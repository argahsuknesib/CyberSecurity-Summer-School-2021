package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);
    
    private final int mIntValue;

    private YogaPrintOptions(int i) {
        this.mIntValue = i;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaPrintOptions fromInt(int i) {
        if (i == 1) {
            return LAYOUT;
        }
        if (i == 2) {
            return STYLE;
        }
        if (i == 4) {
            return CHILDREN;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
