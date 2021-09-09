package org.apache.commons.httpclient;

public class HttpContentTooLargeException extends HttpException {
    private int maxlen;

    public HttpContentTooLargeException(String str, int i) {
        super(str);
        this.maxlen = i;
    }

    public int getMaxLength() {
        return this.maxlen;
    }
}
