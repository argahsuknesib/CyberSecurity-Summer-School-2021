package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

public class d {
    private static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private File f5803a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f15a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<File, a> f16a = new HashMap<>();

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f5803a = new File(str);
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File a() {
        File file;
        synchronized (this.f15a) {
            file = this.f5803a;
        }
        return file;
    }

    private File b(String str) {
        File a2 = a();
        return a(a2, str + ".xml");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r0.exists() == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r5.delete();
        r0.renameTo(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r5.exists() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r5.canRead() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = new java.io.FileInputStream(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2 = com.ta.utdid2.b.a.e.a(r0);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (r0 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0052, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3 = new java.io.FileInputStream(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3.read(new byte[r3.available()]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0066, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006a, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006d, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006f, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        if (r2 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0077, code lost:
        if (r0 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x007d, code lost:
        if (r2 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0082, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0083, code lost:
        if (r0 == null) goto L_0x0086;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0076 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[ExcHandler: all (th java.lang.Throwable), PHI: r0 10  PHI: (r0v16 java.io.FileInputStream) = (r0v8 java.io.FileInputStream), (r0v8 java.io.FileInputStream), (r0v18 java.io.FileInputStream), (r0v18 java.io.FileInputStream) binds: [B:55:0x0079, B:56:?, B:19:0x003c, B:20:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:19:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0073 A[SYNTHETIC, Splitter:B:49:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0079 A[SYNTHETIC, Splitter:B:55:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x007f A[SYNTHETIC, Splitter:B:58:0x007f] */
    public b a(String str, int i) {
        a aVar;
        HashMap hashMap;
        File b2 = b(str);
        synchronized (b) {
            aVar = this.f16a.get(b2);
            if (aVar != null && !aVar.d()) {
                return aVar;
            }
        }
        synchronized (b) {
            if (aVar != null) {
                aVar.a(hashMap);
            } else {
                aVar = this.f16a.get(b2);
                if (aVar == null) {
                    aVar = new a(b2, i, hashMap);
                    this.f16a.put(b2, aVar);
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    static final class a implements b {
        private static final Object c = new Object();

        /* renamed from: a  reason: collision with root package name */
        private Map f5804a;

        /* renamed from: a  reason: collision with other field name */
        private WeakHashMap<b.C0046b, Object> f17a;
        private final File b;

        /* renamed from: c  reason: collision with other field name */
        private final int f18c;

        /* renamed from: c  reason: collision with other field name */
        private final File f19c;
        private boolean j = false;

        a(File file, int i, Map map) {
            this.b = file;
            this.f19c = d.a(file);
            this.f18c = i;
            this.f5804a = map == null ? new HashMap() : map;
            this.f17a = new WeakHashMap<>();
        }

        public final boolean b() {
            File file = this.b;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        public final void a(boolean z) {
            synchronized (this) {
                this.j = z;
            }
        }

        public final boolean d() {
            boolean z;
            synchronized (this) {
                z = this.j;
            }
            return z;
        }

        public final void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f5804a = map;
                }
            }
        }

        public final Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f5804a);
            }
            return hashMap;
        }

        public final String getString(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f5804a.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        public final long getLong(String str, long j2) {
            synchronized (this) {
                Long l = (Long) this.f5804a.get(str);
                if (l != null) {
                    j2 = l.longValue();
                }
            }
            return j2;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        public final class C0047a implements b.a {
            private final Map<String, Object> b = new HashMap();
            private boolean k = false;

            public C0047a() {
            }

            public final b.a a(String str, String str2) {
                synchronized (this) {
                    this.b.put(str, str2);
                }
                return this;
            }

            public final b.a a(String str, int i) {
                synchronized (this) {
                    this.b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            public final b.a a(String str, long j) {
                synchronized (this) {
                    this.b.put(str, Long.valueOf(j));
                }
                return this;
            }

            public final b.a a(String str, float f) {
                synchronized (this) {
                    this.b.put(str, Float.valueOf(f));
                }
                return this;
            }

            public final b.a a(String str, boolean z) {
                synchronized (this) {
                    this.b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            public final b.a a(String str) {
                synchronized (this) {
                    this.b.put(str, this);
                }
                return this;
            }

            public final b.a b() {
                synchronized (this) {
                    this.k = true;
                }
                return this;
            }

            public final boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.C0046b> hashSet;
                boolean a2;
                synchronized (d.a()) {
                    z = a.a(a.this).size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet<>(a.a(a.this).keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.k) {
                            a.a(a.this).clear();
                            this.k = false;
                        }
                        for (Map.Entry next : this.b.entrySet()) {
                            String str = (String) next.getKey();
                            Object value = next.getValue();
                            if (value == this) {
                                a.a(a.this).remove(str);
                            } else {
                                a.a(a.this).put(str, value);
                            }
                            if (z) {
                                arrayList.add(str);
                            }
                        }
                        this.b.clear();
                    }
                    a2 = a.a(a.this);
                    if (a2) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str2 = (String) arrayList.get(size);
                        for (b.C0046b bVar : hashSet) {
                            if (bVar != null) {
                                bVar.a(a.this, str2);
                            }
                        }
                    }
                }
                return a2;
            }
        }

        public final b.a a() {
            return new C0047a();
        }

        private FileOutputStream a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        private boolean e() {
            if (this.b.exists()) {
                if (this.f19c.exists()) {
                    this.b.delete();
                } else if (!this.b.renameTo(this.f19c)) {
                    return false;
                }
            }
            try {
                FileOutputStream a2 = a(this.b);
                if (a2 == null) {
                    return false;
                }
                e.a(this.f5804a, a2);
                a2.close();
                this.f19c.delete();
                return true;
            } catch (Exception unused) {
                if (this.b.exists()) {
                    this.b.delete();
                }
                return false;
            }
        }
    }
}
