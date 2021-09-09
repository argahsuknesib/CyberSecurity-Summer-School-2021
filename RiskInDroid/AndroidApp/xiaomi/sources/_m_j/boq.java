package _m_j;

import com.lidroid.xutils.cache.LruDiskCache$1;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class boq implements Closeable {
    public static final OutputStream O00000oo = new OutputStream() {
        /* class _m_j.boq.AnonymousClass1 */

        public final void write(int i) throws IOException {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final File f13176O000000o;
    public final int O00000Oo;
    public int O00000o;
    public Writer O00000o0;
    final ThreadPoolExecutor O00000oO = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public bop O0000O0o = new bos();
    private final File O0000OOo;
    private final File O0000Oo;
    private final File O0000Oo0;
    private final int O0000OoO;
    private long O0000Ooo;
    private final LinkedHashMap<String, O00000Oo> O0000o0 = new LinkedHashMap<>(0, 0.75f, true);
    private long O0000o00 = 0;
    private long O0000o0O = 0;
    private final Callable<Void> O0000o0o = new LruDiskCache$1(this);

    private boq(File file, int i, int i2, long j) {
        File file2 = file;
        this.f13176O000000o = file2;
        this.O0000OoO = 1;
        this.O0000OOo = new File(file2, "journal");
        this.O0000Oo0 = new File(file2, "journal.tmp");
        this.O0000Oo = new File(file2, "journal.bkp");
        this.O00000Oo = 1;
        this.O0000Ooo = j;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static boq O000000o(File file, long j) throws IOException {
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
            boq boq = new boq(file, 1, 1, j);
            if (boq.O0000OOo.exists()) {
                try {
                    boq.O0000O0o();
                    boq.O0000OOo();
                    boq.O00000o0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(boq.O0000OOo, true), "US-ASCII"));
                    return boq;
                } catch (Throwable th) {
                    brm.O000000o("DiskLruCache " + file + " is corrupt: " + th.getMessage() + ", removing", th);
                    boq.O00000oo();
                }
            }
            if (!file.exists() && !file.mkdirs()) {
                return boq;
            }
            boq boq2 = new boq(file, 1, 1, j);
            boq2.O000000o();
            return boq2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|46|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:14|(4:15|16|17|(8:19|20|(2:22|(3:24|65|48))(1:25)|26|(1:28)|29|(2:31|(1:66)(2:33|(2:35|67)(3:64|36|37)))(2:38|(3:40|41|(2:43|69)(2:44|70))(1:68))|48)(3:63|49|50))|51|52|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0103, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0116 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x0123=Splitter:B:55:0x0123, B:51:0x0116=Splitter:B:51:0x0116} */
    private void O0000O0o() throws IOException {
        O00000o0 o00000o0;
        String str;
        try {
            o00000o0 = new O00000o0(this, new FileInputStream(this.O0000OOo));
            try {
                String O000000o2 = o00000o0.O000000o();
                String O000000o3 = o00000o0.O000000o();
                String O000000o4 = o00000o0.O000000o();
                String O000000o5 = o00000o0.O000000o();
                String O000000o6 = o00000o0.O000000o();
                if (!"libcore.io.DiskLruCache".equals(O000000o2) || !"1".equals(O000000o3) || !Integer.toString(this.O0000OoO).equals(O000000o4) || !Integer.toString(this.O00000Oo).equals(O000000o5) || !"".equals(O000000o6)) {
                    throw new IOException("unexpected journal header: [" + O000000o2 + ", " + O000000o3 + ", " + O000000o5 + ", " + O000000o6 + "]");
                }
                int i = 0;
                while (true) {
                    String O000000o7 = o00000o0.O000000o();
                    int indexOf = O000000o7.indexOf(32);
                    if (indexOf == 1) {
                        char charAt = O000000o7.charAt(0);
                        int i2 = indexOf + 1;
                        int indexOf2 = O000000o7.indexOf(32, i2);
                        if (indexOf2 == -1) {
                            str = O000000o7.substring(i2);
                            if (charAt == 'D') {
                                this.O0000o0.remove(str);
                                i++;
                            }
                        } else {
                            str = O000000o7.substring(i2, indexOf2);
                        }
                        O00000Oo o00000Oo = this.O0000o0.get(str);
                        if (o00000Oo == null) {
                            o00000Oo = new O00000Oo(this, str, (byte) 0);
                            this.O0000o0.put(str, o00000Oo);
                        }
                        if (charAt == 'C') {
                            o00000Oo.O00000o = true;
                            o00000Oo.O00000oO = null;
                            String[] split = O000000o7.substring(indexOf2 + 1).split(" ");
                            if (split.length <= 0) {
                                continue;
                            } else if (split[0].charAt(0) == 't') {
                                o00000Oo.O00000Oo = Long.valueOf(split[0].substring(1)).longValue();
                                o00000Oo.O000000o(split, 1);
                            } else {
                                o00000Oo.O00000Oo = Long.MAX_VALUE;
                                o00000Oo.O000000o(split, 0);
                            }
                        } else if (charAt == 'R') {
                            continue;
                        } else if (charAt == 'U') {
                            o00000Oo.O00000oO = new O000000o(this, o00000Oo, (byte) 0);
                        } else {
                            throw new IOException("unexpected journal line: ".concat(String.valueOf(O000000o7)));
                        }
                        i++;
                    } else {
                        throw new IOException("unexpected journal line: ".concat(String.valueOf(O000000o7)));
                    }
                }
                this.O00000o = i - this.O0000o0.size();
                brl.O000000o(o00000o0);
            } catch (Throwable th) {
                th = th;
                brl.O000000o(o00000o0);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            o00000o0 = null;
            brl.O000000o(o00000o0);
            throw th;
        }
    }

    private void O0000OOo() throws IOException {
        O000000o(this.O0000Oo0);
        Iterator<O00000Oo> it = this.O0000o0.values().iterator();
        while (it.hasNext()) {
            O00000Oo next = it.next();
            int i = 0;
            if (next.O00000oO == null) {
                while (i < this.O00000Oo) {
                    this.O0000o00 += next.O00000o0[i];
                    i++;
                }
            } else {
                next.O00000oO = null;
                while (i < this.O00000Oo) {
                    O000000o(next.O000000o(i));
                    O000000o(next.O00000Oo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public final synchronized void O000000o() throws IOException {
        BufferedWriter bufferedWriter;
        Throwable th;
        if (this.O00000o0 != null) {
            brl.O000000o(this.O00000o0);
        }
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O0000Oo0), "US-ASCII"));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.O0000OoO));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.O00000Oo));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (O00000Oo next : this.O0000o0.values()) {
                    if (next.O00000oO != null) {
                        bufferedWriter.write("U " + next.f13178O000000o + 10);
                    } else {
                        bufferedWriter.write("C " + next.f13178O000000o + " t" + next.O00000Oo + next.O000000o() + 10);
                    }
                }
                brl.O000000o(bufferedWriter);
                if (this.O0000OOo.exists()) {
                    O000000o(this.O0000OOo, this.O0000Oo, true);
                }
                O000000o(this.O0000Oo0, this.O0000OOo, false);
                this.O0000Oo.delete();
                this.O00000o0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O0000OOo, true), "US-ASCII"));
            } catch (Throwable th2) {
                th = th2;
                brl.O000000o(bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedWriter = null;
            th = th4;
            brl.O000000o(bufferedWriter);
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

    private synchronized void O000000o(O000000o o000000o) throws IOException {
        O00000Oo o00000Oo = o000000o.f13177O000000o;
        if (o00000Oo.O00000oO == o000000o) {
            for (int i = 0; i < this.O00000Oo; i++) {
                O000000o(o00000Oo.O00000Oo(i));
            }
            this.O00000o++;
            o00000Oo.O00000oO = null;
            if (false || o00000Oo.O00000o) {
                o00000Oo.O00000o = true;
                this.O00000o0.write("C " + o00000Oo.f13178O000000o + " t" + o00000Oo.O00000Oo + o00000Oo.O000000o() + 10);
            } else {
                this.O0000o0.remove(o00000Oo.f13178O000000o);
                this.O00000o0.write("D " + o00000Oo.f13178O000000o + 10);
            }
            this.O00000o0.flush();
            if (this.O0000o00 > this.O0000Ooo || O00000Oo()) {
                this.O00000oO.submit(this.O0000o0o);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean O00000Oo() {
        int i = this.O00000o;
        return i >= 2000 && i >= this.O0000o0.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        return false;
     */
    public synchronized boolean O000000o(String str) throws IOException {
        O0000Oo0();
        O00000Oo o00000Oo = this.O0000o0.get(str);
        if (o00000Oo != null) {
            if (o00000Oo.O00000oO == null) {
                for (int i = 0; i < this.O00000Oo; i++) {
                    File O000000o2 = o00000Oo.O000000o(i);
                    if (O000000o2.exists()) {
                        if (!O000000o2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(O000000o2)));
                        }
                    }
                    this.O0000o00 -= o00000Oo.O00000o0[i];
                    o00000Oo.O00000o0[i] = 0;
                }
                this.O00000o++;
                this.O00000o0.append((CharSequence) ("D " + str + 10));
                this.O0000o0.remove(str);
                if (O00000Oo()) {
                    this.O00000oO.submit(this.O0000o0o);
                }
            }
        }
    }

    public final synchronized boolean O00000o0() {
        return this.O00000o0 == null;
    }

    private void O0000Oo0() {
        if (this.O00000o0 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void O00000o() throws IOException {
        O0000Oo0();
        O00000oO();
        this.O00000o0.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.O00000o0 != null) {
            Iterator it = new ArrayList(this.O0000o0.values()).iterator();
            while (it.hasNext()) {
                O00000Oo o00000Oo = (O00000Oo) it.next();
                if (o00000Oo.O00000oO != null) {
                    O000000o o000000o = o00000Oo.O00000oO;
                    boq.this.O000000o(o000000o);
                }
            }
            O00000oO();
            this.O00000o0.close();
            this.O00000o0 = null;
        }
    }

    public final void O00000oO() throws IOException {
        while (this.O0000o00 > this.O0000Ooo) {
            O000000o((String) this.O0000o0.entrySet().iterator().next().getKey());
        }
    }

    public final void O00000oo() throws IOException {
        brl.O000000o(this);
        O00000Oo(this.f13176O000000o);
    }

    public final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O00000Oo f13177O000000o;
        public final boolean[] O00000Oo;

        private O000000o(O00000Oo o00000Oo) {
            this.f13177O000000o = o00000Oo;
            this.O00000Oo = o00000Oo.O00000o ? null : new boolean[boq.this.O00000Oo];
        }

        /* synthetic */ O000000o(boq boq, O00000Oo o00000Oo, byte b) {
            this(o00000Oo);
        }
    }

    final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f13178O000000o;
        public long O00000Oo;
        public boolean O00000o;
        public final long[] O00000o0;
        public O000000o O00000oO;

        private O00000Oo(String str) {
            this.O00000Oo = Long.MAX_VALUE;
            this.f13178O000000o = str;
            this.O00000o0 = new long[boq.this.O00000Oo];
        }

        /* synthetic */ O00000Oo(boq boq, String str, byte b) {
            this(str);
        }

        public final String O000000o() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.O00000o0) {
                sb.append(" ");
                sb.append(append);
            }
            return sb.toString();
        }

        public final void O000000o(String[] strArr, int i) throws IOException {
            if (strArr.length - i == boq.this.O00000Oo) {
                int i2 = 0;
                while (i2 < boq.this.O00000Oo) {
                    try {
                        this.O00000o0[i2] = Long.parseLong(strArr[i2 + i]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw O000000o(strArr);
                    }
                }
                return;
            }
            throw O000000o(strArr);
        }

        private static IOException O000000o(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File O000000o(int i) {
            File file = boq.this.f13176O000000o;
            return new File(file, String.valueOf(this.f13178O000000o) + "." + i);
        }

        public final File O00000Oo(int i) {
            File file = boq.this.f13176O000000o;
            return new File(file, String.valueOf(this.f13178O000000o) + "." + i + ".tmp");
        }
    }

    private static void O00000Oo(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    O00000Oo(file2);
                }
                if (!file2.exists() || file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    class O00000o0 implements Closeable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Charset f13179O000000o;
        private byte[] O00000o;
        private final InputStream O00000o0;
        private int O00000oO;
        private int O00000oo;

        public O00000o0(boq boq, InputStream inputStream) {
            this(inputStream, (byte) 0);
        }

        private O00000o0(InputStream inputStream, byte b) {
            this.f13179O000000o = Charset.forName("US-ASCII");
            if (inputStream != null) {
                this.O00000o0 = inputStream;
                this.O00000o = new byte[8192];
                return;
            }
            throw new NullPointerException();
        }

        public final void close() throws IOException {
            synchronized (this.O00000o0) {
                if (this.O00000o != null) {
                    this.O00000o = null;
                    this.O00000o0.close();
                }
            }
        }

        public final String O000000o() throws IOException {
            int i;
            int i2;
            synchronized (this.O00000o0) {
                if (this.O00000o != null) {
                    if (this.O00000oO >= this.O00000oo) {
                        O00000Oo();
                    }
                    for (int i3 = this.O00000oO; i3 != this.O00000oo; i3++) {
                        if (this.O00000o[i3] == 10) {
                            if (i3 != this.O00000oO) {
                                i2 = i3 - 1;
                                if (this.O00000o[i2] == 13) {
                                    String str = new String(this.O00000o, this.O00000oO, i2 - this.O00000oO, this.f13179O000000o.name());
                                    this.O00000oO = i3 + 1;
                                    return str;
                                }
                            }
                            i2 = i3;
                            String str2 = new String(this.O00000o, this.O00000oO, i2 - this.O00000oO, this.f13179O000000o.name());
                            this.O00000oO = i3 + 1;
                            return str2;
                        }
                    }
                    AnonymousClass1 r1 = new ByteArrayOutputStream((this.O00000oo - this.O00000oO) + 80) {
                        /* class _m_j.boq.O00000o0.AnonymousClass1 */

                        public final String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, O00000o0.this.f13179O000000o.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        r1.write(this.O00000o, this.O00000oO, this.O00000oo - this.O00000oO);
                        this.O00000oo = -1;
                        O00000Oo();
                        i = this.O00000oO;
                        while (i != this.O00000oo) {
                            if (this.O00000o[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.O00000oO) {
                        r1.write(this.O00000o, this.O00000oO, i - this.O00000oO);
                    }
                    r1.flush();
                    this.O00000oO = i + 1;
                    String byteArrayOutputStream = r1.toString();
                    return byteArrayOutputStream;
                }
                throw new IOException("LineReader is closed");
            }
        }

        private void O00000Oo() throws IOException {
            InputStream inputStream = this.O00000o0;
            byte[] bArr = this.O00000o;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                this.O00000oO = 0;
                this.O00000oo = read;
                return;
            }
            throw new EOFException();
        }
    }
}
