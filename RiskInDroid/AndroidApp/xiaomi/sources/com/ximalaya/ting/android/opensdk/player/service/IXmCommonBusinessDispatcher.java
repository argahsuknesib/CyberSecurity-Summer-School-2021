package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public interface IXmCommonBusinessDispatcher extends IInterface {
    void closeApp() throws RemoteException;

    String getDownloadPlayPath(Track track) throws RemoteException;

    void isOldTrackDownload(Track track) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmCommonBusinessDispatcher {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
        }

        public static IXmCommonBusinessDispatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmCommonBusinessDispatcher)) {
                return new Proxy(iBinder);
            }
            return (IXmCommonBusinessDispatcher) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Track track = null;
            if (i == 1) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                if (parcel.readInt() != 0) {
                    track = Track.CREATOR.createFromParcel(parcel);
                }
                String downloadPlayPath = getDownloadPlayPath(track);
                parcel2.writeNoException();
                parcel2.writeString(downloadPlayPath);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                if (parcel.readInt() != 0) {
                    track = Track.CREATOR.createFromParcel(parcel);
                }
                isOldTrackDownload(track);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                closeApp();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                return true;
            }
        }

        static class Proxy implements IXmCommonBusinessDispatcher {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getDownloadPlayPath(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isOldTrackDownload(Track track) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void closeApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
