package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.Collection;
import java.util.List;

final class ak extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3803a;
    final /* synthetic */ i b;
    final /* synthetic */ az c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(az azVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = azVar;
        this.f3803a = list;
        this.b = iVar2;
    }

    public final void a() {
        try {
            this.c.f3810a.b().c(this.c.d, az.a((Collection) this.f3803a), az.b(), new ar(this.c, this.b));
        } catch (RemoteException e) {
            az.b.a(e, "deferredInstall(%s)", this.f3803a);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
