package com.xiaomi.smarthome.frame.plugin;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;

public interface IBridgeServiceApi extends IInterface {
    void exitProcess() throws RemoteException;

    boolean isProcessForeground() throws RemoteException;

    boolean isRnActivityReuseAvailable() throws RemoteException;

    void sendMessage(String str, DeviceStat deviceStat, int i, Intent intent, boolean z, IBridgeCallback iBridgeCallback) throws RemoteException;

    void startService(String str, long j, long j2, Intent intent, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IBridgeServiceApi {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
        }

        public static IBridgeServiceApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBridgeServiceApi)) {
                return new Proxy(iBinder);
            }
            return (IBridgeServiceApi) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.content.Intent} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            Intent intent = null;
            if (i3 == 1) {
                parcel3.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                String readString = parcel.readString();
                DeviceStat createFromParcel = parcel.readInt() != 0 ? DeviceStat.CREATOR.createFromParcel(parcel3) : null;
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    intent = Intent.CREATOR.createFromParcel(parcel3);
                }
                sendMessage(readString, createFromParcel, readInt, intent, parcel.readInt() != 0, IBridgeCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i3 == 2) {
                parcel3.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                String readString2 = parcel.readString();
                long readLong = parcel.readLong();
                long readLong2 = parcel.readLong();
                if (parcel.readInt() != 0) {
                    intent = Intent.CREATOR.createFromParcel(parcel3);
                }
                startService(readString2, readLong, readLong2, intent, parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i3 == 3) {
                parcel3.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                exitProcess();
                parcel2.writeNoException();
                return true;
            } else if (i3 == 4) {
                parcel3.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                boolean isProcessForeground = isProcessForeground();
                parcel2.writeNoException();
                parcel4.writeInt(isProcessForeground);
                return true;
            } else if (i3 == 5) {
                parcel3.enforceInterface("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                boolean isRnActivityReuseAvailable = isRnActivityReuseAvailable();
                parcel2.writeNoException();
                parcel4.writeInt(isRnActivityReuseAvailable);
                return true;
            } else if (i3 != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel4.writeString("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                return true;
            }
        }

        static class Proxy implements IBridgeServiceApi {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void sendMessage(String str, DeviceStat deviceStat, int i, Intent intent, boolean z, IBridgeCallback iBridgeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                    obtain.writeString(str);
                    if (deviceStat != null) {
                        obtain.writeInt(1);
                        deviceStat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(iBridgeCallback != null ? iBridgeCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startService(String str, long j, long j2, Intent intent, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void exitProcess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isProcessForeground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
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

            public boolean isRnActivityReuseAvailable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi");
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
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
        }
    }
}
