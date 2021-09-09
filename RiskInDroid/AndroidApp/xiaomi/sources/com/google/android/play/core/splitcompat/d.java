package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final long f3778a;
    private final Context b;
    private File c;

    public d(Context context) throws PackageManager.NameNotFoundException {
        this.b = context;
        this.f3778a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    private static File a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static void c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c2 : listFiles) {
                c(c2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    private static void d(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() == 0 ? new String("Unable to create directory: ") : "Unable to create directory: ".concat(valueOf));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    private final File f() throws IOException {
        File file = new File(g(), "verified-splits");
        d(file);
        return file;
    }

    private final File g() throws IOException {
        File file = new File(h(), Long.toString(this.f3778a));
        d(file);
        return file;
    }

    private final File g(String str) throws IOException {
        File a2 = a(i(), str);
        d(a2);
        return a2;
    }

    private final File h() throws IOException {
        if (this.c == null) {
            Context context = this.b;
            if (context != null) {
                this.c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.c, "splitcompat");
        d(file);
        return file;
    }

    private static String h(String str) {
        return String.valueOf(str).concat(".apk");
    }

    private final File i() throws IOException {
        File file = new File(g(), "native-libraries");
        d(file);
        return file;
    }

    public final File a(File file) throws IOException {
        return a(f(), file.getName());
    }

    public final File a(String str) throws IOException {
        return a(c(), h(str));
    }

    public final File a(String str, String str2) throws IOException {
        return a(g(str), str2);
    }

    public final void a() throws IOException {
        File h = h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f3778a))) {
                    File file = new File(h, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f3778a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    c(file);
                }
            }
        }
    }

    public final File b() throws IOException {
        return new File(g(), "lock.tmp");
    }

    public final File b(String str) throws IOException {
        return a(f(), h(str));
    }

    /* access modifiers changed from: package-private */
    public final void b(File file) throws IOException {
        q.a(file.getParentFile().getParentFile().equals(i()), "File to remove is not a native library");
        c(file);
    }

    public final File c() throws IOException {
        File file = new File(g(), "unverified-splits");
        d(file);
        return file;
    }

    public final File c(String str) throws IOException {
        File file = new File(g(), "dex");
        d(file);
        File a2 = a(file, str);
        d(a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final Set<r> d() throws IOException {
        File f = f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new b(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final void d(String str) throws IOException {
        c(g(str));
    }

    /* access modifiers changed from: package-private */
    public final List<String> e() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final Set<File> e(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = g(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final void f(String str) throws IOException {
        c(b(str));
    }
}
