package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.an;
import com.google.android.play.core.internal.ao;
import com.google.android.play.core.internal.ap;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bj;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitinstall.w;
import com.google.android.play.core.splitinstall.y;
import com.google.android.play.core.splitinstall.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SplitCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<SplitCompat> f3775a = new AtomicReference<>(null);
    /* access modifiers changed from: private */
    public final d b;
    private final Set<String> c = new HashSet();
    private final a d;

    private SplitCompat(Context context) {
        try {
            this.b = new d(context);
            this.d = new a(this.b);
        } catch (PackageManager.NameNotFoundException e) {
            throw new bj("Failed to initialize FileStorage", e);
        }
    }

    public static boolean a() {
        return f3775a.get() != null;
    }

    public static boolean a(Context context) {
        return a(context, true);
    }

    private static boolean a(Context context, boolean z) {
        if (!b()) {
            boolean compareAndSet = f3775a.compareAndSet(null, new SplitCompat(context));
            SplitCompat splitCompat = f3775a.get();
            if (compareAndSet) {
                w.f3839a.a(new an(context, q.a(), new ao(context, splitCompat.b, new aq(), null), splitCompat.b, new q()));
                y.a(new m(splitCompat));
                q.a().execute(new n(context));
            }
            try {
                splitCompat.b(context, z);
                return true;
            } catch (Exception e) {
                Log.e("SplitCompat", "Error installing additional splits", e);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a4 A[SYNTHETIC, Splitter:B:79:0x01a4] */
    private final synchronized void b(Context context, boolean z) throws IOException {
        ZipFile zipFile;
        if (!z) {
            q.a().execute(new o(this));
        } else {
            this.b.a();
        }
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            List<String> arrayList = packageInfo.splitNames == null ? new ArrayList<>() : Arrays.asList(packageInfo.splitNames);
            Set<r> d2 = this.b.d();
            HashSet hashSet = new HashSet();
            Iterator<r> it = d2.iterator();
            while (it.hasNext()) {
                String b2 = it.next().b();
                if (arrayList.contains(b2)) {
                    if (!z) {
                        hashSet.add(b2);
                    } else {
                        this.b.f(b2);
                    }
                    it.remove();
                }
            }
            if (!hashSet.isEmpty()) {
                q.a().execute(new p(this, hashSet));
            }
            HashSet hashSet2 = new HashSet();
            for (r b3 : d2) {
                String b4 = b3.b();
                if (!z.b(b4)) {
                    hashSet2.add(b4);
                }
            }
            for (String str : arrayList) {
                if (!z.b(str)) {
                    hashSet2.add(str);
                }
            }
            HashSet<r> hashSet3 = new HashSet<>(d2.size());
            for (r next : d2) {
                if (!z.a(next.b())) {
                    String b5 = next.b();
                    if (!hashSet2.contains(!z.a(b5) ? b5.split("\\.config\\.", 2)[0] : "")) {
                    }
                }
                hashSet3.add(next);
            }
            l lVar = new l(this.b);
            ap a2 = aq.a();
            ClassLoader classLoader = context.getClassLoader();
            if (z) {
                a2.a(classLoader, lVar.a());
            } else {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    Set<File> a3 = lVar.a((r) it2.next());
                    if (a3 == null) {
                        it2.remove();
                    } else {
                        a2.a(classLoader, a3);
                    }
                }
            }
            HashSet hashSet4 = new HashSet();
            for (r rVar : hashSet3) {
                try {
                    zipFile = new ZipFile(rVar.a());
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry != null) {
                            if (!a2.a(classLoader, this.b.c(rVar.b()), rVar.a(), z)) {
                                String valueOf = String.valueOf(rVar.a());
                                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                                sb.append("split was not installed ");
                                sb.append(valueOf);
                                Log.w("SplitCompat", sb.toString());
                            }
                        }
                        hashSet4.add(rVar.a());
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
                        zipFile.close();
                    }
                    throw e;
                }
            }
            a.b(context, hashSet4);
            HashSet hashSet5 = new HashSet();
            for (r rVar2 : hashSet3) {
                if (hashSet4.contains(rVar2.a())) {
                    String b6 = rVar2.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b6).length() + 30);
                    sb2.append("Split '");
                    sb2.append(b6);
                    sb2.append("' installation emulated");
                    Log.d("SplitCompat", sb2.toString());
                    hashSet5.add(rVar2.b());
                } else {
                    String b7 = rVar2.b();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(b7).length() + 35);
                    sb3.append("Split '");
                    sb3.append(b7);
                    sb3.append("' installation not emulated.");
                    Log.d("SplitCompat", sb3.toString());
                }
            }
            synchronized (this.c) {
                this.c.addAll(hashSet5);
            }
        } catch (PackageManager.NameNotFoundException e3) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e3);
        } catch (IOException e4) {
            cd.a(e, e4);
        }
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* access modifiers changed from: private */
    public final Set<String> c() {
        HashSet hashSet;
        synchronized (this.c) {
            hashSet = new HashSet(this.c);
        }
        return hashSet;
    }

    public static boolean install(Context context) {
        return a(context, false);
    }

    public static boolean installActivity(Context context) {
        if (b()) {
            return false;
        }
        SplitCompat splitCompat = f3775a.get();
        if (splitCompat != null) {
            return splitCompat.d.a(context, splitCompat.c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
