package _m_j;

import _m_j.dpf;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dra extends dqz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14863O000000o = 0;
    protected dpf.O00000o0 O000o0 = new dpf.O00000o0();
    protected int O000o00O;
    protected String O000o00o = "";

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public dra(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0.O000000o();
        this.O000o0.O000000o(this);
    }

    public final void O00000oO() {
        super.O00000oO();
        if ((this.O000o0o & 1) != 0) {
            this.O0000Oo0.setFakeBoldText(true);
        }
        if ((this.O000o0o & 8) != 0) {
            this.O0000Oo0.setStrikeThruText(true);
        }
        if ((this.O000o0o & 2) != 0) {
            this.O0000Oo0.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
        }
        this.O0000Oo0.setTextSize((float) this.O000o0o0);
        this.O0000Oo0.setColor(this.O000o0Oo);
        Paint.FontMetricsInt fontMetricsInt = this.O0000Oo0.getFontMetricsInt();
        this.f14863O000000o = fontMetricsInt.descent - fontMetricsInt.ascent;
        this.O000o00O = fontMetricsInt.descent;
        this.O000o00o = this.O000o0OO;
        if (!TextUtils.isEmpty(this.O000o0OO)) {
            O00000o0(this.O000o0OO);
        } else {
            O00000o0("");
        }
    }

    public final void O00000o() {
        super.O00000o();
        this.O000o0.O00000Oo();
        this.O000o00o = this.O000o0OO;
    }

    public final void O00000o0(String str) {
        this.O000o00o = str;
        super.O00000o0(str);
    }

    public final void O00000Oo(Object obj) {
        super.O00000Oo(obj);
        if (obj instanceof String) {
            this.O000o00o = (String) obj;
            if (this.O00000oO) {
                O000O0OO();
                return;
            }
            return;
        }
        Log.e("VirtualText_TMTEST", "setData type error:".concat(String.valueOf(obj)));
    }

    public final void O00000Oo(Canvas canvas) {
        int i;
        super.O00000Oo(canvas);
        if (this.O000OoO == null) {
            O000OOOo();
        }
        if (this.O000OoO != null) {
            int i2 = this.O000O0oo;
            if ((this.O000OOOo & 2) != 0) {
                i2 = ((this.O000OOo0 - this.O000OoO.width()) - this.O000O0oo) - this.O000OO00;
            } else if ((this.O000OOOo & 4) != 0) {
                i2 = (this.O000OOo0 - this.O000OoO.width()) / 2;
            }
            if ((this.O000OOOo & 16) != 0) {
                i = this.O000OOo - this.O000OO;
            } else if ((this.O000OOOo & 32) != 0) {
                Paint.FontMetricsInt fontMetricsInt = this.O0000Oo0.getFontMetricsInt();
                i = this.O000o00O + (((this.O000OOo - fontMetricsInt.bottom) - fontMetricsInt.top) / 2);
            } else {
                i = this.O000OoO.height() + this.O000OO0o;
            }
            canvas.save();
            canvas.clipRect(0, 0, this.O000OOo0, this.O000OOo);
            canvas.drawText(this.O000o00o, (float) i2, (float) (i - this.O000o00O), this.O0000Oo0);
            canvas.restore();
            dov.O000000o(canvas, this.O0000o0O, this.O000OOo0, this.O000OOo, this.O0000o0, this.O0000o, this.O0000oO0, this.O0000oO, this.O0000oOO);
            return;
        }
        Log.w("VirtualText_TMTEST", "skip draw text");
    }

    public final void O000OOOo() {
        float measureText = this.O0000Oo0.measureText(this.O000o00o);
        if (this.O000OoO == null) {
            this.O000OoO = new Rect(0, 0, (int) measureText, this.f14863O000000o);
        } else {
            this.O000OoO.set(0, 0, (int) measureText, this.f14863O000000o);
        }
    }

    public final void onComMeasure(int i, int i2) {
        this.O000o0.onComMeasure(i, i2);
    }

    public final void measureComponent(int i, int i2) {
        this.O000o0.measureComponent(i, i2);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dra(vafContext, dpg);
        }
    }
}
