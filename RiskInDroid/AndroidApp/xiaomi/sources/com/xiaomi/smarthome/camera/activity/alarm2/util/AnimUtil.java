package com.xiaomi.smarthome.camera.activity.alarm2.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.xiaomi.smarthome.R;

public class AnimUtil {

    public interface AnimEndListener {
        void animEnd();
    }

    public static ValueAnimator getValueAnimatorOfFloat(float[] fArr, int i, int i2, int i3, int i4, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        new ValueAnimator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setDuration((long) i);
        if (i2 != 0) {
            ofFloat.setRepeatCount(i2);
            ofFloat.setRepeatMode(i3);
        }
        if (i4 == 1) {
            ofFloat.setInterpolator(new AccelerateInterpolator());
        } else if (i4 == 2) {
            ofFloat.setInterpolator(new DecelerateInterpolator());
        } else if (i4 == 3) {
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if (i4 == 4) {
            ofFloat.setInterpolator(new LinearInterpolator());
        }
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public static ValueAnimator getValueAnimatorOfInt(int[] iArr, int i, int i2, int i3, int i4, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        new ValueAnimator();
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.setDuration((long) i);
        if (i2 != 0) {
            ofInt.setRepeatCount(i2);
            ofInt.setRepeatMode(i3);
        }
        if (i4 == 1) {
            ofInt.setInterpolator(new AccelerateInterpolator());
        } else if (i4 == 2) {
            ofInt.setInterpolator(new DecelerateInterpolator());
        } else if (i4 == 3) {
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if (i4 == 4) {
            ofInt.setInterpolator(new LinearInterpolator());
        }
        if (animatorUpdateListener != null) {
            ofInt.addUpdateListener(animatorUpdateListener);
        }
        return ofInt;
    }

    public static RotateAnimation getRotateAnimRepeat(int i, int i2, int i3, View view) {
        RotateAnimation rotateAnimation = new RotateAnimation((float) i, (float) i2, (float) (view.getMeasuredWidth() / 2), (float) (view.getMeasuredHeight() / 2));
        rotateAnimation.setDuration((long) i3);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setRepeatCount(-1);
        return rotateAnimation;
    }

    public static void startRotateAnim(int i, int i2, int i3, View view) {
        RotateAnimation rotateAnimation = new RotateAnimation((float) i, (float) i2, (float) (view.getMeasuredWidth() / 2), (float) (view.getMeasuredHeight() / 2));
        rotateAnimation.setDuration((long) i3);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    public static void animLayoutBottom(Context context, final boolean z, final View view, final View view2) {
        Animation animation;
        Animation animation2;
        if (z) {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_out_bottom);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass1 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                view2.setVisibility(0);
                view.setVisibility(0);
                view2.setClickable(false);
                view.setClickable(false);
            }

            public final void onAnimationEnd(Animation animation) {
                if (!z) {
                    view2.setVisibility(4);
                    view.setVisibility(4);
                }
                view2.setClickable(true);
                view.setClickable(true);
            }
        });
        animation.setDuration(300);
        view.startAnimation(animation);
        animation2.setDuration(300);
        view2.startAnimation(animation2);
    }

    public static void animLayoutBottom(Context context, final boolean z, final View view, final View view2, final AnimEndListener animEndListener) {
        Animation animation;
        Animation animation2;
        if (z) {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_out_bottom);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass2 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                view2.setVisibility(0);
                view.setVisibility(0);
                view2.setClickable(false);
                view.setClickable(false);
            }

            public final void onAnimationEnd(Animation animation) {
                if (!z) {
                    view2.setVisibility(4);
                    view.setVisibility(4);
                }
                view2.setClickable(true);
                view.setClickable(true);
                AnimEndListener animEndListener = animEndListener;
                if (animEndListener != null) {
                    animEndListener.animEnd();
                }
            }
        });
        animation.setDuration(180);
        view.startAnimation(animation);
        animation2.setDuration(180);
        view2.startAnimation(animation2);
    }

    public static void animLayoutTop(Context context, boolean z, View view, View view2, View view3, AnimEndListener animEndListener) {
        Animation animation;
        Animation animation2;
        if (z) {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_in_top);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_out_top);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        final View view4 = view3;
        final View view5 = view2;
        final boolean z2 = z;
        final View view6 = view;
        final AnimEndListener animEndListener2 = animEndListener;
        animation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass3 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                View view = view4;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = view5;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = view4;
                if (view3 != null) {
                    view3.setClickable(false);
                }
                View view4 = view5;
                if (view4 != null) {
                    view4.setClickable(false);
                }
            }

            public final void onAnimationEnd(Animation animation) {
                if (!z2) {
                    View view = view4;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    View view2 = view5;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                    View view3 = view6;
                    if (view3 != null) {
                        view3.setVisibility(4);
                    }
                }
                View view4 = view4;
                if (view4 != null) {
                    view4.setClickable(true);
                }
                View view5 = view5;
                if (view5 != null) {
                    view5.setClickable(true);
                }
                AnimEndListener animEndListener = animEndListener2;
                if (animEndListener != null) {
                    animEndListener.animEnd();
                }
            }
        });
        animation.setDuration(180);
        if (view2 != null) {
            view2.startAnimation(animation);
        }
        if (view != null) {
            view.setVisibility(0);
            view.setAnimation(animation);
        }
        animation2.setDuration(180);
        if (view3 != null) {
            view3.startAnimation(animation2);
        }
    }

    public static void animLayoutTop(Context context, boolean z, View view, View view2, View view3, long j, AnimEndListener animEndListener) {
        Animation animation;
        Animation animation2;
        if (z) {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_in_top);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animation2 = AnimationUtils.loadAnimation(context, R.anim.slide_out_top);
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        final View view4 = view3;
        final View view5 = view2;
        final boolean z2 = z;
        final View view6 = view;
        final AnimEndListener animEndListener2 = animEndListener;
        animation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass4 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                View view = view4;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = view5;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = view4;
                if (view3 != null) {
                    view3.setClickable(false);
                }
                View view4 = view5;
                if (view4 != null) {
                    view4.setClickable(false);
                }
            }

            public final void onAnimationEnd(Animation animation) {
                if (!z2) {
                    View view = view4;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    View view2 = view5;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                    View view3 = view6;
                    if (view3 != null) {
                        view3.setVisibility(4);
                    }
                }
                View view4 = view4;
                if (view4 != null) {
                    view4.setClickable(true);
                }
                View view5 = view5;
                if (view5 != null) {
                    view5.setClickable(true);
                }
                AnimEndListener animEndListener = animEndListener2;
                if (animEndListener != null) {
                    animEndListener.animEnd();
                }
            }
        });
        animation.setDuration(j);
        if (view2 != null) {
            view2.startAnimation(animation);
        }
        if (view != null) {
            view.setVisibility(0);
            view.setAnimation(animation);
        }
        animation2.setDuration(j);
        if (view3 != null) {
            view3.startAnimation(animation2);
        }
    }

    public static void animAlpha(Context context, final View view, long j, final boolean z, final AnimEndListener animEndListener) {
        Animation animation;
        if (z) {
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_in);
        } else {
            animation = AnimationUtils.loadAnimation(context, R.anim.alpha_out);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass5 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            public final void onAnimationEnd(Animation animation) {
                if (z) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
                AnimEndListener animEndListener = animEndListener;
                if (animEndListener != null) {
                    animEndListener.animEnd();
                }
            }
        });
        animation.setDuration(j);
        view.startAnimation(animation);
    }

    public static void animScale(Context context, final View view, final boolean z, boolean z2) {
        Animation animation;
        if (z) {
            animation = AnimationUtils.loadAnimation(context, R.anim.scale_to_big);
        } else {
            animation = AnimationUtils.loadAnimation(context, R.anim.scale_to_small);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass6 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            public final void onAnimationEnd(Animation animation) {
                if (z) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
        });
        if (z2) {
            animation.setInterpolator(new BounceInterpolator());
            animation.setDuration(700);
        } else {
            animation.setInterpolator(new DecelerateInterpolator());
            animation.setDuration(400);
        }
        view.startAnimation(animation);
    }

    public static void animScale(Context context, final View view, final boolean z, boolean z2, final AnimEndListener animEndListener) {
        Animation animation;
        if (z) {
            animation = AnimationUtils.loadAnimation(context, R.anim.scale_to_big);
        } else {
            animation = AnimationUtils.loadAnimation(context, R.anim.scale_to_small);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil.AnonymousClass7 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            public final void onAnimationEnd(Animation animation) {
                if (z) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
                AnimEndListener animEndListener = animEndListener;
                if (animEndListener != null) {
                    animEndListener.animEnd();
                }
            }
        });
        if (z2) {
            animation.setInterpolator(new BounceInterpolator());
            animation.setDuration(700);
        } else {
            animation.setInterpolator(new DecelerateInterpolator());
            animation.setDuration(400);
        }
        view.startAnimation(animation);
    }

    public static void animAlpha(Context context, View view) {
        new AnimationUtils();
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.alpha_in_and_out));
    }
}
