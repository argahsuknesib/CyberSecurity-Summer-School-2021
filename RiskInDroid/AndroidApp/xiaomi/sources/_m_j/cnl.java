package _m_j;

import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$1;
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
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class cnl implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Pattern f14144O000000o = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream O0000O0o = new OutputStream() {
        /* class _m_j.cnl.AnonymousClass1 */

        public final void write(int i) throws IOException {
        }
    };
    public final File O00000Oo;
    public Writer O00000o;
    public final int O00000o0;
    public int O00000oO;
    final ThreadPoolExecutor O00000oo = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File O0000OOo;
    private final File O0000Oo;
    private final File O0000Oo0;
    private final int O0000OoO;
    private long O0000Ooo;
    private long O0000o = 0;
    private long O0000o0 = 0;
    private int O0000o00;
    private int O0000o0O = 0;
    private final LinkedHashMap<String, O00000Oo> O0000o0o = new LinkedHashMap<>(0, 0.75f, true);
    private final Callable<Void> O0000oO0 = new DiskLruCache$1(this);

    private cnl(File file, int i, int i2, long j, int i3) {
        File file2 = file;
        this.O00000Oo = file2;
        this.O0000OoO = 1;
        this.O0000OOo = new File(file2, "journal");
        this.O0000Oo0 = new File(file2, "journal.tmp");
        this.O0000Oo = new File(file2, "journal.bkp");
        this.O00000o0 = 1;
        this.O0000Ooo = j;
        this.O0000o00 = i3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cnl.O000000o(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      _m_j.cnl.O000000o(java.io.File, long, int):_m_j.cnl
      _m_j.cnl.O000000o(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static cnl O000000o(File file, long j, int i) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    O000000o(file2, file3, false);
                }
            }
            cnl cnl = new cnl(file, 1, 1, j, i);
            if (cnl.O0000OOo.exists()) {
                try {
                    cnl.O00000oO();
                    cnl.O00000oo();
                    cnl.O00000o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cnl.O0000OOo, true), cno.f14152O000000o));
                    return cnl;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    cnl.close();
                    cno.O000000o(cnl.O00000Oo);
                }
            }
            file.mkdirs();
            cnl cnl2 = new cnl(file, 1, 1, j, i);
            cnl2.O000000o();
            return cnl2;
        } else {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:51|52|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r11.O00000oO = r2 - r11.O0000o0o.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fe */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x010b=Splitter:B:55:0x010b, B:51:0x00fe=Splitter:B:51:0x00fe} */
    private void O00000oO() throws IOException {
        String O000000o2;
        String str;
        cnn cnn = new cnn(new FileInputStream(this.O0000OOo), cno.f14152O000000o);
        try {
            String O000000o3 = cnn.O000000o();
            String O000000o4 = cnn.O000000o();
            String O000000o5 = cnn.O000000o();
            String O000000o6 = cnn.O000000o();
            String O000000o7 = cnn.O000000o();
            if (!"libcore.io.DiskLruCache".equals(O000000o3) || !"1".equals(O000000o4) || !Integer.toString(this.O0000OoO).equals(O000000o5) || !Integer.toString(this.O00000o0).equals(O000000o6) || !"".equals(O000000o7)) {
                throw new IOException("unexpected journal header: [" + O000000o3 + ", " + O000000o4 + ", " + O000000o6 + ", " + O000000o7 + "]");
            }
            int i = 0;
            while (true) {
                O000000o2 = cnn.O000000o();
                int indexOf = O000000o2.indexOf(32);
                if (indexOf != -1) {
                    int i2 = indexOf + 1;
                    int indexOf2 = O000000o2.indexOf(32, i2);
                    if (indexOf2 == -1) {
                        str = O000000o2.substring(i2);
                        if (indexOf == 6 && O000000o2.startsWith("REMOVE")) {
                            this.O0000o0o.remove(str);
                            i++;
                        }
                    } else {
                        str = O000000o2.substring(i2, indexOf2);
                    }
                    O00000Oo o00000Oo = this.O0000o0o.get(str);
                    if (o00000Oo == null) {
                        o00000Oo = new O00000Oo(this, str, (byte) 0);
                        this.O0000o0o.put(str, o00000Oo);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && O000000o2.startsWith("CLEAN")) {
                        String[] split = O000000o2.substring(indexOf2 + 1).split(" ");
                        o00000Oo.O00000o0 = true;
                        o00000Oo.O00000o = null;
                        o00000Oo.O000000o(split);
                        i++;
                    } else if (indexOf2 == -1 && indexOf == 5 && O000000o2.startsWith("DIRTY")) {
                        o00000Oo.O00000o = new O000000o(this, o00000Oo, (byte) 0);
                        i++;
                    } else if (indexOf2 == -1 && indexOf == 4 && O000000o2.startsWith("READ")) {
                        i++;
                    }
                } else {
                    throw new IOException("unexpected journal line: ".concat(String.valueOf(O000000o2)));
                }
            }
            throw new IOException("unexpected journal line: ".concat(String.valueOf(O000000o2)));
        } finally {
            cno.O000000o(cnn);
        }
    }

    private void O00000oo() throws IOException {
        O000000o(this.O0000Oo0);
        Iterator<O00000Oo> it = this.O0000o0o.values().iterator();
        while (it.hasNext()) {
            O00000Oo next = it.next();
            int i = 0;
            if (next.O00000o == null) {
                while (i < this.O00000o0) {
                    this.O0000o0 += next.O00000Oo[i];
                    this.O0000o0O++;
                    i++;
                }
            } else {
                next.O00000o = null;
                while (i < this.O00000o0) {
                    O000000o(next.O000000o(i));
                    O000000o(next.O00000Oo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cnl.O000000o(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      _m_j.cnl.O000000o(java.io.File, long, int):_m_j.cnl
      _m_j.cnl.O000000o(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public final synchronized void O000000o() throws IOException {
        if (this.O00000o != null) {
            this.O00000o.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O0000Oo0), cno.f14152O000000o));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O0000OoO));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O00000o0));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (O00000Oo next : this.O0000o0o.values()) {
                if (next.O00000o != null) {
                    bufferedWriter.write("DIRTY " + next.f14147O000000o + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f14147O000000o + next.O000000o() + 10);
                }
            }
            bufferedWriter.close();
            if (this.O0000OOo.exists()) {
                O000000o(this.O0000OOo, this.O0000Oo, true);
            }
            O000000o(this.O0000Oo0, this.O0000OOo, false);
            this.O0000Oo.delete();
            this.O00000o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O0000OOo, true), cno.f14152O000000o));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void O000000o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void O000000o(File file, File file2, boolean z) throws IOException {
        if (z) {
            O000000o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r12.O00000oO++;
        r12.O00000o.append((java.lang.CharSequence) ("READ " + r13 + 10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (O00000Oo() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r12.O00000oo.submit(r12.O0000oO0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        return new _m_j.cnl.O00000o0(r4, r13, r0.O00000oO, r8, r9, r0.O00000Oo, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
    public final synchronized O00000o0 O000000o(String str) throws IOException {
        O0000O0o();
        O00000o(str);
        O00000Oo o00000Oo = this.O0000o0o.get(str);
        if (o00000Oo != null) {
            if (o00000Oo.O00000o0) {
                File[] fileArr = new File[this.O00000o0];
                InputStream[] inputStreamArr = new InputStream[this.O00000o0];
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.O00000o0) {
                        break;
                    }
                    File O000000o2 = o00000Oo.O000000o(i2);
                    fileArr[i2] = O000000o2;
                    inputStreamArr[i2] = new FileInputStream(O000000o2);
                    i2++;
                }
                while (i < this.O00000o0 && inputStreamArr[i] != null) {
                    cno.O000000o(inputStreamArr[i]);
                    i++;
                    break;
                }
            }
            return null;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public synchronized O000000o O00000Oo(String str) throws IOException {
        O0000O0o();
        O00000o(str);
        O00000Oo o00000Oo = this.O0000o0o.get(str);
        if (o00000Oo == null) {
            o00000Oo = new O00000Oo(this, str, (byte) 0);
            this.O0000o0o.put(str, o00000Oo);
        } else if (o00000Oo.O00000o != null) {
            return null;
        }
        O000000o o000000o = new O000000o(this, o00000Oo, (byte) 0);
        o00000Oo.O00000o = o000000o;
        Writer writer = this.O00000o;
        writer.write("DIRTY " + str + 10);
        this.O00000o.flush();
        return o000000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f0, code lost:
        return;
     */
    public final synchronized void O000000o(O000000o o000000o, boolean z) throws IOException {
        O00000Oo o00000Oo = o000000o.f14145O000000o;
        if (o00000Oo.O00000o == o000000o) {
            if (z && !o00000Oo.O00000o0) {
                int i = 0;
                while (i < this.O00000o0) {
                    if (!o000000o.O00000Oo[i]) {
                        o000000o.O00000o0();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    } else if (!o00000Oo.O00000Oo(i).exists()) {
                        o000000o.O00000o0();
                        return;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.O00000o0; i2++) {
                File O00000Oo2 = o00000Oo.O00000Oo(i2);
                if (!z) {
                    O000000o(O00000Oo2);
                } else if (O00000Oo2.exists()) {
                    File O000000o2 = o00000Oo.O000000o(i2);
                    O00000Oo2.renameTo(O000000o2);
                    long j = o00000Oo.O00000Oo[i2];
                    long length = O000000o2.length();
                    o00000Oo.O00000Oo[i2] = length;
                    this.O0000o0 = (this.O0000o0 - j) + length;
                    this.O0000o0O++;
                }
            }
            this.O00000oO++;
            o00000Oo.O00000o = null;
            if (o00000Oo.O00000o0 || z) {
                o00000Oo.O00000o0 = true;
                this.O00000o.write("CLEAN " + o00000Oo.f14147O000000o + o00000Oo.O000000o() + 10);
                if (z) {
                    long j2 = this.O0000o;
                    this.O0000o = 1 + j2;
                    o00000Oo.O00000oO = j2;
                }
            } else {
                this.O0000o0o.remove(o00000Oo.f14147O000000o);
                this.O00000o.write("REMOVE " + o00000Oo.f14147O000000o + 10);
            }
            this.O00000o.flush();
            if (this.O0000o0 > this.O0000Ooo || this.O0000o0O > this.O0000o00 || O00000Oo()) {
                this.O00000oo.submit(this.O0000oO0);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean O00000Oo() {
        int i = this.O00000oO;
        return i >= 2000 && i >= this.O0000o0o.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        return false;
     */
    public final synchronized boolean O00000o0(String str) throws IOException {
        O0000O0o();
        O00000o(str);
        O00000Oo o00000Oo = this.O0000o0o.get(str);
        if (o00000Oo != null) {
            if (o00000Oo.O00000o == null) {
                for (int i = 0; i < this.O00000o0; i++) {
                    File O000000o2 = o00000Oo.O000000o(i);
                    if (O000000o2.exists()) {
                        if (!O000000o2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(O000000o2)));
                        }
                    }
                    this.O0000o0 -= o00000Oo.O00000Oo[i];
                    this.O0000o0O--;
                    o00000Oo.O00000Oo[i] = 0;
                }
                this.O00000oO++;
                this.O00000o.append((CharSequence) ("REMOVE " + str + 10));
                this.O0000o0o.remove(str);
                if (O00000Oo()) {
                    this.O00000oo.submit(this.O0000oO0);
                }
            }
        }
    }

    private void O0000O0o() {
        if (this.O00000o == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void close() throws IOException {
        if (this.O00000o != null) {
            Iterator it = new ArrayList(this.O0000o0o.values()).iterator();
            while (it.hasNext()) {
                O00000Oo o00000Oo = (O00000Oo) it.next();
                if (o00000Oo.O00000o != null) {
                    o00000Oo.O00000o.O00000o0();
                }
            }
            O00000o0();
            O00000o();
            this.O00000o.close();
            this.O00000o = null;
        }
    }

    public final void O00000o0() throws IOException {
        while (this.O0000o0 > this.O0000Ooo) {
            O00000o0((String) this.O0000o0o.entrySet().iterator().next().getKey());
        }
    }

    public final void O00000o() throws IOException {
        while (this.O0000o0O > this.O0000o00) {
            O00000o0((String) this.O0000o0o.entrySet().iterator().next().getKey());
        }
    }

    private static void O00000o(String str) {
        if (!f14144O000000o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + jdn.f1779O000000o);
        }
    }

    public final class O00000o0 implements Closeable {

        /* renamed from: O000000o  reason: collision with root package name */
        File[] f14148O000000o;
        private final long O00000o;
        private final String O00000o0;
        private final InputStream[] O00000oO;
        private final long[] O00000oo;

        /* synthetic */ O00000o0(cnl cnl, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        private O00000o0(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.O00000o0 = str;
            this.O00000o = j;
            this.f14148O000000o = fileArr;
            this.O00000oO = inputStreamArr;
            this.O00000oo = jArr;
        }

        public final void close() {
            for (InputStream O000000o2 : this.O00000oO) {
                cno.O000000o(O000000o2);
            }
        }
    }

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000Oo f14145O000000o;
        public final boolean[] O00000Oo;
        public boolean O00000o0;
        private boolean O00000oO;

        /* synthetic */ O000000o(cnl cnl, O00000Oo o00000Oo, byte b) {
            this(o00000Oo);
        }

        private O000000o(O00000Oo o00000Oo) {
            this.f14145O000000o = o00000Oo;
            this.O00000Oo = o00000Oo.O00000o0 ? null : new boolean[cnl.this.O00000o0];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0021 */
        public final OutputStream O000000o() throws IOException {
            C0098O000000o o000000o;
            synchronized (cnl.this) {
                if (this.f14145O000000o.O00000o == this) {
                    if (!this.f14145O000000o.O00000o0) {
                        this.O00000Oo[0] = true;
                    }
                    File O00000Oo2 = this.f14145O000000o.O00000Oo(0);
                    FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo2);
                    cnl.this.O00000Oo.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(O00000Oo2);
                        o000000o = new C0098O000000o(this, fileOutputStream, (byte) 0);
                    } catch (FileNotFoundException unused) {
                        return cnl.O0000O0o;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return o000000o;
        }

        public final void O00000Oo() throws IOException {
            if (this.O00000o0) {
                cnl.this.O000000o(this, false);
                cnl.this.O00000o0(this.f14145O000000o.f14147O000000o);
            } else {
                cnl.this.O000000o(this, true);
            }
            this.O00000oO = true;
        }

        public final void O00000o0() throws IOException {
            cnl.this.O000000o(this, false);
        }

        /* renamed from: _m_j.cnl$O000000o$O000000o  reason: collision with other inner class name */
        class C0098O000000o extends FilterOutputStream {
            /* synthetic */ C0098O000000o(O000000o o000000o, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C0098O000000o(OutputStream outputStream) {
                super(outputStream);
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    O000000o.this.O00000o0 = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    O000000o.this.O00000o0 = true;
                }
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    O000000o.this.O00000o0 = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    O000000o.this.O00000o0 = true;
                }
            }
        }
    }

    final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f14147O000000o;
        public final long[] O00000Oo;
        public O000000o O00000o;
        public boolean O00000o0;
        public long O00000oO;

        /* synthetic */ O00000Oo(cnl cnl, String str, byte b) {
            this(str);
        }

        private O00000Oo(String str) {
            this.f14147O000000o = str;
            this.O00000Oo = new long[cnl.this.O00000o0];
        }

        public final String O000000o() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.O00000Oo) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public final void O000000o(String[] strArr) throws IOException {
            if (strArr.length == cnl.this.O00000o0) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.O00000Oo[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw O00000Oo(strArr);
                    }
                }
                return;
            }
            throw O00000Oo(strArr);
        }

        private static IOException O00000Oo(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File O000000o(int i) {
            File file = cnl.this.O00000Oo;
            return new File(file, this.f14147O000000o + i);
        }

        public final File O00000Oo(int i) {
            File file = cnl.this.O00000Oo;
            return new File(file, this.f14147O000000o + i + ".tmp");
        }
    }
}
