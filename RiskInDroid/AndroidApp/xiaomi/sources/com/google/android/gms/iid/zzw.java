package com.google.android.gms.iid;

import java.util.concurrent.TimeUnit;

final /* synthetic */ class zzw implements Runnable {
    private final zzt zzch;

    zzw(zzt zzt) {
        this.zzch = zzt;
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
        r3 = r0.zzcg.zzk;
        r4 = r0.zzcc;
        r5 = android.os.Message.obtain();
        r5.what = r1.what;
        r5.arg1 = r1.zzck;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zzu());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.zzcm);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = r0.zzcd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a1, code lost:
        if (r1.zzab == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        r1.zzab.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ac, code lost:
        if (r1.zzcj == null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ae, code lost:
        r1.zzcj.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bc, code lost:
        throw new java.lang.IllegalStateException("Both messengers are null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bd, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        r0.zzd(2, r1.getMessage());
     */
    public final void run() {
        zzt zzt = this.zzch;
        while (true) {
            synchronized (zzt) {
                if (zzt.state == 2) {
                    if (zzt.zzce.isEmpty()) {
                        zzt.zzs();
                        return;
                    }
                    zzz poll = zzt.zzce.poll();
                    zzt.zzcf.put(poll.zzck, poll);
                    zzt.zzcg.zzbz.schedule(new zzx(zzt, poll), 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
        }
        while (true) {
        }
    }
}
