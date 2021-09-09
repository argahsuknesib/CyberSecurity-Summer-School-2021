package com.polidea.rxandroidble.exceptions;

public class BleAlreadyConnectedException extends BleException {
    private final String macAddress;

    public BleAlreadyConnectedException(String str) {
        this.macAddress = str;
    }

    public String toString() {
        return "BleAlreadyConnectedException{macAddress=" + this.macAddress + '}';
    }
}
