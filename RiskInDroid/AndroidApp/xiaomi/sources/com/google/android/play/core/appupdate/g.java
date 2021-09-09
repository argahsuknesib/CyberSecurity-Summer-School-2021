package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;

final class g extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f3615a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(k kVar, i iVar, i iVar2, String str) {
        super(iVar);
        this.c = kVar;
        this.f3615a = iVar2;
        this.b = str;
    }

    public final void a() {
        try {
            this.c.f3617a.b().b(this.c.d, k.d(), new i(this.c, this.f3615a));
        } catch (RemoteException e) {
            k.b.a(e, "completeUpdate(%s)", this.b);
            this.f3615a.b((Exception) new RuntimeException(e));
        }
    }
}
