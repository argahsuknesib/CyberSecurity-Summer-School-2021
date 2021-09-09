package com.xiaomi.youpin.common.util;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public final class SpanUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f12055O000000o = System.getProperty("line.separator");

    @SuppressLint({"ParcelCreator"})
    class CustomTypefaceSpan extends TypefaceSpan {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Typeface f12056O000000o;

        public void updateDrawState(TextPaint textPaint) {
            O000000o(textPaint, this.f12056O000000o);
        }

        public void updateMeasureState(TextPaint textPaint) {
            O000000o(textPaint, this.f12056O000000o);
        }

        private static void O000000o(Paint paint, Typeface typeface) {
            int i;
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 == null) {
                i = 0;
            } else {
                i = typeface2.getStyle();
            }
            int style = i & (typeface.getStyle() ^ -1);
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }
    }
}
