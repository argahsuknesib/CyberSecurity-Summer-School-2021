package com.xiaomi.shopviews.adapter.countdown;

import _m_j.dpc;
import _m_j.euy;
import _m_j.euz;
import _m_j.evb;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class CountdownVirtualView extends View implements dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    public euz f3908O000000o;
    public evb O00000Oo;
    public boolean O00000o;
    public O000000o O00000o0;
    public long O00000oO;
    public long O00000oo;
    private O00000Oo O0000O0o;
    private long O0000OOo;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public CountdownVirtualView(Context context) {
        this(context, null);
    }

    public CountdownVirtualView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountdownVirtualView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.isConvertDaysToHours, R.attr.isHideTimeBackground, R.attr.isShowDay, R.attr.isShowHour, R.attr.isShowMillisecond, R.attr.isShowMinute, R.attr.isShowSecond, R.attr.isShowTimeBgBorder, R.attr.isShowTimeBgDivisionLine, R.attr.isSuffixTextBold, R.attr.isTimeTextBold, R.attr.suffix, R.attr.suffixDay, R.attr.suffixDayLeftMargin, R.attr.suffixDayRightMargin, R.attr.suffixGravity, R.attr.suffixHour, R.attr.suffixHourLeftMargin, R.attr.suffixHourRightMargin, R.attr.suffixLRMargin, R.attr.suffixMillisecond, R.attr.suffixMillisecondLeftMargin, R.attr.suffixMinute, R.attr.suffixMinuteLeftMargin, R.attr.suffixMinuteRightMargin, R.attr.suffixSecond, R.attr.suffixSecondLeftMargin, R.attr.suffixSecondRightMargin, R.attr.suffixTextColor, R.attr.suffixTextSize, R.attr.timeBgBorderColor, R.attr.timeBgBorderRadius, R.attr.timeBgBorderSize, R.attr.timeBgColor, R.attr.timeBgDivisionLineColor, R.attr.timeBgDivisionLineSize, R.attr.timeBgRadius, R.attr.timeBgSize, R.attr.timeTextColor, R.attr.timeTextSize});
        this.f3908O000000o = this.O00000o ? new euz() : new euy();
        this.f3908O000000o.O000000o(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.f3908O000000o.O00000oO();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int O00000o02 = this.f3908O000000o.O00000o0();
        int O00000o2 = this.f3908O000000o.O00000o();
        int O000000o2 = O000000o(1, O00000o02, i);
        int O000000o3 = O000000o(2, O00000o2, i2);
        setMeasuredDimension(O000000o2, O000000o3);
        this.f3908O000000o.O000000o(this, O000000o2, O000000o3, O00000o02, O00000o2);
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
        this.f3908O000000o.O000000o(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        evb evb = this.O00000Oo;
        if (evb != null) {
            evb.O00000o0();
        }
    }

    public final void O000000o() {
        this.f3908O000000o.O0000OOo();
        requestLayout();
    }

    public void setOnCountdownEndListener(O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public int getDay() {
        return this.f3908O000000o.f15837O000000o;
    }

    public int getHour() {
        return this.f3908O000000o.O00000Oo;
    }

    public int getMinute() {
        return this.f3908O000000o.O00000o0;
    }

    public int getSecond() {
        return this.f3908O000000o.O00000o;
    }

    public long getRemainTime() {
        return this.O00000oo;
    }

    public final void O000000o(long j) {
        this.O00000oo = j;
        O00000Oo(j);
        long j2 = this.O0000OOo;
        if (j2 > 0 && this.O0000O0o != null) {
            long j3 = this.O00000oO;
            if (j3 == 0) {
                this.O00000oO = j;
            } else if (j2 + j <= j3) {
                this.O00000oO = j;
            }
        }
        if (this.f3908O000000o.O00000oo() || this.f3908O000000o.O0000O0o()) {
            O000000o();
        } else {
            invalidate();
        }
    }

    public final void O00000Oo(long j) {
        int i;
        int i2;
        if (!this.f3908O000000o.O0000OoO) {
            i2 = (int) (j / 86400000);
            i = (int) ((j % 86400000) / 3600000);
        } else {
            i = (int) (j / 3600000);
            i2 = 0;
        }
        this.f3908O000000o.O000000o(i2, i, (int) ((j % 3600000) / 60000), (int) ((j % 60000) / 1000), (int) (j % 1000));
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }
}
