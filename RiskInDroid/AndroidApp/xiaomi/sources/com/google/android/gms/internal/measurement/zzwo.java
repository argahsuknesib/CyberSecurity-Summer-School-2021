package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzwo extends ContentObserver {
    zzwo(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzwn.zzbmk.set(true);
    }
}
