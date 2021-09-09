package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izj;
import _m_j.izl;
import _m_j.izn;
import _m_j.izt;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.xiaomi.smarthome.R;
import java.util.Formatter;
import java.util.Locale;
import net.qiujuer.genius.ui.widget.popup.PopupIndicator;

public abstract class AbsSeekBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public izt f15393O000000o;
    public int O00000Oo = 100;
    int O00000o = 0;
    public int O00000o0 = 0;
    PopupIndicator O00000oO;
    public float O00000oo;
    private izl O0000O0o;
    private final izn.O000000o O0000OOo = new izn.O000000o() {
        /* class net.qiujuer.genius.ui.widget.AbsSeekBar.AnonymousClass1 */

        public final void O00000Oo() {
        }

        public final void O000000o() {
            AbsSeekBar.this.f15393O000000o.O000000o();
        }
    };
    private int O0000Oo = 1;
    private final Runnable O0000Oo0 = new Runnable() {
        /* class net.qiujuer.genius.ui.widget.AbsSeekBar.AnonymousClass2 */

        public final void run() {
            AbsSeekBar absSeekBar = AbsSeekBar.this;
            if (!absSeekBar.isInEditMode() && absSeekBar.O00000oO != null) {
                izt izt = absSeekBar.f15393O000000o;
                izt.scheduleSelf(izt.O0000OoO, SystemClock.uptimeMillis() + 100);
                izt.O0000Oo = true;
                PopupIndicator popupIndicator = absSeekBar.O00000oO;
                Point point = absSeekBar.f15393O000000o.f1676O000000o;
                if (popupIndicator.O00000o0) {
                    popupIndicator.O00000o.f15413O000000o.O00000o0();
                    return;
                }
                IBinder windowToken = absSeekBar.getWindowToken();
                if (windowToken != null) {
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.gravity = 8388659;
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.format = -3;
                    layoutParams.flags = PopupIndicator.O00000oo(layoutParams.flags);
                    layoutParams.type = 1000;
                    layoutParams.token = windowToken;
                    layoutParams.softInputMode = 3;
                    layoutParams.setTitle("DiscreteSeekBar Indicator:" + Integer.toHexString(popupIndicator.hashCode()));
                    layoutParams.gravity = 8388659;
                    int i = point.y;
                    popupIndicator.O00000o.measure(View.MeasureSpec.makeMeasureSpec(popupIndicator.O00000Oo.x, 1073741824), View.MeasureSpec.makeMeasureSpec(popupIndicator.O00000Oo.y, Integer.MIN_VALUE));
                    int measuredHeight = popupIndicator.O00000o.getMeasuredHeight();
                    int paddingBottom = popupIndicator.O00000o.f15413O000000o.getPaddingBottom();
                    absSeekBar.getLocationInWindow(popupIndicator.O00000oo);
                    layoutParams.x = 0;
                    layoutParams.y = (popupIndicator.O00000oo[1] - measuredHeight) + i + paddingBottom;
                    layoutParams.width = popupIndicator.O00000Oo.x;
                    layoutParams.height = measuredHeight;
                    popupIndicator.O00000o0 = true;
                    popupIndicator.O00000oO(point.x);
                    popupIndicator.f15412O000000o.addView(popupIndicator.O00000o, layoutParams);
                    popupIndicator.O00000o.f15413O000000o.O00000o0();
                }
            }
        }
    };
    private boolean O0000OoO = false;
    private boolean O0000Ooo = true;
    private boolean O0000o;
    private String O0000o0;
    private Formatter O0000o00;
    private O00000Oo O0000o0O;
    private StringBuilder O0000o0o;
    private Rect O0000oO = new Rect();
    private int O0000oO0;
    private Rect O0000oOO = new Rect();
    private ValueAnimator O0000oOo;
    private float O0000oo;
    private int O0000oo0;
    private float O0000ooO;

    public static abstract class O00000Oo {
        public abstract int O000000o(int i);
    }

    public AbsSeekBar(Context context) {
        super(context);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet, (int) R.attr.gSeekBarStyle);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet, i);
    }

    private void O000000o(AttributeSet attributeSet, int i) {
        Context context = getContext();
        Resources resources = getResources();
        boolean z = !isInEditMode();
        setFocusable(true);
        setWillNotDraw(false);
        this.O0000ooO = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        this.O0000O0o = new izl(izj.O00000Oo(resources, R.color.g_default_seek_bar_ripple));
        this.O0000O0o.setCallback(this);
        this.f15393O000000o = new izt(izj.O00000Oo(resources, R.color.g_default_seek_bar_track), izj.O00000Oo(resources, R.color.g_default_seek_bar_scrubber), izj.O00000Oo(resources, R.color.g_default_seek_bar_thumb));
        this.f15393O000000o.setCallback(this);
        if (attributeSet == null) {
            this.f15393O000000o.O00000o0(resources.getDimensionPixelSize(R.dimen.g_seekBar_trackStroke));
            this.f15393O000000o.O00000Oo(resources.getDimensionPixelSize(R.dimen.g_seekBar_scrubberStroke));
            this.f15393O000000o.O0000O0o = resources.getDimensionPixelSize(R.dimen.g_seekBar_touchSize);
            this.f15393O000000o.O00000oo = resources.getDimensionPixelSize(R.dimen.g_seekBar_tickSize);
            this.f15393O000000o.O00000oO = resources.getDimensionPixelSize(R.dimen.g_seekBar_thumbSize);
            if (z) {
                this.O00000oO = new PopupIndicator(context);
                PopupIndicator popupIndicator = this.O00000oO;
                popupIndicator.O00000oO = this.O0000OOo;
                popupIndicator.O000000o(izj.O00000Oo(resources, R.color.g_default_seek_bar_indicator));
                this.O00000oO.O000000o((float) (this.f15393O000000o.O00000oO * 2));
            }
        } else {
            O000000o(context, resources, z, attributeSet, i, 2132738386);
        }
        this.f15393O000000o.O000000o(this.O00000Oo - this.O00000o0);
        O00000o();
        setNumericTransformer(new O000000o((byte) 0));
        O00000o0();
    }

    private void O000000o(Context context, Resources resources, boolean z, AttributeSet attributeSet, int i, int i2) {
        Typeface O000000o2;
        Context context2 = context;
        Resources resources2 = resources;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, new int[]{R.attr.gAllowTrackClickToDrag, R.attr.gFont, R.attr.gIndicator, R.attr.gIndicatorBackgroundColor, R.attr.gIndicatorFormatter, R.attr.gIndicatorSeparation, R.attr.gIndicatorTextAppearance, R.attr.gIndicatorTextPadding, R.attr.gMax, R.attr.gMin, R.attr.gMirrorForRtl, R.attr.gRippleColor, R.attr.gScrubberColor, R.attr.gScrubberStroke, R.attr.gThumbColor, R.attr.gThumbSize, R.attr.gTickSize, R.attr.gTouchSize, R.attr.gTrackColor, R.attr.gTrackStroke, R.attr.gValue}, i, 2132738386);
        int integer = obtainStyledAttributes.getInteger(8, this.O00000Oo);
        int integer2 = obtainStyledAttributes.getInteger(9, this.O00000o0);
        int integer3 = obtainStyledAttributes.getInteger(20, this.O00000o);
        this.O00000o0 = integer2;
        this.O00000Oo = Math.max(integer2 + 1, integer);
        this.O00000o = Math.max(integer2, Math.min(integer, integer3));
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(18);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(14);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(12);
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(11);
        ColorStateList colorStateList5 = obtainStyledAttributes.getColorStateList(3);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(16, resources2.getDimensionPixelSize(R.dimen.g_seekBar_tickSize));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(15, resources2.getDimensionPixelSize(R.dimen.g_seekBar_thumbSize));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(17, resources2.getDimensionPixelSize(R.dimen.g_seekBar_touchSize));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(19, resources2.getDimensionPixelSize(R.dimen.g_seekBar_trackStroke));
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(13, resources2.getDimensionPixelSize(R.dimen.g_seekBar_scrubberStroke));
        int i3 = obtainStyledAttributes.getInt(2, 1);
        this.O0000OoO = obtainStyledAttributes.getBoolean(10, this.O0000OoO);
        this.O0000Ooo = obtainStyledAttributes.getBoolean(0, this.O0000Ooo);
        this.O0000o0 = obtainStyledAttributes.getString(4);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(7, resources2.getDimensionPixelSize(R.dimen.g_balloonMarker_textPadding));
        int resourceId = obtainStyledAttributes.getResourceId(6, 2132738378);
        String string = obtainStyledAttributes.getString(1);
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(5, resources2.getDimensionPixelSize(R.dimen.g_balloonMarker_separation));
        obtainStyledAttributes.recycle();
        this.f15393O000000o.O00000o0(dimensionPixelSize4);
        this.f15393O000000o.O00000Oo(dimensionPixelSize5);
        izt izt = this.f15393O000000o;
        izt.O0000O0o = dimensionPixelSize3;
        izt.O00000oo = dimensionPixelSize;
        izt.O00000oO = dimensionPixelSize2;
        if (colorStateList4 != null) {
            this.O0000O0o.O000000o(colorStateList4);
        }
        if (colorStateList != null) {
            this.f15393O000000o.O000000o(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f15393O000000o.O00000o0(colorStateList2);
        }
        if (colorStateList3 != null) {
            this.f15393O000000o.O00000Oo(colorStateList3);
        }
        if (z && i3 != 0) {
            this.O00000oO = new PopupIndicator(context2);
            PopupIndicator popupIndicator = this.O00000oO;
            popupIndicator.O00000oO = this.O0000OOo;
            if (colorStateList5 != null) {
                popupIndicator.O000000o(colorStateList5);
            }
            this.O00000oO.O00000o0(resourceId);
            this.O00000oO.O000000o((float) (dimensionPixelSize2 * 2));
            this.O00000oO.O00000Oo(dimensionPixelSize6);
            this.O00000oO.O000000o(dimensionPixelSize7);
            if (!(string == null || string.length() <= 0 || (O000000o2 = izh.O000000o(getContext(), string)) == null)) {
                this.O00000oO.O000000o(O000000o2);
            }
        }
        setEnabled(izh.O000000o(context2, attributeSet, i, 2132738386, isEnabled()));
    }

    public void setTrackStroke(int i) {
        if (i != this.f15393O000000o.O00000o0) {
            this.f15393O000000o.O00000o0(i);
            invalidate();
        }
    }

    public void setScrubberStroke(int i) {
        if (i != this.f15393O000000o.O00000o) {
            this.f15393O000000o.O00000Oo(i);
            invalidate();
        }
    }

    public void setThumbRadius(int i) {
        PopupIndicator popupIndicator;
        if (i != this.f15393O000000o.O00000oO) {
            this.f15393O000000o.O00000oO = i;
            if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
                popupIndicator.O000000o((float) (i * 2));
            }
            invalidate();
        }
    }

    public void setTouchRadius(int i) {
        if (i != this.f15393O000000o.O0000O0o) {
            this.f15393O000000o.O0000O0o = i;
            invalidate();
        }
    }

    public void setTickRadius(int i) {
        if (i != this.f15393O000000o.O00000oo) {
            this.f15393O000000o.O00000oo = i;
            invalidate();
        }
    }

    public void setIndicatorColor(ColorStateList colorStateList) {
        PopupIndicator popupIndicator;
        if (colorStateList != null && (popupIndicator = this.O00000oO) != null) {
            if (colorStateList != (popupIndicator.O00000o != null ? popupIndicator.O00000o.f15413O000000o.getBackgroundColor() : null)) {
                this.O00000oO.O000000o(colorStateList);
                invalidate();
            }
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList != this.O0000O0o.O0000Ooo) {
            this.O0000O0o.O000000o(colorStateList);
            invalidate();
        }
    }

    public void setScrubberColor(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList != this.f15393O000000o.O0000o00) {
            this.f15393O000000o.O00000Oo(colorStateList);
            invalidate();
        }
    }

    public void setThumbColor(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList != this.f15393O000000o.O0000o0) {
            this.f15393O000000o.O00000o0(colorStateList);
            invalidate();
        }
    }

    public void setTrackColor(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList != this.f15393O000000o.O0000Ooo) {
            this.f15393O000000o.O000000o(colorStateList);
            invalidate();
        }
    }

    public void setIndicatorFormatter(String str) {
        if (this.O00000oO != null) {
            this.O0000o0 = str;
            O000000o(this.O00000o);
        }
    }

    public O00000Oo getNumericTransformer() {
        return this.O0000o0O;
    }

    public void setNumericTransformer(O00000Oo o00000Oo) {
        PopupIndicator popupIndicator;
        if (o00000Oo == null) {
            o00000Oo = new O000000o((byte) 0);
        }
        this.O0000o0O = o00000Oo;
        if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
            String O00000Oo2 = O00000Oo(this.O0000o0O.O000000o(this.O00000Oo));
            popupIndicator.O00000Oo();
            if (popupIndicator.O00000o != null) {
                popupIndicator.O00000o.f15413O000000o.O000000o(O00000Oo2);
            }
        }
        O000000o(this.O00000o);
    }

    public int getMax() {
        return this.O00000Oo;
    }

    public void setMax(int i) {
        this.O00000Oo = i;
        int i2 = this.O00000Oo;
        if (i2 <= this.O00000o0) {
            setMin(i2 - 1);
        }
        O00000o();
        this.f15393O000000o.O000000o(this.O00000Oo - this.O00000o0);
        int i3 = this.O00000o;
        if (i3 < this.O00000o0 || i3 > this.O00000Oo) {
            setProgress(this.O00000o);
        } else {
            O000000o(-1.0f);
        }
    }

    public int getMin() {
        return this.O00000o0;
    }

    public void setMin(int i) {
        this.O00000o0 = i;
        int i2 = this.O00000o0;
        if (i2 > this.O00000Oo) {
            setMax(i2 + 1);
        }
        O00000o();
        this.f15393O000000o.O000000o(this.O00000Oo - this.O00000o0);
        int i3 = this.O00000o;
        if (i3 < this.O00000o0 || i3 > this.O00000Oo) {
            setProgress(this.O00000o);
        } else {
            O000000o(-1.0f);
        }
    }

    public int getProgress() {
        return this.O00000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(int, float):void
     arg types: [int, int]
     candidates:
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(float, float):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(android.util.AttributeSet, int):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(android.view.MotionEvent, boolean):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(int, float):void */
    public void setProgress(int i) {
        O000000o(i, -1.0f);
    }

    public void setScrubberColor(int i) {
        this.f15393O000000o.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.f15393O000000o.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        PopupIndicator popupIndicator;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            removeCallbacks(this.O0000Oo0);
            if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
                popupIndicator.O00000Oo();
            }
            O00000oO();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15393O000000o.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        O000000o(-1.0f);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15393O000000o.draw(canvas);
        if (isEnabled()) {
            this.O0000O0o.draw(canvas);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(android.view.MotionEvent, boolean):void
     arg types: [android.view.MotionEvent, int]
     candidates:
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(float, float):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(int, float):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(android.util.AttributeSet, int):void
      net.qiujuer.genius.ui.widget.AbsSeekBar.O000000o(android.view.MotionEvent, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0 != 3) goto L_0x0088;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.O0000o) {
                        O000000o(motionEvent);
                    } else if (Math.abs(motionEvent.getX() - this.O0000oo) > this.O0000ooO) {
                        O000000o(motionEvent, false);
                    }
                }
            }
            if (this.f15393O000000o.O00000oo != 0) {
                z = true;
            }
            if (z) {
                if (O00000oo()) {
                    f = getAnimationPosition();
                } else {
                    float f2 = this.f15393O000000o.O00000Oo;
                    int i = this.O00000Oo;
                    int i2 = this.O00000o0;
                    f = (f2 * ((float) (i - i2))) + ((float) i2);
                }
                this.O0000oo0 = getProgress();
                O00000Oo(f);
            }
            O00000Oo();
        } else {
            this.O0000oo = motionEvent.getX();
            ViewParent parent = getParent();
            while (true) {
                if (parent == null || !(parent instanceof ViewGroup)) {
                    break;
                } else if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                    z = true;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            O000000o(motionEvent, z);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        if (isEnabled()) {
            int animatedProgress = getAnimatedProgress();
            if (i == 21) {
                z3 = O00000o0();
            } else if (i != 22) {
                z = false;
                z2 = false;
                if (z) {
                    if (z2) {
                        if (animatedProgress < this.O00000Oo) {
                            O00000o0(animatedProgress + this.O0000Oo);
                        }
                    } else if (animatedProgress > this.O00000o0) {
                        O00000o0(animatedProgress - this.O0000Oo);
                    }
                }
            } else {
                z3 = !O00000o0();
            }
            z2 = z3;
            z = true;
            if (z) {
            }
        } else {
            z = false;
        }
        return z || super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f15393O000000o || drawable == this.O0000O0o || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        O00000oO();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        PopupIndicator popupIndicator;
        super.onDetachedFromWindow();
        removeCallbacks(this.O0000Oo0);
        if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
            popupIndicator.O00000Oo();
        }
    }

    private boolean O00000o0() {
        boolean z = false;
        if ((Build.VERSION.SDK_INT >= 17 ? getLayoutDirection() : 0) == 1 && this.O0000OoO) {
            z = true;
        }
        this.f15393O000000o.O0000OOo = z;
        return z;
    }

    private void O000000o(int i, float f) {
        int max = Math.max(this.O00000o0, Math.min(this.O00000Oo, i));
        if (O00000oo()) {
            this.O0000oOo.cancel();
        }
        if (this.O00000o != max) {
            this.O00000o = max;
            O000000o(max);
        }
        O000000o(f);
    }

    private void O00000o() {
        int i = this.O00000Oo - this.O00000o0;
        int i2 = this.O0000Oo;
        if (i2 == 0 || i / i2 > 20) {
            this.O0000Oo = Math.max(1, Math.round(((float) i) / 20.0f));
        }
    }

    private void O00000oO() {
        int[] drawableState = getDrawableState();
        boolean z = false;
        boolean z2 = false;
        for (int i : drawableState) {
            if (i == 16842908) {
                z = true;
            } else if (i == 16842919) {
                z2 = true;
            }
        }
        if (!isEnabled() || (!z && !z2)) {
            O0000O0o();
        } else {
            removeCallbacks(this.O0000Oo0);
            postDelayed(this.O0000Oo0, 150);
        }
        this.O0000O0o.setState(drawableState);
        this.f15393O000000o.setState(drawableState);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        PopupIndicator popupIndicator;
        if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
            popupIndicator.O000000o(O00000Oo(this.O0000o0O.O000000o(i)));
        }
    }

    private String O00000Oo(int i) {
        String str = this.O0000o0;
        if (str == null) {
            str = "%d";
        }
        Formatter formatter = this.O0000o00;
        if (formatter == null || !formatter.locale().equals(Locale.getDefault())) {
            int length = str.length() + String.valueOf(this.O00000Oo).length();
            StringBuilder sb = this.O0000o0o;
            if (sb == null) {
                this.O0000o0o = new StringBuilder(length);
            } else {
                sb.ensureCapacity(length);
            }
            this.O0000o00 = new Formatter(this.O0000o0o, Locale.getDefault());
        } else {
            this.O0000o0o.setLength(0);
        }
        return this.O0000o00.format(str, Integer.valueOf(i)).toString();
    }

    private void O000000o(MotionEvent motionEvent, boolean z) {
        Rect rect = this.O0000oOO;
        this.f15393O000000o.O000000o(rect);
        boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!contains && this.O0000Ooo && !z) {
            contains = true;
            this.O0000oO0 = rect.width() / 2;
            O000000o(motionEvent);
            izt izt = this.f15393O000000o;
            izt.O000000o(izt.O00000Oo);
        }
        if (contains) {
            O000000o();
            O000000o(motionEvent.getX(), motionEvent.getY());
            this.O0000oO0 = (int) (motionEvent.getX() - ((float) rect.centerX()));
        }
    }

    private int getAnimatedProgress() {
        return O00000oo() ? getAnimationTarget() : getProgress();
    }

    private boolean O00000oo() {
        ValueAnimator valueAnimator = this.O0000oOo;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    private void O00000o0(int i) {
        float animationPosition = O00000oo() ? getAnimationPosition() : (float) getProgress();
        int i2 = this.O00000o0;
        if (i >= i2 && i <= (i2 = this.O00000Oo)) {
            i2 = i;
        }
        this.O0000oo0 = i2;
        O00000Oo(animationPosition);
    }

    private void O00000Oo(float f) {
        ValueAnimator valueAnimator = this.O0000oOo;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.O0000oOo.setFloatValues(f, (float) this.O0000oo0);
        } else {
            this.O0000oOo = ValueAnimator.ofFloat(f, (float) this.O0000oo0);
            this.O0000oOo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class net.qiujuer.genius.ui.widget.AbsSeekBar.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AbsSeekBar.this.O00000oo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f = (AbsSeekBar.this.O00000oo - ((float) AbsSeekBar.this.O00000o0)) / ((float) (AbsSeekBar.this.O00000Oo - AbsSeekBar.this.O00000o0));
                    AbsSeekBar absSeekBar = AbsSeekBar.this;
                    int round = Math.round((((float) (absSeekBar.O00000Oo - absSeekBar.O00000o0)) * f) + ((float) absSeekBar.O00000o0));
                    if (round != absSeekBar.getProgress()) {
                        absSeekBar.O00000o = round;
                        absSeekBar.O000000o(round);
                    }
                    absSeekBar.O000000o(f);
                }
            });
            this.O0000oOo.setDuration(250L);
        }
        this.O0000oOo.start();
    }

    private int getAnimationTarget() {
        return this.O0000oo0;
    }

    private float getAnimationPosition() {
        return this.O00000oo;
    }

    private void O000000o(MotionEvent motionEvent) {
        O000000o(motionEvent.getX(), motionEvent.getY());
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int x = ((int) motionEvent.getX()) - this.O0000oO0;
        if (x < paddingLeft) {
            x = paddingLeft;
        } else if (x > width) {
            x = width;
        }
        float f = ((float) (x - paddingLeft)) / ((float) (width - paddingLeft));
        if (O00000o0()) {
            f = 1.0f - f;
        }
        int i = this.O00000Oo;
        int i2 = this.O00000o0;
        O000000o(Math.round((((float) (i - i2)) * f) + ((float) i2)), f);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f) {
        PopupIndicator popupIndicator;
        if (f == -1.0f) {
            int i = this.O00000o;
            int i2 = this.O00000o0;
            f = ((float) (i - i2)) / ((float) (this.O00000Oo - i2));
        }
        this.f15393O000000o.O000000o(f);
        Rect rect = this.O0000oOO;
        this.f15393O000000o.O000000o(rect);
        if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
            popupIndicator.O00000o(rect.centerX());
        }
        this.O0000O0o.setBounds(rect.left, rect.top, rect.right, rect.bottom);
        this.f15393O000000o.copyBounds(this.O0000oO);
        invalidate(this.O0000oO);
    }

    @TargetApi(21)
    private void O000000o(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.O0000O0o.setHotspot(f, f2);
        }
    }

    private void O0000O0o() {
        PopupIndicator popupIndicator;
        removeCallbacks(this.O0000Oo0);
        if (!isInEditMode() && (popupIndicator = this.O00000oO) != null) {
            popupIndicator.O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o() {
        this.O0000o = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        this.O0000o = false;
        setPressed(false);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        CustomState customState = new CustomState(super.onSaveInstanceState());
        customState.f15397O000000o = getProgress();
        customState.O00000Oo = this.O00000Oo;
        customState.O00000o0 = this.O00000o0;
        return customState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(CustomState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        CustomState customState = (CustomState) parcelable;
        setMin(customState.O00000o0);
        setMax(customState.O00000Oo);
        setProgress(customState.f15397O000000o);
        super.onRestoreInstanceState(customState.getSuperState());
    }

    static class O000000o extends O00000Oo {
        public final int O000000o(int i) {
            return i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    static class CustomState extends View.BaseSavedState {
        public static final Parcelable.Creator<CustomState> CREATOR = new Parcelable.Creator<CustomState>() {
            /* class net.qiujuer.genius.ui.widget.AbsSeekBar.CustomState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public int f15397O000000o;
        public int O00000Oo;
        public int O00000o0;

        public CustomState(Parcel parcel) {
            super(parcel);
            this.f15397O000000o = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = parcel.readInt();
        }

        public CustomState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15397O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o0);
        }
    }
}
