package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.Collection;
import java.util.List;

final class al extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3804a;
    final /* synthetic */ i b;
    final /* synthetic */ az c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    al(az azVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = azVar;
        this.f3804a = list;
        this.b = iVar2;
    }

    public final void a() {
        try {
            this.c.f3810a.b().d(this.c.d, az.b((Collection) this.f3804a), az.b(), new as(this.c, this.b));
        } catch (RemoteException e) {
            az.b.a(e, "deferredLanguageInstall(%s)", this.f3804a);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
