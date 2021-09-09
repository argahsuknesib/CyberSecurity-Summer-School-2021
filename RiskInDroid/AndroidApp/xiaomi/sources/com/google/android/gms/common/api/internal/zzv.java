package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;

public final class zzv<O extends Api.ApiOptions> extends GoogleApi<O> {
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private final Api.Client zzgd;
    private final zzp zzge;
    private final ClientSettings zzgf;

    public zzv(Context context, Api<O> api, Looper looper, Api.Client client, zzp zzp, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.zzgd = client;
        this.zzge = zzp;
        this.zzgf = clientSettings;
        this.zzdh = abstractClientBuilder;
        this.zzcq.zza(this);
    }

    public final Api.Client zza(Looper looper, GoogleApiManager.zza<O> zza) {
        this.zzge.zza(zza);
        return this.zzgd;
    }

    public final zzby zza(Context context, Handler handler) {
        return new zzby(context, handler, this.zzgf, this.zzdh);
    }

    public final Api.Client zzae() {
        return this.zzgd;
    }
}
