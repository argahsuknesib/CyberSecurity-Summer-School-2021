package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.google.android.gms.signin.internal.ISignInCallbacks;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public interface ISignInService extends IInterface {

    public static abstract class Stub extends zzb implements ISignInService {

        public static class Proxy extends zza implements ISignInService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
            }

            public void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, authAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
            }

            public void clearAccountFromSessionStore(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
            }

            public void getCurrentAccount(ISignInCallbacks iSignInCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
            }

            public void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, checkServerAuthResult);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            public void onUploadServerAuthCode(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
            }

            public void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, recordConsentRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
            }

            public void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, resolveAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iResolveAccountCallbacks);
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
            }

            public void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, account);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
            }

            public void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iAccountAccessor);
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
            }

            public void setGamesHasBeenGreeted(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
            }

            public void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, signInRequest);
                zzc.zza(obtainAndWriteInterfaceToken, iSignInCallbacks);
                transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.ISignInService");
        }

        public static ISignInService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return queryLocalInterface instanceof ISignInService ? (ISignInService) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    authAccount((AuthAccountRequest) zzc.zza(parcel, AuthAccountRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 3:
                    onCheckServerAuthorization((CheckServerAuthResult) zzc.zza(parcel, CheckServerAuthResult.CREATOR));
                    break;
                case 4:
                    onUploadServerAuthCode(zzc.zza(parcel));
                    break;
                case 5:
                    resolveAccount((ResolveAccountRequest) zzc.zza(parcel, ResolveAccountRequest.CREATOR), IResolveAccountCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 6:
                default:
                    return false;
                case 7:
                    clearAccountFromSessionStore(parcel.readInt());
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    saveAccountToSessionStore(parcel.readInt(), (Account) zzc.zza(parcel, Account.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 9:
                    saveDefaultAccountToSharedPref(IAccountAccessor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), zzc.zza(parcel));
                    break;
                case 10:
                    recordConsent((RecordConsentRequest) zzc.zza(parcel, RecordConsentRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 11:
                    getCurrentAccount(ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    signIn((SignInRequest) zzc.zza(parcel, SignInRequest.CREATOR), ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 13:
                    setGamesHasBeenGreeted(zzc.zza(parcel));
                    break;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException;

    void clearAccountFromSessionStore(int i) throws RemoteException;

    void getCurrentAccount(ISignInCallbacks iSignInCallbacks) throws RemoteException;

    void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void onUploadServerAuthCode(boolean z) throws RemoteException;

    void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException;

    void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks) throws RemoteException;

    void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks) throws RemoteException;

    void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException;

    void setGamesHasBeenGreeted(boolean z) throws RemoteException;

    void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks) throws RemoteException;
}
