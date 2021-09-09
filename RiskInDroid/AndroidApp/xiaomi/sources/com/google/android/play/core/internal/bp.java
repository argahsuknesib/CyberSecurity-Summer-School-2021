package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface bp extends IInterface {
    void a(String str, int i, Bundle bundle, br brVar) throws RemoteException;

    void a(String str, int i, br brVar) throws RemoteException;

    void a(String str, br brVar) throws RemoteException;

    void a(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException;

    void b(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException;

    void c(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException;

    void d(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException;

    void e(String str, List<Bundle> list, Bundle bundle, br brVar) throws RemoteException;
}
