package com.tencent.mm.opensdk.constants;

public final class Build {
    private Build() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static int getMajorVersion() {
        return 5;
    }

    public static int getMinorVersion() {
        return 1;
    }
}
