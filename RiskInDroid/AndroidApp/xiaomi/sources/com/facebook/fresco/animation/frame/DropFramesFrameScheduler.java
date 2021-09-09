package com.facebook.fresco.animation.frame;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.fresco.animation.backend.AnimationInformation;

public class DropFramesFrameScheduler implements FrameScheduler {
    private final AnimationInformation mAnimationInformation;
    private long mLoopDurationMs = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.mAnimationInformation = animationInformation;
    }

    public int getFrameNumberToRender(long j, long j2) {
        if (isInfiniteAnimation() || j / getLoopDurationMs() < ((long) this.mAnimationInformation.getLoopCount())) {
            return getFrameNumberWithinLoop(j % getLoopDurationMs());
        }
        return -1;
    }

    public long getLoopDurationMs() {
        long j = this.mLoopDurationMs;
        if (j != -1) {
            return j;
        }
        this.mLoopDurationMs = 0;
        int frameCount = this.mAnimationInformation.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mLoopDurationMs += (long) this.mAnimationInformation.getFrameDurationMs(i);
        }
        return this.mLoopDurationMs;
    }

    public long getTargetRenderTimeMs(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (long) this.mAnimationInformation.getFrameDurationMs(i);
        }
        return j;
    }

    public long getTargetRenderTimeForNextFrameMs(long j) {
        long loopDurationMs = getLoopDurationMs();
        long j2 = 0;
        if (loopDurationMs == 0) {
            return -1;
        }
        if (!isInfiniteAnimation() && j / getLoopDurationMs() >= ((long) this.mAnimationInformation.getLoopCount())) {
            return -1;
        }
        long j3 = j % loopDurationMs;
        int frameCount = this.mAnimationInformation.getFrameCount();
        for (int i = 0; i < frameCount && j2 <= j3; i++) {
            j2 += (long) this.mAnimationInformation.getFrameDurationMs(i);
        }
        return j + (j2 - j3);
    }

    public boolean isInfiniteAnimation() {
        return this.mAnimationInformation.getLoopCount() == 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getFrameNumberWithinLoop(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += (long) this.mAnimationInformation.getFrameDurationMs(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
