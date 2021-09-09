package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class ac extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3628a;
    final /* synthetic */ Map b;
    final /* synthetic */ i c;
    final /* synthetic */ List d;
    final /* synthetic */ as e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ac(as asVar, i iVar, List list, Map map, i iVar2, List list2) {
        super(iVar);
        this.e = asVar;
        this.f3628a = list;
        this.b = map;
        this.c = iVar2;
        this.d = list2;
    }

    public final void a() {
        ArrayList a2 = as.a((Collection) this.f3628a);
        try {
            String a3 = this.e.c;
            Bundle b2 = as.b(this.b);
            as asVar = this.e;
            ((s) this.e.e.b()).a(a3, a2, b2, new ar(asVar, this.c, asVar.d, this.d));
        } catch (RemoteException e2) {
            as.f3638a.a(e2, "startDownload(%s)", this.f3628a);
            this.c.b((Exception) new RuntimeException(e2));
        }
    }
}
