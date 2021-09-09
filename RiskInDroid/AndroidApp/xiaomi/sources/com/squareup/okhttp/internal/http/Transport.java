package com.squareup.okhttp.internal.http;

import _m_j.jbm;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

public interface Transport {
    boolean canReuseConnection();

    jbm createRequestBody(Request request, long j) throws IOException;

    void disconnect(HttpEngine httpEngine) throws IOException;

    void finishRequest() throws IOException;

    ResponseBody openResponseBody(Response response) throws IOException;

    Response.Builder readResponseHeaders() throws IOException;

    void releaseConnectionOnIdle() throws IOException;

    void writeRequestBody(RetryableSink retryableSink) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
