package com.scwang.smartrefresh.header;

import _m_j.cq;
import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dao;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;

public class FlyRefreshHeader extends FalsifyHeader implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f5521O000000o;
    protected AnimatorSet O00000Oo;
    protected czw O00000o;
    protected czx O00000o0;
    protected MountainSceneView O00000oO;
    protected int O00000oo = 0;
    protected float O0000O0o;
    protected boolean O0000OOo = false;

    public FlyRefreshHeader(Context context) {
        super(context);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (z || !this.O0000OOo) {
            if (i < 0) {
                if (this.O00000oo > 0) {
                    i = 0;
                    f = 0.0f;
                } else {
                    return;
                }
            }
            this.O00000oo = i;
            this.O0000O0o = f;
            MountainSceneView mountainSceneView = this.O00000oO;
            if (mountainSceneView != null) {
                mountainSceneView.O000000o(f);
                this.O00000oO.postInvalidate();
            }
            View view = this.f5521O000000o;
            if (view != null) {
                int i4 = i2 + i3;
                if (i4 > 0) {
                    view.setRotation((((float) i) * -45.0f) / ((float) i4));
                } else {
                    view.setRotation(f * -45.0f);
                }
            }
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O00000o.O000000o(0);
        float f = this.O0000O0o;
        if (f > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.scwang.smartrefresh.header.FlyRefreshHeader.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlyRefreshHeader.this.O000000o(true, ((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
                }
            });
            ofFloat.start();
            this.O0000O0o = 0.0f;
        }
        if (this.f5521O000000o != null && !this.O0000OOo) {
            AnimatorSet animatorSet = this.O00000Oo;
            if (animatorSet != null) {
                animatorSet.end();
                this.f5521O000000o.clearAnimation();
            }
            this.O0000OOo = true;
            czx.O00000oo(false);
            int width = ((View) this.O00000o0).getWidth() - this.f5521O000000o.getLeft();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f5521O000000o, "translationX", 0.0f, (float) width);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f5521O000000o, "translationY", 0.0f, (float) (((-(this.f5521O000000o.getTop() - this.O00000oo)) * 2) / 3));
            ofFloat3.setInterpolator(cq.O000000o(0.7f, 1.0f));
            View view = this.f5521O000000o;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "rotation", view.getRotation(), 0.0f);
            ofFloat4.setInterpolator(new DecelerateInterpolator());
            View view2 = this.f5521O000000o;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "rotationX", view2.getRotationX(), 50.0f);
            ofFloat5.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800L);
            View view3 = this.f5521O000000o;
            float[] fArr = {view3.getScaleX(), 0.5f};
            View view4 = this.f5521O000000o;
            animatorSet2.playTogether(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(view3, "scaleX", fArr), ObjectAnimator.ofFloat(view4, "scaleY", view4.getScaleY(), 0.5f));
            this.O00000Oo = animatorSet2;
            this.O00000Oo.start();
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        MountainSceneView mountainSceneView;
        if (iArr.length > 0 && (mountainSceneView = this.O00000oO) != null) {
            mountainSceneView.setPrimaryColor(iArr[0]);
        }
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O00000o = czw;
        this.O00000o0 = czw.O000000o();
        this.O00000o0.O0000Oo0();
    }

    public final int O000000o(czx czx, boolean z) {
        boolean z2 = this.O0000OOo;
        if (z2 && this.f5521O000000o != null && z2 && this.O00000o0 != null) {
            AnimatorSet animatorSet = this.O00000Oo;
            if (animatorSet != null) {
                animatorSet.end();
                this.f5521O000000o.clearAnimation();
            }
            this.O0000OOo = false;
            this.O00000o0.O0000OOo();
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800L);
            View view = this.f5521O000000o;
            float f = (float) (-this.f5521O000000o.getRight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), f);
            View view2 = this.f5521O000000o;
            float f2 = (float) (-dao.O000000o(10.0f));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", view2.getTranslationY(), f2);
            ofFloat2.setInterpolator(cq.O000000o(0.1f, 1.0f));
            View view3 = this.f5521O000000o;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, "rotation", view3.getRotation(), 0.0f);
            View view4 = this.f5521O000000o;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view4, "rotationX", view4.getRotationX(), 30.0f);
            ofFloat3.setInterpolator(new AccelerateInterpolator());
            View view5 = this.f5521O000000o;
            float[] fArr = {view5.getScaleX(), 0.9f};
            View view6 = this.f5521O000000o;
            animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(view5, "scaleX", fArr), ObjectAnimator.ofFloat(view6, "scaleY", view6.getScaleY(), 0.9f));
            animatorSet2.addListener(new AnimatorListenerAdapter() {
                /* class com.scwang.smartrefresh.header.FlyRefreshHeader.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    if (FlyRefreshHeader.this.f5521O000000o != null) {
                        FlyRefreshHeader.this.f5521O000000o.setRotationY(180.0f);
                    }
                }
            });
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.setDuration(800L);
            animatorSet3.setInterpolator(new DecelerateInterpolator());
            animatorSet3.playTogether(ObjectAnimator.ofFloat(this.f5521O000000o, "translationX", f, 0.0f), ObjectAnimator.ofFloat(this.f5521O000000o, "translationY", f2, 0.0f), ObjectAnimator.ofFloat(this.f5521O000000o, "rotationX", 30.0f, 0.0f), ObjectAnimator.ofFloat(this.f5521O000000o, "scaleX", 0.9f, 1.0f), ObjectAnimator.ofFloat(this.f5521O000000o, "scaleY", 0.9f, 1.0f));
            animatorSet3.setStartDelay(100);
            animatorSet3.addListener(new AnimatorListenerAdapter(null) {
                /* class com.scwang.smartrefresh.header.FlyRefreshHeader.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ AnimatorListenerAdapter f5524O000000o = null;

                public final void onAnimationStart(Animator animator) {
                    if (FlyRefreshHeader.this.f5521O000000o != null) {
                        FlyRefreshHeader.this.f5521O000000o.setRotationY(0.0f);
                    }
                }

                public final void onAnimationEnd(Animator animator) {
                    if (FlyRefreshHeader.this.O00000o0 != null) {
                        FlyRefreshHeader.this.O00000o0.O00000oo(true);
                    }
                    AnimatorListenerAdapter animatorListenerAdapter = this.f5524O000000o;
                    if (animatorListenerAdapter != null) {
                        animatorListenerAdapter.onAnimationEnd(animator);
                    }
                }
            });
            this.O00000Oo = new AnimatorSet();
            this.O00000Oo.playSequentially(animatorSet2, animatorSet3);
            this.O00000Oo.start();
        }
        return super.O000000o(czx, z);
    }
}
