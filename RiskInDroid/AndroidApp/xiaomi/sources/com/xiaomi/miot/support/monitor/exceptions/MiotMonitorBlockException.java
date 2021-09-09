package com.xiaomi.miot.support.monitor.exceptions;

public class MiotMonitorBlockException extends MiotMonitorBaseException {
    private static final long serialVersionUID = 2;

    public String getLogInfo() {
        StackTraceElement[] stackTrace = getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString() + "\n");
        }
        return sb.toString();
    }
}
