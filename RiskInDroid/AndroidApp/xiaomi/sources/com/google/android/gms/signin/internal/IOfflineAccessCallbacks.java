package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.google.android.gms.signin.internal.ISignInService;
import java.util.List;

public interface IOfflineAccessCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements IOfflineAccessCallbacks {

        public static class Proxy extends zza implements IOfflineAccessCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            }

            public void checkServerAuthorization(String str, List<Scope> list, ISignInService iSignInService) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeTypedList(list);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInService);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
            }

            public void uploadServerAuthCode(String str, String str2, ISignInService iSignInService) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeString(str2);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInService);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
        }

        public static IOfflineAccessCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            return queryLocalInterface instanceof IOfflineAccessCallbacks ? (IOfflineAccessCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                checkServerAuthorization(parcel.readString(), parcel.createTypedArrayList(Scope.CREATOR), ISignInService.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i != 3) {
                return false;
            } else {
                uploadServerAuthCode(parcel.readString(), parcel.readString(), ISignInService.Stub.asInterface(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void checkServerAuthorization(String str, List<Scope> list, ISignInService iSignInService) throws RemoteException;

    void uploadServerAuthCode(String str, String str2, ISignInService iSignInService) throws RemoteException;
}
