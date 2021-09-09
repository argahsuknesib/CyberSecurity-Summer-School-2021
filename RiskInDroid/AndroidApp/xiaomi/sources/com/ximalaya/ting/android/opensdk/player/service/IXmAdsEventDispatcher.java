package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;

public interface IXmAdsEventDispatcher extends IInterface {
    void onAdsStartBuffering() throws RemoteException;

    void onAdsStopBuffering() throws RemoteException;

    void onCompletePlayAds() throws RemoteException;

    void onError(int i, int i2) throws RemoteException;

    void onGetAdsInfo(AdvertisList advertisList) throws RemoteException;

    void onStartGetAdsInfo() throws RemoteException;

    void onStartPlayAds(Advertis advertis, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmAdsEventDispatcher {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
        }

        public static IXmAdsEventDispatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmAdsEventDispatcher)) {
                return new Proxy(iBinder);
            }
            return (IXmAdsEventDispatcher) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.ximalaya.ting.android.opensdk.model.advertis.Advertis} */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ? r0 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        onStartGetAdsInfo();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        if (parcel.readInt() != 0) {
                            r0 = AdvertisList.CREATOR.createFromParcel(parcel);
                        }
                        onGetAdsInfo(r0);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        onAdsStartBuffering();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        onAdsStopBuffering();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        if (parcel.readInt() != 0) {
                            r0 = Advertis.CREATOR.createFromParcel(parcel);
                        }
                        onStartPlayAds(r0, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        onCompletePlayAds();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                        onError(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                return true;
            }
        }

        static class Proxy implements IXmAdsEventDispatcher {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onStartGetAdsInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onGetAdsInfo(AdvertisList advertisList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    if (advertisList != null) {
                        obtain.writeInt(1);
                        advertisList.writeToParcel(obtain, 0);
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

            public void onAdsStartBuffering() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAdsStopBuffering() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStartPlayAds(Advertis advertis, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    if (advertis != null) {
                        obtain.writeInt(1);
                        advertis.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCompletePlayAds() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
