package com.xiaomi.mico.api;

public interface IncompleteApiListener {
    void onFailure(ApiError apiError);

    void onSuccess();
}
