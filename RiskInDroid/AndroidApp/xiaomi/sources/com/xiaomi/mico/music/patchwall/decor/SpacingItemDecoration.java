package com.xiaomi.mico.music.patchwall.decor;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpacingItemDecoration extends RecyclerView.O0000Oo {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;
    private int topSpace;

    public SpacingItemDecoration(int i, int i2, boolean z, int i3) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
        this.topSpace = i3;
    }

    public void setSpanCount(int i) {
        this.spanCount = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.spanCount;
        int i2 = childAdapterPosition % i;
        if (this.includeEdge) {
            int i3 = this.spacing;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = this.topSpace;
            }
            rect.bottom = this.spacing;
            return;
        }
        int i4 = this.spacing;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (childAdapterPosition < i) {
            rect.top = this.topSpace;
        }
        rect.bottom = this.spacing;
    }
}
