package org.apache.commons.httpclient.auth;

public class AuthChallengeException extends AuthenticationException {
    public AuthChallengeException() {
    }

    public AuthChallengeException(String str) {
        super(str);
    }

    public AuthChallengeException(String str, Throwable th) {
        super(str, th);
    }
}
