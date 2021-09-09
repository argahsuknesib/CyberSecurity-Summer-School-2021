package _m_j;

import _m_j.dpf;
import android.graphics.Paint;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.text.NativeTextImp;

public final class dqy extends dqz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected NativeTextImp f14859O000000o;
    protected float O000o0 = 1.0f;
    protected O00000o0 O000o00O;
    protected boolean O000o00o = false;
    protected float O000o0O = Float.NaN;
    protected float O000o0O0 = 0.0f;

    public dqy(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.f14859O000000o = new NativeTextImp(vafContext.O0000O0o());
    }

    public final void O00000o0(String str) {
        if (!TextUtils.equals(str, this.O000o0OO)) {
            this.O000o0OO = str;
            O00000o(this.O000o0OO);
        }
    }

    public final void O00000o() {
        super.O00000o();
    }

    public final View g_() {
        return this.f14859O000000o;
    }

    public final void onComMeasure(int i, int i2) {
        this.f14859O000000o.onComMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f14859O000000o.onComLayout(z, i, i2, i3, i4);
    }

    public final void measureComponent(int i, int i2) {
        this.f14859O000000o.measureComponent(i, i2);
    }

    public final int getComMeasuredWidth() {
        return this.f14859O000000o.getComMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return this.f14859O000000o.getComMeasuredHeight();
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        this.f14859O000000o.comLayout(i, i2, i3, i4);
    }

    public final void O00000oO() {
        super.O00000oO();
        int i = 0;
        this.f14859O000000o.setTextSize(0, (float) this.O000o0o0);
        this.f14859O000000o.setBorderColor(this.O0000o0O);
        this.f14859O000000o.setBorderWidth(this.O0000o0);
        this.f14859O000000o.setBorderTopLeftRadius(this.O0000o);
        this.f14859O000000o.setBorderTopRightRadius(this.O0000oO0);
        this.f14859O000000o.setBorderBottomLeftRadius(this.O0000oO);
        this.f14859O000000o.setBorderBottomRightRadius(this.O0000oOO);
        this.f14859O000000o.setBackgroundColor(this.O0000Oo);
        this.f14859O000000o.setTextColor(this.O000o0Oo);
        int i2 = (this.O000o0o & 1) != 0 ? 33 : 1;
        if ((this.O000o0o & 8) != 0) {
            i2 |= 16;
        }
        if ((this.O000o0o & 4) != 0) {
            i2 |= 8;
        }
        this.f14859O000000o.setPaintFlags(i2);
        if ((this.O000o0o & 2) != 0) {
            this.f14859O000000o.setTypeface(null, 3);
        }
        if (this.O000o > 0) {
            this.f14859O000000o.setLines(this.O000o);
        }
        if (this.O000oO00 >= 0) {
            this.f14859O000000o.setEllipsize(TextUtils.TruncateAt.values()[this.O000oO00]);
        }
        if ((this.O000OOOo & 1) != 0) {
            i = 3;
        } else if ((this.O000OOOo & 2) != 0) {
            i = 5;
        } else if ((this.O000OOOo & 4) != 0) {
            i = 1;
        }
        if ((this.O000OOOo & 8) != 0) {
            i |= 48;
        } else if ((this.O000OOOo & 16) != 0) {
            i |= 80;
        } else if ((this.O000OOOo & 32) != 0) {
            i |= 16;
        }
        this.f14859O000000o.setGravity(i);
        this.f14859O000000o.setLineSpacing(this.O000o0O0, this.O000o0);
        if (!TextUtils.isEmpty(this.O000o0OO)) {
            O00000o(this.O000o0OO);
        } else {
            O00000o("");
        }
    }

    public final void O00000Oo(Object obj) {
        super.O00000Oo(obj);
        if (obj instanceof String) {
            O00000o((String) obj);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    private void O00000o(String str) {
        CharSequence charSequence = str;
        if (this.O000o00o) {
            charSequence = Html.fromHtml(str);
        }
        if (!Float.isNaN(this.O000o0O)) {
            if (this.O000o00O == null) {
                this.O000o00O = new O00000o0();
            }
            this.O000o00O.O000000o(charSequence, this.O000o0O);
            this.f14859O000000o.setText(this.O000o00O);
            return;
        }
        this.f14859O000000o.setText(charSequence);
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o02 = super.O00000o0(i, i2);
        boolean z = false;
        if (O00000o02) {
            return O00000o02;
        }
        switch (i) {
            case -1118334530:
                this.O000o0O0 = (float) i2;
                break;
            case -667362093:
                this.O000o0 = (float) i2;
                break;
            case -515807685:
                this.O000o0O = (float) bns.O00000Oo((double) i2);
                break;
            case 390232059:
                this.f14859O000000o.setMaxLines(i2);
                break;
            case 506010071:
                if (i2 > 0) {
                    z = true;
                }
                this.O000o00o = z;
                break;
            default:
                return false;
        }
        return true;
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo2 = super.O00000Oo(i, f);
        boolean z = false;
        if (O00000Oo2) {
            return O00000Oo2;
        }
        switch (i) {
            case -1118334530:
                this.O000o0O0 = f;
                break;
            case -667362093:
                this.O000o0 = f;
                break;
            case -515807685:
                this.O000o0O = (float) bns.O00000Oo((double) f);
                break;
            case 506010071:
                if (f > 0.0f) {
                    z = true;
                }
                this.O000o00o = z;
                break;
            default:
                return false;
        }
        return true;
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo2 = super.O00000Oo(i, i2);
        if (O00000Oo2) {
            return O00000Oo2;
        }
        if (i != -515807685) {
            return false;
        }
        this.O000o0O = (float) bns.O000000o((double) i2);
        return true;
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i != -515807685) {
            return false;
        }
        this.O000o0O = (float) bns.O000000o((double) f);
        return true;
    }

    public final boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        if (O000000o2) {
            return O000000o2;
        }
        if (i != -515807685) {
            return false;
        }
        this.O00000Oo.O000000o(this, -515807685, str, 1);
        return true;
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqy(vafContext, dpg);
        }
    }

    public static class O00000o0 extends SpannableStringBuilder {

        /* renamed from: O000000o  reason: collision with root package name */
        private O00000Oo f14861O000000o;

        public final void O000000o(CharSequence charSequence, float f) {
            clear();
            clearSpans();
            O00000Oo o00000Oo = this.f14861O000000o;
            if (o00000Oo == null) {
                this.f14861O000000o = new O00000Oo(f);
            } else {
                o00000Oo.O000000o(f);
            }
            append(charSequence);
            setSpan(this.f14861O000000o, 0, charSequence.length(), 17);
        }
    }

    public static class O00000Oo implements LineHeightSpan {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f14860O000000o;

        O00000Oo(float f) {
            this.f14860O000000o = (int) Math.ceil((double) f);
        }

        public final void O000000o(float f) {
            this.f14860O000000o = (int) Math.ceil((double) f);
        }

        public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            int i5 = fontMetricsInt.descent;
            int i6 = this.f14860O000000o;
            if (i5 > i6) {
                int min = Math.min(i6, fontMetricsInt.descent);
                fontMetricsInt.descent = min;
                fontMetricsInt.bottom = min;
                fontMetricsInt.ascent = 0;
                fontMetricsInt.top = 0;
            } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.f14860O000000o) {
                fontMetricsInt.bottom = fontMetricsInt.descent;
                int i7 = (-this.f14860O000000o) + fontMetricsInt.descent;
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
            } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.f14860O000000o) {
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = fontMetricsInt.ascent + this.f14860O000000o;
            } else {
                int i8 = (-fontMetricsInt.top) + fontMetricsInt.bottom;
                int i9 = this.f14860O000000o;
                if (i8 > i9) {
                    fontMetricsInt.top = fontMetricsInt.bottom - this.f14860O000000o;
                    return;
                }
                int i10 = i9 - ((-fontMetricsInt.top) + fontMetricsInt.bottom);
                double d = (double) fontMetricsInt.top;
                double d2 = (double) (((float) i10) / 2.0f);
                double ceil = Math.ceil(d2);
                Double.isNaN(d);
                fontMetricsInt.top = (int) (d - ceil);
                double d3 = (double) fontMetricsInt.bottom;
                double floor = Math.floor(d2);
                Double.isNaN(d3);
                fontMetricsInt.bottom = (int) (d3 + floor);
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
        }
    }
}
