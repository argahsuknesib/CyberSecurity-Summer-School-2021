package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;

public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();
    private static final Class<?> TAG = AnimatedDrawable2.class;
    private AnimationBackend mAnimationBackend;
    private volatile AnimationListener mAnimationListener;
    private volatile DrawListener mDrawListener;
    private DrawableProperties mDrawableProperties;
    private int mDroppedFrames;
    private long mExpectedRenderTimeMs;
    private FrameScheduler mFrameScheduler;
    private long mFrameSchedulingDelayMs;
    private long mFrameSchedulingOffsetMs;
    public final Runnable mInvalidateRunnable;
    private volatile boolean mIsRunning;
    private int mLastDrawnFrameNumber;
    private long mLastFrameAnimationTimeMs;
    private long mStartTimeMs;

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public int getOpacity() {
        return -3;
    }

    public AnimatedDrawable2() {
        this(null);
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new Runnable() {
            /* class com.facebook.fresco.animation.drawable.AnimatedDrawable2.AnonymousClass1 */

            public void run() {
                AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
                animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                AnimatedDrawable2.this.invalidateSelf();
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
    }

    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    public void start() {
        AnimationBackend animationBackend;
        if (!this.mIsRunning && (animationBackend = this.mAnimationBackend) != null && animationBackend.getFrameCount() > 1) {
            this.mIsRunning = true;
            this.mStartTimeMs = now();
            this.mExpectedRenderTimeMs = this.mStartTimeMs;
            this.mLastFrameAnimationTimeMs = -1;
            this.mLastDrawnFrameNumber = -1;
            invalidateSelf();
            this.mAnimationListener.onAnimationStart(this);
        }
    }

    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0;
            this.mExpectedRenderTimeMs = this.mStartTimeMs;
            this.mLastFrameAnimationTimeMs = -1;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            this.mAnimationListener.onAnimationStop(this);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(rect);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public void draw(Canvas canvas) {
        long j;
        long j2;
        long j3;
        long j4;
        AnimatedDrawable2 animatedDrawable2;
        if (this.mAnimationBackend != null && this.mFrameScheduler != null) {
            long now = now();
            if (this.mIsRunning) {
                j = (now - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs;
            } else {
                j = Math.max(this.mLastFrameAnimationTimeMs, 0L);
            }
            long j5 = j;
            int frameNumberToRender = this.mFrameScheduler.getFrameNumberToRender(j5, this.mLastFrameAnimationTimeMs);
            if (frameNumberToRender == -1) {
                frameNumberToRender = this.mAnimationBackend.getFrameCount() - 1;
                this.mAnimationListener.onAnimationStop(this);
                this.mIsRunning = false;
            } else if (frameNumberToRender == 0 && this.mLastDrawnFrameNumber != -1 && now >= this.mExpectedRenderTimeMs) {
                this.mAnimationListener.onAnimationRepeat(this);
            }
            int i = frameNumberToRender;
            boolean drawFrame = this.mAnimationBackend.drawFrame(this, canvas, i);
            if (drawFrame) {
                this.mAnimationListener.onAnimationFrame(this, i);
                this.mLastDrawnFrameNumber = i;
            }
            if (!drawFrame) {
                onFrameDropped();
            }
            long now2 = now();
            if (this.mIsRunning) {
                long targetRenderTimeForNextFrameMs = this.mFrameScheduler.getTargetRenderTimeForNextFrameMs(now2 - this.mStartTimeMs);
                if (targetRenderTimeForNextFrameMs != -1) {
                    long j6 = this.mFrameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                    scheduleNextFrame(j6);
                    j2 = j6;
                } else {
                    j2 = -1;
                }
                j3 = targetRenderTimeForNextFrameMs;
            } else {
                j3 = -1;
                j2 = -1;
            }
            if (this.mDrawListener != null) {
                this.mDrawListener.onDraw(this, this.mFrameScheduler, i, drawFrame, this.mIsRunning, this.mStartTimeMs, j5, this.mLastFrameAnimationTimeMs, now, now2, j3, j2);
                animatedDrawable2 = this;
                j4 = j5;
            } else {
                animatedDrawable2 = this;
                j4 = j5;
            }
            animatedDrawable2.mLastFrameAnimationTimeMs = j4;
        }
    }

    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setAlpha(i);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public void setAnimationBackend(AnimationBackend animationBackend) {
        this.mAnimationBackend = animationBackend;
        AnimationBackend animationBackend2 = this.mAnimationBackend;
        if (animationBackend2 != null) {
            this.mFrameScheduler = new DropFramesFrameScheduler(animationBackend2);
            this.mAnimationBackend.setBounds(getBounds());
            DrawableProperties drawableProperties = this.mDrawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
        stop();
    }

    public AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    public long getDroppedFrames() {
        return (long) this.mDroppedFrames;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.mFrameScheduler;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    public void jumpToFrame(int i) {
        FrameScheduler frameScheduler;
        if (this.mAnimationBackend != null && (frameScheduler = this.mFrameScheduler) != null) {
            this.mLastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(i);
            this.mStartTimeMs = now() - this.mLastFrameAnimationTimeMs;
            this.mExpectedRenderTimeMs = this.mStartTimeMs;
            invalidateSelf();
        }
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend == null) {
            return 0;
        }
        FrameScheduler frameScheduler = this.mFrameScheduler;
        if (frameScheduler != null) {
            return frameScheduler.getLoopDurationMs();
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mAnimationBackend.getFrameCount(); i2++) {
            i += this.mAnimationBackend.getFrameDurationMs(i2);
        }
        return (long) i;
    }

    public int getFrameCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameCount();
    }

    public int getLoopCount() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getLoopCount();
    }

    public void setFrameSchedulingDelayMs(long j) {
        this.mFrameSchedulingDelayMs = j;
    }

    public void setFrameSchedulingOffsetMs(long j) {
        this.mFrameSchedulingOffsetMs = j;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.mAnimationListener = animationListener;
    }

    public void setDrawListener(DrawListener drawListener) {
        this.mDrawListener = drawListener;
    }

    private void scheduleNextFrame(long j) {
        this.mExpectedRenderTimeMs = this.mStartTimeMs + j;
        scheduleSelf(this.mInvalidateRunnable, this.mExpectedRenderTimeMs);
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this.mDroppedFrames));
        }
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    private static FrameScheduler createSchedulerForBackendAndDelayMethod(AnimationBackend animationBackend) {
        if (animationBackend == null) {
            return null;
        }
        return new DropFramesFrameScheduler(animationBackend);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.mIsRunning) {
            return false;
        }
        long j = (long) i;
        if (this.mLastFrameAnimationTimeMs == j) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    public void dropCaches() {
        AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }
}
