package com.polidea.rxandroidble.exceptions;

import _m_j.cqw;

public class BleGattException extends BleException {
    private final cqw bleGattOperationType;
    private final int status;

    public BleGattException(int i, cqw cqw) {
        this.status = i;
        this.bleGattOperationType = cqw;
    }

    public BleGattException(cqw cqw) {
        this(-1, cqw);
    }

    public cqw getBleGattOperationType() {
        return this.bleGattOperationType;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + "status=" + this.status + ", bleGattOperation=" + this.bleGattOperationType + '}';
    }
}
