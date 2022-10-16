package com.example.tatesmotivationapp;

import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>{

    private final ArrayList<Hero> heroesList;
    boolean visible;

    public MyRvAdapter(ArrayList<Hero> heroesList) {
        this.heroesList=heroesList;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.imageView.setImageResource(this.heroesList.get(position).getPicture());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int id = holder.getAdapterPosition();
//                String name = heroesList.get(id).getName();
                TransitionManager.beginDelayedTransition(holder.buttonContainer);
                visible = !visible;
                holder.cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        visible = !visible;
                        holder.buttonContainer.setVisibility(visible? View.VISIBLE: View.GONE);

                    }
                });
                holder.chooseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), HeroInfo.class);
                        intent.putExtra("index",holder.getAdapterPosition());
                        v.getContext().startActivity(intent);
                    }
                });




                holder.buttonContainer.setVisibility(visible? View.VISIBLE: View.GONE);

            }
        });


    }

    @Override
    public int getItemCount() {
        return this.heroesList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout buttonContainer;
        Button cancelBtn;
        Button chooseBtn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pictureImageView);
            buttonContainer = itemView.findViewById(R.id.buttonLayout);
            cancelBtn = itemView.findViewById(R.id.cancelBtn);
            chooseBtn = itemView.findViewById(R.id.chooseBtn);
        }
    }
}