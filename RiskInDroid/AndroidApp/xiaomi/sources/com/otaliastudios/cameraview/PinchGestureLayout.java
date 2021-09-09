package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

class PinchGestureLayout extends GestureLayout {
    ScaleGestureDetector O00000o;
    public boolean O00000oO;
    float O00000oo = 0.0f;

    public PinchGestureLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context) {
        super.O000000o(context);
        this.O00000o0 = new PointF[]{new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f)};
        this.O00000o = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            /* class com.otaliastudios.cameraview.PinchGestureLayout.AnonymousClass1 */

            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                PinchGestureLayout pinchGestureLayout = PinchGestureLayout.this;
                pinchGestureLayout.O00000oO = true;
                pinchGestureLayout.O00000oo = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            this.O00000o.setQuickScaleEnabled(false);
        }
        this.O00000Oo = Gesture.PINCH;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f5388O000000o) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.O00000oO = false;
        }
        this.O00000o.onTouchEvent(motionEvent);
        if (this.O00000oO) {
            this.O00000o0[0].x = motionEvent.getX(0);
            this.O00000o0[0].y = motionEvent.getY(0);
            z = true;
            if (motionEvent.getPointerCount() > 1) {
                this.O00000o0[1].x = motionEvent.getX(1);
                this.O00000o0[1].y = motionEvent.getY(1);
            }
        }
        return z;
    }

    public final float O000000o(float f, float f2, float f3) {
        return O000000o(f, (this.O00000oo * (f3 - f2)) + f, f2, f3);
    }
}
