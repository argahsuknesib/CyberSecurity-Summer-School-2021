package com.mibi.sdk.model;

import android.os.Bundle;

public interface IBaseModel<Result> {

    public interface IResultCallback<Result> {
        void onFailed(int i, String str, Throwable th);

        void onSuccess(Result result);
    }

    void request(Bundle bundle, IResultCallback<Result> iResultCallback);
}
