package com.google.android.play.core.internal;

import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class ba implements ap {
    ba() {
    }

    static au a() {
        return new ax();
    }

    public static void a(ClassLoader classLoader, Set<File> set, az azVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a2 = av.a(classLoader);
            bk a3 = bl.a(a2, "nativeLibraryDirectories", List.class);
            synchronized (v.class) {
                ArrayList arrayList = new ArrayList((Collection) a3.a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                a3.a((Object) arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a4 = azVar.a(a2, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                bj bjVar = new bj("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    cd.a(bjVar, (IOException) arrayList2.get(i));
                }
                throw bjVar;
            }
            synchronized (v.class) {
                bl.b(a2, "nativeLibraryPathElements", Object.class).b(Arrays.asList(a4));
            }
        }
    }

    public static boolean a(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return av.a(classLoader, file, file2, z, a(), str, av.b());
    }

    static az b() {
        return new ay();
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        a(classLoader, set, b());
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, "zip");
    }
}
