package com.tiqiaa.remote.entity;

public enum AirSleep {
    SLEEP_OFF(0),
    SLEEP_ON(1);
    
    private final int value;

    private AirSleep(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirSleep getSleepState(int i) {
        if (i == 0) {
            return SLEEP_OFF;
        }
        if (i != 1) {
            return SLEEP_OFF;
        }
        return SLEEP_ON;
    }
}
