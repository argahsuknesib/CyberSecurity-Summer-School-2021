package com.xiaomi.miot.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.miot.service.ICallback;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IMiuiService extends IInterface {
    void getAccess(Bundle bundle) throws RemoteException;

    void getDeviceCount(ICallback iCallback, boolean z) throws RemoteException;

    void getDeviceDesc(boolean z, ICallback iCallback) throws RemoteException;

    void getDeviceList(ICallback iCallback) throws RemoteException;

    void getDeviceListFilterKey(ICallback iCallback, boolean z) throws RemoteException;

    void getDeviceListPropOrder(ICallback iCallback, boolean z) throws RemoteException;

    void initUwb(Bundle bundle, ICallback iCallback) throws RemoteException;

    void isLogin(ICallback iCallback) throws RemoteException;

    void isSameCard(String str, ICallback iCallback) throws RemoteException;

    void scanNearList(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException;

    void scanNearListFilterKey(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException;

    void setDeviceOn(String str, boolean z, ICallback iCallback) throws RemoteException;

    void stopScanNear() throws RemoteException;

    public static abstract class Stub extends Binder implements IMiuiService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.miot.service.IMiuiService");
        }

        public static IMiuiService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.miot.service.IMiuiService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiuiService)) {
                return new Proxy(iBinder);
            }
            return (IMiuiService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        isLogin(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        getDeviceList(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setDeviceOn(readString, z, ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        boolean z2 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        scanNearList(z2, z, parcel.readInt(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        stopScanNear();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getDeviceDesc(z, ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        isSameCard(parcel.readString(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        ICallback asInterface = ICallback.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getDeviceListFilterKey(asInterface, z);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        boolean z3 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        scanNearListFilterKey(z3, z, parcel.readInt(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        ICallback asInterface2 = ICallback.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getDeviceCount(asInterface2, z);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        ICallback asInterface3 = ICallback.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        getDeviceListPropOrder(asInterface3, z);
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        initUwb(bundle, ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.xiaomi.miot.service.IMiuiService");
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getAccess(bundle);
                        parcel2.writeNoException();
                        if (bundle != null) {
                            parcel2.writeInt(1);
                            bundle.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.miot.service.IMiuiService");
                return true;
            }
        }

        static class Proxy implements IMiuiService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.miot.service.IMiuiService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void isLogin(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceList(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDeviceOn(String str, boolean z, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void scanNearList(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    int i2 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopScanNear() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceDesc(boolean z, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isSameCard(String str, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceListFilterKey(ICallback iCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void scanNearListFilterKey(boolean z, boolean z2, int i, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    int i2 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceCount(ICallback iCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceListPropOrder(ICallback iCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initUwb(Bundle bundle, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getAccess(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miot.service.IMiuiService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
