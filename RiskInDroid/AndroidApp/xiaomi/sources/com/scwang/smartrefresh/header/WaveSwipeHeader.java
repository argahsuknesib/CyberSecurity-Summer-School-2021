package com.scwang.smartrefresh.header;

import _m_j.czh;
import _m_j.czu;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;

public class WaveSwipeHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected WaveView f5541O000000o;
    protected RefreshState O00000Oo;
    protected ProgressAnimationImageView O00000o;
    protected czh O00000o0;
    protected float O00000oO;

    public enum VERTICAL_DRAG_THRESHOLD {
        FIRST(0.1f),
        SECOND(FIRST.val + 0.16f),
        THIRD(FIRST.val + 0.5f);
        
        final float val;

        private VERTICAL_DRAG_THRESHOLD(float f) {
            this.val = f;
        }
    }

    public WaveSwipeHeader(Context context) {
        this(context, null);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O000OoOo = SpinnerStyle.MatchLayout;
        WaveView waveView = new WaveView(context);
        this.f5541O000000o = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(context);
        this.O00000o = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.wshAccentColor, R.attr.wshPrimaryColor, R.attr.wshShadowColor, R.attr.wshShadowRadius});
        int color = obtainStyledAttributes.getColor(1, 0);
        int color2 = obtainStyledAttributes.getColor(0, 0);
        if (color != 0) {
            this.f5541O000000o.setWaveColor(color);
        }
        if (color2 != 0) {
            this.O00000o0.O000000o(color2);
        } else {
            this.O00000o0.O000000o(-1);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f5541O000000o.O000000o(obtainStyledAttributes.getDimensionPixelOffset(3, 0), obtainStyledAttributes.getColor(2, -16777216));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        WaveView waveView = this.f5541O000000o;
        ProgressAnimationImageView progressAnimationImageView = this.O00000o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.O00000o0.getIntrinsicWidth(), 1073741824);
        progressAnimationImageView.measure(makeMeasureSpec, makeMeasureSpec);
        waveView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WaveView waveView = this.f5541O000000o;
        ProgressAnimationImageView progressAnimationImageView = this.O00000o;
        waveView.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = progressAnimationImageView.getMeasuredWidth();
        progressAnimationImageView.layout((measuredWidth - measuredWidth2) / 2, -progressAnimationImageView.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            O000000o(true, 0.99f, dao.O000000o(99.0f), dao.O000000o(100.0f), dao.O000000o(100.0f));
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.O00000o0.O000000o(iArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (z && this.O00000Oo != RefreshState.Refreshing) {
            ProgressAnimationImageView progressAnimationImageView = this.O00000o;
            double min = (double) Math.min(1.0f, f);
            Double.isNaN(min);
            float max = (Math.max((float) (min - 0.4d), 0.0f) * 5.0f) / 3.0f;
            float f2 = f > 3.0f ? 2.0f : f > 1.0f ? f - 1.0f : 0.0f;
            float f3 = ((4.0f - f2) * f2) / 8.0f;
            if (f < 1.0f) {
                this.O00000o0.O000000o(0.0f, Math.min(0.8f, max * 0.8f));
                this.O00000o0.O000000o(Math.min(1.0f, max));
            }
            this.O00000o0.O00000Oo((((max * 0.4f) - 16.0f) + (f3 * 2.0f)) * 0.5f);
            progressAnimationImageView.setTranslationY(this.f5541O000000o.getCurrentCircleCenterY());
            float min2 = (((float) i) * 1.0f) / ((float) Math.min(getMeasuredWidth(), getMeasuredHeight()));
            float f4 = (min2 * (5.0f - (2.0f * min2))) / 3.5f;
            float f5 = f4 - VERTICAL_DRAG_THRESHOLD.FIRST.val;
            float f6 = (f4 - VERTICAL_DRAG_THRESHOLD.SECOND.val) / 5.0f;
            this.O00000oO = f4;
            if (f4 < VERTICAL_DRAG_THRESHOLD.FIRST.val) {
                this.f5541O000000o.O000000o(f4);
            } else if (f4 < VERTICAL_DRAG_THRESHOLD.SECOND.val) {
                this.f5541O000000o.O000000o(f4, f5);
            } else {
                this.f5541O000000o.O000000o(f4, f5, f6);
            }
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O00000oO = 0.0f;
        this.f5541O000000o.O00000o0();
        this.O00000o0.setAlpha(255);
        this.O00000o0.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.WaveSwipeHeader.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressAnimationImageView progressAnimationImageView = WaveSwipeHeader.this.O00000o;
                progressAnimationImageView.setTranslationY(WaveSwipeHeader.this.f5541O000000o.getCurrentCircleCenterY() + (((float) progressAnimationImageView.getHeight()) / 2.0f));
            }
        });
        ofFloat.start();
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        ProgressAnimationImageView progressAnimationImageView = this.O00000o;
        this.O00000Oo = refreshState2;
        int i = AnonymousClass4.f5545O000000o[refreshState2.ordinal()];
        if (i == 1) {
            return;
        }
        if (i == 2) {
            this.O00000o0.O000000o(true);
            progressAnimationImageView.setScaleX(1.0f);
            progressAnimationImageView.setScaleY(1.0f);
            this.O00000o0.setAlpha(255);
        } else if (i == 3) {
            this.O00000o0.O000000o(false);
            this.O00000o0.O00000Oo(0.0f);
            this.O00000o0.O000000o(0.0f, 0.0f);
            this.f5541O000000o.O00000Oo(this.O00000oO);
            this.O00000oO = 0.0f;
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5545O000000o = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5545O000000o[RefreshState.None.ordinal()] = 1;
            f5545O000000o[RefreshState.PullDownToRefresh.ordinal()] = 2;
            f5545O000000o[RefreshState.PullDownCanceled.ordinal()] = 3;
            f5545O000000o[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            f5545O000000o[RefreshState.Refreshing.ordinal()] = 5;
        }
    }

    public final int O000000o(czx czx, boolean z) {
        final ProgressAnimationImageView progressAnimationImageView = this.O00000o;
        AnonymousClass2 r4 = new Animation() {
            /* class com.scwang.smartrefresh.header.WaveSwipeHeader.AnonymousClass2 */

            public final void applyTransformation(float f, Transformation transformation) {
                float f2 = 1.0f - f;
                progressAnimationImageView.setScaleX(f2);
                progressAnimationImageView.setScaleY(f2);
            }
        };
        r4.setDuration(200);
        this.O00000o.setAnimationListener(new Animation.AnimationListener() {
            /* class com.scwang.smartrefresh.header.WaveSwipeHeader.AnonymousClass3 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                WaveSwipeHeader.this.O00000o0.stop();
                WaveSwipeHeader.this.O00000o0.setAlpha(255);
                WaveSwipeHeader.this.f5541O000000o.O00000Oo();
            }
        });
        progressAnimationImageView.clearAnimation();
        progressAnimationImageView.startAnimation(r4);
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f5541O000000o.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.O00000o0.O000000o(iArr[1]);
            }
        }
    }

    public static boolean O000000o() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    public class ProgressAnimationImageView extends ImageView {
        protected Animation.AnimationListener mListener;

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            this.mListener = animationListener;
        }

        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }

        public ProgressAnimationImageView(Context context) {
            super(context);
            WaveSwipeHeader.this.O00000o0 = new czh(WaveSwipeHeader.this);
            WaveSwipeHeader.this.O00000o0.O00000Oo(0);
            if (WaveSwipeHeader.O000000o()) {
                WaveSwipeHeader.this.O00000o0.O000000o(0);
            }
            super.setImageDrawable(WaveSwipeHeader.this.O00000o0);
        }

        public void setProgressColorSchemeColorsFromResource(int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = resources.getColor(iArr[i]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }
    }
}
