package com.miui.tsmclientsdk;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.miui.tsmclientsdk.IMiTsmResponse;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IMiTsmService extends IInterface {
    void addMiPayShortcut(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException;

    void addMipayCard(IMiTsmResponse iMiTsmResponse, String str, int i, String str2) throws RemoteException;

    void createSSD(IMiTsmResponse iMiTsmResponse, int i) throws RemoteException;

    void deleteAllBankCard(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void deleteBankCard(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException;

    void getActiveCards(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException;

    void getCPLC(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void getCardInfo(IMiTsmResponse iMiTsmResponse, List<String> list) throws RemoteException;

    void getCardsQuantity(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException;

    void getCardsState(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void getData(IMiTsmResponse iMiTsmResponse, String str, Bundle bundle) throws RemoteException;

    void getDefaultCard(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException;

    void getMiPayStatus(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void getSeBankCards(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void getTransCardState(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void isBankCardAvailable(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    void manageBankCard(IMiTsmResponse iMiTsmResponse, String str, int i) throws RemoteException;

    void manageVirtualSimCard(IMiTsmResponse iMiTsmResponse, String str, int i) throws RemoteException;

    void notifyPayResult(IMiTsmResponse iMiTsmResponse, Bundle bundle) throws RemoteException;

    void requestInappTransaction(IMiTsmResponse iMiTsmResponse, Bundle bundle, int i) throws RemoteException;

    void requestPin(IMiTsmResponse iMiTsmResponse, int i) throws RemoteException;

    void setDefaultCard(IMiTsmResponse iMiTsmResponse, String str, Bundle bundle) throws RemoteException;

    void syncBankCardStatus(IMiTsmResponse iMiTsmResponse) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiTsmService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.tsmclientsdk.IMiTsmService");
        }

        public static IMiTsmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclientsdk.IMiTsmService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiTsmService)) {
                return new Proxy(iBinder);
            }
            return (IMiTsmService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getCPLC(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getDefaultCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        IMiTsmResponse asInterface = IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder());
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        setDefaultCard(asInterface, readString, bundle);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        createSSD(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getCardsQuantity(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getCardInfo(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getActiveCards(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getSeBankCards(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        deleteBankCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        deleteAllBankCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        manageBankCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        isBankCardAvailable(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getTransCardState(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        syncBankCardStatus(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        addMiPayShortcut(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        manageVirtualSimCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getMiPayStatus(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        IMiTsmResponse asInterface2 = IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        requestInappTransaction(asInterface2, bundle, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        requestPin(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        IMiTsmResponse asInterface3 = IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        notifyPayResult(asInterface3, bundle);
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        addMipayCard(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        getCardsState(IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.miui.tsmclientsdk.IMiTsmService");
                        IMiTsmResponse asInterface4 = IMiTsmResponse.Stub.asInterface(parcel.readStrongBinder());
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getData(asInterface4, readString2, bundle);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.miui.tsmclientsdk.IMiTsmService");
                return true;
            }
        }

        static class Proxy implements IMiTsmService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.tsmclientsdk.IMiTsmService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void getCPLC(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDefaultCard(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDefaultCard(IMiTsmResponse iMiTsmResponse, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void createSSD(IMiTsmResponse iMiTsmResponse, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCardsQuantity(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCardInfo(IMiTsmResponse iMiTsmResponse, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeStringList(list);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getActiveCards(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getSeBankCards(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteBankCard(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteAllBankCard(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void manageBankCard(IMiTsmResponse iMiTsmResponse, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void isBankCardAvailable(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getTransCardState(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncBankCardStatus(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addMiPayShortcut(IMiTsmResponse iMiTsmResponse, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void manageVirtualSimCard(IMiTsmResponse iMiTsmResponse, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMiPayStatus(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestInappTransaction(IMiTsmResponse iMiTsmResponse, Bundle bundle, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestPin(IMiTsmResponse iMiTsmResponse, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyPayResult(IMiTsmResponse iMiTsmResponse, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addMipayCard(IMiTsmResponse iMiTsmResponse, String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getCardsState(IMiTsmResponse iMiTsmResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getData(IMiTsmResponse iMiTsmResponse, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclientsdk.IMiTsmService");
                    obtain.writeStrongBinder(iMiTsmResponse != null ? iMiTsmResponse.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
