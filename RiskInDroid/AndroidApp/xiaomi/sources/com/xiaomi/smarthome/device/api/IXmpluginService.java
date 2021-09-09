package com.xiaomi.smarthome.device.api;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xiaomi.router.miio.miioplugin.IMessageCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;

public interface IXmpluginService extends IInterface {
    void sendMessage(PluginPackageInfo pluginPackageInfo, String str, int i, Intent intent, IMessageCallback iMessageCallback, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmpluginService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.smarthome.device.api.IXmpluginService");
        }

        public static IXmpluginService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.smarthome.device.api.IXmpluginService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmpluginService)) {
                return new Proxy(iBinder);
            }
            return (IXmpluginService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: android.content.Intent} */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.smarthome.device.api.IXmpluginService");
                Intent intent = null;
                PluginPackageInfo createFromParcel = parcel.readInt() != 0 ? PluginPackageInfo.CREATOR.createFromParcel(parcel) : null;
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    intent = Intent.CREATOR.createFromParcel(parcel);
                }
                sendMessage(createFromParcel, readString, readInt, intent, IMessageCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.xiaomi.smarthome.device.api.IXmpluginService");
                return true;
            }
        }

        static class Proxy implements IXmpluginService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.smarthome.device.api.IXmpluginService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void sendMessage(PluginPackageInfo pluginPackageInfo, String str, int i, Intent intent, IMessageCallback iMessageCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.smarthome.device.api.IXmpluginService");
                    if (pluginPackageInfo != null) {
                        obtain.writeInt(1);
                        pluginPackageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMessageCallback != null ? iMessageCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
