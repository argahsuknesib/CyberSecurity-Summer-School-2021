package com.xiaomi.smarthome.camera.v4.view;

import _m_j.gsy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    private final int MOVE_SLOP;
    public boolean dealWith;
    private boolean isCanScroll;
    private float lastY;
    private boolean mTopFlag;
    private onTouchMoveListener onTouchMoveListener;

    public interface onTouchMoveListener {
        void onTop(MotionEvent motionEvent);
    }

    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopFlag = true;
        this.isCanScroll = false;
        this.lastY = 0.0f;
        this.MOVE_SLOP = 20;
        this.dealWith = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.dealWith) {
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastY = motionEvent.getY();
        } else if (action == 2) {
            gsy.O000000o(3, "Javine", "getScrollY(): " + getScrollY());
            float y = motionEvent.getY();
            if (getScrollY() == 0 && y - this.lastY > 20.0f) {
                onTouchMoveListener ontouchmovelistener = this.onTouchMoveListener;
                if (ontouchmovelistener != null) {
                    ontouchmovelistener.onTop(motionEvent);
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        }
        return onTouchEvent;
    }

    public void setOnTouchMoveListener(onTouchMoveListener ontouchmovelistener) {
        this.onTouchMoveListener = ontouchmovelistener;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        gsy.O000000o(3, "Javine", "onScrolled ".concat(String.valueOf(i2)));
        this.isCanScroll = true;
        if (i2 == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mTopFlag = true;
        }
    }
}
