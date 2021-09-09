package com.google.android.gms.common.api.internal;

import _m_j.o0O0OOO0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zzj {
    private final o0O0OOO0<zzh<?>, ConnectionResult> zzcc = new o0O0OOO0<>();
    private final o0O0OOO0<zzh<?>, String> zzei = new o0O0OOO0<>();
    private final TaskCompletionSource<Map<zzh<?>, String>> zzej = new TaskCompletionSource<>();
    private int zzek;
    private boolean zzel = false;

    public zzj(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi zzm : iterable) {
            this.zzcc.put(zzm.zzm(), null);
        }
        this.zzek = this.zzcc.keySet().size();
    }

    public final Task<Map<zzh<?>, String>> getTask() {
        return this.zzej.getTask();
    }

    public final void zza(zzh<?> zzh, ConnectionResult connectionResult, String str) {
        this.zzcc.put(zzh, connectionResult);
        this.zzei.put(zzh, str);
        this.zzek--;
        if (!connectionResult.isSuccess()) {
            this.zzel = true;
        }
        if (this.zzek != 0) {
            return;
        }
        if (this.zzel) {
            this.zzej.setException(new AvailabilityException(this.zzcc));
            return;
        }
        this.zzej.setResult(this.zzei);
    }

    public final Set<zzh<?>> zzs() {
        return this.zzcc.keySet();
    }
}
