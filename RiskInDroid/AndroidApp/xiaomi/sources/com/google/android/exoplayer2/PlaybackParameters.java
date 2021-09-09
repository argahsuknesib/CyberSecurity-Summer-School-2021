package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

@Deprecated
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    private final int scaledUsPerMs;
    public final float speed;

    public PlaybackParameters(float f) {
        Assertions.checkArgument(f > 0.0f);
        this.speed = f;
        this.scaledUsPerMs = Math.round(f * 1000.0f);
    }

    public final long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * ((long) this.scaledUsPerMs);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.speed == ((PlaybackParameters) obj).speed;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.speed);
    }
}
