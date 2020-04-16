package com.example.yoofixcustomer;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecorator extends RecyclerView.ItemDecoration {

    private int interItemGap;
    private int netOneSideGap;

    public CarouselItemDecorator(Context context, int itemWidth, float itemPeekingPercent) {
        this(context.getResources().getDisplayMetrics().widthPixels, itemWidth, itemPeekingPercent);
    }

    public CarouselItemDecorator(int totalWidth, int itemWidth, float itemPeekingPercent) {
        int cardPeekingWidth = (int) (itemWidth * itemPeekingPercent + .5f);

        interItemGap = (totalWidth - itemWidth) / 2;
        netOneSideGap = interItemGap / 2 - cardPeekingWidth;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int index = parent.getChildAdapterPosition(view);
        boolean isFirstItem = isFirstItem(index);
        boolean isLastItem = isLastItem(index, parent);

        int leftInset = isFirstItem ? interItemGap : netOneSideGap;
        int rightInset = isLastItem ? interItemGap : netOneSideGap;

        outRect.set(leftInset, 0, rightInset, 0);
    }

    private boolean isFirstItem(int index) {
        if (index == 0) {
            return true;
        }

        return false;
    }

    private boolean isLastItem(int index, RecyclerView recyclerView) {
        if (index == recyclerView.getAdapter().getItemCount() - 1) {
            return true;
        }

        return false;
    }

}
