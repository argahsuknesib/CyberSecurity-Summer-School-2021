package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;

public final class AppMeasurementService extends Service implements zzjg {
    private zzjc<AppMeasurementService> zzade;

    private final zzjc<AppMeasurementService> zzfq() {
        if (this.zzade == null) {
            this.zzade = new zzjc<>(this);
        }
        return this.zzade;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return zzfq().onBind(intent);
    }

    public final void onCreate() {
        super.onCreate();
        zzfq().onCreate();
    }

    public final void onDestroy() {
        zzfq().onDestroy();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        zzfq().onRebind(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzfq().onStartCommand(intent, i, i2);
    }

    public final boolean onUnbind(Intent intent) {
        return zzfq().onUnbind(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzb(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
