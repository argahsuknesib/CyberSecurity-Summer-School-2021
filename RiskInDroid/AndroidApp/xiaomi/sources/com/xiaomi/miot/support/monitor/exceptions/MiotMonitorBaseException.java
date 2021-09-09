package com.xiaomi.miot.support.monitor.exceptions;

public abstract class MiotMonitorBaseException extends Exception {
    public abstract String getLogInfo();

    public MiotMonitorBaseException() {
    }

    public MiotMonitorBaseException(String str) {
        super(str);
    }
}
