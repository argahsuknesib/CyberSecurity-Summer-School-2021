package com.xiaomi.shopviews.adapter.countdown;

import _m_j.euy;
import _m_j.euz;
import _m_j.evb;
import _m_j.evc;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class CountdownView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f3906O000000o;
    private euz O00000Oo;
    private O00000Oo O00000o;
    private evb O00000o0;
    private boolean O00000oO;
    private long O00000oo;
    private long O0000O0o;
    private long O0000OOo;

    public interface O000000o {
        void O000000o(CountdownView countdownView);
    }

    public interface O00000Oo {
        void O000000o(CountdownView countdownView, long j);
    }

    public CountdownView(Context context) {
        this(context, null);
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.isConvertDaysToHours, R.attr.isHideTimeBackground, R.attr.isShowDay, R.attr.isShowHour, R.attr.isShowMillisecond, R.attr.isShowMinute, R.attr.isShowSecond, R.attr.isShowTimeBgBorder, R.attr.isShowTimeBgDivisionLine, R.attr.isSuffixTextBold, R.attr.isTimeTextBold, R.attr.suffix, R.attr.suffixDay, R.attr.suffixDayLeftMargin, R.attr.suffixDayRightMargin, R.attr.suffixGravity, R.attr.suffixHour, R.attr.suffixHourLeftMargin, R.attr.suffixHourRightMargin, R.attr.suffixLRMargin, R.attr.suffixMillisecond, R.attr.suffixMillisecondLeftMargin, R.attr.suffixMinute, R.attr.suffixMinuteLeftMargin, R.attr.suffixMinuteRightMargin, R.attr.suffixSecond, R.attr.suffixSecondLeftMargin, R.attr.suffixSecondRightMargin, R.attr.suffixTextColor, R.attr.suffixTextSize, R.attr.timeBgBorderColor, R.attr.timeBgBorderRadius, R.attr.timeBgBorderSize, R.attr.timeBgColor, R.attr.timeBgDivisionLineColor, R.attr.timeBgDivisionLineSize, R.attr.timeBgRadius, R.attr.timeBgSize, R.attr.timeTextColor, R.attr.timeTextSize});
        this.O00000oO = obtainStyledAttributes.getBoolean(1, true);
        this.O00000Oo = this.O00000oO ? new euz() : new euy();
        this.O00000Oo.O000000o(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.O00000Oo.O00000oO();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int O00000o02 = this.O00000Oo.O00000o0();
        int O00000o2 = this.O00000Oo.O00000o();
        int O000000o2 = O000000o(1, O00000o02, i);
        int O000000o3 = O000000o(2, O00000o2, i2);
        setMeasuredDimension(O000000o2, O000000o3);
        this.O00000Oo.O000000o(this, O000000o2, O000000o3, O00000o02, O00000o2);
    }

    private int O000000o(int i, int i2, int i3) {
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return Math.max(i2, size);
        }
        if (i == 1) {
            i5 = getPaddingLeft();
            i4 = getPaddingRight();
        } else {
            i5 = getPaddingTop();
            i4 = getPaddingBottom();
        }
        return i5 + i4 + i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.O00000Oo.O000000o(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void O00000Oo() {
        this.O00000Oo.O0000OOo();
        requestLayout();
    }

    public final void O000000o(long j) {
        long j2;
        if (j > 0) {
            this.O00000oo = 0;
            evb evb = this.O00000o0;
            if (evb != null) {
                evb.O00000o0();
                this.O00000o0 = null;
            }
            if (this.O00000Oo.O0000Oo) {
                j2 = 10;
                O00000Oo(j);
            } else {
                j2 = 1000;
            }
            this.O00000o0 = new evb(j, j2) {
                /* class com.xiaomi.shopviews.adapter.countdown.CountdownView.AnonymousClass1 */

                public final void O000000o(long j) {
                    CountdownView.this.O00000Oo(j);
                }

                public final void O000000o() {
                    CountdownView.this.O000000o();
                    if (CountdownView.this.f3906O000000o != null) {
                        CountdownView.this.f3906O000000o.O000000o(CountdownView.this);
                    }
                }
            };
            this.O00000o0.O00000Oo();
        }
    }

    public final void O000000o() {
        this.O00000Oo.O000000o(0, 0, 0, 0, 0);
        invalidate();
    }

    public void setOnCountdownEndListener(O000000o o000000o) {
        this.f3906O000000o = o000000o;
    }

    public final void setOnCountdownIntervalListener$2fa15284(O00000Oo o00000Oo) {
        this.O0000O0o = 1000;
        this.O00000o = o00000Oo;
    }

    public int getDay() {
        return this.O00000Oo.f15837O000000o;
    }

    public int getHour() {
        return this.O00000Oo.O00000Oo;
    }

    public int getMinute() {
        return this.O00000Oo.O00000o0;
    }

    public int getSecond() {
        return this.O00000Oo.O00000o;
    }

    public long getRemainTime() {
        return this.O0000OOo;
    }

    public final void O00000Oo(long j) {
        O00000Oo o00000Oo;
        this.O0000OOo = j;
        O00000o0(j);
        long j2 = this.O0000O0o;
        if (j2 > 0 && (o00000Oo = this.O00000o) != null) {
            long j3 = this.O00000oo;
            if (j3 == 0) {
                this.O00000oo = j;
            } else if (j2 + j <= j3) {
                this.O00000oo = j;
                o00000Oo.O000000o(this, this.O0000OOo);
            }
        }
        if (this.O00000Oo.O00000oo() || this.O00000Oo.O0000O0o()) {
            O00000Oo();
        } else {
            invalidate();
        }
    }

    private void O00000o0(long j) {
        int i;
        int i2;
        if (!this.O00000Oo.O0000OoO) {
            i2 = (int) (j / 86400000);
            i = (int) ((j % 86400000) / 3600000);
        } else {
            i = (int) (j / 3600000);
            i2 = 0;
        }
        this.O00000Oo.O000000o(i2, i, (int) ((j % 3600000) / 60000), (int) ((j % 60000) / 1000), (int) (j % 1000));
    }

    public final void O000000o(evc evc) {
        boolean z;
        boolean z2;
        evc evc2 = evc;
        if (evc2 != null) {
            Float f = evc2.f15841O000000o.f15843O000000o;
            if (f != null) {
                this.O00000Oo.O0000O0o(f.floatValue());
                z = true;
            } else {
                z = false;
            }
            Float f2 = evc2.f15841O000000o.O00000o;
            if (f2 != null) {
                this.O00000Oo.O0000OOo(f2.floatValue());
                z = true;
            }
            Integer num = evc2.f15841O000000o.O00000Oo;
            if (num != null) {
                this.O00000Oo.O00000o(num.intValue());
                z2 = true;
            } else {
                z2 = false;
            }
            Integer num2 = evc2.f15841O000000o.O00000oO;
            if (num2 != null) {
                this.O00000Oo.O00000oO(num2.intValue());
                z2 = true;
            }
            Boolean bool = evc2.f15841O000000o.O00000o0;
            if (bool != null) {
                this.O00000Oo.O00000o0(bool.booleanValue());
                z = true;
            }
            Boolean bool2 = evc2.f15841O000000o.O0000O0o;
            if (bool2 != null) {
                this.O00000Oo.O00000o(bool2.booleanValue());
                z = true;
            }
            String str = evc2.f15841O000000o.O0000o0O;
            if (!TextUtils.isEmpty(str)) {
                this.O00000Oo.O000000o(str);
                z = true;
            }
            if (this.O00000Oo.O000000o(evc2.f15841O000000o.O0000o0o, evc2.f15841O000000o.O0000o, evc2.f15841O000000o.O0000oO0, evc2.f15841O000000o.O0000oO, evc2.f15841O000000o.O0000oOO)) {
                z = true;
            }
            Float f3 = evc2.f15841O000000o.O0000oOo;
            if (f3 != null) {
                this.O00000Oo.O0000Oo0(f3.floatValue());
                z = true;
            }
            if (this.O00000Oo.O000000o(evc2.f15841O000000o.O0000oo0, evc2.f15841O000000o.O0000oo, evc2.f15841O000000o.O00oOooO, evc2.f15841O000000o.O00oOooo, evc2.f15841O000000o.O000O00o, evc2.f15841O000000o.O000O0OO, evc2.f15841O000000o.O0000ooO, evc2.f15841O000000o.O0000ooo, evc2.f15841O000000o.O000O0Oo)) {
                z = true;
            }
            Integer num3 = evc2.f15841O000000o.O00000oo;
            if (num3 != null) {
                this.O00000Oo.O00000oo(num3.intValue());
                z = true;
            }
            Boolean bool3 = evc2.f15841O000000o.O0000OOo;
            Boolean bool4 = evc2.f15841O000000o.O0000Oo0;
            Boolean bool5 = evc2.f15841O000000o.O0000Oo;
            Boolean bool6 = evc2.f15841O000000o.O0000OoO;
            Boolean bool7 = evc2.f15841O000000o.O0000Ooo;
            if (!(bool3 == null && bool4 == null && bool5 == null && bool6 == null && bool7 == null)) {
                boolean z3 = this.O00000Oo.O00000oo;
                if (bool3 != null) {
                    z3 = bool3.booleanValue();
                    this.O00000Oo.O0000Ooo = true;
                } else {
                    this.O00000Oo.O0000Ooo = false;
                }
                boolean z4 = z3;
                boolean z5 = this.O00000Oo.O0000O0o;
                if (bool4 != null) {
                    z5 = bool4.booleanValue();
                    this.O00000Oo.O0000o00 = true;
                } else {
                    this.O00000Oo.O0000o00 = false;
                }
                if (this.O00000Oo.O000000o(z4, z5, bool5 != null ? bool5.booleanValue() : this.O00000Oo.O0000OOo, bool6 != null ? bool6.booleanValue() : this.O00000Oo.O0000Oo0, bool7 != null ? bool7.booleanValue() : this.O00000Oo.O0000Oo)) {
                    O000000o(this.O0000OOo);
                }
                z = true;
            }
            evc.O000000o o000000o = evc2.f15841O000000o.O0000o0;
            if (!this.O00000oO && o000000o != null) {
                euy euy = (euy) this.O00000Oo;
                Float f4 = o000000o.O00000o0;
                if (f4 != null) {
                    euy.O000000o(f4.floatValue());
                    z = true;
                }
                Integer num4 = o000000o.O00000Oo;
                if (num4 != null) {
                    euy.O000000o(num4.intValue());
                    z2 = true;
                }
                Float f5 = o000000o.O00000o;
                if (f5 != null) {
                    euy.O00000Oo(f5.floatValue());
                    z2 = true;
                }
                Boolean bool8 = o000000o.O00000oO;
                if (bool8 != null) {
                    euy.O000000o(bool8.booleanValue());
                    if (bool8.booleanValue()) {
                        Integer num5 = o000000o.O00000oo;
                        if (num5 != null) {
                            euy.O00000Oo(num5.intValue());
                        }
                        Float f6 = o000000o.O0000O0o;
                        if (f6 != null) {
                            euy.O00000o0(f6.floatValue());
                        }
                    }
                    z2 = true;
                }
                Boolean bool9 = o000000o.O0000OOo;
                if (bool9 != null) {
                    euy.O00000Oo(bool9.booleanValue());
                    if (bool9.booleanValue()) {
                        Integer num6 = o000000o.O0000Oo0;
                        if (num6 != null) {
                            euy.O00000o0(num6.intValue());
                        }
                        Float f7 = o000000o.O0000OoO;
                        if (f7 != null) {
                            euy.O00000o(f7.floatValue());
                        }
                        Float f8 = o000000o.O0000Oo;
                        if (f8 != null) {
                            euy.O00000oO(f8.floatValue());
                        }
                    }
                    z = true;
                }
            }
            Boolean O000000o2 = evc.O000000o();
            if (O000000o2 != null && this.O00000Oo.O00000oO(O000000o2.booleanValue())) {
                O00000o0(getRemainTime());
                z = true;
            }
            if (z) {
                O00000Oo();
            } else if (z2) {
                invalidate();
            }
        }
    }
}
