package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.ArrayList;
import java.util.List;

public class dpo extends dpd {
    private List<dpf> O000o00O = new ArrayList();

    public dpo(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public void onComMeasure(int i, int i2) {
        int O000OO00;
        if (this.O000O0o0 > 0) {
            int i3 = this.O000O0o0;
            if (i3 != 1) {
                if (i3 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O000O0o) / this.O000O0oO), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O000O0oO) / this.O000O0o), 1073741824);
            }
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.O000o00O.clear();
        int size3 = this.f14825O000000o.size();
        for (int i4 = 0; i4 < size3; i4++) {
            dpf dpf = (dpf) this.f14825O000000o.get(i4);
            if (!dpf.O0000oo()) {
                dpd.O000000o O000O0oo = dpf.O000O0oo();
                if ((1073741824 != mode2 && -1 == O000O0oo.O00000Oo) || (1073741824 != mode && -1 == O000O0oo.f14826O000000o)) {
                    this.O000o00O.add(dpf);
                }
                O000000o(dpf, i, i2);
            }
        }
        if (Integer.MIN_VALUE == mode) {
            int size4 = this.f14825O000000o.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size4; i6++) {
                dpf dpf2 = (dpf) this.f14825O000000o.get(i6);
                if (!dpf2.O0000oo() && (O000OO00 = dpf2.O000OO00()) > i5) {
                    i5 = O000OO00;
                }
            }
            size = Math.min(size, i5 + this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1));
        } else if (1073741824 != mode) {
            Log.e("FrameLayout_TMTEST", "getRealWidth error mode:".concat(String.valueOf(mode)));
        }
        O00000o(size, O0000OOo(mode2, size2));
        if (this.O000o00O.size() > 0) {
            int size5 = this.O000o00O.size();
            for (int i7 = 0; i7 < size5; i7++) {
                O000000o(this.O000o00O.get(i7), View.MeasureSpec.makeMeasureSpec(this.O000OOo0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.O000OOo, 1073741824));
            }
        }
    }

    private int O0000OOo(int i, int i2) {
        int O000OO0o;
        int O000OO0o2;
        int i3 = 0;
        if (Integer.MIN_VALUE == i) {
            int size = this.f14825O000000o.size();
            int i4 = 0;
            while (i3 < size) {
                dpf dpf = (dpf) this.f14825O000000o.get(i3);
                if (!dpf.O0000oo() && (O000OO0o2 = dpf.O000OO0o()) > i4) {
                    i4 = O000OO0o2;
                }
                i3++;
            }
            return Math.min(i2, i4 + this.O000OO0o + this.O000OO + (this.O0000o0 << 1));
        } else if (1073741824 == i) {
            return i2;
        } else {
            int size2 = this.f14825O000000o.size();
            int i5 = 0;
            while (i3 < size2) {
                dpf dpf2 = (dpf) this.f14825O000000o.get(i3);
                if (!dpf2.O0000oo() && (O000OO0o = dpf2.O000OO0o()) > i5) {
                    i5 = O000OO0o;
                }
                i3++;
            }
            return i5 + this.O000OO0o + this.O000OO + (this.O0000o0 << 1);
        }
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int size = this.f14825O000000o.size();
        for (int i7 = 0; i7 < size; i7++) {
            dpf dpf = (dpf) this.f14825O000000o.get(i7);
            if (!dpf.O0000oo()) {
                int comMeasuredWidth = dpf.getComMeasuredWidth();
                int comMeasuredHeight = dpf.getComMeasuredHeight();
                O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                if ((o00000Oo.O0000Ooo & 4) != 0) {
                    i5 = ((i3 + i) - comMeasuredWidth) >> 1;
                } else if ((o00000Oo.O0000Ooo & 2) != 0) {
                    i5 = (((i3 - this.O000OO00) - o00000Oo.O00000oo) - comMeasuredWidth) - this.O0000o0;
                } else {
                    i5 = this.O000O0oo + i + o00000Oo.O00000o + this.O0000o0;
                }
                if ((o00000Oo.O0000Ooo & 32) != 0) {
                    i6 = ((i4 + i2) - comMeasuredHeight) >> 1;
                } else if ((o00000Oo.O0000Ooo & 16) != 0) {
                    i6 = (((i4 - comMeasuredHeight) - this.O000OO) - o00000Oo.O0000Oo) - this.O0000o0;
                } else {
                    i6 = this.O0000o0 + this.O000OO0o + i2 + o00000Oo.O0000OOo;
                }
                int O000000o2 = dos.O000000o(O000OOo0(), i, O0000ooo(), i5, comMeasuredWidth);
                dpf.comLayout(O000000o2, i6, comMeasuredWidth + O000000o2, comMeasuredHeight + i6);
            }
        }
    }

    public static class O00000Oo extends dpd.O000000o {
        public int O0000Ooo;

        public final boolean O00000Oo(int i, int i2) {
            boolean O00000Oo = super.O00000Oo(i, i2);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i != 516361156) {
                return false;
            }
            this.O0000Ooo = i2;
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpo(vafContext, dpg);
        }
    }

    public final /* synthetic */ dpd.O000000o O000000o() {
        return new O00000Oo();
    }
}
