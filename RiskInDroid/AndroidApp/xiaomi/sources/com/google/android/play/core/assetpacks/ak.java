package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class ak extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f3636a;
    final /* synthetic */ as b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(as asVar, i iVar, i iVar2) {
        super(iVar);
        this.b = asVar;
        this.f3636a = iVar2;
    }

    public final void a() {
        try {
            ((s) this.b.f.b()).b(this.b.c, as.e(), new ao(this.b, this.f3636a));
        } catch (RemoteException e) {
            as.f3638a.a(e, "keepAlive", new Object[0]);
        }
    }
}
