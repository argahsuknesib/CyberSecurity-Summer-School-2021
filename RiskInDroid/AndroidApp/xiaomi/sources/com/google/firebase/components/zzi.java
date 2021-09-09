package com.google.firebase.components;

import com.google.firebase.inject.Provider;

final class zzi<T> implements Provider<T> {
    private static final Object zzaq = new Object();
    private volatile Object zzar = zzaq;
    private volatile Provider<T> zzas;

    zzi(ComponentFactory<T> componentFactory, ComponentContainer componentContainer) {
        this.zzas = new zzj(componentFactory, componentContainer);
    }

    public final T get() {
        T t = this.zzar;
        if (t == zzaq) {
            synchronized (this) {
                t = this.zzar;
                if (t == zzaq) {
                    t = this.zzas.get();
                    this.zzar = t;
                    this.zzas = null;
                }
            }
        }
        return t;
    }
}
