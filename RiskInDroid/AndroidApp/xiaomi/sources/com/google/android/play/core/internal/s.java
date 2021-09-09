package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface s extends IInterface {
    void a(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException;

    void a(String str, Bundle bundle, u uVar) throws RemoteException;

    void a(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException;

    void b(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException;

    void b(String str, Bundle bundle, u uVar) throws RemoteException;

    void b(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException;

    void c(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException;

    void c(String str, List<Bundle> list, Bundle bundle, u uVar) throws RemoteException;

    void d(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException;

    void e(String str, Bundle bundle, Bundle bundle2, u uVar) throws RemoteException;
}
