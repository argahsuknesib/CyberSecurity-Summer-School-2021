package com.tiqiaa.remote.entity;

public enum AirWindAmount {
    LEVEL_1(0),
    LEVEL_2(1),
    LEVEL_3(2),
    LEVEL_4(3),
    AUTO(4);
    
    private final int value;

    private AirWindAmount(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirWindAmount getWindAmount(int i) {
        if (i == 0) {
            return LEVEL_1;
        }
        if (i == 1) {
            return LEVEL_2;
        }
        if (i == 2) {
            return LEVEL_3;
        }
        if (i == 3) {
            return LEVEL_4;
        }
        if (i != 4) {
            return LEVEL_1;
        }
        return AUTO;
    }
}
