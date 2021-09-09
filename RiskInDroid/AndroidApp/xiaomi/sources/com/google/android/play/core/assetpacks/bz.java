package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import java.util.concurrent.atomic.AtomicBoolean;

final class bz {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3669a = new aa("ExtractorLooper");
    private final cr b;
    private final bw c;
    private final dv d;
    private final df e;
    private final dj f;
    private final Cdo g;
    private final ce<x> h;
    private final cu i;
    private final AtomicBoolean j = new AtomicBoolean(false);

    bz(cr crVar, ce<x> ceVar, bw bwVar, dv dvVar, df dfVar, dj djVar, Cdo doVar, cu cuVar) {
        this.b = crVar;
        this.h = ceVar;
        this.c = bwVar;
        this.d = dvVar;
        this.e = dfVar;
        this.f = djVar;
        this.g = doVar;
        this.i = cuVar;
    }

    private final void a(int i2, Exception exc) {
        try {
            this.b.d(i2);
            this.b.a(i2);
        } catch (by unused) {
            f3669a.b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f3669a.a("Run extractor loop", new Object[0]);
        if (this.j.compareAndSet(false, true)) {
            while (true) {
                ct ctVar = null;
                try {
                    ctVar = this.i.a();
                } catch (by e2) {
                    f3669a.b("Error while getting next extraction task: %s", e2.getMessage());
                    if (e2.f3668a >= 0) {
                        this.h.a().a(e2.f3668a);
                        a(e2.f3668a, e2);
                    }
                }
                if (ctVar == null) {
                    this.j.set(false);
                    return;
                } else if (ctVar instanceof bv) {
                    try {
                        this.c.a((bv) ctVar);
                    } catch (Exception e3) {
                        f3669a.b("Error during extraction task: %s", e3.getMessage());
                        this.h.a().a(ctVar.j);
                        a(ctVar.j, e3);
                    }
                } else if (ctVar instanceof du) {
                    this.d.a((du) ctVar);
                } else if (ctVar instanceof de) {
                    this.e.a((de) ctVar);
                } else if (ctVar instanceof dh) {
                    this.f.a((dh) ctVar);
                } else if (!(ctVar instanceof dn)) {
                    f3669a.b("Unknown task type: %s", ctVar.getClass().getName());
                } else {
                    this.g.a((dn) ctVar);
                }
            }
        } else {
            f3669a.d("runLoop already looping; return", new Object[0]);
        }
    }
}
