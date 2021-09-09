package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

final class g implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Set f3781a;
    final /* synthetic */ r b;
    final /* synthetic */ l c;

    g(l lVar, Set set, r rVar) {
        this.c = lVar;
        this.f3781a = set;
        this.b = rVar;
    }

    public final void a(ZipFile zipFile, Set<k> set) throws IOException {
        this.f3781a.addAll(l.a(this.c, set, this.b, zipFile));
    }
}
