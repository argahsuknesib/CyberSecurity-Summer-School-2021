package com.swmansion.gesturehandler;

import _m_j.dec;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

public class LongPressGestureHandler extends dec<LongPressGestureHandler> {
    private static float O0000oOO = 10.0f;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f5762O000000o = 500;
    public float O00000Oo;
    private float O0000oOo;
    private Handler O0000oo;
    private float O0000oo0;

    public LongPressGestureHandler(Context context) {
        this.O0000Ooo = true;
        this.O00000Oo = O0000oOO * context.getResources().getDisplayMetrics().density;
    }

    public final void O0000OOo() {
        Handler handler = this.O0000oo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.O0000oo = null;
        }
    }

    public final void O000000o(MotionEvent motionEvent) {
        if (this.O0000O0o == 0) {
            O00000oo();
            this.O0000oOo = motionEvent.getRawX();
            this.O0000oo0 = motionEvent.getRawY();
            this.O0000oo = new Handler();
            this.O0000oo.postDelayed(new Runnable() {
                /* class com.swmansion.gesturehandler.LongPressGestureHandler.AnonymousClass1 */

                public final void run() {
                    LongPressGestureHandler.this.O00000oO();
                }
            }, this.f5762O000000o);
        }
        if (motionEvent.getActionMasked() == 1) {
            Handler handler = this.O0000oo;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.O0000oo = null;
            }
            if (this.O0000O0o == 4) {
                O0000O0o();
            } else {
                O00000o();
            }
        } else {
            float rawX = motionEvent.getRawX() - this.O0000oOo;
            float rawY = motionEvent.getRawY() - this.O0000oo0;
            if ((rawX * rawX) + (rawY * rawY) <= this.O00000Oo) {
                return;
            }
            if (this.O0000O0o == 4) {
                O00000o0();
            } else {
                O00000o();
            }
        }
    }
}
