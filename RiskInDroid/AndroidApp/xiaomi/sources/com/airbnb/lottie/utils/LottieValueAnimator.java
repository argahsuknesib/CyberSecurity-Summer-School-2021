package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    protected boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    public float getAnimatedFraction() {
        float minFrame2;
        float maxFrame2;
        float minFrame3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame2 = getMaxFrame() - this.frame;
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        } else {
            minFrame2 = this.frame - getMinFrame();
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        }
        return minFrame2 / (maxFrame2 - minFrame3);
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float frameDurationNs = ((float) (nanoTime - this.lastFrameTimeNs)) / getFrameDurationNs();
            float f = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            this.frame = f + frameDurationNs;
            boolean z = !MiscUtils.contains(this.frame, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = nanoTime;
            notifyUpdate();
            if (z) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = nanoTime;
                } else {
                    this.frame = getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                }
            }
            verifyFrame();
        }
    }

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z = this.composition == null;
        this.composition = lottieComposition;
        if (z) {
            setMinAndMaxFrames((int) Math.max(this.minFrame, lottieComposition.getStartFrame()), (int) Math.min(this.maxFrame, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        setFrame((int) this.frame);
        this.lastFrameTimeNs = System.nanoTime();
    }

    public void setFrame(int i) {
        float f = (float) i;
        if (this.frame != f) {
            this.frame = MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = System.nanoTime();
            notifyUpdate();
        }
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames(i, (int) this.maxFrame);
    }

    public void setMaxFrame(int i) {
        setMinAndMaxFrames((int) this.minFrame, i);
    }

    public void setMinAndMaxFrames(int i, int i2) {
        LottieComposition lottieComposition = this.composition;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.composition;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        float f = (float) i;
        this.minFrame = MiscUtils.clamp(f, startFrame, endFrame);
        float f2 = (float) i2;
        this.maxFrame = MiscUtils.clamp(f2, startFrame, endFrame);
        setFrame((int) MiscUtils.clamp(this.frame, f, f2));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = System.nanoTime();
        this.repeatCount = 0;
        postFrameCallback();
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    public void pauseAnimation() {
        removeFrameCallback();
    }

    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = System.nanoTime();
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.14748365E9f ? lottieComposition.getStartFrame() : f;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.14748365E9f ? lottieComposition.getEndFrame() : f;
    }

    /* access modifiers changed from: protected */
    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    /* access modifiers changed from: protected */
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void verifyFrame() {
        if (this.composition != null) {
            float f = this.frame;
            if (f < this.minFrame || f > this.maxFrame) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
            }
        }
    }
}
