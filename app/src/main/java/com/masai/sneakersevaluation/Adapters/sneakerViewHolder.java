package com.masai.sneakersevaluation.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masai.sneakersevaluation.Models.Media;
import com.masai.sneakersevaluation.Models.ResponseModel;
import com.masai.sneakersevaluation.Models.ResponseModelItem;
import com.masai.sneakersevaluation.R;

import org.jetbrains.annotations.NotNull;

public class sneakerViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImageView;
    private TextView mtvName;
    private TextView mTvPrice;

    public sneakerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        mIvImageView = itemView.findViewById(R.id.IvImage);
        mtvName = itemView.findViewById(R.id.tvName);
        mTvPrice = itemView.findViewById(R.id.tvprice);

    }

    public void setData(ResponseModelItem responseModelItem) {
        if (responseModelItem != null) {
            Glide.with(mIvImageView).load(responseModelItem.getMedia().getImageUrl()).into(mIvImageView);
            mtvName.setText(responseModelItem.getName());
            mTvPrice.setText(responseModelItem.getRetailPrice());

        }
    }
}
