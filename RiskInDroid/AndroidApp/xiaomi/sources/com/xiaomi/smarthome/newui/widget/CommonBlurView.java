package com.xiaomi.smarthome.newui.widget;

import _m_j.gsy;
import _m_j.gzi;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.application.CommonApplication;

@SuppressLint({"AppCompatCustomView"})
public class CommonBlurView extends ImageView {
    private Bitmap mScaledBitmap;
    private View mView;
    private gzi manager = new gzi();
    private final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() {
        /* class com.xiaomi.smarthome.newui.widget.$$Lambda$CommonBlurView$97XqYzS7B81azCrCrDwLEkBFUNg */

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            CommonBlurView.this.lambda$new$0$CommonBlurView(view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };

    public /* synthetic */ void lambda$new$0$CommonBlurView(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        processBlurView(this.mView.getDrawingCache(), false, false);
    }

    public CommonBlurView(Context context) {
        super(context);
    }

    public CommonBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBlurView(View view, boolean z) {
        View view2 = this.mView;
        if (view2 != null) {
            view2.removeOnLayoutChangeListener(this.onLayoutChangeListener);
            this.mView.setDrawingCacheEnabled(false);
        }
        if (view != null) {
            this.mView = view;
            view.setDrawingCacheEnabled(true);
            processBlurView(view.getDrawingCache(), z, true);
            view.addOnLayoutChangeListener(this.onLayoutChangeListener);
        }
    }

    public void setBlurViewGone() {
        this.mView.removeOnLayoutChangeListener(this.onLayoutChangeListener);
        this.mView.setDrawingCacheEnabled(false);
        if (getVisibility() == 0 && getAlpha() > 0.0f) {
            animateGone();
        }
    }

    private void processBlurView(Bitmap bitmap, boolean z, boolean z2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 5, bitmap.getHeight() / 5, false);
            CommonApplication.getGlobalWorkerHandler().post(new Runnable(z2, z) {
                /* class com.xiaomi.smarthome.newui.widget.$$Lambda$CommonBlurView$9lXAirx3jIGctPSloQ1b6pl1QvY */
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CommonBlurView.this.lambda$processBlurView$2$CommonBlurView(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$processBlurView$2$CommonBlurView(boolean z, boolean z2) {
        post(new Runnable(this.manager.O000000o(this.mScaledBitmap), z, z2) {
            /* class com.xiaomi.smarthome.newui.widget.$$Lambda$CommonBlurView$aXkAIGcWEVOtmmrRXdY8MsAbY */
            private final /* synthetic */ Bitmap f$1;
            private final /* synthetic */ boolean f$2;
            private final /* synthetic */ boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                CommonBlurView.this.lambda$null$1$CommonBlurView(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$null$1$CommonBlurView(Bitmap bitmap, boolean z, boolean z2) {
        setImageBitmap(bitmap);
        if (z) {
            setVisibility(0);
        }
        if (z2) {
            animateStart();
        }
    }

    private void animateStart() {
        gsy.O000000o(4, "zc", "animateStart");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    private void animateGone() {
        gsy.O000000o(4, "zc", "animateGone");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
        if (getVisibility() == 0) {
            canvas.drawColor(Integer.MIN_VALUE);
        }
    }
}
