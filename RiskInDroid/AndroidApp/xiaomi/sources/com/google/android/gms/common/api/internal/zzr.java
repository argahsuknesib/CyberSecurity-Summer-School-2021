package com.google.android.gms.common.api.internal;

import _m_j.o0O0OOO0;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzr implements zzbp {
    private final Context mContext;
    private final Looper zzcn;
    private final zzav zzfq;
    /* access modifiers changed from: private */
    public final zzbd zzfr;
    /* access modifiers changed from: private */
    public final zzbd zzfs;
    private final Map<Api.AnyClientKey<?>, zzbd> zzft;
    private final Set<SignInConnectionListener> zzfu = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zzfv;
    private Bundle zzfw;
    /* access modifiers changed from: private */
    public ConnectionResult zzfx = null;
    /* access modifiers changed from: private */
    public ConnectionResult zzfy = null;
    /* access modifiers changed from: private */
    public boolean zzfz = false;
    /* access modifiers changed from: private */
    public final Lock zzga;
    private int zzgb = 0;

    private zzr(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zzp> arrayList, ArrayList<zzp> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zzfq = zzav;
        this.zzga = lock;
        this.zzcn = looper;
        this.zzfv = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zzbd zzbd = r3;
        zzbd zzbd2 = new zzbd(context2, this.zzfq, lock2, looper2, googleApiAvailabilityLight2, map2, null, map4, null, arrayList2, new zzt(this, null));
        this.zzfr = zzbd;
        this.zzfs = new zzbd(context2, this.zzfq, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zzu(this, null));
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            o0o0ooo0.put(put, this.zzfr);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            o0o0ooo0.put(put2, this.zzfs);
        }
        this.zzft = Collections.unmodifiableMap(o0o0ooo0);
    }

    public static zzr zza(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        o0O0OOO0 o0o0ooo02 = new o0O0OOO0();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                o0o0ooo0.put((Api.AnyClientKey) next.getKey(), client2);
            } else {
                o0o0ooo02.put((Api.AnyClientKey) next.getKey(), client2);
            }
        }
        Preconditions.checkState(!o0o0ooo0.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        o0O0OOO0 o0o0ooo03 = new o0O0OOO0();
        o0O0OOO0 o0o0ooo04 = new o0O0OOO0();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = next2.getClientKey();
            if (o0o0ooo0.containsKey(clientKey)) {
                o0o0ooo03.put(next2, map3.get(next2));
            } else if (o0o0ooo02.containsKey(clientKey)) {
                o0o0ooo04.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zzp zzp = (zzp) obj;
            if (o0o0ooo03.containsKey(zzp.mApi)) {
                arrayList2.add(zzp);
            } else if (o0o0ooo04.containsKey(zzp.mApi)) {
                arrayList3.add(zzp);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzr(context, zzav, lock, looper, googleApiAvailabilityLight, o0o0ooo0, o0o0ooo02, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, o0o0ooo03, o0o0ooo04);
    }

    /* access modifiers changed from: private */
    public final void zza(int i, boolean z) {
        this.zzfq.zzb(i, z);
        this.zzfy = null;
        this.zzfx = null;
    }

    /* access modifiers changed from: private */
    public final void zza(Bundle bundle) {
        Bundle bundle2 = this.zzfw;
        if (bundle2 == null) {
            this.zzfw = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private final void zza(ConnectionResult connectionResult) {
        int i = this.zzgb;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zzgb = 0;
            }
            this.zzfq.zzc(connectionResult);
        }
        zzab();
        this.zzgb = 0;
    }

    private final boolean zza(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zzft.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzft.get(clientKey).equals(this.zzfs);
    }

    /* access modifiers changed from: private */
    public final void zzaa() {
        if (zzb(this.zzfx)) {
            if (zzb(this.zzfy) || zzac()) {
                int i = this.zzgb;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zzgb = 0;
                        return;
                    }
                    this.zzfq.zzb(this.zzfw);
                }
                zzab();
                this.zzgb = 0;
                return;
            }
            ConnectionResult connectionResult = this.zzfy;
            if (connectionResult == null) {
                return;
            }
            if (this.zzgb == 1) {
                zzab();
                return;
            }
            zza(connectionResult);
            this.zzfr.disconnect();
        } else if (this.zzfx == null || !zzb(this.zzfy)) {
            ConnectionResult connectionResult2 = this.zzfx;
            if (connectionResult2 != null && this.zzfy != null) {
                if (this.zzfs.zzje < this.zzfr.zzje) {
                    connectionResult2 = this.zzfy;
                }
                zza(connectionResult2);
            }
        } else {
            this.zzfs.disconnect();
            zza(this.zzfx);
        }
    }

    private final void zzab() {
        for (SignInConnectionListener onComplete : this.zzfu) {
            onComplete.onComplete();
        }
        this.zzfu.clear();
    }

    private final boolean zzac() {
        ConnectionResult connectionResult = this.zzfy;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final PendingIntent zzad() {
        if (this.zzfv == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfq), this.zzfv.getSignInIntent(), 134217728);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void connect() {
        this.zzgb = 2;
        this.zzfz = false;
        this.zzfy = null;
        this.zzfx = null;
        this.zzfr.connect();
        this.zzfs.connect();
    }

    public final void disconnect() {
        this.zzfy = null;
        this.zzfx = null;
        this.zzgb = 0;
        this.zzfr.disconnect();
        this.zzfs.disconnect();
        zzab();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append((CharSequence) "authClient").println(":");
        this.zzfs.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append((CharSequence) "anonClient").println(":");
        this.zzfr.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final <A extends com.google.android.gms.common.api.Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T r5) {
        /*
            r4 = this;
            boolean r0 = r4.zza(r5)
            if (r0 == 0) goto L_0x0022
            boolean r0 = r4.zzac()
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            r1 = 4
            r2 = 0
            android.app.PendingIntent r3 = r4.zzad()
            r0.<init>(r1, r2, r3)
            r5.setFailedResult(r0)
            return r5
        L_0x001b:
            com.google.android.gms.common.api.internal.zzbd r0 = r4.zzfs
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r5 = r0.enqueue(r5)
            return r5
        L_0x0022:
            com.google.android.gms.common.api.internal.zzbd r0 = r4.zzfr
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r5 = r0.enqueue(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzr.enqueue(com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl):com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final <A extends com.google.android.gms.common.api.Api.AnyClient, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T r5) {
        /*
            r4 = this;
            boolean r0 = r4.zza(r5)
            if (r0 == 0) goto L_0x0022
            boolean r0 = r4.zzac()
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            r1 = 4
            r2 = 0
            android.app.PendingIntent r3 = r4.zzad()
            r0.<init>(r1, r2, r3)
            r5.setFailedResult(r0)
            return r5
        L_0x001b:
            com.google.android.gms.common.api.internal.zzbd r0 = r4.zzfs
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r5 = r0.execute(r5)
            return r5
        L_0x0022:
            com.google.android.gms.common.api.internal.zzbd r0 = r4.zzfr
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r5 = r0.execute(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzr.execute(com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl):com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl");
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return this.zzft.get(api.getClientKey()).equals(this.zzfs) ? zzac() ? new ConnectionResult(4, zzad()) : this.zzfs.getConnectionResult(api) : this.zzfr.getConnectionResult(api);
    }

    public final boolean isConnected() {
        this.zzga.lock();
        try {
            boolean z = true;
            if (!this.zzfr.isConnected() || (!this.zzfs.isConnected() && !zzac() && this.zzgb != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzga.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzga.lock();
        try {
            return this.zzgb == 2;
        } finally {
            this.zzga.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zzga.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zzfs.isConnected()) {
                this.zzfu.add(signInConnectionListener);
                if (this.zzgb == 0) {
                    this.zzgb = 1;
                }
                this.zzfy = null;
                this.zzfs.connect();
                return true;
            }
            this.zzga.unlock();
            return false;
        } finally {
            this.zzga.unlock();
        }
    }

    public final void maybeSignOut() {
        this.zzga.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfs.disconnect();
            this.zzfy = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzcn).post(new zzs(this));
            } else {
                zzab();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public final void zzz() {
        this.zzfr.zzz();
        this.zzfs.zzz();
    }
}
