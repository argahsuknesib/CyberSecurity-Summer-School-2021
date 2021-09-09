package com.xiaomi.smarthome.uwb.tv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalItemDecoration extends RecyclerView.O0000Oo {
    private int mSpace;

    public HorizontalItemDecoration(int i, Context context) {
        this.mSpace = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (childAdapterPosition == 0) {
            rect.left = 0;
            rect.right = this.mSpace / 2;
        } else if (childAdapterPosition == itemCount - 1) {
            rect.left = this.mSpace / 2;
            rect.right = 0;
        } else {
            int i = this.mSpace;
            rect.left = i / 2;
            rect.right = i / 2;
        }
    }
}
