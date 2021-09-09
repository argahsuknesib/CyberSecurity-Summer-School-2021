package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzgd implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzgl zzalb;
    private final /* synthetic */ zzfg zzalc;
    private final /* synthetic */ long zzald;
    private final /* synthetic */ Bundle zzale;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzqu;

    zzgd(zzgb zzgb, zzgl zzgl, long j, Bundle bundle, Context context, zzfg zzfg, BroadcastReceiver.PendingResult pendingResult) {
        this.zzalb = zzgl;
        this.zzald = j;
        this.zzale = bundle;
        this.val$context = context;
        this.zzalc = zzfg;
        this.zzqu = pendingResult;
    }

    public final void run() {
        long j = this.zzalb.zzgf().zzajz.get();
        long j2 = this.zzald;
        if (j > 0 && (j2 >= j || j2 <= 0)) {
            j2 = j - 1;
        }
        if (j2 > 0) {
            this.zzale.putLong("click_timestamp", j2);
        }
        this.zzale.putString("_cis", "referrer broadcast");
        AppMeasurement.getInstance(this.val$context).logEventInternal("auto", "_cmp", this.zzale);
        this.zzalc.zzit().log("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.zzqu;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
