package com.google.android.gms.common.api;

import _m_j.o0O0OOO0;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final o0O0OOO0<zzh<?>, ConnectionResult> zzcc;

    public AvailabilityException(o0O0OOO0<zzh<?>, ConnectionResult> o0o0ooo0) {
        this.zzcc = o0o0ooo0;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        zzh<? extends Api.ApiOptions> zzm = googleApi.zzm();
        Preconditions.checkArgument(this.zzcc.get(zzm) != null, "The given API was not part of the availability request.");
        return this.zzcc.get(zzm);
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zzh next : this.zzcc.keySet()) {
            ConnectionResult connectionResult = this.zzcc.get(next);
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String zzq = next.zzq();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(zzq).length() + 2 + String.valueOf(valueOf).length());
            sb.append(zzq);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final o0O0OOO0<zzh<?>, ConnectionResult> zzl() {
        return this.zzcc;
    }
}
