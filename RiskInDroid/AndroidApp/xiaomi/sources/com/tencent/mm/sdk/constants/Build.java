package com.tencent.mm.sdk.constants;

public final class Build {
    private Build() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static int getMajorVersion() {
        return 3;
    }

    public static int getMinorVersion() {
        return 1;
    }
}
