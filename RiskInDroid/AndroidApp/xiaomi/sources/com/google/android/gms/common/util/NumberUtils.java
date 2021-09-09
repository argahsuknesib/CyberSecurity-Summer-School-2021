package com.google.android.gms.common.util;

@VisibleForTesting
public class NumberUtils {
    private NumberUtils() {
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static long parseHexLong(String str) {
        if (str.length() > 16) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37);
            sb.append("Invalid input: ");
            sb.append(str);
            sb.append(" exceeds 16 characters");
            throw new NumberFormatException(sb.toString());
        } else if (str.length() != 16) {
            return Long.parseLong(str, 16);
        } else {
            return (Long.parseLong(str.substring(0, 8), 16) << 32) | Long.parseLong(str.substring(8), 16);
        }
    }
}
