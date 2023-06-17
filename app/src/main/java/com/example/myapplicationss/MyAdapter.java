package com.example.myapplicationss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //declaration
    private Context context;
    private ArrayList name_id, price_id;

    //in the arraylist will have name and price
    public MyAdapter(Context context, ArrayList name_id, ArrayList price_id) {
        this.context = context;
        this.name_id = name_id;
        this.price_id = price_id;

    }

    @NonNull
    @Override
    //create view holder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    //create view holder for name_id and price_id
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.price_id.setText(String.valueOf(price_id.get(position)));


    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //to view holder in text view
        TextView name_id, price_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id= itemView.findViewById(R.id.textname);
            price_id= itemView.findViewById(R.id.textprice);



        }
    }
}
