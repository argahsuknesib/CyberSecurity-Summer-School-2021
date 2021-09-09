package com.xiaomi.mico.common.recyclerview.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ListDividerItemDecoration extends RecyclerView.O0000Oo {
    private int mDividerSize;
    private Ignore mIgnore;
    private int mLeftOrTopPadding;
    private int mOrientation;
    private Paint mPaint;
    private int mRightOrBottomPadding;

    public ListDividerItemDecoration(int i, int i2, int i3, int i4, int i5, Ignore ignore) {
        if (i == 0 || i == 1) {
            this.mOrientation = i;
            this.mDividerSize = i3;
            this.mLeftOrTopPadding = i4;
            this.mRightOrBottomPadding = i5;
            this.mIgnore = ignore;
            this.mPaint = new Paint(1);
            this.mPaint.setColor(i2);
            this.mPaint.setStyle(Paint.Style.FILL);
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
            rect.set(0, 0, 0, this.mDividerSize);
        } else {
            rect.set(0, 0, this.mDividerSize, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (this.mOrientation == 0) {
            drawHorizontal(canvas, recyclerView);
        } else {
            drawVertical(canvas, recyclerView);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.mLeftOrTopPadding;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.mRightOrBottomPadding;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            Ignore ignore = this.mIgnore;
            if (ignore == null || !ignore.needIgnore(childAdapterPosition, recyclerView.getChildViewHolder(childAt).getItemViewType())) {
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                int i2 = this.mDividerSize + bottom;
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect((float) paddingLeft, (float) bottom, (float) width, (float) i2, paint);
                }
            }
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop() + this.mLeftOrTopPadding;
        int height = (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.mRightOrBottomPadding;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            Ignore ignore = this.mIgnore;
            if (ignore == null || !ignore.needIgnore(childAdapterPosition, recyclerView.getChildViewHolder(childAt).getItemViewType())) {
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                int i2 = this.mDividerSize + right;
                Paint paint = this.mPaint;
                if (paint != null) {
                    canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) height, paint);
                }
            }
        }
    }
}
