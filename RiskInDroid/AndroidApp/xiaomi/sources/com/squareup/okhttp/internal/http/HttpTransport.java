package com.squareup.okhttp.internal.http;

import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

public final class HttpTransport implements Transport {
    private final HttpConnection httpConnection;
    private final HttpEngine httpEngine;

    public HttpTransport(HttpEngine httpEngine2, HttpConnection httpConnection2) {
        this.httpEngine = httpEngine2;
        this.httpConnection = httpConnection2;
    }

    public final jbm createRequestBody(Request request, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return this.httpConnection.newChunkedSink();
        }
        if (j != -1) {
            return this.httpConnection.newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void finishRequest() throws IOException {
        this.httpConnection.flush();
    }

    public final void writeRequestBody(RetryableSink retryableSink) throws IOException {
        this.httpConnection.writeRequestBody(retryableSink);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        this.httpEngine.writingRequestHeaders();
        this.httpConnection.writeRequest(request.headers(), RequestLine.get(request, this.httpEngine.getConnection().getRoute().getProxy().type()));
    }

    public final Response.Builder readResponseHeaders() throws IOException {
        return this.httpConnection.readResponse();
    }

    public final void releaseConnectionOnIdle() throws IOException {
        if (canReuseConnection()) {
            this.httpConnection.poolOnIdle();
        } else {
            this.httpConnection.closeOnIdle();
        }
    }

    public final boolean canReuseConnection() {
        if (!"close".equalsIgnoreCase(this.httpEngine.getRequest().header("Connection")) && !"close".equalsIgnoreCase(this.httpEngine.getResponse().header("Connection")) && !this.httpConnection.isClosed()) {
            return true;
        }
        return false;
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), jbg.O000000o(getTransferStream(response)));
    }

    private jbn getTransferStream(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return this.httpConnection.newFixedLengthSource(0);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return this.httpConnection.newChunkedSource(this.httpEngine);
        }
        long contentLength = OkHeaders.contentLength(response);
        if (contentLength != -1) {
            return this.httpConnection.newFixedLengthSource(contentLength);
        }
        return this.httpConnection.newUnknownLengthSource();
    }

    public final void disconnect(HttpEngine httpEngine2) throws IOException {
        this.httpConnection.closeIfOwnedBy(httpEngine2);
    }
}
