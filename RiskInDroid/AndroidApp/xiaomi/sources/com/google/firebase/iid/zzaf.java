package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class zzaf implements ComponentFactory {
    static final ComponentFactory zzby = new zzaf();

    private zzaf() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.get(FirebaseApp.class));
    }
}
