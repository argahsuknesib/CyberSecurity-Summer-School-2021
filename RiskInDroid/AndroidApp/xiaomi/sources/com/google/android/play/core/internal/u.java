package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface u extends IInterface {
    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, Bundle bundle) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(Bundle bundle, Bundle bundle2) throws RemoteException;

    void a(List<Bundle> list) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void b(Bundle bundle, Bundle bundle2) throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void c(Bundle bundle, Bundle bundle2) throws RemoteException;

    void d(Bundle bundle) throws RemoteException;
}
