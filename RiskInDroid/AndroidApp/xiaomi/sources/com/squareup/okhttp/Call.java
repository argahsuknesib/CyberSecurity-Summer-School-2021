package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Call {
    volatile boolean canceled;
    public final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* access modifiers changed from: package-private */
    public Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    /* access modifiers changed from: package-private */
    public void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.disconnect();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        /* access modifiers changed from: package-private */
        public final String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        /* access modifiers changed from: package-private */
        public final Request request() {
            return Call.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public final Object tag() {
            return Call.this.originalRequest.tag();
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            Call.this.cancel();
        }

        /* access modifiers changed from: package-private */
        public final Call get() {
            return Call.this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[SYNTHETIC, Splitter:B:14:0x003b] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0057 A[Catch:{ all -> 0x0034 }] */
        public final void execute() {
            IOException e;
            boolean z = true;
            try {
                Response responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                if (Call.this.canceled) {
                    try {
                        this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (!z) {
                        }
                        Call.this.client.getDispatcher().finished(this);
                    }
                } else {
                    this.responseCallback.onResponse(responseWithInterceptorChain);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
                if (!z) {
                    try {
                        Logger logger = Internal.logger;
                        Level level = Level.INFO;
                        logger.log(level, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e);
                    } catch (Throwable th) {
                        Call.this.client.getDispatcher().finished(this);
                        throw th;
                    }
                } else {
                    this.responseCallback.onFailure(Call.this.engine == null ? Call.this.originalRequest : Call.this.engine.getRequest(), e);
                }
                Call.this.client.getDispatcher().finished(this);
            }
            Call.this.client.getDispatcher().finished(this);
        }
    }

    public String toLoggableString() {
        String str = this.canceled ? "canceled call" : "call";
        HttpUrl resolve = this.originalRequest.httpUrl().resolve("/...");
        return str + " to " + resolve;
    }

    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        public Connection connection() {
            return null;
        }

        ApplicationInterceptorChain(int i, Request request2, boolean z) {
            this.index = i;
            this.request = request2;
            this.forWebSocket = z;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request2, this.forWebSocket);
            }
            ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, request2, this.forWebSocket);
            Interceptor interceptor = Call.this.client.interceptors().get(this.index);
            Response intercept = interceptor.intercept(applicationInterceptorChain);
            if (intercept != null) {
                return intercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public Response getResponse(Request request, boolean z) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            Request.Builder newBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
            request = newBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                Response response = this.engine.getResponse();
                Request followUpRequest = this.engine.followUpRequest();
                if (followUpRequest == null) {
                    if (!z) {
                        this.engine.releaseConnection();
                    }
                    return response;
                }
                i++;
                if (i <= 20) {
                    if (!this.engine.sameConnection(followUpRequest.httpUrl())) {
                        this.engine.releaseConnection();
                    }
                    this.engine = new HttpEngine(this.client, followUpRequest, false, false, z, this.engine.close(), null, null, response);
                } else {
                    throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i)));
                }
            } catch (RequestException e) {
                throw e.getCause();
            } catch (RouteException e2) {
                HttpEngine recover = this.engine.recover(e2);
                if (recover != null) {
                    this.engine = recover;
                } else {
                    throw e2.getLastConnectException();
                }
            } catch (IOException e3) {
                HttpEngine recover2 = this.engine.recover(e3, null);
                if (recover2 != null) {
                    this.engine = recover2;
                } else {
                    throw e3;
                }
            }
        }
        this.engine.releaseConnection();
        throw new IOException("Canceled");
    }
}
