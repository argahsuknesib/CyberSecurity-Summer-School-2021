package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.service.CommonApiImpl;

final class zzb extends zzd {
    zzb(CommonApiImpl commonApiImpl, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((ICommonService) ((CommonClient) anyClient).getService()).clearDefaultAccount(new CommonApiImpl.zza(this));
    }
}
