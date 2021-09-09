package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;

final class aw extends ay<List<SplitInstallSessionState>> {
    aw(az azVar, i<List<SplitInstallSessionState>> iVar) {
        super(azVar, iVar);
    }

    public final void a(List<Bundle> list) throws RemoteException {
        super.a(list);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(SplitInstallSessionState.a(list.get(i)));
        }
        this.f3809a.b(arrayList);
    }
}
