package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.cd;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f3784a = 0;
    private static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final d c;

    l(d dVar) throws IOException {
        this.c = dVar;
    }

    static /* synthetic */ Set a(l lVar, Set set, r rVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        lVar.a(rVar, set, new h(hashSet, rVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4 A[SYNTHETIC, Splitter:B:34:0x00f4] */
    private static void a(r rVar, i iVar) throws IOException {
        ZipFile zipFile;
        String format;
        try {
            zipFile = new ZipFile(rVar.a());
            try {
                String b2 = rVar.b();
                HashMap hashMap = new HashMap();
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    Matcher matcher = b.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", b2, group2, group));
                        Set set = (Set) hashMap.get(group);
                        if (set == null) {
                            set = new HashSet();
                            hashMap.put(group, set);
                        }
                        set.add(new k(zipEntry, group2));
                    }
                }
                HashMap hashMap2 = new HashMap();
                for (String str : Build.SUPPORTED_ABIS) {
                    if (hashMap.containsKey(str)) {
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                        for (k kVar : (Set) hashMap.get(str)) {
                            if (!hashMap2.containsKey(kVar.f3783a)) {
                                hashMap2.put(kVar.f3783a, kVar);
                                format = String.format("NativeLibraryExtractor: using library %s for ABI %s", kVar.f3783a, str);
                            } else {
                                format = String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", kVar.f3783a, str);
                            }
                            Log.d("SplitCompat", format);
                        }
                    } else {
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                    }
                }
                iVar.a(zipFile, new HashSet(hashMap2.values()));
                zipFile.close();
            } catch (IOException e) {
                e = e;
                if (zipFile != null) {
                }
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            zipFile = null;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    cd.a(e, e3);
                }
            }
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public final void a(r rVar, Set<k> set, j jVar) throws IOException {
        for (k next : set) {
            File a2 = this.c.a(rVar.b(), next.f3783a);
            boolean z = false;
            if (a2.exists() && a2.length() == next.b.getSize()) {
                z = true;
            }
            jVar.a(next, a2, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<File> a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<r> d = this.c.d();
        for (String next : this.c.e()) {
            Iterator<r> it = d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equals(next)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", next));
                    this.c.d(next);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (r next2 : d) {
            HashSet hashSet2 = new HashSet();
            a(next2, new g(this, hashSet2, next2));
            for (File next3 : this.c.e(next2.b())) {
                if (!hashSet2.contains(next3)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", next3.getAbsolutePath(), next2.b(), next2.a().getAbsolutePath()));
                    this.c.b(next3);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final Set<File> a(r rVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        a(rVar, new f(this, rVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
