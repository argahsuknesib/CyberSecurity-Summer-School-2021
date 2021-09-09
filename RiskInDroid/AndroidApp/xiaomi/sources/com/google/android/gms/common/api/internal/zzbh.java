package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zzbh implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager zzjy;

    zzbh(GoogleApiManager googleApiManager) {
        this.zzjy = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.zzjy.handler.sendMessage(this.zzjy.handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
