package com.xiaomi.passport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public interface IPassportServiceTokenService extends IInterface {

    public static class Default implements IPassportServiceTokenService {
        public IBinder asBinder() {
            return null;
        }

        public boolean fastCheckSlhPhCompatibility() throws RemoteException {
            return false;
        }

        public XmAccountVisibility getAccountVisible(String str) throws RemoteException {
            return null;
        }

        public ServiceTokenResult getServiceToken(String str) throws RemoteException {
            return null;
        }

        public ServiceTokenResult invalidateServiceToken(ServiceTokenResult serviceTokenResult) throws RemoteException {
            return null;
        }

        public XmAccountVisibility setAccountVisible(String str) throws RemoteException {
            return null;
        }

        public boolean supportAccessAccount() throws RemoteException {
            return false;
        }

        public boolean supportServiceTokenUIResponse() throws RemoteException {
            return false;
        }
    }

    boolean fastCheckSlhPhCompatibility() throws RemoteException;

    XmAccountVisibility getAccountVisible(String str) throws RemoteException;

    ServiceTokenResult getServiceToken(String str) throws RemoteException;

    ServiceTokenResult invalidateServiceToken(ServiceTokenResult serviceTokenResult) throws RemoteException;

    XmAccountVisibility setAccountVisible(String str) throws RemoteException;

    boolean supportAccessAccount() throws RemoteException;

    boolean supportServiceTokenUIResponse() throws RemoteException;

    public static abstract class Stub extends Binder implements IPassportServiceTokenService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.IPassportServiceTokenService");
        }

        public static IPassportServiceTokenService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.IPassportServiceTokenService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPassportServiceTokenService)) {
                return new Proxy(iBinder);
            }
            return (IPassportServiceTokenService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        ServiceTokenResult serviceToken = getServiceToken(parcel.readString());
                        parcel2.writeNoException();
                        if (serviceToken != null) {
                            parcel2.writeInt(1);
                            serviceToken.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        ServiceTokenResult invalidateServiceToken = invalidateServiceToken(parcel.readInt() != 0 ? ServiceTokenResult.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        if (invalidateServiceToken != null) {
                            parcel2.writeInt(1);
                            invalidateServiceToken.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        boolean supportServiceTokenUIResponse = supportServiceTokenUIResponse();
                        parcel2.writeNoException();
                        parcel2.writeInt(supportServiceTokenUIResponse ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        boolean fastCheckSlhPhCompatibility = fastCheckSlhPhCompatibility();
                        parcel2.writeNoException();
                        parcel2.writeInt(fastCheckSlhPhCompatibility ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        boolean supportAccessAccount = supportAccessAccount();
                        parcel2.writeNoException();
                        parcel2.writeInt(supportAccessAccount ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        XmAccountVisibility accountVisible = setAccountVisible(parcel.readString());
                        parcel2.writeNoException();
                        if (accountVisible != null) {
                            parcel2.writeInt(1);
                            accountVisible.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.passport.IPassportServiceTokenService");
                        XmAccountVisibility accountVisible2 = getAccountVisible(parcel.readString());
                        parcel2.writeNoException();
                        if (accountVisible2 != null) {
                            parcel2.writeInt(1);
                            accountVisible2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.passport.IPassportServiceTokenService");
                return true;
            }
        }

        static class Proxy implements IPassportServiceTokenService {
            public static IPassportServiceTokenService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.IPassportServiceTokenService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public ServiceTokenResult getServiceToken(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getServiceToken(str);
                    }
                    obtain2.readException();
                    ServiceTokenResult createFromParcel = obtain2.readInt() != 0 ? ServiceTokenResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ServiceTokenResult invalidateServiceToken(ServiceTokenResult serviceTokenResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    if (serviceTokenResult != null) {
                        obtain.writeInt(1);
                        serviceTokenResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().invalidateServiceToken(serviceTokenResult);
                    }
                    obtain2.readException();
                    ServiceTokenResult createFromParcel = obtain2.readInt() != 0 ? ServiceTokenResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean supportServiceTokenUIResponse() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    boolean z = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().supportServiceTokenUIResponse();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean fastCheckSlhPhCompatibility() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    boolean z = false;
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().fastCheckSlhPhCompatibility();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean supportAccessAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    boolean z = false;
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().supportAccessAccount();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public XmAccountVisibility setAccountVisible(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAccountVisible(str);
                    }
                    obtain2.readException();
                    XmAccountVisibility createFromParcel = obtain2.readInt() != 0 ? XmAccountVisibility.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public XmAccountVisibility getAccountVisible(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.IPassportServiceTokenService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAccountVisible(str);
                    }
                    obtain2.readException();
                    XmAccountVisibility createFromParcel = obtain2.readInt() != 0 ? XmAccountVisibility.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPassportServiceTokenService iPassportServiceTokenService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iPassportServiceTokenService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iPassportServiceTokenService;
                return true;
            }
        }

        public static IPassportServiceTokenService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
