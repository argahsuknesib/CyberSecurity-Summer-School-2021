package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class i implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f3768a;
    private final String b;

    protected i(IBinder iBinder, String str) {
        this.f3768a = iBinder;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void a(int i, Parcel parcel) throws RemoteException {
        try {
            this.f3768a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f3768a;
    }
}
