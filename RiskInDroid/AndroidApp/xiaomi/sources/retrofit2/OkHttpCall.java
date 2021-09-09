package retrofit2;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbc;
import _m_j.jbg;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private Call rawCall;
    private final ServiceMethod<T> serviceMethod;

    OkHttpCall(ServiceMethod<T> serviceMethod2, Object[] objArr) {
        this.serviceMethod = serviceMethod2;
        this.args = objArr;
    }

    public final OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.serviceMethod, this.args);
    }

    public final synchronized Request request() {
        Call call = this.rawCall;
        if (call != null) {
            return call.request();
        } else if (this.creationFailure == null) {
            try {
                Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall.request();
            } catch (RuntimeException e) {
                this.creationFailure = e;
                throw e;
            } catch (IOException e2) {
                this.creationFailure = e2;
                throw new RuntimeException("Unable to create request.", e2);
            }
        } else if (this.creationFailure instanceof IOException) {
            throw new RuntimeException("Unable to create request.", this.creationFailure);
        } else {
            throw ((RuntimeException) this.creationFailure);
        }
    }

    public final void enqueue(final Callback<T> callback) {
        Call call;
        Throwable th;
        if (callback != null) {
            synchronized (this) {
                if (!this.executed) {
                    this.executed = true;
                    call = this.rawCall;
                    th = this.creationFailure;
                    if (call == null && th == null) {
                        try {
                            Call createRawCall = createRawCall();
                            this.rawCall = createRawCall;
                            call = createRawCall;
                        } catch (Throwable th2) {
                            th = th2;
                            this.creationFailure = th;
                        }
                    }
                } else {
                    throw new IllegalStateException("Already executed.");
                }
            }
            if (th != null) {
                callback.onFailure(this, th);
                return;
            }
            if (this.canceled) {
                call.cancel();
            }
            call.enqueue(new Callback() {
                /* class retrofit2.OkHttpCall.AnonymousClass1 */

                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        callSuccess(OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th) {
                        callFailure(th);
                    }
                }

                public void onFailure(Call call, IOException iOException) {
                    try {
                        callback.onFailure(OkHttpCall.this, iOException);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                private void callFailure(Throwable th) {
                    try {
                        callback.onFailure(OkHttpCall.this, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                private void callSuccess(Response<T> response) {
                    try {
                        callback.onResponse(OkHttpCall.this, response);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        throw new NullPointerException("callback == null");
    }

    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    public final Response<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                if (this.creationFailure == null) {
                    call = this.rawCall;
                    if (call == null) {
                        try {
                            call = createRawCall();
                            this.rawCall = call;
                        } catch (IOException | RuntimeException e) {
                            this.creationFailure = e;
                            throw e;
                        }
                    }
                } else if (this.creationFailure instanceof IOException) {
                    throw ((IOException) this.creationFailure);
                } else {
                    throw ((RuntimeException) this.creationFailure);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    private Call createRawCall() throws IOException {
        Call newCall = this.serviceMethod.callFactory.newCall(this.serviceMethod.toRequest(this.args));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: package-private */
    public final Response<T> parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            return Response.success((Object) null, build);
        } else {
            ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(body);
            try {
                return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), build);
            } catch (RuntimeException e) {
                exceptionCatchingRequestBody.throwIfCaught();
                throw e;
            }
        }
    }

    public final void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public final boolean isCanceled() {
        return this.canceled;
    }

    static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        public final MediaType contentType() {
            return this.contentType;
        }

        public final long contentLength() {
            return this.contentLength;
        }

        public final jaz source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    static final class ExceptionCatchingRequestBody extends ResponseBody {
        private final ResponseBody delegate;
        IOException thrownException;

        ExceptionCatchingRequestBody(ResponseBody responseBody) {
            this.delegate = responseBody;
        }

        public final MediaType contentType() {
            return this.delegate.contentType();
        }

        public final long contentLength() {
            return this.delegate.contentLength();
        }

        public final jaz source() {
            return jbg.O000000o(new jbc(this.delegate.source()) {
                /* class retrofit2.OkHttpCall.ExceptionCatchingRequestBody.AnonymousClass1 */

                public long read(jax jax, long j) throws IOException {
                    try {
                        return super.read(jax, j);
                    } catch (IOException e) {
                        ExceptionCatchingRequestBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        public final void close() {
            this.delegate.close();
        }

        /* access modifiers changed from: package-private */
        public final void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
