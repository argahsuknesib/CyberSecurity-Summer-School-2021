package _m_j;

import _m_j.dpf;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public final class dqg extends dqf {
    private dqh O000o0O;

    public dqg(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0O = new dqh(vafContext.O0000O0o(), this);
    }

    public final View g_() {
        return this.O000o0O;
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O000o0O.O000000o(this.O000o00O, this.O000o00o, this.O000o0);
    }

    public final void onComMeasure(int i, int i2) {
        this.O000o0O.onComMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.O000o0O.onComLayout(z, i, i2, i3, i4);
    }

    public final void measureComponent(int i, int i2) {
        this.O000o0O.measureComponent(i, i2);
    }

    public final int getComMeasuredWidth() {
        return this.O000o0O.getComMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return this.O000o0O.getComMeasuredHeight();
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        this.O000o0O.comLayout(i, i2, i3, i4);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqg(vafContext, dpg);
        }
    }
}
