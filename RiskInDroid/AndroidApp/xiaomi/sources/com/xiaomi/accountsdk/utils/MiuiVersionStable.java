package com.xiaomi.accountsdk.utils;

import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiuiVersionStable implements Comparable<MiuiVersionStable> {
    private static final Pattern PATTERN_STABLE = Pattern.compile("^V(\\d+)\\.(\\d+)\\.\\d+\\.\\d+\\.[A-Z]{7}$");
    private static volatile MiuiVersionStable sVersionThisBuild;
    public final int major;
    public final int minor;

    public MiuiVersionStable(int i, int i2) {
        this.major = i;
        this.minor = i2;
    }

    public static boolean earlyThan(MiuiVersionStable miuiVersionStable, boolean z) {
        MiuiVersionStable parseFromBuild = parseFromBuild();
        if (parseFromBuild == null) {
            return z;
        }
        return parseFromBuild.compareTo(miuiVersionStable) < 0;
    }

    public static MiuiVersionStable parseFromBuild() {
        if (sVersionThisBuild != null) {
            return sVersionThisBuild;
        }
        String str = Build.VERSION.INCREMENTAL;
        if (str == null) {
            return null;
        }
        Matcher matcher = PATTERN_STABLE.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        MiuiVersionStable miuiVersionStable = new MiuiVersionStable(Integer.valueOf(matcher.group(1)).intValue(), Integer.valueOf(matcher.group(2)).intValue());
        sVersionThisBuild = miuiVersionStable;
        return miuiVersionStable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiuiVersionStable)) {
            return false;
        }
        MiuiVersionStable miuiVersionStable = (MiuiVersionStable) obj;
        return this.major == miuiVersionStable.major && this.minor == miuiVersionStable.minor;
    }

    public int hashCode() {
        return (this.major * 31) + this.minor;
    }

    public int compareTo(MiuiVersionStable miuiVersionStable) {
        if (miuiVersionStable != null) {
            return valToCompare() - miuiVersionStable.valToCompare();
        }
        throw new IllegalArgumentException("another == null");
    }

    private int valToCompare() {
        return (this.major * 100) + this.minor;
    }
}
