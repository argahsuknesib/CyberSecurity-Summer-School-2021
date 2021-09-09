package com.google.firebase.iid;

import java.util.concurrent.TimeUnit;

final /* synthetic */ class zzx implements Runnable {
    private final zzu zzbo;

    zzx(zzu zzu) {
        this.zzbo = zzu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        android.util.Log.d("MessengerIpcClient", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        r3 = r0.zzbn.zzz;
        r4 = r0.zzbj;
        r5 = android.os.Message.obtain();
        r5.what = r1.what;
        r5.arg1 = r1.zzbr;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zzw());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.zzbt);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzbk.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        r0.zza(2, r1.getMessage());
     */
    public final void run() {
        zzu zzu = this.zzbo;
        while (true) {
            synchronized (zzu) {
                if (zzu.state == 2) {
                    if (zzu.zzbl.isEmpty()) {
                        zzu.zzu();
                        return;
                    }
                    zzab poll = zzu.zzbl.poll();
                    zzu.zzbm.put(poll.zzbr, poll);
                    zzu.zzbn.zzbg.schedule(new zzy(zzu, poll), 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
        }
        while (true) {
        }
    }
}
