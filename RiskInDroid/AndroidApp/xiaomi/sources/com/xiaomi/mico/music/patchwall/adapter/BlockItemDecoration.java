package com.xiaomi.mico.music.patchwall.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class BlockItemDecoration extends RecyclerView.O0000Oo {
    private int mHorizontalSpacing;
    private int mVerticalSpacing;

    public BlockItemDecoration(int i, int i2) {
        this.mHorizontalSpacing = i;
        this.mVerticalSpacing = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        double d;
        double d2;
        Rect rect2 = rect;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof BlockLayoutManager) {
            int position = layoutManager.getPosition(view);
            BlockLayoutManager blockLayoutManager = (BlockLayoutManager) layoutManager;
            boolean isFirstLane = blockLayoutManager.isFirstLane(position);
            boolean isSecondLane = blockLayoutManager.isSecondLane(position);
            boolean isBeforeLastLane = blockLayoutManager.isBeforeLastLane(position);
            boolean isLastLane = blockLayoutManager.isLastLane(position);
            boolean isFirstChildInLane = blockLayoutManager.isFirstChildInLane(position);
            boolean isLastChildInLane = blockLayoutManager.isLastChildInLane(position);
            if (isFirstLane) {
                z = isFirstLane;
                i = 0;
            } else {
                if (!isLastLane || isSecondLane) {
                    z = isFirstLane;
                    if (!isSecondLane || isLastLane) {
                        double d3 = (double) this.mHorizontalSpacing;
                        Double.isNaN(d3);
                        d2 = d3 * 0.5d;
                    } else {
                        double d4 = (double) this.mHorizontalSpacing;
                        Double.isNaN(d4);
                        d2 = d4 * 0.25d;
                    }
                } else {
                    z = isFirstLane;
                    double d5 = (double) this.mHorizontalSpacing;
                    Double.isNaN(d5);
                    d2 = d5 * 0.75d;
                }
                i = (int) d2;
            }
            if (isLastLane) {
                i2 = 0;
            } else {
                if (z && !isBeforeLastLane) {
                    double d6 = (double) this.mHorizontalSpacing;
                    Double.isNaN(d6);
                    d = d6 * 0.75d;
                } else if (!isBeforeLastLane || z) {
                    double d7 = (double) this.mHorizontalSpacing;
                    Double.isNaN(d7);
                    d = d7 * 0.5d;
                } else {
                    double d8 = (double) this.mHorizontalSpacing;
                    Double.isNaN(d8);
                    d = d8 * 0.25d;
                }
                i2 = (int) d;
            }
            rect2.left = i;
            if (isFirstChildInLane) {
                i3 = 0;
            } else {
                i3 = this.mVerticalSpacing / 2;
            }
            rect2.top = i3;
            rect2.right = i2;
            if (isLastChildInLane) {
                i4 = 0;
            } else {
                i4 = this.mVerticalSpacing / 2;
            }
            rect2.bottom = i4;
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, o000OO0o);
    }
}
