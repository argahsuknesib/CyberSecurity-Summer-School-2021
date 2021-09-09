package com.tiqiaa.remote.entity;

public enum AirWindHoz {
    HOZ_OFF(0),
    HOZ_ON(1);
    
    private final int value;

    private AirWindHoz(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirWindHoz getWindHoz(int i) {
        if (i == 0) {
            return HOZ_OFF;
        }
        if (i != 1) {
            return HOZ_OFF;
        }
        return HOZ_ON;
    }
}
