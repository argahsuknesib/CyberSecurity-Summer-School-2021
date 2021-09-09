package com.tencent.qqmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IQQMusicApiEventListener extends IInterface {
    void onEvent(String str, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IQQMusicApiEventListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener");
        }

        public static IQQMusicApiEventListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IQQMusicApiEventListener)) {
                return new Proxy(iBinder);
            }
            return (IQQMusicApiEventListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener");
                onEvent(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener");
                return true;
            }
        }

        static class Proxy implements IQQMusicApiEventListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
