package org.apache.commons.httpclient.auth;

public class CredentialsNotAvailableException extends AuthenticationException {
    public CredentialsNotAvailableException() {
    }

    public CredentialsNotAvailableException(String str) {
        super(str);
    }

    public CredentialsNotAvailableException(String str, Throwable th) {
        super(str, th);
    }
}
