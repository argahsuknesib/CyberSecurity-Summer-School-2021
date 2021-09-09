package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class StatefulRunnable<T> implements Runnable {
    protected final AtomicInteger mState = new AtomicInteger(0);

    /* access modifiers changed from: protected */
    public void disposeResult(T t) {
    }

    /* access modifiers changed from: protected */
    public abstract T getResult() throws Exception;

    /* access modifiers changed from: protected */
    public void onCancellation() {
    }

    /* access modifiers changed from: protected */
    public void onFailure(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void onSuccess(T t) {
    }

    public final void run() {
        if (this.mState.compareAndSet(0, 1)) {
            try {
                Object result = getResult();
                this.mState.set(3);
                try {
                    onSuccess(result);
                } finally {
                    disposeResult(result);
                }
            } catch (Exception e) {
                this.mState.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mState.compareAndSet(0, 2)) {
            onCancellation();
        }
    }
}
