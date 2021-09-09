package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;
import java.util.Collection;
import java.util.List;

final class ad extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3629a;
    final /* synthetic */ i b;
    final /* synthetic */ as c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(as asVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = asVar;
        this.f3629a = list;
        this.b = iVar2;
    }

    public final void a() {
        try {
            ((s) this.c.e.b()).b(this.c.c, as.a((Collection) this.f3629a), as.e(), new al(this.c, this.b, (byte[]) null));
        } catch (RemoteException e) {
            as.f3638a.a(e, "cancelDownloads(%s)", this.f3629a);
        }
    }
}
