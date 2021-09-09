package com.facebook.fresco.animation.bitmap.wrapper;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;

public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend animatedDrawableBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
    }

    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(i);
    }

    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }
}
