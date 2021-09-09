package _m_j;

import _m_j.dpf;
import _m_j.evc;
import android.text.TextUtils;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.xiaomi.shopviews.adapter.countdown.CountdownVirtualView;

public final class eva extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected CountdownVirtualView f15838O000000o;
    private int O000o;
    private int O000o0;
    private int O000o00O;
    private int O000o00o;
    private int O000o0O;
    private int O000o0O0;
    private int O000o0OO;
    private int O000o0Oo;
    private int O000o0o;
    private int O000o0o0;
    private int O000o0oo;
    private int O000oO;
    private int O000oO0;
    private int O000oO00;
    private int O000oO0O;
    private int O000oO0o;
    private int O000oOO;
    private int O000oOO0;
    private int O000oOOO;
    private int O000oOOo;
    private int O000oOo;
    private int O000oOo0;
    private int O000oOoO;
    private int O000oOoo;
    private int O000oo;
    private int O000oo0;
    private int O000oo0O;
    private int O000oo0o;
    private int O000ooO;
    private int O000ooO0;
    private int O000ooOO;
    private int O000ooOo;
    private int O000ooo;
    private int O000ooo0;
    private int O000oooO;
    private int O000oooo;
    private int O00O000o;
    private int O00O00Oo;
    private boolean O00O00o;
    private boolean O00O00o0;
    private int O00O00oO;
    private int O00O00oo;
    private int O00O0O0o;
    private int O00O0OO;
    private int O00O0OOo;
    private int O00O0Oo0;
    private int O00O0OoO;
    private boolean O00O0Ooo;
    private boolean O00O0o;
    private boolean O00O0o0;
    private boolean O00O0o00;
    private boolean O00O0o0O;
    private boolean O00O0o0o;
    private int O00O0oO0;
    private int O00O0oOO;
    private int O00O0oOo;
    private int O00oOOoo;
    private int oooOoO;

    public eva(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.f15838O000000o = new CountdownVirtualView(vafContext.O0000O0o());
        dpw O0000Oo0 = VafContext.O0000Oo0();
        this.O000o00O = O0000Oo0.O000000o("isHideTimeBackground");
        this.O000o00o = O0000Oo0.O000000o("isShowTimeBgDivisionLine");
        this.O000o0 = O0000Oo0.O000000o("timeBgDivisionLineColor");
        this.O000o0O0 = O0000Oo0.O000000o("timeBgDivisionLineSize");
        this.O000o0O = O0000Oo0.O000000o("timeBgColor");
        this.O000o0OO = O0000Oo0.O000000o("timeBgSize");
        this.O000o0Oo = O0000Oo0.O000000o("timeBgRadius");
        this.O000o0o0 = O0000Oo0.O000000o("isTimeTextBold");
        this.O000o0o = O0000Oo0.O000000o("timeTextSize");
        this.O000o0oo = O0000Oo0.O000000o("timeTextColor");
        this.O000o = O0000Oo0.O000000o("isShowDay");
        this.O000oO00 = O0000Oo0.O000000o("isShowHour");
        this.O000oO0 = O0000Oo0.O000000o("isShowMinute");
        this.O000oO0O = O0000Oo0.O000000o("isShowSecond");
        this.O000oO0o = O0000Oo0.O000000o("isShowMillisecond");
        this.O000oO = O0000Oo0.O000000o("isConvertDaysToHours");
        this.O000oOO0 = O0000Oo0.O000000o("isSuffixTextBold");
        this.O000oOO = O0000Oo0.O000000o("suffixTextSize");
        this.O000oOOO = O0000Oo0.O000000o("suffixTextColor");
        this.O000oOOo = O0000Oo0.O000000o("suffix");
        this.O000oOo0 = O0000Oo0.O000000o("suffixDay");
        this.O000oOo = O0000Oo0.O000000o("suffixHour");
        this.O000oOoO = O0000Oo0.O000000o("suffixMinute");
        this.O000oOoo = O0000Oo0.O000000o("suffixSecond");
        this.O000oo0 = O0000Oo0.O000000o("suffixMillisecond");
        this.O000oo0O = O0000Oo0.O000000o("suffixGravity");
        this.O000oo0o = O0000Oo0.O000000o("suffixLRMargin");
        this.O000oo = O0000Oo0.O000000o("suffixDayLeftMargin");
        this.O000ooO0 = O0000Oo0.O000000o("suffixDayRightMargin");
        this.O000ooO = O0000Oo0.O000000o("suffixHourLeftMargin");
        this.O000ooOO = O0000Oo0.O000000o("suffixHourRightMargin");
        this.O000ooOo = O0000Oo0.O000000o("suffixMinuteLeftMargin");
        this.O000ooo0 = O0000Oo0.O000000o("suffixMinuteRightMargin");
        this.O000ooo = O0000Oo0.O000000o("suffixSecondLeftMargin");
        this.O000oooO = O0000Oo0.O000000o("suffixSecondRightMargin");
        this.O000oooo = O0000Oo0.O000000o("suffixMillisecondLeftMargin");
        this.oooOoO = O0000Oo0.O000000o("isShowTimeBgBorder");
        this.O00oOOoo = O0000Oo0.O000000o("timeBgBorderColor");
        this.O00O000o = O0000Oo0.O000000o("timeBgBorderSize");
        this.O00O00Oo = O0000Oo0.O000000o("timeBgBorderRadius");
    }

    public final void onComMeasure(int i, int i2) {
        this.f15838O000000o.onComMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f15838O000000o.onComLayout(z, i, i2, i3, i4);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        this.f15838O000000o.comLayout(i, i2, i3, i4);
    }

    public final View g_() {
        return this.f15838O000000o;
    }

    public final int getComMeasuredWidth() {
        return this.f15838O000000o.getComMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return this.f15838O000000o.getComMeasuredHeight();
    }

    public final boolean O000000o(int i, String str) {
        if (i == this.O000o00O) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o00O, str, 4);
            }
        } else if (i == this.O000o00o) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o00o, str, 4);
            }
        } else if (i == this.O000o0) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0, str, 3);
            }
        } else if (i == this.O000o) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o, str, 4);
            }
        } else if (i == this.O000oO00) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000oO00, str, 4);
            }
        } else if (i == this.O000oO0o) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000oO0o, str, 4);
            }
        } else if (i == this.O000oO0) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000oO0, str, 4);
            }
        } else if (i == this.O000oO0O) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000oO0O, str, 4);
            }
        } else if (i == this.oooOoO) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.oooOoO, str, 4);
            }
        } else if (i == this.O00oOOoo) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O00oOOoo, str, 3);
            }
        } else if (i == this.O00O00Oo) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O00O00Oo, str, 0);
            }
        } else if (i == this.O00O000o) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O00O000o, str, 0);
            }
        } else if (i == this.O000o0O) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0O, str, 3);
            }
        } else if (i == this.O000o0O0) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0O0, str, 0);
            }
        } else if (i == this.O000o0Oo) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0Oo, str, 0);
            }
        } else if (i == this.O000o0OO) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0OO, str, 0);
            }
        } else if (i == this.O000o0oo) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0oo, str, 3);
            }
        } else if (i != this.O000o0o) {
            return super.O000000o(i, str);
        } else {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0o, str, 0);
            }
        }
        return true;
    }

    public final boolean O00000o0(int i, int i2) {
        if (i == this.O00O00Oo) {
            this.O00O0oOo = i2;
            return true;
        } else if (i == this.O00O000o) {
            this.O00O0oOO = i2;
            return true;
        } else if (i == this.O000o0O0) {
            this.O00O00oo = i2;
            return true;
        } else if (i == this.O000o0Oo) {
            this.O00O0OOo = i2;
            return true;
        } else if (i == this.O000o0OO) {
            this.O00O0OO = i2;
            return true;
        } else if (i == this.O000o0o) {
            this.O00O0Oo0 = i2;
            return true;
        } else {
            boolean z = false;
            if (i == this.O000o00O) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O00o0 = z;
                return true;
            } else if (i == this.O000o00o) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O00o = z;
                return true;
            } else if (i == this.O000o) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0Ooo = z;
                return true;
            } else if (i == this.O000oO00) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0o00 = z;
                return true;
            } else if (i == this.O000oO0o) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0o0o = z;
                return true;
            } else if (i == this.O000oO0) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0o0 = z;
                return true;
            } else if (i == this.O000oO0O) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0o0O = z;
                return true;
            } else if (i == this.oooOoO) {
                if (i2 == 1) {
                    z = true;
                }
                this.O00O0o = z;
                return true;
            } else if (i == this.O000o0) {
                this.O00O00oO = i2;
                return true;
            } else if (i == this.O00oOOoo) {
                this.O00O0oO0 = i2;
                return true;
            } else if (i == this.O000o0O) {
                this.O00O0O0o = i2;
                return true;
            } else if (i != this.O000o0oo) {
                return super.O00000o0(i, i2);
            } else {
                this.O00O0OoO = i2;
                return true;
            }
        }
    }

    public final void O00000o() {
        super.O00000o();
    }

    public final void O00000oO() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        long j;
        super.O00000oO();
        evc.O00000Oo o00000Oo = new evc.O00000Oo();
        o00000Oo.O0000OOo = Boolean.valueOf(this.O00O0Ooo);
        o00000Oo.O0000Oo0 = Boolean.valueOf(this.O00O0o00);
        o00000Oo.O0000Ooo = Boolean.valueOf(this.O00O0o0o);
        o00000Oo.O0000Oo = Boolean.valueOf(this.O00O0o0);
        o00000Oo.O0000OoO = Boolean.valueOf(this.O00O0o0O);
        o00000Oo.O00000Oo = Integer.valueOf(this.O00O0OoO);
        o00000Oo.O00000o = Float.valueOf((float) this.O00O0Oo0);
        evc.O000000o o000000o = new evc.O000000o();
        Boolean valueOf = Boolean.valueOf(this.O00O0o);
        o000000o.f15842O000000o = true;
        o000000o.O0000OOo = valueOf;
        o000000o.O00000Oo(Integer.valueOf(this.O00O0oO0));
        o000000o.O00000o(Float.valueOf((float) this.O00O0oOo));
        o000000o.O00000o0(Float.valueOf((float) this.O00O0oOO));
        o000000o.O000000o(Integer.valueOf(this.O00O0O0o));
        o000000o.O00000Oo(Float.valueOf((float) this.O00O00oo));
        Float valueOf2 = Float.valueOf((float) this.O00O0OOo);
        o000000o.f15842O000000o = true;
        o000000o.O00000o = valueOf2;
        o000000o.O000000o(Float.valueOf((float) this.O00O0OO));
        o00000Oo.O0000o0 = o000000o;
        CountdownVirtualView countdownVirtualView = this.f15838O000000o;
        countdownVirtualView.O00000o = this.O00O00o0;
        evc O000000o2 = o00000Oo.O000000o();
        Float f = O000000o2.f15841O000000o.f15843O000000o;
        if (f != null) {
            countdownVirtualView.f3908O000000o.O0000O0o(f.floatValue());
            z = true;
        } else {
            z = false;
        }
        Float f2 = O000000o2.f15841O000000o.O00000o;
        if (f2 != null) {
            countdownVirtualView.f3908O000000o.O0000OOo(f2.floatValue());
            z = true;
        }
        Integer num = O000000o2.f15841O000000o.O00000Oo;
        if (num != null) {
            countdownVirtualView.f3908O000000o.O00000o(num.intValue());
            z2 = true;
        } else {
            z2 = false;
        }
        Integer num2 = O000000o2.f15841O000000o.O00000oO;
        if (num2 != null) {
            countdownVirtualView.f3908O000000o.O00000oO(num2.intValue());
            z3 = true;
        } else {
            z3 = z2;
        }
        Boolean bool = O000000o2.f15841O000000o.O00000o0;
        if (bool != null) {
            countdownVirtualView.f3908O000000o.O00000o0(bool.booleanValue());
            z = true;
        }
        Boolean bool2 = O000000o2.f15841O000000o.O0000O0o;
        if (bool2 != null) {
            countdownVirtualView.f3908O000000o.O00000o(bool2.booleanValue());
            z = true;
        }
        String str = O000000o2.f15841O000000o.O0000o0O;
        if (!TextUtils.isEmpty(str)) {
            countdownVirtualView.f3908O000000o.O000000o(str);
            z = true;
        }
        if (countdownVirtualView.f3908O000000o.O000000o(O000000o2.f15841O000000o.O0000o0o, O000000o2.f15841O000000o.O0000o, O000000o2.f15841O000000o.O0000oO0, O000000o2.f15841O000000o.O0000oO, O000000o2.f15841O000000o.O0000oOO)) {
            z = true;
        }
        Float f3 = O000000o2.f15841O000000o.O0000oOo;
        if (f3 != null) {
            countdownVirtualView.f3908O000000o.O0000Oo0(f3.floatValue());
            z = true;
        }
        if (countdownVirtualView.f3908O000000o.O000000o(O000000o2.f15841O000000o.O0000oo0, O000000o2.f15841O000000o.O0000oo, O000000o2.f15841O000000o.O00oOooO, O000000o2.f15841O000000o.O00oOooo, O000000o2.f15841O000000o.O000O00o, O000000o2.f15841O000000o.O000O0OO, O000000o2.f15841O000000o.O0000ooO, O000000o2.f15841O000000o.O0000ooo, O000000o2.f15841O000000o.O000O0Oo)) {
            z = true;
        }
        Integer num3 = O000000o2.f15841O000000o.O00000oo;
        if (num3 != null) {
            countdownVirtualView.f3908O000000o.O00000oo(num3.intValue());
            z = true;
        }
        Boolean bool3 = O000000o2.f15841O000000o.O0000OOo;
        Boolean bool4 = O000000o2.f15841O000000o.O0000Oo0;
        Boolean bool5 = O000000o2.f15841O000000o.O0000Oo;
        Boolean bool6 = O000000o2.f15841O000000o.O0000OoO;
        Boolean bool7 = O000000o2.f15841O000000o.O0000Ooo;
        if (!(bool3 == null && bool4 == null && bool5 == null && bool6 == null && bool7 == null)) {
            boolean z6 = countdownVirtualView.f3908O000000o.O00000oo;
            if (bool3 != null) {
                boolean booleanValue = bool3.booleanValue();
                countdownVirtualView.f3908O000000o.O0000Ooo = true;
                z4 = booleanValue;
                z5 = false;
            } else {
                z5 = false;
                countdownVirtualView.f3908O000000o.O0000Ooo = false;
                z4 = z6;
            }
            boolean z7 = countdownVirtualView.f3908O000000o.O0000O0o;
            if (bool4 != null) {
                z7 = bool4.booleanValue();
                countdownVirtualView.f3908O000000o.O0000o00 = true;
            } else {
                countdownVirtualView.f3908O000000o.O0000o00 = z5;
            }
            if (countdownVirtualView.f3908O000000o.O000000o(z4, z7, bool5 != null ? bool5.booleanValue() : countdownVirtualView.f3908O000000o.O0000OOo, bool6 != null ? bool6.booleanValue() : countdownVirtualView.f3908O000000o.O0000Oo0, bool7 != null ? bool7.booleanValue() : countdownVirtualView.f3908O000000o.O0000Oo)) {
                long j2 = countdownVirtualView.O00000oo;
                if (j2 > 0) {
                    countdownVirtualView.O00000oO = 0;
                    if (countdownVirtualView.O00000Oo != null) {
                        countdownVirtualView.O00000Oo.O00000o0();
                        countdownVirtualView.O00000Oo = null;
                    }
                    if (countdownVirtualView.f3908O000000o.O0000Oo) {
                        j = 10;
                        countdownVirtualView.O000000o(j2);
                    } else {
                        j = 1000;
                    }
                    countdownVirtualView.O00000Oo = new evb(j2, j) {
                        /* class com.xiaomi.shopviews.adapter.countdown.CountdownVirtualView.AnonymousClass1 */

                        public final void O000000o(long j) {
                            CountdownVirtualView.this.O000000o(j);
                        }

                        public final void O000000o() {
                            CountdownVirtualView countdownVirtualView = CountdownVirtualView.this;
                            countdownVirtualView.f3908O000000o.O000000o(0, 0, 0, 0, 0);
                            countdownVirtualView.invalidate();
                        }
                    };
                    countdownVirtualView.O00000Oo.O00000Oo();
                }
            }
            z = true;
        }
        evc.O000000o o000000o2 = O000000o2.f15841O000000o.O0000o0;
        if (!countdownVirtualView.O00000o && o000000o2 != null) {
            euy euy = (euy) countdownVirtualView.f3908O000000o;
            Float f4 = o000000o2.O00000o0;
            if (f4 != null) {
                euy.O000000o(f4.floatValue());
                z = true;
            }
            Integer num4 = o000000o2.O00000Oo;
            if (num4 != null) {
                euy.O000000o(num4.intValue());
                z3 = true;
            }
            Float f5 = o000000o2.O00000o;
            if (f5 != null) {
                euy.O00000Oo(f5.floatValue());
                z3 = true;
            }
            Boolean bool8 = o000000o2.O00000oO;
            if (bool8 != null) {
                euy.O000000o(bool8.booleanValue());
                if (bool8.booleanValue()) {
                    Integer num5 = o000000o2.O00000oo;
                    if (num5 != null) {
                        euy.O00000Oo(num5.intValue());
                    }
                    Float f6 = o000000o2.O0000O0o;
                    if (f6 != null) {
                        euy.O00000o0(f6.floatValue());
                    }
                }
                z3 = true;
            }
            Boolean bool9 = o000000o2.O0000OOo;
            if (bool9 != null) {
                euy.O00000Oo(bool9.booleanValue());
                if (bool9.booleanValue()) {
                    Integer num6 = o000000o2.O0000Oo0;
                    if (num6 != null) {
                        euy.O00000o0(num6.intValue());
                    }
                    Float f7 = o000000o2.O0000OoO;
                    if (f7 != null) {
                        euy.O00000o(f7.floatValue());
                    }
                    Float f8 = o000000o2.O0000Oo;
                    if (f8 != null) {
                        euy.O00000oO(f8.floatValue());
                    }
                }
                z = true;
            }
        }
        Boolean O000000o3 = O000000o2.O000000o();
        if (O000000o3 != null && countdownVirtualView.f3908O000000o.O00000oO(O000000o3.booleanValue())) {
            countdownVirtualView.O00000Oo(countdownVirtualView.getRemainTime());
            z = true;
        }
        if (z) {
            countdownVirtualView.O000000o();
        } else if (z3) {
            countdownVirtualView.invalidate();
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new eva(vafContext, dpg);
        }
    }
}
