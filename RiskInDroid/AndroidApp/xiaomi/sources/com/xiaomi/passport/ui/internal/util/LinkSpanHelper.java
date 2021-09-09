package com.xiaomi.passport.ui.internal.util;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

public final class LinkSpanHelper {

    public interface O000000o {
        void O000000o(View view, String str);
    }

    public static class UrlSpanNoUnderline extends URLSpan {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O000000o f6262O000000o;
        private final int O00000Oo;

        public UrlSpanNoUnderline(String str, O000000o o000000o, int i) {
            super(str);
            this.f6262O000000o = o000000o;
            this.O00000Oo = i;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.O00000Oo);
        }

        public void onClick(View view) {
            this.f6262O000000o.O000000o(view, getURL());
        }
    }
}
