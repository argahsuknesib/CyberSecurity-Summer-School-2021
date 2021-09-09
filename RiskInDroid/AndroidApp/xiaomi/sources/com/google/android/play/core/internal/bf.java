package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

final class bf implements ap {
    bf() {
    }

    static void b(ClassLoader classLoader, Set<File> set) {
        ba.a(classLoader, set, new bd());
    }

    static boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return av.a(classLoader, file, file2, z, ba.a(), "path", new be());
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return b(classLoader, file, file2, z);
    }
}
