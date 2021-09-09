package com.google.android.gms.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GmsVersionParser {
    private static Pattern zzzy;

    private GmsVersionParser() {
    }

    public static int parseBuildMajorVersion(int i) {
        if (i == -1) {
            return -1;
        }
        return i / 100000;
    }

    public static long parseBuildNumber(String str) {
        if (str == null) {
            return -1;
        }
        Matcher matcher = zzdc().matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        try {
            return Long.parseLong(matcher.group(2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int parseBuildType(String str) {
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            return -1;
        }
        return (int) (parseVariantCode / 10000);
    }

    public static int parseBuildVersion(int i) {
        if (i == -1) {
            return -1;
        }
        return i / 1000;
    }

    public static int parseScreenDensity(String str) {
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            return -1;
        }
        return (int) (parseVariantCode % 100);
    }

    public static int parseTargetArchitecture(String str) {
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            return -1;
        }
        return (int) ((parseVariantCode / 100) % 100);
    }

    public static long parseVariantCode(String str) {
        if (str == null) {
            return -1;
        }
        Matcher matcher = zzdc().matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static Pattern zzdc() {
        if (zzzy == null) {
            zzzy = Pattern.compile("\\((?:eng-)?(\\d+)-(.+?)[-)$]");
        }
        return zzzy;
    }
}
