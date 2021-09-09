package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T> implements Response.ErrorListener, Response.Listener<T>, Future<T> {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }

    public synchronized boolean cancel(boolean z) {
        if (this.mRequest == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.mRequest.cancel();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T doGet(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        } else if (this.mResultReceived) {
            return this.mResult;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.mException != null) {
                throw new ExecutionException(this.mException);
            } else if (this.mResultReceived) {
                return this.mResult;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public boolean isCancelled() {
        Request<?> request = this.mRequest;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    public synchronized boolean isDone() {
        return this.mResultReceived || this.mException != null || isCancelled();
    }

    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }
}
