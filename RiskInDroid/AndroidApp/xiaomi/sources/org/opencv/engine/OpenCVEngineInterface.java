package org.opencv.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface OpenCVEngineInterface extends IInterface {
    int getEngineVersion() throws RemoteException;

    String getLibPathByVersion(String str) throws RemoteException;

    String getLibraryList(String str) throws RemoteException;

    boolean installVersion(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements OpenCVEngineInterface {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "org.opencv.engine.OpenCVEngineInterface");
        }

        public static OpenCVEngineInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.opencv.engine.OpenCVEngineInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof OpenCVEngineInterface)) {
                return new Proxy(iBinder);
            }
            return (OpenCVEngineInterface) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                int engineVersion = getEngineVersion();
                parcel2.writeNoException();
                parcel2.writeInt(engineVersion);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                String libPathByVersion = getLibPathByVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libPathByVersion);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                boolean installVersion = installVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(installVersion ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                String libraryList = getLibraryList(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libraryList);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("org.opencv.engine.OpenCVEngineInterface");
                return true;
            }
        }

        static class Proxy implements OpenCVEngineInterface {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "org.opencv.engine.OpenCVEngineInterface";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int getEngineVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getLibPathByVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean installVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public String getLibraryList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
