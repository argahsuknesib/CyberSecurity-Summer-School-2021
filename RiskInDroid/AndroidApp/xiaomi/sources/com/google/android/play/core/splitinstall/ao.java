package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;

final class ao extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f3807a;
    final /* synthetic */ az b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(az azVar, i iVar, i iVar2) {
        super(iVar);
        this.b = azVar;
        this.f3807a = iVar2;
    }

    public final void a() {
        try {
            this.b.f3810a.b().a(this.b.d, new aw(this.b, this.f3807a));
        } catch (RemoteException e) {
            az.b.a(e, "getSessionStates", new Object[0]);
            this.f3807a.b((Exception) new RuntimeException(e));
        }
    }
}
