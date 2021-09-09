package com.facebook.fresco.animation.frame;

public interface FrameScheduler {
    int getFrameNumberToRender(long j, long j2);

    long getLoopDurationMs();

    long getTargetRenderTimeForNextFrameMs(long j);

    long getTargetRenderTimeMs(int i);

    boolean isInfiniteAnimation();
}
