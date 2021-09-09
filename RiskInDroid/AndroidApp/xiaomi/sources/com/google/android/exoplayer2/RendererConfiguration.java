package com.google.android.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT = new RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i) {
        this.tunnelingAudioSessionId = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.tunnelingAudioSessionId == ((RendererConfiguration) obj).tunnelingAudioSessionId;
    }

    public final int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
