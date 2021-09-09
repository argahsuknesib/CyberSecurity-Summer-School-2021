package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class ah extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3633a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;
    final /* synthetic */ int d;
    final /* synthetic */ as e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(as asVar, i iVar, int i, String str, i iVar2, int i2) {
        super(iVar);
        this.e = asVar;
        this.f3633a = i;
        this.b = str;
        this.c = iVar2;
        this.d = i2;
    }

    public final void a() {
        try {
            ((s) this.e.e.b()).b(this.e.c, as.c(this.f3633a, this.b), as.e(), new ap(this.e, this.c, this.f3633a, this.b, this.d));
        } catch (RemoteException e2) {
            as.f3638a.a(e2, "notifyModuleCompleted", new Object[0]);
        }
    }
}
