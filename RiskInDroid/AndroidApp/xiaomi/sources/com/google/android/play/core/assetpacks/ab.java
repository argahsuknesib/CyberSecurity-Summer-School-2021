package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class ab extends com.google.android.play.core.internal.ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3627a;
    final /* synthetic */ i b;
    final /* synthetic */ as c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ab(as asVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = asVar;
        this.f3627a = str;
        this.b = iVar2;
    }

    public final void a() {
        try {
            ((s) this.c.e.b()).e(this.c.c, as.c(0, this.f3627a), as.e(), new al(this.c, this.b, (short[]) null));
        } catch (RemoteException e) {
            as.f3638a.a(e, "removePack(%s)", this.f3627a);
        }
    }
}
