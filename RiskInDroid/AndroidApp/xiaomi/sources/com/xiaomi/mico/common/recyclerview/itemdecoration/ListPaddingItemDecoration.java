package com.xiaomi.mico.common.recyclerview.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ListPaddingItemDecoration extends RecyclerView.O0000Oo {
    private Ignore mIgnore;
    private int mLeftOrTopPadding;
    private int mOrientation;
    private int mRightOrBottomPadding;

    public ListPaddingItemDecoration(int i, int i2, int i3, Ignore ignore) {
        if (i == 0 || i == 1) {
            this.mOrientation = i;
            this.mLeftOrTopPadding = i2;
            this.mRightOrBottomPadding = i3;
            this.mIgnore = ignore;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        Ignore ignore = this.mIgnore;
        if (ignore != null && ignore.needIgnore(childAdapterPosition, recyclerView.getChildViewHolder(view).getItemViewType())) {
            super.getItemOffsets(rect, view, recyclerView, o000OO0o);
        } else if (this.mOrientation == 0) {
            rect.set(0, this.mLeftOrTopPadding, 0, this.mRightOrBottomPadding);
        } else {
            rect.set(this.mLeftOrTopPadding, 0, this.mRightOrBottomPadding, 0);
        }
    }
}
