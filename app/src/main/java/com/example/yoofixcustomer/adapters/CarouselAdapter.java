package com.example.yoofixcustomer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yoofixcustomer.R;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouseViewHolder> {
    private String[] imageSources;
    private int screenWidth;

    public CarouselAdapter(String[] imageSources, Context context) {
        this.imageSources = imageSources;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    @NonNull
    @Override
    public CarouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_carousel, parent, false);

        return new CarouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouseViewHolder holder, int position) {
        holder.carouselImage.setImageResource(R.drawable.banner_1);

        int itemWidth = (int) (screenWidth * 0.8f);

        ViewGroup.LayoutParams lp = holder.carouselImage.getLayoutParams();

        float ratio =(float)lp.width / (float)lp.height;
        lp.width = itemWidth;
        System.out.println("ratio " + ratio);
        ((RelativeLayout) holder.carouselImage.getParent()).getLayoutParams().height = (int) (itemWidth * ratio);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class CarouseViewHolder extends RecyclerView.ViewHolder {
        private ImageView carouselImage;

        public CarouseViewHolder(@NonNull View itemView) {
            super(itemView);
            carouselImage = itemView.findViewById(R.id.carousel_image);
        }
    }
}
