package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class SmartBarView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9255O000000o = new Paint();
    int O00000Oo;
    Interpolator O00000o = new AccelerateDecelerateInterpolator();
    int O00000o0;
    int O00000oO = 3000;

    public SmartBarView(Context context) {
        super(context);
    }

    public SmartBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmartBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9255O000000o.setAntiAlias(true);
        this.f9255O000000o.setColor(-6513508);
        this.f9255O000000o.setStrokeWidth(1.0f);
        this.f9255O000000o.setStyle(Paint.Style.STROKE);
        int height = (getHeight() * 2) / 3;
        float f = (float) height;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), f, f, this.f9255O000000o);
        this.f9255O000000o.setColor(this.O00000Oo);
        this.f9255O000000o.setStyle(Paint.Style.FILL);
        float f2 = (float) (height - 4);
        canvas.drawRoundRect(new RectF(2.0f, 2.0f, (float) ((((getWidth() - 4) * this.O00000o0) / 100) + 2), (float) (getHeight() - 2)), f2, f2, this.f9255O000000o);
    }
}
