package com.xiaomi.smarthome.library.common.pageindicator;

import _m_j.goh;
import _m_j.goi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

public class IconPageIndicator extends HorizontalScrollView implements goi {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f9127O000000o;
    private final LinearLayout O00000Oo;
    private ViewPager.O0000O0o O00000o;
    private ViewPager O00000o0;
    private int O00000oO;

    public IconPageIndicator(Context context) {
        this(context, null);
    }

    public IconPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHorizontalScrollBarEnabled(false);
        this.O00000Oo = new LinearLayout(context);
        this.O00000Oo.setOrientation(0);
        addView(this.O00000Oo, new FrameLayout.LayoutParams(-2, -1, 17));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f9127O000000o;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f9127O000000o;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onPageScrollStateChanged(int i) {
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        ViewPager.O0000O0o o0000O0o = this.O00000o;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.O00000o0;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.O00000o0 = viewPager;
                viewPager.setOnPageChangeListener(this);
                O000000o();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.O00000o0;
        if (viewPager != null) {
            this.O00000oO = i;
            viewPager.setCurrentItem(i);
            int childCount = this.O00000Oo.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.O00000Oo.getChildAt(i2);
                boolean z = i2 == i;
                childAt.setSelected(z);
                if (z) {
                    final View childAt2 = this.O00000Oo.getChildAt(i);
                    Runnable runnable = this.f9127O000000o;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                    }
                    this.f9127O000000o = new Runnable() {
                        /* class com.xiaomi.smarthome.library.common.pageindicator.IconPageIndicator.AnonymousClass1 */

                        public final void run() {
                            IconPageIndicator.this.smoothScrollTo(childAt2.getLeft() - ((IconPageIndicator.this.getWidth() - childAt2.getWidth()) / 2), 0);
                            IconPageIndicator.this.f9127O000000o = null;
                        }
                    };
                    post(this.f9127O000000o);
                }
                i2++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    private void O000000o() {
        this.O00000Oo.removeAllViews();
        goh goh = (goh) this.O00000o0.getAdapter();
        int O00000Oo2 = goh.O00000Oo();
        for (int i = 0; i < O00000Oo2; i++) {
            ImageView imageView = new ImageView(getContext(), null);
            imageView.setImageResource(goh.O000000o());
            if (i > 0) {
                imageView.setPadding((int) (getResources().getDisplayMetrics().density * 10.0f), 0, 0, 0);
            }
            this.O00000Oo.addView(imageView);
        }
        if (this.O00000oO > O00000Oo2) {
            this.O00000oO = O00000Oo2 - 1;
        }
        setCurrentItem(this.O00000oO);
        requestLayout();
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000o = o0000O0o;
    }
}
