package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f4953O000000o;
    private int O00000Oo;
    private ViewGroup O00000o0;

    public void setParent(ViewGroup viewGroup) {
        this.O00000o0 = viewGroup;
    }

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4953O000000o = (int) (motionEvent.getX() + 0.5f);
            this.O00000Oo = (int) (motionEvent.getY() + 0.5f);
            this.O00000o0.requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int x = (int) (motionEvent.getX() + 0.5f);
            int y = (int) (motionEvent.getY() + 0.5f);
            int i = x - this.f4953O000000o;
            this.f4953O000000o = x;
            this.O00000Oo = y;
            if (Math.abs(y - this.O00000Oo) > Math.abs(i)) {
                this.O00000o0.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
