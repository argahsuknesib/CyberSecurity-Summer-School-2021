package com.xiaomi.mico.common.recyclerview.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.O0000Oo {
    int mSpace;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (recyclerView.getChildAdapterPosition(view) % 2 == 0) {
            rect.right = this.mSpace / 3;
        } else {
            rect.right = 0;
        }
        rect.left = 0;
        rect.top = 0;
        rect.bottom = this.mSpace;
    }

    public SpaceItemDecoration(int i) {
        this.mSpace = i;
    }
}
