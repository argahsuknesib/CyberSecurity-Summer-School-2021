package org.apache.commons.httpclient;

public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
    public ConnectionPoolTimeoutException() {
    }

    public ConnectionPoolTimeoutException(String str) {
        super(str);
    }

    public ConnectionPoolTimeoutException(String str, Throwable th) {
        super(str, th);
    }
}
