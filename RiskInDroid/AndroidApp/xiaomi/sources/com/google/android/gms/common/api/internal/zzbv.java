package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

public final class zzbv {
    public final RegisterListenerMethod<Api.AnyClient, ?> zzlt;
    public final UnregisterListenerMethod<Api.AnyClient, ?> zzlu;

    public zzbv(RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        this.zzlt = registerListenerMethod;
        this.zzlu = unregisterListenerMethod;
    }
}
