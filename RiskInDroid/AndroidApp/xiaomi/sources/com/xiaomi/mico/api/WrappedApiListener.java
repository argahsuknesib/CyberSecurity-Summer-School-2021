package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;

public class WrappedApiListener<T> implements ApiRequest.Listener<T> {
    private ApiRequest.Listener<T> mDelegate;

    protected WrappedApiListener(ApiRequest.Listener<T> listener) {
        this.mDelegate = listener;
    }

    public void onSuccess(Object obj) {
        ApiRequest.Listener<T> listener = this.mDelegate;
        if (listener != null) {
            listener.onSuccess(obj);
        }
    }

    public void onFailure(ApiError apiError) {
        ApiRequest.Listener<T> listener = this.mDelegate;
        if (listener != null) {
            listener.onFailure(apiError);
        }
    }
}
