package com.xiaomi.miplay.audioclient;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IMiPlayClientCallback extends IInterface {

    public static class Default implements IMiPlayClientCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onBtFrequencyACK(Map map) throws RemoteException {
        }

        public void onBufferStateChange(Map map) throws RemoteException {
        }

        public void onChannelsAck(Map map) throws RemoteException {
        }

        public void onDeviceConnectStateChange(String str, int i) throws RemoteException {
        }

        public void onDeviceFound(MiPlayDevice miPlayDevice) throws RemoteException {
        }

        public void onDeviceLost(String str) throws RemoteException {
        }

        public void onDeviceUpdate(MiPlayDevice miPlayDevice) throws RemoteException {
        }

        public void onDisconnectNotify(Map map) throws RemoteException {
        }

        public void onInitError() throws RemoteException {
        }

        public void onInitSuccess() throws RemoteException {
        }

        public void onMediaInfoAck(Map map) throws RemoteException {
        }

        public void onMediaInfoChange(Map map) throws RemoteException {
        }

        public void onMirrorModeAck(Map map) throws RemoteException {
        }

        public void onMirrorModeNotify(Map map) throws RemoteException {
        }

        public void onPlayStateAck(Map map) throws RemoteException {
        }

        public void onPlayStateChange(Map map) throws RemoteException {
        }

        public void onPositionAck(Map map) throws RemoteException {
        }

        public void onVolumeAck(Map map) throws RemoteException {
        }

        public void onVolumeChange(Map map) throws RemoteException {
        }
    }

    void onBtFrequencyACK(Map map) throws RemoteException;

    void onBufferStateChange(Map map) throws RemoteException;

    void onChannelsAck(Map map) throws RemoteException;

    void onDeviceConnectStateChange(String str, int i) throws RemoteException;

    void onDeviceFound(MiPlayDevice miPlayDevice) throws RemoteException;

    void onDeviceLost(String str) throws RemoteException;

    void onDeviceUpdate(MiPlayDevice miPlayDevice) throws RemoteException;

    void onDisconnectNotify(Map map) throws RemoteException;

    void onInitError() throws RemoteException;

    void onInitSuccess() throws RemoteException;

    void onMediaInfoAck(Map map) throws RemoteException;

    void onMediaInfoChange(Map map) throws RemoteException;

    void onMirrorModeAck(Map map) throws RemoteException;

    void onMirrorModeNotify(Map map) throws RemoteException;

    void onPlayStateAck(Map map) throws RemoteException;

    void onPlayStateChange(Map map) throws RemoteException;

    void onPositionAck(Map map) throws RemoteException;

    void onVolumeAck(Map map) throws RemoteException;

    void onVolumeChange(Map map) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiPlayClientCallback {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
        }

        public static IMiPlayClientCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMiPlayClientCallback)) {
                return new Proxy(iBinder);
            }
            return (IMiPlayClientCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                MiPlayDevice miPlayDevice = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onInitSuccess();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onInitError();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        if (parcel.readInt() != 0) {
                            miPlayDevice = MiPlayDevice.CREATOR.createFromParcel(parcel);
                        }
                        onDeviceFound(miPlayDevice);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        if (parcel.readInt() != 0) {
                            miPlayDevice = MiPlayDevice.CREATOR.createFromParcel(parcel);
                        }
                        onDeviceUpdate(miPlayDevice);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onDeviceLost(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onPositionAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onDeviceConnectStateChange(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onPlayStateChange(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onPlayStateAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onMediaInfoAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onMediaInfoChange(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onChannelsAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onVolumeChange(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onVolumeAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onBufferStateChange(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onMirrorModeAck(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onMirrorModeNotify(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onBtFrequencyACK(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                        onDisconnectNotify(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                return true;
            }
        }

        static class Proxy implements IMiPlayClientCallback {
            public static IMiPlayClientCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.xiaomi.miplay.audioclient.IMiPlayClientCallback";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onInitSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInitSuccess();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInitError() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onInitError();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceFound(MiPlayDevice miPlayDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    if (miPlayDevice != null) {
                        obtain.writeInt(1);
                        miPlayDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeviceFound(miPlayDevice);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceUpdate(MiPlayDevice miPlayDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    if (miPlayDevice != null) {
                        obtain.writeInt(1);
                        miPlayDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeviceUpdate(miPlayDevice);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceLost(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeviceLost(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPositionAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPositionAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceConnectStateChange(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDeviceConnectStateChange(str, i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayStateChange(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayStateChange(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayStateAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayStateAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMediaInfoAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMediaInfoAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMediaInfoChange(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMediaInfoChange(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onChannelsAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onChannelsAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onVolumeChange(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onVolumeChange(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onVolumeAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onVolumeAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBufferStateChange(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onBufferStateChange(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMirrorModeAck(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMirrorModeAck(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMirrorModeNotify(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMirrorModeNotify(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBtFrequencyACK(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onBtFrequencyACK(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDisconnectNotify(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.miplay.audioclient.IMiPlayClientCallback");
                    obtain.writeMap(map);
                    if (this.mRemote.transact(19, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDisconnectNotify(map);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMiPlayClientCallback iMiPlayClientCallback) {
            if (Proxy.sDefaultImpl != null || iMiPlayClientCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMiPlayClientCallback;
            return true;
        }

        public static IMiPlayClientCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
