package com.xiaomi.shopviews.widget.smarttab;

import _m_j.exj;
import _m_j.exk;
import _m_j.exl;
import _m_j.exm;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.nineoldandroids.animation.ValueAnimator;
import com.xiaomi.smarthome.R;

public class SmartTabLayout extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    ValueAnimator f3992O000000o;
    public exj O00000Oo;
    protected final exl O00000o;
    public O00000o O00000o0;
    public ViewPager.O0000O0o O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private O000000o O0000OOo;
    private O0000Oo0 O0000Oo;
    private O00000o0 O0000Oo0;
    private int O0000OoO;
    private boolean O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private ColorStateList O0000o00;
    private int O0000o0O;
    private float O0000o0o;

    public interface O00000o {
    }

    public interface O00000o0 {
    }

    public interface O0000OOo {
        int O000000o(int i);

        int O00000Oo(int i);
    }

    public interface O0000Oo0 {
        View O000000o(ViewGroup viewGroup, int i, exj exj);
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
    }

    public SmartTabLayout(Context context) {
        this(context, null);
    }

    public SmartTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        this.O0000O0o = true;
        setHorizontalScrollBarEnabled(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 13.0f, displayMetrics);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, new int[]{R.attr.mi_stl_clickable, R.attr.mi_stl_customTabTextLayoutId, R.attr.mi_stl_customTabTextViewId, R.attr.mi_stl_defaultTabBackground, R.attr.mi_stl_defaultTabTextAllCaps, R.attr.mi_stl_defaultTabTextColor, R.attr.mi_stl_defaultTabTextHorizontalPadding, R.attr.mi_stl_defaultTabTextMinWidth, R.attr.mi_stl_defaultTabTextSize, R.attr.mi_stl_distributeEvenly, R.attr.mi_stl_dividerColor, R.attr.mi_stl_dividerColors, R.attr.mi_stl_dividerThickness, R.attr.mi_stl_drawDecorationAfterTab, R.attr.mi_stl_indicatorAlwaysInCenter, R.attr.mi_stl_indicatorColor, R.attr.mi_stl_indicatorColors, R.attr.mi_stl_indicatorCornerRadius, R.attr.mi_stl_indicatorGravity, R.attr.mi_stl_indicatorInFront, R.attr.mi_stl_indicatorInterpolation, R.attr.mi_stl_indicatorThickness, R.attr.mi_stl_indicatorWidth, R.attr.mi_stl_indicatorWithoutPadding, R.attr.mi_stl_overlineColor, R.attr.mi_stl_overlineThickness, R.attr.mi_stl_titleOffset, R.attr.mi_stl_underlineColor, R.attr.mi_stl_underlineThickness}, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        boolean z = obtainStyledAttributes.getBoolean(4, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(5);
        float dimension = obtainStyledAttributes.getDimension(8, applyDimension);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, (int) (16.0f * f));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(7, (int) (0.0f * f));
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(2, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(9, false);
        boolean z3 = obtainStyledAttributes.getBoolean(0, true);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(26, (int) (f * 24.0f));
        obtainStyledAttributes.recycle();
        this.O0000o = layoutDimension;
        this.O0000OoO = resourceId;
        this.O0000Ooo = z;
        this.O0000o00 = colorStateList == null ? ColorStateList.valueOf(-67108864) : colorStateList;
        this.O0000o0o = dimension;
        this.O0000o0 = dimensionPixelSize;
        this.O0000o0O = dimensionPixelSize2;
        this.O0000OOo = z3 ? new O000000o(this, (byte) 0) : null;
        this.O00000oo = z2;
        if (resourceId2 != -1) {
            this.O0000Oo = new O0000O0o(getContext(), resourceId2, resourceId3, (byte) 0);
        }
        this.O00000o = new exl(context2, attributeSet2);
        if (!z2 || !this.O00000o.O00000o) {
            setFillViewport(!this.O00000o.O00000o);
            addView(this.O00000o, -1, -1);
            return;
        }
        throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.shopviews.widget.smarttab.SmartTabLayout.O000000o(boolean, int):void
     arg types: [int, int]
     candidates:
      com.xiaomi.shopviews.widget.smarttab.SmartTabLayout.O000000o(int, float):void
      com.xiaomi.shopviews.widget.smarttab.SmartTabLayout.O000000o(boolean, int):void */
    public final void O000000o(int i, float f) {
        int i2;
        int childCount = this.O00000o.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            O000000o(false, 0);
            boolean O0000OOo2 = exm.O0000OOo(this);
            View childAt = this.O00000o.getChildAt(i);
            int O00000oo2 = (int) (((float) (exm.O00000oo(childAt) + exm.O00000Oo(childAt))) * f);
            if (this.O00000o.O00000o) {
                if (0.0f < f && f < 1.0f) {
                    View childAt2 = this.O00000o.getChildAt(i + 1);
                    O00000oo2 = Math.round(f * ((float) ((exm.O00000oo(childAt) / 2) + exm.O000000o(childAt) + (exm.O00000oo(childAt2) / 2) + exm.O00000o0(childAt2))));
                }
                View childAt3 = this.O00000o.getChildAt(0);
                if (O0000OOo2) {
                    i2 = ((exm.O000000o(childAt, false) - exm.O000000o(childAt)) - O00000oo2) - (((exm.O00000oo(childAt3) + exm.O000000o(childAt3)) - (exm.O00000oo(childAt) + exm.O000000o(childAt))) / 2);
                } else {
                    i2 = (O00000oo2 + (exm.O00000Oo(childAt, false) - exm.O00000o0(childAt))) - (((exm.O00000oo(childAt3) + exm.O00000o0(childAt3)) - (exm.O00000oo(childAt) + exm.O00000o0(childAt))) / 2);
                }
                O000000o(true, i2);
                return;
            }
            if (this.O0000o == -1) {
                if (0.0f < f && f < 1.0f) {
                    View childAt4 = this.O00000o.getChildAt(i + 1);
                    Math.round(f * ((float) ((exm.O00000oo(childAt) / 2) + exm.O000000o(childAt) + (exm.O00000oo(childAt4) / 2) + exm.O00000o0(childAt4))));
                }
                if (O0000OOo2) {
                    exm.O0000O0o(childAt);
                    getWidth();
                    exm.O00000oO(this);
                } else {
                    exm.O0000O0o(childAt);
                    getWidth();
                    exm.O00000oO(this);
                }
            }
            int O00000Oo2 = exm.O00000Oo(childAt, false);
            exm.O00000o0(childAt);
            if (O0000OOo2) {
                getWidth();
                getPaddingLeft();
                getPaddingRight();
            }
            O000000o(this.O0000O0o, O00000Oo2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        exj exj;
        super.onLayout(z, i, i2, i3, i4);
        if (z && (exj = this.O00000Oo) != null) {
            O000000o(exj.O00000Oo(), 0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.O00000o.O00000o && this.O00000o.getChildCount() > 0) {
            View childAt = this.O00000o.getChildAt(0);
            exl exl = this.O00000o;
            View childAt2 = exl.getChildAt(exl.getChildCount() - 1);
            int O00000o2 = ((i - exm.O00000o(childAt)) / 2) - exm.O00000o0(childAt);
            int O00000o3 = ((i - exm.O00000o(childAt2)) / 2) - exm.O000000o(childAt2);
            exl exl2 = this.O00000o;
            exl2.setMinimumWidth(exl2.getMeasuredWidth());
            setPadding(O00000o2, getPaddingTop(), O00000o3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void setCustomTabColorizer(O0000OOo o0000OOo) {
        exl exl = this.O00000o;
        exl.f15921O000000o = o0000OOo;
        exl.invalidate();
    }

    public void setCustomTabView(O0000Oo0 o0000Oo0) {
        this.O0000Oo = o0000Oo0;
    }

    public void setDefaultTabTextColor(int i) {
        this.O0000o00 = ColorStateList.valueOf(i);
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        this.O0000o00 = colorStateList;
    }

    public void setDefaultTextMinWidth(int i) {
        this.O0000o0O = i;
    }

    public void setDistributeEvenly(boolean z) {
        this.O00000oo = z;
    }

    public void setDividerColors(int... iArr) {
        exl exl = this.O00000o;
        exl.f15921O000000o = null;
        exl.O00000Oo.f15922O000000o = iArr;
        exl.invalidate();
    }

    public void setDoStartAnim(boolean z) {
        this.O0000O0o = z;
    }

    public void setIndicationInterpolator(exk exk) {
        exl exl = this.O00000o;
        exl.O00000o0 = exk;
        exl.invalidate();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    public void setMediator(exj exj) {
        TextView textView;
        this.O00000o.removeAllViews();
        this.O00000Oo = exj;
        if (exj != null && !exj.O00000o0()) {
            exj.O000000o(new O00000Oo(this, (byte) 0));
            int i = 0;
            while (i < this.O00000Oo.O000000o()) {
                O0000Oo0 o0000Oo0 = this.O0000Oo;
                if (o0000Oo0 == null) {
                    CharSequence O000000o2 = this.O00000Oo.O000000o(i);
                    TextView textView2 = new TextView(getContext());
                    textView2.setGravity(17);
                    textView2.setText(O000000o2);
                    textView2.setTextColor(this.O0000o00);
                    textView2.setTextSize(0, this.O0000o0o);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                    int i2 = this.O0000OoO;
                    if (i2 != -1) {
                        textView2.setBackgroundResource(i2);
                    }
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView2.setAllCaps(this.O0000Ooo);
                    }
                    int i3 = this.O0000o0;
                    textView2.setPadding(i3, 0, i3, 0);
                    int i4 = this.O0000o0O;
                    textView = textView2;
                    if (i4 > 0) {
                        textView2.setMinWidth(i4);
                        textView = textView2;
                    }
                } else {
                    textView = o0000Oo0.O000000o(this.O00000o, i, this.O00000Oo);
                }
                if (textView != null) {
                    if (this.O00000oo) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams.width = 0;
                        layoutParams.weight = 1.0f;
                    }
                    O000000o o000000o = this.O0000OOo;
                    if (o000000o != null) {
                        textView.setOnClickListener(o000000o);
                    }
                    View view = textView;
                    this.O00000o.addView(view);
                    if (i == this.O00000Oo.O00000Oo()) {
                        view.setSelected(true);
                    }
                    i++;
                } else {
                    throw new IllegalStateException("tabView is null.");
                }
            }
        }
    }

    public void setOnScrollChangeListener(O00000o0 o00000o0) {
        this.O0000Oo0 = o00000o0;
    }

    public void setOnTabClickListener(O00000o o00000o) {
        this.O00000o0 = o00000o;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        exl exl = this.O00000o;
        exl.f15921O000000o = null;
        exl.O00000Oo.O00000Oo = iArr;
        exl.invalidate();
    }

    private void O000000o(boolean z, int i) {
        if (this.f3992O000000o == null) {
            this.f3992O000000o = new ValueAnimator();
        }
        if (z) {
            this.f3992O000000o.setIntValues(getScrollX(), i);
            this.f3992O000000o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.xiaomi.shopviews.widget.smarttab.SmartTabLayout.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SmartTabLayout.this.setScrollX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.f3992O000000o.setDuration(200L);
            this.f3992O000000o.start();
        } else if (this.f3992O000000o.isRunning()) {
            this.f3992O000000o.end();
        }
    }

    class O000000o implements View.OnClickListener {
        private O000000o() {
        }

        /* synthetic */ O000000o(SmartTabLayout smartTabLayout, byte b) {
            this();
        }

        public final void onClick(View view) {
            view.getId();
            for (int i = 0; i < SmartTabLayout.this.O00000o.getChildCount(); i++) {
                if (view == SmartTabLayout.this.O00000o.getChildAt(i)) {
                    SmartTabLayout.this.O00000Oo.O00000Oo(i);
                    return;
                }
            }
        }
    }

    class O00000Oo implements ViewPager.O0000O0o {
        private int O00000Oo;

        /* synthetic */ O00000Oo(SmartTabLayout smartTabLayout, byte b) {
            this();
        }

        private O00000Oo() {
            this.O00000Oo = 0;
        }

        public final void onPageScrollStateChanged(int i) {
            this.O00000Oo = i;
            if (SmartTabLayout.this.O00000oO != null) {
                SmartTabLayout.this.O00000oO.onPageScrollStateChanged(i);
            }
        }

        public final void onPageScrolled(int i, float f, int i2) {
            int childCount = SmartTabLayout.this.O00000o.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SmartTabLayout.this.O00000o.O000000o(i, f);
                SmartTabLayout.this.O000000o(i, f);
                if (SmartTabLayout.this.O00000oO != null) {
                    SmartTabLayout.this.O00000oO.onPageScrolled(i, f, i2);
                }
            }
        }

        public final void onPageSelected(int i) {
            if (this.O00000Oo == 0) {
                SmartTabLayout.this.O00000o.O000000o(i, 0.0f);
                SmartTabLayout.this.O000000o(i, 0.0f);
            }
            int i2 = 0;
            while (i2 < SmartTabLayout.this.O00000o.getChildCount()) {
                SmartTabLayout.this.O00000o.getChildAt(i2).setSelected(i == i2);
                i2++;
            }
            if (SmartTabLayout.this.O00000oO != null) {
                SmartTabLayout.this.O00000oO.onPageSelected(i);
            }
        }
    }

    static class O0000O0o implements O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private final LayoutInflater f3996O000000o;
        private final int O00000Oo;
        private final int O00000o0;

        /* synthetic */ O0000O0o(Context context, int i, int i2, byte b) {
            this(context, i, i2);
        }

        private O0000O0o(Context context, int i, int i2) {
            this.f3996O000000o = LayoutInflater.from(context);
            this.O00000Oo = i;
            this.O00000o0 = i2;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View] */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [int, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final View O000000o(ViewGroup viewGroup, int i, exj exj) {
            int i2 = this.O00000Oo;
            TextView textView = null;
            View inflate = i2 != -1 ? this.f3996O000000o.inflate(i2, viewGroup, false) : null;
            int i3 = this.O00000o0;
            if (!(i3 == -1 || inflate == 0)) {
                textView = inflate.findViewById(i3);
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = inflate;
            }
            if (textView != null) {
                textView.setText(exj.O000000o(i));
            }
            return inflate;
        }
    }
}
