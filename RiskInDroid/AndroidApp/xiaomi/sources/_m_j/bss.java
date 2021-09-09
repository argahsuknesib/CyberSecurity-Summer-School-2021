package _m_j;

import com.google.android.exoplayer2.C;
import com.loc.bc$1;
import com.loc.bc$2;
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
import java.util.regex.Pattern;

public final class bss implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Pattern f13245O000000o = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor O00000o0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), O0000o0o);
    private static final ThreadFactory O0000o0o = new bc$1();
    /* access modifiers changed from: private */
    public static final OutputStream O0000oO0 = new OutputStream() {
        /* class _m_j.bss.AnonymousClass1 */

        public final void write(int i) throws IOException {
        }
    };
    /* access modifiers changed from: package-private */
    public final File O00000Oo;
    private final File O00000o;
    private final File O00000oO;
    private final File O00000oo;
    private final int O0000O0o;
    private long O0000OOo;
    private long O0000Oo = 0;
    /* access modifiers changed from: private */
    public final int O0000Oo0;
    /* access modifiers changed from: private */
    public Writer O0000OoO;
    private int O0000Ooo = 1000;
    private final Callable<Void> O0000o = new bc$2(this);
    /* access modifiers changed from: private */
    public int O0000o0;
    private final LinkedHashMap<String, O00000o0> O0000o00 = new LinkedHashMap<>(0, 0.75f, true);
    private long O0000o0O = 0;

    public final class O00000Oo implements Closeable {

        /* renamed from: O000000o  reason: collision with root package name */
        final InputStream[] f13248O000000o;
        private final long O00000o;
        private final String O00000o0;
        private final long[] O00000oO;

        private O00000Oo(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.O00000o0 = str;
            this.O00000o = j;
            this.f13248O000000o = inputStreamArr;
            this.O00000oO = jArr;
        }

        /* synthetic */ O00000Oo(bss bss, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final void close() {
            for (InputStream O000000o2 : this.f13248O000000o) {
                bsu.O000000o(O000000o2);
            }
        }
    }

    final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f13249O000000o;
        final long[] O00000Oo;
        O000000o O00000o;
        boolean O00000o0;
        long O00000oO;

        private O00000o0(String str) {
            this.f13249O000000o = str;
            this.O00000Oo = new long[bss.this.O0000Oo0];
        }

        /* synthetic */ O00000o0(bss bss, String str, byte b) {
            this(str);
        }

        private static IOException O000000o(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void O000000o(O00000o0 o00000o0, String[] strArr) throws IOException {
            if (strArr.length == bss.this.O0000Oo0) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        o00000o0.O00000Oo[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw O000000o(strArr);
                    }
                }
                return;
            }
            throw O000000o(strArr);
        }

        public final File O000000o(int i) {
            File O0000O0o = bss.this.O00000Oo;
            return new File(O0000O0o, this.f13249O000000o + "." + i);
        }

        public final String O000000o() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.O00000Oo) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public final File O00000Oo(int i) {
            File O0000O0o = bss.this.O00000Oo;
            return new File(O0000O0o, this.f13249O000000o + "." + i + ".tmp");
        }
    }

    private bss(File file, long j) {
        this.O00000Oo = file;
        this.O0000O0o = 1;
        this.O00000o = new File(file, "journal");
        this.O00000oO = new File(file, "journal.tmp");
        this.O00000oo = new File(file, "journal.bkp");
        this.O0000Oo0 = 1;
        this.O0000OOo = j;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void
      _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static bss O000000o(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    O000000o(file2, file3, false);
                }
            }
            bss bss = new bss(file, j);
            if (bss.O00000o.exists()) {
                try {
                    bss.O00000oo();
                    bss.O0000O0o();
                    bss.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bss.O00000o, true), bsu.f13252O000000o));
                    return bss;
                } catch (Throwable unused) {
                    bss.O00000o0();
                }
            }
            file.mkdirs();
            bss bss2 = new bss(file, j);
            bss2.O0000OOo();
            return bss2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void O000000o() {
        ThreadPoolExecutor threadPoolExecutor = O00000o0;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            O00000o0.shutdown();
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

    private static void O00000o(String str) {
        if (!f13245O000000o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + jdn.f1779O000000o);
        }
    }

    private static ThreadPoolExecutor O00000oO() {
        try {
            if (O00000o0 == null || O00000o0.isShutdown()) {
                O00000o0 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), O0000o0o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return O00000o0;
    }

    private void O0000Oo() {
        if (this.O0000OoO == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public boolean O0000Oo0() {
        int i = this.O0000o0;
        return i >= 2000 && i >= this.O0000o00.size();
    }

    /* access modifiers changed from: private */
    public void O0000OoO() throws IOException {
        while (true) {
            if (this.O0000Oo > this.O0000OOo || this.O0000o00.size() > this.O0000Ooo) {
                O00000o0((String) this.O0000o00.entrySet().iterator().next().getKey());
            } else {
                return;
            }
        }
    }

    public final void O000000o(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = C.MSG_CUSTOM_BASE;
        }
        this.O0000Ooo = i;
    }

    public final synchronized void O00000Oo() throws IOException {
        O0000Oo();
        O0000OoO();
        this.O0000OoO.flush();
    }

    public final void O00000o0() throws IOException {
        close();
        bsu.O000000o(this.O00000Oo);
    }

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final O00000o0 f13246O000000o;
        final boolean[] O00000Oo;
        boolean O00000o0;
        private boolean O00000oO;

        /* synthetic */ O000000o(bss bss, O00000o0 o00000o0, byte b) {
            this(o00000o0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void
         arg types: [_m_j.bss, _m_j.bss$O000000o, int]
         candidates:
          _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void
          _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void */
        public final void O00000o0() throws IOException {
            bss.this.O000000o(this, false);
        }

        /* renamed from: _m_j.bss$O000000o$O000000o  reason: collision with other inner class name */
        class C0095O000000o extends FilterOutputStream {
            private C0095O000000o(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0095O000000o(O000000o o000000o, OutputStream outputStream, byte b) {
                this(outputStream);
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

        private O000000o(O00000o0 o00000o0) {
            this.f13246O000000o = o00000o0;
            this.O00000Oo = o00000o0.O00000o0 ? null : new boolean[bss.this.O0000Oo0];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0029 */
        public final OutputStream O000000o() throws IOException {
            C0095O000000o o000000o;
            if (bss.this.O0000Oo0 > 0) {
                synchronized (bss.this) {
                    if (this.f13246O000000o.O00000o == this) {
                        if (!this.f13246O000000o.O00000o0) {
                            this.O00000Oo[0] = true;
                        }
                        File O00000Oo2 = this.f13246O000000o.O00000Oo(0);
                        FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo2);
                        bss.this.O00000Oo.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(O00000Oo2);
                            o000000o = new C0095O000000o(this, fileOutputStream, (byte) 0);
                        } catch (FileNotFoundException unused) {
                            return bss.O0000oO0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return o000000o;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + bss.this.O0000Oo0);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void
         arg types: [_m_j.bss, _m_j.bss$O000000o, int]
         candidates:
          _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void
          _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void */
        public final void O00000Oo() throws IOException {
            if (this.O00000o0) {
                bss.this.O000000o(this, false);
                bss.this.O00000o0(this.f13246O000000o.f13249O000000o);
            } else {
                bss.this.O000000o(this, true);
            }
            this.O00000oO = true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:51|52|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r11.O0000o0 = r2 - r11.O0000o00.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fe */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x010b=Splitter:B:55:0x010b, B:51:0x00fe=Splitter:B:51:0x00fe} */
    private void O00000oo() throws IOException {
        String O000000o2;
        String str;
        bst bst = new bst(new FileInputStream(this.O00000o), bsu.f13252O000000o);
        try {
            String O000000o3 = bst.O000000o();
            String O000000o4 = bst.O000000o();
            String O000000o5 = bst.O000000o();
            String O000000o6 = bst.O000000o();
            String O000000o7 = bst.O000000o();
            if (!"libcore.io.DiskLruCache".equals(O000000o3) || !"1".equals(O000000o4) || !Integer.toString(this.O0000O0o).equals(O000000o5) || !Integer.toString(this.O0000Oo0).equals(O000000o6) || !"".equals(O000000o7)) {
                throw new IOException("unexpected journal header: [" + O000000o3 + ", " + O000000o4 + ", " + O000000o6 + ", " + O000000o7 + "]");
            }
            int i = 0;
            while (true) {
                O000000o2 = bst.O000000o();
                int indexOf = O000000o2.indexOf(32);
                if (indexOf != -1) {
                    int i2 = indexOf + 1;
                    int indexOf2 = O000000o2.indexOf(32, i2);
                    if (indexOf2 == -1) {
                        str = O000000o2.substring(i2);
                        if (indexOf == 6 && O000000o2.startsWith("REMOVE")) {
                            this.O0000o00.remove(str);
                            i++;
                        }
                    } else {
                        str = O000000o2.substring(i2, indexOf2);
                    }
                    O00000o0 o00000o0 = this.O0000o00.get(str);
                    if (o00000o0 == null) {
                        o00000o0 = new O00000o0(this, str, (byte) 0);
                        this.O0000o00.put(str, o00000o0);
                    }
                    if (indexOf2 != -1 && indexOf == 5 && O000000o2.startsWith("CLEAN")) {
                        String[] split = O000000o2.substring(indexOf2 + 1).split(" ");
                        o00000o0.O00000o0 = true;
                        o00000o0.O00000o = null;
                        O00000o0.O000000o(o00000o0, split);
                        i++;
                    } else if (indexOf2 == -1 && indexOf == 5 && O000000o2.startsWith("DIRTY")) {
                        o00000o0.O00000o = new O000000o(this, o00000o0, (byte) 0);
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
            bsu.O000000o(bst);
        }
    }

    private void O0000O0o() throws IOException {
        O000000o(this.O00000oO);
        Iterator<O00000o0> it = this.O0000o00.values().iterator();
        while (it.hasNext()) {
            O00000o0 next = it.next();
            int i = 0;
            if (next.O00000o == null) {
                while (i < this.O0000Oo0) {
                    this.O0000Oo += next.O00000Oo[i];
                    i++;
                }
            } else {
                next.O00000o = null;
                while (i < this.O0000Oo0) {
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
     method: _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      _m_j.bss.O000000o(_m_j.bss, _m_j.bss$O000000o, boolean):void
      _m_j.bss.O000000o(java.io.File, java.io.File, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* access modifiers changed from: private */
    public synchronized void O0000OOo() throws IOException {
        if (this.O0000OoO != null) {
            this.O0000OoO.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000oO), bsu.f13252O000000o));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O0000O0o));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O0000Oo0));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (O00000o0 next : this.O0000o00.values()) {
                if (next.O00000o != null) {
                    bufferedWriter.write("DIRTY " + next.f13249O000000o + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f13249O000000o + next.O000000o() + 10);
                }
            }
            bufferedWriter.close();
            if (this.O00000o.exists()) {
                O000000o(this.O00000o, this.O00000oo, true);
            }
            O000000o(this.O00000oO, this.O00000o, false);
            this.O00000oo.delete();
            this.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000o, true), bsu.f13252O000000o));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.O0000o0++;
        r11.O0000OoO.append((java.lang.CharSequence) ("READ " + r12 + 10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (O0000Oo0() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        O00000oO().submit(r11.O0000o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        return new _m_j.bss.O00000Oo(r4, r12, r0.O00000oO, r8, r0.O00000Oo, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006e */
    public final synchronized O00000Oo O000000o(String str) throws IOException {
        O0000Oo();
        O00000o(str);
        O00000o0 o00000o0 = this.O0000o00.get(str);
        if (o00000o0 != null) {
            if (o00000o0.O00000o0) {
                InputStream[] inputStreamArr = new InputStream[this.O0000Oo0];
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.O0000Oo0) {
                        break;
                    }
                    inputStreamArr[i2] = new FileInputStream(o00000o0.O000000o(i2));
                    i2++;
                }
                while (i < this.O0000Oo0 && inputStreamArr[i] != null) {
                    bsu.O000000o(inputStreamArr[i]);
                    i++;
                    break;
                }
            }
            return null;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized O000000o O00000Oo(String str) throws IOException {
        O0000Oo();
        O00000o(str);
        O00000o0 o00000o0 = this.O0000o00.get(str);
        if (o00000o0 == null) {
            o00000o0 = new O00000o0(this, str, (byte) 0);
            this.O0000o00.put(str, o00000o0);
        } else if (o00000o0.O00000o != null) {
            return null;
        }
        O000000o o000000o = new O000000o(this, o00000o0, (byte) 0);
        o00000o0.O00000o = o000000o;
        Writer writer = this.O0000OoO;
        writer.write("DIRTY " + str + 10);
        this.O0000OoO.flush();
        return o000000o;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e7, code lost:
        return;
     */
    public synchronized void O000000o(O000000o o000000o, boolean z) throws IOException {
        O00000o0 o00000o0 = o000000o.f13246O000000o;
        if (o00000o0.O00000o == o000000o) {
            if (z && !o00000o0.O00000o0) {
                int i = 0;
                while (i < this.O0000Oo0) {
                    if (!o000000o.O00000Oo[i]) {
                        o000000o.O00000o0();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    } else if (!o00000o0.O00000Oo(i).exists()) {
                        o000000o.O00000o0();
                        return;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.O0000Oo0; i2++) {
                File O00000Oo2 = o00000o0.O00000Oo(i2);
                if (!z) {
                    O000000o(O00000Oo2);
                } else if (O00000Oo2.exists()) {
                    File O000000o2 = o00000o0.O000000o(i2);
                    O00000Oo2.renameTo(O000000o2);
                    long j = o00000o0.O00000Oo[i2];
                    long length = O000000o2.length();
                    o00000o0.O00000Oo[i2] = length;
                    this.O0000Oo = (this.O0000Oo - j) + length;
                }
            }
            this.O0000o0++;
            o00000o0.O00000o = null;
            if (o00000o0.O00000o0 || z) {
                o00000o0.O00000o0 = true;
                this.O0000OoO.write("CLEAN " + o00000o0.f13249O000000o + o00000o0.O000000o() + 10);
                if (z) {
                    long j2 = this.O0000o0O;
                    this.O0000o0O = 1 + j2;
                    o00000o0.O00000oO = j2;
                }
            } else {
                this.O0000o00.remove(o00000o0.f13249O000000o);
                this.O0000OoO.write("REMOVE " + o00000o0.f13249O000000o + 10);
            }
            this.O0000OoO.flush();
            if (this.O0000Oo > this.O0000OOo || O0000Oo0()) {
                O00000oO().submit(this.O0000o);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        return false;
     */
    public final synchronized boolean O00000o0(String str) throws IOException {
        O0000Oo();
        O00000o(str);
        O00000o0 o00000o0 = this.O0000o00.get(str);
        if (o00000o0 != null) {
            if (o00000o0.O00000o == null) {
                for (int i = 0; i < this.O0000Oo0; i++) {
                    File O000000o2 = o00000o0.O000000o(i);
                    if (O000000o2.exists()) {
                        if (!O000000o2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(O000000o2)));
                        }
                    }
                    this.O0000Oo -= o00000o0.O00000Oo[i];
                    o00000o0.O00000Oo[i] = 0;
                }
                this.O0000o0++;
                this.O0000OoO.append((CharSequence) ("REMOVE " + str + 10));
                this.O0000o00.remove(str);
                if (O0000Oo0()) {
                    O00000oO().submit(this.O0000o);
                }
            }
        }
    }

    public final synchronized void close() throws IOException {
        if (this.O0000OoO != null) {
            Iterator it = new ArrayList(this.O0000o00.values()).iterator();
            while (it.hasNext()) {
                O00000o0 o00000o0 = (O00000o0) it.next();
                if (o00000o0.O00000o != null) {
                    o00000o0.O00000o.O00000o0();
                }
            }
            O0000OoO();
            this.O0000OoO.close();
            this.O0000OoO = null;
        }
    }
}
