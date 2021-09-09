package com.scwang.smartrefresh.header;

import _m_j.czh;
import _m_j.czu;
import _m_j.czx;
import _m_j.dae;
import _m_j.dag;
import _m_j.dao;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public class WaterDropHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected RefreshState f5538O000000o;
    protected ImageView O00000Oo;
    protected dag O00000o;
    protected WaterDropView O00000o0;
    protected czh O00000oO;

    public WaterDropHeader(Context context) {
        this(context, null);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dao dao = new dao();
        this.O000OoOo = SpinnerStyle.Scale;
        this.O00000o0 = new WaterDropView(context);
        this.O00000o0.O000000o(0);
        addView(this.O00000o0, -1, -1);
        this.O00000o = new dag();
        dag dag = this.O00000o;
        dag.setCallback(this);
        dag.setBounds(0, 0, dao.O00000Oo(20.0f), dao.O00000Oo(20.0f));
        this.O00000Oo = new ImageView(context);
        this.O00000oO = new czh(this.O00000Oo);
        this.O00000oO.O00000Oo(-1);
        this.O00000oO.setAlpha(255);
        this.O00000oO.O000000o(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.O00000Oo.setImageDrawable(this.O00000oO);
        addView(this.O00000Oo, dao.O00000Oo(30.0f), dao.O00000Oo(30.0f));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ImageView imageView = this.O00000Oo;
        WaterDropView waterDropView = this.O00000o0;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        waterDropView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        super.setMeasuredDimension(View.resolveSize(Math.max(imageView.getMeasuredWidth(), waterDropView.getMeasuredWidth()), i), View.resolveSize(Math.max(imageView.getMeasuredHeight(), waterDropView.getMeasuredHeight()), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView = this.O00000Oo;
        WaterDropView waterDropView = this.O00000o0;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = waterDropView.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        waterDropView.layout(i7, 0, i7 + measuredWidth2, waterDropView.getMeasuredHeight() + 0);
        int measuredWidth3 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > waterDropView.getBottom() - i11) {
            i10 = (waterDropView.getBottom() - i11) - measuredHeight;
        }
        imageView.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        WaterDropView waterDropView = this.O00000o0;
        dag dag = this.O00000o;
        if (this.f5538O000000o == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((float) ((getWidth() / 2) - (dag.getBounds().width() / 2)), (float) ((this.O00000o0.getMaxCircleRadius() + waterDropView.getPaddingTop()) - (dag.getBounds().height() / 2)));
            dag.draw(canvas);
            canvas.restore();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (z || !(this.f5538O000000o == RefreshState.Refreshing || this.f5538O000000o == RefreshState.RefreshReleased)) {
            WaterDropView waterDropView = this.O00000o0;
            Math.max(i, 0);
            waterDropView.postInvalidate();
        }
        if (z) {
            float f2 = (float) i2;
            double min = (double) Math.min(1.0f, Math.abs((((float) i) * 1.0f) / f2));
            Double.isNaN(min);
            float max = (Math.max((float) (min - 0.4d), 0.0f) * 5.0f) / 3.0f;
            double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i) - i2), f2 * 2.0f) / f2) / 4.0f);
            double pow = Math.pow(max2, 2.0d);
            Double.isNaN(max2);
            this.O00000oO.O000000o(true);
            this.O00000oO.O000000o(0.0f, Math.min(0.8f, max * 0.8f));
            this.O00000oO.O000000o(Math.min(1.0f, max));
            this.O00000oO.O00000Oo((((0.4f * max) - 16.0f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        WaterDropView waterDropView = this.O00000o0;
        this.f5538O000000o = refreshState2;
        switch (refreshState2) {
            case None:
                waterDropView.setVisibility(0);
                return;
            case PullDownToRefresh:
                waterDropView.setVisibility(0);
                return;
            case PullDownCanceled:
                return;
            case ReleaseToRefresh:
                waterDropView.setVisibility(0);
                return;
            case Refreshing:
                return;
            case RefreshFinish:
                waterDropView.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        final WaterDropView waterDropView = this.O00000o0;
        this.O00000o.start();
        WaterDropView waterDropView2 = this.O00000o0;
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.waterdrop.WaterDropView.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaterDropView.this.O000000o(((Float) valueAnimator.getAnimatedValue()).floatValue());
                WaterDropView.this.postInvalidate();
            }
        });
        duration.start();
        waterDropView.animate().setDuration(150).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.header.WaterDropHeader.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                waterDropView.setVisibility(8);
                waterDropView.setAlpha(1.0f);
            }
        });
    }

    public final int O000000o(czx czx, boolean z) {
        this.O00000o.stop();
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.O00000o0.setIndicatorColor(iArr[0]);
        }
    }
}
