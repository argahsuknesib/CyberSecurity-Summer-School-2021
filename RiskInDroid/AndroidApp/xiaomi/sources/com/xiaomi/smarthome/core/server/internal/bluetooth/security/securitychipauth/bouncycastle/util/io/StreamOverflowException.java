package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.util.io;

import java.io.IOException;

public class StreamOverflowException extends IOException {
    public StreamOverflowException(String str) {
        super(str);
    }
}
