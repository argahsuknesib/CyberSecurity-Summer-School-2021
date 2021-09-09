package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.ISignInCallbacks;

public class BaseSignInCallbacks extends ISignInCallbacks.Stub {
    public void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException {
    }

    public void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException {
    }

    public void onRecordConsentComplete(Status status) throws RemoteException {
    }

    public void onSaveAccountToSessionStoreComplete(Status status) throws RemoteException {
    }

    public void onSignInComplete(SignInResponse signInResponse) throws RemoteException {
    }
}
