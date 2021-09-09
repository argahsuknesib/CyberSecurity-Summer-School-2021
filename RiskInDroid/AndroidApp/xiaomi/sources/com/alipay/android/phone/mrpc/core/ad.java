package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class ad implements HttpRequestRetryHandler {

    /* renamed from: a  reason: collision with root package name */
    static final String f3130a = "ad";

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        if (i >= 3) {
            return false;
        }
        if (iOException instanceof NoHttpResponseException) {
            return true;
        }
        return ((iOException instanceof SocketException) || (iOException instanceof SSLException)) && iOException.getMessage() != null && iOException.getMessage().contains("Broken pipe");
    }
}
