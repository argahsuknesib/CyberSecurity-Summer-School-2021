package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

class zzfp extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzaaw = "com.google.android.gms.internal.measurement.zzfp";
    private boolean zzaax;
    private boolean zzaay;
    /* access modifiers changed from: private */
    public final zzjr zzajp;

    zzfp(zzjr zzjr) {
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
    }

    public void onReceive(Context context, Intent intent) {
        this.zzajp.zzkq();
        String action = intent.getAction();
        this.zzajp.zzge().zzit().zzg("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzex = this.zzajp.zzkn().zzex();
            if (this.zzaay != zzex) {
                this.zzaay = zzex;
                this.zzajp.zzgd().zzc(new zzfq(this, zzex));
                return;
            }
            return;
        }
        this.zzajp.zzge().zzip().zzg("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void unregister() {
        this.zzajp.zzkq();
        this.zzajp.zzab();
        this.zzajp.zzab();
        if (this.zzaax) {
            this.zzajp.zzge().zzit().log("Unregistering connectivity change receiver");
            this.zzaax = false;
            this.zzaay = false;
            try {
                this.zzajp.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzajp.zzge().zzim().zzg("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final void zzeu() {
        this.zzajp.zzkq();
        this.zzajp.zzab();
        if (!this.zzaax) {
            this.zzajp.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzaay = this.zzajp.zzkn().zzex();
            this.zzajp.zzge().zzit().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzaay));
            this.zzaax = true;
        }
    }
}
