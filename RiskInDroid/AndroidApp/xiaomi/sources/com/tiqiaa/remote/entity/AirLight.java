package com.tiqiaa.remote.entity;

public enum AirLight {
    LIGHT_OFF(0),
    LIGHT_ON(1);
    
    private final int value;

    private AirLight(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirLight getLightState(int i) {
        if (i == 0) {
            return LIGHT_OFF;
        }
        if (i != 1) {
            return LIGHT_OFF;
        }
        return LIGHT_ON;
    }
}
