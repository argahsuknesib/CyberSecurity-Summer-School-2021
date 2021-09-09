package com.miui.tsmclient.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.tsmclient.smartcard.terminal.SmartMxError;

public interface ITsmTerminalService extends IInterface {
    void checkNfcEEStatus(SmartMxError smartMxError) throws RemoteException;

    void close(SmartMxError smartMxError) throws RemoteException;

    String getSignedSpiPK(SmartMxError smartMxError) throws RemoteException;

    void open(SmartMxError smartMxError, IBinder iBinder) throws RemoteException;

    byte[] transmit(byte[] bArr, SmartMxError smartMxError) throws RemoteException;

    public static abstract class Stub extends Binder implements ITsmTerminalService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclient.service.ITsmTerminalService");
        }

        public static ITsmTerminalService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclient.service.ITsmTerminalService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmTerminalService)) {
                return new Proxy(iBinder);
            }
            return (ITsmTerminalService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.tsmclient.service.ITsmTerminalService");
                SmartMxError smartMxError = new SmartMxError();
                open(smartMxError, parcel.readStrongBinder());
                parcel2.writeNoException();
                parcel2.writeInt(1);
                smartMxError.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.miui.tsmclient.service.ITsmTerminalService");
                SmartMxError smartMxError2 = new SmartMxError();
                close(smartMxError2);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                smartMxError2.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.miui.tsmclient.service.ITsmTerminalService");
                byte[] createByteArray = parcel.createByteArray();
                SmartMxError smartMxError3 = new SmartMxError();
                byte[] transmit = transmit(createByteArray, smartMxError3);
                parcel2.writeNoException();
                parcel2.writeByteArray(transmit);
                parcel2.writeInt(1);
                smartMxError3.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.miui.tsmclient.service.ITsmTerminalService");
                SmartMxError smartMxError4 = new SmartMxError();
                checkNfcEEStatus(smartMxError4);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                smartMxError4.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.miui.tsmclient.service.ITsmTerminalService");
                SmartMxError smartMxError5 = new SmartMxError();
                String signedSpiPK = getSignedSpiPK(smartMxError5);
                parcel2.writeNoException();
                parcel2.writeString(signedSpiPK);
                parcel2.writeInt(1);
                smartMxError5.writeToParcel(parcel2, 1);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.miui.tsmclient.service.ITsmTerminalService");
                return true;
            }
        }

        static class Proxy implements ITsmTerminalService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclient.service.ITsmTerminalService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void open(SmartMxError smartMxError, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmTerminalService");
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void close(SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmTerminalService");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] transmit(byte[] bArr, SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmTerminalService");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkNfcEEStatus(SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmTerminalService");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSignedSpiPK(SmartMxError smartMxError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmTerminalService");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    if (obtain2.readInt() != 0) {
                        smartMxError.readFromParcel(obtain2);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
