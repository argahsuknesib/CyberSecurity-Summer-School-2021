package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

final class e implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3779a;

    e(f fVar) {
        this.f3779a = fVar;
    }

    public final void a(k kVar, File file, boolean z) throws IOException {
        this.f3779a.b.add(file);
        if (!z) {
            this.f3779a.c.set(false);
        }
    }
}
