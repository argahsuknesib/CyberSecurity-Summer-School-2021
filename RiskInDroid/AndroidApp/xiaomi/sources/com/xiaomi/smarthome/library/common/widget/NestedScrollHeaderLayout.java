package com.xiaomi.smarthome.library.common.widget;

import _m_j.bv;
import _m_j.cb;
import _m_j.cx;
import _m_j.gsy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class NestedScrollHeaderLayout extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private bv f9227O000000o;
    private int O00000Oo;
    private boolean O00000o;
    private cx O00000o0;

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public NestedScrollHeaderLayout(Context context) {
        this(context, null);
    }

    public NestedScrollHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = false;
        this.f9227O000000o = new bv();
        this.O00000o0 = cx.O000000o(getContext(), null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.O00000Oo = getChildAt(0).getMeasuredHeight();
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f9227O000000o.O000000o(i, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3;
        int scrollY = getScrollY();
        if (i2 > 0 && scrollY < (i3 = this.O00000Oo) && scrollY >= 0) {
            int min = Math.min(i2, i3 - scrollY);
            iArr[1] = min;
            scrollBy(0, min);
            if (!this.O00000o) {
                this.O00000o = true;
                setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight() + this.O00000Oo));
            }
        } else if (i2 < 0 && scrollY == this.O00000Oo) {
            iArr[1] = i2;
            scrollBy(0, i2);
        } else if (i2 < 0 && scrollY < this.O00000Oo && scrollY > 0) {
            int max = Math.max(i2, -scrollY);
            iArr[1] = max;
            scrollBy(0, max);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        gsy.O00000Oo("hzd", "onNestedScroll dxConsumed = " + i + " , dyConsumed = " + i2 + " , dxUnconsumed = " + i3 + " , dyUnconsumed = " + i4);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int scrollY = getScrollY();
        if (f2 <= 0.0f || scrollY >= this.O00000Oo || scrollY <= 0) {
            return false;
        }
        if (!this.O00000o0.f14386O000000o.isFinished()) {
            this.O00000o0.f14386O000000o.abortAnimation();
        }
        cx cxVar = this.O00000o0;
        int i = this.O00000Oo;
        cxVar.f14386O000000o.fling(0, scrollY, (int) f, (int) f2, 0, 0, 0, i);
        cb.O00000oo(this);
        return true;
    }

    public void onStopNestedScroll(View view) {
        this.f9227O000000o.O000000o(0);
    }

    public int getNestedScrollAxes() {
        return this.f9227O000000o.O000000o();
    }

    public void computeScroll() {
        if (this.O00000o0.f14386O000000o.computeScrollOffset()) {
            scrollTo(this.O00000o0.f14386O000000o.getCurrX(), this.O00000o0.f14386O000000o.getCurrY());
            postInvalidate();
        }
    }
}
