package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.service.ICommonService;

public class CommonClient extends GmsClient<ICommonService> {
    public CommonClient(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    public ICommonService createServiceInterface(IBinder iBinder) {
        return ICommonService.Stub.asInterface(iBinder);
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    public String getStartServiceAction() {
        return "com.google.android.gms.common.service.START";
    }
}
