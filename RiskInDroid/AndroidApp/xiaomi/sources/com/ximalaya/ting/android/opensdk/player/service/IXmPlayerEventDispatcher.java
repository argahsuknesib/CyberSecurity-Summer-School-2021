package com.ximalaya.ting.android.opensdk.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public interface IXmPlayerEventDispatcher extends IInterface {
    void onBufferProgress(int i) throws RemoteException;

    void onBufferingStart() throws RemoteException;

    void onBufferingStop() throws RemoteException;

    void onError(XmPlayerException xmPlayerException) throws RemoteException;

    void onPlayPause() throws RemoteException;

    void onPlayProgress(int i, int i2) throws RemoteException;

    void onPlayStart() throws RemoteException;

    void onPlayStop() throws RemoteException;

    void onSoundPlayComplete() throws RemoteException;

    void onSoundPrepared() throws RemoteException;

    void onSoundSwitch(Track track, Track track2) throws RemoteException;

    public static abstract class Stub extends Binder implements IXmPlayerEventDispatcher {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
        }

        public static IXmPlayerEventDispatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IXmPlayerEventDispatcher)) {
                return new Proxy(iBinder);
            }
            return (IXmPlayerEventDispatcher) queryLocalInterface;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.ximalaya.ting.android.opensdk.model.track.Track} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.ximalaya.ting.android.opensdk.player.service.XmPlayerException} */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ? r3 = 0;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onPlayStart();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onPlayPause();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onPlayStop();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onSoundPlayComplete();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onSoundPrepared();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        Track createFromParcel = parcel.readInt() != 0 ? Track.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            r3 = Track.CREATOR.createFromParcel(parcel);
                        }
                        onSoundSwitch(createFromParcel, r3);
                        parcel2.writeNoException();
                        if (createFromParcel != null) {
                            parcel2.writeInt(1);
                            createFromParcel.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        if (r3 != 0) {
                            parcel2.writeInt(1);
                            r3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onBufferingStart();
                        parcel2.writeNoException();
                        return true;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onBufferingStop();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onBufferProgress(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        onPlayProgress(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                        if (parcel.readInt() != 0) {
                            r3 = XmPlayerException.CREATOR.createFromParcel(parcel);
                        }
                        onError(r3);
                        parcel2.writeNoException();
                        if (r3 != 0) {
                            parcel2.writeInt(1);
                            r3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                return true;
            }
        }

        static class Proxy implements IXmPlayerEventDispatcher {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onPlayStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSoundPlayComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSoundPrepared() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSoundSwitch(Track track, Track track2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    if (track != null) {
                        obtain.writeInt(1);
                        track.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (track2 != null) {
                        obtain.writeInt(1);
                        track2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        track.O000000o(obtain2);
                    }
                    if (obtain2.readInt() != 0) {
                        track2.O000000o(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBufferingStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBufferingStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBufferProgress(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayProgress(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(XmPlayerException xmPlayerException) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher");
                    if (xmPlayerException != null) {
                        obtain.writeInt(1);
                        xmPlayerException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        xmPlayerException.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
