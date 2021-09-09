package com.miui.tsmclient.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.tsmclient.service.IServiceResponse;
import java.util.Map;

public interface ISEInteractionService extends IInterface {
    void deleteCard(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void issueCard(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    public static abstract class Stub extends Binder implements ISEInteractionService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclient.service.ISEInteractionService");
        }

        public static ISEInteractionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclient.service.ISEInteractionService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISEInteractionService)) {
                return new Proxy(iBinder);
            }
            return (ISEInteractionService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.tsmclient.service.ISEInteractionService");
                issueCard(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.miui.tsmclient.service.ISEInteractionService");
                deleteCard(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.miui.tsmclient.service.ISEInteractionService");
                return true;
            }
        }

        static class Proxy implements ISEInteractionService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclient.service.ISEInteractionService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void issueCard(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ISEInteractionService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteCard(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ISEInteractionService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
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
