package com.mibi.sdk.task;

public abstract class RxBaseSuccessHandler<R> {
    /* access modifiers changed from: protected */
    public abstract void handleSuccess(R r);

    public void call(R r) {
        try {
            handleSuccess(r);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("exception occurs in onNext", e);
        }
    }
}
