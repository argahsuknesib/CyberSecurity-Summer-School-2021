package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class ColorIndicatorView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int f8585O000000o = Color.parseColor("#e0e0e0");
    private static final String O00000o0 = "ColorIndicatorView";
    public int O00000Oo;
    private int O00000o;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private float O0000OOo;
    private Paint O0000Oo;
    private int O0000Oo0;
    private Paint O0000OoO;

    public ColorIndicatorView(Context context, int i, float f, int i2, int i3, int i4) {
        super(context);
        this.O00000o = -16777216;
        this.O00000oO = i;
        this.O00000Oo = i;
        this.O0000OOo = f;
        this.O00000oo = i2;
        this.O0000O0o = i3;
        this.O0000Oo0 = i4;
        O000000o();
    }

    public ColorIndicatorView(Context context) {
        super(context);
        this.O00000o = -16777216;
        this.O00000oO = O000000o(23.0f);
        this.O00000Oo = this.O00000oO;
        this.O0000OOo = 1.3f;
        this.O00000oo = O000000o(2.0f);
        this.O0000O0o = O000000o(0.0f);
        this.O0000Oo0 = f8585O000000o;
        O000000o();
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [float, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    private void O000000o() {
        this.O0000Oo = new Paint();
        this.O0000Oo.setAntiAlias(true);
        this.O0000Oo.setColor(-1);
        this.O0000Oo.setStyle(Paint.Style.FILL);
        this.O0000Oo.setShadowLayer((float) this.O0000O0o, 0.0f, 0.0f, this.O0000Oo0);
        this.O0000OoO = new Paint();
        this.O0000OoO.setAntiAlias(true);
        this.O0000OoO.setColor(this.O00000o);
        this.O0000OoO.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setActivate(boolean z) {
        if (z) {
            int i = this.O00000oO;
            ValueAnimator ofInt = ValueAnimator.ofInt(i, (int) (this.O0000OOo * ((float) i)));
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.ColorIndicatorView.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ColorIndicatorView.this.O00000Oo = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ColorIndicatorView.this.invalidate();
                }
            });
            ofInt.start();
            return;
        }
        float f = this.O0000OOo;
        int i2 = this.O00000oO;
        ValueAnimator ofInt2 = ValueAnimator.ofInt((int) (f * ((float) i2)), i2);
        ofInt2.setDuration(150L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.ColorIndicatorView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorIndicatorView.this.O00000Oo = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ColorIndicatorView.this.invalidate();
            }
        });
        ofInt2.start();
    }

    public int getColor() {
        return this.O00000o;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(1, this.O0000Oo);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O00000Oo, this.O0000Oo);
        int i = this.O00000Oo - this.O00000oo;
        this.O0000OoO.setColor(this.O00000o);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) i, this.O0000OoO);
    }

    public void setColor(int i) {
        this.O00000o = i;
        invalidate();
    }
}
