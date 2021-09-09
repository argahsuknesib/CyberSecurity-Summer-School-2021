package com.tiqiaa.remote.entity;

public enum AirAnion {
    ANION_OFF(0),
    ANION_ON(1);
    
    private final int value;

    private AirAnion(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirAnion getAnionState(int i) {
        if (i == 0) {
            return ANION_OFF;
        }
        if (i != 1) {
            return ANION_OFF;
        }
        return ANION_ON;
    }
}
