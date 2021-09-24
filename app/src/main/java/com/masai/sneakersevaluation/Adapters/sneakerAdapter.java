package com.masai.sneakersevaluation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.sneakersevaluation.Models.ResponseModel;
import com.masai.sneakersevaluation.Models.ResponseModelItem;
import com.masai.sneakersevaluation.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class sneakerAdapter extends RecyclerView.Adapter<sneakerViewHolder> {
    private ArrayList<ResponseModelItem> list;

    public sneakerAdapter(ArrayList<ResponseModelItem> list) {
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public sneakerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sneaker_item_layout,parent,false);
        return new sneakerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull sneakerViewHolder holder, int position) {
        ResponseModelItem responseModelItem =list.get(position);
        holder.setData(responseModelItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
