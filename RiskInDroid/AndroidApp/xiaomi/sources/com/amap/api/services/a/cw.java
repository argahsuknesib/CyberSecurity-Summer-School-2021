package com.amap.api.services.a;

import _m_j.jdn;
import com.google.android.exoplayer2.C;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public final class cw implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f3379a = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), q);
    private static final ThreadFactory q = new ThreadFactory() {
        /* class com.amap.api.services.a.cw.AnonymousClass1 */

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f3380a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f3380a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */
    public static final OutputStream s = new OutputStream() {
        /* class com.amap.api.services.a.cw.AnonymousClass3 */

        public final void write(int i) throws IOException {
        }
    };
    /* access modifiers changed from: private */
    public final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    /* access modifiers changed from: private */
    public final int i;
    private long j = 0;
    /* access modifiers changed from: private */
    public Writer k;
    private int l = 1000;
    private final LinkedHashMap<String, c> m = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int n;
    private cx o;
    private long p = 0;
    private final Callable<Void> r = new Callable<Void>() {
        /* class com.amap.api.services.a.cw.AnonymousClass2 */

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (cw.this) {
                if (cw.this.k == null) {
                    return null;
                }
                cw.this.k();
                if (cw.this.i()) {
                    cw.this.h();
                    int unused = cw.this.n = 0;
                }
            }
        }
    };

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = C.MSG_CUSTOM_BASE;
        }
        this.l = i2;
    }

    public static ThreadPoolExecutor a() {
        try {
            if (b == null || b.isShutdown()) {
                b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    private cw(File file, int i2, int i3, long j2) {
        this.c = file;
        this.g = i2;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i3;
        this.h = j2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void
      com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static cw a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            cw cwVar = new cw(file, i2, i3, j2);
            if (cwVar.d.exists()) {
                try {
                    cwVar.f();
                    cwVar.g();
                    cwVar.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cwVar.d, true), cz.f3388a));
                    return cwVar;
                } catch (Throwable unused) {
                    cwVar.d();
                }
            }
            file.mkdirs();
            cw cwVar2 = new cw(file, i2, i3, j2);
            cwVar2.h();
            return cwVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.n = r0 - r9.m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x006c=Splitter:B:20:0x006c, B:16:0x005f=Splitter:B:16:0x005f} */
    private void f() throws IOException {
        cy cyVar = new cy(new FileInputStream(this.d), cz.f3388a);
        try {
            String a2 = cyVar.a();
            String a3 = cyVar.a();
            String a4 = cyVar.a();
            String a5 = cyVar.a();
            String a6 = cyVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.g).equals(a4) || !Integer.toString(this.i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i2 = 0;
            while (true) {
                d(cyVar.a());
                i2++;
            }
        } finally {
            cz.a(cyVar);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, boolean):boolean
     arg types: [com.amap.api.services.a.cw$c, int]
     candidates:
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, long):long
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, com.amap.api.services.a.cw$a):com.amap.api.services.a.cw$a
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, java.lang.String[]):void
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, boolean):boolean */
    private void d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.m.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = this.m.get(str2);
            if (cVar == null) {
                cVar = new c(str2);
                this.m.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = cVar.d = true;
                a unused2 = cVar.e = (a) null;
                cVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                a unused3 = cVar.e = new a(cVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void g() throws IOException {
        a(this.e);
        Iterator<c> it = this.m.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.i) {
                    this.j += next.c[i2];
                    i2++;
                }
            } else {
                a unused = next.e = (a) null;
                while (i2 < this.i) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void
      com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* access modifiers changed from: private */
    public synchronized void h() throws IOException {
        if (this.k != null) {
            this.k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), cz.f3388a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c next : this.m.values()) {
                if (next.e != null) {
                    bufferedWriter.write("DIRTY " + next.b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.b + next.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), cz.f3388a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.n++;
        r11.k.append((java.lang.CharSequence) ("READ " + r12 + 10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (i() == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        a().submit(r11.r);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        return new com.amap.api.services.a.cw.b(r4, r12, com.amap.api.services.a.cw.c.e(r0), r8, com.amap.api.services.a.cw.c.b(r0), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
    public final synchronized b a(String str) throws IOException {
        j();
        e(str);
        c cVar = this.m.get(str);
        if (cVar != null) {
            if (cVar.d) {
                InputStream[] inputStreamArr = new InputStream[this.i];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.i) {
                        break;
                    }
                    inputStreamArr[i3] = new FileInputStream(cVar.a(i3));
                    i3++;
                }
                while (i2 < this.i && inputStreamArr[i2] != null) {
                    cz.a(inputStreamArr[i2]);
                    i2++;
                    break;
                }
            }
            return null;
        }
        return null;
    }

    public final a b(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    private synchronized a a(String str, long j2) throws IOException {
        j();
        e(str);
        c cVar = this.m.get(str);
        if (j2 == -1 || (cVar != null && cVar.f == j2)) {
            if (cVar == null) {
                cVar = new c(str);
                this.m.put(str, cVar);
            } else if (cVar.e != null) {
                return null;
            }
            a aVar = new a(cVar);
            a unused = cVar.e = aVar;
            Writer writer = this.k;
            writer.write("DIRTY " + str + 10);
            this.k.flush();
            return aVar;
        }
    }

    public final File b() {
        return this.c;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, boolean):boolean
     arg types: [com.amap.api.services.a.cw$c, int]
     candidates:
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, long):long
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, com.amap.api.services.a.cw$a):com.amap.api.services.a.cw$a
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, java.lang.String[]):void
      com.amap.api.services.a.cw.c.a(com.amap.api.services.a.cw$c, boolean):boolean */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fe, code lost:
        return;
     */
    public synchronized void a(a aVar, boolean z) throws IOException {
        c a2 = aVar.b;
        if (a2.e == aVar) {
            if (z && !a2.d) {
                int i2 = 0;
                while (i2 < this.i) {
                    if (!aVar.c[i2]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                    } else if (!a2.b(i2).exists()) {
                        aVar.b();
                        return;
                    } else {
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.i; i3++) {
                File b2 = a2.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a3 = a2.a(i3);
                    b2.renameTo(a3);
                    long j2 = a2.c[i3];
                    long length = a3.length();
                    a2.c[i3] = length;
                    this.j = (this.j - j2) + length;
                }
            }
            this.n++;
            a unused = a2.e = (a) null;
            if (a2.d || z) {
                boolean unused2 = a2.d = true;
                this.k.write("CLEAN " + a2.b + a2.a() + 10);
                if (z) {
                    long j3 = this.p;
                    this.p = 1 + j3;
                    long unused3 = a2.f = j3;
                }
            } else {
                this.m.remove(a2.b);
                this.k.write("REMOVE " + a2.b + 10);
            }
            this.k.flush();
            if (this.j > this.h || i()) {
                a().submit(this.r);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    public boolean i() {
        int i2 = this.n;
        return i2 >= 2000 && i2 >= this.m.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        return false;
     */
    public final synchronized boolean c(String str) throws IOException {
        j();
        e(str);
        c cVar = this.m.get(str);
        if (cVar != null) {
            if (cVar.e == null) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(a2)));
                        }
                    }
                    this.j -= cVar.c[i2];
                    cVar.c[i2] = 0;
                }
                this.n++;
                this.k.append((CharSequence) ("REMOVE " + str + 10));
                this.m.remove(str);
                if (i()) {
                    a().submit(this.r);
                }
            }
        }
    }

    private void j() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void c() throws IOException {
        j();
        k();
        this.k.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.k != null) {
            Iterator it = new ArrayList(this.m.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.e != null) {
                    cVar.e.b();
                }
            }
            k();
            this.k.close();
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    public void k() throws IOException {
        while (true) {
            if (this.j > this.h || this.m.size() > this.l) {
                String str = (String) this.m.entrySet().iterator().next().getKey();
                c(str);
                cx cxVar = this.o;
                if (cxVar != null) {
                    cxVar.a(str);
                }
            } else {
                return;
            }
        }
    }

    public final void d() throws IOException {
        close();
        cz.a(this.c);
    }

    private void e(String str) {
        if (!f3379a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + jdn.f1779O000000o);
        }
    }

    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public final InputStream a(int i) {
            return this.d[i];
        }

        public final void close() {
            for (InputStream a2 : this.d) {
                cz.a(a2);
            }
        }
    }

    public final class a {
        /* access modifiers changed from: private */
        public final c b;
        /* access modifiers changed from: private */
        public final boolean[] c;
        /* access modifiers changed from: private */
        public boolean d;
        private boolean e;

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[cw.this.i];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        public final OutputStream a(int i) throws IOException {
            C0023a aVar;
            if (i < 0 || i >= cw.this.i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + cw.this.i);
            }
            synchronized (cw.this) {
                if (this.b.e == this) {
                    if (!this.b.d) {
                        this.c[i] = true;
                    }
                    File b2 = this.b.b(i);
                    FileOutputStream fileOutputStream = new FileOutputStream(b2);
                    cw.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                        aVar = new C0023a(fileOutputStream);
                    } catch (FileNotFoundException unused) {
                        return cw.s;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void
         arg types: [com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, int]
         candidates:
          com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void
          com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void */
        public final void a() throws IOException {
            if (this.d) {
                cw.this.a(this, false);
                cw.this.c(this.b.b);
            } else {
                cw.this.a(this, true);
            }
            this.e = true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void
         arg types: [com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, int]
         candidates:
          com.amap.api.services.a.cw.a(java.io.File, java.io.File, boolean):void
          com.amap.api.services.a.cw.a(com.amap.api.services.a.cw, com.amap.api.services.a.cw$a, boolean):void */
        public final void b() throws IOException {
            cw.this.a(this, false);
        }

        /* renamed from: com.amap.api.services.a.cw$a$a  reason: collision with other inner class name */
        class C0023a extends FilterOutputStream {
            private C0023a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }
        }
    }

    final class c {
        /* access modifiers changed from: private */
        public final String b;
        /* access modifiers changed from: private */
        public final long[] c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public a e;
        /* access modifiers changed from: private */
        public long f;

        private c(String str) {
            this.b = str;
            this.c = new long[cw.this.i];
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == cw.this.i) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File f2 = cw.this.c;
            return new File(f2, this.b + "." + i);
        }

        public final File b(int i) {
            File f2 = cw.this.c;
            return new File(f2, this.b + "." + i + ".tmp");
        }
    }
}
