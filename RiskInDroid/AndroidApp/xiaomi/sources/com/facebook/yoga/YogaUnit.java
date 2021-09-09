package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    
    private final int mIntValue;

    private YogaUnit(int i) {
        this.mIntValue = i;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaUnit fromInt(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return POINT;
        }
        if (i == 2) {
            return PERCENT;
        }
        if (i == 3) {
            return AUTO;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
