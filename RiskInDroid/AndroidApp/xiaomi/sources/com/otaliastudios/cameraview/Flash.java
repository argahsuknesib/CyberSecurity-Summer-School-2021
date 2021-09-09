package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class Flash extends Enum<Flash> implements cps {
    private static final /* synthetic */ Flash[] $VALUES;
    public static final Flash AUTO = new Flash("AUTO", 2, 2);
    public static final Flash DEFAULT;
    public static final Flash OFF = new Flash("OFF", 0, 0);
    public static final Flash ON = new Flash("ON", 1, 1);
    public static final Flash TORCH = new Flash("TORCH", 3, 3);
    private int value;

    public static Flash valueOf(String str) {
        return (Flash) Enum.valueOf(Flash.class, str);
    }

    public static Flash[] values() {
        return (Flash[]) $VALUES.clone();
    }

    static {
        Flash flash = OFF;
        $VALUES = new Flash[]{flash, ON, AUTO, TORCH};
        DEFAULT = flash;
    }

    private Flash(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static Flash fromValue(int i) {
        for (Flash flash : values()) {
            if (flash.value() == i) {
                return flash;
            }
        }
        return null;
    }
}
