package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class av implements ap {
    av() {
    }

    static au a() {
        return new ar();
    }

    static Object a(ClassLoader classLoader) {
        return bl.a(classLoader, "pathList", Object.class).a();
    }

    static boolean a(ClassLoader classLoader, File file, File file2, boolean z, au auVar, String str, at atVar) {
        ArrayList arrayList = new ArrayList();
        Object a2 = a(classLoader);
        bk b = bl.b(a2, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a3 : asList) {
            arrayList2.add((File) bl.a(a3, str, File.class).a());
        }
        if (!arrayList2.contains(file2)) {
            if (!z && !atVar.a(a2, file2, file)) {
                String valueOf = String.valueOf(file2.getPath());
                Log.w("SplitCompat", valueOf.length() == 0 ? new String("Should be optimized ") : "Should be optimized ".concat(valueOf));
                return false;
            }
            b.a((Collection) Arrays.asList(auVar.a(a2, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (!arrayList.isEmpty()) {
                bj bjVar = new bj("DexPathList.makeDexElement failed");
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    IOException iOException = (IOException) arrayList.get(i);
                    Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                    cd.a(bjVar, iOException);
                }
                bl.b(a2, "dexElementsSuppressedExceptions", IOException.class).a((Collection) arrayList);
                throw bjVar;
            }
        }
        return true;
    }

    static at b() {
        return new as();
    }

    static void b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() == 0 ? new String("Adding native library parent directory: ") : "Adding native library parent directory: ".concat(valueOf));
                hashSet.add(next.getParentFile());
            }
            bk b = bl.b(a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.a()));
            synchronized (v.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                b.b(hashSet);
            }
        }
    }

    public final void a(ClassLoader classLoader, Set<File> set) {
        b(classLoader, set);
    }

    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return a(classLoader, file, file2, z, a(), "zip", b());
    }
}
