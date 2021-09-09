package com.xiaomi.passport.uicontroller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.MiLoginResult;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.account.data.NotificationLoginEndParams;
import com.xiaomi.accountsdk.account.data.PasswordLoginParams;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;

public interface IMiPassportUIControllerService extends IInterface {

    public static class Default implements IMiPassportUIControllerService {
        public void addOrUpdateAccountManager(AccountInfo accountInfo) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public MiLoginResult loginByPassword(PasswordLoginParams passwordLoginParams) throws RemoteException {
            return null;
        }

        public MiLoginResult loginByStep2(Step2LoginParams step2LoginParams) throws RemoteException {
            return null;
        }

        public NotificationAuthResult onNotificationAuthEnd(String str) throws RemoteException {
            return null;
        }

        public MiLoginResult onNotificationLoginEnd(NotificationLoginEndParams notificationLoginEndParams) throws RemoteException {
            return null;
        }
    }

    void addOrUpdateAccountManager(AccountInfo accountInfo) throws RemoteException;

    MiLoginResult loginByPassword(PasswordLoginParams passwordLoginParams) throws RemoteException;

    MiLoginResult loginByStep2(Step2LoginParams step2LoginParams) throws RemoteException;

    NotificationAuthResult onNotificationAuthEnd(String str) throws RemoteException;

    MiLoginResult onNotificationLoginEnd(NotificationLoginEndParams notificationLoginEndParams) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiPassportUIControllerService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
        }

        public static IMiPassportUIControllerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiPassportUIControllerService)) {
                return new Proxy(iBinder);
            }
            return (IMiPassportUIControllerService) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.xiaomi.accountsdk.account.data.PasswordLoginParams} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.xiaomi.accountsdk.account.data.NotificationLoginEndParams} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.xiaomi.accountsdk.account.data.Step2LoginParams} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.xiaomi.accountsdk.account.data.AccountInfo} */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ? r1 = 0;
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                if (parcel.readInt() != 0) {
                    r1 = PasswordLoginParams.CREATOR.createFromParcel(parcel);
                }
                MiLoginResult loginByPassword = loginByPassword(r1);
                parcel2.writeNoException();
                if (loginByPassword != null) {
                    parcel2.writeInt(1);
                    loginByPassword.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                if (parcel.readInt() != 0) {
                    r1 = NotificationLoginEndParams.CREATOR.createFromParcel(parcel);
                }
                MiLoginResult onNotificationLoginEnd = onNotificationLoginEnd(r1);
                parcel2.writeNoException();
                if (onNotificationLoginEnd != null) {
                    parcel2.writeInt(1);
                    onNotificationLoginEnd.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                if (parcel.readInt() != 0) {
                    r1 = Step2LoginParams.CREATOR.createFromParcel(parcel);
                }
                MiLoginResult loginByStep2 = loginByStep2(r1);
                parcel2.writeNoException();
                if (loginByStep2 != null) {
                    parcel2.writeInt(1);
                    loginByStep2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                if (parcel.readInt() != 0) {
                    r1 = AccountInfo.CREATOR.createFromParcel(parcel);
                }
                addOrUpdateAccountManager(r1);
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                NotificationAuthResult onNotificationAuthEnd = onNotificationAuthEnd(parcel.readString());
                parcel2.writeNoException();
                if (onNotificationAuthEnd != null) {
                    parcel2.writeInt(1);
                    onNotificationAuthEnd.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                return true;
            }
        }

        static class Proxy implements IMiPassportUIControllerService {
            public static IMiPassportUIControllerService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.passport.uicontroller.IMiPassportUIControllerService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public MiLoginResult loginByPassword(PasswordLoginParams passwordLoginParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                    if (passwordLoginParams != null) {
                        obtain.writeInt(1);
                        passwordLoginParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().loginByPassword(passwordLoginParams);
                    }
                    obtain2.readException();
                    MiLoginResult createFromParcel = obtain2.readInt() != 0 ? MiLoginResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public MiLoginResult onNotificationLoginEnd(NotificationLoginEndParams notificationLoginEndParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                    if (notificationLoginEndParams != null) {
                        obtain.writeInt(1);
                        notificationLoginEndParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onNotificationLoginEnd(notificationLoginEndParams);
                    }
                    obtain2.readException();
                    MiLoginResult createFromParcel = obtain2.readInt() != 0 ? MiLoginResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public MiLoginResult loginByStep2(Step2LoginParams step2LoginParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                    if (step2LoginParams != null) {
                        obtain.writeInt(1);
                        step2LoginParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().loginByStep2(step2LoginParams);
                    }
                    obtain2.readException();
                    MiLoginResult createFromParcel = obtain2.readInt() != 0 ? MiLoginResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOrUpdateAccountManager(AccountInfo accountInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                    if (accountInfo != null) {
                        obtain.writeInt(1);
                        accountInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addOrUpdateAccountManager(accountInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public NotificationAuthResult onNotificationAuthEnd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.passport.uicontroller.IMiPassportUIControllerService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onNotificationAuthEnd(str);
                    }
                    obtain2.readException();
                    NotificationAuthResult createFromParcel = obtain2.readInt() != 0 ? NotificationAuthResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMiPassportUIControllerService iMiPassportUIControllerService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMiPassportUIControllerService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMiPassportUIControllerService;
                return true;
            }
        }

        public static IMiPassportUIControllerService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
