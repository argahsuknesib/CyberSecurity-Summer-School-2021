package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class Facing extends Enum<Facing> implements cps {
    private static final /* synthetic */ Facing[] $VALUES;
    public static final Facing BACK = new Facing("BACK", 0, 0);
    static final Facing DEFAULT;
    public static final Facing FRONT = new Facing("FRONT", 1, 1);
    private int value;

    public static Facing valueOf(String str) {
        return (Facing) Enum.valueOf(Facing.class, str);
    }

    public static Facing[] values() {
        return (Facing[]) $VALUES.clone();
    }

    static {
        Facing facing = BACK;
        $VALUES = new Facing[]{facing, FRONT};
        DEFAULT = facing;
    }

    private Facing(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static Facing fromValue(int i) {
        for (Facing facing : values()) {
            if (facing.value() == i) {
                return facing;
            }
        }
        return null;
    }
}
