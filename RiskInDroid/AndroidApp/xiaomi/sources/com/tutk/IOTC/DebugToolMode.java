package com.tutk.IOTC;

public enum DebugToolMode {
    ENABLE_LOCAL(0),
    ENABLE_REMOTE(1);
    
    private int value;

    private DebugToolMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
