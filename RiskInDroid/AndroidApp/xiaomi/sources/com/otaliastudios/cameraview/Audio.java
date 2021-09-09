package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class Audio extends Enum<Audio> implements cps {
    private static final /* synthetic */ Audio[] $VALUES;
    static final Audio DEFAULT;
    public static final Audio OFF = new Audio("OFF", 0, 0);
    public static final Audio ON = new Audio("ON", 1, 1);
    private int value;

    public static Audio valueOf(String str) {
        return (Audio) Enum.valueOf(Audio.class, str);
    }

    public static Audio[] values() {
        return (Audio[]) $VALUES.clone();
    }

    static {
        Audio audio = ON;
        $VALUES = new Audio[]{OFF, audio};
        DEFAULT = audio;
    }

    private Audio(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static Audio fromValue(int i) {
        for (Audio audio : values()) {
            if (audio.value() == i) {
                return audio;
            }
        }
        return null;
    }
}
