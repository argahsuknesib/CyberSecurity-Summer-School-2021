package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

final class aw implements ap {
    aw() {
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        av.b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return av.a(classLoader, file, file2, z, av.a(), "zip", av.b());
    }
}
