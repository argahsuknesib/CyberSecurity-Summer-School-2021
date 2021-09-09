package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.cd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

final class bc {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3647a = new aa("AssetPackStorage");
    private static final long b = TimeUnit.DAYS.toMillis(14);
    private static final long c = TimeUnit.DAYS.toMillis(28);
    private final Context d;
    private final dl e;

    bc(Context context, dl dlVar) {
        this.d = context;
        this.e = dlVar;
    }

    private final File a(String str, int i) {
        return new File(g(str), String.valueOf(i));
    }

    private static List<String> a(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    private static void a(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long b2 = b(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(b2)) && !file2.getName().equals("stale.tmp")) {
                    c(file2);
                }
            }
        }
    }

    private static long b(File file) {
        if (file.exists()) {
            ArrayList arrayList = new ArrayList();
            try {
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().equals("stale.tmp")) {
                        arrayList.add(Long.valueOf(file2.getName()));
                    }
                }
            } catch (NumberFormatException e2) {
                f3647a.a(e2, "Corrupt asset pack directories.", new Object[0]);
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList);
                return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
            }
        }
        return -1;
    }

    private static boolean c(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            boolean z2 = true;
            for (File c2 : listFiles) {
                if (!c(c2)) {
                    z2 = false;
                }
            }
            z = z2;
        }
        if (file.delete()) {
            return z;
        }
        return false;
    }

    private final File g(String str) {
        return new File(i(), str);
    }

    private final File g(String str, int i, long j) {
        return new File(c(str, i, j), "merge.tmp");
    }

    private final List<File> g() {
        ArrayList arrayList = new ArrayList();
        try {
            if (!i().exists() || i().listFiles() == null) {
                return arrayList;
            }
            for (File file : i().listFiles()) {
                if (!file.getCanonicalPath().equals(h().getCanonicalPath())) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        } catch (IOException e2) {
            f3647a.b("Could not process directory while scanning installed packs. %s", e2);
        }
    }

    private final File h() {
        return new File(i(), "_tmp");
    }

    private final File h(String str, int i, long j) {
        return new File(new File(new File(h(), str), String.valueOf(i)), String.valueOf(j));
    }

    private final File i() {
        return new File(this.d.getFilesDir(), "assetpacks");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    public final AssetLocation a(String str, String str2) {
        PackageInfo packageInfo;
        ArrayList<String> arrayList;
        String str3;
        String str4;
        try {
            packageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            f3647a.b("Could not find PackageInfo.", new Object[0]);
            packageInfo = null;
        }
        if (packageInfo != null) {
            arrayList = new ArrayList<>();
            if (Build.VERSION.SDK_INT < 21) {
                arrayList.add(packageInfo.applicationInfo.sourceDir);
            } else {
                if (packageInfo.splitNames == null || packageInfo.applicationInfo.splitSourceDirs == null) {
                    f3647a.a("No splits present for package %s.", str);
                } else {
                    int binarySearch = Arrays.binarySearch(packageInfo.splitNames, str);
                    if (binarySearch < 0) {
                        f3647a.a("Asset Pack '%s' is not installed.", str);
                    } else {
                        str3 = packageInfo.applicationInfo.splitSourceDirs[binarySearch];
                        if (str3 != null) {
                            arrayList.add(packageInfo.applicationInfo.sourceDir);
                            str4 = "config.";
                        } else {
                            arrayList.add(str3);
                            str4 = String.valueOf(str).concat(".config.");
                        }
                        arrayList.addAll(a(packageInfo, str4));
                    }
                }
                str3 = null;
                if (str3 != null) {
                }
                arrayList.addAll(a(packageInfo, str4));
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        String path = new File("assets", str2).getPath();
        for (String str5 : arrayList) {
            try {
                AssetLocation a2 = dd.a(str5, path);
                if (a2 != null) {
                    return a2;
                }
            } catch (IOException e2) {
                f3647a.a(e2, "Failed to parse APK file '%s' looking for asset '%s'.", str5, str2);
                return null;
            }
        }
        f3647a.a("The asset %s is not present in Asset Pack %s. Searched in APKs: %s", str2, str, arrayList);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final AssetLocation a(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.a(file.getPath(), 0, file.length());
        }
        f3647a.a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }

    /* access modifiers changed from: package-private */
    public final File a(String str, int i, long j) {
        return new File(a(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final File a(String str, int i, long j, String str2) {
        return new File(new File(new File(h(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final Map<String, AssetPackLocation> a() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : g()) {
                AssetPackLocation b2 = b(next.getName());
                if (b2 != null) {
                    hashMap.put(next.getName(), b2);
                }
            }
        } catch (IOException e2) {
            f3647a.b("Could not process directory while scanning installed packs: %s", e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, int i, long j, int i2) throws IOException {
        File g = g(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        g.getParentFile().mkdirs();
        g.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(g);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(List<String> list) {
        int a2 = this.e.a();
        List<File> g = g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (!list.contains(file.getName()) && b(file) != ((long) a2)) {
                c(file);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        try {
            return c(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final AssetPackLocation b(String str) throws IOException {
        String c2 = c(str);
        if (c2 == null) {
            return null;
        }
        File file = new File(c2, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.a(c2, file.getCanonicalPath());
        }
        f3647a.b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final File b(String str, int i, long j) {
        return new File(a(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File b(String str, int i, long j, String str2) {
        return new File(new File(new File(h(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Long> b() {
        HashMap hashMap = new HashMap();
        for (String next : a().keySet()) {
            hashMap.put(next, Long.valueOf(f(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final File c(String str, int i, long j) {
        return new File(h(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    public final File c(String str, int i, long j, String str2) {
        return new File(f(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    public final String c(String str) throws IOException {
        int length;
        File file = new File(i(), str);
        if (!file.exists()) {
            f3647a.a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.e.a()));
        if (!file2.exists()) {
            f3647a.a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f3647a.a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f3647a.b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        List<File> g = g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (file.listFiles() != null) {
                a(file);
                long b2 = b(file);
                if (((long) this.e.a()) != b2) {
                    try {
                        new File(new File(file, String.valueOf(b2)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f3647a.b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File a2 : file.listFiles()) {
                    a(a2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int d(String str, int i, long j) throws IOException {
        File g = g(str, i, j);
        if (!g.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(g);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new by("Merge checkpoint file corrupt.", e2);
                }
            } else {
                throw new by("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            cd.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final File d(String str, int i, long j, String str2) {
        return new File(f(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        List<File> g = g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > c) {
                        c(file2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d(String str) {
        if (g(str).exists()) {
            return c(g(str));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int e(String str) {
        return (int) b(g(str));
    }

    /* access modifiers changed from: package-private */
    public final File e(String str, int i, long j) {
        return new File(new File(h(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File e(String str, int i, long j, String str2) {
        return new File(f(str, i, j, str2), "slice.zip");
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (h().exists()) {
            for (File file : h().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > b) {
                    c(file);
                } else {
                    a(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final long f(String str) {
        return b(a(str, e(str)));
    }

    /* access modifiers changed from: package-private */
    public final File f(String str, int i, long j, String str2) {
        return new File(e(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        c(i());
    }

    /* access modifiers changed from: package-private */
    public final void f(String str, int i, long j) {
        if (h(str, i, j).exists()) {
            c(h(str, i, j));
        }
    }
}
