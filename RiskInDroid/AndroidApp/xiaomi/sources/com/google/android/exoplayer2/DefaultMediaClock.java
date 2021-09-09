package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

final class DefaultMediaClock implements MediaClock {
    private boolean isUsingStandaloneClock = true;
    private final PlaybackSpeedListener listener;
    private MediaClock rendererClock;
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneClock;
    private boolean standaloneClockIsStarted;

    public interface PlaybackSpeedListener {
        void onPlaybackSpeedChanged(float f);
    }

    public DefaultMediaClock(PlaybackSpeedListener playbackSpeedListener, Clock clock) {
        this.listener = playbackSpeedListener;
        this.standaloneClock = new StandaloneMediaClock(clock);
    }

    public final void start() {
        this.standaloneClockIsStarted = true;
        this.standaloneClock.start();
    }

    public final void stop() {
        this.standaloneClockIsStarted = false;
        this.standaloneClock.stop();
    }

    public final void resetPosition(long j) {
        this.standaloneClock.resetPosition(j);
    }

    public final void onRendererEnabled(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 != null && mediaClock2 != (mediaClock = this.rendererClock)) {
            if (mediaClock == null) {
                this.rendererClock = mediaClock2;
                this.rendererClockSource = renderer;
                this.rendererClock.setPlaybackSpeed(this.standaloneClock.getPlaybackSpeed());
                return;
            }
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public final void onRendererDisabled(Renderer renderer) {
        if (renderer == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
            this.isUsingStandaloneClock = true;
        }
    }

    public final long syncAndGetPositionUs(boolean z) {
        syncClocks(z);
        return getPositionUs();
    }

    public final long getPositionUs() {
        return this.isUsingStandaloneClock ? this.standaloneClock.getPositionUs() : this.rendererClock.getPositionUs();
    }

    public final void setPlaybackSpeed(float f) {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            mediaClock.setPlaybackSpeed(f);
            f = this.rendererClock.getPlaybackSpeed();
        }
        this.standaloneClock.setPlaybackSpeed(f);
    }

    public final float getPlaybackSpeed() {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            return mediaClock.getPlaybackSpeed();
        }
        return this.standaloneClock.getPlaybackSpeed();
    }

    private void syncClocks(boolean z) {
        if (shouldUseStandaloneClock(z)) {
            this.isUsingStandaloneClock = true;
            if (this.standaloneClockIsStarted) {
                this.standaloneClock.start();
                return;
            }
            return;
        }
        long positionUs = this.rendererClock.getPositionUs();
        if (this.isUsingStandaloneClock) {
            if (positionUs < this.standaloneClock.getPositionUs()) {
                this.standaloneClock.stop();
                return;
            }
            this.isUsingStandaloneClock = false;
            if (this.standaloneClockIsStarted) {
                this.standaloneClock.start();
            }
        }
        this.standaloneClock.resetPosition(positionUs);
        float playbackSpeed = this.rendererClock.getPlaybackSpeed();
        if (playbackSpeed != this.standaloneClock.getPlaybackSpeed()) {
            this.standaloneClock.setPlaybackSpeed(playbackSpeed);
            this.listener.onPlaybackSpeedChanged(playbackSpeed);
        }
    }

    private boolean shouldUseStandaloneClock(boolean z) {
        Renderer renderer = this.rendererClockSource;
        if (renderer == null || renderer.isEnded()) {
            return true;
        }
        if (!this.rendererClockSource.isReady()) {
            return z || this.rendererClockSource.hasReadStreamToEnd();
        }
        return false;
    }
}
