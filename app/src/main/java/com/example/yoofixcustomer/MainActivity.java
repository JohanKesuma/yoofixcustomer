package com.example.yoofixcustomer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.yoofixcustomer.adapters.CarouselAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView carouselRecyclerView;
    private CarouselAdapter carouselAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_beranda);

        carouselRecyclerView = findViewById(R.id.carousel_recycler_view);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        carouselRecyclerView.setLayoutManager(layoutManager);

        String[] data = {"1", "2"};
        carouselAdapter = new CarouselAdapter(data, this);
        carouselRecyclerView.setAdapter(carouselAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                View centerView = findSnapView(layoutManager);
                if (centerView == null)
                    return RecyclerView.NO_POSITION;

                int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                if (layoutManager.canScrollVertically()) {
                    if (velocityY < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                return targetPosition;
            }
        };
        snapHelper.attachToRecyclerView(carouselRecyclerView);

        int carouselWidthPixel = (int) (this.getResources().getDisplayMetrics().widthPixels * 0.9f);
        float carouselHintPercent = 0.01f;
        carouselRecyclerView.addItemDecoration(new CarouselItemDecorator(this, carouselWidthPixel, carouselHintPercent));
    }
}
