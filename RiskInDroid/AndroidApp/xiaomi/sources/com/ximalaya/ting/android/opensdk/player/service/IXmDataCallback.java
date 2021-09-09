package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.ArrayList;
import java.util.List;

public interface IXmDataCallback extends IInterface {
    void onDataReady(List<Track> list, boolean z, boolean z2) throws RemoteException;

    void onError(int i, String str, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmDataCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
        }

        public static IXmDataCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmDataCallback)) {
                return new Proxy(iBinder);
            }
            return (IXmDataCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            if (i == 1) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
                ArrayList createTypedArrayList = parcel.createTypedArrayList(Track.CREATOR);
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                onDataReady(createTypedArrayList, z2, z);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                onError(readInt, readString, z);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
                return true;
            }
        }

        static class Proxy implements IXmDataCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onDataReady(List<Track> list, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
                    obtain.writeTypedList(list);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(int i, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
