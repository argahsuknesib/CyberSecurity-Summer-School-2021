package com.tiqiaa.remote.entity;

public enum AirTempDisplay {
    DISPLAY_OUTDOOR_TEMP(0),
    DISPLAY_INDOOR_TEMP(1),
    DISPLAY_TARGET_TEMP(2),
    DISPLAY_NONE(3);
    
    private final int value;

    private AirTempDisplay(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirTempDisplay getTempDisplay(int i) {
        if (i == 0) {
            return DISPLAY_OUTDOOR_TEMP;
        }
        if (i == 1) {
            return DISPLAY_INDOOR_TEMP;
        }
        if (i != 2) {
            return DISPLAY_NONE;
        }
        return DISPLAY_TARGET_TEMP;
    }
}
