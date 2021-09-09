package com.xiaomi.idm.uwb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.idm.uwb.IMiCloseRangeCallback;

public interface IMiCloseRange extends IInterface {
    int asyncCommand(byte[] bArr) throws RemoteException;

    byte[] command(byte[] bArr) throws RemoteException;

    int frameData(String str, int i, byte[] bArr) throws RemoteException;

    int registerCallback(IMiCloseRangeCallback iMiCloseRangeCallback) throws RemoteException;

    int unRegisterCallback() throws RemoteException;

    public static abstract class Stub extends Binder implements IMiCloseRange {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.idm.uwb.IMiCloseRange");
        }

        public static IMiCloseRange asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.idm.uwb.IMiCloseRange");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiCloseRange)) {
                return new Proxy(iBinder);
            }
            return (IMiCloseRange) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRange");
                int registerCallback = registerCallback(IMiCloseRangeCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(registerCallback);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRange");
                int asyncCommand = asyncCommand(parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(asyncCommand);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRange");
                byte[] command = command(parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeByteArray(command);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRange");
                int unRegisterCallback = unRegisterCallback();
                parcel2.writeNoException();
                parcel2.writeInt(unRegisterCallback);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.xiaomi.idm.uwb.IMiCloseRange");
                int frameData = frameData(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(frameData);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.idm.uwb.IMiCloseRange");
                return true;
            }
        }

        static class Proxy implements IMiCloseRange {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.idm.uwb.IMiCloseRange";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int registerCallback(IMiCloseRangeCallback iMiCloseRangeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRange");
                    obtain.writeStrongBinder(iMiCloseRangeCallback != null ? iMiCloseRangeCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int asyncCommand(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRange");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] command(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRange");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unRegisterCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRange");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int frameData(String str, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.idm.uwb.IMiCloseRange");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
