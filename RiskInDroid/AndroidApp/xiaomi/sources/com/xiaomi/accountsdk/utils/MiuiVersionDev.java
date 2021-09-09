package com.xiaomi.accountsdk.utils;

import android.os.Build;
import com.google.android.exoplayer2.C;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiuiVersionDev implements Comparable<MiuiVersionDev> {
    private static final Pattern PATTERN_DEV = Pattern.compile("^(\\d)\\.(\\d{1,2})\\.(\\d{1,2})$");
    private static volatile MiuiVersionDev sVersionThisBuild;
    public final int day;
    public final int month;
    public final int year;

    public MiuiVersionDev(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static boolean earlyThan(MiuiVersionDev miuiVersionDev, boolean z) {
        MiuiVersionDev parseFromBuild = parseFromBuild();
        if (parseFromBuild == null) {
            return z;
        }
        return parseFromBuild.compareTo(miuiVersionDev) < 0;
    }

    public static MiuiVersionDev parseFromBuild() {
        if (sVersionThisBuild != null) {
            return sVersionThisBuild;
        }
        String str = Build.VERSION.INCREMENTAL;
        if (str == null) {
            return null;
        }
        Matcher matcher = PATTERN_DEV.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        MiuiVersionDev miuiVersionDev = new MiuiVersionDev(Integer.valueOf(matcher.group(1)).intValue(), Integer.valueOf(matcher.group(2)).intValue(), Integer.valueOf(matcher.group(3)).intValue());
        sVersionThisBuild = miuiVersionDev;
        return miuiVersionDev;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiuiVersionDev)) {
            return false;
        }
        MiuiVersionDev miuiVersionDev = (MiuiVersionDev) obj;
        return this.year == miuiVersionDev.year && this.month == miuiVersionDev.month && this.day == miuiVersionDev.day;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.day;
    }

    public int compareTo(MiuiVersionDev miuiVersionDev) {
        if (miuiVersionDev != null) {
            return val() - miuiVersionDev.val();
        }
        throw new IllegalArgumentException("another == null");
    }

    private int val() {
        return this.day + (this.month * 100) + (this.year * C.MSG_CUSTOM_BASE);
    }
}
