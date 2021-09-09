package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.text.Cue;

final class SubtitleViewUtils {
    public static float resolveTextSize(int i, float f, int i2, int i3) {
        float f2;
        if (i == 0) {
            f2 = (float) i3;
        } else if (i == 1) {
            f2 = (float) i2;
        } else if (i != 2) {
            return -3.4028235E38f;
        } else {
            return f;
        }
        return f * f2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public static float resolveCueTextSize(Cue cue, int i, int i2) {
        if (cue.textSizeType == Integer.MIN_VALUE || cue.textSize == -3.4028235E38f) {
            return 0.0f;
        }
        return Math.max(resolveTextSize(cue.textSizeType, cue.textSize, i, i2), 0.0f);
    }

    private SubtitleViewUtils() {
    }
}
