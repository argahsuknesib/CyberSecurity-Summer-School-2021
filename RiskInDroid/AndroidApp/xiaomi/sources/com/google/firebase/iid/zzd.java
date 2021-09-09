package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzd {
    final Intent intent;
    private final BroadcastReceiver.PendingResult zzs;
    private boolean zzt = false;
    private final ScheduledFuture<?> zzu;

    zzd(Intent intent2, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.intent = intent2;
        this.zzs = pendingResult;
        this.zzu = scheduledExecutorService.schedule(new zze(this, intent2), 9500, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void finish() {
        if (!this.zzt) {
            this.zzs.finish();
            this.zzu.cancel(false);
            this.zzt = true;
        }
    }
}
