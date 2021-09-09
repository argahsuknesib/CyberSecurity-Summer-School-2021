package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.internal.SignInClientImpl;

final class zzb extends Api.AbstractClientBuilder<SignInClientImpl, SignIn.SignInOptionsInternal> {
    zzb() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.signin.internal.SignInClientImpl.<init>(android.content.Context, android.os.Looper, boolean, com.google.android.gms.common.internal.ClientSettings, android.os.Bundle, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):void
     arg types: [android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.ClientSettings, android.os.Bundle, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener]
     candidates:
      com.google.android.gms.signin.internal.SignInClientImpl.<init>(android.content.Context, android.os.Looper, boolean, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.signin.SignInOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):void
      com.google.android.gms.signin.internal.SignInClientImpl.<init>(android.content.Context, android.os.Looper, boolean, com.google.android.gms.common.internal.ClientSettings, android.os.Bundle, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):void */
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new SignInClientImpl(context, looper, false, clientSettings, ((SignIn.SignInOptionsInternal) obj).getSignInOptionsBundle(), connectionCallbacks, onConnectionFailedListener);
    }
}
