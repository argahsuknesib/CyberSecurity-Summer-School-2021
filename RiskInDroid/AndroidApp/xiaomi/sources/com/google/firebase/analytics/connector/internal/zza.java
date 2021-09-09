package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzboi = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.getInstance((Context) componentContainer.get(Context.class));
    }
}
