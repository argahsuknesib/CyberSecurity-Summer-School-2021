package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator {
    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<>();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* class com.nineoldandroids.animation.ValueAnimator.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* class com.nineoldandroids.animation.ValueAnimator.AnonymousClass3 */

        /* access modifiers changed from: protected */
        public final ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* class com.nineoldandroids.animation.ValueAnimator.AnonymousClass4 */

        /* access modifiers changed from: protected */
        public final ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    public static long sFrameDelay = 10;
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* class com.nineoldandroids.animation.ValueAnimator.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public final ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* class com.nineoldandroids.animation.ValueAnimator.AnonymousClass5 */

        /* access modifiers changed from: protected */
        public final ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private float mCurrentFraction = 0.0f;
    private int mCurrentIteration = 0;
    private long mDelayStartTime;
    private long mDuration = 300;
    boolean mInitialized = false;
    private Interpolator mInterpolator = sDefaultInterpolator;
    private boolean mPlayingBackwards = false;
    int mPlayingState = 0;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    public boolean mRunning = false;
    long mSeekTime = -1;
    public long mStartDelay = 0;
    long mStartTime;
    private boolean mStarted = false;
    private boolean mStartedDelay = false;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            } else {
                propertyValuesHolderArr[0].setIntValues(iArr);
            }
            this.mInitialized = false;
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            } else {
                propertyValuesHolderArr[0].setFloatValues(fArr);
            }
            this.mInitialized = false;
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            } else {
                propertyValuesHolderArr[0].setObjectValues(objArr);
            }
            this.mInitialized = false;
        }
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap<>(r0);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    /* access modifiers changed from: package-private */
    public void initAnimation() {
        if (!this.mInitialized) {
            for (PropertyValuesHolder init : this.mValues) {
                init.init();
            }
            this.mInitialized = true;
        }
    }

    public ValueAnimator setDuration(long j) {
        if (j >= 0) {
            this.mDuration = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(j)));
    }

    public long getDuration() {
        return this.mDuration;
    }

    public void setCurrentPlayTime(long j) {
        initAnimation();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = j;
            this.mPlayingState = 2;
        }
        this.mStartTime = currentAnimationTimeMillis - j;
        animationFrame(currentAnimationTimeMillis);
    }

    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [int, long]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = ValueAnimator.sAnimations.get();
            ArrayList arrayList2 = ValueAnimator.sDelayedAnims.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = ValueAnimator.sPendingAnimations.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i2);
                        if (valueAnimator.mStartDelay == 0) {
                            valueAnimator.startAnimation();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            } else if (i == 1) {
                z = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = ValueAnimator.sReadyAnims.get();
            ArrayList arrayList6 = ValueAnimator.sEndingAnims.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i3);
                if (valueAnimator2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i4);
                    valueAnimator3.startAnimation();
                    valueAnimator3.mRunning = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i5);
                if (valueAnimator4.animationFrame(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((ValueAnimator) arrayList6.get(i6)).endAnimation();
                }
                arrayList6.clear();
            }
            if (!z) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    public Object getAnimatedValue() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].getAnimatedValue();
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.remove(animatorUpdateListener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.mValues) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
        }
    }

    private void start(boolean z) {
        if (Looper.myLooper() != null) {
            this.mPlayingBackwards = z;
            this.mCurrentIteration = 0;
            this.mPlayingState = 0;
            this.mStarted = true;
            this.mStartedDelay = false;
            sPendingAnimations.get().add(this);
            if (this.mStartDelay == 0) {
                setCurrentPlayTime(getCurrentPlayTime());
                this.mPlayingState = 0;
                this.mRunning = true;
                if (this.mListeners != null) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        ((Animator.AnimatorListener) arrayList.get(i)).onAnimationStart(this);
                    }
                }
            }
            AnimationHandler animationHandler = sAnimationHandler.get();
            if (animationHandler == null) {
                animationHandler = new AnimationHandler();
                sAnimationHandler.set(animationHandler);
            }
            animationHandler.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public void start() {
        start(false);
    }

    public void cancel() {
        if (this.mPlayingState != 0 || sPendingAnimations.get().contains(this) || sDelayedAnims.get().contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        int i = this.mRepeatCount;
        if (i <= 0 || (i & 1) != 1) {
            animateValue(1.0f);
        } else {
            animateValue(0.0f);
        }
        endAnimation();
    }

    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    public void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator.AnimatorListener) arrayList.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
        if (this.mStartDelay > 0 && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator.AnimatorListener) arrayList.get(i)).onAnimationStart(this);
            }
        }
    }

    public boolean delayedAnimationFrame(long j) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j;
            return false;
        }
        long j2 = j - this.mDelayStartTime;
        long j3 = this.mStartDelay;
        if (j2 <= j3) {
            return false;
        }
        this.mStartTime = j - (j2 - j3);
        this.mPlayingState = 1;
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: package-private */
    public boolean animationFrame(long j) {
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j2 = this.mSeekTime;
            if (j2 < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - j2;
                this.mSeekTime = -1;
            }
        }
        int i = this.mPlayingState;
        boolean z = false;
        if (i == 1 || i == 2) {
            long j3 = this.mDuration;
            float f = j3 > 0 ? ((float) (j - this.mStartTime)) / ((float) j3) : 1.0f;
            if (f >= 1.0f) {
                int i2 = this.mCurrentIteration;
                int i3 = this.mRepeatCount;
                if (i2 < i3 || i3 == -1) {
                    if (this.mListeners != null) {
                        int size = this.mListeners.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ((Animator.AnimatorListener) this.mListeners.get(i4)).onAnimationRepeat(this);
                        }
                    }
                    if (this.mRepeatMode == 2) {
                        this.mPlayingBackwards = !this.mPlayingBackwards;
                    }
                    this.mCurrentIteration += (int) f;
                    f %= 1.0f;
                    this.mStartTime += this.mDuration;
                } else {
                    f = Math.min(f, 1.0f);
                    z = true;
                }
            }
            if (this.mPlayingBackwards) {
                f = 1.0f - f;
            }
            animateValue(f);
        }
        return z;
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    /* access modifiers changed from: package-private */
    public void animateValue(float f) {
        float interpolation = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = interpolation;
        for (PropertyValuesHolder calculateValue : this.mValues) {
            calculateValue.calculateValue(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this);
            }
        }
    }

    public ValueAnimator clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            valueAnimator.mUpdateListeners = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i));
            }
        }
        valueAnimator.mSeekTime = -1;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                PropertyValuesHolder clone = propertyValuesHolderArr[i2].clone();
                valueAnimator.mValues[i2] = clone;
                valueAnimator.mValuesMap.put(clone.getPropertyName(), clone);
            }
        }
        return valueAnimator;
    }

    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.mValues != null) {
            for (int i = 0; i < this.mValues.length; i++) {
                str = str + "\n    " + this.mValues[i].toString();
            }
        }
        return str;
    }
}
