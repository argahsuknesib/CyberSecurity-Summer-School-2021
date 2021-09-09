package com.scwang.smartrefresh.header.fungame;

import _m_j.czs;
import _m_j.czu;
import _m_j.czv;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

@SuppressLint({"RestrictedApi"})
public abstract class FunGameBase extends dae implements czu {
    protected int O0000oO;
    protected int O0000oO0;
    protected int O0000oOO = getResources().getDisplayMetrics().heightPixels;
    protected float O0000oOo;
    protected boolean O0000oo;
    protected boolean O0000oo0;
    protected boolean O0000ooO;
    protected RefreshState O0000ooo;
    boolean O000O00o;
    protected czw O00oOooO;
    protected czs O00oOooo;

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i);

    public FunGameBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMinimumHeight(dao.O000000o(100.0f));
        this.O000OoOo = SpinnerStyle.MatchLayout;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.O0000ooo == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(int, boolean):_m_j.czw
     arg types: [int, int]
     candidates:
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
      _m_j.czw.O000000o(int, boolean):_m_j.czw */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O0000ooo != RefreshState.Refreshing && this.O0000ooo != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z = this.O0000ooO;
        if (!z && !z) {
            this.O0000ooO = true;
            this.O00oOooo = this.O00oOooO.O00000Oo();
            this.O000O00o = this.O00oOooO.O000000o().isEnableLoadMore();
            this.O00oOooO.O000000o().O0000O0o(false);
            View O000000o2 = this.O00oOooo.O000000o();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) O000000o2.getLayoutParams();
            marginLayoutParams.topMargin += this.O0000oO;
            O000000o2.setLayoutParams(marginLayoutParams);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.O0000oOo;
                    if (rawY >= 0.0f) {
                        double d = (double) (this.O0000oO * 2);
                        double d2 = (double) ((this.O0000oOO * 2) / 3);
                        double d3 = (double) rawY;
                        Double.isNaN(d3);
                        double max = Math.max(0.0d, d3 * 0.5d);
                        Double.isNaN(d2);
                        Double.isNaN(d);
                        this.O00oOooO.O000000o((int) Math.min(d * (1.0d - Math.pow(100.0d, (-max) / d2)), max), false);
                    } else {
                        double d4 = (double) (this.O0000oO * 2);
                        double d5 = (double) ((this.O0000oOO * 2) / 3);
                        double d6 = (double) rawY;
                        Double.isNaN(d6);
                        double d7 = -Math.min(0.0d, d6 * 0.5d);
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        this.O00oOooO.O000000o((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, (-d7) / d5)), d7)), false);
                    }
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            O000000o();
            this.O0000oOo = -1.0f;
            if (this.O0000oo0) {
                this.O00oOooO.O000000o(this.O0000oO, true);
                return true;
            }
            return true;
        }
        this.O0000oOo = motionEvent.getRawY();
        this.O00oOooO.O000000o(0, true);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(int, boolean):_m_j.czw
     arg types: [int, int]
     candidates:
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
      _m_j.czw.O000000o(int, boolean):_m_j.czw */
    private void O000000o() {
        if (this.O0000oo0) {
            this.O0000ooO = false;
            this.O00oOooO.O000000o().O0000O0o(this.O000O00o);
            if (this.O0000oOo != -1.0f) {
                O000000o(this.O00oOooO.O000000o(), this.O0000oo);
                this.O00oOooO.O000000o(RefreshState.RefreshFinish);
                this.O00oOooO.O000000o(0);
            } else {
                this.O00oOooO.O000000o(this.O0000oO, true);
            }
            View O000000o2 = this.O00oOooo.O000000o();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) O000000o2.getLayoutParams();
            marginLayoutParams.topMargin -= this.O0000oO;
            O000000o2.setLayoutParams(marginLayoutParams);
            return;
        }
        this.O00oOooO.O000000o(0, true);
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (this.O0000ooO) {
            O000000o(i);
            return;
        }
        this.O0000oO0 = i;
        setTranslationY((float) (this.O0000oO0 - this.O0000oO));
    }

    public void O00000Oo(czx czx, int i, int i2) {
        this.O0000oo0 = false;
        setTranslationY(0.0f);
    }

    public void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        this.O0000ooo = refreshState2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
     arg types: [com.scwang.smartrefresh.header.fungame.FunGameBase, int]
     candidates:
      _m_j.czw.O000000o(int, boolean):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw */
    public void O000000o(czw czw, int i, int i2) {
        this.O00oOooO = czw;
        this.O0000oO = i;
        if (!isInEditMode()) {
            setTranslationY((float) (this.O0000oO0 - this.O0000oO));
            czw.O000000o((czv) this, true);
        }
    }

    public int O000000o(czx czx, boolean z) {
        this.O0000oo = z;
        if (!this.O0000oo0) {
            this.O0000oo0 = true;
            if (this.O0000ooO) {
                if (this.O0000oOo != -1.0f) {
                    return Integer.MAX_VALUE;
                }
                O000000o();
                O000000o(czx, z);
                return 0;
            }
        }
        return 0;
    }
}
