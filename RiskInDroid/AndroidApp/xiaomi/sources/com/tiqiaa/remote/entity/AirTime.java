package com.tiqiaa.remote.entity;

public enum AirTime {
    TIME_OFF(0),
    TIME_ON(1);
    
    private final int value;

    private AirTime(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirTime getTimeState(int i) {
        if (i == 0) {
            return TIME_OFF;
        }
        if (i != 1) {
            return TIME_OFF;
        }
        return TIME_ON;
    }
}
