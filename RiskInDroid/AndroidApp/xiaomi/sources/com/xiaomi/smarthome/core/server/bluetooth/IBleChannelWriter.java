package com.xiaomi.smarthome.core.server.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public interface IBleChannelWriter extends IInterface {
    void write(byte[] bArr, int i, IBleResponse iBleResponse) throws RemoteException;

    void writeWithOpCode(int i, byte[] bArr, int i2, IBleResponse iBleResponse) throws RemoteException;

    public static abstract class Stub extends Binder implements IBleChannelWriter {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
        }

        public static IBleChannelWriter asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBleChannelWriter)) {
                return new Proxy(iBinder);
            }
            return (IBleChannelWriter) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            byte[] bArr = null;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
                int readInt = parcel.readInt();
                if (readInt >= 0) {
                    bArr = new byte[readInt];
                }
                write(bArr, parcel.readInt(), IBleResponse.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeByteArray(bArr);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                if (readInt3 >= 0) {
                    bArr = new byte[readInt3];
                }
                writeWithOpCode(readInt2, bArr, parcel.readInt(), IBleResponse.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeByteArray(bArr);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
                return true;
            }
        }

        static class Proxy implements IBleChannelWriter {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void write(byte[] bArr, int i, IBleResponse iBleResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBleResponse != null ? iBleResponse.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readByteArray(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void writeWithOpCode(int i, byte[] bArr, int i2, IBleResponse iBleResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter");
                    obtain.writeInt(i);
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iBleResponse != null ? iBleResponse.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readByteArray(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
