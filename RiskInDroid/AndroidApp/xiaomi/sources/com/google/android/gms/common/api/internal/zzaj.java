package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzaj implements zzbc {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    /* access modifiers changed from: private */
    public final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    /* access modifiers changed from: private */
    public final GoogleApiAvailabilityLight zzgk;
    private ConnectionResult zzgt;
    /* access modifiers changed from: private */
    public final zzbd zzhf;
    private int zzhi;
    private int zzhj = 0;
    private int zzhk;
    private final Bundle zzhl = new Bundle();
    private final Set<Api.AnyClientKey> zzhm = new HashSet();
    /* access modifiers changed from: private */
    public SignInClient zzhn;
    private boolean zzho;
    /* access modifiers changed from: private */
    public boolean zzhp;
    private boolean zzhq;
    /* access modifiers changed from: private */
    public IAccountAccessor zzhr;
    private boolean zzhs;
    private boolean zzht;
    private ArrayList<Future<?>> zzhu = new ArrayList<>();

    public zzaj(zzbd zzbd, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zzhf = zzbd;
        this.zzgf = clientSettings;
        this.zzgi = map;
        this.zzgk = googleApiAvailabilityLight;
        this.zzdh = abstractClientBuilder;
        this.zzga = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public final void zza(SignInResponse signInResponse) {
        if (zze(0)) {
            ConnectionResult connectionResult = signInResponse.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
                ConnectionResult connectionResult2 = resolveAccountResponse.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    zze(connectionResult2);
                    return;
                }
                this.zzhq = true;
                this.zzhr = resolveAccountResponse.getAccountAccessor();
                this.zzhs = resolveAccountResponse.getSaveDefaultAccount();
                this.zzht = resolveAccountResponse.isFromCrossClientAuth();
                zzas();
            } else if (zzd(connectionResult)) {
                zzau();
                zzas();
            } else {
                zze(connectionResult);
            }
        }
    }

    private final void zza(boolean z) {
        SignInClient signInClient = this.zzhn;
        if (signInClient != null) {
            if (signInClient.isConnected() && z) {
                this.zzhn.clearAccountFromSessionStore();
            }
            this.zzhn.disconnect();
            this.zzhr = null;
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzar() {
        ConnectionResult connectionResult;
        this.zzhk--;
        int i = this.zzhk;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.zzhf.zzfq.zzbb());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, null);
        } else {
            connectionResult = this.zzgt;
            if (connectionResult == null) {
                return true;
            }
            this.zzhf.zzje = this.zzhi;
        }
        zze(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    public final void zzas() {
        if (this.zzhk == 0) {
            if (!this.zzhp || this.zzhq) {
                ArrayList arrayList = new ArrayList();
                this.zzhj = 1;
                this.zzhk = this.zzhf.zzil.size();
                for (Api.AnyClientKey next : this.zzhf.zzil.keySet()) {
                    if (!this.zzhf.zzjb.containsKey(next)) {
                        arrayList.add(this.zzhf.zzil.get(next));
                    } else if (zzar()) {
                        zzat();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zzhu.add(zzbg.zzbe().submit(new zzap(this, arrayList)));
                }
            }
        }
    }

    private final void zzat() {
        this.zzhf.zzbd();
        zzbg.zzbe().execute(new zzak(this));
        SignInClient signInClient = this.zzhn;
        if (signInClient != null) {
            if (this.zzhs) {
                signInClient.saveDefaultAccount(this.zzhr, this.zzht);
            }
            zza(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zzhf.zzjb.keySet()) {
            this.zzhf.zzil.get(anyClientKey).disconnect();
        }
        this.zzhf.zzjf.zzb(this.zzhl.isEmpty() ? null : this.zzhl);
    }

    /* access modifiers changed from: private */
    public final void zzau() {
        this.zzhp = false;
        this.zzhf.zzfq.zzim = Collections.emptySet();
        for (Api.AnyClientKey next : this.zzhm) {
            if (!this.zzhf.zzjb.containsKey(next)) {
                this.zzhf.zzjb.put(next, new ConnectionResult(17, null));
            }
        }
    }

    private final void zzav() {
        ArrayList arrayList = this.zzhu;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zzhu.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zzaw() {
        ClientSettings clientSettings = this.zzgf;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api next : optionalApiSettings.keySet()) {
            if (!this.zzhf.zzjb.containsKey(next.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(next).mScopes);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if ((r5.hasResolution() || r4.zzgk.getErrorResolutionIntent(r5.getErrorCode()) != null) != false) goto L_0x0024;
     */
    public final void zzb(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int priority = api.zzj().getPriority();
        boolean z2 = false;
        if (z) {
        }
        if (this.zzgt == null || priority < this.zzhi) {
            z2 = true;
        }
        if (z2) {
            this.zzgt = connectionResult;
            this.zzhi = priority;
        }
        this.zzhf.zzjb.put(api.getClientKey(), connectionResult);
    }

    /* access modifiers changed from: private */
    public final boolean zzd(ConnectionResult connectionResult) {
        return this.zzho && !connectionResult.hasResolution();
    }

    /* access modifiers changed from: private */
    public final void zze(ConnectionResult connectionResult) {
        zzav();
        zza(!connectionResult.hasResolution());
        this.zzhf.zzf(connectionResult);
        this.zzhf.zzjf.zzc(connectionResult);
    }

    /* access modifiers changed from: private */
    public final boolean zze(int i) {
        if (this.zzhj == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzhf.zzfq.zzbb());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i2 = this.zzhk;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String zzf = zzf(this.zzhj);
        String zzf2 = zzf(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(zzf).length() + 70 + String.valueOf(zzf2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(zzf);
        sb3.append(" but received callback for step ");
        sb3.append(zzf2);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        zze(new ConnectionResult(8, null));
        return false;
    }

    private static String zzf(int i) {
        return i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    public final void begin() {
        this.zzhf.zzjb.clear();
        this.zzhp = false;
        this.zzgt = null;
        this.zzhj = 0;
        this.zzho = true;
        this.zzhq = false;
        this.zzhs = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zzgi.keySet()) {
            Api.Client client = this.zzhf.zzil.get(next.getClientKey());
            z |= next.zzj().getPriority() == 1;
            boolean booleanValue = this.zzgi.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zzhp = true;
                if (booleanValue) {
                    this.zzhm.add(next.getClientKey());
                } else {
                    this.zzho = false;
                }
            }
            hashMap.put(client, new zzal(this, next, booleanValue));
        }
        if (z) {
            this.zzhp = false;
        }
        if (this.zzhp) {
            this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zzhf.zzfq)));
            zzas zzas = new zzas(this, null);
            Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder = this.zzdh;
            Context context = this.mContext;
            Looper looper = this.zzhf.zzfq.getLooper();
            ClientSettings clientSettings = this.zzgf;
            this.zzhn = (SignInClient) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), zzas, zzas);
        }
        this.zzhk = this.zzhf.zzil.size();
        this.zzhu.add(zzbg.zzbe().submit(new zzam(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zzav();
        zza(true);
        this.zzhf.zzf(null);
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.zzhf.zzfq.zzgo.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void onConnected(Bundle bundle) {
        if (zze(1)) {
            if (bundle != null) {
                this.zzhl.putAll(bundle);
            }
            if (zzar()) {
                zzat();
            }
        }
    }

    public final void onConnectionSuspended(int i) {
        zze(new ConnectionResult(8, null));
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zze(1)) {
            zzb(connectionResult, api, z);
            if (zzar()) {
                zzat();
            }
        }
    }
}
