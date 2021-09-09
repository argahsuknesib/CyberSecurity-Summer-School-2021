package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.tasks.i;

final class aj extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3635a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ i e;
    final /* synthetic */ as f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(as asVar, i iVar, int i, String str, String str2, int i2, i iVar2) {
        super(iVar);
        this.f = asVar;
        this.f3635a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = iVar2;
    }

    public final void a() {
        try {
            ((s) this.f.e.b()).d(this.f.c, as.c(this.f3635a, this.b, this.c, this.d), as.e(), new am(this.f, this.e));
        } catch (RemoteException e2) {
            as.f3638a.b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.b, this.c, Integer.valueOf(this.d), Integer.valueOf(this.f3635a));
            this.e.b((Exception) new RuntimeException(e2));
        }
    }
}
