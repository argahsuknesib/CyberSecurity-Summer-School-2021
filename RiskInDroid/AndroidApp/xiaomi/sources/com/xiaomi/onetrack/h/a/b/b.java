package com.xiaomi.onetrack.h.a.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {
    String a();

    boolean b();

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6164a;

        public a(IBinder iBinder) {
            this.f6164a = iBinder;
        }

        public final IBinder asBinder() {
            return this.f6164a;
        }

        public final String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f6164a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        public final boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f6164a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }
    }
}
