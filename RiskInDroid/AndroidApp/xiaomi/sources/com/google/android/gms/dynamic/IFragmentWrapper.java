package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {

        public static class Proxy extends zza implements IFragmentWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public IObjectWrapper getActivity() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public Bundle getArguments() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                Bundle bundle = (Bundle) zzc.zza(transactAndReadException, Bundle.CREATOR);
                transactAndReadException.recycle();
                return bundle;
            }

            public int getId() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public IFragmentWrapper getParentFragment() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IObjectWrapper getResources() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean getRetainInstance() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public String getTag() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                String readString = transactAndReadException.readString();
                transactAndReadException.recycle();
                return readString;
            }

            public IFragmentWrapper getTargetFragment() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public boolean getUserVisibleHint() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public IObjectWrapper getView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean isAdded() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isDetached() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isHidden() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isInLayout() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isRemoving() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isResumed() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isVisible() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public void registerForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(20, obtainAndWriteInterfaceToken);
            }

            public void setHasOptionsMenu(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(21, obtainAndWriteInterfaceToken);
            }

            public void setMenuVisibility(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(22, obtainAndWriteInterfaceToken);
            }

            public void setRetainInstance(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(23, obtainAndWriteInterfaceToken);
            }

            public void setUserVisibleHint(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(24, obtainAndWriteInterfaceToken);
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, intent);
                transactAndReadExceptionReturnVoid(25, obtainAndWriteInterfaceToken);
            }

            public void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, intent);
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(26, obtainAndWriteInterfaceToken);
            }

            public void unregisterForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(27, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IInterface iInterface;
            int i3;
            boolean z;
            switch (i) {
                case 2:
                    iInterface = getActivity();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, iInterface);
                    return true;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    return true;
                case 4:
                    i3 = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    iInterface = getParentFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, iInterface);
                    return true;
                case 6:
                    iInterface = getResources();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, iInterface);
                    return true;
                case 7:
                    z = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                case 9:
                    iInterface = getTargetFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, iInterface);
                    return true;
                case 10:
                    i3 = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    z = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    iInterface = getView();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, iInterface);
                    return true;
                case 13:
                    z = isAdded();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 14:
                    z = isDetached();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    z = isHidden();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 16:
                    z = isInLayout();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 17:
                    z = isRemoving();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 18:
                    z = isResumed();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 19:
                    z = isVisible();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, z);
                    return true;
                case 20:
                    registerForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    startActivity((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    unregisterForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    IObjectWrapper getActivity() throws RemoteException;

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    IFragmentWrapper getParentFragment() throws RemoteException;

    IObjectWrapper getResources() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    IFragmentWrapper getTargetFragment() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void registerForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void unregisterForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException;
}
