package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private T zzdm;

    public Response() {
    }

    protected Response(T t) {
        this.zzdm = t;
    }

    /* access modifiers changed from: protected */
    public T getResult() {
        return this.zzdm;
    }

    public void setResult(T t) {
        this.zzdm = t;
    }
}
