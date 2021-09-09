package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class r extends j implements s {
    public static s a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof s ? (s) queryLocalInterface : new q(iBinder);
    }
}
