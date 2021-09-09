package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.ISignInService;

public class SignInClientImpl extends GmsClient<ISignInService> implements SignInClient {
    @Deprecated
    public static final String KEY_OFFLINE_ACCESS_CALLBACKS = "com.google.android.gms.signin.internal.signInCallbacks";
    private final Bundle zzada;
    private final boolean zzads;
    private final ClientSettings zzgf;
    private Integer zzsc;

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzads = z;
        this.zzgf = clientSettings;
        this.zzada = bundle;
        this.zzsc = clientSettings.getClientSessionId();
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, clientSettings, createBundleFromClientSettings(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        SignInOptions signInOptions = clientSettings.getSignInOptions();
        Integer clientSessionId = clientSettings.getClientSessionId();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.getAccount());
        if (clientSessionId != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", clientSessionId.intValue());
        }
        if (signInOptions != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", signInOptions.isOfflineAccessRequested());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", signInOptions.isIdTokenRequested());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", signInOptions.getServerClientId());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", signInOptions.isForceCodeForRefreshToken());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", signInOptions.getHostedDomain());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", signInOptions.waitForAccessTokenRefresh());
            if (signInOptions.getAuthApiSignInModuleVersion() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", signInOptions.getAuthApiSignInModuleVersion().longValue());
            }
            if (signInOptions.getRealClientLibraryVersion() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", signInOptions.getRealClientLibraryVersion().longValue());
            }
        }
        return bundle;
    }

    public void clearAccountFromSessionStore() {
        try {
            ((ISignInService) getService()).clearAccountFromSessionStore(this.zzsc.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void connect() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    /* access modifiers changed from: protected */
    public ISignInService createServiceInterface(IBinder iBinder) {
        return ISignInService.Stub.asInterface(iBinder);
    }

    public Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zzgf.getRealClientPackageName())) {
            this.zzada.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzgf.getRealClientPackageName());
        }
        return this.zzada;
    }

    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public boolean requiresSignIn() {
        return this.zzads;
    }

    public void saveDefaultAccount(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((ISignInService) getService()).saveDefaultAccountToSharedPref(iAccountAccessor, this.zzsc.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void signIn(ISignInCallbacks iSignInCallbacks) {
        Preconditions.checkNotNull(iSignInCallbacks, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zzgf.getAccountOrDefault();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(accountOrDefault.name)) {
                googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
            }
            ((ISignInService) getService()).signIn(new SignInRequest(new ResolveAccountRequest(accountOrDefault, this.zzsc.intValue(), googleSignInAccount)), iSignInCallbacks);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                iSignInCallbacks.onSignInComplete(new SignInResponse(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
