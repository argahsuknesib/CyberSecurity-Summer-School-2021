package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IInterface;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;

public abstract class BaseSimpleClient<T extends IInterface> implements Api.SimpleClient<T> {
    private final Context mContext;
    private final Object mLock = new Object();
    private int mState = 1;
    private T zzrj = null;

    public BaseSimpleClient(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    public T getService() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.mState == 5) {
                throw new DeadObjectException();
            } else if (this.mState == 4) {
                Preconditions.checkState(this.zzrj != null, "Client is connected but service is null");
                t = this.zzrj;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }

    public void setState(int i, T t) {
        synchronized (this.mLock) {
            this.mState = i;
            this.zzrj = t;
        }
    }
}
