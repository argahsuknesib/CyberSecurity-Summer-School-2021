package com.facebook.imagepipeline.animated.base;

public class AnimatedDrawableOptionsBuilder {
    private boolean mAllowPrefetching = true;
    private boolean mEnableDebugging;
    private boolean mForceKeepAllFramesInMemory;
    private int mMaximumBytes = -1;

    public boolean getForceKeepAllFramesInMemory() {
        return this.mForceKeepAllFramesInMemory;
    }

    public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean z) {
        this.mForceKeepAllFramesInMemory = z;
        return this;
    }

    public boolean getAllowPrefetching() {
        return this.mAllowPrefetching;
    }

    public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean z) {
        this.mAllowPrefetching = z;
        return this;
    }

    public int getMaximumBytes() {
        return this.mMaximumBytes;
    }

    public AnimatedDrawableOptionsBuilder setMaximumBytes(int i) {
        this.mMaximumBytes = i;
        return this;
    }

    public boolean getEnableDebugging() {
        return this.mEnableDebugging;
    }

    public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean z) {
        this.mEnableDebugging = z;
        return this;
    }

    public AnimatedDrawableOptions build() {
        return new AnimatedDrawableOptions(this);
    }
}
