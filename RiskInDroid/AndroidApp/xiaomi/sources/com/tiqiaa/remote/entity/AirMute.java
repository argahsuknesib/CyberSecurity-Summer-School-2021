package com.tiqiaa.remote.entity;

public enum AirMute {
    MUTE_OFF(0),
    MUTE_ON(1);
    
    private final int value;

    private AirMute(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirMute getMuteState(int i) {
        if (i == 0) {
            return MUTE_OFF;
        }
        if (i != 1) {
            return MUTE_OFF;
        }
        return MUTE_ON;
    }
}
