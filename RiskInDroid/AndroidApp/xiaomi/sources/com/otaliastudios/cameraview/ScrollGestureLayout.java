package com.otaliastudios.cameraview;

import _m_j.cpo;
import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;

class ScrollGestureLayout extends GestureLayout {
    public static final cpo O00000o = cpo.O000000o(ScrollGestureLayout.class.getSimpleName());
    private static final String O0000O0o = "ScrollGestureLayout";
    public boolean O00000oO;
    float O00000oo;
    private GestureDetector O0000OOo;

    public ScrollGestureLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context) {
        super.O000000o(context);
        this.O00000o0 = new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f)};
        this.O0000OOo = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.otaliastudios.cameraview.ScrollGestureLayout.AnonymousClass1 */

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z;
                boolean z2 = false;
                ScrollGestureLayout.O00000o.O000000o("onScroll:", "distanceX=".concat(String.valueOf(f)), "distanceY=".concat(String.valueOf(f2)));
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getX() == ScrollGestureLayout.this.O00000o0[0].x && motionEvent.getY() == ScrollGestureLayout.this.O00000o0[0].y) {
                    if (ScrollGestureLayout.this.O00000Oo == Gesture.SCROLL_HORIZONTAL) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = Math.abs(f) >= Math.abs(f2);
                    ScrollGestureLayout.this.O00000Oo = z ? Gesture.SCROLL_HORIZONTAL : Gesture.SCROLL_VERTICAL;
                    ScrollGestureLayout.this.O00000o0[0].set(motionEvent.getX(), motionEvent.getY());
                }
                ScrollGestureLayout.this.O00000o0[1].set(motionEvent2.getX(), motionEvent2.getY());
                ScrollGestureLayout scrollGestureLayout = ScrollGestureLayout.this;
                scrollGestureLayout.O00000oo = z ? f / ((float) scrollGestureLayout.getWidth()) : f2 / ((float) scrollGestureLayout.getHeight());
                ScrollGestureLayout scrollGestureLayout2 = ScrollGestureLayout.this;
                scrollGestureLayout2.O00000oo = z ? -scrollGestureLayout2.O00000oo : scrollGestureLayout2.O00000oo;
                ScrollGestureLayout.this.O00000oO = true;
                return true;
            }
        });
        this.O0000OOo.setIsLongpressEnabled(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5388O000000o) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.O00000oO = false;
        }
        this.O0000OOo.onTouchEvent(motionEvent);
        if (this.O00000oO) {
            O00000o.O000000o(1, "Notifying a gesture of type", this.O00000Oo.name());
        }
        return this.O00000oO;
    }

    public final float O000000o(float f, float f2, float f3) {
        return O000000o(f, (this.O00000oo * (f3 - f2) * 2.0f) + f, f2, f3);
    }
}
