package com.tiqiaa.remote.entity;

public enum AirPower {
    POWER_OFF(0),
    POWER_ON(1),
    WORK(2);
    
    private final int value;

    private AirPower(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirPower getPowerState(int i) {
        if (i == 0) {
            return POWER_OFF;
        }
        if (i == 1) {
            return POWER_ON;
        }
        if (i != 2) {
            return POWER_OFF;
        }
        return WORK;
    }
}
