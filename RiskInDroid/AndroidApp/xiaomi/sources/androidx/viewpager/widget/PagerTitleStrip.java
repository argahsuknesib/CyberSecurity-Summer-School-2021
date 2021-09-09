package androidx.viewpager.widget;

import _m_j.cy;
import _m_j.jz;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.O000000o
public class PagerTitleStrip extends ViewGroup {
    private static final int[] O0000o0 = {16842804, 16842901, 16842904, 16842927};
    private static final int[] O0000o0O = {16843660};

    /* renamed from: O000000o  reason: collision with root package name */
    ViewPager f3029O000000o;
    TextView O00000Oo;
    TextView O00000o;
    TextView O00000o0;
    float O00000oO;
    int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;
    private final O000000o O0000Ooo;
    private WeakReference<jz> O0000o00;
    private int O0000o0o;

    static class O00000Oo extends SingleLineTransformationMethod {

        /* renamed from: O000000o  reason: collision with root package name */
        private Locale f3031O000000o;

        O00000Oo(Context context) {
            this.f3031O000000o = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f3031O000000o);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new O00000Oo(textView.getContext()));
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000O0o = -1;
        this.O00000oO = -1.0f;
        this.O0000Ooo = new O000000o();
        TextView textView = new TextView(context);
        this.O00000Oo = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.O00000o0 = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.O00000o = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O0000o0);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            cy.O000000o(this.O00000Oo, resourceId);
            cy.O000000o(this.O00000o0, resourceId);
            cy.O000000o(this.O00000o, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.O00000Oo.setTextSize(0, f);
            this.O00000o0.setTextSize(0, f);
            this.O00000o.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.O00000Oo.setTextColor(color);
            this.O00000o0.setTextColor(color);
            this.O00000o.setTextColor(color);
        }
        this.O0000Oo0 = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.O00000oo = this.O00000o0.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.O00000Oo.setEllipsize(TextUtils.TruncateAt.END);
        this.O00000o0.setEllipsize(TextUtils.TruncateAt.END);
        this.O00000o.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, O0000o0O);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.O00000Oo);
            setSingleLineAllCaps(this.O00000o0);
            setSingleLineAllCaps(this.O00000o);
        } else {
            this.O00000Oo.setSingleLine();
            this.O00000o0.setSingleLine();
            this.O00000o.setSingleLine();
        }
        this.O0000OOo = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.O0000OOo = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.O0000OOo;
    }

    public void setNonPrimaryAlpha(float f) {
        this.O0000o0o = ((int) (f * 255.0f)) & 255;
        int i = (this.O0000o0o << 24) | (this.O00000oo & 16777215);
        this.O00000Oo.setTextColor(i);
        this.O00000o.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.O00000oo = i;
        this.O00000o0.setTextColor(i);
        int i2 = (this.O0000o0o << 24) | (this.O00000oo & 16777215);
        this.O00000Oo.setTextColor(i2);
        this.O00000o.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.O0000Oo0 = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            jz adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.O0000Ooo);
            viewPager.addOnAdapterChangeListener(this.O0000Ooo);
            this.f3029O000000o = viewPager;
            WeakReference<jz> weakReference = this.O0000o00;
            O000000o(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f3029O000000o;
        if (viewPager != null) {
            O000000o(viewPager.getAdapter(), (jz) null);
            this.f3029O000000o.setInternalPageChangeListener(null);
            this.f3029O000000o.removeOnAdapterChangeListener(this.O0000Ooo);
            this.f3029O000000o = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, jz jzVar) {
        int count = jzVar != null ? jzVar.getCount() : 0;
        this.O0000Oo = true;
        CharSequence charSequence = null;
        this.O00000Oo.setText((i <= 0 || jzVar == null) ? null : jzVar.getPageTitle(i - 1));
        this.O00000o0.setText((jzVar == null || i >= count) ? null : jzVar.getPageTitle(i));
        int i2 = i + 1;
        if (i2 < count && jzVar != null) {
            charSequence = jzVar.getPageTitle(i2);
        }
        this.O00000o.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.O00000Oo.measure(makeMeasureSpec, makeMeasureSpec2);
        this.O00000o0.measure(makeMeasureSpec, makeMeasureSpec2);
        this.O00000o.measure(makeMeasureSpec, makeMeasureSpec2);
        this.O0000O0o = i;
        if (!this.O0000OoO) {
            O000000o(i, this.O00000oO, false);
        }
        this.O0000Oo = false;
    }

    public void requestLayout() {
        if (!this.O0000Oo) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jz jzVar, jz jzVar2) {
        if (jzVar != null) {
            jzVar.unregisterDataSetObserver(this.O0000Ooo);
            this.O0000o00 = null;
        }
        if (jzVar2 != null) {
            jzVar2.registerDataSetObserver(this.O0000Ooo);
            this.O0000o00 = new WeakReference<>(jzVar2);
        }
        ViewPager viewPager = this.f3029O000000o;
        if (viewPager != null) {
            this.O0000O0o = -1;
            this.O00000oO = -1.0f;
            O000000o(viewPager.getCurrentItem(), jzVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void O000000o(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = i;
        float f2 = f;
        if (i6 != this.O0000O0o) {
            O000000o(i6, this.f3029O000000o.getAdapter());
        } else if (!z && f2 == this.O00000oO) {
            return;
        }
        this.O0000OoO = true;
        int measuredWidth = this.O00000Oo.getMeasuredWidth();
        int measuredWidth2 = this.O00000o0.getMeasuredWidth();
        int measuredWidth3 = this.O00000o.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (((float) i9) * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.O00000Oo.getBaseline();
        int baseline2 = this.O00000o0.getBaseline();
        int baseline3 = this.O00000o.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = max - baseline;
        int i13 = max - baseline2;
        int i14 = max - baseline3;
        int i15 = measuredWidth3;
        int max2 = Math.max(Math.max(this.O00000Oo.getMeasuredHeight() + i12, this.O00000o0.getMeasuredHeight() + i13), this.O00000o.getMeasuredHeight() + i14);
        int i16 = this.O0000Oo0 & 112;
        if (i16 == 16) {
            i5 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i16 != 80) {
            i4 = i12 + paddingTop;
            i2 = i13 + paddingTop;
            i3 = paddingTop + i14;
            TextView textView = this.O00000o0;
            textView.layout(i10, i2, i11, textView.getMeasuredHeight() + i2);
            int min = Math.min(paddingLeft, (i10 - this.O0000OOo) - measuredWidth);
            TextView textView2 = this.O00000Oo;
            textView2.layout(min, i4, measuredWidth + min, textView2.getMeasuredHeight() + i4);
            int max3 = Math.max((width - paddingRight) - i15, i11 + this.O0000OOo);
            TextView textView3 = this.O00000o;
            textView3.layout(max3, i3, max3 + i15, textView3.getMeasuredHeight() + i3);
            this.O00000oO = f;
            this.O0000OoO = false;
        } else {
            i5 = (height - paddingBottom) - max2;
        }
        i4 = i12 + i5;
        i2 = i13 + i5;
        i3 = i5 + i14;
        TextView textView4 = this.O00000o0;
        textView4.layout(i10, i2, i11, textView4.getMeasuredHeight() + i2);
        int min2 = Math.min(paddingLeft, (i10 - this.O0000OOo) - measuredWidth);
        TextView textView22 = this.O00000Oo;
        textView22.layout(min2, i4, measuredWidth + min2, textView22.getMeasuredHeight() + i4);
        int max32 = Math.max((width - paddingRight) - i15, i11 + this.O0000OOo);
        TextView textView32 = this.O00000o;
        textView32.layout(max32, i3, max32 + i15, textView32.getMeasuredHeight() + i3);
        this.O00000oO = f;
        this.O0000OoO = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
            this.O00000Oo.measure(childMeasureSpec2, childMeasureSpec);
            this.O00000o0.measure(childMeasureSpec2, childMeasureSpec);
            this.O00000o.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                i3 = View.MeasureSpec.getSize(i2);
            } else {
                i3 = Math.max(getMinHeight(), this.O00000o0.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i3, i2, this.O00000o0.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3029O000000o != null) {
            float f = this.O00000oO;
            if (f < 0.0f) {
                f = 0.0f;
            }
            O000000o(this.O0000O0o, f, true);
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    class O000000o extends DataSetObserver implements ViewPager.O00000o, ViewPager.O0000O0o {
        private int O00000Oo;

        O000000o() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.O000000o(i, f, false);
        }

        public final void onPageSelected(int i) {
            if (this.O00000Oo == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.O000000o(pagerTitleStrip.f3029O000000o.getCurrentItem(), PagerTitleStrip.this.f3029O000000o.getAdapter());
                float f = 0.0f;
                if (PagerTitleStrip.this.O00000oO >= 0.0f) {
                    f = PagerTitleStrip.this.O00000oO;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.O000000o(pagerTitleStrip2.f3029O000000o.getCurrentItem(), f, true);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            this.O00000Oo = i;
        }

        public final void onAdapterChanged(ViewPager viewPager, jz jzVar, jz jzVar2) {
            PagerTitleStrip.this.O000000o(jzVar, jzVar2);
        }

        public final void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.O000000o(pagerTitleStrip.f3029O000000o.getCurrentItem(), PagerTitleStrip.this.f3029O000000o.getAdapter());
            float f = 0.0f;
            if (PagerTitleStrip.this.O00000oO >= 0.0f) {
                f = PagerTitleStrip.this.O00000oO;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.O000000o(pagerTitleStrip2.f3029O000000o.getCurrentItem(), f, true);
        }
    }
}
