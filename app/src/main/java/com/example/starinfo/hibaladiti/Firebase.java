package com.example.starinfo.hibaladiti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Firebase {
    public static FirebaseDatabase database;
    public static DatabaseReference rootRef;
    public static DatabaseReference reclamationRef;
    public static DatabaseReference messageRef;
    public static DatabaseReference citoyenRef;
    public static DatabaseReference quizRef;
    public static DatabaseReference service;


    public static void sendMessage(Context context, String email, String name,String title, String text){
        try{
            String key = messageRef.push().getKey();
            Map messageShema = new HashMap();
            messageShema.put("created_at",new Date().getTime());
            messageShema.put("message",text);
            messageShema.put("name",name);
            messageShema.put("reponce",null);
            messageShema.put("sender",email);
            messageShema.put("title",title);
            messageShema.put("vue",false);
            messageRef.child(key).setValue(messageShema);
            Toast.makeText(context, "تم إرسال الرسالة", Toast.LENGTH_SHORT).show();
        }catch(Exception ex){
            Toast.makeText(context, "تعذر إرسال الرسالة", Toast.LENGTH_SHORT).show();
        }
    }

    public static void signup(String email, String name, String cin, String password){
        String key = citoyenRef.push().getKey();
        Map citoyenShema = new HashMap();
        citoyenShema.put("email", email);
        citoyenShema.put("created_at", new Date().getTime());
        citoyenShema.put("name", name);
        citoyenShema.put("password", password);
        citoyenShema.put("cin", cin);
        citoyenRef.child(key).setValue(citoyenShema);
    }
    public static void sendNote(String email, int note1, int note2, int note3, int note4, int note5, int note6, int note7){
        String key = citoyenRef.push().getKey();
        Map quizShema = new HashMap();
        quizShema.put("email", email);
        quizShema.put("question1", note1);
        quizShema.put("question2", note2);
        quizShema.put("question3", note3);
        quizShema.put("question4", note4);
        quizShema.put("question5", note5);
        quizShema.put("question6", note6);
        quizShema.put("question7", note7);
        quizRef.child(key).setValue(quizShema);
    }
    public static void sendReport(Context context, ImageView imageView, String subject, String message, String cin, String code){
        String encoded_string = "";
        try{
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            //bitmap = BitmapFactory.decodeFile(imageUri.getPath());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            bitmap.recycle();

            byte[] array = stream.toByteArray();
            encoded_string = Base64.encodeToString(array, 0);
        }catch(RuntimeException runTimeEx){
            Toast.makeText(context, "FFS just wait plz ...", Toast.LENGTH_SHORT).show();
        }catch(Exception ex){
            Toast.makeText(context, "Sorry somthing happend  :/  .", Toast.LENGTH_SHORT).show();
        }finally{
            String key = Firebase.reclamationRef.push().getKey();
            Map reclamationShema = new HashMap();
            reclamationShema.put("cin",cin);
            reclamationShema.put("code",code);
            reclamationShema.put("etat","1");
            reclamationShema.put("image",encoded_string);
            reclamationShema.put("text",message);
            reclamationShema.put("title",subject);
            Firebase.reclamationRef.child(key).setValue(reclamationShema);
            Toast.makeText(context, "Terminer :)", Toast.LENGTH_SHORT).show();
        }
    }
    static{
        database = FirebaseDatabase.getInstance();
        rootRef = database.getReference();
        reclamationRef = rootRef.child("reclamations");
        messageRef = rootRef.child("messages");
        citoyenRef = rootRef.child("citoyens");
        quizRef = rootRef.child("quiz");
    }
}
