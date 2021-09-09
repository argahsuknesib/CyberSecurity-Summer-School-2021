package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.util.encoders;

public class EncoderException extends IllegalStateException {
    private Throwable cause;

    public Throwable getCause() {
        return this.cause;
    }
}
