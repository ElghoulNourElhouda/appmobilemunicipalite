package com.example.starinfo.hibaladiti;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgetAndChangePasswordActivity extends AppCompatActivity {

    private EditText edtMode;
    private TextView txtMode;
    private Button submit;
    private FirebaseAuth auth;
    private ProgressDialog PD;
    private TextInputLayout labelMode;



    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_and_change_password);

        PD = new ProgressDialog(this);
        PD.setMessage("تحميل ...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        auth = FirebaseAuth.getInstance();

        edtMode = (EditText) findViewById(R.id.mode);
        txtMode = (TextView) findViewById(R.id.title);
        submit = (Button) findViewById(R.id.submit_button);
        labelMode = (TextInputLayout) findViewById(R.id.label);
        Animation animation,animation1;

        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        txtMode.startAnimation(animation);
        txtMode.startAnimation(animation1);


        final int mode = getIntent().getIntExtra("Mode", 0);
        if (mode == 0) {
            txtMode.setText("نسيت كلمة المرور");
            edtMode.setHint("أدخل بريدك الإلكتروني المسجل");
            labelMode.setHint("أدخل بريدك الإلكتروني المسجل");
        } else if (mode == 1) {
            txtMode.setText("تغيير كلمة المرور");
            edtMode.setHint("أدخل كلمة مرور جديدة");
            labelMode.setHint("أدخل كلمة مرور جديدة");
        } else if (mode == 2) {
            txtMode.setText("تغيير البريد الإلكتروني");
            edtMode.setHint("أدخل البريد الإلكتروني الجديد");
            labelMode.setHint("أدخل البريد الإلكتروني الجديد");
        } else {
            txtMode.setText("حذف المستخدم");
            edtMode.setVisibility(View.GONE);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {
                callFunction(mode);
            }
        });

    }

    private void callFunction(int mode) {

        FirebaseUser user = auth.getCurrentUser();
        final String modeStr = edtMode.getText().toString();
        if (mode == 0) {
            if (TextUtils.isEmpty(modeStr)) {
                edtMode.setError("إملأ الخانة");
            } else {
                PD.show();
                auth.sendPasswordResetEmail(modeStr).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgetAndChangePasswordActivity.this, "لدينا التعليمات الخاصة بك لإعادة تعيين كلمة المرور الخاصة بك!", Toast.LENGTH_SHORT).show();
                            Toast.makeText(ForgetAndChangePasswordActivity.this, "فشل في إرسال إعادة تعيين البريد الإلكتروني!", Toast.LENGTH_SHORT).show();
                        }
                        PD.dismiss();

                    }
                });
            }
        } else if (mode == 1) {
            if (TextUtils.isEmpty(modeStr)) {
                edtMode.setError("إملأ الخانة");
            } else {
                PD.show();
                user.updatePassword(modeStr)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "تم تحديث كلمة المرور", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "فشل في تحديث كلمة المرور!", Toast.LENGTH_SHORT).show();
                                }
                                PD.dismiss();
                            }

                        });
            }
        } else if (mode == 2) {
            if (TextUtils.isEmpty(modeStr)) {
                edtMode.setError("إملأ الخانة");
            } else {
                PD.show();
                user.updateEmail(modeStr)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "تم تحديث عنوان البريد الإلكتروني.", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "فشل في تحديث البريد الإلكتروني!", Toast.LENGTH_LONG).show();
                                }
                                PD.dismiss();
                            }
                        });
            }
        } else {
            if (user != null) {
                PD.show();
                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "يتم حذف ملف التعريف الخاص بك :( إنشاء حساب الآن! ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgetAndChangePasswordActivity.this, "فشل في حذف حسابك!", Toast.LENGTH_SHORT).show();
                                }
                                PD.dismiss();
                            }
                        });
            }
        }

    }

}
