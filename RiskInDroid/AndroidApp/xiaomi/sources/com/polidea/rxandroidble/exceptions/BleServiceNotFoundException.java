package com.polidea.rxandroidble.exceptions;

import java.util.UUID;

public class BleServiceNotFoundException extends BleException {
    private final UUID serviceUUID;

    public BleServiceNotFoundException(UUID uuid) {
        this.serviceUUID = uuid;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }

    public String toString() {
        return "BleServiceNotFoundException{serviceUUID=" + this.serviceUUID + '}';
    }
}
