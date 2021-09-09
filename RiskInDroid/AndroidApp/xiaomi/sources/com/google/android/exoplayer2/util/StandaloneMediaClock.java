package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;

public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private float playbackSpeed = 1.0f;
    private int scaledUsPerMs = getScaledUsPerMs(this.playbackSpeed);
    private boolean started;

    public StandaloneMediaClock(Clock clock2) {
        this.clock = clock2;
    }

    public final void start() {
        if (!this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }

    public final void resetPosition(long j) {
        this.baseUs = j;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    public final long getPositionUs() {
        long j;
        long j2 = this.baseUs;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        if (this.playbackSpeed == 1.0f) {
            j = C.msToUs(elapsedRealtime);
        } else {
            j = elapsedRealtime * ((long) this.scaledUsPerMs);
        }
        return j2 + j;
    }

    public final void setPlaybackSpeed(float f) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackSpeed = f;
        this.scaledUsPerMs = getScaledUsPerMs(f);
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    private static int getScaledUsPerMs(float f) {
        return Math.round(f * 1000.0f);
    }
}
