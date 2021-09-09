package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zza implements BackgroundDetector.BackgroundStateChangeListener {
    zza() {
    }

    public final void onBackgroundStateChanged(boolean z) {
        FirebaseApp.onBackgroundStateChanged(z);
    }
}
