package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class ag extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3632a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ i e;
    final /* synthetic */ as f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ag(as asVar, i iVar, int i, String str, String str2, int i2, i iVar2) {
        super(iVar);
        this.f = asVar;
        this.f3632a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = iVar2;
    }

    public final void a() {
        try {
            ((s) this.f.e.b()).a(this.f.c, as.c(this.f3632a, this.b, this.c, this.d), as.e(), new al(this.f, this.e, (char[]) null));
        } catch (RemoteException e2) {
            as.f3638a.a(e2, "notifyChunkTransferred", new Object[0]);
        }
    }
}
