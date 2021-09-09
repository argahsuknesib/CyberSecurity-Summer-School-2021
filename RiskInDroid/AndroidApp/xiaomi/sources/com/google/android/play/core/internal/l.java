package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class l extends i implements n {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    public final void a(String str, Bundle bundle, p pVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, pVar);
        a(2, a2);
    }

    public final void b(String str, Bundle bundle, p pVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, pVar);
        a(3, a2);
    }
}
