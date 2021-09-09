package com.xiaomi.smarthome.library.common.widget.spans;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan extends SuperscriptSpan {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f9332O000000o = 2;
    protected float O00000Oo = 0.0f;

    TopAlignSuperscriptSpan() {
    }

    public void updateDrawState(TextPaint textPaint) {
        float ascent = textPaint.ascent();
        textPaint.setTextSize(textPaint.getTextSize() / ((float) this.f9332O000000o));
        float f = textPaint.getFontMetrics().ascent;
        float f2 = this.O00000Oo;
        textPaint.baselineShift = (int) (((float) textPaint.baselineShift) + ((ascent - (ascent * f2)) - (f - (f2 * f))));
    }

    public void updateMeasureState(TextPaint textPaint) {
        updateDrawState(textPaint);
    }
}
