package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.ProtocolException;

public class MalformedCookieException extends ProtocolException {
    public MalformedCookieException() {
    }

    public MalformedCookieException(String str) {
        super(str);
    }

    public MalformedCookieException(String str, Throwable th) {
        super(str, th);
    }
}
