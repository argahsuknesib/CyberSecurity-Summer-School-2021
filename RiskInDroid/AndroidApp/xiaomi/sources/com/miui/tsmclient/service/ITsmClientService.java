package com.miui.tsmclient.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.miui.tsmclient.service.IServiceResponse;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface ITsmClientService extends IInterface {
    void cancelTask(String str) throws RemoteException;

    void checkNfcEEStatus(IServiceResponse iServiceResponse) throws RemoteException;

    void checkSeUpgrade(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void enrollUPCard(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void getCPLC(IServiceResponse iServiceResponse) throws RemoteException;

    void getCardList(IServiceResponse iServiceResponse, boolean z) throws RemoteException;

    void getSeid(IServiceResponse iServiceResponse) throws RemoteException;

    void isServiceAvailable(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void notifyInappPayResult(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void preparePayApplet(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void processCard(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void queryPan(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void rechargeCard(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void requestInappPay(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void requestVerificationCode(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void setRfConfig(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void transferOut(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void unrestrictESE(IServiceResponse iServiceResponse) throws RemoteException;

    void updateCards(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void upgradeApplet(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void upgradeCPLC(IServiceResponse iServiceResponse) throws RemoteException;

    void uploadExceptionUserLog(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    void verifyVerificationCode(IServiceResponse iServiceResponse, Map map) throws RemoteException;

    public static abstract class Stub extends Binder implements ITsmClientService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclient.service.ITsmClientService");
        }

        public static ITsmClientService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclient.service.ITsmClientService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmClientService)) {
                return new Proxy(iBinder);
            }
            return (ITsmClientService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        getCPLC(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        getSeid(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        checkNfcEEStatus(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        unrestrictESE(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        upgradeCPLC(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        getCardList(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        updateCards(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        processCard(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        rechargeCard(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        requestVerificationCode(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        verifyVerificationCode(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        queryPan(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        preparePayApplet(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        enrollUPCard(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        requestInappPay(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        notifyInappPayResult(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        transferOut(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        isServiceAvailable(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        uploadExceptionUserLog(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        checkSeUpgrade(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        upgradeApplet(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        cancelTask(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.miui.tsmclient.service.ITsmClientService");
                        setRfConfig(IServiceResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.miui.tsmclient.service.ITsmClientService");
                return true;
            }
        }

        static class Proxy implements ITsmClientService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclient.service.ITsmClientService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void getCPLC(IServiceResponse iServiceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSeid(IServiceResponse iServiceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkNfcEEStatus(IServiceResponse iServiceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unrestrictESE(IServiceResponse iServiceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void upgradeCPLC(IServiceResponse iServiceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCardList(IServiceResponse iServiceResponse, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateCards(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void processCard(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void rechargeCard(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestVerificationCode(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void verifyVerificationCode(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void queryPan(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void preparePayApplet(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enrollUPCard(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestInappPay(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyInappPayResult(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void transferOut(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isServiceAvailable(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void uploadExceptionUserLog(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkSeUpgrade(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void upgradeApplet(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelTask(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeString(str);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRfConfig(IServiceResponse iServiceResponse, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.service.ITsmClientService");
                    obtain.writeStrongBinder(iServiceResponse != null ? iServiceResponse.asBinder() : null);
                    obtain.writeMap(map);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
