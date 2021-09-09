package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class Hdr extends Enum<Hdr> implements cps {
    private static final /* synthetic */ Hdr[] $VALUES;
    public static final Hdr DEFAULT;
    public static final Hdr OFF = new Hdr("OFF", 0, 0);
    public static final Hdr ON = new Hdr("ON", 1, 1);
    private int value;

    public static Hdr valueOf(String str) {
        return (Hdr) Enum.valueOf(Hdr.class, str);
    }

    public static Hdr[] values() {
        return (Hdr[]) $VALUES.clone();
    }

    static {
        Hdr hdr = OFF;
        $VALUES = new Hdr[]{hdr, ON};
        DEFAULT = hdr;
    }

    private Hdr(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static Hdr fromValue(int i) {
        for (Hdr hdr : values()) {
            if (hdr.value() == i) {
                return hdr;
            }
        }
        return null;
    }
}
