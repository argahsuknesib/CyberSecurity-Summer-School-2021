package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;

public class ColorSeekArc extends SeekArc {

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9154O000000o;
    Shader O00000Oo = null;

    public ColorSeekArc(Context context) {
        super(context);
    }

    public ColorSeekArc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorSeekArc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context, AttributeSet attributeSet, int i) {
        super.O000000o(context, attributeSet, i);
        this.f9154O000000o = new Paint(1);
        this.f9154O000000o.setStyle(Paint.Style.STROKE);
        this.f9154O000000o.setStrokeWidth((float) this.O0000Oo);
    }

    public void setArcColor(int i) {
        int i2 = -16777216 | i;
        int i3 = i & 16777215;
        this.O00000Oo = new SweepGradient(this.O0000oO.centerX(), this.O0000oO.centerY(), new int[]{i3, i3, i2}, new float[]{0.0f, 0.45833334f, 1.0f});
        this.f9154O000000o.setShader(this.O00000Oo);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.O00000Oo == null) {
            super.onDraw(canvas);
            return;
        }
        if (!this.O0000o0o) {
            canvas.scale(-1.0f, 1.0f, this.O0000oO.centerX(), this.O0000oO.centerY());
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.O0000oO, (float) ((this.O0000OoO - 90) + this.O0000o00), (float) this.O0000Ooo, false, this.f9154O000000o);
        canvas.translate((float) (this.O0000oo0 - this.O0000ooO), (float) (this.O0000oo - this.O0000ooo));
        this.O00000oo.draw(canvas);
    }
}
