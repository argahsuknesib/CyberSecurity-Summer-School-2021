package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zziw implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzii zzape;
    /* access modifiers changed from: private */
    public volatile boolean zzapk;
    private volatile zzff zzapl;

    protected zziw(zzii zzii) {
        this.zzape = zzii;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            this.zzapl = null;
            this.zzape.zzgd().zzc(new zziz(this, (zzey) this.zzapl.getService()));
            this.zzapl = null;
            this.zzapk = false;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfg zzjo = this.zzape.zzacw.zzjo();
        if (zzjo != null) {
            zzjo.zzip().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzapk = false;
            this.zzapl = null;
        }
        this.zzape.zzgd().zzc(new zzjb(this));
    }

    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzape.zzge().zzis().log("Service connection suspended");
        this.zzape.zzgd().zzc(new zzja(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.zzape.zzge().zzim().log("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0062 */
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzapk = false;
                this.zzape.zzge().zzim().log("Service connected with null binder");
                return;
            }
            zzey zzey = null;
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzey = queryLocalInterface instanceof zzey ? (zzey) queryLocalInterface : new zzfa(iBinder);
                }
                this.zzape.zzge().zzit().log("Bound to IMeasurementService interface");
            } else {
                this.zzape.zzge().zzim().zzg("Got binder with a wrong descriptor", interfaceDescriptor);
            }
            if (zzey == null) {
                this.zzapk = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.zzape.getContext(), this.zzape.zzaox);
                } catch (IllegalArgumentException unused) {
                }
            } else {
                this.zzape.zzgd().zzc(new zzix(this, zzey));
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzape.zzge().zzis().log("Service disconnected");
        this.zzape.zzgd().zzc(new zziy(this, componentName));
    }

    public final void zzc(Intent intent) {
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzapk) {
                this.zzape.zzge().zzit().log("Connection attempt already in progress");
                return;
            }
            this.zzape.zzge().zzit().log("Using local app measurement service");
            this.zzapk = true;
            instance.bindService(context, intent, this.zzape.zzaox, 129);
        }
    }

    public final void zzkh() {
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        synchronized (this) {
            if (this.zzapk) {
                this.zzape.zzge().zzit().log("Connection attempt already in progress");
            } else if (this.zzapl != null) {
                this.zzape.zzge().zzit().log("Already awaiting connection attempt");
            } else {
                this.zzapl = new zzff(context, Looper.getMainLooper(), this, this);
                this.zzape.zzge().zzit().log("Connecting to remote service");
                this.zzapk = true;
                this.zzapl.checkAvailabilityAndConnect();
            }
        }
    }
}
