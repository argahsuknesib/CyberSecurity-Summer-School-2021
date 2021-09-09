package com.otaliastudios.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

class TapGestureLayout extends GestureLayout {
    public boolean O00000o;
    public FrameLayout O00000oO;
    ImageView O00000oo;
    public final Runnable O0000O0o = new Runnable() {
        /* class com.otaliastudios.cameraview.TapGestureLayout.AnonymousClass2 */

        public final void run() {
            TapGestureLayout.this.O00000Oo(false);
        }
    };
    private GestureDetector O0000OOo;

    public final float O000000o(float f, float f2, float f3) {
        return 0.0f;
    }

    public TapGestureLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context) {
        super.O000000o(context);
        this.O00000o0 = new PointF[]{new PointF(0.0f, 0.0f)};
        this.O0000OOo = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.otaliastudios.cameraview.TapGestureLayout.AnonymousClass1 */

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                TapGestureLayout tapGestureLayout = TapGestureLayout.this;
                tapGestureLayout.O00000o = true;
                tapGestureLayout.O00000Oo = Gesture.TAP;
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                TapGestureLayout tapGestureLayout = TapGestureLayout.this;
                tapGestureLayout.O00000o = true;
                tapGestureLayout.O00000Oo = Gesture.LONG_TAP;
            }
        });
        this.O0000OOo.setIsLongpressEnabled(true);
        LayoutInflater.from(getContext()).inflate((int) R.layout.cameraview_layout_focus_marker, this);
        this.O00000oO = (FrameLayout) findViewById(R.id.focusMarkerContainer);
        this.O00000oo = (ImageView) findViewById(R.id.fill);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5388O000000o) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.O00000o = false;
        }
        this.O0000OOo.onTouchEvent(motionEvent);
        if (!this.O00000o) {
            return false;
        }
        this.O00000o0[0].x = motionEvent.getX();
        this.O00000o0[0].y = motionEvent.getY();
        return true;
    }

    public final void O00000Oo(boolean z) {
        if (z) {
            O000000o(this.O00000oO, 1.0f, 0.0f, 500, 0, null);
            O000000o(this.O00000oo, 1.0f, 0.0f, 500, 0, null);
            return;
        }
        O000000o(this.O00000oo, 0.0f, 0.0f, 500, 0, null);
        O000000o(this.O00000oO, 1.36f, 1.0f, 500, 0, new AnimatorListenerAdapter() {
            /* class com.otaliastudios.cameraview.TapGestureLayout.AnonymousClass4 */

            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                TapGestureLayout.O000000o(TapGestureLayout.this.O00000oO, 1.36f, 0.0f, 200, 1000, null);
            }
        });
    }

    public static void O000000o(View view, float f, float f2, long j, long j2, Animator.AnimatorListener animatorListener) {
        view.animate().scaleX(f).scaleY(f).alpha(f2).setDuration(j).setStartDelay(j2).setListener(animatorListener).start();
    }
}
