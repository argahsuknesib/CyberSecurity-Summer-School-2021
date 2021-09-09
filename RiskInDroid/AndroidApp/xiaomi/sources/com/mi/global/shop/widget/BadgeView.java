package com.mi.global.shop.widget;

import _m_j.cay;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;

@SuppressLint({"NewApi"})
public class BadgeView extends CustomTextView {
    private static final int DEFAULT_BADGE_COLOR = Color.parseColor("#FF5816");
    private static Animation mFadeInAnim;
    private static Animation mFadeOutAnim;
    private boolean isShown;
    private Drawable mBadgeBg;
    private int mBadgeColor;
    private int mBadgeMarginH;
    private int mBadgeMarginV;
    private int mBadgePosition;
    private Context mContext;
    private float mCounterHeight;
    private View mTarget;
    private int mTargetTabIndex;

    public BadgeView(Context context) {
        this(context, (AttributeSet) null, 16842884);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public BadgeView(Context context, View view) {
        this(context, null, 16842884, view, 0);
    }

    public BadgeView(Context context, TabWidget tabWidget, int i) {
        this(context, null, 16842884, tabWidget, i);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 0);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i, View view, int i2) {
        super(context, attributeSet, i);
        this.mCounterHeight = 15.0f;
        init(context, view, i2);
    }

    private void init(Context context, View view, int i) {
        setMinWidth(dipToPixels(15.0f));
        setMinHeight(dipToPixels(15.0f));
        setGravity(17);
        this.mContext = context;
        this.mTarget = view;
        this.mTargetTabIndex = i;
        this.mBadgePosition = 2;
        this.mBadgeMarginH = dipToPixels(5.0f);
        this.mBadgeMarginV = this.mBadgeMarginH;
        this.mBadgeColor = DEFAULT_BADGE_COLOR;
        cay.O000000o(this, context);
        int dipToPixels = dipToPixels(5.0f);
        setPadding(dipToPixels, 0, dipToPixels, 0);
        setTextColor(-1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        mFadeInAnim = alphaAnimation;
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        mFadeInAnim.setDuration(200);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        mFadeOutAnim = alphaAnimation2;
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        mFadeOutAnim.setDuration(200);
        this.isShown = false;
        View view2 = this.mTarget;
        if (view2 != null) {
            applyTo(view2);
        } else {
            show();
        }
    }

    private void applyTo(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        if (view instanceof TabWidget) {
            View childTabViewAt = ((TabWidget) view).getChildTabViewAt(this.mTargetTabIndex);
            this.mTarget = childTabViewAt;
            ((ViewGroup) childTabViewAt).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            frameLayout.addView(this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(frameLayout, indexOfChild, layoutParams);
        frameLayout.addView(view);
        setVisibility(8);
        frameLayout.addView(this);
        viewGroup.invalidate();
    }

    public void show() {
        show(false, null);
    }

    public void show(boolean z) {
        show(z, mFadeInAnim);
    }

    public void show(Animation animation) {
        show(true, animation);
    }

    public void hide() {
        hide(false, null);
    }

    public void hide(boolean z) {
        hide(z, mFadeOutAnim);
    }

    public void hide(Animation animation) {
        hide(true, animation);
    }

    public void toggle() {
        toggle(false, null, null);
    }

    public void toggle(boolean z) {
        toggle(z, mFadeInAnim, mFadeOutAnim);
    }

    public void toggle(Animation animation, Animation animation2) {
        toggle(true, animation, animation2);
    }

    private void show(boolean z, Animation animation) {
        if (getBackground() == null) {
            if (this.mBadgeBg == null) {
                this.mBadgeBg = getDefaultBackground();
            }
            setBackgroundDrawable(this.mBadgeBg);
        }
        applyLayoutParams();
        if (z) {
            startAnimation(animation);
        }
        setVisibility(0);
        this.isShown = true;
    }

    private void hide(boolean z, Animation animation) {
        setVisibility(8);
        if (z) {
            startAnimation(animation);
        }
        this.isShown = false;
    }

    private void toggle(boolean z, Animation animation, Animation animation2) {
        boolean z2 = true;
        if (this.isShown) {
            if (!z || animation2 == null) {
                z2 = false;
            }
            hide(z2, animation2);
            return;
        }
        if (!z || animation == null) {
            z2 = false;
        }
        show(z2, animation);
    }

    public int increment(int i) {
        int i2;
        CharSequence text = getText();
        if (text != null) {
            try {
                i2 = Integer.parseInt(text.toString());
            } catch (NumberFormatException unused) {
            }
            int i3 = i2 + i;
            setText(String.valueOf(i3));
            return i3;
        }
        i2 = 0;
        int i32 = i2 + i;
        setText(String.valueOf(i32));
        return i32;
    }

    public int decrement(int i) {
        return increment(-i);
    }

    private Drawable getDefaultBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mBadgeColor);
        gradientDrawable.setCornerRadius(90.0f);
        return gradientDrawable;
    }

    private Drawable getOvalDrawable() {
        OvalShape ovalShape = new OvalShape();
        ovalShape.resize((float) dipToPixels(this.mCounterHeight), (float) dipToPixels(this.mCounterHeight));
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(this.mBadgeColor);
        shapeDrawable.setIntrinsicHeight(dipToPixels(this.mCounterHeight));
        shapeDrawable.setIntrinsicWidth(dipToPixels(this.mCounterHeight));
        return shapeDrawable;
    }

    private void applyLayoutParams() {
        FrameLayout.LayoutParams layoutParams;
        float f = this.mCounterHeight;
        if (f > 0.0f) {
            layoutParams = new FrameLayout.LayoutParams(-2, dipToPixels(f));
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        switch (this.mBadgePosition) {
            case 1:
                layoutParams.gravity = 51;
                layoutParams.setMargins(this.mBadgeMarginH, this.mBadgeMarginV, 0, 0);
                break;
            case 2:
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, this.mBadgeMarginV, this.mBadgeMarginH, 0);
                break;
            case 3:
                layoutParams.gravity = 83;
                layoutParams.setMargins(this.mBadgeMarginH, 0, 0, this.mBadgeMarginV);
                break;
            case 4:
                layoutParams.gravity = 85;
                layoutParams.setMargins(0, 0, this.mBadgeMarginH, this.mBadgeMarginV);
                break;
            case 5:
                layoutParams.gravity = 17;
                layoutParams.setMargins(0, 0, 0, 0);
                break;
            case 6:
                layoutParams.gravity = 21;
                layoutParams.setMargins(0, 0, this.mBadgeMarginH, 0);
                break;
        }
        setLayoutParams(layoutParams);
    }

    public View getTarget() {
        return this.mTarget;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public int getmBadgePosition() {
        return this.mBadgePosition;
    }

    public void setmBadgePosition(int i) {
        this.mBadgePosition = i;
    }

    public int getHorizontalBadgeMargin() {
        return this.mBadgeMarginH;
    }

    public int getVerticalBadgeMargin() {
        return this.mBadgeMarginV;
    }

    public void setBadgeMargin(int i) {
        this.mBadgeMarginH = i;
        this.mBadgeMarginV = i;
    }

    public void setBadgeMargin(int i, int i2) {
        this.mBadgeMarginH = i;
        this.mBadgeMarginV = i2;
    }

    public int getBadgeBackgroundColor() {
        return this.mBadgeColor;
    }

    public void setBadgeBackgroundColor(int i) {
        this.mBadgeColor = i;
        this.mBadgeBg = getDefaultBackground();
    }

    public void setBadgeBackgroundDrawable(Drawable drawable) {
        this.mBadgeBg = drawable;
    }

    private int dipToPixels(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence)) {
            super.setText("", bufferType);
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    public void setBadgeBackgroundResource(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(getResources().getDrawable(i));
        } else {
            setBackgroundDrawable(getResources().getDrawable(i));
        }
    }

    public void setCounterHeight(float f) {
        this.mCounterHeight = f;
    }

    public void setCount(int i) {
        if (i > 0) {
            if (i < 10) {
                setBadgeBackgroundDrawable(getOvalDrawable());
                setText(String.valueOf(i));
            } else if (i > 99) {
                setBadgeBackgroundDrawable(getDefaultBackground());
                setText("99+");
            } else {
                setBadgeBackgroundDrawable(getDefaultBackground());
                setText(String.valueOf(i));
            }
            show();
            return;
        }
        hide();
    }
}
