package com.example.starinfo.hibaladiti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class CustomeAdapter2 extends RecyclerView.Adapter<CustomeAdapter2.MyViewHolder>{

    private List<Mydata2> moviesList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textViewName);
            image =  view.findViewById(R.id.imageView);

        }
    }


    public CustomeAdapter2(List<Mydata2> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mydata2 data = moviesList.get(position);
        holder.name.setText(data.getName());
        String url = data.getImage();
        if(url.length()>4)
        Picasso.with(context).load(url).into(holder.image);
       /* holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());*/
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
