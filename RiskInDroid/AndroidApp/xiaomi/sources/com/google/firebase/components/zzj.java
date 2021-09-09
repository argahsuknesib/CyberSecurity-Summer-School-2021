package com.google.firebase.components;

import com.google.firebase.inject.Provider;

final /* synthetic */ class zzj implements Provider {
    private final ComponentFactory zzat;
    private final ComponentContainer zzau;

    zzj(ComponentFactory componentFactory, ComponentContainer componentContainer) {
        this.zzat = componentFactory;
        this.zzau = componentContainer;
    }

    public final Object get() {
        return this.zzat.create(this.zzau);
    }
}
