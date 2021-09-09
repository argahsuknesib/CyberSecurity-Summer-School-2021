package com.tutk.IOTC;

public enum Region {
    REGION_ALL(0),
    REGION_CN(1),
    REGION_EU(2),
    REGION_US(3),
    REGION_ASIA(4);
    
    private int value;

    private Region(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
