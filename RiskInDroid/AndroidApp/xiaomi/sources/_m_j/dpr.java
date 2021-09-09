package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import _m_j.dps;
import android.util.Log;
import com.tmall.wireless.vaf.framework.VafContext;

public class dpr extends dps {
    public dpr(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = this.O000o00O;
        int i9 = 0;
        if (i8 == 0) {
            int i10 = i2 + this.O000OO0o;
            int i11 = i4 - this.O000OO;
            int size = this.f14825O000000o.size();
            int i12 = 0;
            while (i9 < size) {
                dpf dpf = (dpf) this.f14825O000000o.get(i9);
                if (!dpf.O0000oo()) {
                    O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                    int comMeasuredWidth = dpf.getComMeasuredWidth();
                    int comMeasuredHeight = dpf.getComMeasuredHeight();
                    if ((o00000Oo.O0000Ooo & 2) != 0) {
                        i12 = o00000Oo.O0000OOo + i10;
                        i10 = o00000Oo.O0000Oo + comMeasuredHeight + i12;
                    } else if ((o00000Oo.O0000Ooo & 8) != 0) {
                        i12 = i11 - (o00000Oo.O0000Oo + comMeasuredHeight);
                        i11 = i12 - o00000Oo.O0000OOo;
                    } else {
                        Log.e("VH2Layout_TMTEST", "onComLayout VERTICAL direction invalidate:" + o00000Oo.O0000Ooo);
                    }
                    if ((o00000Oo.O0000o00 & 4) != 0) {
                        i5 = ((i3 + i7) - comMeasuredWidth) >> 1;
                    } else if ((o00000Oo.O0000o00 & 2) != 0) {
                        i5 = ((i3 - this.O000OO00) - o00000Oo.O00000oo) - comMeasuredWidth;
                    } else {
                        i5 = o00000Oo.O00000o + this.O000O0oo + i7;
                    }
                    int O000000o2 = dos.O000000o(O000OOo0(), i7, O0000ooo(), i5, comMeasuredWidth);
                    dpf.comLayout(O000000o2, i12, comMeasuredWidth + O000000o2, comMeasuredHeight + i12);
                }
                i9++;
            }
        } else if (i8 == 1) {
            int i13 = this.O000O0oo + i7;
            int i14 = i3 - this.O000OO00;
            int size2 = this.f14825O000000o.size();
            int i15 = 0;
            while (i9 < size2) {
                dpf dpf2 = (dpf) this.f14825O000000o.get(i9);
                if (!dpf2.O0000oo()) {
                    O00000Oo o00000Oo2 = (O00000Oo) dpf2.O000O0oo();
                    int comMeasuredWidth2 = dpf2.getComMeasuredWidth();
                    int comMeasuredHeight2 = dpf2.getComMeasuredHeight();
                    if ((o00000Oo2.O0000Ooo & 1) != 0) {
                        i15 = o00000Oo2.O00000o + i13;
                        i13 = o00000Oo2.O00000oo + comMeasuredWidth2 + i15;
                    } else if ((o00000Oo2.O0000Ooo & 4) != 0) {
                        i15 = i14 - (o00000Oo2.O00000oo + comMeasuredWidth2);
                        i14 = i15 - o00000Oo2.O00000o;
                    } else {
                        Log.e("VH2Layout_TMTEST", "onComLayout HORIZONTAL direction invalidate:" + o00000Oo2.O0000Ooo);
                    }
                    if ((o00000Oo2.O0000o00 & 32) != 0) {
                        i6 = ((i4 + i2) - comMeasuredHeight2) >> 1;
                    } else if ((o00000Oo2.O0000o00 & 16) != 0) {
                        i6 = ((i4 - comMeasuredHeight2) - this.O000OO) - o00000Oo2.O0000Oo;
                    } else {
                        i6 = o00000Oo2.O0000OOo + i2 + this.O000OO0o;
                    }
                    int O000000o3 = dos.O000000o(O000OOo0(), i7, O0000ooo(), i15, comMeasuredWidth2);
                    dpf2.comLayout(O000000o3, i6, comMeasuredWidth2 + O000000o3, comMeasuredHeight2 + i6);
                }
                i9++;
            }
        }
    }

    public static class O00000Oo extends dps.O00000Oo {
        public int O0000Ooo = 1;

        public final boolean O00000Oo(int i, int i2) {
            boolean O00000Oo = super.O00000Oo(i, i2);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i != -1955718283) {
                return false;
            }
            this.O0000Ooo = i2;
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpr(vafContext, dpg);
        }
    }

    public final /* synthetic */ dps.O00000Oo O000OOo() {
        return new O00000Oo();
    }

    public final /* synthetic */ dpd.O000000o O000000o() {
        return new O00000Oo();
    }
}
