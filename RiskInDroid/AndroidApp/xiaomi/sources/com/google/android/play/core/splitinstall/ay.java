package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bq;
import com.google.android.play.core.tasks.i;
import java.util.List;

class ay<T> extends bq {

    /* renamed from: a  reason: collision with root package name */
    final i<T> f3809a;
    final /* synthetic */ az b;

    ay(az azVar, i<T> iVar) {
        this.b = azVar;
        this.f3809a = iVar;
    }

    public final void a() throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    public final void a(int i) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    public void a(int i, Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    public void a(Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onDeferredInstall", new Object[0]);
    }

    public void a(List<Bundle> list) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onGetSessionStates", new Object[0]);
    }

    public final void b() throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onGetSplitsForAppUpdate", new Object[0]);
    }

    public void b(int i, Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onGetSession(%d)", Integer.valueOf(i));
    }

    public void b(Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onDeferredLanguageInstall", new Object[0]);
    }

    public void c(int i, Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onStartInstall(%d)", Integer.valueOf(i));
    }

    public void c(Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onDeferredLanguageUninstall", new Object[0]);
    }

    public void d(Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        az.b.c("onDeferredUninstall", new Object[0]);
    }

    public final void e(Bundle bundle) throws RemoteException {
        this.b.f3810a.a();
        int i = bundle.getInt("error_code");
        az.b.b("onError(%d)", Integer.valueOf(i));
        this.f3809a.b((Exception) new SplitInstallException(i));
    }
}
