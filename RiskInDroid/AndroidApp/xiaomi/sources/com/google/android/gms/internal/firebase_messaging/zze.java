package com.google.android.gms.internal.firebase_messaging;

import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;

public interface zze extends IInterface {
    void send(Message message) throws RemoteException;
}
