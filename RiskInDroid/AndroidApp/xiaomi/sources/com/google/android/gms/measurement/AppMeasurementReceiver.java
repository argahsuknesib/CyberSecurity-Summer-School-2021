package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzge {
    private zzgb zzadd;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.zzadd == null) {
            this.zzadd = new zzgb(this);
        }
        this.zzadd.onReceive(context, intent);
    }
}
