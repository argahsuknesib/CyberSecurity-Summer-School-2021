package com.xiaomi.smarthome.notishortcut;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;

public interface ISmartNoti extends IInterface {
    String getDeviceSettingFromFile() throws RemoteException;

    String getNetConfig() throws RemoteException;

    boolean getSettingSwitch() throws RemoteException;

    void notifyCloseNoti() throws RemoteException;

    void notifyLogin(String str) throws RemoteException;

    void notifyLogout() throws RemoteException;

    void notifyOpenNoti(String str, String str2) throws RemoteException;

    void notifyPushMsg(String str) throws RemoteException;

    void setLocale(Bundle bundle) throws RemoteException;

    void setServer(String str) throws RemoteException;

    void setServerEnv(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements ISmartNoti {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.notishortcut.ISmartNoti");
        }

        public static ISmartNoti asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISmartNoti)) {
                return new Proxy(iBinder);
            }
            return (ISmartNoti) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        String deviceSettingFromFile = getDeviceSettingFromFile();
                        parcel2.writeNoException();
                        parcel2.writeString(deviceSettingFromFile);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        boolean settingSwitch = getSettingSwitch();
                        parcel2.writeNoException();
                        parcel2.writeInt(settingSwitch ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        String netConfig = getNetConfig();
                        parcel2.writeNoException();
                        parcel2.writeString(netConfig);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        notifyLogin(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        notifyLogout();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        notifyPushMsg(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        setLocale(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        setServer(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        setServerEnv(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        notifyOpenNoti(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                        notifyCloseNoti();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                return true;
            }
        }

        static class Proxy implements ISmartNoti {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.notishortcut.ISmartNoti";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getDeviceSettingFromFile() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getSettingSwitch() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getNetConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyLogin(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyLogout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyPushMsg(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setLocale(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setServer(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setServerEnv(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyOpenNoti(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyCloseNoti() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.notishortcut.ISmartNoti");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
