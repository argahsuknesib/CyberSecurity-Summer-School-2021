package com.facebook.imagepipeline.animated.base;

public class AnimatedDrawableOptions {
    public static AnimatedDrawableOptions DEFAULTS = newBuilder().build();
    public final boolean allowPrefetching;
    public final boolean enableDebugging;
    public final boolean forceKeepAllFramesInMemory;
    public final int maximumBytes;

    public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder animatedDrawableOptionsBuilder) {
        this.forceKeepAllFramesInMemory = animatedDrawableOptionsBuilder.getForceKeepAllFramesInMemory();
        this.allowPrefetching = animatedDrawableOptionsBuilder.getAllowPrefetching();
        this.maximumBytes = animatedDrawableOptionsBuilder.getMaximumBytes();
        this.enableDebugging = animatedDrawableOptionsBuilder.getEnableDebugging();
    }

    public static AnimatedDrawableOptionsBuilder newBuilder() {
        return new AnimatedDrawableOptionsBuilder();
    }
}
