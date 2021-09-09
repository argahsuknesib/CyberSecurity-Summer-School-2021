package com.miui.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrack extends IInterface {
    void trackEvent(String str, String str2, String str3, String str4) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrack {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.analytics.ITrack");
        }

        public static ITrack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.analytics.ITrack");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITrack)) {
                return new Proxy(iBinder);
            }
            return (ITrack) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.analytics.ITrack");
                trackEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.miui.analytics.ITrack");
                return true;
            }
        }

        static class Proxy implements ITrack {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.analytics.ITrack";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void trackEvent(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.analytics.ITrack");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
