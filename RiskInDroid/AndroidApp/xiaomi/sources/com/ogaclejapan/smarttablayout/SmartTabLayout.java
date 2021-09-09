package com.ogaclejapan.smarttablayout;

import _m_j.cb;
import _m_j.cox;
import _m_j.coy;
import _m_j.coz;
import _m_j.jz;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
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
import com.xiaomi.smarthome.R;

public class SmartTabLayout extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final coy f5366O000000o;
    public ViewPager O00000Oo;
    public O00000o O00000o;
    public ViewPager.O0000O0o O00000o0;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o;
    private ColorStateList O0000OOo;
    private int O0000Oo;
    private float O0000Oo0;
    private int O0000OoO;
    private O00000o0 O0000Ooo;
    private O000000o O0000o0;
    private O0000Oo0 O0000o00;
    private boolean O0000o0O;

    public interface O00000o {
        void onTabClicked(int i);
    }

    public interface O00000o0 {
    }

    public interface O0000OOo {
        int O000000o(int i);

        int O00000Oo(int i);
    }

    public interface O0000Oo0 {
        View O000000o(ViewGroup viewGroup, int i, jz jzVar);
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
        setHorizontalScrollBarEnabled(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 12.0f, displayMetrics);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, new int[]{R.attr.stl_clickable, R.attr.stl_customTabTextLayoutId, R.attr.stl_customTabTextViewId, R.attr.stl_defaultTabBackground, R.attr.stl_defaultTabTextAllCaps, R.attr.stl_defaultTabTextColor, R.attr.stl_defaultTabTextHorizontalPadding, R.attr.stl_defaultTabTextMinWidth, R.attr.stl_defaultTabTextSize, R.attr.stl_distributeEvenly, R.attr.stl_dividerColor, R.attr.stl_dividerColors, R.attr.stl_dividerThickness, R.attr.stl_drawDecorationAfterTab, R.attr.stl_indicatorAlwaysInCenter, R.attr.stl_indicatorColor, R.attr.stl_indicatorColors, R.attr.stl_indicatorCornerRadius, R.attr.stl_indicatorGravity, R.attr.stl_indicatorInFront, R.attr.stl_indicatorInterpolation, R.attr.stl_indicatorThickness, R.attr.stl_indicatorWidth, R.attr.stl_indicatorWithoutPadding, R.attr.stl_overlineColor, R.attr.stl_overlineThickness, R.attr.stl_titleOffset, R.attr.stl_underlineColor, R.attr.stl_underlineThickness}, i, 0);
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
        this.O00000oO = layoutDimension;
        this.O00000oo = resourceId;
        this.O0000O0o = z;
        this.O0000OOo = colorStateList == null ? ColorStateList.valueOf(-67108864) : colorStateList;
        this.O0000Oo0 = dimension;
        this.O0000Oo = dimensionPixelSize;
        this.O0000OoO = dimensionPixelSize2;
        this.O0000o0 = z3 ? new O000000o(this, (byte) 0) : null;
        this.O0000o0O = z2;
        if (resourceId2 != -1) {
            this.O0000o00 = new O0000O0o(getContext(), resourceId2, resourceId3, (byte) 0);
        }
        this.f5366O000000o = new coy(context2, attributeSet2);
        if (!z2 || !this.f5366O000000o.f14176O000000o) {
            setFillViewport(!this.f5366O000000o.f14176O000000o);
            addView(this.f5366O000000o, -1, -1);
            return;
        }
        throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f5366O000000o.f14176O000000o && this.f5366O000000o.getChildCount() > 0) {
            View childAt = this.f5366O000000o.getChildAt(0);
            coy coy = this.f5366O000000o;
            View childAt2 = coy.getChildAt(coy.getChildCount() - 1);
            int O000000o2 = ((i - coz.O000000o(childAt)) / 2) - coz.O00000oo(childAt);
            int O000000o3 = ((i - coz.O000000o(childAt2)) / 2) - coz.O0000O0o(childAt2);
            coy coy2 = this.f5366O000000o;
            coy2.setMinimumWidth(coy2.getMeasuredWidth());
            cb.O00000Oo(this, O000000o2, getPaddingTop(), O000000o3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewPager viewPager;
        super.onLayout(z, i, i2, i3, i4);
        if (z && (viewPager = this.O00000Oo) != null) {
            O000000o(viewPager.getCurrentItem(), 0.0f);
        }
    }

    public void setIndicationInterpolator(cox cox) {
        coy coy = this.f5366O000000o;
        coy.O00000o0 = cox;
        coy.invalidate();
    }

    public void setCustomTabColorizer(O0000OOo o0000OOo) {
        coy coy = this.f5366O000000o;
        coy.O00000o = o0000OOo;
        coy.invalidate();
    }

    public void setDefaultTabTextColor(int i) {
        this.O0000OOo = ColorStateList.valueOf(i);
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        this.O0000OOo = colorStateList;
    }

    public void setDistributeEvenly(boolean z) {
        this.O0000o0O = z;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        coy coy = this.f5366O000000o;
        coy.O00000o = null;
        coy.O00000Oo.f14177O000000o = iArr;
        coy.invalidate();
    }

    public void setDividerColors(int... iArr) {
        coy coy = this.f5366O000000o;
        coy.O00000o = null;
        coy.O00000Oo.O00000Oo = iArr;
        coy.invalidate();
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000o0 = o0000O0o;
    }

    public void setOnScrollChangeListener(O00000o0 o00000o0) {
        this.O0000Ooo = o00000o0;
    }

    public void setOnTabClickListener(O00000o o00000o) {
        this.O00000o = o00000o;
    }

    public void setCustomTabView(O0000Oo0 o0000Oo0) {
        this.O0000o00 = o0000Oo0;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    public void setViewPager(ViewPager viewPager) {
        TextView textView;
        this.f5366O000000o.removeAllViews();
        this.O00000Oo = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.addOnPageChangeListener(new O00000Oo(this, (byte) 0));
            jz adapter = this.O00000Oo.getAdapter();
            int i = 0;
            while (i < adapter.getCount()) {
                O0000Oo0 o0000Oo0 = this.O0000o00;
                if (o0000Oo0 == null) {
                    CharSequence pageTitle = adapter.getPageTitle(i);
                    TextView textView2 = new TextView(getContext());
                    textView2.setGravity(17);
                    textView2.setText(pageTitle);
                    textView2.setTextColor(this.O0000OOo);
                    textView2.setTextSize(0, this.O0000Oo0);
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                    int i2 = this.O00000oo;
                    if (i2 != -1) {
                        textView2.setBackgroundResource(i2);
                    } else if (Build.VERSION.SDK_INT >= 11) {
                        TypedValue typedValue = new TypedValue();
                        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                        textView2.setBackgroundResource(typedValue.resourceId);
                    }
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView2.setAllCaps(this.O0000O0o);
                    }
                    int i3 = this.O0000Oo;
                    textView2.setPadding(i3, 0, i3, 0);
                    int i4 = this.O0000OoO;
                    textView = textView2;
                    if (i4 > 0) {
                        textView2.setMinWidth(i4);
                        textView = textView2;
                    }
                } else {
                    textView = o0000Oo0.O000000o(this.f5366O000000o, i, adapter);
                }
                if (textView != null) {
                    if (this.O0000o0O) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams.width = 0;
                        layoutParams.weight = 1.0f;
                    }
                    O000000o o000000o = this.O0000o0;
                    if (o000000o != null) {
                        textView.setOnClickListener(o000000o);
                    }
                    this.f5366O000000o.addView(textView);
                    if (i == this.O00000Oo.getCurrentItem()) {
                        textView.setSelected(true);
                    }
                    i++;
                } else {
                    throw new IllegalStateException("tabView is null.");
                }
            }
        }
    }

    public final View O000000o(int i) {
        return this.f5366O000000o.getChildAt(i);
    }

    public final void O000000o(int i, float f) {
        int i2;
        int i3;
        int i4;
        int childCount = this.f5366O000000o.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            boolean O0000Oo02 = coz.O0000Oo0(this);
            View childAt = this.f5366O000000o.getChildAt(i);
            int O00000Oo2 = (int) (((float) (coz.O00000Oo(childAt) + coz.O0000OOo(childAt))) * f);
            if (this.f5366O000000o.f14176O000000o) {
                if (0.0f < f && f < 1.0f) {
                    View childAt2 = this.f5366O000000o.getChildAt(i + 1);
                    O00000Oo2 = Math.round(f * ((float) ((coz.O00000Oo(childAt) / 2) + coz.O0000O0o(childAt) + (coz.O00000Oo(childAt2) / 2) + coz.O00000oo(childAt2))));
                }
                View childAt3 = this.f5366O000000o.getChildAt(0);
                if (O0000Oo02) {
                    int O00000Oo3 = coz.O00000Oo(childAt3) + coz.O0000O0o(childAt3);
                    int O00000Oo4 = coz.O00000Oo(childAt) + coz.O0000O0o(childAt);
                    i4 = (coz.O00000Oo(childAt, false) - coz.O0000O0o(childAt)) - O00000Oo2;
                    i3 = (O00000Oo3 - O00000Oo4) / 2;
                } else {
                    int O00000Oo5 = coz.O00000Oo(childAt3) + coz.O00000oo(childAt3);
                    int O00000Oo6 = coz.O00000Oo(childAt) + coz.O00000oo(childAt);
                    i4 = (coz.O000000o(childAt, false) - coz.O00000oo(childAt)) + O00000Oo2;
                    i3 = (O00000Oo5 - O00000Oo6) / 2;
                }
                scrollTo(i4 - i3, 0);
                return;
            }
            if (this.O00000oO == -1) {
                if (0.0f < f && f < 1.0f) {
                    View childAt4 = this.f5366O000000o.getChildAt(i + 1);
                    O00000Oo2 = Math.round(f * ((float) ((coz.O00000Oo(childAt) / 2) + coz.O0000O0o(childAt) + (coz.O00000Oo(childAt4) / 2) + coz.O00000oo(childAt4))));
                }
                i2 = O0000Oo02 ? (((-coz.O00000o0(childAt)) / 2) + (getWidth() / 2)) - coz.O00000o(this) : ((coz.O00000o0(childAt) / 2) - (getWidth() / 2)) + coz.O00000o(this);
            } else {
                if (O0000Oo02) {
                    if (i > 0 || f > 0.0f) {
                        i2 = this.O00000oO;
                    }
                } else if (i > 0 || f > 0.0f) {
                    i2 = -this.O00000oO;
                }
                i2 = 0;
            }
            int O000000o2 = coz.O000000o(childAt, false);
            int O00000oo2 = coz.O00000oo(childAt);
            scrollTo(i2 + (O0000Oo02 ? (((O000000o2 + O00000oo2) - O00000Oo2) - getWidth()) + coz.O00000oO(this) : (O000000o2 - O00000oo2) + O00000Oo2), 0);
        }
    }

    static class O0000O0o implements O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        private final LayoutInflater f5369O000000o;
        private final int O00000Oo;
        private final int O00000o0;

        /* synthetic */ O0000O0o(Context context, int i, int i2, byte b) {
            this(context, i, i2);
        }

        private O0000O0o(Context context, int i, int i2) {
            this.f5369O000000o = LayoutInflater.from(context);
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
        public final View O000000o(ViewGroup viewGroup, int i, jz jzVar) {
            int i2 = this.O00000Oo;
            TextView textView = null;
            View inflate = i2 != -1 ? this.f5369O000000o.inflate(i2, viewGroup, false) : null;
            int i3 = this.O00000o0;
            if (!(i3 == -1 || inflate == null)) {
                textView = inflate.findViewById(i3);
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = (TextView) inflate;
            }
            if (textView != null) {
                textView.setText(jzVar.getPageTitle(i));
            }
            return inflate;
        }
    }

    class O00000Oo implements ViewPager.O0000O0o {
        private int O00000Oo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(SmartTabLayout smartTabLayout, byte b) {
            this();
        }

        public final void onPageScrolled(int i, float f, int i2) {
            int childCount = SmartTabLayout.this.f5366O000000o.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SmartTabLayout.this.f5366O000000o.O000000o(i, f);
                SmartTabLayout.this.O000000o(i, f);
                if (SmartTabLayout.this.O00000o0 != null) {
                    SmartTabLayout.this.O00000o0.onPageScrolled(i, f, i2);
                }
            }
        }

        public final void onPageScrollStateChanged(int i) {
            this.O00000Oo = i;
            if (SmartTabLayout.this.O00000o0 != null) {
                SmartTabLayout.this.O00000o0.onPageScrollStateChanged(i);
            }
        }

        public final void onPageSelected(int i) {
            if (this.O00000Oo == 0) {
                SmartTabLayout.this.f5366O000000o.O000000o(i, 0.0f);
                SmartTabLayout.this.O000000o(i, 0.0f);
            }
            int childCount = SmartTabLayout.this.f5366O000000o.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                SmartTabLayout.this.f5366O000000o.getChildAt(i2).setSelected(i == i2);
                i2++;
            }
            if (SmartTabLayout.this.O00000o0 != null) {
                SmartTabLayout.this.O00000o0.onPageSelected(i);
            }
        }
    }

    class O000000o implements View.OnClickListener {
        private O000000o() {
        }

        /* synthetic */ O000000o(SmartTabLayout smartTabLayout, byte b) {
            this();
        }

        public final void onClick(View view) {
            for (int i = 0; i < SmartTabLayout.this.f5366O000000o.getChildCount(); i++) {
                if (view == SmartTabLayout.this.f5366O000000o.getChildAt(i)) {
                    if (SmartTabLayout.this.O00000o != null) {
                        SmartTabLayout.this.O00000o.onTabClicked(i);
                    }
                    SmartTabLayout.this.O00000Oo.setCurrentItem(i);
                    return;
                }
            }
        }
    }
}
