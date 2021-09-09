package com.miui.whetstone;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.InputEvent;
import com.google.android.exoplayer2.C;
import com.miui.whetstone.strategy.WhetstonePackageInfo;

public interface IWhetstone extends IInterface {
    IBinder getApplicationThread(int i) throws RemoteException;

    int getWhetstoneLevel() throws RemoteException;

    WhetstonePackageInfo getWhetstonePackage(IBinder iBinder) throws RemoteException;

    boolean injectInputEvent(InputEvent inputEvent, int i) throws RemoteException;

    boolean isNeeded(int i) throws RemoteException;

    boolean putSetting(String str, String str2, String str3) throws RemoteException;

    Bitmap screenShot(int i, int i2) throws RemoteException;

    void setWhetstoneLevel(int i) throws RemoteException;

    void wifiSmartConfigStartAsync(String str, String str2, String str3, String str4, String str5, IBinder iBinder) throws RemoteException;

    void wifiSmartConfigStop() throws RemoteException;

    boolean wifiSmartConfigSupport() throws RemoteException;

    public static abstract class Stub extends Binder implements IWhetstone {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.miui.whetstone.IWhetstone");
        }

        public static IWhetstone asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.whetstone.IWhetstone");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWhetstone)) {
                return new Proxy(iBinder);
            }
            return (IWhetstone) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.InputEvent] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ? r0 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        boolean isNeeded = isNeeded(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(isNeeded);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        setWhetstoneLevel(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        int whetstoneLevel = getWhetstoneLevel();
                        parcel2.writeNoException();
                        parcel2.writeInt(whetstoneLevel);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        if (parcel.readInt() > 0) {
                            r0 = parcel.readStrongBinder();
                        }
                        WhetstonePackageInfo whetstonePackage = getWhetstonePackage(r0);
                        parcel2.writeNoException();
                        if (whetstonePackage != null) {
                            parcel2.writeInt(1);
                            whetstonePackage.writeToParcel(parcel2, 0);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        IBinder applicationThread = getApplicationThread(parcel.readInt());
                        parcel2.writeNoException();
                        if (applicationThread != null) {
                            parcel2.writeInt(1);
                            parcel2.writeStrongBinder(applicationThread);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        wifiSmartConfigStartAsync(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readStrongBinder());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        wifiSmartConfigStop();
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        boolean wifiSmartConfigSupport = wifiSmartConfigSupport();
                        parcel2.writeNoException();
                        parcel2.writeInt(wifiSmartConfigSupport);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        Bitmap screenShot = screenShot(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (screenShot != null) {
                            parcel2.writeInt(1);
                            screenShot.writeToParcel(parcel2, 0);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        if (parcel.readInt() != 0) {
                            r0 = (InputEvent) InputEvent.CREATOR.createFromParcel(parcel);
                        }
                        boolean injectInputEvent = injectInputEvent(r0, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(injectInputEvent);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.miui.whetstone.IWhetstone");
                        boolean putSetting = putSetting(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(putSetting);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.miui.whetstone.IWhetstone");
                return true;
            }
        }

        static class Proxy implements IWhetstone {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.miui.whetstone.IWhetstone";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean isNeeded(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setWhetstoneLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getWhetstoneLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public WhetstonePackageInfo getWhetstonePackage(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    if (iBinder != null) {
                        obtain.writeInt(1);
                        obtain.writeStrongBinder(iBinder);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (WhetstonePackageInfo) WhetstonePackageInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder getApplicationThread(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? obtain2.readStrongBinder() : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void wifiSmartConfigStartAsync(String str, String str2, String str3, String str4, String str5, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(6, obtain, obtain2, 1);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void wifiSmartConfigStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean wifiSmartConfigSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    boolean z = false;
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bitmap screenShot(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() == 1 ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean injectInputEvent(InputEvent inputEvent, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    boolean z = true;
                    if (inputEvent != null) {
                        obtain.writeInt(1);
                        inputEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean putSetting(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.whetstone.IWhetstone");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    boolean z = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
