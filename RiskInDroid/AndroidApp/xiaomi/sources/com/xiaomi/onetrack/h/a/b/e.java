package com.xiaomi.onetrack.h.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* renamed from: com.xiaomi.onetrack.h.a.b.e$a$a  reason: collision with other inner class name */
        public static class C0057a implements e {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6167a;

            public C0057a(IBinder iBinder) {
                this.f6167a = iBinder;
            }

            /* JADX INFO: finally extract failed */
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f6167a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain.recycle();
                    obtain2.recycle();
                    return readString;
                } catch (Exception e) {
                    e.printStackTrace();
                    obtain.recycle();
                    obtain2.recycle();
                    return null;
                } catch (Throwable th) {
                    obtain.recycle();
                    obtain2.recycle();
                    throw th;
                }
            }

            public IBinder asBinder() {
                return this.f6167a;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0057a(iBinder);
            }
            return (e) queryLocalInterface;
        }
    }
}
