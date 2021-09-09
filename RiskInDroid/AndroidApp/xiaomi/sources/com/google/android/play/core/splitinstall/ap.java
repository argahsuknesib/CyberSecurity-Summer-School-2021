package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;

final class ap extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3808a;
    final /* synthetic */ i b;
    final /* synthetic */ az c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(az azVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = azVar;
        this.f3808a = i;
        this.b = iVar2;
    }

    public final void a() {
        try {
            this.c.f3810a.b().a(this.c.d, this.f3808a, az.b(), new aq(this.c, this.b));
        } catch (RemoteException e) {
            az.b.a(e, "cancelInstall(%d)", Integer.valueOf(this.f3808a));
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
