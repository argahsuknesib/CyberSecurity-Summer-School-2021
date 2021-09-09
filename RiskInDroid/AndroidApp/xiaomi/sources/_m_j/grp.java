package _m_j;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class grp extends MetricAffectingSpan {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f18185O000000o;

    public grp(int i) {
        this.f18185O000000o = i;
    }

    public final void updateMeasureState(TextPaint textPaint) {
        textPaint.baselineShift += O000000o(textPaint);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.baselineShift += O000000o(textPaint);
    }

    private int O000000o(TextPaint textPaint) {
        return ((int) ((textPaint.ascent() + textPaint.descent()) / 2.0f)) + this.f18185O000000o;
    }
}
