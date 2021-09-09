package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    private Throwable cause;

    public Throwable getCause() {
        return this.cause;
    }
}
