package com.scwang.smartrefresh.layout.header;

import _m_j.czr;
import _m_j.czu;
import _m_j.czv;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;

public class TwoLevelHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f5584O000000o;
    protected float O00000Oo;
    protected float O00000o;
    protected float O00000o0;
    protected float O00000oO;
    protected boolean O00000oo;
    protected boolean O0000O0o;
    protected int O0000OOo;
    protected czu O0000Oo;
    protected int O0000Oo0;
    protected czw O0000OoO;
    protected czr O0000Ooo;

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = 0.0f;
        this.O00000o0 = 2.5f;
        this.O00000o = 1.9f;
        this.O00000oO = 1.0f;
        this.O00000oo = true;
        this.O0000O0o = true;
        this.O0000OOo = 1000;
        this.O000OoOo = SpinnerStyle.FixedBehind;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlEnablePullToCloseTwoLevel, R.attr.srlEnableTwoLevel, R.attr.srlFloorDuration, R.attr.srlFloorRage, R.attr.srlMaxRage, R.attr.srlRefreshRage});
        this.O00000o0 = obtainStyledAttributes.getFloat(4, this.O00000o0);
        this.O00000o = obtainStyledAttributes.getFloat(3, this.O00000o);
        this.O00000oO = obtainStyledAttributes.getFloat(5, this.O00000oO);
        this.O0000OOo = obtainStyledAttributes.getInt(2, this.O0000OOo);
        this.O00000oo = obtainStyledAttributes.getBoolean(1, this.O00000oo);
        this.O0000O0o = obtainStyledAttributes.getBoolean(0, this.O0000O0o);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof czu) {
                this.O0000Oo = (czu) childAt;
                this.O000Ooo0 = (czv) childAt;
                bringChildToFront(childAt);
                break;
            }
            i++;
        }
        if (this.O0000Oo == null) {
            O000000o(new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O000OoOo = SpinnerStyle.MatchLayout;
        if (this.O0000Oo == null) {
            O000000o(new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O000OoOo = SpinnerStyle.FixedBehind;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        czu czu = this.O0000Oo;
        if (czu == null) {
            super.onMeasure(i, i2);
        } else if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            czu.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), czu.getView().getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    public boolean equals(Object obj) {
        czu czu = this.O0000Oo;
        return (czu != null && czu.equals(obj)) || super.equals(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw
     arg types: [com.scwang.smartrefresh.layout.header.TwoLevelHeader, boolean]
     candidates:
      _m_j.czw.O000000o(int, boolean):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, int):_m_j.czw
      _m_j.czw.O000000o(_m_j.czv, boolean):_m_j.czw */
    public final void O000000o(czw czw, int i, int i2) {
        czu czu = this.O0000Oo;
        if (czu != null) {
            if ((((float) (i2 + i)) * 1.0f) / ((float) i) != this.O00000o0 && this.O0000Oo0 == 0) {
                this.O0000Oo0 = i;
                this.O0000Oo = null;
                czw.O000000o().O00000Oo(this.O00000o0);
                this.O0000Oo = czu;
            }
            if (this.O0000OoO == null && czu.getSpinnerStyle() == SpinnerStyle.Translate && !isInEditMode()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) czu.getView().getLayoutParams();
                marginLayoutParams.topMargin -= i;
                czu.getView().setLayoutParams(marginLayoutParams);
            }
            this.O0000Oo0 = i;
            this.O0000OoO = czw;
            czw.O00000Oo(this.O0000OOo);
            czw.O000000o((czv) this, !this.O0000O0o);
            czu.O000000o(czw, i, i2);
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        czu czu = this.O0000Oo;
        if (czu != null) {
            czu.O000000o(czx, refreshState, refreshState2);
            int i = AnonymousClass1.f5585O000000o[refreshState2.ordinal()];
            boolean z = true;
            if (i == 1) {
                if (czu.getView() != this) {
                    czu.getView().animate().alpha(0.0f).setDuration((long) (this.O0000OOo / 2));
                }
                czw czw = this.O0000OoO;
                if (czw != null) {
                    czr czr = this.O0000Ooo;
                    if (czr != null && !czr.O000000o()) {
                        z = false;
                    }
                    czw.O000000o(z);
                }
            } else if (i == 2) {
            } else {
                if (i != 3) {
                    if (i == 4 && czu.getView().getAlpha() == 0.0f && czu.getView() != this) {
                        czu.getView().setAlpha(1.0f);
                    }
                } else if (czu.getView() != this) {
                    czu.getView().animate().alpha(1.0f).setDuration((long) (this.O0000OOo / 2));
                }
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.TwoLevelHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5585O000000o = new int[RefreshState.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[SpinnerStyle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        static {
            try {
                O00000Oo[SpinnerStyle.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[SpinnerStyle.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5585O000000o[RefreshState.TwoLevelReleased.ordinal()] = 1;
            f5585O000000o[RefreshState.TwoLevel.ordinal()] = 2;
            f5585O000000o[RefreshState.TwoLevelFinish.ordinal()] = 3;
            try {
                f5585O000000o[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private TwoLevelHeader O000000o(czu czu) {
        if (czu != null) {
            czu czu2 = this.O0000Oo;
            if (czu2 != null) {
                removeView(czu2.getView());
            }
            if (czu.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(czu.getView(), 0, new RelativeLayout.LayoutParams(-1, -2));
            } else {
                addView(czu.getView(), -1, -2);
            }
            this.O0000Oo = czu;
            this.O000Ooo0 = czu;
        }
        return this;
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        czu czu = this.O0000Oo;
        if (!(this.f5584O000000o == i || czu == null)) {
            this.f5584O000000o = i;
            int i4 = AnonymousClass1.O00000Oo[czu.getSpinnerStyle().ordinal()];
            if (i4 == 1) {
                czu.getView().setTranslationY((float) i);
            } else if (i4 == 2) {
                View view = czu.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
            }
        }
        czu czu2 = this.O0000Oo;
        czw czw = this.O0000OoO;
        if (czu2 != null) {
            czu2.O000000o(z, f, i, i2, i3);
        }
        if (z) {
            float f2 = this.O00000Oo;
            float f3 = this.O00000o;
            if (f2 < f3 && f >= f3 && this.O00000oo) {
                czw.O000000o(RefreshState.ReleaseToTwoLevel);
            } else if (this.O00000Oo < this.O00000o || f >= this.O00000oO) {
                float f4 = this.O00000Oo;
                float f5 = this.O00000o;
                if (f4 >= f5 && f < f5) {
                    czw.O000000o(RefreshState.ReleaseToRefresh);
                }
            } else {
                czw.O000000o(RefreshState.PullDownToRefresh);
            }
            this.O00000Oo = f;
        }
    }
}
