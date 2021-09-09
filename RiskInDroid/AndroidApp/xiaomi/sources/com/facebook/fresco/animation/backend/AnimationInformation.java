package com.facebook.fresco.animation.backend;

public interface AnimationInformation {
    int getFrameCount();

    int getFrameDurationMs(int i);

    int getLoopCount();
}
