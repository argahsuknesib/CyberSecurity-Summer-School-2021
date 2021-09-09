package com.polidea.rxandroidble.exceptions;

public class BleScanException extends BleException {
    private final int reason;

    public BleScanException(int i) {
        this.reason = i;
    }

    public int getReason() {
        return this.reason;
    }
}
