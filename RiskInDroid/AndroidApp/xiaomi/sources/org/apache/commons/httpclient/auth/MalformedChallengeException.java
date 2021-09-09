package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.ProtocolException;

public class MalformedChallengeException extends ProtocolException {
    public MalformedChallengeException() {
    }

    public MalformedChallengeException(String str) {
        super(str);
    }

    public MalformedChallengeException(String str, Throwable th) {
        super(str, th);
    }
}
