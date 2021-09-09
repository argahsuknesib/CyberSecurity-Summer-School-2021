package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

public final class CommonApiImpl implements CommonApi {

    static class zza extends BaseCommonServiceCallbacks {
        private final BaseImplementation.ResultHolder<Status> mResultHolder;

        public zza(BaseImplementation.ResultHolder<Status> resultHolder) {
            this.mResultHolder = resultHolder;
        }

        public final void onDefaultAccountCleared(int i) throws RemoteException {
            this.mResultHolder.setResult(new Status(i));
        }
    }

    public final PendingResult<Status> clearDefaultAccount(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzb(this, googleApiClient));
    }
}
