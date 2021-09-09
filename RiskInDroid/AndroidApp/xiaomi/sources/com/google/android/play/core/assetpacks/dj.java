package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ce;
import java.io.File;
import java.util.concurrent.Executor;

final class dj {

    /* renamed from: a  reason: collision with root package name */
    private final bc f3704a;
    private final ce<x> b;
    private final cr c;
    private final ce<Executor> d;
    private final cb e;

    dj(bc bcVar, ce<x> ceVar, cr crVar, ce<Executor> ceVar2, cb cbVar) {
        this.f3704a = bcVar;
        this.b = ceVar;
        this.c = crVar;
        this.d = ceVar2;
        this.e = cbVar;
    }

    public final void a(dh dhVar) {
        File c2 = this.f3704a.c(dhVar.k, dhVar.f3702a, dhVar.b);
        File e2 = this.f3704a.e(dhVar.k, dhVar.f3702a, dhVar.b);
        if (!c2.exists() || !e2.exists()) {
            throw new by(String.format("Cannot find pack files to move for pack %s.", dhVar.k), dhVar.j);
        }
        File a2 = this.f3704a.a(dhVar.k, dhVar.f3702a, dhVar.b);
        a2.mkdirs();
        if (c2.renameTo(a2)) {
            new File(this.f3704a.a(dhVar.k, dhVar.f3702a, dhVar.b), "merge.tmp").delete();
            File b2 = this.f3704a.b(dhVar.k, dhVar.f3702a, dhVar.b);
            b2.mkdirs();
            if (e2.renameTo(b2)) {
                bc bcVar = this.f3704a;
                bcVar.getClass();
                this.d.a().execute(di.a(bcVar));
                this.c.a(dhVar.k, dhVar.f3702a, dhVar.b);
                this.e.a(dhVar.k);
                this.b.a().a(dhVar.j, dhVar.k);
                return;
            }
            throw new by("Cannot move metadata files to final location.", dhVar.j);
        }
        throw new by("Cannot move merged pack files to final location.", dhVar.j);
    }
}
