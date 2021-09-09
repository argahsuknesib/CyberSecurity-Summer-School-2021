package com.tiqiaa.remote.entity;

public enum AirFlashAir {
    FLASH_OFF(0),
    FLASH_ON(1);
    
    private final int value;

    private AirFlashAir(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static AirFlashAir getFlashAirState(int i) {
        if (i == 0) {
            return FLASH_OFF;
        }
        if (i != 1) {
            return FLASH_OFF;
        }
        return FLASH_ON;
    }
}
