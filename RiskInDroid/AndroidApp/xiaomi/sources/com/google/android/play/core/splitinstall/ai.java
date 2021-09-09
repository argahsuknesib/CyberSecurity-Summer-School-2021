package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;

final class ai extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f3801a;
    final /* synthetic */ Collection b;
    final /* synthetic */ i c;
    final /* synthetic */ az d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(az azVar, i iVar, Collection collection, Collection collection2, i iVar2) {
        super(iVar);
        this.d = azVar;
        this.f3801a = collection;
        this.b = collection2;
        this.c = iVar2;
    }

    public final void a() {
        ArrayList a2 = az.a(this.f3801a);
        a2.addAll(az.b(this.b));
        try {
            this.d.f3810a.b().a(this.d.d, a2, az.b(), new ax(this.d, this.c));
        } catch (RemoteException e) {
            az.b.a(e, "startInstall(%s,%s)", this.f3801a, this.b);
            this.c.b((Exception) new RuntimeException(e));
        }
    }
}
