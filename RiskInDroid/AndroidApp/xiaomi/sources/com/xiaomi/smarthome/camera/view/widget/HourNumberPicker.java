package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import java.util.Formatter;
import java.util.Locale;

public class HourNumberPicker extends NumberPicker {
    public static final NumberPicker.O00000o HOUR_MINUTE_DIGIT_FORMATTER = new NumberPicker.O00000o() {
        /* class com.xiaomi.smarthome.camera.view.widget.HourNumberPicker.AnonymousClass1 */
        final Object[] mArgs = new Object[1];
        final StringBuilder mBuilder = new StringBuilder();
        final StringBuilder mBuilder1 = new StringBuilder();
        final Formatter mFmt = new Formatter(this.mBuilder, Locale.US);
        final Formatter mFmt1 = new Formatter(this.mBuilder1, Locale.US);

        public final String format(int i) {
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
            StringBuilder sb2 = this.mBuilder1;
            sb2.delete(0, sb2.length());
            this.mFmt.format("%02d", Integer.valueOf(i / 6));
            this.mFmt1.format("%02d", Integer.valueOf((i % 6) * 10));
            return this.mFmt.toString() + ":" + this.mFmt1.toString();
        }
    };

    public HourNumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HourNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HourNumberPicker(Context context) {
        super(context);
    }
}
