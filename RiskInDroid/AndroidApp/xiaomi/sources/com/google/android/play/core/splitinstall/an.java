package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;

final class an extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3806a;
    final /* synthetic */ i b;
    final /* synthetic */ az c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(az azVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = azVar;
        this.f3806a = i;
        this.b = iVar2;
    }

    public final void a() {
        try {
            this.c.f3810a.b().a(this.c.d, this.f3806a, new av(this.c, this.b));
        } catch (RemoteException e) {
            az.b.a(e, "getSessionState(%d)", Integer.valueOf(this.f3806a));
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
