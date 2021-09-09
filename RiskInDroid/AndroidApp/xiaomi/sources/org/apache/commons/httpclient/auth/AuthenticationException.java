package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.ProtocolException;

public class AuthenticationException extends ProtocolException {
    public AuthenticationException() {
    }

    public AuthenticationException(String str) {
        super(str);
    }

    public AuthenticationException(String str, Throwable th) {
        super(str, th);
    }
}
