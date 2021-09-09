package com.xiaomi.onetrack.h.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface f extends IInterface {
    String a();

    public static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6168a;

        public a(IBinder iBinder) {
            this.f6168a = iBinder;
        }

        public IBinder asBinder() {
            return this.f6168a;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f6168a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
    }

    public static abstract class b extends Binder implements f {
        public b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public f a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService") == null) {
                return null;
            }
            return new a(iBinder);
        }
    }
}
