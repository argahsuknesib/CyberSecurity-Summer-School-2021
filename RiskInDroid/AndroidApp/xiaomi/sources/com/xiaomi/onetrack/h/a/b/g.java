package com.xiaomi.onetrack.h.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface g extends IInterface {
    boolean a();

    String b();

    boolean c();

    void d();

    public static abstract class a extends Binder implements g {

        /* renamed from: com.xiaomi.onetrack.h.a.b.g$a$a  reason: collision with other inner class name */
        public static class C0058a implements g {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6169a;

            public boolean c() {
                return false;
            }

            public C0058a(IBinder iBinder) {
                this.f6169a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6169a;
            }

            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f6169a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        return false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return true;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    th.printStackTrace();
                    return false;
                }
            }

            public String b() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f6169a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return str;
            }

            public void d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f6169a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
