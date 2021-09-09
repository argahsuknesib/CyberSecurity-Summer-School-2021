package com.tiqiaa.remote.entity;

public enum AirMode {
    AUTO(0),
    WIND(1),
    DRY(2),
    HOT(3),
    COOL(4);
    
    private final int value;

    private AirMode(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirMode getMode(int i) {
        if (i == 0) {
            return AUTO;
        }
        if (i == 1) {
            return WIND;
        }
        if (i == 2) {
            return DRY;
        }
        if (i == 3) {
            return HOT;
        }
        if (i != 4) {
            return AUTO;
        }
        return COOL;
    }
}
