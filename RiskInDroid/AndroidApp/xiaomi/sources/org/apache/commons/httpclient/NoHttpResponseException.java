package org.apache.commons.httpclient;

import _m_j.jcs;
import java.io.IOException;

public class NoHttpResponseException extends IOException {
    public NoHttpResponseException() {
    }

    public NoHttpResponseException(String str) {
        super(str);
    }

    public NoHttpResponseException(String str, Throwable th) {
        super(str);
        jcs.O000000o(this, th);
    }
}
