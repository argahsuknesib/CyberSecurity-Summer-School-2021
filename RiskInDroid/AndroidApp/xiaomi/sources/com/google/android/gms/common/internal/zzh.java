package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

final class zzh extends GmsClientSupervisor implements Handler.Callback {
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final Context zzau;
    /* access modifiers changed from: private */
    public final HashMap<GmsClientSupervisor.ConnectionStatusConfig, zzi> zztr = new HashMap<>();
    /* access modifiers changed from: private */
    public final ConnectionTracker zzts;
    private final long zztt;
    /* access modifiers changed from: private */
    public final long zztu;

    zzh(Context context) {
        this.zzau = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzts = ConnectionTracker.getInstance();
        this.zztt = 5000;
        this.zztu = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean bindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            zzi zzi = this.zztr.get(connectionStatusConfig);
            if (zzi == null) {
                zzi = new zzi(this, connectionStatusConfig);
                zzi.zza(serviceConnection, str);
                zzi.zzj(str);
                this.zztr.put(connectionStatusConfig, zzi);
            } else {
                this.mHandler.removeMessages(0, connectionStatusConfig);
                if (!zzi.zza(serviceConnection)) {
                    zzi.zza(serviceConnection, str);
                    int state = zzi.getState();
                    if (state == 1) {
                        serviceConnection.onServiceConnected(zzi.getComponentName(), zzi.getBinder());
                    } else if (state == 2) {
                        zzi.zzj(str);
                    }
                } else {
                    String valueOf = String.valueOf(connectionStatusConfig);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zzi.isBound();
        }
        return isBound;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zztr) {
                GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                zzi zzi = this.zztr.get(connectionStatusConfig);
                if (zzi != null && zzi.zzcv()) {
                    if (zzi.isBound()) {
                        zzi.zzk("GmsClientSupervisor");
                    }
                    this.zztr.remove(connectionStatusConfig);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zztr) {
                GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig2 = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                zzi zzi2 = this.zztr.get(connectionStatusConfig2);
                if (zzi2 != null && zzi2.getState() == 3) {
                    String valueOf = String.valueOf(connectionStatusConfig2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zzi2.getComponentName();
                    if (componentName == null) {
                        componentName = connectionStatusConfig2.getComponentName();
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(connectionStatusConfig2.getPackage(), "unknown");
                    }
                    zzi2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }

    @VisibleForTesting
    public final void resetForTesting() {
        synchronized (this.zztr) {
            for (zzi next : this.zztr.values()) {
                this.mHandler.removeMessages(0, next.zztx);
                if (next.isBound()) {
                    next.zzk("GmsClientSupervisor");
                }
            }
            this.zztr.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void unbindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            zzi zzi = this.zztr.get(connectionStatusConfig);
            if (zzi == null) {
                String valueOf = String.valueOf(connectionStatusConfig);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzi.zza(serviceConnection)) {
                zzi.zzb(serviceConnection, str);
                if (zzi.zzcv()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, connectionStatusConfig), this.zztt);
                }
            } else {
                String valueOf2 = String.valueOf(connectionStatusConfig);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
