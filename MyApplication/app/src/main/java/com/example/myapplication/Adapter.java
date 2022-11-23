package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    ArrayList<RandomItem> itemList;

    public Adapter(ArrayList<RandomItem> randomItems) {
        this.itemList = randomItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private TextView textIndex;

        public ViewHolder(final View view){
            super(view);
            text = view.findViewById(R.id.contentTextView);
            textIndex = view.findViewById(R.id.contentIndex);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        String index = itemList.get(position).getIndex() + "";
        holder.text.setText(name);
        holder.textIndex.setText(index);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



}
