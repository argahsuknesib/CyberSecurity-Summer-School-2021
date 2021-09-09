package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.BaseSignInCallbacks;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.Set;

public final class zzby extends BaseSignInCallbacks implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzlv = SignIn.CLIENT_BUILDER;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzby;
    private ClientSettings zzgf;
    private SignInClient zzhn;
    /* access modifiers changed from: private */
    public zzcb zzlw;

    public zzby(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, zzlv);
    }

    public zzby(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zzgf = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zzby = abstractClientBuilder;
    }

    /* access modifiers changed from: private */
    public final void zzb(SignInResponse signInResponse) {
        ConnectionResult connectionResult = signInResponse.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
            connectionResult = resolveAccountResponse.getConnectionResult();
            if (!connectionResult.isSuccess()) {
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
            } else {
                this.zzlw.zza(resolveAccountResponse.getAccountAccessor(), this.mScopes);
                this.zzhn.disconnect();
            }
        }
        this.zzlw.zzg(connectionResult);
        this.zzhn.disconnect();
    }

    public final void onConnected(Bundle bundle) {
        this.zzhn.signIn(this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzlw.zzg(connectionResult);
    }

    public final void onConnectionSuspended(int i) {
        this.zzhn.disconnect();
    }

    public final void onSignInComplete(SignInResponse signInResponse) {
        this.mHandler.post(new zzca(this, signInResponse));
    }

    public final void zza(zzcb zzcb) {
        SignInClient signInClient = this.zzhn;
        if (signInClient != null) {
            signInClient.disconnect();
        }
        this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder = this.zzby;
        Context context = this.mContext;
        Looper looper = this.mHandler.getLooper();
        ClientSettings clientSettings = this.zzgf;
        this.zzhn = (SignInClient) abstractClientBuilder.buildClient(context, looper, clientSettings, clientSettings.getSignInOptions(), this, this);
        this.zzlw = zzcb;
        Set<Scope> set = this.mScopes;
        if (set == null || set.isEmpty()) {
            this.mHandler.post(new zzbz(this));
        } else {
            this.zzhn.connect();
        }
    }

    public final SignInClient zzbt() {
        return this.zzhn;
    }

    public final void zzbz() {
        SignInClient signInClient = this.zzhn;
        if (signInClient != null) {
            signInClient.disconnect();
        }
    }
}
