package com.xiaomi.smarthome.device;

import _m_j.gsy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class ChooseDeviceNestedParent extends ScrollView {
    static boolean O00000o = false;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6923O000000o;
    public boolean O00000Oo = false;
    boolean O00000o0 = false;
    private View O00000oO;
    private int O00000oo;
    private long O0000O0o = 0;
    private int O0000OOo = 120;
    private O000000o O0000Oo;
    private SCROLL_ACTION O0000Oo0 = SCROLL_ACTION.NONE;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public enum SCROLL_ACTION {
        UP,
        DOWN,
        NONE
    }

    public int getNestedScrollAxes() {
        return 0;
    }

    public ChooseDeviceNestedParent(Context context) {
        super(context);
    }

    public ChooseDeviceNestedParent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChooseDeviceNestedParent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setNestView(View view) {
        this.O00000oO = view;
        this.O00000oO.post(new Runnable() {
            /* class com.xiaomi.smarthome.device.$$Lambda$ChooseDeviceNestedParent$fZAwAHKx1Iynx2bm4l9gapRMlc */

            public final void run() {
                ChooseDeviceNestedParent.this.O000000o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        this.f6923O000000o = this.O00000oO.getHeight();
    }

    public void setYScrollDelta(int i) {
        this.O0000OOo = i;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 3) {
            this.O00000o0 = false;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        gsy.O00000Oo("ChooseDeviceNestedParen", String.format("onScrollChanged: %d, %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        this.O00000oo = i2;
        this.O0000Oo0 = i2 == i4 ? SCROLL_ACTION.NONE : i2 > i4 ? SCROLL_ACTION.UP : SCROLL_ACTION.DOWN;
        if (System.currentTimeMillis() - this.O0000O0o < 200) {
            return;
        }
        if (i2 > this.f6923O000000o - this.O0000OOo && this.O0000Oo0 == SCROLL_ACTION.UP && !this.O00000Oo) {
            this.O0000Oo.O000000o();
            this.O00000Oo = true;
            this.O0000O0o = System.currentTimeMillis();
        } else if (i2 < this.f6923O000000o - (this.O0000OOo + 30) && this.O0000Oo0 == SCROLL_ACTION.DOWN && this.O00000Oo) {
            this.O0000Oo.O00000Oo();
            this.O00000Oo = false;
            this.O0000O0o = System.currentTimeMillis();
        }
    }

    public void setOnScanViewChangeListener(O000000o o000000o) {
        this.O0000Oo = o000000o;
    }
}
