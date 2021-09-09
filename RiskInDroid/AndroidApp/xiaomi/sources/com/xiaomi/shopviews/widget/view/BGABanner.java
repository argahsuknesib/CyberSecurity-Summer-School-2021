package com.xiaomi.shopviews.widget.view;

import _m_j.cb;
import _m_j.jz;
import _m_j.lm;
import _m_j.ln;
import _m_j.lo;
import _m_j.lr;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.BGAViewPager;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BGABanner extends RelativeLayout implements ViewPager.O0000O0o, BGAViewPager.O000000o {
    private static final ImageView.ScaleType[] O000OOoo = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: O000000o  reason: collision with root package name */
    public BGAViewPager f3997O000000o;
    public List<View> O00000Oo;
    public boolean O00000o;
    public List<View> O00000o0;
    public List<? extends Object> O00000oO;
    public O00000o0 O00000oo;
    public O000000o O0000O0o;
    private List<String> O0000OOo;
    private TextView O0000Oo;
    private LinearLayout O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private Drawable O0000oOO;
    private O00000Oo O0000oOo;
    private float O0000oo;
    private int O0000oo0;
    private TransitionEffect O0000ooO;
    private ImageView O0000ooo;
    private int O000O00o;
    private ViewPager.O0000O0o O000O0OO;
    private boolean O000O0Oo;
    private int O000O0o;
    private int O000O0o0;
    private Drawable O000O0oO;
    private boolean O000O0oo;
    private boolean O000OO;
    private int O000OO00;
    private float O000OO0o;
    private View O000OOOo;
    private boolean O000OOo;
    private View O000OOo0;
    private RelativeLayout O000OOoO;
    private lo O000Oo00;
    private TextView O00oOoOo;
    private ImageView.ScaleType O00oOooO;
    private int O00oOooo;

    public interface O000000o<V extends View, M> {
        void O000000o(V v, M m, int i);
    }

    public interface O00000o0<V extends View, M> {
        void O000000o(M m);
    }

    public BGABanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BGABanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = true;
        this.O0000OoO = 4000;
        this.O0000Ooo = 800;
        this.O0000o00 = 81;
        this.O0000oO0 = -1;
        this.O0000oO = R.drawable.bga_banner_selector_point_solid;
        this.O00oOooO = ImageView.ScaleType.CENTER_CROP;
        this.O00oOooo = -1;
        this.O000O00o = 2;
        this.O000O0Oo = false;
        this.O000O0o0 = -1;
        this.O000OO = true;
        this.O000OOo = true;
        this.O000Oo00 = new lo() {
            /* class com.xiaomi.shopviews.widget.view.BGABanner.AnonymousClass1 */

            public final void O000000o() {
            }
        };
        this.O0000oOo = new O00000Oo(this, (byte) 0);
        this.O0000o0 = lm.O000000o(context, 3.0f);
        this.O0000o0O = lm.O000000o(context, 6.0f);
        this.O0000o0o = lm.O000000o(context, 10.0f);
        this.O0000o = lm.O000000o(context);
        this.O0000oOO = new ColorDrawable(Color.parseColor("#44aaaaaa"));
        this.O0000ooO = TransitionEffect.Default;
        this.O000O0o = lm.O000000o(context);
        this.O000OO00 = 0;
        this.O000OO0o = 0.0f;
        O000000o(context, attributeSet);
        this.O000OOoO = new RelativeLayout(context);
        if (Build.VERSION.SDK_INT >= 16) {
            this.O000OOoO.setBackground(this.O0000oOO);
        } else {
            this.O000OOoO.setBackgroundDrawable(this.O0000oOO);
        }
        RelativeLayout relativeLayout = this.O000OOoO;
        int i2 = this.O0000o0o;
        int i3 = this.O0000o0O;
        relativeLayout.setPadding(i2, i3, i2, i3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if ((this.O0000o00 & 112) == 48) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(12);
        }
        addView(this.O000OOoO, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        if (this.O000O0Oo) {
            this.O00oOoOo = new TextView(context);
            this.O00oOoOo.setId(R.id.banner_indicatorId);
            this.O00oOoOo.setGravity(16);
            this.O00oOoOo.setSingleLine(true);
            this.O00oOoOo.setEllipsize(TextUtils.TruncateAt.END);
            this.O00oOoOo.setTextColor(this.O000O0o0);
            this.O00oOoOo.setTextSize(0, (float) this.O000O0o);
            this.O00oOoOo.setVisibility(4);
            if (this.O000O0oO != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.O00oOoOo.setBackground(this.O000O0oO);
                } else {
                    this.O00oOoOo.setBackgroundDrawable(this.O000O0oO);
                }
            }
            this.O000OOoO.addView(this.O00oOoOo, layoutParams2);
        } else {
            this.O0000Oo0 = new LinearLayout(context);
            this.O0000Oo0.setId(R.id.banner_indicatorId);
            this.O0000Oo0.setOrientation(0);
            this.O0000Oo0.setGravity(16);
            this.O000OOoO.addView(this.O0000Oo0, layoutParams2);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(15);
        this.O0000Oo = new TextView(context);
        this.O0000Oo.setGravity(16);
        this.O0000Oo.setSingleLine(true);
        this.O0000Oo.setEllipsize(TextUtils.TruncateAt.END);
        this.O0000Oo.setTextColor(this.O0000oO0);
        this.O0000Oo.setTextSize(0, (float) this.O0000o);
        this.O000OOoO.addView(this.O0000Oo, layoutParams3);
        int i4 = this.O0000o00 & 7;
        if (i4 == 3) {
            layoutParams2.addRule(9);
            layoutParams3.addRule(1, R.id.banner_indicatorId);
            this.O0000Oo.setGravity(21);
        } else if (i4 == 5) {
            layoutParams2.addRule(11);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        } else {
            layoutParams2.addRule(14);
            layoutParams3.addRule(0, R.id.banner_indicatorId);
        }
        if (this.O0000ooo == null && this.O00oOooo != -1) {
            this.O0000ooo = lm.O000000o(getContext(), this.O00oOooo, new ln(), this.O00oOooO);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams4.setMargins(0, 0, 0, this.O000OO00);
            addView(this.O0000ooo, layoutParams4);
        }
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, R.attr.banner_aspectRatio, R.attr.banner_contentBottomMargin, R.attr.banner_indicatorGravity, R.attr.banner_isNeedShowIndicatorOnOnlyOnePage, R.attr.banner_isNumberIndicator, R.attr.banner_numberIndicatorBackground, R.attr.banner_numberIndicatorTextColor, R.attr.banner_numberIndicatorTextSize, R.attr.banner_pageChangeDuration, R.attr.banner_placeholderDrawable, R.attr.banner_pointAutoPlayAble, R.attr.banner_pointAutoPlayInterval, R.attr.banner_pointContainerBackground, R.attr.banner_pointContainerLeftRightPadding, R.attr.banner_pointDrawable, R.attr.banner_pointLeftRightMargin, R.attr.banner_pointTopBottomMargin, R.attr.banner_tipTextColor, R.attr.banner_tipTextSize, R.attr.banner_transitionEffect});
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 15) {
                this.O0000oO = obtainStyledAttributes.getResourceId(index, R.drawable.bga_banner_selector_point_solid);
            } else if (index == 13) {
                this.O0000oOO = obtainStyledAttributes.getDrawable(index);
            } else if (index == 16) {
                this.O0000o0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000o0);
            } else if (index == 14) {
                this.O0000o0o = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000o0o);
            } else if (index == 17) {
                this.O0000o0O = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000o0O);
            } else if (index == 3) {
                this.O0000o00 = obtainStyledAttributes.getInt(index, this.O0000o00);
            } else if (index == 11) {
                this.O00000o = obtainStyledAttributes.getBoolean(index, this.O00000o);
            } else if (index == 12) {
                this.O0000OoO = obtainStyledAttributes.getInteger(index, this.O0000OoO);
            } else if (index == 9) {
                this.O0000Ooo = obtainStyledAttributes.getInteger(index, this.O0000Ooo);
            } else if (index == 20) {
                this.O0000ooO = TransitionEffect.values()[obtainStyledAttributes.getInt(index, TransitionEffect.Accordion.ordinal())];
            } else if (index == 18) {
                this.O0000oO0 = obtainStyledAttributes.getColor(index, this.O0000oO0);
            } else if (index == 19) {
                this.O0000o = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000o);
            } else if (index == 10) {
                this.O00oOooo = obtainStyledAttributes.getResourceId(index, this.O00oOooo);
            } else if (index == 5) {
                this.O000O0Oo = obtainStyledAttributes.getBoolean(index, this.O000O0Oo);
            } else if (index == 7) {
                this.O000O0o0 = obtainStyledAttributes.getColor(index, this.O000O0o0);
            } else if (index == 8) {
                this.O000O0o = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0o);
            } else if (index == 6) {
                this.O000O0oO = obtainStyledAttributes.getDrawable(index);
            } else if (index == 4) {
                this.O000O0oo = obtainStyledAttributes.getBoolean(index, this.O000O0oo);
            } else if (index == 2) {
                this.O000OO00 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO00);
            } else if (index == 1) {
                this.O000OO0o = obtainStyledAttributes.getFloat(index, this.O000OO0o);
            } else if (index == 0 && (i = obtainStyledAttributes.getInt(index, -1)) >= 0) {
                ImageView.ScaleType[] scaleTypeArr = O000OOoo;
                if (i < scaleTypeArr.length) {
                    this.O00oOooO = scaleTypeArr[i];
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void setPointTopBottomMargin(int i) {
        this.O0000o0O = i;
        RelativeLayout relativeLayout = this.O000OOoO;
        int i2 = this.O0000o0o;
        int i3 = this.O0000o0O;
        relativeLayout.setPadding(i2, i3, i2, i3);
    }

    public void setPageChangeDuration(int i) {
        if (i >= 0 && i <= 2000) {
            this.O0000Ooo = i;
            BGAViewPager bGAViewPager = this.f3997O000000o;
            if (bGAViewPager != null) {
                bGAViewPager.setPageChangeDuration(i);
            }
        }
    }

    public void setAutoPlayAble(boolean z) {
        this.O00000o = z;
        O00000oo();
        BGAViewPager bGAViewPager = this.f3997O000000o;
        if (bGAViewPager != null && bGAViewPager.getAdapter() != null) {
            this.f3997O000000o.getAdapter().notifyDataSetChanged();
        }
    }

    public void setAutoPlayInterval(int i) {
        this.O0000OoO = i;
    }

    public final void O000000o(List<View> list, List<? extends Object> list2, List<String> list3) {
        if (lm.O000000o(list, new Collection[0])) {
            this.O00000o = false;
            list = new ArrayList<>();
            list2 = new ArrayList<>();
            list3 = new ArrayList<>();
        }
        if (this.O00000o && list.size() < 3 && this.O00000Oo == null) {
            this.O00000o = false;
        }
        this.O00000oO = list2;
        this.O00000o0 = list;
        this.O0000OOo = list3;
        O00000Oo();
        O00000o0();
        O00000o();
    }

    public void setData(List<View> list) {
        O000000o(list, null, null);
    }

    public void setAllowUserScrollable(boolean z) {
        this.O000OO = z;
        BGAViewPager bGAViewPager = this.f3997O000000o;
        if (bGAViewPager != null) {
            bGAViewPager.setAllowUserScrollable(this.O000OO);
        }
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O000O0OO = o0000O0o;
    }

    public int getCurrentItem() {
        if (this.f3997O000000o == null || lm.O000000o(this.O00000o0, new Collection[0])) {
            return -1;
        }
        return this.f3997O000000o.getCurrentItem() % this.O00000o0.size();
    }

    public int getItemCount() {
        List<View> list = this.O00000o0;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<? extends View> getViews() {
        return this.O00000o0;
    }

    public List<String> getTips() {
        return this.O0000OOo;
    }

    public BGAViewPager getViewPager() {
        return this.f3997O000000o;
    }

    public void setOverScrollMode(int i) {
        this.O000O00o = i;
        BGAViewPager bGAViewPager = this.f3997O000000o;
        if (bGAViewPager != null) {
            bGAViewPager.setOverScrollMode(this.O000O00o);
        }
    }

    private void O00000Oo() {
        LinearLayout linearLayout = this.O0000Oo0;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            boolean z = this.O000O0oo;
            if (z || (!z && this.O00000o0.size() > 1)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i = this.O0000o0;
                layoutParams.setMargins(i, 0, i, 0);
                for (int i2 = 0; i2 < this.O00000o0.size(); i2++) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(this.O0000oO);
                    this.O0000Oo0.addView(imageView);
                }
            }
        }
        if (this.O00oOoOo != null) {
            boolean z2 = this.O000O0oo;
            if (z2 || (!z2 && this.O00000o0.size() > 1)) {
                this.O00oOoOo.setVisibility(0);
            } else {
                this.O00oOoOo.setVisibility(4);
            }
        }
    }

    private void O00000o0() {
        BGAViewPager bGAViewPager = this.f3997O000000o;
        if (bGAViewPager != null && equals(bGAViewPager.getParent())) {
            removeView(this.f3997O000000o);
            this.f3997O000000o = null;
        }
        this.f3997O000000o = new BGAViewPager(getContext());
        this.f3997O000000o.setOffscreenPageLimit(1);
        this.f3997O000000o.setAdapter(new O00000o(this, (byte) 0));
        this.f3997O000000o.addOnPageChangeListener(this);
        this.f3997O000000o.setOverScrollMode(this.O000O00o);
        this.f3997O000000o.setAllowUserScrollable(this.O000OO);
        this.f3997O000000o.setPageTransformer(true, lr.O000000o(this.O0000ooO));
        setPageChangeDuration(this.O0000Ooo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, this.O000OO00);
        addView(this.f3997O000000o, 0, layoutParams);
        if (this.O00000o) {
            this.f3997O000000o.setAutoPlayDelegate(this);
            this.f3997O000000o.setCurrentItem(1073741823 - (1073741823 % this.O00000o0.size()));
            O000000o();
            return;
        }
        O000000o(0);
    }

    private void O00000o() {
        ImageView imageView = this.O0000ooo;
        if (imageView != null && equals(imageView.getParent())) {
            removeView(this.O0000ooo);
            this.O0000ooo = null;
        }
    }

    public void setAspectRatio(float f) {
        this.O000OO0o = f;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.O000OO0o > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i)) / this.O000OO0o), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.O00000o) {
            int action = motionEvent.getAction();
            if (action == 0) {
                O00000oo();
            } else if (action == 1 || action == 3) {
                O000000o();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setIsNeedShowIndicatorOnOnlyOnePage(boolean z) {
        this.O000O0oo = z;
    }

    public void setCurrentItem(int i) {
        if (this.f3997O000000o != null && this.O00000o0 != null) {
            if (i <= getItemCount() - 1) {
                if (this.O00000o) {
                    int currentItem = this.f3997O000000o.getCurrentItem();
                    int size = i - (currentItem % this.O00000o0.size());
                    if (size < 0) {
                        for (int i2 = -1; i2 >= size; i2--) {
                            this.f3997O000000o.setCurrentItem(currentItem + i2, false);
                        }
                    } else if (size > 0) {
                        for (int i3 = 1; i3 <= size; i3++) {
                            this.f3997O000000o.setCurrentItem(currentItem + i3, false);
                        }
                    }
                    O000000o();
                    return;
                }
                this.f3997O000000o.setCurrentItem(i, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            O000000o();
        } else if (i == 4 || i == 8) {
            O00000oO();
        }
    }

    private void O00000oO() {
        O00000oo();
        if (!this.O000OOo && this.O00000o && this.f3997O000000o != null && getItemCount() > 0 && this.O0000oo != 0.0f) {
            BGAViewPager bGAViewPager = this.f3997O000000o;
            bGAViewPager.setCurrentItem(bGAViewPager.getCurrentItem() - 1);
            BGAViewPager bGAViewPager2 = this.f3997O000000o;
            bGAViewPager2.setCurrentItem(bGAViewPager2.getCurrentItem() + 1);
        }
        this.O000OOo = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000oO();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O000000o();
    }

    public final void O000000o() {
        O00000oo();
        if (this.O00000o) {
            postDelayed(this.O0000oOo, (long) this.O0000OoO);
        }
    }

    private void O00000oo() {
        O00000Oo o00000Oo = this.O0000oOo;
        if (o00000Oo != null) {
            removeCallbacks(o00000Oo);
        }
    }

    private void O000000o(int i) {
        boolean z;
        boolean z2;
        if (this.O0000Oo != null) {
            List<String> list = this.O0000OOo;
            if (list == null || list.size() <= 0 || i >= this.O0000OOo.size()) {
                this.O0000Oo.setVisibility(8);
            } else {
                this.O0000Oo.setVisibility(0);
                this.O0000Oo.setText(this.O0000OOo.get(i));
            }
        }
        if (this.O0000Oo0 != null) {
            List<View> list2 = this.O00000o0;
            if (list2 == null || list2.size() <= 0 || i >= this.O00000o0.size() || (!(z2 = this.O000O0oo) && (z2 || this.O00000o0.size() <= 1))) {
                this.O0000Oo0.setVisibility(8);
            } else {
                this.O0000Oo0.setVisibility(0);
                int i2 = 0;
                while (i2 < this.O0000Oo0.getChildCount()) {
                    this.O0000Oo0.getChildAt(i2).setEnabled(i2 == i);
                    this.O0000Oo0.getChildAt(i2).requestLayout();
                    i2++;
                }
            }
        }
        if (this.O00oOoOo != null) {
            List<View> list3 = this.O00000o0;
            if (list3 == null || list3.size() <= 0 || i >= this.O00000o0.size() || (!(z = this.O000O0oo) && (z || this.O00000o0.size() <= 1))) {
                this.O00oOoOo.setVisibility(8);
                return;
            }
            this.O00oOoOo.setVisibility(0);
            TextView textView = this.O00oOoOo;
            textView.setText((i + 1) + "/" + this.O00000o0.size());
        }
    }

    public void setTransitionEffect(TransitionEffect transitionEffect) {
        this.O0000ooO = transitionEffect;
        if (this.f3997O000000o != null) {
            O00000o0();
            List<View> list = this.O00000Oo;
            if (list == null) {
                lm.O000000o(this.O00000o0);
            } else {
                lm.O000000o(list);
            }
        }
    }

    public void setPageTransformer(ViewPager.O0000OOo o0000OOo) {
        BGAViewPager bGAViewPager;
        if (o0000OOo != null && (bGAViewPager = this.f3997O000000o) != null) {
            bGAViewPager.setPageTransformer(true, o0000OOo);
        }
    }

    public final void O000000o(float f) {
        BGAViewPager bGAViewPager = this.f3997O000000o;
        if (bGAViewPager == null) {
            return;
        }
        if (this.O0000oo0 < bGAViewPager.getCurrentItem()) {
            if (f > 400.0f || (this.O0000oo < 0.7f && f > -400.0f)) {
                this.f3997O000000o.setBannerCurrentItemInternal(this.O0000oo0, true);
            } else {
                this.f3997O000000o.setBannerCurrentItemInternal(this.O0000oo0 + 1, true);
            }
        } else if (f < -400.0f || (this.O0000oo > 0.3f && f < 400.0f)) {
            this.f3997O000000o.setBannerCurrentItemInternal(this.O0000oo0 + 1, true);
        } else {
            this.f3997O000000o.setBannerCurrentItemInternal(this.O0000oo0, true);
        }
    }

    public void onPageSelected(int i) {
        int size = i % this.O00000o0.size();
        O000000o(size);
        ViewPager.O0000O0o o0000O0o = this.O000O0OO;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(size);
        }
    }

    public void onPageScrollStateChanged(int i) {
        ViewPager.O0000O0o o0000O0o = this.O000O0OO;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
    }

    public void setDelegate(O00000o0 o00000o0) {
        this.O00000oo = o00000o0;
    }

    public void setAdapter(O000000o o000000o) {
        this.O0000O0o = o000000o;
    }

    class O00000o extends jz {
        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private O00000o() {
        }

        /* synthetic */ O00000o(BGABanner bGABanner, byte b) {
            this();
        }

        public final int getCount() {
            if (BGABanner.this.O00000o0 == null) {
                return 0;
            }
            if (BGABanner.this.O00000o) {
                return Integer.MAX_VALUE;
            }
            return BGABanner.this.O00000o0.size();
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            View view;
            if (lm.O000000o(BGABanner.this.O00000o0, new Collection[0])) {
                return null;
            }
            int size = i % BGABanner.this.O00000o0.size();
            if (BGABanner.this.O00000Oo == null) {
                view = BGABanner.this.O00000o0.get(size);
            } else {
                view = BGABanner.this.O00000Oo.get(i % BGABanner.this.O00000Oo.size());
            }
            if (BGABanner.this.O00000oo != null) {
                view.setOnClickListener(new lo() {
                    /* class com.xiaomi.shopviews.widget.view.BGABanner.O00000o.AnonymousClass1 */

                    public final void O000000o() {
                        int currentItem = BGABanner.this.f3997O000000o.getCurrentItem() % BGABanner.this.O00000o0.size();
                        if (lm.O000000o(currentItem, BGABanner.this.O00000oO)) {
                            BGABanner.this.O00000oo.O000000o(BGABanner.this.O00000oO.get(currentItem));
                        } else if (lm.O000000o(BGABanner.this.O00000oO, new Collection[0])) {
                            BGABanner.this.O00000oo.O000000o(null);
                        }
                    }
                });
            }
            if (BGABanner.this.O0000O0o != null) {
                if (lm.O000000o(size, BGABanner.this.O00000oO)) {
                    BGABanner.this.O0000O0o.O000000o(view, BGABanner.this.O00000oO.get(size), size);
                } else if (lm.O000000o(BGABanner.this.O00000oO, new Collection[0])) {
                    BGABanner.this.O0000O0o.O000000o(view, null, size);
                }
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }
    }

    static class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<BGABanner> f3999O000000o;

        /* synthetic */ O00000Oo(BGABanner bGABanner, byte b) {
            this(bGABanner);
        }

        private O00000Oo(BGABanner bGABanner) {
            this.f3999O000000o = new WeakReference<>(bGABanner);
        }

        public final void run() {
            BGABanner bGABanner = this.f3999O000000o.get();
            if (bGABanner != null) {
                if (bGABanner.f3997O000000o != null) {
                    bGABanner.f3997O000000o.setCurrentItem(bGABanner.f3997O000000o.getCurrentItem() + 1);
                }
                bGABanner.O000000o();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    public void onPageScrolled(int i, float f, int i2) {
        if (!(this.O000OOo0 == null && this.O000OOOo == null)) {
            if (i == getItemCount() - 2) {
                View view = this.O000OOo0;
                if (view != null) {
                    cb.O00000o0(view, f);
                }
                View view2 = this.O000OOOo;
                if (view2 != null) {
                    cb.O00000o0(view2, 1.0f - f);
                }
                if (f > 0.5f) {
                    View view3 = this.O000OOo0;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    View view4 = this.O000OOOo;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                } else {
                    View view5 = this.O000OOo0;
                    if (view5 != null) {
                        view5.setVisibility(8);
                    }
                    View view6 = this.O000OOOo;
                    if (view6 != null) {
                        view6.setVisibility(0);
                    }
                }
            } else if (i == getItemCount() - 1) {
                View view7 = this.O000OOOo;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
                View view8 = this.O000OOo0;
                if (view8 != null) {
                    view8.setVisibility(0);
                    cb.O00000o0(this.O000OOo0, 1.0f);
                }
            } else {
                View view9 = this.O000OOOo;
                if (view9 != null) {
                    view9.setVisibility(0);
                    cb.O00000o0(this.O000OOOo, 1.0f);
                }
                View view10 = this.O000OOo0;
                if (view10 != null) {
                    view10.setVisibility(8);
                }
            }
        }
        this.O0000oo0 = i;
        this.O0000oo = f;
        if (this.O0000Oo != null) {
            if (lm.O00000Oo(this.O0000OOo, new Collection[0])) {
                this.O0000Oo.setVisibility(0);
                int size = i % this.O0000OOo.size();
                int size2 = (i + 1) % this.O0000OOo.size();
                if (size2 < this.O0000OOo.size() && size < this.O0000OOo.size()) {
                    if (((double) f) > 0.5d) {
                        this.O0000Oo.setText(this.O0000OOo.get(size2));
                        cb.O00000o0(this.O0000Oo, f);
                    } else {
                        cb.O00000o0(this.O0000Oo, 1.0f - f);
                        this.O0000Oo.setText(this.O0000OOo.get(size));
                    }
                }
            } else {
                this.O0000Oo.setVisibility(8);
            }
        }
        ViewPager.O0000O0o o0000O0o = this.O000O0OO;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i % this.O00000o0.size(), f, i2);
        }
    }
}
