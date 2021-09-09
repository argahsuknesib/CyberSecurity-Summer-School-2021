package com.xiasuhuei321.loadingdialog.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class LVCircularRing extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12143O000000o;
    public float O00000Oo;
    private float O00000o;
    ValueAnimator O00000o0;
    private float O00000oO;
    private Paint O00000oo;
    private int O0000O0o;
    private Paint O0000OOo;

    public LVCircularRing(Context context) {
        this(context, null);
    }

    public LVCircularRing(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LVCircularRing(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12143O000000o = getClass().getSimpleName();
        this.O00000o = 0.0f;
        this.O00000oO = 0.0f;
        this.O00000Oo = 0.0f;
        this.O0000O0o = Color.argb(100, 255, 255, 255);
        this.O00000oo = new Paint();
        this.O00000oo.setAntiAlias(true);
        this.O00000oo.setStyle(Paint.Style.STROKE);
        this.O00000oo.setColor(this.O0000O0o);
        this.O00000oo.setStrokeWidth(8.0f);
        this.O0000OOo = new Paint();
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStyle(Paint.Style.STROKE);
        this.O0000OOo.setStrokeWidth(8.0f);
        this.O0000OOo.setColor(this.O0000O0o);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.O00000o = (float) getMeasuredHeight();
        } else {
            this.O00000o = (float) getMeasuredWidth();
        }
        this.O00000oO = 5.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.O0000OOo.setColor(this.O0000O0o);
        float f = this.O00000o;
        canvas.drawCircle(f / 2.0f, f / 2.0f, (f / 2.0f) - this.O00000oO, this.O0000OOo);
        this.O00000oo.setColor(-1);
        float f2 = this.O00000oO;
        float f3 = this.O00000o;
        canvas.drawArc(new RectF(f2, f2, f3 - f2, f3 - f2), this.O00000Oo, 100.0f, false, this.O00000oo);
    }

    public void setColor(int i) {
        this.O0000O0o = i;
        this.O00000oo.setColor(i);
        this.O0000OOo.setColor(i);
    }
}
