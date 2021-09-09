package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class OrientationHelper {
    private int mLastTotalSpace;
    protected final RecyclerView.LayoutManager mLayoutManager;
    final Rect mTmpRect;

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = layoutManager;
    }

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.mLastTotalSpace) {
            return 0;
        }
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i) {
        if (i == 0) {
            return createHorizontalHelper(layoutManager);
        }
        if (i == 1) {
            return createVerticalHelper(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            /* class android.support.v7.widget.OrientationHelper.AnonymousClass1 */

            public final int getEndAfterPadding() {
                return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
            }

            public final int getEnd() {
                return this.mLayoutManager.getWidth();
            }

            public final void offsetChildren(int i) {
                this.mLayoutManager.offsetChildrenHorizontal(i);
            }

            public final int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingLeft();
            }

            public final int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int getDecoratedEnd(View view) {
                return this.mLayoutManager.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public final int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int getTransformedEndWithDecoration(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                return this.mTmpRect.right;
            }

            public final int getTransformedStartWithDecoration(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                return this.mTmpRect.left;
            }

            public final int getTotalSpace() {
                return (this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft()) - this.mLayoutManager.getPaddingRight();
            }

            public final void offsetChild(View view, int i) {
                view.offsetLeftAndRight(i);
            }

            public final int getEndPadding() {
                return this.mLayoutManager.getPaddingRight();
            }

            public final int getMode() {
                return this.mLayoutManager.getWidthMode();
            }

            public final int getModeInOther() {
                return this.mLayoutManager.getHeightMode();
            }
        };
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            /* class android.support.v7.widget.OrientationHelper.AnonymousClass2 */

            public final int getEndAfterPadding() {
                return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
            }

            public final int getEnd() {
                return this.mLayoutManager.getHeight();
            }

            public final void offsetChildren(int i) {
                this.mLayoutManager.offsetChildrenVertical(i);
            }

            public final int getStartAfterPadding() {
                return this.mLayoutManager.getPaddingTop();
            }

            public final int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public final int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public final int getDecoratedEnd(View view) {
                return this.mLayoutManager.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public final int getDecoratedStart(View view) {
                return this.mLayoutManager.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int getTransformedEndWithDecoration(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                return this.mTmpRect.bottom;
            }

            public final int getTransformedStartWithDecoration(View view) {
                this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
                return this.mTmpRect.top;
            }

            public final int getTotalSpace() {
                return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
            }

            public final void offsetChild(View view, int i) {
                view.offsetTopAndBottom(i);
            }

            public final int getEndPadding() {
                return this.mLayoutManager.getPaddingBottom();
            }

            public final int getMode() {
                return this.mLayoutManager.getHeightMode();
            }

            public final int getModeInOther() {
                return this.mLayoutManager.getWidthMode();
            }
        };
    }
}
