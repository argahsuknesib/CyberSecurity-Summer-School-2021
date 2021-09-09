package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

final class zzaw implements GmsClientEventManager.GmsClientEventState {
    private final /* synthetic */ zzav zzit;

    zzaw(zzav zzav) {
        this.zzit = zzav;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return this.zzit.isConnected();
    }
}
