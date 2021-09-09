package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbd implements zzbp, zzq {
    private final Context mContext;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    final zzav zzfq;
    /* access modifiers changed from: private */
    public final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    private final GoogleApiAvailabilityLight zzgk;
    final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    private final Condition zziz;
    private final zzbf zzja;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zzjb = new HashMap();
    /* access modifiers changed from: private */
    public volatile zzbc zzjc;
    private ConnectionResult zzjd = null;
    int zzje;
    final zzbq zzjf;

    public zzbd(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzbq zzbq) {
        this.mContext = context;
        this.zzga = lock;
        this.zzgk = googleApiAvailabilityLight;
        this.zzil = map;
        this.zzgf = clientSettings;
        this.zzgi = map2;
        this.zzdh = abstractClientBuilder;
        this.zzfq = zzav;
        this.zzjf = zzbq;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzp) obj).zza(this);
        }
        this.zzja = new zzbf(this, looper);
        this.zziz = lock.newCondition();
        this.zzjc = new zzau(this);
    }

    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zziz.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zzjd;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            } else {
                nanos = this.zziz.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zzjd;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final void connect() {
        this.zzjc.connect();
    }

    public final void disconnect() {
        if (this.zzjc.disconnect()) {
            this.zzjb.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append((CharSequence) "mState=").println(this.zzjc);
        for (Api next : this.zzgi.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) next.getName()).println(":");
            this.zzil.get(next.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        t.zzx();
        return this.zzjc.enqueue(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        t.zzx();
        return this.zzjc.execute(t);
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (!this.zzil.containsKey(clientKey)) {
            return null;
        }
        if (this.zzil.get(clientKey).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zzjb.containsKey(clientKey)) {
            return this.zzjb.get(clientKey);
        }
        return null;
    }

    public final boolean isConnected() {
        return this.zzjc instanceof zzag;
    }

    public final boolean isConnecting() {
        return this.zzjc instanceof zzaj;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    public final void onConnected(Bundle bundle) {
        this.zzga.lock();
        try {
            this.zzjc.onConnected(bundle);
        } finally {
            this.zzga.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zzga.lock();
        try {
            this.zzjc.onConnectionSuspended(i);
        } finally {
            this.zzga.unlock();
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zzga.lock();
        try {
            this.zzjc.zza(connectionResult, api, z);
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbe zzbe) {
        this.zzja.sendMessage(this.zzja.obtainMessage(1, zzbe));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(RuntimeException runtimeException) {
        this.zzja.sendMessage(this.zzja.obtainMessage(2, runtimeException));
    }

    /* access modifiers changed from: package-private */
    public final void zzbc() {
        this.zzga.lock();
        try {
            this.zzjc = new zzaj(this, this.zzgf, this.zzgi, this.zzgk, this.zzdh, this.zzga, this.mContext);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbd() {
        this.zzga.lock();
        try {
            this.zzfq.zzaz();
            this.zzjc = new zzag(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(ConnectionResult connectionResult) {
        this.zzga.lock();
        try {
            this.zzjd = connectionResult;
            this.zzjc = new zzau(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
        }
    }

    public final void zzz() {
        if (isConnected()) {
            ((zzag) this.zzjc).zzap();
        }
    }
}
