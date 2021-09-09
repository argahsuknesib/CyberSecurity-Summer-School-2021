package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class av extends ay<SplitInstallSessionState> {
    av(az azVar, i<SplitInstallSessionState> iVar) {
        super(azVar, iVar);
    }

    public final void b(int i, Bundle bundle) throws RemoteException {
        super.b(i, bundle);
        this.f3809a.b(SplitInstallSessionState.a(bundle));
    }
}
