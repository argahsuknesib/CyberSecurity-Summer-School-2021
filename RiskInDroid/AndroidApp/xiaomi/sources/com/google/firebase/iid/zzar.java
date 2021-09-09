package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzar extends BroadcastReceiver {
    private zzaq zzcy;

    public zzar(zzaq zzaq) {
        this.zzcy = zzaq;
    }

    public final void onReceive(Context context, Intent intent) {
        zzaq zzaq = this.zzcy;
        if (zzaq != null && zzaq.zzaj()) {
            if (FirebaseInstanceId.zzj()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.zzcy, 0);
            this.zzcy.getContext().unregisterReceiver(this);
            this.zzcy = null;
        }
    }

    public final void zzak() {
        if (FirebaseInstanceId.zzj()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zzcy.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
