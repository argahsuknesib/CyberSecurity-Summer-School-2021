package _m_j;

import _m_j.dpf;
import android.graphics.Canvas;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dqr extends dph {
    private int O000o0 = -16776961;
    private int O000o00O = 1;
    private int O000o00o = 0;
    private int O000o0O = 0;
    private int O000o0O0 = 0;

    public dqr(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public final void O00000o() {
        super.O00000o();
        this.O000o00o = 0;
        this.O000o0O0 = 0;
        this.O000o0O = 0;
    }

    public final void O00000Oo(Canvas canvas) {
        super.O00000Oo(canvas);
        int i = this.O000o00o;
        if (this.O000o0O0 > 0) {
            i += ((((this.O000OOo0 - this.O000o00o) - this.O000O0oo) - this.O000OO00) * this.O000o0O0) / this.O000o0O;
        }
        if (i > 0) {
            canvas.drawRect((float) this.O000O0oo, (float) this.O000OO0o, (float) (i + this.O000O0oo), (float) (this.O000OOo - this.O000OO), this.O0000Oo0);
        }
    }

    public final void O00000oO() {
        super.O00000oO();
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i != -266541503) {
            return false;
        }
        this.O000o00o = bns.O00000Oo((double) f);
        return true;
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        if (i == -266541503) {
            this.O000o00o = bns.O00000Oo((double) i2);
            return true;
        } else if (i == 3575610) {
            this.O000o00O = i2;
            return true;
        } else if (i != 94842723) {
            return false;
        } else {
            this.O000o0 = i2;
            this.O0000Oo0.setColor(this.O000o0);
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqr(vafContext, dpg);
        }
    }
}
