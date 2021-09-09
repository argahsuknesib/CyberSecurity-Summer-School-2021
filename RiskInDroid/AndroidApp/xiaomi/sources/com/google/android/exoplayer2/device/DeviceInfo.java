package com.google.android.exoplayer2.device;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class DeviceInfo {
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;

    @Documented
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public DeviceInfo(int i, int i2, int i3) {
        this.playbackType = i;
        this.minVolume = i2;
        this.maxVolume = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume;
    }

    public final int hashCode() {
        return ((((this.playbackType + 527) * 31) + this.minVolume) * 31) + this.maxVolume;
    }
}
