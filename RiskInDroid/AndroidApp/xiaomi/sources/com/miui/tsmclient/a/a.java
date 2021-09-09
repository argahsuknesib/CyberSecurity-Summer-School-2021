package com.miui.tsmclient.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface a extends IInterface {

    /* renamed from: com.miui.tsmclient.a.a$a  reason: collision with other inner class name */
    public static abstract class C0024a extends Binder implements a {

        /* renamed from: com.miui.tsmclient.a.a$a$a  reason: collision with other inner class name */
        static class C0025a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f3584a;

            C0025a(IBinder iBinder) {
                this.f3584a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3584a;
            }

            public String deleteCard(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSeid(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getServiceStatus(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String issueCard(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String preIssueCard(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String queryCardInfo(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String recharge(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.tsmclient.open.IMiTransitOpenService");
                    obtain.writeMap(map);
                    this.f3584a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0024a() {
            attachInterface(this, "com.miui.tsmclient.open.IMiTransitOpenService");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.tsmclient.open.IMiTransitOpenService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0025a(iBinder) : (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String serviceStatus;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = getServiceStatus(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 2:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = getSeid(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 3:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = preIssueCard(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 4:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = issueCard(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 5:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = recharge(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 6:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = deleteCard(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    case 7:
                        parcel.enforceInterface("com.miui.tsmclient.open.IMiTransitOpenService");
                        serviceStatus = queryCardInfo(parcel.readHashMap(getClass().getClassLoader()));
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeNoException();
                parcel2.writeString(serviceStatus);
                return true;
            }
            parcel2.writeString("com.miui.tsmclient.open.IMiTransitOpenService");
            return true;
        }
    }

    String deleteCard(Map map) throws RemoteException;

    String getSeid(Map map) throws RemoteException;

    String getServiceStatus(Map map) throws RemoteException;

    String issueCard(Map map) throws RemoteException;

    String preIssueCard(Map map) throws RemoteException;

    String queryCardInfo(Map map) throws RemoteException;

    String recharge(Map map) throws RemoteException;
}
