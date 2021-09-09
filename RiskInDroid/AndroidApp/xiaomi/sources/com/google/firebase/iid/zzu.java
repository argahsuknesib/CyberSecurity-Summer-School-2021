package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class zzu implements ServiceConnection {
    int state;
    final Messenger zzbj;
    zzz zzbk;
    final Queue<zzab<?>> zzbl;
    final SparseArray<zzab<?>> zzbm;
    final /* synthetic */ zzs zzbn;

    private zzu(zzs zzs) {
        this.zzbn = zzs;
        this.state = 0;
        this.zzbj = new Messenger(new Handler(Looper.getMainLooper(), new zzv(this)));
        this.zzbl = new ArrayDeque();
        this.zzbm = new SparseArray<>();
    }

    private final void zzt() {
        this.zzbn.zzbg.execute(new zzx(this));
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zza(0, "Null service connection");
            return;
        }
        try {
            this.zzbk = new zzz(iBinder);
            this.state = 2;
            zzt();
        } catch (RemoteException e) {
            zza(0, e.getMessage());
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zza(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzab zzab = this.zzbm.get(i);
        if (zzab != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.zzbm.remove(i);
            zzab.zza(new zzac(3, "Timed out waiting for response"));
            zzu();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.state;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.state = 4;
            ConnectionTracker.getInstance().unbindService(this.zzbn.zzz, this);
            zzac zzac = new zzac(i, str);
            for (zzab<?> zza : this.zzbl) {
                zza.zza(zzac);
            }
            this.zzbl.clear();
            for (int i3 = 0; i3 < this.zzbm.size(); i3++) {
                this.zzbm.valueAt(i3).zza(zzac);
            }
            this.zzbm.clear();
        } else if (i2 == 3) {
            this.state = 4;
        } else if (i2 != 4) {
            int i4 = this.state;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r1.zza(new com.google.firebase.iid.zzac(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1.zzb(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        return true;
     */
    public final boolean zza(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            zzab zzab = this.zzbm.get(i);
            if (zzab == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.zzbm.remove(i);
            zzu();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return true;
     */
    public final synchronized boolean zzb(zzab zzab) {
        int i = this.state;
        if (i == 0) {
            this.zzbl.add(zzab);
            Preconditions.checkState(this.state == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.state = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!ConnectionTracker.getInstance().bindService(this.zzbn.zzz, intent, this, 1)) {
                zza(0, "Unable to bind to service");
            } else {
                this.zzbn.zzbg.schedule(new zzw(this), 30, TimeUnit.SECONDS);
            }
        } else if (i == 1) {
            this.zzbl.add(zzab);
            return true;
        } else if (i == 2) {
            this.zzbl.add(zzab);
            zzt();
            return true;
        } else if (i != 3) {
            if (i != 4) {
                int i2 = this.state;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzu() {
        if (this.state == 2 && this.zzbl.isEmpty() && this.zzbm.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzbn.zzz, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzv() {
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
    }
}
