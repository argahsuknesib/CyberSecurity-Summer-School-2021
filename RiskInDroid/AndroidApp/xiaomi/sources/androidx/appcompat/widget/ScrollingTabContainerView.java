package androidx.appcompat.widget;

import _m_j.OO00O0;
import _m_j.Oo;
import _m_j.o000000;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.xiaomi.smarthome.R;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator O0000OoO = new DecelerateInterpolator();

    /* renamed from: O000000o  reason: collision with root package name */
    Runnable f2728O000000o;
    LinearLayoutCompat O00000Oo;
    int O00000o;
    int O00000o0;
    int O00000oO;
    protected ViewPropertyAnimator O00000oo;
    protected final O00000o0 O0000O0o = new O00000o0();
    private Spinner O0000OOo;
    private int O0000Oo;
    private boolean O0000Oo0;

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        OO00O0 O000000o2 = OO00O0.O000000o(context);
        setContentHeight(O000000o2.O00000o0());
        this.O00000o = O000000o2.O00000oO();
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.O00000Oo = linearLayoutCompat;
        addView(this.O00000Oo, new ViewGroup.LayoutParams(-2, -1));
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.O00000Oo.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.O00000o0 = -1;
        } else {
            if (childCount > 2) {
                this.O00000o0 = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.O00000o0 = View.MeasureSpec.getSize(i) / 2;
            }
            this.O00000o0 = Math.min(this.O00000o0, this.O00000o);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O00000oO, 1073741824);
        if (z2 || !this.O0000Oo0) {
            z = false;
        }
        if (z) {
            this.O00000Oo.measure(0, makeMeasureSpec);
            if (this.O00000Oo.getMeasuredWidth() <= View.MeasureSpec.getSize(i)) {
                O00000Oo();
            } else if (!O000000o()) {
                if (this.O0000OOo == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.O0000OOo = appCompatSpinner;
                }
                removeView(this.O00000Oo);
                addView(this.O0000OOo, new ViewGroup.LayoutParams(-2, -1));
                if (this.O0000OOo.getAdapter() == null) {
                    this.O0000OOo.setAdapter((SpinnerAdapter) new O000000o());
                }
                Runnable runnable = this.f2728O000000o;
                if (runnable != null) {
                    removeCallbacks(runnable);
                    this.f2728O000000o = null;
                }
                this.O0000OOo.setSelection(this.O0000Oo);
            }
        } else {
            O00000Oo();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.O0000Oo);
        }
    }

    private boolean O000000o() {
        Spinner spinner = this.O0000OOo;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.O0000Oo0 = z;
    }

    private boolean O00000Oo() {
        if (!O000000o()) {
            return false;
        }
        removeView(this.O0000OOo);
        addView(this.O00000Oo, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.O0000OOo.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.O0000Oo = i;
        int childCount = this.O00000Oo.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.O00000Oo.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.O00000Oo.getChildAt(i);
                Runnable runnable = this.f2728O000000o;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                this.f2728O000000o = new Runnable() {
                    /* class androidx.appcompat.widget.ScrollingTabContainerView.AnonymousClass1 */

                    public final void run() {
                        ScrollingTabContainerView.this.smoothScrollTo(childAt2.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        ScrollingTabContainerView.this.f2728O000000o = null;
                    }
                };
                post(this.f2728O000000o);
            }
            i2++;
        }
        Spinner spinner = this.O0000OOo;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.O00000oO = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OO00O0 O000000o2 = OO00O0.O000000o(getContext());
        setContentHeight(O000000o2.O00000o0());
        this.O00000o = O000000o2.O00000oO();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2728O000000o;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2728O000000o;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    class O00000Oo extends LinearLayout {

        /* renamed from: O000000o  reason: collision with root package name */
        ActionBar.O000000o f2731O000000o;
        private TextView O00000o;
        private final int[] O00000o0 = {16842964};
        private ImageView O00000oO;
        private View O00000oo;

        public O00000Oo(Context context, ActionBar.O000000o o000000o, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f2731O000000o = o000000o;
            Oo O000000o2 = Oo.O000000o(context, null, this.O00000o0, R.attr.actionBarTabStyle, 0);
            if (O000000o2.O0000O0o(0)) {
                setBackgroundDrawable(O000000o2.O000000o(0));
            }
            O000000o2.f12340O000000o.recycle();
            setGravity(8388627);
            O000000o();
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.O00000o0 > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.O00000o0) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.O00000o0, 1073741824), i2);
            }
        }

        public final void O000000o() {
            ActionBar.O000000o o000000o = this.f2731O000000o;
            View O00000o02 = o000000o.O00000o0();
            CharSequence charSequence = null;
            if (O00000o02 != null) {
                ViewParent parent = O00000o02.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(O00000o02);
                    }
                    addView(O00000o02);
                }
                this.O00000oo = O00000o02;
                TextView textView = this.O00000o;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.O00000oO;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.O00000oO.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.O00000oo;
            if (view != null) {
                removeView(view);
                this.O00000oo = null;
            }
            Drawable O000000o2 = o000000o.O000000o();
            CharSequence O00000Oo2 = o000000o.O00000Oo();
            if (O000000o2 != null) {
                if (this.O00000oO == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.O00000oO = appCompatImageView;
                }
                this.O00000oO.setImageDrawable(O000000o2);
                this.O00000oO.setVisibility(0);
            } else {
                ImageView imageView2 = this.O00000oO;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.O00000oO.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(O00000Oo2);
            if (z) {
                if (this.O00000o == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.O00000o = appCompatTextView;
                }
                this.O00000o.setText(O00000Oo2);
                this.O00000o.setVisibility(0);
            } else {
                TextView textView2 = this.O00000o;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.O00000o.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.O00000oO;
            if (imageView3 != null) {
                imageView3.setContentDescription(o000000o.O00000o());
            }
            if (!z) {
                charSequence = o000000o.O00000o();
            }
            o000000.O000000o(this, charSequence);
        }
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final int getCount() {
            return ScrollingTabContainerView.this.O00000Oo.getChildCount();
        }

        public final Object getItem(int i) {
            return ((O00000Oo) ScrollingTabContainerView.this.O00000Oo.getChildAt(i)).f2731O000000o;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                O00000Oo o00000Oo = new O00000Oo(scrollingTabContainerView.getContext(), (ActionBar.O000000o) getItem(i), true);
                o00000Oo.setBackgroundDrawable(null);
                o00000Oo.setLayoutParams(new AbsListView.LayoutParams(-1, scrollingTabContainerView.O00000oO));
                return o00000Oo;
            }
            O00000Oo o00000Oo2 = (O00000Oo) view;
            o00000Oo2.f2731O000000o = (ActionBar.O000000o) getItem(i);
            o00000Oo2.O000000o();
            return view;
        }
    }

    public class O00000o0 extends AnimatorListenerAdapter {
        private boolean O00000Oo = false;
        private int O00000o0;

        protected O00000o0() {
        }

        public final void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.O00000Oo = false;
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.O00000Oo) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.O00000oo = null;
                scrollingTabContainerView.setVisibility(this.O00000o0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.O00000Oo = true;
        }
    }
}
