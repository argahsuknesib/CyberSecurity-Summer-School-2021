package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

final class zzaq implements Runnable {
    private final zzae zzal;
    private final FirebaseInstanceId zzaw;
    private final long zzcw;
    private final PowerManager.WakeLock zzcx = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");

    @VisibleForTesting
    zzaq(FirebaseInstanceId firebaseInstanceId, zzae zzae, long j) {
        this.zzaw = firebaseInstanceId;
        this.zzal = zzae;
        this.zzcw = j;
        this.zzcx.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean zzah() {
        zzap zzg = this.zzaw.zzg();
        if (zzg != null && !zzg.zzj(this.zzal.zzy())) {
            return true;
        }
        try {
            String zzh = this.zzaw.zzh();
            if (zzh == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (zzg == null || (zzg != null && !zzh.equals(zzg.zzcu))) {
                Context context = getContext();
                Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                intent2.setClass(context, FirebaseInstanceIdReceiver.class);
                intent2.putExtra("wrapped_intent", intent);
                context.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException | SecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (zzk(r1) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return false;
     */
    @VisibleForTesting
    private final boolean zzai() {
        String zzaf;
        while (true) {
            synchronized (this.zzaw) {
                zzaf = FirebaseInstanceId.zzi().zzaf();
                if (zzaf == null) {
                    Log.d("FirebaseInstanceId", "topic sync succeeded");
                    return true;
                }
            }
            FirebaseInstanceId.zzi().zzf(zzaf);
        }
        while (true) {
        }
    }

    private final boolean zzk(String str) {
        String str2;
        String[] split = str.split("!");
        if (split.length == 2) {
            String str3 = split[0];
            String str4 = split[1];
            char c = 65535;
            try {
                int hashCode = str3.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str3.equals("U")) {
                            c = 1;
                        }
                    }
                } else if (str3.equals("S")) {
                    c = 0;
                }
                if (c == 0) {
                    this.zzaw.zzb(str4);
                    if (FirebaseInstanceId.zzj()) {
                        str2 = "subscribe operation succeeded";
                    }
                } else if (c == 1) {
                    this.zzaw.zzc(str4);
                    if (FirebaseInstanceId.zzj()) {
                        str2 = "unsubscribe operation succeeded";
                    }
                }
                Log.d("FirebaseInstanceId", str2);
            } catch (IOException e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Topic sync failed: ".concat(valueOf) : new String("Topic sync failed: "));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzaw.zze().getApplicationContext();
    }

    public final void run() {
        FirebaseInstanceId firebaseInstanceId;
        this.zzcx.acquire();
        try {
            boolean z = true;
            this.zzaw.zza(true);
            if (this.zzal.zzx() == 0) {
                z = false;
            }
            if (!z) {
                firebaseInstanceId = this.zzaw;
            } else {
                if (!zzaj()) {
                    new zzar(this).zzak();
                } else if (!zzah() || !zzai()) {
                    this.zzaw.zza(this.zzcw);
                } else {
                    firebaseInstanceId = this.zzaw;
                }
            }
            firebaseInstanceId.zza(false);
        } finally {
            this.zzcx.release();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
