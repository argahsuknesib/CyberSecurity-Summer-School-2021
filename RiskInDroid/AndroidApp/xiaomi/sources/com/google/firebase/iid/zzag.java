package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.Registrar;

final /* synthetic */ class zzag implements ComponentFactory {
    static final ComponentFactory zzby = new zzag();

    private zzag() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new Registrar.zza((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
