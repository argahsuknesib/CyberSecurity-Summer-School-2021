package com.xiaomi.smarthome.newui.widget;

import _m_j.gpo;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayoutSpringBehavior;
import com.xiaomi.smarthome.R;

public class SimplePushToRefreshHeader extends LinearLayout implements AppBarLayoutSpringBehavior.PullToRefreshCallback {
    private static final String O00000o = "SimplePushToRefreshHeader";

    /* renamed from: O000000o  reason: collision with root package name */
    public float f10331O000000o = 0.0f;
    public View O00000Oo;
    LottieAnimationView O00000o0;
    private View O00000oO = null;
    private O000000o O00000oo;

    public interface O000000o {
        void O000000o();
    }

    public void onOffsetChanged(int i) {
    }

    public SimplePushToRefreshHeader(Context context) {
        super(context);
        O000000o();
    }

    public SimplePushToRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SimplePushToRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000oO = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header, (ViewGroup) null);
        this.O00000Oo = this.O00000oO.findViewById(R.id.pull_header);
        this.O00000o0 = (LottieAnimationView) this.O00000oO.findViewById(R.id.pull_animation);
        addView(this.O00000oO);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void onDrag(int i, boolean z) {
        float f = (float) i;
        this.f10331O000000o = f > 150.0f ? Math.min(((f / 150.0f) - 1.0f) * 2.0f, 1.0f) : 0.0f;
        this.O00000Oo.setAlpha(this.f10331O000000o);
        setVisibility(0);
        this.O00000Oo.setVisibility(0);
        gpo.O000000o(this.O00000o0);
        invalidate();
    }

    public void onComplete() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(200L);
        valueAnimator.setFloatValues(1.0f, 0.0f);
        valueAnimator.addListener(new Animator.AnimatorListener() {
            /* class com.xiaomi.smarthome.newui.widget.SimplePushToRefreshHeader.AnonymousClass1 */

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                SimplePushToRefreshHeader simplePushToRefreshHeader = SimplePushToRefreshHeader.this;
                simplePushToRefreshHeader.f10331O000000o = 0.0f;
                simplePushToRefreshHeader.O00000Oo.setAlpha(simplePushToRefreshHeader.f10331O000000o);
                gpo.O00000Oo(simplePushToRefreshHeader.O00000o0);
                simplePushToRefreshHeader.invalidate();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.newui.widget.SimplePushToRefreshHeader.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimplePushToRefreshHeader.this.f10331O000000o *= ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SimplePushToRefreshHeader.this.O00000Oo.setAlpha(SimplePushToRefreshHeader.this.f10331O000000o);
                SimplePushToRefreshHeader.this.invalidate();
            }
        });
        valueAnimator.start();
    }

    public void onRefresh() {
        this.f10331O000000o = 1.0f;
        this.O00000Oo.setAlpha(this.f10331O000000o);
        O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public void setOnRefreshListener(O000000o o000000o) {
        this.O00000oo = o000000o;
    }
}
