package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

final class zza extends AsyncTask<Void, Void, Integer> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ ProviderInstaller.ProviderInstallListener zzacy;

    zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.val$context = context;
        this.zzacy = providerInstallListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Integer doInBackground(Void... voidArr) {
        int connectionStatusCode;
        try {
            ProviderInstaller.installIfNeeded(this.val$context);
            connectionStatusCode = 0;
        } catch (GooglePlayServicesRepairableException e) {
            connectionStatusCode = e.getConnectionStatusCode();
        } catch (GooglePlayServicesNotAvailableException e2) {
            connectionStatusCode = e2.errorCode;
        }
        return Integer.valueOf(connectionStatusCode);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzacy.onProviderInstalled();
            return;
        }
        this.zzacy.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzacw.getErrorResolutionIntent(this.val$context, num.intValue(), "pi"));
    }
}
