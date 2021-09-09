package com.google.android.exoplayer2.util;

public interface MediaClock {
    float getPlaybackSpeed();

    long getPositionUs();

    void setPlaybackSpeed(float f);
}
