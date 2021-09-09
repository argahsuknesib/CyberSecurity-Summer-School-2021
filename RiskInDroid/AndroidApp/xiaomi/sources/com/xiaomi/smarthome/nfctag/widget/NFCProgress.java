package com.xiaomi.smarthome.nfctag.widget;

import _m_j.gpc;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.xiaomi.smarthome.R;

public class NFCProgress extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f10474O000000o;
    int O00000Oo;
    float O00000o;
    float O00000o0;
    int O00000oO;
    private Paint O00000oo;

    public NFCProgress(Context context) {
        this(context, null);
    }

    public NFCProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NFCProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10474O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0.0f;
        this.O00000o = 0.0f;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.duaration, R.attr.max_width});
        this.O00000o = obtainStyledAttributes.getDimension(1, 0.0f);
        this.O00000oO = obtainStyledAttributes.getInteger(0, 1000);
        obtainStyledAttributes.recycle();
        this.f10474O000000o = gpc.O00000o0(context, 2.0f);
        this.O00000Oo = gpc.O00000o0(context, 4.0f);
        this.O00000oo = new Paint();
        this.O00000oo.setStrokeWidth((float) gpc.O00000o0(context, 1.0f));
        this.O00000oo.setStyle(Paint.Style.FILL);
        this.O00000oo.setColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O00000oo.setStrokeCap(Paint.Cap.SQUARE);
        this.O00000oo.setAntiAlias(true);
    }

    public final void O000000o() {
        float f = this.O00000o;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) f, (int) f);
        ofInt.setDuration((long) this.O00000oO);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.nfctag.widget.$$Lambda$NFCProgress$_p7CNWOWOWFRwOlBk4M81XDOY */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NFCProgress.this.O000000o(valueAnimator);
            }
        });
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(1);
        ofInt.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ValueAnimator valueAnimator) {
        this.O00000o0 = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, this.O00000o0, (float) this.O00000Oo);
        int i = this.f10474O000000o;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.O00000oo);
        invalidate();
        canvas.restore();
    }
}
