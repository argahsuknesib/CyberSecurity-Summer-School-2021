package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Remote;

class RemoteApiListener<T> implements ApiRequest.Listener<Remote.Response> {
    private final Class<T> mClassOfT;
    private final ApiRequest.Listener<T> mDelegate;

    RemoteApiListener(ApiRequest.Listener<T> listener, Class<T> cls) {
        this.mDelegate = listener;
        this.mClassOfT = cls;
    }

    public void onSuccess(Remote.Response response) {
        if (this.mDelegate == null) {
            return;
        }
        if (response.code == 0) {
            this.mDelegate.onSuccess(response.parseInfo(this.mClassOfT));
        } else {
            this.mDelegate.onFailure(ApiError.generateError(response.code, "Unexpected ubus response."));
        }
    }

    public void onFailure(ApiError apiError) {
        ApiRequest.Listener<T> listener = this.mDelegate;
        if (listener != null) {
            listener.onFailure(apiError);
        }
    }
}
