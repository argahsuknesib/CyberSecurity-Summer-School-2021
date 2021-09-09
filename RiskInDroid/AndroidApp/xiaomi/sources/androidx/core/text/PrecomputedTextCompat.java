package androidx.core.text;

import _m_j.as;
import _m_j.bd;
import _m_j.bf;
import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public final class PrecomputedTextCompat implements Spannable {
    private static final Object O00000Oo = new Object();
    private static Executor O00000o0 = null;

    /* renamed from: O000000o  reason: collision with root package name */
    public final O000000o f2837O000000o;
    private final Spannable O00000o;
    private final int[] O00000oO;
    private final PrecomputedText O00000oo;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final TextPaint f2838O000000o;
        public final TextDirectionHeuristic O00000Oo;
        public final int O00000o;
        public final int O00000o0;
        final PrecomputedText.Params O00000oO;

        /* renamed from: androidx.core.text.PrecomputedTextCompat$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0012O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextDirectionHeuristic f2839O000000o;
            public int O00000Oo;
            private final TextPaint O00000o;
            public int O00000o0;

            public C0012O000000o(TextPaint textPaint) {
                this.O00000o = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.O00000Oo = 1;
                    this.O00000o0 = 1;
                } else {
                    this.O00000o0 = 0;
                    this.O00000Oo = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f2839O000000o = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2839O000000o = null;
                }
            }

            public final O000000o O000000o() {
                return new O000000o(this.O00000o, this.f2839O000000o, this.O00000Oo, this.O00000o0);
            }
        }

        @SuppressLint({"NewApi"})
        O000000o(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.O00000oO = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.O00000oO = null;
            }
            this.f2838O000000o = textPaint;
            this.O00000Oo = textDirectionHeuristic;
            this.O00000o0 = i;
            this.O00000o = i2;
        }

        public O000000o(PrecomputedText.Params params) {
            this.f2838O000000o = params.getTextPaint();
            this.O00000Oo = params.getTextDirection();
            this.O00000o0 = params.getBreakStrategy();
            this.O00000o = params.getHyphenationFrequency();
            this.O00000oO = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public final boolean O000000o(O000000o o000000o) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.O00000o0 != o000000o.O00000o0 || this.O00000o != o000000o.O00000o)) || this.f2838O000000o.getTextSize() != o000000o.f2838O000000o.getTextSize() || this.f2838O000000o.getTextScaleX() != o000000o.f2838O000000o.getTextScaleX() || this.f2838O000000o.getTextSkewX() != o000000o.f2838O000000o.getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f2838O000000o.getLetterSpacing() != o000000o.f2838O000000o.getLetterSpacing() || !TextUtils.equals(this.f2838O000000o.getFontFeatureSettings(), o000000o.f2838O000000o.getFontFeatureSettings()))) || this.f2838O000000o.getFlags() != o000000o.f2838O000000o.getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f2838O000000o.getTextLocales().equals(o000000o.f2838O000000o.getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f2838O000000o.getTextLocale().equals(o000000o.f2838O000000o.getTextLocale())) {
                return false;
            }
            if (this.f2838O000000o.getTypeface() == null) {
                if (o000000o.f2838O000000o.getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2838O000000o.getTypeface().equals(o000000o.f2838O000000o.getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            if (!O000000o(o000000o)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.O00000Oo == o000000o.O00000Oo;
        }

        public final int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return bd.O000000o(Float.valueOf(this.f2838O000000o.getTextSize()), Float.valueOf(this.f2838O000000o.getTextScaleX()), Float.valueOf(this.f2838O000000o.getTextSkewX()), Float.valueOf(this.f2838O000000o.getLetterSpacing()), Integer.valueOf(this.f2838O000000o.getFlags()), this.f2838O000000o.getTextLocales(), this.f2838O000000o.getTypeface(), Boolean.valueOf(this.f2838O000000o.isElegantTextHeight()), this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return bd.O000000o(Float.valueOf(this.f2838O000000o.getTextSize()), Float.valueOf(this.f2838O000000o.getTextScaleX()), Float.valueOf(this.f2838O000000o.getTextSkewX()), Float.valueOf(this.f2838O000000o.getLetterSpacing()), Integer.valueOf(this.f2838O000000o.getFlags()), this.f2838O000000o.getTextLocale(), this.f2838O000000o.getTypeface(), Boolean.valueOf(this.f2838O000000o.isElegantTextHeight()), this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return bd.O000000o(Float.valueOf(this.f2838O000000o.getTextSize()), Float.valueOf(this.f2838O000000o.getTextScaleX()), Float.valueOf(this.f2838O000000o.getTextSkewX()), Integer.valueOf(this.f2838O000000o.getFlags()), this.f2838O000000o.getTextLocale(), this.f2838O000000o.getTypeface(), this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return bd.O000000o(Float.valueOf(this.f2838O000000o.getTextSize()), Float.valueOf(this.f2838O000000o.getTextScaleX()), Float.valueOf(this.f2838O000000o.getTextSkewX()), Integer.valueOf(this.f2838O000000o.getFlags()), this.f2838O000000o.getTextLocale(), this.f2838O000000o.getTypeface(), this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o));
            } else {
                return bd.O000000o(Float.valueOf(this.f2838O000000o.getTextSize()), Float.valueOf(this.f2838O000000o.getTextScaleX()), Float.valueOf(this.f2838O000000o.getTextSkewX()), Integer.valueOf(this.f2838O000000o.getFlags()), this.f2838O000000o.getTypeface(), this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o));
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2838O000000o.getTextSize());
            sb.append(", textScaleX=" + this.f2838O000000o.getTextScaleX());
            sb.append(", textSkewX=" + this.f2838O000000o.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f2838O000000o.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2838O000000o.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f2838O000000o.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f2838O000000o.getTextLocale());
            }
            sb.append(", typeface=" + this.f2838O000000o.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f2838O000000o.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.O00000Oo);
            sb.append(", breakStrategy=" + this.O00000o0);
            sb.append(", hyphenationFrequency=" + this.O00000o);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.TextUtils.indexOf(java.lang.CharSequence, char, int, int):int}
     arg types: [java.lang.CharSequence, int, int, int]
     candidates:
      ClspMth{android.text.TextUtils.indexOf(java.lang.CharSequence, java.lang.CharSequence, int, int):int}
      ClspMth{android.text.TextUtils.indexOf(java.lang.CharSequence, char, int, int):int} */
    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat O000000o(CharSequence charSequence, O000000o o000000o) {
        bf.O000000o(charSequence);
        bf.O000000o(o000000o);
        try {
            as.O000000o("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && o000000o.O00000oO != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, o000000o.O00000oO), o000000o);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, 10, i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), o000000o.f2838O000000o, Integer.MAX_VALUE).setBreakStrategy(o000000o.O00000o0).setHyphenationFrequency(o000000o.O00000o).setTextDirection(o000000o.O00000Oo).build();
            } else if (Build.VERSION.SDK_INT >= 21) {
                new StaticLayout(charSequence, o000000o.f2838O000000o, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, o000000o, iArr);
            as.O000000o();
            return precomputedTextCompat;
        } finally {
            as.O000000o();
        }
    }

    private PrecomputedTextCompat(CharSequence charSequence, O000000o o000000o, int[] iArr) {
        this.O00000o = new SpannableString(charSequence);
        this.f2837O000000o = o000000o;
        this.O00000oO = iArr;
        this.O00000oo = null;
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, O000000o o000000o) {
        this.O00000o = precomputedText;
        this.f2837O000000o = o000000o;
        this.O00000oO = null;
        this.O00000oo = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public final PrecomputedText O000000o() {
        Spannable spannable = this.O00000o;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private O000000o mParams;
            private CharSequence mText;

            PrecomputedTextCallback(O000000o o000000o, CharSequence charSequence) {
                this.mParams = o000000o;
                this.mText = charSequence;
            }

            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.O000000o(this.mText, this.mParams);
            }
        }

        PrecomputedTextFutureTask(O000000o o000000o, CharSequence charSequence) {
            super(new PrecomputedTextCallback(o000000o, charSequence));
        }
    }

    @SuppressLint({"NewApi"})
    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.O00000oo.setSpan(obj, i, i2, i3);
        } else {
            this.O00000o.setSpan(obj, i, i2, i3);
        }
    }

    @SuppressLint({"NewApi"})
    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.O00000oo.removeSpan(obj);
        } else {
            this.O00000o.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.O00000oo.getSpans(i, i2, cls);
        }
        return this.O00000o.getSpans(i, i2, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.O00000o.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.O00000o.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.O00000o.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.O00000o.nextSpanTransition(i, i2, cls);
    }

    public final int length() {
        return this.O00000o.length();
    }

    public final char charAt(int i) {
        return this.O00000o.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.O00000o.subSequence(i, i2);
    }

    public final String toString() {
        return this.O00000o.toString();
    }
}
