package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

final class f implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f3780a;
    final /* synthetic */ Set b;
    final /* synthetic */ AtomicBoolean c;
    final /* synthetic */ l d;

    f(l lVar, r rVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = lVar;
        this.f3780a = rVar;
        this.b = set;
        this.c = atomicBoolean;
    }

    public final void a(ZipFile zipFile, Set<k> set) throws IOException {
        this.d.a(this.f3780a, set, new e(this));
    }
}
