package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class q extends i implements s {
    q(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    public final void a(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, bundle2);
        k.a(a2, uVar);
        a(6, a2);
    }

    public final void a(String str, Bundle bundle, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, uVar);
        a(5, a2);
    }

    public final void a(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, uVar);
        a(2, a2);
    }

    public final void b(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, bundle2);
        k.a(a2, uVar);
        a(7, a2);
    }

    public final void b(String str, Bundle bundle, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, uVar);
        a(10, a2);
    }

    public final void b(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, uVar);
        a(14, a2);
    }

    public final void c(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, bundle2);
        k.a(a2, uVar);
        a(9, a2);
    }

    public final void c(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, uVar);
        a(12, a2);
    }

    public final void d(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, bundle2);
        k.a(a2, uVar);
        a(11, a2);
    }

    public final void e(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, bundle);
        k.a(a2, bundle2);
        k.a(a2, uVar);
        a(13, a2);
    }
}
