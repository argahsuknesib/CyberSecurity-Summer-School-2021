package com.miui.tsmclientsdk.internal;

import android.os.Bundle;
import android.os.RemoteException;

public interface ITaskResponse {
    String getId() throws RemoteException;

    void onError(int i, String str) throws RemoteException;

    void onProgress(int i) throws RemoteException;

    void onResult(Bundle bundle) throws RemoteException;
}
