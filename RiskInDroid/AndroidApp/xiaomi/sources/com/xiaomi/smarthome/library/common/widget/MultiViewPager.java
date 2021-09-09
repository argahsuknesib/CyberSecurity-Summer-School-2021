package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;

public class MultiViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9226O000000o;
    private int O00000Oo;
    private boolean O00000o;
    private int O00000o0;
    private final Point O00000oO;
    private final Point O00000oo;
    private ViewPager.O0000OOo O0000O0o;
    private boolean O0000OOo;

    public MultiViewPager(Context context) {
        super(context);
        this.f9226O000000o = -1;
        this.O00000Oo = -1;
        this.O0000OOo = true;
        this.O00000oO = new Point();
        this.O00000oo = new Point();
    }

    public MultiViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9226O000000o = -1;
        this.O00000Oo = -1;
        this.O0000OOo = true;
        setClipChildren(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843039, 16843040, R.attr.matchChildWidth});
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(0, -1));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(1, -1));
        setMatchChildWidth(obtainStyledAttributes.getResourceId(2, 0));
        obtainStyledAttributes.recycle();
        this.O00000oO = new Point();
        this.O00000oo = new Point();
    }

    public void onMeasure(int i, int i2) {
        ViewPager.O0000OOo o0000OOo;
        this.O00000oO.set(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.f9226O000000o >= 0 || this.O00000Oo >= 0) {
            this.O00000oo.set(this.f9226O000000o, this.O00000Oo);
            Point point = this.O00000oO;
            Point point2 = this.O00000oo;
            if (point2.x >= 0 && point.x > point2.x) {
                point.x = point2.x;
            }
            if (point2.y >= 0 && point.y > point2.y) {
                point.y = point2.y;
            }
            i = View.MeasureSpec.makeMeasureSpec(this.O00000oO.x, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(this.O00000oO.y, 1073741824);
        }
        super.onMeasure(i, i2);
        if (!this.O00000o) {
            return;
        }
        if (this.O00000o0 == 0) {
            this.O00000o = false;
        } else if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i, i2);
            int measuredWidth = childAt.getMeasuredWidth();
            View findViewById = childAt.findViewById(this.O00000o0);
            if (findViewById != null) {
                int measuredWidth2 = findViewById.getMeasuredWidth();
                if (measuredWidth2 > 0) {
                    this.O00000o = false;
                    setPageMargin(-((int) (((float) (measuredWidth - measuredWidth2)) + (getResources().getDisplayMetrics().density * 18.0f))));
                    setOffscreenPageLimit(((int) Math.ceil((double) (((float) measuredWidth) / ((float) measuredWidth2)))) + 1);
                }
                if (this.O0000OOo && getChildCount() > 1 && (o0000OOo = this.O0000O0o) != null) {
                    this.O0000OOo = false;
                    if (o0000OOo != null) {
                        int scrollX = getScrollX() + childAt.getMeasuredWidth();
                        int childCount = getChildCount();
                        for (int i3 = 1; i3 < childCount; i3++) {
                            View childAt2 = getChildAt(i3);
                            if (!((ViewPager.LayoutParams) childAt2.getLayoutParams()).f3034O000000o) {
                                this.O0000O0o.transformPage(childAt2, ((float) (((childAt2.getLeft() - scrollX) - measuredWidth) + measuredWidth2)) / ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())));
                                scrollX += childAt2.getMeasuredWidth();
                            }
                        }
                    }
                }
                requestLayout();
                return;
            }
            throw new NullPointerException("MatchWithChildResId did not find that ID in the first fragment of the ViewPager; is that view defined in the child view's layout? Note that MultiViewPager only measures the child for index 0.");
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O00000o = true;
    }

    public void setMatchChildWidth(int i) {
        if (this.O00000o0 != i) {
            this.O00000o0 = i;
            this.O00000o = true;
        }
    }

    public void setMaxWidth(int i) {
        this.f9226O000000o = i;
    }

    public void setMaxHeight(int i) {
        this.O00000Oo = i;
    }

    public void setPageTransformer(boolean z, ViewPager.O0000OOo o0000OOo) {
        super.setPageTransformer(z, o0000OOo);
        this.O0000O0o = o0000OOo;
    }
}
