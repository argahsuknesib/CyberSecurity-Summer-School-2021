package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException extends Exception {
    public RequestException(IOException iOException) {
        super(iOException);
    }

    public final IOException getCause() {
        return (IOException) super.getCause();
    }
}
