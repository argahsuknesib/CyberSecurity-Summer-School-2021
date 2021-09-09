package com.xiaomi.shopviews.widget.hdhorizontalrecyclergoods;

import _m_j.dul;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class CustRecylerView extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f3930O000000o = false;
    private float O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;

    public CustRecylerView(Context context) {
        super(context);
    }

    public CustRecylerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustRecylerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x0076;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.O00000o0 = motionEvent.getRawX();
                    this.O00000oO = motionEvent.getRawY();
                    if (this.f3930O000000o) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        float abs = Math.abs(this.O00000oO - this.O00000o);
                        float abs2 = Math.abs(this.O00000o0 - this.O00000Oo);
                        if (abs2 < abs || abs2 < ((float) dul.O000000o(getContext(), 3.0f))) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                        this.f3930O000000o = true;
                    }
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f3930O000000o = false;
        } else {
            this.O00000Oo = motionEvent.getRawX();
            this.O00000o = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
