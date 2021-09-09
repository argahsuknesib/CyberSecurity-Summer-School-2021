package com.xiaomi.smarthome.scene.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class HomeSceneScrollView extends ScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11313O000000o;
    private int O00000Oo;
    private O000000o O00000o;
    private int O00000o0;

    public interface O000000o {
        void onScrollY(int i);
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    public HomeSceneScrollView(Context context) {
        super(context);
        this.O00000o0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public HomeSceneScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public HomeSceneScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11313O000000o = (int) motionEvent.getRawX();
            this.O00000Oo = (int) motionEvent.getRawY();
        } else if (action == 2 && Math.abs(((int) motionEvent.getRawY()) - this.O00000Oo) > this.O00000o0) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.onScrollY(i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
