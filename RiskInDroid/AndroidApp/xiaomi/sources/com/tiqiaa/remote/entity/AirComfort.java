package com.tiqiaa.remote.entity;

public enum AirComfort {
    COMFORT_OFF(0),
    COMFORT_ON(1);
    
    private final int value;

    private AirComfort(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirComfort getComfortState(int i) {
        if (i == 0) {
            return COMFORT_OFF;
        }
        if (i != 1) {
            return COMFORT_OFF;
        }
        return COMFORT_ON;
    }
}
