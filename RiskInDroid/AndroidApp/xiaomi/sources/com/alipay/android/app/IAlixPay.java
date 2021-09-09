package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback;
import com.google.android.exoplayer2.C;
import java.util.Map;

public interface IAlixPay extends IInterface {
    String Pay(String str) throws RemoteException;

    void deployFastConnect() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean manager(String str) throws RemoteException;

    String pay02(String str, Map map) throws RemoteException;

    String prePay(String str) throws RemoteException;

    void r03(String str, String str2, Map map) throws RemoteException;

    void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    void registerCallback03(IRemoteServiceCallback iRemoteServiceCallback, String str, Map map) throws RemoteException;

    String test() throws RemoteException;

    void unregisterCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IAlixPay {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.alipay.android.app.IAlixPay");
        }

        public static IAlixPay asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAlixPay)) {
                return new a(iBinder);
            }
            return (IAlixPay) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        String Pay = Pay(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(Pay);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        String test = test();
                        parcel2.writeNoException();
                        parcel2.writeString(test);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        registerCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        unregisterCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        String prePay = prePay(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(prePay);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        deployFastConnect();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        boolean manager = manager(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(manager ? 1 : 0);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(version);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        String pay02 = pay02(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        parcel2.writeString(pay02);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        r03(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        return true;
                    case 11:
                        parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                        registerCallback03(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.alipay.android.app.IAlixPay");
                return true;
            }
        }

        static class a implements IAlixPay {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f3124a;

            public String a() {
                return "com.alipay.android.app.IAlixPay";
            }

            a(IBinder iBinder) {
                this.f3124a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3124a;
            }

            public String Pay(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeString(str);
                    this.f3124a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String test() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    this.f3124a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.f3124a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.f3124a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String prePay(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeString(str);
                    this.f3124a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deployFastConnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    this.f3124a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean manager(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeString(str);
                    boolean z = false;
                    this.f3124a.transact(7, obtain, obtain2, 0);
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

            public int getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    this.f3124a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String pay02(String str, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.f3124a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r03(String str, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.f3124a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void registerCallback03(IRemoteServiceCallback iRemoteServiceCallback, String str, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.f3124a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
