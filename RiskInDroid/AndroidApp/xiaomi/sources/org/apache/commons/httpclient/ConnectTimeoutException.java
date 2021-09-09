package org.apache.commons.httpclient;

import _m_j.jcs;
import java.io.InterruptedIOException;

public class ConnectTimeoutException extends InterruptedIOException {
    public ConnectTimeoutException() {
    }

    public ConnectTimeoutException(String str) {
        super(str);
    }

    public ConnectTimeoutException(String str, Throwable th) {
        super(str);
        jcs.O000000o(this, th);
    }
}
