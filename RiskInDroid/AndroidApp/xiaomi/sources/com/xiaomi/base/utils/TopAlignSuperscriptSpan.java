package com.xiaomi.base.utils;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan extends SuperscriptSpan {

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f5975O000000o;
    protected float O00000Oo;

    TopAlignSuperscriptSpan() {
        this.f5975O000000o = 1.5f;
        this.O00000Oo = 0.0f;
    }

    public TopAlignSuperscriptSpan(byte b) {
        this.f5975O000000o = 1.5f;
        this.O00000Oo = 0.0f;
        this.O00000Oo = 0.35f;
    }

    public void updateDrawState(TextPaint textPaint) {
        float ascent = textPaint.ascent();
        textPaint.setTextSize(textPaint.getTextSize() / this.f5975O000000o);
        float f = textPaint.getFontMetrics().ascent;
        int i = textPaint.baselineShift;
        float f2 = this.O00000Oo;
        textPaint.baselineShift = i + ((int) ((ascent - (ascent * f2)) - (f - (f2 * f))));
    }

    public void updateMeasureState(TextPaint textPaint) {
        updateDrawState(textPaint);
    }
}
