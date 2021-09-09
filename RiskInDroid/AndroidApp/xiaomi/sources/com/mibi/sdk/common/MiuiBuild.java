package com.mibi.sdk.common;

import com.mibi.sdk.common.os.Build;

public class MiuiBuild {
    private MiuiBuild() {
    }

    public static boolean isAlphaBuild() {
        return Build.IS_ALPHA_BUILD;
    }

    public static boolean isDevelopmentVersion() {
        return Build.IS_DEVELOPMENT_VERSION;
    }

    public static boolean isStableVersion() {
        return Build.IS_STABLE_VERSION;
    }

    public static boolean isTablet() {
        return Build.IS_TABLET;
    }

    public static boolean isCTABuild() {
        return Build.IS_CTA_BUILD;
    }

    public static boolean isMiFour() {
        return Build.IS_MIFOUR;
    }

    public static boolean isMiFive() {
        return Build.IS_MIFIVE;
    }

    public static boolean isInternationalBuild() {
        return Build.IS_INTERNATIONAL_BUILD;
    }
}
