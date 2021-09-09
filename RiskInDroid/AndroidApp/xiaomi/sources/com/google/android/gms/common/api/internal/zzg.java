package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzg extends zzc<Boolean> {
    private final ListenerHolder.ListenerKey<?> zzea;

    public zzg(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzea = listenerKey;
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
        zzbv remove = zza.zzbn().remove(this.zzea);
        if (remove != null) {
            remove.zzlu.unregisterListener(zza.zzae(), this.zzdu);
            remove.zzlt.clearListener();
            return;
        }
        this.zzdu.trySetResult(Boolean.FALSE);
    }
}
