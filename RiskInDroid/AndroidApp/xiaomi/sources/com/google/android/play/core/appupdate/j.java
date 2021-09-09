package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.tasks.i;

final class j extends h<AppUpdateInfo> {
    final /* synthetic */ k d;
    private final String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(k kVar, i<AppUpdateInfo> iVar, String str) {
        super(kVar, new aa("OnRequestInstallCallback"), iVar);
        this.d = kVar;
        this.e = str;
    }

    public final void a(Bundle bundle) throws RemoteException {
        super.a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.b.b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.b.b(k.a(this.d, bundle, this.e));
        }
    }
}
