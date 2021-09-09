package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class bo extends j implements bp {
    public static bp a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof bp ? (bp) queryLocalInterface : new bn(iBinder);
    }
}
