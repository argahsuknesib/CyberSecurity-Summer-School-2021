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

final class af extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3631a;
    final /* synthetic */ Map b;
    final /* synthetic */ i c;
    final /* synthetic */ ba d;
    final /* synthetic */ as e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(as asVar, i iVar, List list, Map map, i iVar2, ba baVar) {
        super(iVar);
        this.e = asVar;
        this.f3631a = list;
        this.b = map;
        this.c = iVar2;
        this.d = baVar;
    }

    public final void a() {
        ArrayList a2 = as.a((Collection) this.f3631a);
        try {
            String a3 = this.e.c;
            Bundle b2 = as.b(this.b);
            as asVar = this.e;
            ((s) this.e.e.b()).c(a3, a2, b2, new aq(asVar, this.c, asVar.d, this.d));
        } catch (RemoteException e2) {
            as.f3638a.a(e2, "getPackStates(%s)", this.f3631a);
            this.c.b((Exception) new RuntimeException(e2));
        }
    }
}
