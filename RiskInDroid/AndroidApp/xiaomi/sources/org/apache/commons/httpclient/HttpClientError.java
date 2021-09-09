package org.apache.commons.httpclient;

public class HttpClientError extends Error {
    public HttpClientError() {
    }

    public HttpClientError(String str) {
        super(str);
    }
}
