package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public class dpq extends dpd {
    protected int O000o0 = 0;
    protected int O000o00O = 1;
    protected int O000o00o = 0;
    protected int O000o0O;
    protected int O000o0O0;

    public dpq(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0102  */
    public void onComMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
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
                        this.O000o0O = 0;
                        O000OOo();
                        int size3 = this.f14825O000000o.size();
                        boolean z = false;
                        for (int i7 = 0; i7 < size3; i7++) {
                            dpf dpf = (dpf) this.f14825O000000o.get(i7);
                            if (!dpf.O0000oo()) {
                                O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                                if ((1073741824 != mode && -1 == o00000Oo.f14826O000000o) || o00000Oo.O0000Ooo > 0.0f) {
                                    z = true;
                                }
                                O00000o0(dpf, i4, i3);
                                if (o00000Oo.O0000Ooo <= 0.0f) {
                                    this.O000o0O += dpf.O000OO0o();
                                } else {
                                    this.O000o0O += o00000Oo.O0000OOo + o00000Oo.O0000Oo;
                                }
                            }
                        }
                        O00000o(O0000OOo(mode, size), O0000Oo0(mode2, size2));
                        if (z) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
                            int size4 = this.f14825O000000o.size();
                            for (int i8 = 0; i8 < size4; i8++) {
                                dpf dpf2 = (dpf) this.f14825O000000o.get(i8);
                                if (!dpf2.O0000oo()) {
                                    O00000Oo o00000Oo2 = (O00000Oo) dpf2.O000O0oo();
                                    if (-1 == o00000Oo2.f14826O000000o || o00000Oo2.O0000Ooo > 0.0f) {
                                        O00000o0(dpf2, makeMeasureSpec, makeMeasureSpec2);
                                    }
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
                        this.O000o0O = 0;
                        O000OOo();
                        int size7 = this.f14825O000000o.size();
                        boolean z2 = false;
                        for (int i9 = 0; i9 < size7; i9++) {
                            dpf dpf3 = (dpf) this.f14825O000000o.get(i9);
                            if (!dpf3.O0000oo()) {
                                O00000Oo o00000Oo3 = (O00000Oo) dpf3.O000O0oo();
                                if ((1073741824 != mode4 && -1 == o00000Oo3.O00000Oo) || o00000Oo3.O0000Ooo > 0.0f) {
                                    z2 = true;
                                }
                                O00000Oo(dpf3, i4, i3);
                                if (o00000Oo3.O0000Ooo <= 0.0f) {
                                    this.O000o0O += dpf3.O000OO00();
                                } else {
                                    this.O000o0O += o00000Oo3.O00000o + o00000Oo3.O00000oo;
                                }
                            }
                        }
                        O00000o(O0000OOo(mode3, size5), O0000Oo0(mode4, size6));
                        if (z2) {
                            int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
                            int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
                            int size8 = this.f14825O000000o.size();
                            for (int i10 = 0; i10 < size8; i10++) {
                                dpf dpf4 = (dpf) this.f14825O000000o.get(i10);
                                if (!dpf4.O0000oo()) {
                                    O00000Oo o00000Oo4 = (O00000Oo) dpf4.O000O0oo();
                                    if (-1 == o00000Oo4.O00000Oo || o00000Oo4.O0000Ooo > 0.0f) {
                                        O00000Oo(dpf4, makeMeasureSpec3, makeMeasureSpec4);
                                    }
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

    private void O00000Oo(dpf dpf, int i, int i2) {
        int i3;
        O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
        int O000000o2 = O000000o(i2, this.O000OO0o + this.O000OO + (this.O0000o0 << 1) + o00000Oo.O0000OOo + o00000Oo.O0000Oo, o00000Oo.O00000Oo);
        if (o00000Oo.O0000Ooo > 0.0f) {
            i3 = O000000o(i, this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1), o00000Oo.f14826O000000o, o00000Oo.O0000Ooo);
        } else {
            i3 = O000000o(i, this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1) + o00000Oo.O00000o + o00000Oo.O00000oo, o00000Oo.f14826O000000o);
        }
        dpf.measureComponent(i3, O000000o2);
    }

    private void O00000o0(dpf dpf, int i, int i2) {
        int i3;
        O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
        int O000000o2 = O000000o(i, this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1) + o00000Oo.O00000o + o00000Oo.O00000oo, o00000Oo.f14826O000000o);
        if (o00000Oo.O0000Ooo > 0.0f) {
            i3 = O000000o(i2, this.O000OO0o + this.O000OO + (this.O0000o0 << 1), o00000Oo.O00000Oo, o00000Oo.O0000Ooo);
        } else {
            i3 = O000000o(i2, this.O000OO0o + this.O000OO + (this.O0000o0 << 1) + o00000Oo.O0000OOo + o00000Oo.O0000Oo, o00000Oo.O00000Oo);
        }
        dpf.measureComponent(O000000o2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (r5 >= 0) goto L_0x002e;
     */
    private int O000000o(int i, int i2, int i3, float f) {
        int mode = View.MeasureSpec.getMode(i);
        int max = Math.max(0, (View.MeasureSpec.getSize(i) - i2) - this.O000o0O);
        int i4 = 1073741824;
        if (mode == 1073741824) {
            if (f > 0.0f) {
                int i5 = (int) ((f * ((float) max)) / ((float) this.O000o0O0));
                i3 = i5 < 0 ? 0 : i5;
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i4);
        }
        i3 = 0;
        i4 = 0;
        return View.MeasureSpec.makeMeasureSpec(i3, i4);
    }

    private void O000OOo() {
        this.O000o0O0 = 0;
        int size = this.f14825O000000o.size();
        for (int i = 0; i < size; i++) {
            dpf dpf = (dpf) this.f14825O000000o.get(i);
            if (!dpf.O0000oo()) {
                this.O000o0O0 = (int) (((float) this.O000o0O0) + ((O00000Oo) dpf.O000O0oo()).O0000Ooo);
            }
        }
    }

    private int O0000OOo(int i, int i2) {
        int O000OO00;
        if (Integer.MIN_VALUE == i) {
            int i3 = this.O000o00O;
            if (1 == i3 || i3 != 0) {
                return i2;
            }
            int size = this.f14825O000000o.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                dpf dpf = (dpf) this.f14825O000000o.get(i5);
                if (!dpf.O0000oo() && (O000OO00 = dpf.O000OO00()) > i4) {
                    i4 = O000OO00;
                }
            }
            this.O000o00o = i4;
            return Math.min(i2, i4 + this.O000O0oo + this.O000OO00 + (this.O0000o0 << 1));
        } else if (1073741824 == i) {
            return i2;
        } else {
            Log.e("RatioLayout_TMTEST", "getRealWidth error mode:".concat(String.valueOf(i)));
            return i2;
        }
    }

    private int O0000Oo0(int i, int i2) {
        int i3;
        int O000OO0o;
        int O000OO0o2;
        int i4 = 0;
        if (Integer.MIN_VALUE == i) {
            if (1 != this.O000o00O) {
                return i2;
            }
            int size = this.f14825O000000o.size();
            int i5 = 0;
            while (i4 < size) {
                dpf dpf = (dpf) this.f14825O000000o.get(i4);
                if (!dpf.O0000oo() && (O000OO0o2 = dpf.O000OO0o()) > i5) {
                    i5 = O000OO0o2;
                }
                i4++;
            }
            this.O000o0 = i5;
            return Math.min(i2, i5 + this.O000OO0o + this.O000OO + (this.O0000o0 << 1));
        } else if (1073741824 == i) {
            return i2;
        } else {
            int i6 = this.O000o00O;
            if (1 == i6) {
                int size2 = this.f14825O000000o.size();
                i3 = 0;
                while (i4 < size2) {
                    dpf dpf2 = (dpf) this.f14825O000000o.get(i4);
                    if (!dpf2.O0000oo() && (O000OO0o = dpf2.O000OO0o()) > i3) {
                        i3 = O000OO0o;
                    }
                    i4++;
                }
                this.O000o0 = i3;
            } else if (i6 != 0) {
                return i2;
            } else {
                int size3 = this.f14825O000000o.size();
                i3 = 0;
                while (i4 < size3) {
                    dpf dpf3 = (dpf) this.f14825O000000o.get(i4);
                    if (!dpf3.O0000oo()) {
                        i3 += dpf3.O000OO0o();
                    }
                    i4++;
                }
            }
            return i3 + this.O000OO0o + this.O000OO + (this.O0000o0 << 1);
        }
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = this.O000o00O;
        int i8 = 0;
        if (i7 == 0) {
            int i9 = i2 + this.O000OO0o + this.O0000o0;
            int size = this.f14825O000000o.size();
            while (i8 < size) {
                dpf dpf = (dpf) this.f14825O000000o.get(i8);
                if (!dpf.O0000oo()) {
                    O00000Oo o00000Oo = (O00000Oo) dpf.O000O0oo();
                    int comMeasuredWidth = dpf.getComMeasuredWidth();
                    int comMeasuredHeight = dpf.getComMeasuredHeight();
                    int i10 = i9 + o00000Oo.O0000OOo;
                    if ((o00000Oo.O0000o00 & 4) != 0) {
                        i5 = ((i3 + i) - comMeasuredWidth) >> 1;
                    } else if ((o00000Oo.O0000o00 & 2) != 0) {
                        i5 = (((i3 - this.O000OO00) - this.O0000o0) - o00000Oo.O00000oo) - comMeasuredWidth;
                    } else {
                        i5 = this.O000O0oo + i + this.O0000o0 + o00000Oo.O00000o;
                    }
                    int O000000o2 = dos.O000000o(O000OOo0(), i, O0000ooo(), i5, comMeasuredWidth);
                    dpf.comLayout(O000000o2, i10, comMeasuredWidth + O000000o2, i10 + comMeasuredHeight);
                    i9 = i10 + comMeasuredHeight + o00000Oo.O0000Oo;
                }
                i8++;
            }
        } else if (i7 == 1) {
            int i11 = this.O000O0oo + i + this.O0000o0;
            int size2 = this.f14825O000000o.size();
            while (i8 < size2) {
                dpf dpf2 = (dpf) this.f14825O000000o.get(i8);
                if (!dpf2.O0000oo()) {
                    O00000Oo o00000Oo2 = (O00000Oo) dpf2.O000O0oo();
                    int comMeasuredWidth2 = dpf2.getComMeasuredWidth();
                    int comMeasuredHeight2 = dpf2.getComMeasuredHeight();
                    int i12 = i11 + o00000Oo2.O00000o;
                    if ((o00000Oo2.O0000o00 & 32) != 0) {
                        i6 = ((i4 + i2) - comMeasuredHeight2) >> 1;
                    } else if ((o00000Oo2.O0000o00 & 16) != 0) {
                        i6 = (((i4 - comMeasuredHeight2) - this.O000OO) - this.O0000o0) - o00000Oo2.O0000Oo;
                    } else {
                        i6 = this.O000OO0o + i2 + this.O0000o0 + o00000Oo2.O0000OOo;
                    }
                    int O000000o3 = dos.O000000o(O000OOo0(), i, O0000ooo(), i12, comMeasuredWidth2);
                    dpf2.comLayout(O000000o3, i6, O000000o3 + comMeasuredWidth2, comMeasuredHeight2 + i6);
                    i11 = i12 + comMeasuredWidth2 + o00000Oo2.O00000oo;
                }
                i8++;
            }
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
        public float O0000Ooo = 0.0f;
        public int O0000o00;

        public final boolean O00000Oo(int i, float f) {
            boolean O00000Oo = super.O00000Oo(i, f);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i != 1999032065) {
                return false;
            }
            this.O0000Ooo = f;
            return true;
        }

        public final boolean O00000Oo(int i, int i2) {
            boolean O00000Oo = super.O00000Oo(i, i2);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i == 516361156) {
                this.O0000o00 = i2;
                return true;
            } else if (i != 1999032065) {
                return false;
            } else {
                this.O0000Ooo = (float) i2;
                return true;
            }
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpq(vafContext, dpg);
        }
    }

    public final /* synthetic */ dpd.O000000o O000000o() {
        return new O00000Oo();
    }
}
