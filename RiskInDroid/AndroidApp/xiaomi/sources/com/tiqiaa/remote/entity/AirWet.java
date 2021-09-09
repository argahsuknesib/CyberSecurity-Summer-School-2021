package com.tiqiaa.remote.entity;

public enum AirWet {
    WET_OFF(0),
    WET_ON(1);
    
    private final int value;

    private AirWet(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirWet getWetState(int i) {
        if (i == 0) {
            return WET_OFF;
        }
        if (i != 1) {
            return WET_OFF;
        }
        return WET_ON;
    }
}
