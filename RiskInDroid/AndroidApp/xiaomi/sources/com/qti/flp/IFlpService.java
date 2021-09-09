package com.qti.flp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.qti.flp.ILocationCallback;
import com.qti.flp.ISessionStatusCallback;

public interface IFlpService extends IInterface {

    public static class Default implements IFlpService {
        public IBinder asBinder() {
            return null;
        }

        public int getAllSupportedFeatures() throws RemoteException {
            return 0;
        }

        public int pullLocations(ILocationCallback iLocationCallback, long j, int i) throws RemoteException {
            return 0;
        }

        public void registerCallback(int i, int i2, ILocationCallback iLocationCallback, long j) throws RemoteException {
        }

        public void registerForSessionStatus(int i, ISessionStatusCallback iSessionStatusCallback) throws RemoteException {
        }

        public int startFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException {
            return 0;
        }

        public int startFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException {
            return 0;
        }

        public int stopFlpSession(int i) throws RemoteException {
            return 0;
        }

        public void unregisterCallback(int i, ILocationCallback iLocationCallback) throws RemoteException {
        }

        public void unregisterForSessionStatus(ISessionStatusCallback iSessionStatusCallback) throws RemoteException {
        }

        public int updateFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException {
            return 0;
        }

        public int updateFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException {
            return 0;
        }
    }

    int getAllSupportedFeatures() throws RemoteException;

    int pullLocations(ILocationCallback iLocationCallback, long j, int i) throws RemoteException;

    void registerCallback(int i, int i2, ILocationCallback iLocationCallback, long j) throws RemoteException;

    void registerForSessionStatus(int i, ISessionStatusCallback iSessionStatusCallback) throws RemoteException;

    int startFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException;

    int startFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException;

    int stopFlpSession(int i) throws RemoteException;

    void unregisterCallback(int i, ILocationCallback iLocationCallback) throws RemoteException;

    void unregisterForSessionStatus(ISessionStatusCallback iSessionStatusCallback) throws RemoteException;

    int updateFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException;

    int updateFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException;

    public static abstract class Stub extends Binder implements IFlpService {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.qti.flp.IFlpService");
        }

        public static IFlpService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qti.flp.IFlpService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IFlpService)) {
                return new Proxy(iBinder);
            }
            return (IFlpService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        registerCallback(parcel.readInt(), parcel.readInt(), ILocationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        unregisterCallback(parcel.readInt(), ILocationCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int allSupportedFeatures = getAllSupportedFeatures();
                        parcel2.writeNoException();
                        parcel4.writeInt(allSupportedFeatures);
                        return true;
                    case 4:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int startFlpSession = startFlpSession(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel4.writeInt(startFlpSession);
                        return true;
                    case 5:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int updateFlpSession = updateFlpSession(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel4.writeInt(updateFlpSession);
                        return true;
                    case 6:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int stopFlpSession = stopFlpSession(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(stopFlpSession);
                        return true;
                    case 7:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int pullLocations = pullLocations(ILocationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(pullLocations);
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        registerForSessionStatus(parcel.readInt(), ISessionStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        unregisterForSessionStatus(ISessionStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int startFlpSessionWithPower = startFlpSessionWithPower(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel4.writeInt(startFlpSessionWithPower);
                        return true;
                    case 11:
                        parcel3.enforceInterface("com.qti.flp.IFlpService");
                        int updateFlpSessionWithPower = updateFlpSessionWithPower(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel4.writeInt(updateFlpSessionWithPower);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString("com.qti.flp.IFlpService");
                return true;
            }
        }

        static class Proxy implements IFlpService {
            public static IFlpService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.qti.flp.IFlpService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void registerCallback(int i, int i2, ILocationCallback iLocationCallback, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iLocationCallback != null ? iLocationCallback.asBinder() : null);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback(i, i2, iLocationCallback, j);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallback(int i, ILocationCallback iLocationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iLocationCallback != null ? iLocationCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallback(i, iLocationCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAllSupportedFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllSupportedFeatures();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    int i4 = i;
                    obtain.writeInt(i);
                    int i5 = i2;
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    try {
                        if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            int readInt = obtain2.readInt();
                            obtain2.recycle();
                            obtain.recycle();
                            return readInt;
                        }
                        int startFlpSession = Stub.getDefaultImpl().startFlpSession(i, i2, j, i3, j2);
                        obtain2.recycle();
                        obtain.recycle();
                        return startFlpSession;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public int updateFlpSession(int i, int i2, long j, int i3, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    int i4 = i;
                    obtain.writeInt(i);
                    int i5 = i2;
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    try {
                        if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            int readInt = obtain2.readInt();
                            obtain2.recycle();
                            obtain.recycle();
                            return readInt;
                        }
                        int updateFlpSession = Stub.getDefaultImpl().updateFlpSession(i, i2, j, i3, j2);
                        obtain2.recycle();
                        obtain.recycle();
                        return updateFlpSession;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public int stopFlpSession(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopFlpSession(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int pullLocations(ILocationCallback iLocationCallback, long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeStrongBinder(iLocationCallback != null ? iLocationCallback.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pullLocations(iLocationCallback, j, i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerForSessionStatus(int i, ISessionStatusCallback iSessionStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iSessionStatusCallback != null ? iSessionStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerForSessionStatus(i, iSessionStatusCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterForSessionStatus(ISessionStatusCallback iSessionStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeStrongBinder(iSessionStatusCallback != null ? iSessionStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterForSessionStatus(iSessionStatusCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    obtain.writeInt(i4);
                    obtain.writeLong(j3);
                    try {
                        if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            int readInt = obtain2.readInt();
                            obtain2.recycle();
                            obtain.recycle();
                            return readInt;
                        }
                        int startFlpSessionWithPower = Stub.getDefaultImpl().startFlpSessionWithPower(i, i2, j, i3, j2, i4, j3);
                        obtain2.recycle();
                        obtain.recycle();
                        return startFlpSessionWithPower;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public int updateFlpSessionWithPower(int i, int i2, long j, int i3, long j2, int i4, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qti.flp.IFlpService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    obtain.writeInt(i4);
                    obtain.writeLong(j3);
                    try {
                        if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            int readInt = obtain2.readInt();
                            obtain2.recycle();
                            obtain.recycle();
                            return readInt;
                        }
                        int updateFlpSessionWithPower = Stub.getDefaultImpl().updateFlpSessionWithPower(i, i2, j, i3, j2, i4, j3);
                        obtain2.recycle();
                        obtain.recycle();
                        return updateFlpSessionWithPower;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static boolean setDefaultImpl(IFlpService iFlpService) {
            if (Proxy.sDefaultImpl != null || iFlpService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iFlpService;
            return true;
        }

        public static IFlpService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
