package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    private final WeakReference<ViewPropertyAnimator> mNative;

    ViewPropertyAnimatorICS(View view) {
        this.mNative = new WeakReference<>(view.animate());
    }

    public ViewPropertyAnimator setDuration(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    public long getDuration() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1;
    }

    public ViewPropertyAnimator setStartDelay(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    public long getStartDelay() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1;
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimator setListener(final Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                    /* class com.nineoldandroids.view.ViewPropertyAnimatorICS.AnonymousClass1 */

                    public void onAnimationStart(android.animation.Animator animator) {
                        animatorListener.onAnimationStart(null);
                    }

                    public void onAnimationRepeat(android.animation.Animator animator) {
                        animatorListener.onAnimationRepeat(null);
                    }

                    public void onAnimationEnd(android.animation.Animator animator) {
                        animatorListener.onAnimationEnd(null);
                    }

                    public void onAnimationCancel(android.animation.Animator animator) {
                        animatorListener.onAnimationCancel(null);
                    }
                });
            }
        }
        return this;
    }

    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    public void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public ViewPropertyAnimator x(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator y(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotation(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator alpha(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }
}
