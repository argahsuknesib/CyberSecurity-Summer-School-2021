package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.o;
import com.google.android.play.core.tasks.i;

class h<T> extends o {

    /* renamed from: a  reason: collision with root package name */
    final aa f3616a;
    final i<T> b;
    final /* synthetic */ k c;

    h(k kVar, aa aaVar, i<T> iVar) {
        this.c = kVar;
        this.f3616a = aaVar;
        this.b = iVar;
    }

    public void a(Bundle bundle) throws RemoteException {
        this.c.f3617a.a();
        this.f3616a.c("onRequestInfo", new Object[0]);
    }

    public void b(Bundle bundle) throws RemoteException {
        this.c.f3617a.a();
        this.f3616a.c("onCompleteUpdate", new Object[0]);
    }
}
