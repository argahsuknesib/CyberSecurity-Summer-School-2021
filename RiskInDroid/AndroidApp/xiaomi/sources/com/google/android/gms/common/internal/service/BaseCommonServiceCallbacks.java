package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.service.ICommonCallbacks;

public class BaseCommonServiceCallbacks extends ICommonCallbacks.Stub {
    public void onDefaultAccountCleared(int i) throws RemoteException {
    }
}
