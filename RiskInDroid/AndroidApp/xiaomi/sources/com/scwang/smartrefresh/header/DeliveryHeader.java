package com.scwang.smartrefresh.header;

import _m_j.czj;
import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public class DeliveryHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static String[] f5514O000000o = {"M113.91,328.86 L119.02,331.02 134.86,359.02 133.99,359.02ZM2.18,144.52c-3.67,-76.84 49.96,-122.23 96.3,-134.98 6.03,0.21 7.57,0.59 13.23,3.9 0.19,1.7 0.25,2.17 -0.41,3.98 -47.88,37.64 -55.13,79.65 -68.07,137.22C37.56,194.8 16.18,191.4 2.18,144.52Z", "m133.99,359.02 l-0.71,-26.66 2.6,0.26 -1.02,26.4zM119.02,331.02c-3.39,-0.99 -8.53,-3.03 -8.72,-6.61 0,-0.81 -2.02,-3.63 -4.49,-6.27C88.05,299.71 7.29,218.46 2.18,144.52c17.67,43.57 33.35,45.33 41.05,10.12 0.13,-70.78 33.78,-125.48 68.07,-137.22 2.34,3.33 4.11,4.81 8.14,7.8 -22.02,65.69 -23.25,84.11 -24.14,150.23 -8.68,29.57 -37.44,32.81 -52.07,-20.81 14.12,64.06 31.66,101.57 60.64,147.13 6.2,8.38 14.74,18.4 15.15,29.25zM98.48,9.54c4.59,-1.5 17.8,-4.6 33.87,-5.07 0.95,0.95 1.38,1.91 1.14,2.91 -8.81,1.34 -16.36,3.1 -21.78,6.06 -2.53,-1.27 -7.82,-3.26 -13.23,-3.9z", "m119.02,331.02c-1.29,-7.57 -4.22,-12.31 -6.54,-15.79 -36.86,-54.89 -63.48,-98.79 -69.25,-160.59 19.89,45.9 41.27,48.65 52.07,20.81 -1.95,-52.55 -8.04,-91.2 24.14,-150.23 10.47,-0.28 16.85,0.17 30.66,-0.34 40.19,60.54 24.92,135.95 22.16,149.57 -13.9,53.18 -66.91,34.12 -76.96,1 11.54,50.55 20.28,89.27 30,135.97 4.12,10.03 5.37,10.37 5.06,21.35 -2.82,-0.22 -8.22,-1.01 -11.35,-1.75z", "m172.27,174.45c4.91,-51.6 -1.8,-105.99 -22.16,-149.57 2.51,-3.42 3.25,-4.36 6.59,-6.04 47.91,22.5 77.5,62.66 68.9,139.94 -16.53,49.7 -45.39,52.78 -53.33,15.68zM154.36,13.39c-6.65,-2.73 -11.65,-4.27 -20.87,-6.01 -0.25,-1.02 -0.71,-2.21 -1.14,-2.91 16.31,-0.22 27.58,2.29 37.27,4.82 -5.49,0.42 -11.39,1.87 -15.26,4.11z", "m133.99,359.02 l14.98,-28.13 2.24,-0.75 -16.34,28.88zM141.15,332.65c0.01,-11.71 2.3,-14.29 4.13,-21.52 11.82,-46.68 16.09,-77.45 26.98,-136.68 12.18,38.55 37.7,23.31 53.33,-15.68 -4.01,53.72 -43.68,121.28 -68.8,155.25 -6.17,9.5 -8.27,16.22 -5.59,16.12 -3.69,1.47 -6.24,2.05 -10.05,2.51z", "m225.59,158.77c1.61,-52.44 -22.26,-117.1 -68.9,-139.94 -1.48,-2.24 -1.63,-2.16 -2.34,-5.44 3.7,-3.42 9.42,-4.82 15.26,-4.11 48.59,9.81 103.07,66.75 96.62,132.26 -9.7,45.68 -35.45,51.78 -40.64,17.24z", "m156.48,313.99c32.9,-59.38 53.82,-87.19 69.12,-155.22 12.23,38.4 28.73,22.32 40.64,-17.24 -2.11,50.59 -43.12,112.84 -99.62,171.38 -4.57,4.73 -8.31,9.42 -8.31,10.4 -0,2.28 -3.52,5.43 -7.1,6.82 -4.65,0.73 2.08,-12.86 5.27,-16.15z", "M130.37,332.77C129.51,321.51 128.56,320.77 125.3,311.42 113.97,281.37 101.34,222.24 95.3,175.45c16.48,38.98 60.02,33.39 76.96,-1 -5.91,58.92 -10.85,88.45 -27.42,138.74 -1.67,6.75 -2.67,11.63 -3.7,19.46 -2.94,0.45 -6.48,0.45 -10.78,0.12zM119.44,25.22c-3.52,-1.25 -6.98,-3.72 -8.14,-7.8 -0.44,-1.53 -0.24,-2.79 0.41,-3.98 2.48,-4.55 14.53,-6.26 21.78,-6.06 5.29,0.15 14.87,0.72 20.87,6.01 1.82,1.61 2.74,3.95 2.34,5.44 -0.76,2.83 -4.21,5.19 -6.59,6.04 -7.49,2.68 -22.62,3.2 -30.66,0.34z"};
    protected static int[] O00000Oo = {-7151637, -9580311, -11549721, -13650202, -14308898, -15619100, -15819816, -12535839};
    protected static int[] O00000o = {-1};
    protected static String[] O00000o0 = {"M63,0.1A22.6,22.4 0,0 0,42.1 14.2,17.3 17.3,0 0,0 30.9,10.2 17.3,17.3 0,0 0,13.7 25.8,8.8 8.8,0 0,0 8.7,24.2 8.8,8.8 0,0 0,0 32h99a7.9,7.9 0,0 0,0 -0.6,7.9 7.9,0 0,0 -7.9,-7.9 7.9,7.9 0,0 0,-5.8 2.6,22.6 22.4,0 0,0 0.3,-3.6A22.6,22.4 0,0 0,63 0.1Z"};
    protected static String[] O00000oO = {"M0,17.5 L3.1,29.8 2.9,76.4 47.5,93 92.8,76.2V29.9L94.9,18.1 47.4,0.5Z", "M3.1,29.8 L47.8,46.4 47.5,93 2.9,76.4ZM0,17.5 L47.9,35.4 47.8,46.4 0.2,28.8Z", "m56.5,17.8c0,2.1 -3.8,3.8 -8.5,3.8 -4.7,0 -8.5,-1.7 -8.5,-3.8 0,-2.1 3.8,-3.8 8.5,-3.8 4.7,0 8.5,1.7 8.5,3.8zM3.1,29.8 L3.1,34.7l44.7,16.9 0,-5.1z", "M47.9,35.4 L47.5,93 92.8,76.2V29.9l2.2,-0.8 0,-10.9z", "M82.6,80 L92.8,62.4 92.8,76.2ZM47.6,79.8 L59.8,88.4 47.5,93ZM47.8,46.4 L92.8,29.9 92.8,34.2 47.8,51.6Z"};
    protected static int[] O00000oo = {-478905, -878788, -1212368, -81839, -545463};
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected float O0000OoO;
    protected RefreshState O0000Ooo;
    protected Drawable O0000o0;
    protected Drawable O0000o00;
    protected Drawable O0000o0O;

    public DeliveryHeader(Context context) {
        this(context, null);
    }

    public DeliveryHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DeliveryHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O000OoOo = SpinnerStyle.Scale;
        setMinimumHeight(dao.O000000o(150.0f));
        czj czj = new czj();
        if (!czj.O000000o(O00000o0)) {
            czj.O000000o(0, 0, 99, 32);
        }
        czj.O000000o(O00000o);
        int O000000o2 = dao.O000000o(20.0f);
        Rect bounds = czj.getBounds();
        float height = (((float) O000000o2) * 1.0f) / ((float) bounds.height());
        czj.setBounds((int) (((float) bounds.left) * height), (int) (((float) bounds.top) * height), (int) (((float) bounds.right) * height), (int) (((float) bounds.bottom) * height));
        czj czj2 = new czj();
        if (!czj2.O000000o(f5514O000000o)) {
            czj2.O000000o(2, 4, 265, 355);
        }
        czj2.O000000o(O00000Oo);
        czj2.O000000o(dao.O000000o(200.0f));
        czj czj3 = new czj();
        if (!czj3.O000000o(O00000oO)) {
            czj3.O000000o(0, 1, 95, 92);
        }
        czj3.O000000o(O00000oo);
        czj3.O000000o(dao.O000000o(50.0f));
        this.O0000o0O = czj3;
        this.O0000o00 = czj;
        this.O0000o0 = czj2;
        if (isInEditMode()) {
            this.O0000Ooo = RefreshState.Refreshing;
            this.O0000OoO = 100.0f;
            this.O0000O0o = (int) (((float) this.O0000o00.getBounds().width()) * 3.5f);
            this.O0000OOo = (int) (((float) this.O0000o00.getBounds().width()) * 0.5f);
            this.O0000Oo0 = (int) (((float) this.O0000o00.getBounds().width()) * 2.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int saveCount = canvas.getSaveCount();
        canvas.save();
        double d = (double) (this.O0000Oo / 13);
        double sin = Math.sin((double) this.O0000OoO);
        Double.isNaN(d);
        int i = (int) (d * sin);
        if (this.O0000Ooo == RefreshState.Refreshing || this.O0000Ooo == RefreshState.RefreshFinish) {
            this.O0000o00.getBounds().offsetTo(this.O0000O0o, this.O0000Oo / 3);
            this.O0000o00.draw(canvas);
            this.O0000o00.getBounds().offsetTo(this.O0000OOo, this.O0000Oo / 2);
            this.O0000o00.draw(canvas);
            this.O0000o00.getBounds().offsetTo(this.O0000Oo0, (this.O0000Oo * 2) / 3);
            this.O0000o00.draw(canvas);
            canvas.rotate(((float) Math.sin((double) (this.O0000OoO / 2.0f))) * 5.0f, (float) (width / 2), (float) ((this.O0000Oo / 2) - this.O0000o0.getBounds().height()));
            this.O0000O0o += dao.O000000o(9.0f);
            this.O0000OOo += dao.O000000o(5.0f);
            this.O0000Oo0 += dao.O000000o(12.0f);
            int width2 = this.O0000o00.getBounds().width();
            int i2 = width + width2;
            if (this.O0000O0o > i2) {
                this.O0000O0o = -width2;
            }
            if (this.O0000OOo > i2) {
                this.O0000OOo = -width2;
            }
            if (this.O0000Oo0 > i2) {
                this.O0000Oo0 = -width2;
            }
            this.O0000OoO += 0.1f;
            invalidate();
        }
        int i3 = this.O0000Oo;
        int i4 = (height - (i3 / 2)) + i;
        int i5 = width / 2;
        this.O0000o0O.getBounds().offsetTo(i5 - (this.O0000o0O.getBounds().width() / 2), ((((i3 / 2) - this.O0000o0O.getBounds().height()) + i4) - Math.min((this.O0000Oo / 2) - this.O0000o0O.getBounds().height(), dao.O000000o(this.O0000OoO * 100.0f))) - (this.O0000o0O.getBounds().height() / 4));
        this.O0000o0O.draw(canvas);
        if (this.O0000Ooo == RefreshState.Refreshing || this.O0000Ooo == RefreshState.RefreshFinish) {
            Rect bounds = this.O0000o0.getBounds();
            int i6 = this.O0000Oo;
            this.O0000o0.getBounds().offsetTo(i5 - (bounds.width() / 2), ((i4 - i6) + Math.min(i6, dao.O000000o(this.O0000OoO * 100.0f))) - bounds.height());
            this.O0000o0.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
        super.dispatchDraw(canvas);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (this.O0000Ooo != RefreshState.Refreshing) {
            this.O0000o0O.setAlpha((int) ((1.0f - Math.max(0.0f, f - 1.0f)) * 255.0f));
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        O00000Oo(czx, i, i2);
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        this.O0000Ooo = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.O0000OoO = 0.0f;
            int i = -this.O0000o00.getBounds().width();
            this.O0000Oo0 = i;
            this.O0000OOo = i;
            this.O0000O0o = i;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                Drawable drawable = this.O0000o00;
                if (drawable instanceof czj) {
                    ((czj) drawable).O000000o(iArr[1]);
                }
            }
        }
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O0000Oo = i;
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        this.O0000Ooo = RefreshState.Refreshing;
        this.O0000o0O.setAlpha(255);
        invalidate();
    }
}
