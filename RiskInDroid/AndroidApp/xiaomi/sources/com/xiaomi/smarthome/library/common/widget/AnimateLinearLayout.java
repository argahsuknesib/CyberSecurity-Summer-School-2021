package com.xiaomi.smarthome.library.common.widget;

import _m_j.gsy;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

public class AnimateLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f9133O000000o = "AnimateLinearLayout";
    protected static final float O00000Oo = (Resources.getSystem().getDisplayMetrics().density * 200.0f);
    protected static final float O00000o0 = (Resources.getSystem().getDisplayMetrics().density * -60.0f);
    static int O0000O0o = 1000;
    static float O0000o0 = 0.9f;
    static float O0000o0O = 2.0f;
    public volatile boolean O00000o = false;
    LinearInterpolator O00000oO = new LinearInterpolator();
    Animator.AnimatorListener O00000oo = null;
    O00000Oo O0000OOo = null;
    int O0000Oo = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    GestureDetector O0000Oo0 = null;
    boolean O0000OoO = false;
    float O0000Ooo;
    int O0000o00 = 0;

    public interface O00000Oo {
    }

    private static AnimateLinearLayout getSubAnimateLayout$5345dac0() {
        return null;
    }

    public static class O000000o implements Interpolator {

        /* renamed from: O000000o  reason: collision with root package name */
        protected static final O000000o f9139O000000o = new O000000o();

        protected O000000o() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt((double) (1.0f - (f2 * f2)));
        }
    }

    public AnimateLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int O000000o(int i) {
        if (i < 3) {
            i = 3;
        } else if (i > 10) {
            i = 10;
        }
        return 180 / i;
    }

    @SuppressLint({"NewApi"})
    public final synchronized void O000000o(int i, int i2) {
        gsy.O000000o(3, f9133O000000o, "doMoveInAnim");
        this.O00000o = true;
        final int childCount = getChildCount();
        int i3 = -1;
        for (final int i4 = 0; i4 < childCount; i4++) {
            final View childAt = getChildAt(i4);
            if (childAt == null) {
                if (i4 == childCount - 1) {
                    this.O00000o = false;
                }
            } else if (childAt.getVisibility() != 8) {
                i3++;
                if (getOrientation() == 1) {
                    childAt.setAlpha(0.0f);
                    childAt.setTranslationX(-O00000Oo);
                } else {
                    childAt.setTranslationY(-O00000o0);
                }
                ViewPropertyAnimator animate = childAt.animate();
                if (getOrientation() == 1) {
                    animate.translationX(0.0f);
                } else {
                    animate.translationY(0.0f);
                }
                animate.setInterpolator(O000000o.f9139O000000o);
                long j = (long) (((i3 + 0) * i2) + 150);
                animate.setStartDelay(j);
                if (Build.VERSION.SDK_INT >= 16) {
                    animate.withEndAction(new Runnable() {
                        /* class com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout.AnonymousClass1 */

                        public final void run() {
                            childAt.setTranslationX(0.0f);
                            if (i4 == childCount - 1) {
                                AnimateLinearLayout.this.O00000o = false;
                            }
                        }
                    });
                } else {
                    animate.setListener(new Animator.AnimatorListener() {
                        /* class com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout.AnonymousClass2 */

                        public final void onAnimationEnd(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationCancel(Animator animator) {
                            childAt.setTranslationX(0.0f);
                            if (i4 == childCount - 1) {
                                AnimateLinearLayout.this.O00000o = false;
                            }
                        }
                    });
                }
                animate.start();
                if (getOrientation() == 1) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, 1.0f);
                    ofFloat.setInterpolator(this.O00000oO);
                    ofFloat.setStartDelay(j);
                    ofFloat.start();
                }
            } else if (i4 == childCount - 1) {
                this.O00000o = false;
            }
        }
    }

    public void setMoveOutAnimListener(Animator.AnimatorListener animatorListener) {
        this.O00000oo = animatorListener;
    }

    public void setFlingLeftListener(O00000Oo o00000Oo) {
        this.O0000OOo = o00000Oo;
        if (this.O0000OOo != null && this.O0000Oo0 == null) {
            this.O0000Oo0 = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                /* class com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout.AnonymousClass3 */

                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if ((-f) > ((float) AnimateLinearLayout.O0000O0o)) {
                        Math.abs(f);
                        Math.abs(f2);
                    }
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
            });
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O0000OOo == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        String str = f9133O000000o;
        gsy.O000000o(3, str, System.currentTimeMillis() + "onInterceptTouchEvent,ev=" + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else if (this.O0000OoO) {
                    return true;
                } else {
                    if (((int) Math.abs(motionEvent.getX() - this.O0000Ooo)) <= this.O0000Oo) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                    this.O0000OoO = true;
                    return true;
                }
            }
            this.O0000OoO = false;
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.O0000OoO = false;
        this.O0000Ooo = motionEvent.getX();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r0 != 3) goto L_0x009e;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O0000OOo == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.O0000OoO) {
                        this.O0000o00 = (int) (motionEvent.getX() - this.O0000Ooo);
                        int i = this.O0000o00;
                        if (i > 0) {
                            this.O0000o00 = 0;
                        } else {
                            this.O0000o00 = (int) (((float) i) * O0000o0O);
                            O00000Oo(this.O0000o00);
                        }
                    }
                }
            }
            this.O0000OoO = false;
            if ((-this.O0000o00) > getWidth() / 3) {
                int i2 = this.O0000o00;
                Animator.AnimatorListener animatorListener = this.O00000oo;
                ValueAnimator ofInt = ValueAnimator.ofInt(i2, (i2 - getWidth()) * 2);
                ofInt.setInterpolator(this.O00000oO);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout.AnonymousClass5 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AnimateLinearLayout.this.O00000Oo(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                if (animatorListener != null) {
                    ofInt.addListener(animatorListener);
                }
                ofInt.start();
            } else {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(this.O0000o00, 0);
                ofInt2.setInterpolator(O000000o.f9139O000000o);
                ofInt2.setDuration(200L);
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.library.common.widget.AnimateLinearLayout.AnonymousClass4 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AnimateLinearLayout.this.O00000Oo(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                ofInt2.start();
            }
        } else {
            this.O0000OoO = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public final void O00000Oo(int i) {
        int childCount;
        View childAt;
        int i2;
        if (Math.abs(i) > 1 && (childCount = getChildCount()) > 0) {
            int i3 = 0;
            if (this.O0000OOo != null) {
                int width = getWidth() * 2;
                if (Math.abs(i) > width) {
                    i2 = 0;
                } else {
                    i2 = ((width - Math.abs(i)) * 255) / width;
                }
                Drawable background = getBackground();
                if (background != null) {
                    background.setAlpha(i2);
                }
            }
            while (i3 < childCount) {
                i = (int) (((float) i) * O0000o0);
                if (Math.abs(i) > 0) {
                    if (Math.abs(i) > 0 && (childAt = getChildAt(i3)) != null && childAt.getVisibility() == 0) {
                        childAt.setTranslationX((float) i);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
