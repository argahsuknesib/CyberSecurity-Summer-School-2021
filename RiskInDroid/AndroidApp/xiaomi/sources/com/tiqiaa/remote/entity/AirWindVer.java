package com.tiqiaa.remote.entity;

public enum AirWindVer {
    VER_OFF(0),
    VER_ON(1);
    
    private final int value;

    private AirWindVer(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirWindVer getWindVer(int i) {
        if (i == 0) {
            return VER_OFF;
        }
        if (i != 1) {
            return VER_OFF;
        }
        return VER_ON;
    }
}
