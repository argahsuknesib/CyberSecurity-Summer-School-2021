package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public class dpp extends dpd {
    protected int O000o0 = -1;
    protected int O000o00O = 1;
    protected int O000o00o;
    protected int O000o0O = 0;
    protected int O000o0O0 = 0;

    public dpp(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public void onComMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.O000O0o0 > 0) {
            int i7 = this.O000O0o0;
            if (i7 != 1) {
                if (i7 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
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
        int i8 = this.O000O0oo + this.O000OO00;
        int i9 = this.O000o0O0;
        int i10 = this.O000o00O;
        this.O000o00o = (size - (i8 + (i9 * (i10 - 1)))) / i10;
        int size3 = this.f14825O000000o.size();
        for (int i11 = 0; i11 < size3; i11++) {
            dpf dpf = (dpf) this.f14825O000000o.get(i11);
            if (!dpf.O0000oo()) {
                if (this.O000o0 > 0) {
                    dpf.measureComponent(View.MeasureSpec.makeMeasureSpec(this.O000o00o, 1073741824), View.MeasureSpec.makeMeasureSpec(this.O000o0, 1073741824));
                } else {
                    dpd.O000000o O000O0oo = dpf.O000O0oo();
                    dpf.measureComponent(View.MeasureSpec.makeMeasureSpec(this.O000o00o, 1073741824), dpd.O000000o(i2, this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1) + O000O0oo.O00000o + O000O0oo.O00000oo, O000O0oo.O00000Oo));
                }
            }
        }
        if (Integer.MIN_VALUE == mode) {
            int i12 = this.O000O0oo + this.O000OO00;
            int size4 = this.f14825O000000o.size();
            int i13 = i12;
            int i14 = 0;
            for (int i15 = 0; i15 < size4; i15++) {
                i13 += ((dpf) this.f14825O000000o.get(i15)).O000OO00();
                i14++;
                if (i14 >= this.O000o00O) {
                    break;
                }
                i13 += this.O000o0O0;
            }
            size = Math.min(size, i13);
        } else if (1073741824 != mode) {
            Log.e("GridLayout_TMTEST", "getRealWidth error mode:".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            if (this.f14825O000000o.size() > 0) {
                int size5 = this.f14825O000000o.size();
                int i16 = this.O000o00O;
                int i17 = (size5 / i16) + (size5 % i16 > 0 ? 1 : 0);
                int i18 = this.O000o0;
                if (i18 > 0) {
                    i4 = (i18 * i17) + this.O000OO0o + this.O000OO;
                    i5 = i17 - 1;
                    i6 = this.O000o0O;
                } else {
                    i4 = (((dpf) this.f14825O000000o.get(0)).getComMeasuredHeight() * i17) + this.O000OO0o + this.O000OO;
                    i5 = i17 - 1;
                    i6 = this.O000o0O;
                }
                i3 = i4 + (i5 * i6);
            } else {
                i3 = 0;
            }
            if (Integer.MIN_VALUE == mode2) {
                size2 = Math.min(size2, i3);
            } else {
                size2 = i3;
            }
        }
        O00000o(size, size2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i;
        if (this.f14825O000000o.size() > 0) {
            int i7 = this.O000O0oo + i6;
            int i8 = i2 + this.O000OO0o;
            int size = this.f14825O000000o.size();
            dpf dpf = (dpf) this.f14825O000000o.get(0);
            getComMeasuredWidth();
            int comMeasuredWidth = dpf.getComMeasuredWidth();
            int comMeasuredHeight = dpf.getComMeasuredHeight();
            int i9 = this.O000o00O;
            int i10 = (size / i9) + (size % i9 > 0 ? 1 : 0);
            int i11 = i8;
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10) {
                int i14 = i7;
                int i15 = i13;
                int i16 = 0;
                while (i16 < this.O000o00O && i15 < size) {
                    int i17 = i15 + 1;
                    dpf dpf2 = (dpf) this.f14825O000000o.get(i15);
                    if (!dpf2.O0000oo()) {
                        int O000000o2 = dos.O000000o(O000OOo0(), i6, O0000ooo(), i14, comMeasuredWidth);
                        dpf2.comLayout(O000000o2, i11, O000000o2 + comMeasuredWidth, i11 + comMeasuredHeight);
                        i14 += this.O000o0O0 + comMeasuredWidth;
                    }
                    i16++;
                    i15 = i17;
                }
                int i18 = this.O000o0;
                if (i18 > 0) {
                    i5 = i18 + this.O000o0O;
                } else {
                    i5 = this.O000o0O + comMeasuredHeight;
                }
                i11 += i5;
                i12++;
                i13 = i15;
            }
        }
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 196203191) {
            this.O000o0O = bns.O00000Oo((double) f);
            return true;
        } else if (i == 1671241242) {
            this.O000o0 = bns.O00000Oo((double) Math.round(f));
            return true;
        } else if (i != 2129234981) {
            return false;
        } else {
            this.O000o0O0 = bns.O00000Oo((double) f);
            return true;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case -669528209:
                this.O000o00O = i2;
                return true;
            case 196203191:
                this.O000o0O = bns.O00000Oo((double) i2);
                return true;
            case 1671241242:
                this.O000o0 = bns.O00000Oo((double) i2);
                return true;
            case 2129234981:
                this.O000o0O0 = bns.O00000Oo((double) i2);
                return true;
            default:
                return false;
        }
    }

    public final boolean O000000o(int i, String str) {
        if (i == 196203191) {
            this.O00000Oo.O000000o(this, 196203191, str, 1);
            return true;
        } else if (i != 2129234981) {
            return super.O000000o(i, str);
        } else {
            this.O00000Oo.O000000o(this, 2129234981, str, 1);
            return true;
        }
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i == 196203191) {
            this.O000o0O = bns.O000000o((double) f);
            return true;
        } else if (i == 1671241242) {
            this.O000o0 = bns.O000000o((double) f);
            return true;
        } else if (i != 2129234981) {
            return false;
        } else {
            this.O000o0O0 = bns.O000000o((double) f);
            return true;
        }
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 196203191) {
            this.O000o0O = bns.O000000o((double) i2);
            return true;
        } else if (i == 1671241242) {
            this.O000o0 = bns.O000000o((double) i2);
            return true;
        } else if (i != 2129234981) {
            return false;
        } else {
            this.O000o0O0 = bns.O000000o((double) i2);
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpp(vafContext, dpg);
        }
    }
}
