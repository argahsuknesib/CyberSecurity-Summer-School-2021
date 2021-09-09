package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class BlockLayoutManager extends RecyclerView.LayoutManager {
    private int[] mCellBorders;
    private int mCellHeight;
    private float mCellRatio;
    private int mColumns;
    private int mExpandHeight;
    private final Rect mItemDecorationInsets = new Rect();
    private boolean mLayoutDirty = true;
    private int mRows;

    public BlockLayoutManager() {
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }

    public void setLayoutFrame(int i, int i2, float f, int i3) {
        this.mColumns = i;
        this.mRows = i2;
        this.mCellRatio = f;
        this.mExpandHeight = i3;
        reset();
    }

    public boolean isFirstLane(int i) {
        return ((LayoutParams) findViewByPosition(i).getLayoutParams()).x == 0;
    }

    public boolean isSecondLane(int i) {
        int laneForPosition = getLaneForPosition(i);
        if (!(laneForPosition == 0 || i == 0)) {
            int i2 = i - 1;
            int i3 = -1;
            while (i2 >= 0) {
                i3 = getLaneForPosition(i2);
                if (i3 != laneForPosition) {
                    break;
                }
                i2--;
            }
            return i3 == 0 && laneForPosition == i3 + getLaneSpanForPosition(i2);
        }
    }

    public boolean isBeforeLastLane(int i) {
        LayoutParams layoutParams = (LayoutParams) findViewByPosition(i).getLayoutParams();
        return layoutParams.x + layoutParams.w == this.mColumns - 1;
    }

    public boolean isLastLane(int i) {
        LayoutParams layoutParams = (LayoutParams) findViewByPosition(i).getLayoutParams();
        return layoutParams.x + layoutParams.w == this.mColumns;
    }

    public boolean isFirstChildInLane(int i) {
        if (i >= this.mColumns) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += getLaneSpanForPosition(i3);
            if (i2 >= this.mColumns) {
                return false;
            }
        }
        return true;
    }

    public boolean isLastChildInLane(int i) {
        LayoutParams layoutParams = (LayoutParams) findViewByPosition(i).getLayoutParams();
        return layoutParams.y + layoutParams.h >= this.mRows;
    }

    private int getLaneForPosition(int i) {
        return ((LayoutParams) findViewByPosition(i).getLayoutParams()).x;
    }

    private int getLaneSpanForPosition(int i) {
        return ((LayoutParams) findViewByPosition(i).getLayoutParams()).w;
    }

    public void onAdapterChanged(RecyclerView.O000000o o000000o, RecyclerView.O000000o o000000o2) {
        reset();
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.mLayoutDirty) {
            this.mLayoutDirty = false;
            detachAndScrapAttachedViews(o000o0oo);
            int O000000o2 = o000OO0o.O000000o();
            if (O000000o2 != 0) {
                calculateCellSize();
                calculateCellBorders();
                int paddingTop = getPaddingTop();
                for (int i = 0; i < O000000o2; i++) {
                    View O00000Oo = o000o0oo.O00000Oo(i);
                    LayoutParams layoutParams = (LayoutParams) O00000Oo.getLayoutParams();
                    if (layoutParams.x + layoutParams.w <= this.mColumns) {
                        addView(O00000Oo);
                        measureChildWithDecorationsAndMargin(O00000Oo, getChildMeasureSpec(this.mCellBorders[layoutParams.x + layoutParams.w] - this.mCellBorders[layoutParams.x], 1073741824, 0, layoutParams.width, false), getChildMeasureSpec((layoutParams.h * this.mCellHeight) + this.mExpandHeight, 1073741824, 0, layoutParams.height, false));
                        int i2 = this.mCellBorders[layoutParams.x] + layoutParams.leftMargin;
                        int expandY = (layoutParams.y * this.mCellHeight) + getExpandY(i) + paddingTop + layoutParams.topMargin;
                        layoutDecorated(O00000Oo, i2, expandY, i2 + getDecoratedMeasuredWidth(O00000Oo), expandY + getDecoratedMeasuredHeight(O00000Oo));
                    }
                }
            }
        }
    }

    public View findViewByPosition(int i) {
        if (i < 0 || i >= getChildCount()) {
            return null;
        }
        return getChildAt(i);
    }

    private void reset() {
        this.mLayoutDirty = true;
        this.mCellHeight = 0;
        this.mCellBorders = null;
    }

    private void calculateCellSize() {
        this.mCellHeight = (int) Math.floor((double) (((float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.mColumns)) * (1.0f / this.mCellRatio)));
    }

    private void calculateCellBorders() {
        int i;
        int i2 = 1;
        this.mCellBorders = new int[(this.mColumns + 1)];
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i3 = 0;
        this.mCellBorders[0] = paddingLeft;
        int i4 = this.mColumns;
        int i5 = width / i4;
        int i6 = width % i4;
        while (true) {
            int i7 = this.mColumns;
            if (i2 <= i7) {
                i3 += i6;
                if (i3 <= 0 || i7 - i3 >= i6) {
                    i = i5;
                } else {
                    i = i5 + 1;
                    i3 -= i7;
                }
                paddingLeft += i;
                this.mCellBorders[i2] = paddingLeft;
                i2++;
            } else {
                return;
            }
        }
    }

    private int getExpandY(int i) {
        if (i == 0 || this.mExpandHeight <= 0) {
            return 0;
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(i);
        LayoutParams layoutParams = (LayoutParams) findViewByPosition(i).getLayoutParams();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            LayoutParams layoutParams2 = (LayoutParams) findViewByPosition(i3).getLayoutParams();
            if (!sparseBooleanArray.get(layoutParams2.y) && layoutParams2.y < layoutParams.y && ((layoutParams2.x >= layoutParams.x && layoutParams2.x < layoutParams.x + layoutParams.w) || (layoutParams.x >= layoutParams2.x && layoutParams.x < layoutParams2.x + layoutParams2.w))) {
                sparseBooleanArray.put(layoutParams2.y, true);
                i2++;
            }
        }
        return i2 * this.mExpandHeight;
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mItemDecorationInsets);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(updateSpecWithExtra(i, layoutParams.leftMargin + this.mItemDecorationInsets.left, layoutParams.rightMargin + this.mItemDecorationInsets.right), updateSpecWithExtra(i2, layoutParams.topMargin + this.mItemDecorationInsets.top, layoutParams.bottomMargin + this.mItemDecorationInsets.bottom));
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public int h;
        public int w;
        public int x;
        public int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
        }
    }
}
