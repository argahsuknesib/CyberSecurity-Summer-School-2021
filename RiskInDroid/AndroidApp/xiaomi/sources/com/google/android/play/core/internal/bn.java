package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class bn extends i implements bp {
    bn(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    public final void a(String str, int i, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(4, a2);
    }

    public final void a(String str, int i, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        k.a(a2, brVar);
        a(5, a2);
    }

    public final void a(String str, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        k.a(a2, brVar);
        a(6, a2);
    }

    public final void a(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(2, a2);
    }

    public final void b(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(7, a2);
    }

    public final void c(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(8, a2);
    }

    public final void d(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(13, a2);
    }

    public final void e(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        k.a(a2, bundle);
        k.a(a2, brVar);
        a(14, a2);
    }
}
