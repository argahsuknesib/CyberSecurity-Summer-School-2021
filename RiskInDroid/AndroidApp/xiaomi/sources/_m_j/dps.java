package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public class dps extends dpd {
    protected int O000o0;
    public int O000o00O = 1;
    protected int O000o00o;

    public dps(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    /* renamed from: O000OOo */
    public O00000Oo O000000o() {
        return new O00000Oo();
    }

    private int O000OOoO() {
        if (this.O000o00o <= 0) {
            this.O000o00o = 0;
            int size = this.f14825O000000o.size();
            for (int i = 0; i < size; i++) {
                this.O000o00o += ((dpf) this.f14825O000000o.get(i)).O000OO00();
            }
        }
        return this.O000o00o;
    }

    private int O000OOoo() {
        if (this.O000o0 <= 0) {
            this.O000o0 = 0;
            int size = this.f14825O000000o.size();
            for (int i = 0; i < size; i++) {
                this.O000o0 += ((dpf) this.f14825O000000o.get(i)).O000OO0o();
            }
        }
        return this.O000o0;
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.O000o00O;
        int i10 = 0;
        if (i9 == 0) {
            if ((this.O000OOOo & 8) != 0) {
                i5 = i2 + this.O000OO0o + this.O0000o0;
            } else if ((this.O000OOOo & 32) != 0) {
                i5 = ((i4 + i2) - O000OOoo()) >> 1;
            } else {
                i5 = ((i4 - O000OOoo()) - this.O000OO) - this.O0000o0;
            }
            int size = this.f14825O000000o.size();
            while (i10 < size) {
                dpf dpf = (dpf) this.f14825O000000o.get(i10);
                if (!dpf.O0000oo()) {
                    O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                    int comMeasuredWidth = dpf.getComMeasuredWidth();
                    int comMeasuredHeight = dpf.getComMeasuredHeight();
                    int i11 = i5 + o00000Oo.O0000OOo;
                    if ((o00000Oo.O0000o00 & 4) != 0) {
                        i6 = ((i3 + i) - comMeasuredWidth) >> 1;
                    } else if ((o00000Oo.O0000o00 & 2) != 0) {
                        i6 = (((i3 - this.O000OO00) - this.O0000o0) - o00000Oo.O00000oo) - comMeasuredWidth;
                    } else {
                        i6 = this.O000O0oo + i + this.O0000o0 + o00000Oo.O00000o;
                    }
                    int O000000o2 = dos.O000000o(O000OOo0(), i, O0000ooo(), i6, comMeasuredWidth);
                    dpf.comLayout(O000000o2, i11, comMeasuredWidth + O000000o2, i11 + comMeasuredHeight);
                    i5 = i11 + comMeasuredHeight + o00000Oo.O0000Oo;
                }
                i10++;
            }
        } else if (i9 == 1) {
            if ((this.O000OOOo & 1) != 0) {
                i7 = this.O000O0oo + i + this.O0000o0;
            } else if ((this.O000OOOo & 4) != 0) {
                i7 = ((i3 - i) - O000OOoO()) >> 1;
            } else {
                i7 = ((i3 - O000OOoO()) - this.O000OO00) - this.O0000o0;
            }
            int size2 = this.f14825O000000o.size();
            while (i10 < size2) {
                dpf dpf2 = (dpf) this.f14825O000000o.get(i10);
                if (!dpf2.O0000oo()) {
                    O00000Oo o00000Oo2 = (O00000Oo) dpf2.O000O0oo();
                    int comMeasuredWidth2 = dpf2.getComMeasuredWidth();
                    int comMeasuredHeight2 = dpf2.getComMeasuredHeight();
                    int i12 = i7 + o00000Oo2.O00000o;
                    if ((o00000Oo2.O0000o00 & 32) != 0) {
                        i8 = ((i4 + i2) - comMeasuredHeight2) >> 1;
                    } else if ((o00000Oo2.O0000o00 & 16) != 0) {
                        i8 = (((i4 - comMeasuredHeight2) - this.O000OO) - this.O0000o0) - o00000Oo2.O0000Oo;
                    } else {
                        i8 = this.O000OO0o + i2 + this.O0000o0 + o00000Oo2.O0000OOo;
                    }
                    int O000000o3 = dos.O000000o(O000OOo0(), i, O0000ooo(), i12, comMeasuredWidth2);
                    dpf2.comLayout(O000000o3, i8, O000000o3 + comMeasuredWidth2, comMeasuredHeight2 + i8);
                    i7 = i12 + comMeasuredWidth2 + o00000Oo2.O00000oo;
                }
                i10++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    public void onComMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        this.O000o00o = 0;
        this.O000o0 = 0;
        if (this.O000O0o0 > 0) {
            int i6 = this.O000O0o0;
            if (i6 != 1) {
                if (i6 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i4 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O000O0o) / this.O000O0oO), 1073741824);
                    i3 = i2;
                    i5 = this.O000o00O;
                    if (i5 == 0) {
                        int size = View.MeasureSpec.getSize(i4);
                        int size2 = View.MeasureSpec.getSize(i3);
                        int mode = View.MeasureSpec.getMode(i4);
                        int mode2 = View.MeasureSpec.getMode(i3);
                        int size3 = this.f14825O000000o.size();
                        boolean z = false;
                        for (int i7 = 0; i7 < size3; i7++) {
                            dpf dpf = (dpf) this.f14825O000000o.get(i7);
                            if (!dpf.O0000oo()) {
                                O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                                if (1073741824 != mode && -1 == o00000Oo.f14826O000000o) {
                                    z = true;
                                }
                                O000000o(dpf, i4, i3);
                            }
                        }
                        O00000o(O0000OOo(mode, size), O0000Oo0(mode2, size2));
                        if (z) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
                            int size4 = this.f14825O000000o.size();
                            for (int i8 = 0; i8 < size4; i8++) {
                                dpf dpf2 = (dpf) this.f14825O000000o.get(i8);
                                if (!dpf2.O0000oo() && -1 == dpf2.O000O0oo().f14826O000000o) {
                                    O000000o(dpf2, makeMeasureSpec, i3);
                                }
                            }
                            return;
                        }
                        return;
                    } else if (i5 == 1) {
                        int size5 = View.MeasureSpec.getSize(i4);
                        int size6 = View.MeasureSpec.getSize(i3);
                        int mode3 = View.MeasureSpec.getMode(i4);
                        int mode4 = View.MeasureSpec.getMode(i3);
                        int size7 = this.f14825O000000o.size();
                        boolean z2 = false;
                        int i9 = 0;
                        for (int i10 = 0; i10 < size7; i10++) {
                            dpf dpf3 = (dpf) this.f14825O000000o.get(i10);
                            if (!dpf3.O0000oo()) {
                                dpd.O000000o O000O0oo = dpf3.O000O0oo();
                                if (1073741824 != mode4 && -1 == O000O0oo.O00000Oo) {
                                    z2 = true;
                                }
                                if (mode3 != 0) {
                                    O000000o(dpf3, View.MeasureSpec.makeMeasureSpec(size5 - i9, 1073741824), i3);
                                } else {
                                    O000000o(dpf3, i4, i3);
                                }
                                i9 += dpf3.O000OO00();
                            }
                        }
                        O00000o(O0000OOo(mode3, size5), O0000Oo0(mode4, size6));
                        if (z2) {
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
                            int size8 = this.f14825O000000o.size();
                            for (int i11 = 0; i11 < size8; i11++) {
                                dpf dpf4 = (dpf) this.f14825O000000o.get(i11);
                                if (!dpf4.O0000oo() && -1 == dpf4.O000O0oo().O00000Oo) {
                                    O000000o(dpf4, i4, makeMeasureSpec2);
                                }
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O000O0oO) / this.O000O0o), 1073741824);
                i4 = i;
                i5 = this.O000o00O;
                if (i5 == 0) {
                }
            }
        }
        i4 = i;
        i3 = i2;
        i5 = this.O000o00O;
        if (i5 == 0) {
        }
    }

    private int O0000OOo(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int O000OO00;
        if (Integer.MIN_VALUE == i) {
            int i6 = this.O000o00O;
            int i7 = 0;
            if (1 == i6) {
                int size = this.f14825O000000o.size();
                i3 = 0;
                while (i7 < size) {
                    dpf dpf = (dpf) this.f14825O000000o.get(i7);
                    if (!dpf.O0000oo()) {
                        i3 += dpf.O000OO00();
                    }
                    i7++;
                }
                this.O000o00o = i3;
                i4 = this.O000O0oo + this.O000OO00;
                i5 = this.O0000o0;
            } else {
                if (i6 == 0) {
                    int size2 = this.f14825O000000o.size();
                    i3 = 0;
                    while (i7 < size2) {
                        dpf dpf2 = (dpf) this.f14825O000000o.get(i7);
                        if (!dpf2.O0000oo() && (O000OO00 = dpf2.O000OO00()) > i3) {
                            i3 = O000OO00;
                        }
                        i7++;
                    }
                    this.O000o00o = i3;
                    i4 = this.O000O0oo + this.O000OO00;
                    i5 = this.O0000o0;
                }
                return Math.min(i2, i7);
            }
            i7 = i3 + i4 + (i5 << 1);
            return Math.min(i2, i7);
        } else if (1073741824 == i) {
            return i2;
        } else {
            Log.e("VHLayout_TMTEST", "getRealWidth error mode:".concat(String.valueOf(i)));
            return i2;
        }
    }

    private int O0000Oo0(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int O000OO0o;
        int i6;
        int i7;
        int i8;
        int O000OO0o2;
        int i9 = 0;
        if (Integer.MIN_VALUE == i) {
            int i10 = this.O000o00O;
            if (1 == i10) {
                int size = this.f14825O000000o.size();
                i6 = 0;
                while (i9 < size) {
                    dpf dpf = (dpf) this.f14825O000000o.get(i9);
                    if (!dpf.O0000oo() && (O000OO0o2 = dpf.O000OO0o()) > i6) {
                        i6 = O000OO0o2;
                    }
                    i9++;
                }
                this.O000o0 = i6;
                i7 = this.O000OO0o + this.O000OO;
                i8 = this.O0000o0;
            } else {
                if (i10 == 0) {
                    int size2 = this.f14825O000000o.size();
                    i6 = 0;
                    while (i9 < size2) {
                        dpf dpf2 = (dpf) this.f14825O000000o.get(i9);
                        if (!dpf2.O0000oo()) {
                            i6 += dpf2.O000OO0o();
                        }
                        i9++;
                    }
                    this.O000o0 = i6;
                    i7 = this.O000OO0o + this.O000OO;
                    i8 = this.O0000o0;
                }
                return Math.min(i2, i9);
            }
            i9 = i6 + i7 + (i8 << 1);
            return Math.min(i2, i9);
        } else if (1073741824 == i) {
            return i2;
        } else {
            int i11 = this.O000o00O;
            if (1 == i11) {
                int size3 = this.f14825O000000o.size();
                i3 = 0;
                while (i9 < size3) {
                    dpf dpf3 = (dpf) this.f14825O000000o.get(i9);
                    if (!dpf3.O0000oo() && (O000OO0o = dpf3.O000OO0o()) > i3) {
                        i3 = O000OO0o;
                    }
                    i9++;
                }
                this.O000o0 = i3;
                i4 = this.O000OO0o + this.O000OO;
                i5 = this.O0000o0;
            } else if (i11 != 0) {
                return 0;
            } else {
                int size4 = this.f14825O000000o.size();
                i3 = 0;
                while (i9 < size4) {
                    dpf dpf4 = (dpf) this.f14825O000000o.get(i9);
                    if (!dpf4.O0000oo()) {
                        i3 += dpf4.O000OO0o();
                    }
                    i9++;
                }
                this.O000o0 = i3;
                i4 = this.O000OO0o + this.O000OO;
                i5 = this.O0000o0;
            }
            return i3 + i4 + (i5 << 1);
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        if (i != -1439500848) {
            return false;
        }
        this.O000o00O = i2;
        return true;
    }

    public static class O00000Oo extends dpd.O000000o {
        public int O0000o00;

        public boolean O00000Oo(int i, int i2) {
            boolean O00000Oo = super.O00000Oo(i, i2);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i != 516361156) {
                return false;
            }
            this.O0000o00 = i2;
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dps(vafContext, dpg);
        }
    }
}
