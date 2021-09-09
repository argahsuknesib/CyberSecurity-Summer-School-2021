package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import com.google.android.exoplayer2.util.Util;

public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new Builder().build();
    public final int allowedCapturePolicy;
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        private int allowedCapturePolicy = 1;
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;

        public final Builder setContentType(int i) {
            this.contentType = i;
            return this;
        }

        public final Builder setFlags(int i) {
            this.flags = i;
            return this;
        }

        public final Builder setUsage(int i) {
            this.usage = i;
            return this;
        }

        public final Builder setAllowedCapturePolicy(int i) {
            this.allowedCapturePolicy = i;
            return this;
        }

        public final AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage, this.allowedCapturePolicy);
        }
    }

    private AudioAttributes(int i, int i2, int i3, int i4) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
    }

    public final android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            AudioAttributes.Builder usage2 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
            if (Util.SDK_INT >= 29) {
                usage2.setAllowedCapturePolicy(this.allowedCapturePolicy);
            }
            this.audioAttributesV21 = usage2.build();
        }
        return this.audioAttributesV21;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            return this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy;
        }
    }

    public final int hashCode() {
        return ((((((this.contentType + 527) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy;
    }
}
