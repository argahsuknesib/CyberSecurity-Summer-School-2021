package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zze extends zzc<Void> {
    private final RegisterListenerMethod<Api.AnyClient, ?> zzdw;
    private final UnregisterListenerMethod<Api.AnyClient, ?> zzdx;

    public zze(zzbv zzbv, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zzdw = zzbv.zzlt;
        this.zzdx = zzbv.zzlu;
    }

    public final /* bridge */ /* synthetic */ void zza(Status status) {
        super.zza(status);
    }

    public final /* bridge */ /* synthetic */ void zza(zzaa zzaa, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void zza(RuntimeException runtimeException) {
        super.zza(runtimeException);
    }

    public final void zzb(GoogleApiManager.zza<?> zza) throws RemoteException {
        this.zzdw.registerListener(zza.zzae(), this.zzdu);
        if (this.zzdw.getListenerKey() != null) {
            zza.zzbn().put(this.zzdw.getListenerKey(), new zzbv(this.zzdw, this.zzdx));
        }
    }
}
