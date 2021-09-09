package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;
import java.util.Map;

final class ae extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f3630a;
    final /* synthetic */ i b;
    final /* synthetic */ as c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(as asVar, i iVar, Map map, i iVar2) {
        super(iVar);
        this.c = asVar;
        this.f3630a = map;
        this.b = iVar2;
    }

    public final void a() {
        try {
            ((s) this.c.e.b()).a(this.c.c, as.b(this.f3630a), new an(this.c, this.b));
        } catch (RemoteException e) {
            as.f3638a.a(e, "syncPacks", new Object[0]);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
