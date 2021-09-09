package com.mibi.sdk.model;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;

public abstract class Model<Result> implements IBaseModel<Result> {
    private IBaseModel.IResultCallback<Result> mCallback;
    private Context mContext;
    private Session mSession;

    public Model(Session session) {
        if (session != null) {
            this.mSession = session;
            this.mContext = this.mSession.getAppContext();
            return;
        }
        throw new IllegalStateException("session is null");
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Result> iResultCallback) {
        this.mCallback = iResultCallback;
    }

    public IBaseModel.IResultCallback<Result> getCallback() {
        return this.mCallback;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Session getSession() {
        return this.mSession;
    }

    public void release() {
        this.mContext = null;
        this.mSession = null;
    }
}
