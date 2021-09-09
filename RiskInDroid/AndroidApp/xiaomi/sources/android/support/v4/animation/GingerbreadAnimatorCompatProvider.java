package android.support.v4.animation;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
@RequiresApi(9)
class GingerbreadAnimatorCompatProvider implements AnimatorProvider {
    public void clearInterpolator(View view) {
    }

    GingerbreadAnimatorCompatProvider() {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new GingerbreadFloatValueAnimator();
    }

    static class GingerbreadFloatValueAnimator implements ValueAnimatorCompat {
        public long mDuration = 200;
        private boolean mEnded = false;
        public float mFraction = 0.0f;
        List<AnimatorListenerCompat> mListeners = new ArrayList();
        public Runnable mLoopRunnable = new Runnable() {
            /* class android.support.v4.animation.GingerbreadAnimatorCompatProvider.GingerbreadFloatValueAnimator.AnonymousClass1 */

            public void run() {
                float time = (((float) (GingerbreadFloatValueAnimator.this.getTime() - GingerbreadFloatValueAnimator.this.mStartTime)) * 1.0f) / ((float) GingerbreadFloatValueAnimator.this.mDuration);
                if (time > 1.0f || GingerbreadFloatValueAnimator.this.mTarget.getParent() == null) {
                    time = 1.0f;
                }
                GingerbreadFloatValueAnimator gingerbreadFloatValueAnimator = GingerbreadFloatValueAnimator.this;
                gingerbreadFloatValueAnimator.mFraction = time;
                gingerbreadFloatValueAnimator.notifyUpdateListeners();
                if (GingerbreadFloatValueAnimator.this.mFraction >= 1.0f) {
                    GingerbreadFloatValueAnimator.this.dispatchEnd();
                } else {
                    GingerbreadFloatValueAnimator.this.mTarget.postDelayed(GingerbreadFloatValueAnimator.this.mLoopRunnable, 16);
                }
            }
        };
        public long mStartTime;
        private boolean mStarted = false;
        View mTarget;
        List<AnimatorUpdateListenerCompat> mUpdateListeners = new ArrayList();

        public void notifyUpdateListeners() {
            for (int size = this.mUpdateListeners.size() - 1; size >= 0; size--) {
                this.mUpdateListeners.get(size).onAnimationUpdate(this);
            }
        }

        public void setTarget(View view) {
            this.mTarget = view;
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.mListeners.add(animatorListenerCompat);
        }

        public void setDuration(long j) {
            if (!this.mStarted) {
                this.mDuration = j;
            }
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.mFraction = 0.0f;
                this.mStartTime = getTime();
                this.mTarget.postDelayed(this.mLoopRunnable, 16);
            }
        }

        public long getTime() {
            return this.mTarget.getDrawingTime();
        }

        private void dispatchStart() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationStart(this);
            }
        }

        public void dispatchEnd() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationEnd(this);
            }
        }

        private void dispatchCancel() {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onAnimationCancel(this);
            }
        }

        public void cancel() {
            if (!this.mEnded) {
                this.mEnded = true;
                if (this.mStarted) {
                    dispatchCancel();
                }
                dispatchEnd();
            }
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.mUpdateListeners.add(animatorUpdateListenerCompat);
        }

        public float getAnimatedFraction() {
            return this.mFraction;
        }
    }
}
