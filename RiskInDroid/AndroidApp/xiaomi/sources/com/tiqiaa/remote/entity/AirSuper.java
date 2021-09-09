package com.tiqiaa.remote.entity;

public enum AirSuper {
    SUPER_OFF(0),
    SUPER_ON(1);
    
    private final int value;

    private AirSuper(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirSuper getSuperState(int i) {
        if (i == 0) {
            return SUPER_OFF;
        }
        if (i != 1) {
            return SUPER_OFF;
        }
        return SUPER_ON;
    }
}
