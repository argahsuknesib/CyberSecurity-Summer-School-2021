package com.xiaomi.smarthome.device;

import _m_j.bo;
import _m_j.br;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BleGatewayNestedScrollingChild extends LinearLayout implements bo {

    /* renamed from: O000000o  reason: collision with root package name */
    private br f6894O000000o;
    private final int[] O00000Oo = new int[2];
    private final int[] O00000o = new int[2];
    private final int[] O00000o0 = new int[2];
    private int O00000oO;
    private int O00000oo;

    public BleGatewayNestedScrollingChild(Context context) {
        super(context);
        O000000o();
    }

    public BleGatewayNestedScrollingChild(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public BleGatewayNestedScrollingChild(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.f6894O000000o = new br(this);
        setNestedScrollingEnabled(true);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f6894O000000o.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f6894O000000o.f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        return this.f6894O000000o.O000000o(i, 0);
    }

    public void stopNestedScroll() {
        this.f6894O000000o.O00000Oo(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.f6894O000000o.O000000o(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f6894O000000o.O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f6894O000000o.O000000o(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f6894O000000o.O000000o(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f6894O000000o.O000000o(f, f2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int[] iArr = this.O00000Oo;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O00000oO = (int) (motionEvent.getX() + 0.5f);
            this.O00000oo = (int) (motionEvent.getY() + 0.5f);
            startNestedScroll(2);
        } else if (action == 1) {
            stopNestedScroll();
        } else if (action == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int i = this.O00000oO - x;
            int i2 = this.O00000oo - y;
            if (dispatchNestedPreScroll(i, i2, this.O00000o, this.O00000o0)) {
                int[] iArr2 = this.O00000o;
                i -= iArr2[0];
                i2 -= iArr2[1];
                int[] iArr3 = this.O00000Oo;
                int i3 = iArr3[0];
                int[] iArr4 = this.O00000o0;
                iArr3[0] = i3 + iArr4[0];
                iArr3[1] = iArr3[1] + iArr4[1];
            }
            int i4 = i;
            int i5 = i2;
            if (getScrollY() + i5 > 0) {
                dispatchNestedScroll(0, i5, i4, 0, this.O00000Oo);
            } else if (getScrollY() > 0) {
                dispatchNestedScroll(0, getScrollY(), i4, i5 - getScrollY(), this.O00000Oo);
            }
            int[] iArr5 = this.O00000o0;
            this.O00000oO = x - iArr5[0];
            this.O00000oo = y - iArr5[1];
        }
        return true;
    }
}
