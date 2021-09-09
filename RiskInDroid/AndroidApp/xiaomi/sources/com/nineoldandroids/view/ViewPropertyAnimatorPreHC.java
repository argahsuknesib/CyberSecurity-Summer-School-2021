package com.nineoldandroids.view;

import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator {
    private Runnable mAnimationStarter = new Runnable() {
        /* class com.nineoldandroids.view.ViewPropertyAnimatorPreHC.AnonymousClass1 */

        public void run() {
            ViewPropertyAnimatorPreHC.this.startAnimation();
        }
    };
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();
    public HashMap<Animator, PropertyBundle> mAnimatorMap = new HashMap<>();
    private long mDuration;
    private boolean mDurationSet = false;
    private Interpolator mInterpolator;
    private boolean mInterpolatorSet = false;
    public Animator.AnimatorListener mListener = null;
    ArrayList<NameValuesHolder> mPendingAnimations = new ArrayList<>();
    private final AnimatorProxy mProxy;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    public final WeakReference<View> mView;

    static class PropertyBundle {
        ArrayList<NameValuesHolder> mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, ArrayList<NameValuesHolder> arrayList) {
            this.mPropertyMask = i;
            this.mNameValuesHolder = arrayList;
        }

        /* access modifiers changed from: package-private */
        public boolean cancel(int i) {
            ArrayList<NameValuesHolder> arrayList;
            if (!((this.mPropertyMask & i) == 0 || (arrayList = this.mNameValuesHolder) == null)) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.mNameValuesHolder.get(i2).mNameConstant == i) {
                        this.mNameValuesHolder.remove(i2);
                        this.mPropertyMask = (i ^ -1) & this.mPropertyMask;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f2) {
            this.mNameConstant = i;
            this.mFromValue = f;
            this.mDeltaValue = f2;
        }
    }

    ViewPropertyAnimatorPreHC(View view) {
        this.mView = new WeakReference<>(view);
        this.mProxy = AnimatorProxy.wrap(view);
    }

    public ViewPropertyAnimator setDuration(long j) {
        if (j >= 0) {
            this.mDurationSet = true;
            this.mDuration = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(j)));
    }

    public long getDuration() {
        if (this.mDurationSet) {
            return this.mDuration;
        }
        return new ValueAnimator().getDuration();
    }

    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0;
    }

    public ViewPropertyAnimator setStartDelay(long j) {
        if (j >= 0) {
            this.mStartDelaySet = true;
            this.mStartDelay = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(j)));
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    public void start() {
        startAnimation();
    }

    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            for (Animator cancel : ((HashMap) this.mAnimatorMap.clone()).keySet()) {
                cancel.cancel();
            }
        }
        this.mPendingAnimations.clear();
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    public ViewPropertyAnimator x(float f) {
        animateProperty(NotificationCompat.FLAG_HIGH_PRIORITY, f);
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(NotificationCompat.FLAG_HIGH_PRIORITY, f);
        return this;
    }

    public ViewPropertyAnimator y(float f) {
        animateProperty(256, f);
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(256, f);
        return this;
    }

    public ViewPropertyAnimator rotation(float f) {
        animateProperty(16, f);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(16, f);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        animateProperty(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(32, f);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        animateProperty(64, f);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(64, f);
        return this;
    }

    public ViewPropertyAnimator translationX(float f) {
        animateProperty(1, f);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(1, f);
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        animateProperty(2, f);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(2, f);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        animateProperty(4, f);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(4, f);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        animateProperty(8, f);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(8, f);
        return this;
    }

    public ViewPropertyAnimator alpha(float f) {
        animateProperty(512, f);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(512, f);
        return this;
    }

    public void startAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
        this.mPendingAnimations.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((NameValuesHolder) arrayList.get(i2)).mNameConstant;
        }
        this.mAnimatorMap.put(ofFloat, new PropertyBundle(i, arrayList));
        ofFloat.addUpdateListener(this.mAnimatorEventListener);
        ofFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            ofFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            ofFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            ofFloat.setInterpolator(this.mInterpolator);
        }
        ofFloat.start();
    }

    private void animateProperty(int i, float f) {
        float value = getValue(i);
        animatePropertyBy(i, value, f - value);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f2) {
        if (this.mAnimatorMap.size() > 0) {
            Animator animator = null;
            Iterator<Animator> it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Animator next = it.next();
                PropertyBundle propertyBundle = this.mAnimatorMap.get(next);
                if (propertyBundle.cancel(i) && propertyBundle.mPropertyMask == 0) {
                    animator = next;
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.add(new NameValuesHolder(i, f, f2));
        View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }

    public void setValue(int i, float f) {
        if (i == 1) {
            this.mProxy.setTranslationX(f);
        } else if (i == 2) {
            this.mProxy.setTranslationY(f);
        } else if (i == 4) {
            this.mProxy.setScaleX(f);
        } else if (i == 8) {
            this.mProxy.setScaleY(f);
        } else if (i == 16) {
            this.mProxy.setRotation(f);
        } else if (i == 32) {
            this.mProxy.setRotationX(f);
        } else if (i == 64) {
            this.mProxy.setRotationY(f);
        } else if (i == 128) {
            this.mProxy.setX(f);
        } else if (i == 256) {
            this.mProxy.setY(f);
        } else if (i == 512) {
            this.mProxy.setAlpha(f);
        }
    }

    private float getValue(int i) {
        if (i == 1) {
            return this.mProxy.getTranslationX();
        }
        if (i == 2) {
            return this.mProxy.getTranslationY();
        }
        if (i == 4) {
            return this.mProxy.getScaleX();
        }
        if (i == 8) {
            return this.mProxy.getScaleY();
        }
        if (i == 16) {
            return this.mProxy.getRotation();
        }
        if (i == 32) {
            return this.mProxy.getRotationX();
        }
        if (i == 64) {
            return this.mProxy.getRotationY();
        }
        if (i == 128) {
            return this.mProxy.getX();
        }
        if (i == 256) {
            return this.mProxy.getY();
        }
        if (i != 512) {
            return 0.0f;
        }
        return this.mProxy.getAlpha();
    }

    class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationStart(animator);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationCancel(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.mListener != null) {
                ViewPropertyAnimatorPreHC.this.mListener.onAnimationEnd(animator);
            }
            ViewPropertyAnimatorPreHC.this.mAnimatorMap.remove(animator);
            if (ViewPropertyAnimatorPreHC.this.mAnimatorMap.isEmpty()) {
                ViewPropertyAnimatorPreHC.this.mListener = null;
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PropertyBundle propertyBundle = ViewPropertyAnimatorPreHC.this.mAnimatorMap.get(valueAnimator);
            if (!((propertyBundle.mPropertyMask & 511) == 0 || (view = ViewPropertyAnimatorPreHC.this.mView.get()) == null)) {
                view.invalidate();
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    NameValuesHolder nameValuesHolder = arrayList.get(i);
                    ViewPropertyAnimatorPreHC.this.setValue(nameValuesHolder.mNameConstant, nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction));
                }
            }
            View view2 = ViewPropertyAnimatorPreHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }
}
