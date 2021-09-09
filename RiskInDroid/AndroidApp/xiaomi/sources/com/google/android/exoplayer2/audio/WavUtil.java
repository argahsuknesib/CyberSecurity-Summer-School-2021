package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class WavUtil {
    public static int getTypeForPcmEncoding(int i) {
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 536870912 || i == 805306368) {
            return 1;
        }
        throw new IllegalArgumentException();
    }

    public static int getPcmEncodingForType(int i, int i2) {
        if (i != 1) {
            if (i == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (i != 65534) {
                return 0;
            }
        }
        return Util.getPcmEncoding(i2);
    }

    private WavUtil() {
    }
}
