package com.example.dogscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class animalAdapter extends RecyclerView.Adapter<animalAdapter.ViewHolder> {

    private ArrayList<Dog> dogArrayList;
    private Context c;
    private View.OnClickListener doglistner;


    public animalAdapter(ArrayList<Dog> pokearray, Context c) {
        this.dogArrayList = pokearray;
        this.c = c;
    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner)
    {
        doglistner = itemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(dogArrayList.get(position).getMessage()).into((Target) holder.message);
        holder.message.setText(dogArrayList.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return dogArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            message = itemView.findViewById(R.id.tvMessage);


            itemView.setTag(this);
            itemView.setOnClickListener(doglistner);



        }
    }

}
