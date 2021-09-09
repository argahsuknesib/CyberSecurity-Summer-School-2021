package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class ai extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3634a;
    final /* synthetic */ i b;
    final /* synthetic */ as c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(as asVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = asVar;
        this.f3634a = i;
        this.b = iVar2;
    }

    public final void a() {
        try {
            ((s) this.c.e.b()).c(this.c.c, as.c(this.f3634a), as.e(), new al(this.c, this.b, (int[]) null));
        } catch (RemoteException e) {
            as.f3638a.a(e, "notifySessionFailed", new Object[0]);
        }
    }
}
