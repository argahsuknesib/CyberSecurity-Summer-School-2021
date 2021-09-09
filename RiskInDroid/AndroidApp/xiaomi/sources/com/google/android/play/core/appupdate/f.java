package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;

final class f extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3614a;
    final /* synthetic */ i b;
    final /* synthetic */ k c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(k kVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = kVar;
        this.f3614a = str;
        this.b = iVar2;
    }

    public final void a() {
        try {
            this.c.f3617a.b().a(this.c.d, k.a(this.c, this.f3614a), new j(this.c, this.b, this.f3614a));
        } catch (RemoteException e) {
            k.b.a(e, "requestUpdateInfo(%s)", this.f3614a);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
