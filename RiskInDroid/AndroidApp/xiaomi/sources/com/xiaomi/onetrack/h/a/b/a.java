package com.xiaomi.onetrack.h.a.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
    String a();

    /* renamed from: com.xiaomi.onetrack.h.a.b.a$a  reason: collision with other inner class name */
    public static final class C0054a implements a {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6163a;

        public C0054a(IBinder iBinder) {
            this.f6163a = iBinder;
        }

        public final IBinder asBinder() {
            return this.f6163a;
        }

        public final String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f6163a.transact(3, obtain, obtain2, 0);
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
    }
}
