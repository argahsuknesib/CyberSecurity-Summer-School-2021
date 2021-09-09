package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.startTimeIndex = i;
        this.endTimeIndex = i2;
        this.styleIndex = i3;
        this.textIndex = i4;
        this.length = i5;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static SsaDialogueFormat fromFormatLine(String str) {
        char c;
        Assertions.checkArgument(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            String lowerInvariant = Util.toLowerInvariant(split[i5].trim());
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (lowerInvariant.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (lowerInvariant.equals("style")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                i = i5;
            } else if (c == 1) {
                i2 = i5;
            } else if (c == 2) {
                i3 = i5;
            } else if (c == 3) {
                i4 = i5;
            }
        }
        if (i == -1 || i2 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i, i2, i3, i4, split.length);
    }
}
