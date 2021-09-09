package com.tiqiaa.remote.entity;

public enum AirWindDirection {
    AUTO(0),
    UP(1),
    MIDDLE(2),
    DOWN(3);
    
    private final int value;

    private AirWindDirection(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirWindDirection getWindDirection(int i) {
        if (i == 0) {
            return AUTO;
        }
        if (i == 1) {
            return UP;
        }
        if (i == 2) {
            return MIDDLE;
        }
        if (i != 3) {
            return AUTO;
        }
        return DOWN;
    }
}
