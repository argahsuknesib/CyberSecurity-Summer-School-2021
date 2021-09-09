package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class WhiteBalance extends Enum<WhiteBalance> implements cps {
    private static final /* synthetic */ WhiteBalance[] $VALUES;
    public static final WhiteBalance AUTO = new WhiteBalance("AUTO", 0, 0);
    public static final WhiteBalance CLOUDY = new WhiteBalance("CLOUDY", 4, 4);
    public static final WhiteBalance DAYLIGHT = new WhiteBalance("DAYLIGHT", 3, 3);
    public static final WhiteBalance DEFAULT;
    public static final WhiteBalance FLUORESCENT = new WhiteBalance("FLUORESCENT", 2, 2);
    public static final WhiteBalance INCANDESCENT = new WhiteBalance("INCANDESCENT", 1, 1);
    private int value;

    public static WhiteBalance valueOf(String str) {
        return (WhiteBalance) Enum.valueOf(WhiteBalance.class, str);
    }

    public static WhiteBalance[] values() {
        return (WhiteBalance[]) $VALUES.clone();
    }

    static {
        WhiteBalance whiteBalance = AUTO;
        $VALUES = new WhiteBalance[]{whiteBalance, INCANDESCENT, FLUORESCENT, DAYLIGHT, CLOUDY};
        DEFAULT = whiteBalance;
    }

    private WhiteBalance(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static WhiteBalance fromValue(int i) {
        for (WhiteBalance whiteBalance : values()) {
            if (whiteBalance.value() == i) {
                return whiteBalance;
            }
        }
        return null;
    }
}
