package com.xiaomi.onetrack;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.a.f;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.ab;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashAnalysis {
    private static final AtomicBoolean s = new AtomicBoolean(false);
    private final FileProcessor[] t;
    /* access modifiers changed from: private */
    public final f u;

    private CrashAnalysis(Context context, f fVar) {
        try {
            Object newInstance = Class.forName("xcrash.XCrash$InitParameters").getConstructor(new Class[0]).newInstance(new Object[0]);
            a(newInstance, "setNativeDumpAllThreads", Boolean.FALSE);
            a(newInstance, "setLogDir", a());
            a(newInstance, "setNativeDumpMap", Boolean.FALSE);
            a(newInstance, "setNativeDumpFds", Boolean.FALSE);
            a(newInstance, "setJavaDumpAllThreads", Boolean.FALSE);
            Class.forName("xcrash.XCrash").getDeclaredMethod("init", Context.class, newInstance.getClass()).invoke(null, context.getApplicationContext(), newInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.u = fVar;
        this.t = new FileProcessor[]{new FileProcessor("java"), new FileProcessor("anr"), new FileProcessor("native")};
    }

    public static boolean isSupport() {
        try {
            Class.forName("xcrash.XCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static void a(Context context) {
        try {
            a.a(context);
            Class.forName("xcrash.XCrash").getDeclaredMethod("initHooker", Context.class, String.class).invoke(null, context.getApplicationContext(), a());
            Log.d("CrashAnalysis", "registerHook succeeded");
        } catch (Exception e) {
            Log.d("CrashAnalysis", "registerHook failed: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void start(final Context context, final f fVar) {
        if (s.compareAndSet(false, true)) {
            j.a(new Runnable() {
                /* class com.xiaomi.onetrack.CrashAnalysis.AnonymousClass1 */

                public final void run() {
                    try {
                        CrashAnalysis crashAnalysis = new CrashAnalysis(context, fVar);
                        q.a("CrashAnalysis", "CrashAnalysis create success");
                        if (crashAnalysis.d()) {
                            crashAnalysis.e();
                        } else {
                            q.a("CrashAnalysis", "no crash file found");
                        }
                    } catch (Throwable th) {
                        q.b("CrashAnalysis", "processCrash error: " + th.toString());
                    }
                }
            });
        } else {
            q.b("CrashAnalysis", "run method has been invoked more than once");
        }
    }

    /* access modifiers changed from: private */
    public static String c(String str, String str2) {
        int i;
        int indexOf;
        int indexOf2;
        int indexOf3;
        if (!TextUtils.isEmpty(str)) {
            if (str2.equals("anr")) {
                int indexOf4 = str.indexOf(" tid=1 ");
                if (!(indexOf4 == -1 || (indexOf2 = str.indexOf("\n  at ", indexOf4)) == -1 || (indexOf3 = str.indexOf(10, indexOf2 + 6)) == -1)) {
                    return str.substring(indexOf2 + 2, indexOf3);
                }
            } else {
                int indexOf5 = str.indexOf("error reason:\n\t");
                if (!(indexOf5 == -1 || (indexOf = str.indexOf("\n\n", (i = indexOf5 + 15))) == -1)) {
                    return str.substring(i, indexOf);
                }
            }
        }
        return "uncategoried";
    }

    /* access modifiers changed from: private */
    public static String d(String str, String str2) {
        int i;
        int indexOf;
        int indexOf2;
        if (!TextUtils.isEmpty(str)) {
            if (str2.equals("anr")) {
                int indexOf3 = str.indexOf(" tid=1 ");
                if (!(indexOf3 == -1 || (indexOf2 = str.indexOf("\n\n", indexOf3)) == -1)) {
                    return calculateJavaDigest(str.substring(indexOf3, indexOf2));
                }
            } else {
                int indexOf4 = str.indexOf("backtrace feature id:\n\t");
                if (!(indexOf4 == -1 || (indexOf = str.indexOf("\n\n", (i = indexOf4 + 23))) == -1)) {
                    return str.substring(i, indexOf);
                }
            }
        }
        return "";
    }

    private void a(Object obj, String str, Object obj2) throws Exception {
        obj.getClass().getDeclaredMethod(str, obj2.getClass() == Boolean.class ? Boolean.TYPE : obj2.getClass()).invoke(obj, obj2);
    }

    private static String a() {
        return l.a();
    }

    private long b() {
        long c = z.c();
        if (c == 0) {
            q.a("CrashAnalysis", "no ticket data found, return max count");
            return 10;
        }
        long b = ab.b();
        if (c / 100 != b) {
            q.a("CrashAnalysis", "no today's ticket, return max count");
            return 10;
        }
        Long.signum(b);
        long j = c - (b * 100);
        q.a("CrashAnalysis", "today's remain ticket is ".concat(String.valueOf(j)));
        return j;
    }

    private void a(long j) {
        z.d((ab.b() * 100) + j);
    }

    private List<File> c() {
        File[] listFiles = new File(a()).listFiles();
        if (listFiles == null) {
            q.a("CrashAnalysis", "this path does not denote a directory, or if an I/O error occurs.");
            return null;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new Comparator<File>() {
            /* class com.xiaomi.onetrack.CrashAnalysis.AnonymousClass2 */

            public int compare(File file, File file2) {
                return (int) (file.lastModified() - file2.lastModified());
            }
        });
        int size = asList.size();
        if (size <= 20) {
            return asList;
        }
        int i = size - 20;
        for (int i2 = 0; i2 < i; i2++) {
            l.a(asList.get(i2));
        }
        return asList.subList(i, size);
    }

    /* access modifiers changed from: private */
    public boolean d() {
        boolean z;
        List<File> c = c();
        long b = b();
        if (c == null || c.size() <= 0) {
            z = false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = z.b();
            long j = 604800000;
            if (b2 > currentTimeMillis) {
                b2 = currentTimeMillis - 604800000;
            }
            long j2 = 0;
            long j3 = b;
            long j4 = 0;
            boolean z2 = false;
            for (File next : c) {
                long lastModified = next.lastModified();
                if (lastModified < currentTimeMillis - j || lastModified > currentTimeMillis) {
                    q.a("CrashAnalysis", "remove obsolete crash files: " + next.getName());
                    l.a(next);
                } else if (lastModified <= b2) {
                    q.a("CrashAnalysis", "found already reported crash file, ignore");
                } else if (j3 > j2) {
                    long j5 = j4;
                    for (FileProcessor a2 : this.t) {
                        if (a2.a(next)) {
                            q.a("CrashAnalysis", "find crash file:" + next.getName());
                            j3--;
                            if (j5 < lastModified) {
                                j5 = lastModified;
                            }
                            z2 = true;
                        }
                    }
                    j4 = j5;
                }
                j = 604800000;
                j2 = 0;
            }
            if (j4 > j2) {
                z.c(j4);
            }
            z = z2;
            b = j3;
        }
        if (z) {
            a(b);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void e() {
        for (FileProcessor a2 : this.t) {
            a2.a();
        }
    }

    class FileProcessor {

        /* renamed from: a  reason: collision with root package name */
        final List<File> f6080a = new ArrayList();
        final String b;
        final String c;

        FileProcessor(String str) {
            this.c = str;
            this.b = str + ".xcrash";
        }

        /* access modifiers changed from: package-private */
        public boolean a(File file) {
            if (!file.getName().contains(this.b)) {
                return false;
            }
            this.f6080a.add(file);
            return true;
        }

        private String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("__");
            if (split.length != 2) {
                return null;
            }
            String[] split2 = split[0].split("_");
            if (split2.length == 3) {
                return split2[2];
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (int i = 0; i < this.f6080a.size(); i++) {
                String absolutePath = this.f6080a.get(i).getAbsoluteFile().getAbsolutePath();
                String a2 = a(absolutePath);
                String a3 = l.a(absolutePath, 102400);
                if (!TextUtils.isEmpty(a3) && CrashAnalysis.this.u != null) {
                    String a4 = CrashAnalysis.d(a3, this.c);
                    String b2 = CrashAnalysis.c(a3, this.c);
                    q.a("CrashAnalysis", "fileName: ".concat(String.valueOf(absolutePath)));
                    q.a("CrashAnalysis", "feature id: ".concat(String.valueOf(a4)));
                    q.a("CrashAnalysis", "error: ".concat(String.valueOf(b2)));
                    CrashAnalysis.this.u.a(a3, b2, this.c, a2, a4);
                    l.a(new File(absolutePath));
                    q.a("CrashAnalysis", "remove reported crash file");
                }
            }
        }
    }

    public static String calculateJavaDigest(String str) {
        String[] split = str.replaceAll("\\t", "").split("\\n");
        StringBuilder sb = new StringBuilder();
        int min = Math.min(split.length, 20);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            split[i2] = split[i2].replaceAll("((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+", "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX").replaceAll("\\d+[B,KB,MB]*", "");
        }
        while (i < min && (!split[i].contains("...") || !split[i].contains("more"))) {
            sb.append(split[i]);
            sb.append(10);
            i++;
        }
        return d.h(sb.toString());
    }
}
