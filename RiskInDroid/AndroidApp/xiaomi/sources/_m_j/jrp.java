package _m_j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import xcrash.XCrash;

public final class jrp {
    private static final jrp O0000o00 = new jrp();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f2104O000000o = "placeholder";
    public String O00000Oo = ".clean.xcrash";
    public String O00000o = null;
    public String O00000o0 = ".dirty.xcrash";
    public int O00000oO = 0;
    private int O00000oo = 0;
    private int O0000O0o = 0;
    private int O0000OOo = 0;
    private int O0000Oo = 0;
    private int O0000Oo0 = 1;
    private int O0000OoO = 0;
    private AtomicInteger O0000Ooo = new AtomicInteger();

    private jrp() {
    }

    public static jrp O000000o() {
        return O0000o00;
    }

    public final void O000000o(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        this.O00000o = str;
        this.O00000oo = i;
        this.O0000O0o = i2;
        this.O0000OOo = i3;
        this.O0000Oo = i4;
        this.O0000OoO = i5;
        this.O00000oO = i6;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            String name = file2.getName();
                            if (!name.startsWith("tombstone_")) {
                                if (name.startsWith(this.f2104O000000o + "_")) {
                                    if (name.endsWith(this.O00000Oo)) {
                                        i11++;
                                    } else if (name.endsWith(this.O00000o0)) {
                                        i12++;
                                    }
                                }
                            } else if (name.endsWith(".java.xcrash")) {
                                i7++;
                            } else if (name.endsWith(".native.xcrash")) {
                                i8++;
                            } else if (name.endsWith(".anr.xcrash")) {
                                i9++;
                            } else if (name.endsWith(".trace.xcrash")) {
                                i10++;
                            }
                        }
                    }
                    if (i7 > this.O00000oo || i8 > this.O0000O0o || i9 > this.O0000OOo || i10 > this.O0000Oo0 || i11 != this.O0000Oo || i12 != 0) {
                        if (i7 <= this.O00000oo + 10 && i8 <= this.O0000O0o + 10 && i9 <= this.O0000OOo + 10 && i10 <= this.O0000Oo0 + 10 && i11 <= this.O0000Oo + 10) {
                            if (i12 <= 10) {
                                if (i7 > this.O00000oo || i8 > this.O0000O0o || i9 > this.O0000OOo || i10 > this.O0000Oo0 || i11 > this.O0000Oo || i12 > 0) {
                                    this.O00000oO = 0;
                                    return;
                                }
                                return;
                            }
                        }
                        O00000o0();
                        this.O00000oO = -1;
                        return;
                    }
                    this.O00000oO = -1;
                }
            }
        } catch (Exception e) {
            XCrash.O000000o().O00000o0("xcrash", "FileManager init failed", e);
        }
    }

    public final boolean O00000Oo() {
        if (!jrv.O000000o(this.O00000o)) {
            return false;
        }
        try {
            return O000000o(new File(this.O00000o), ".anr.xcrash", this.O0000OOo);
        } catch (Exception e) {
            XCrash.O000000o().O00000o0("xcrash", "FileManager maintainAnr failed", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final File O000000o(String str) {
        String str2 = this.O00000o;
        if (str2 == null || !jrv.O000000o(str2)) {
            return null;
        }
        File file = new File(str);
        File[] listFiles = new File(this.O00000o).listFiles(new FilenameFilter() {
            /* class _m_j.jrp.AnonymousClass4 */

            public final boolean accept(File file, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(jrp.this.f2104O000000o);
                sb.append("_");
                return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000Oo);
            }
        });
        if (listFiles != null) {
            int length = listFiles.length;
            while (length > 0) {
                File file2 = listFiles[length - 1];
                try {
                    if (file2.renameTo(file)) {
                        return file;
                    }
                    file2.delete();
                    length--;
                } catch (Exception e) {
                    XCrash.O000000o().O00000o0("xcrash", "FileManager createLogFile by renameTo failed", e);
                }
            }
        }
        try {
            if (file.createNewFile()) {
                return file;
            }
            XCrash.O000000o().O000000o("xcrash", "FileManager createLogFile by createNewFile failed, file already exists");
            return null;
        } catch (Exception e2) {
            XCrash.O000000o().O00000o0("xcrash", "FileManager createLogFile by createNewFile failed", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[SYNTHETIC, Splitter:B:27:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[SYNTHETIC, Splitter:B:31:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    static boolean O000000o(String str, String str2) {
        long j;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rws");
            try {
                if (randomAccessFile2.length() > 0) {
                    MappedByteBuffer map = randomAccessFile2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile2.length());
                    j = randomAccessFile2.length();
                    while (j > 0 && map.get(((int) j) - 1) == 0) {
                        j--;
                    }
                } else {
                    j = 0;
                }
                randomAccessFile2.seek(j);
                randomAccessFile2.write(str2.getBytes("UTF-8"));
                try {
                    randomAccessFile2.close();
                } catch (Exception unused) {
                }
                return true;
            } catch (Exception e) {
                e = e;
                randomAccessFile = randomAccessFile2;
                try {
                    XCrash.O000000o().O00000o0("xcrash", "FileManager appendText failed", e);
                    if (randomAccessFile != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            XCrash.O000000o().O00000o0("xcrash", "FileManager appendText failed", e);
            if (randomAccessFile != null) {
                return false;
            }
            try {
                randomAccessFile.close();
                return false;
            } catch (Exception unused3) {
                return false;
            }
        }
    }

    public final boolean O000000o(File file) {
        if (file == null) {
            return false;
        }
        String str = this.O00000o;
        if (str == null || this.O0000Oo <= 0) {
            try {
                return file.delete();
            } catch (Exception unused) {
                return false;
            }
        } else {
            try {
                File[] listFiles = new File(str).listFiles(new FilenameFilter() {
                    /* class _m_j.jrp.AnonymousClass5 */

                    public final boolean accept(File file, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(jrp.this.f2104O000000o);
                        sb.append("_");
                        return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000Oo);
                    }
                });
                if (listFiles == null || listFiles.length < this.O0000Oo) {
                    File file2 = new File(String.format(Locale.US, "%s/%s_%020d%s", this.O00000o, this.f2104O000000o, Long.valueOf((new Date().getTime() * 1000) + ((long) O00000o())), this.O00000o0));
                    if (file.renameTo(file2)) {
                        return O00000o(file2);
                    }
                    try {
                        return file.delete();
                    } catch (Exception unused2) {
                        return false;
                    }
                } else {
                    try {
                        return file.delete();
                    } catch (Exception unused3) {
                        return false;
                    }
                }
            } catch (Exception e) {
                XCrash.O000000o().O00000o0("xcrash", "FileManager recycleLogFile failed", e);
                try {
                    return file.delete();
                } catch (Exception unused4) {
                    return false;
                }
            }
        }
    }

    public final void O00000o0() {
        if (jrv.O000000o(this.O00000o)) {
            File file = new File(this.O00000o);
            try {
                O00000Oo(file);
            } catch (Exception e) {
                XCrash.O000000o().O00000o0("xcrash", "FileManager doMaintainTombstone failed", e);
            }
            try {
                O00000o0(file);
            } catch (Exception e2) {
                XCrash.O000000o().O00000o0("xcrash", "FileManager doMaintainPlaceholder failed", e2);
            }
        }
    }

    private void O00000Oo(File file) {
        O000000o(file, ".native.xcrash", this.O0000O0o);
        O000000o(file, ".java.xcrash", this.O00000oo);
        O000000o(file, ".anr.xcrash", this.O0000OOo);
        O000000o(file, ".trace.xcrash", this.O0000Oo0);
    }

    private boolean O000000o(File file, final String str, int i) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            /* class _m_j.jrp.AnonymousClass6 */

            public final boolean accept(File file, String str) {
                return str.startsWith("tombstone_") && str.endsWith(str);
            }
        });
        if (listFiles == null || listFiles.length <= i) {
            return true;
        }
        if (i > 0) {
            Arrays.sort(listFiles, new Comparator<File>() {
                /* class _m_j.jrp.AnonymousClass7 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((File) obj).getName().compareTo(((File) obj2).getName());
                }
            });
        }
        boolean z = true;
        for (int i2 = 0; i2 < listFiles.length - i; i2++) {
            if (!O000000o(listFiles[i2])) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[LOOP:0: B:7:0x0020->B:29:0x008a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c A[EDGE_INSN: B:45:0x008c->B:30:0x008c ?: BREAK  , SYNTHETIC] */
    private void O00000o0(File file) {
        File[] listFiles;
        int i;
        File file2 = file;
        File[] listFiles2 = file2.listFiles(new FilenameFilter() {
            /* class _m_j.jrp.AnonymousClass8 */

            public final boolean accept(File file, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(jrp.this.f2104O000000o);
                sb.append("_");
                return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000Oo);
            }
        });
        if (listFiles2 != null && (listFiles = file2.listFiles(new FilenameFilter() {
            /* class _m_j.jrp.AnonymousClass9 */

            public final boolean accept(File file, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(jrp.this.f2104O000000o);
                sb.append("_");
                return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000o0);
            }
        })) != null) {
            int length = listFiles2.length;
            int length2 = listFiles.length;
            char c = 0;
            int i2 = 0;
            while (length < this.O0000Oo) {
                if (length2 > 0) {
                    if (O00000o(listFiles[length2 - 1])) {
                        length++;
                    }
                    length2--;
                } else {
                    try {
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[4];
                        objArr[c] = this.O00000o;
                        objArr[1] = this.f2104O000000o;
                        i = i2;
                        try {
                            objArr[2] = Long.valueOf((new Date().getTime() * 1000) + ((long) O00000o()));
                            objArr[3] = this.O00000o0;
                            File file3 = new File(String.format(locale, "%s/%s_%020d%s", objArr));
                            if (file3.createNewFile() && O00000o(file3)) {
                                length++;
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                    i2 = i + 1;
                    if (i2 <= this.O0000Oo * 2) {
                        break;
                    }
                    c = 0;
                }
                i = i2;
                i2 = i + 1;
                if (i2 <= this.O0000Oo * 2) {
                }
            }
            if (i2 > 0) {
                listFiles2 = file2.listFiles(new FilenameFilter() {
                    /* class _m_j.jrp.AnonymousClass10 */

                    public final boolean accept(File file, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(jrp.this.f2104O000000o);
                        sb.append("_");
                        return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000Oo);
                    }
                });
                listFiles = file2.listFiles(new FilenameFilter() {
                    /* class _m_j.jrp.AnonymousClass2 */

                    public final boolean accept(File file, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(jrp.this.f2104O000000o);
                        sb.append("_");
                        return str.startsWith(sb.toString()) && str.endsWith(jrp.this.O00000o0);
                    }
                });
            }
            if (listFiles2 != null && listFiles2.length > this.O0000Oo) {
                for (int i3 = 0; i3 < listFiles2.length - this.O0000Oo; i3++) {
                    listFiles2[i3].delete();
                }
            }
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf A[SYNTHETIC, Splitter:B:45:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5 A[SYNTHETIC, Splitter:B:51:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb A[SYNTHETIC, Splitter:B:56:0x00cb] */
    private boolean O00000o(File file) {
        boolean z;
        FileOutputStream fileOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            Arrays.fill(bArr, (byte) 0);
            long j = (long) this.O0000OoO;
            long length = file.length();
            if (length > ((long) (this.O0000OoO * 1024))) {
                j = length / 1024;
                if (length % 1024 != 0) {
                    j++;
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file.getAbsoluteFile(), false);
            int i = 0;
            while (((long) i) < j) {
                i++;
                if (((long) i) == j) {
                    try {
                        if (length % 1024 != 0) {
                            fileOutputStream2.write(bArr, 0, (int) (length % 1024));
                        }
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            XCrash.O000000o().O00000o0("xcrash", "FileManager cleanTheDirtyFile failed", e);
                            if (fileOutputStream != null) {
                            }
                            z = false;
                            if (!z) {
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                    }
                }
                fileOutputStream2.write(bArr);
            }
            fileOutputStream2.flush();
            Locale locale = Locale.US;
            Object[] objArr = new Object[4];
            objArr[0] = this.O00000o;
            objArr[1] = this.f2104O000000o;
            objArr[2] = Long.valueOf((new Date().getTime() * 1000) + ((long) O00000o()));
            objArr[3] = this.O00000Oo;
            z = file.renameTo(new File(String.format(locale, "%s/%s_%020d%s", objArr)));
            try {
                fileOutputStream2.close();
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            e = e2;
            XCrash.O000000o().O00000o0("xcrash", "FileManager cleanTheDirtyFile failed", e);
            if (fileOutputStream != null) {
            }
            z = false;
            if (!z) {
            }
            return z;
        }
        if (!z) {
            try {
                file.delete();
            } catch (Exception unused2) {
            }
        }
        return z;
    }

    private int O00000o() {
        int incrementAndGet = this.O0000Ooo.incrementAndGet();
        if (incrementAndGet >= 999) {
            this.O0000Ooo.set(0);
        }
        return incrementAndGet;
    }
}
