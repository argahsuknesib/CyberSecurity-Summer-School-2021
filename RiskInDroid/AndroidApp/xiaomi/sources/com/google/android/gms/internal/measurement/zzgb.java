package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzgb {
    private final zzge zzala;

    public zzgb(zzge zzge) {
        Preconditions.checkNotNull(zzge);
        this.zzala = zzge;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void onReceive(Context context, Intent intent) {
        zzgl zzg = zzgl.zzg(context);
        zzfg zzge = zzg.zzge();
        if (intent == null) {
            zzge.zzip().log("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzge.zzit().zzg("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzge.zzit().log("Starting wakeful intent.");
            this.zzala.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzg.zzgd().zzc(new zzgc(this, zzg, zzge));
            } catch (Exception e) {
                zzge.zzip().zzg("Install Referrer Reporter encountered a problem", e);
            }
            BroadcastReceiver.PendingResult doGoAsync = this.zzala.doGoAsync();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzge.zzit().log("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            zzge.zzir().zzg("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle zza = zzg.zzgb().zza(Uri.parse(stringExtra));
            if (zza == null) {
                zzge.zzit().log("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
            if (longExtra == 0) {
                zzge.zzip().log("Install referrer is missing timestamp");
            }
            zzg.zzgd().zzc(new zzgd(this, zzg, longExtra, zza, context, zzge, doGoAsync));
        }
    }
}
