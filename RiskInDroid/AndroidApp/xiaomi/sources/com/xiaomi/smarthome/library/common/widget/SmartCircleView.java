package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;

public class SmartCircleView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9256O000000o = new Paint();
    int O00000Oo;
    long O00000o;
    TextView O00000o0;
    Interpolator O00000oO = new AccelerateDecelerateInterpolator();
    int O00000oo = 3000;
    int O0000O0o = 0;

    public SmartCircleView(Context context) {
        super(context);
    }

    public SmartCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmartCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.O00000Oo != 0) {
            this.f9256O000000o.setAntiAlias(true);
            this.f9256O000000o.setColor(-2040355);
            this.f9256O000000o.setStrokeWidth(3.0f);
            this.f9256O000000o.setStyle(Paint.Style.STROKE);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() - 20) / 2), this.f9256O000000o);
            this.f9256O000000o.setColor(-750049);
            this.f9256O000000o.setStrokeWidth(20.0f);
            this.f9256O000000o.setStyle(Paint.Style.STROKE);
            float currentTimeMillis = (float) (System.currentTimeMillis() - this.O00000o);
            int i = this.O00000oo;
            if (currentTimeMillis > ((float) i)) {
                f = 1.0f;
            } else {
                f = currentTimeMillis / ((float) i);
                postInvalidate();
            }
            float interpolation = this.O00000oO.getInterpolation(f);
            canvas.drawArc(new RectF(10.0f, 10.0f, (float) (getWidth() - 10), (float) (getHeight() - 10)), 135.0f, (((float) (this.O00000Oo * 360)) * interpolation) / 100.0f, false, this.f9256O000000o);
            this.O0000O0o++;
            if (this.O00000o0 == null) {
                return;
            }
            if (this.O0000O0o % 5 == 0 || ((double) interpolation) == 1.0d) {
                this.O00000o0.setText(String.valueOf((int) (((float) this.O00000Oo) * interpolation)));
            }
        }
    }
}
