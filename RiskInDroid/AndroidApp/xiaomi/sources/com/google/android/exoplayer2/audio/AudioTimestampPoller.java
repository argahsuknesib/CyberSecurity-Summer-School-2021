package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.Util;

final class AudioTimestampPoller {
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.audioTimestamp = new AudioTimestampV19(audioTrack);
            reset();
            return;
        }
        this.audioTimestamp = null;
        updateState(3);
    }

    @TargetApi(19)
    public final boolean maybePollTimestamp(long j) {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 == null || j - this.lastTimestampSampleTimeUs < this.sampleIntervalUs) {
            return false;
        }
        this.lastTimestampSampleTimeUs = j;
        boolean maybeUpdateTimestamp = audioTimestampV19.maybeUpdateTimestamp();
        int i = this.state;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return maybeUpdateTimestamp;
                        }
                        throw new IllegalStateException();
                    } else if (!maybeUpdateTimestamp) {
                        return maybeUpdateTimestamp;
                    } else {
                        reset();
                        return maybeUpdateTimestamp;
                    }
                } else if (maybeUpdateTimestamp) {
                    return maybeUpdateTimestamp;
                } else {
                    reset();
                    return maybeUpdateTimestamp;
                }
            } else if (!maybeUpdateTimestamp) {
                reset();
                return maybeUpdateTimestamp;
            } else if (this.audioTimestamp.getTimestampPositionFrames() <= this.initialTimestampPositionFrames) {
                return maybeUpdateTimestamp;
            } else {
                updateState(2);
                return maybeUpdateTimestamp;
            }
        } else if (maybeUpdateTimestamp) {
            if (this.audioTimestamp.getTimestampSystemTimeUs() < this.initializeSystemTimeUs) {
                return false;
            }
            this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
            updateState(1);
            return maybeUpdateTimestamp;
        } else if (j - this.initializeSystemTimeUs <= 500000) {
            return maybeUpdateTimestamp;
        } else {
            updateState(3);
            return maybeUpdateTimestamp;
        }
    }

    public final void rejectTimestamp() {
        updateState(4);
    }

    public final void acceptTimestamp() {
        if (this.state == 4) {
            reset();
        }
    }

    public final boolean hasTimestamp() {
        int i = this.state;
        return i == 1 || i == 2;
    }

    public final boolean isTimestampAdvancing() {
        return this.state == 2;
    }

    public final void reset() {
        if (this.audioTimestamp != null) {
            updateState(0);
        }
    }

    @TargetApi(19)
    public final long getTimestampSystemTimeUs() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampSystemTimeUs();
        }
        return -9223372036854775807L;
    }

    @TargetApi(19)
    public final long getTimestampPositionFrames() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampPositionFrames();
        }
        return -1;
    }

    private void updateState(int i) {
        this.state = i;
        if (i == 0) {
            this.lastTimestampSampleTimeUs = 0;
            this.initialTimestampPositionFrames = -1;
            this.initializeSystemTimeUs = System.nanoTime() / 1000;
            this.sampleIntervalUs = 5000;
        } else if (i == 1) {
            this.sampleIntervalUs = 5000;
        } else if (i == 2 || i == 3) {
            this.sampleIntervalUs = 10000000;
        } else if (i == 4) {
            this.sampleIntervalUs = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp = new AudioTimestamp();
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public AudioTimestampV19(AudioTrack audioTrack2) {
            this.audioTrack = audioTrack2;
        }

        public final boolean maybeUpdateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j = this.audioTimestamp.framePosition;
                if (this.lastTimestampRawPositionFrames > j) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastTimestampRawPositionFrames = j;
                this.lastTimestampPositionFrames = j + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }

        public final long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000;
        }

        public final long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }
    }
}
