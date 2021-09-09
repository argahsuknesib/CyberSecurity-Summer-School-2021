package com.xiaomi.smarthome.library.common.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;

public class CircleIndicator extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewPager f9149O000000o;
    public int O00000Oo = R.drawable.mj_white_radius;
    public Animator O00000o;
    public int O00000o0 = R.drawable.mj_white_radius;
    public Animator O00000oO;
    public int O00000oo = -1;
    private int O0000O0o = -1;
    private int O0000OOo = -1;
    private int O0000Oo = R.animator.mj_scale_with_alpha;
    private int O0000Oo0 = -1;
    private int O0000OoO = 0;
    private Animator O0000Ooo;
    private final ViewPager.O0000O0o O0000o0 = new ViewPager.O0000O0o() {
        /* class com.xiaomi.smarthome.library.common.widget.CircleIndicator.AnonymousClass1 */

        public final void onPageScrollStateChanged(int i) {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            if (CircleIndicator.this.f9149O000000o.getAdapter() != null && CircleIndicator.this.f9149O000000o.getAdapter().getCount() > 0) {
                if (CircleIndicator.this.O00000oO.isRunning()) {
                    CircleIndicator.this.O00000oO.cancel();
                }
                if (CircleIndicator.this.O00000o.isRunning()) {
                    CircleIndicator.this.O00000o.cancel();
                }
                if (CircleIndicator.this.O00000oo >= 0) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    View childAt = circleIndicator.getChildAt(circleIndicator.O00000oo);
                    childAt.setBackgroundResource(CircleIndicator.this.O00000o0);
                    CircleIndicator.this.O00000oO.setTarget(childAt);
                    CircleIndicator.this.O00000oO.start();
                }
                View childAt2 = CircleIndicator.this.getChildAt(i);
                childAt2.setBackgroundResource(CircleIndicator.this.O00000Oo);
                CircleIndicator.this.O00000o.setTarget(childAt2);
                CircleIndicator.this.O00000o.start();
                CircleIndicator.this.O00000oo = i;
            }
        }
    };
    private Animator O0000o00;
    private DataSetObserver O0000o0O = new DataSetObserver() {
        /* class com.xiaomi.smarthome.library.common.widget.CircleIndicator.AnonymousClass2 */

        public final void onChanged() {
            super.onChanged();
            int count = CircleIndicator.this.f9149O000000o.getAdapter().getCount();
            if (count != CircleIndicator.this.getChildCount()) {
                if (CircleIndicator.this.O00000oo < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.O00000oo = circleIndicator.f9149O000000o.getCurrentItem();
                } else {
                    CircleIndicator.this.O00000oo = -1;
                }
                CircleIndicator.this.O000000o();
            }
        }
    };

    public CircleIndicator(Context context) {
        super(context);
        O000000o(context, (AttributeSet) null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        setGravity(17);
        O00000Oo(context, attributeSet);
        O000000o(context);
    }

    private void O00000Oo(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ci_animator, R.attr.ci_animator_reverse, R.attr.ci_drawable, R.attr.ci_drawable_unselected, R.attr.ci_height, R.attr.ci_margin, R.attr.ci_width});
            this.O0000OOo = obtainStyledAttributes.getDimensionPixelSize(6, -1);
            this.O0000Oo0 = obtainStyledAttributes.getDimensionPixelSize(4, -1);
            this.O0000O0o = obtainStyledAttributes.getDimensionPixelSize(5, -1);
            this.O0000Oo = obtainStyledAttributes.getResourceId(0, R.animator.mj_scale_with_alpha);
            this.O0000OoO = obtainStyledAttributes.getResourceId(1, 0);
            this.O00000Oo = obtainStyledAttributes.getResourceId(2, R.drawable.mj_white_radius);
            this.O00000o0 = obtainStyledAttributes.getResourceId(3, this.O00000Oo);
            obtainStyledAttributes.recycle();
        }
    }

    private void O000000o(Context context) {
        int i = this.O0000OOo;
        if (i < 0) {
            i = O00000Oo();
        }
        this.O0000OOo = i;
        int i2 = this.O0000Oo0;
        if (i2 < 0) {
            i2 = O00000Oo();
        }
        this.O0000Oo0 = i2;
        int i3 = this.O0000O0o;
        if (i3 < 0) {
            i3 = O00000Oo();
        }
        this.O0000O0o = i3;
        int i4 = this.O0000Oo;
        if (i4 == 0) {
            i4 = R.animator.mj_scale_with_alpha;
        }
        this.O0000Oo = i4;
        this.O00000o = O00000Oo(context);
        this.O0000Ooo = O00000Oo(context);
        this.O0000Ooo.setDuration(0);
        this.O00000oO = O00000o0(context);
        this.O0000o00 = O00000o0(context);
        this.O0000o00.setDuration(0);
        int i5 = this.O00000Oo;
        if (i5 == 0) {
            i5 = R.drawable.mj_white_radius;
        }
        this.O00000Oo = i5;
        int i6 = this.O00000o0;
        if (i6 == 0) {
            i6 = this.O00000Oo;
        }
        this.O00000o0 = i6;
    }

    private Animator O00000Oo(Context context) {
        return AnimatorInflater.loadAnimator(context, this.O0000Oo);
    }

    private Animator O00000o0(Context context) {
        int i = this.O0000OoO;
        if (i != 0) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.O0000Oo);
        loadAnimator.setInterpolator(new O000000o(this, (byte) 0));
        return loadAnimator;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f9149O000000o = viewPager;
        ViewPager viewPager2 = this.f9149O000000o;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            O000000o();
            this.f9149O000000o.removeOnPageChangeListener(this.O0000o0);
            this.f9149O000000o.addOnPageChangeListener(this.O0000o0);
            this.f9149O000000o.getAdapter().registerDataSetObserver(this.O0000o0O);
            this.O0000o0.onPageSelected(this.f9149O000000o.getCurrentItem());
        }
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        ViewPager viewPager = this.f9149O000000o;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(o0000O0o);
            this.f9149O000000o.addOnPageChangeListener(o0000O0o);
            return;
        }
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    public final void O000000o() {
        removeAllViews();
        int count = this.f9149O000000o.getAdapter().getCount();
        if (count > 0) {
            int currentItem = this.f9149O000000o.getCurrentItem();
            for (int i = 0; i < count; i++) {
                if (currentItem == i) {
                    O000000o(this.O00000Oo, this.O0000Ooo);
                } else {
                    O000000o(this.O00000o0, this.O0000o00);
                }
            }
        }
    }

    private void O000000o(int i, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i);
        addView(view, this.O0000OOo, this.O0000Oo0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        int i2 = this.O0000O0o;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    class O000000o implements Interpolator {
        private O000000o() {
        }

        /* synthetic */ O000000o(CircleIndicator circleIndicator, byte b) {
            this();
        }

        public final float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    private int O00000Oo() {
        return (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
    }
}
