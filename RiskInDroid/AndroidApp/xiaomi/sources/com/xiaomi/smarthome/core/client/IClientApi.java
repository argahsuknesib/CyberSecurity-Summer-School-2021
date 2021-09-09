package com.xiaomi.smarthome.core.client;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.core.entity.message.CoreMessageType;
import com.xiaomi.smarthome.core.server.IServerCallback;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IClientApi extends IInterface {
    void onAccountReady(boolean z, String str) throws RemoteException;

    void onActivityResume(int i, int i2, String str) throws RemoteException;

    void onBleCharacterChanged(Bundle bundle) throws RemoteException;

    void onCoreMessage(CoreMessageType coreMessageType, Bundle bundle) throws RemoteException;

    void onCoreReady() throws RemoteException;

    void onGlobalDynamicSettingReady() throws RemoteException;

    void onLocaleChanged(Bundle bundle, Bundle bundle2) throws RemoteException;

    void onPluginChanged(boolean z, boolean z2, String str) throws RemoteException;

    void onPluginReady() throws RemoteException;

    void onServerChanged(ServerBean serverBean, ServerBean serverBean2) throws RemoteException;

    void onStatisticReady() throws RemoteException;

    void onUnAuthorized() throws RemoteException;

    void refreshServiceToken(String str, String str2, boolean z, String str3, IServerCallback iServerCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IClientApi {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.core.client.IClientApi");
        }

        public static IClientApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.core.client.IClientApi");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IClientApi)) {
                return new Proxy(iBinder);
            }
            return (IClientApi) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.xiaomi.smarthome.frame.server_compact.ServerBean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.os.Bundle} */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                ? r3 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onAccountReady(z, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onGlobalDynamicSettingReady();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onStatisticReady();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onPluginReady();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onCoreReady();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        refreshServiceToken(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), IServerCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onUnAuthorized();
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        CoreMessageType createFromParcel = parcel.readInt() != 0 ? CoreMessageType.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onCoreMessage(createFromParcel, r3);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        ServerBean createFromParcel2 = parcel.readInt() != 0 ? ServerBean.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r3 = ServerBean.CREATOR.createFromParcel(parcel);
                        }
                        onServerChanged(createFromParcel2, r3);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onLocaleChanged(bundle, r3);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        boolean z2 = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onPluginChanged(z2, z, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        onActivityResume(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.xiaomi.smarthome.core.client.IClientApi");
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onBleCharacterChanged(r3);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.smarthome.core.client.IClientApi");
                return true;
            }
        }

        static class Proxy implements IClientApi {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.core.client.IClientApi";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onAccountReady(boolean z, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onGlobalDynamicSettingReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStatisticReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPluginReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCoreReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void refreshServiceToken(String str, String str2, boolean z, String str3, IServerCallback iServerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iServerCallback != null ? iServerCallback.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onUnAuthorized() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCoreMessage(CoreMessageType coreMessageType, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    if (coreMessageType != null) {
                        obtain.writeInt(1);
                        coreMessageType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onServerChanged(ServerBean serverBean, ServerBean serverBean2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    if (serverBean != null) {
                        obtain.writeInt(1);
                        serverBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (serverBean2 != null) {
                        obtain.writeInt(1);
                        serverBean2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLocaleChanged(Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPluginChanged(boolean z, boolean z2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    int i = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onActivityResume(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBleCharacterChanged(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.core.client.IClientApi");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
