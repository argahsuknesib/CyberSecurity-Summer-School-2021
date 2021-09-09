package com.google.android.gms.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class SignIn {
    public static final Api<SignInOptions> API = new Api<>("SignIn.API", CLIENT_BUILDER, CLIENT_KEY);
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> CLIENT_BUILDER = new zza();
    public static final Api.ClientKey<SignInClientImpl> CLIENT_KEY = new Api.ClientKey<>();
    public static final Api<SignInOptionsInternal> INTERNAL_API = new Api<>("SignIn.INTERNAL_API", zzacz, INTERNAL_CLIENT_KEY);
    public static final Api.ClientKey<SignInClientImpl> INTERNAL_CLIENT_KEY = new Api.ClientKey<>();
    public static final Scope SCOPE_EMAIL = new Scope("email");
    public static final Scope SCOPE_PROFILE = new Scope("profile");
    private static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptionsInternal> zzacz = new zzb();

    public static class SignInOptionsInternal implements Api.ApiOptions.HasOptions {
        private final Bundle zzada;

        private SignInOptionsInternal(Bundle bundle) {
            this.zzada = bundle == null ? new Bundle() : bundle;
        }

        public static SignInOptionsInternal create(Bundle bundle) {
            return new SignInOptionsInternal(bundle);
        }

        public Bundle getSignInOptionsBundle() {
            return this.zzada;
        }
    }

    private SignIn() {
    }
}
