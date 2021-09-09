package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;

public class WrappedIncompleteApiListener<T> implements ApiRequest.Listener<T> {
    private IncompleteApiListener mDelegate;

    public WrappedIncompleteApiListener(IncompleteApiListener incompleteApiListener) {
        this.mDelegate = incompleteApiListener;
    }

    public void onSuccess(Object obj) {
        IncompleteApiListener incompleteApiListener = this.mDelegate;
        if (incompleteApiListener != null) {
            incompleteApiListener.onSuccess();
        }
    }

    public void onFailure(ApiError apiError) {
        IncompleteApiListener incompleteApiListener = this.mDelegate;
        if (incompleteApiListener != null) {
            incompleteApiListener.onFailure(apiError);
        }
    }
}
