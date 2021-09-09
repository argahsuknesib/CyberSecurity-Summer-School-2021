package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class m extends j implements n {
    public static n a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof n ? (n) queryLocalInterface : new l(iBinder);
    }
}
