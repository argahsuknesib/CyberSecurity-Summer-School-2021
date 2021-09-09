package com.tiqiaa.remote.entity;

public enum AirAidHot {
    AIDHOT_OFF(0),
    AIDHOT_ON(1);
    
    private final int value;

    private AirAidHot(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirAidHot getAidHottate(int i) {
        if (i == 0) {
            return AIDHOT_OFF;
        }
        if (i != 1) {
            return AIDHOT_OFF;
        }
        return AIDHOT_ON;
    }
}
