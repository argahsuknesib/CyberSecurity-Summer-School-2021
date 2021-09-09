package _m_j;

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class dzi {
    private static Map<String, dzi> O00000o0 = new HashMap();

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f15096O000000o;
    private final String O00000Oo = dzi.class.getSimpleName();

    private static String O000000o() {
        return "_" + Process.myPid();
    }

    private dzi(File file, long j, int i) {
        if (!file.exists() && !file.mkdirs()) {
            file.mkdirs();
        }
        this.f15096O000000o = new O000000o(this, file, 50000000, Integer.MAX_VALUE, (byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[SYNTHETIC, Splitter:B:35:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089 A[SYNTHETIC, Splitter:B:42:0x0089] */
    public final String O000000o(String str) {
        BufferedReader bufferedReader;
        File O000000o2 = this.f15096O000000o.O000000o(str);
        if (!O000000o2.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(O000000o2));
            String str2 = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = str2 + readLine;
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (!O00000Oo.O000000o(str2.getBytes())) {
                if (str2 != null && O00000Oo.O00000Oo(str2.getBytes())) {
                    str2 = str2.substring(str2.indexOf(32) + 1, str2.length());
                }
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return str2;
            }
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            this.f15096O000000o.O000000o(str).delete();
            return null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final AtomicLong f15097O000000o;
        public final AtomicInteger O00000Oo;
        protected File O00000o;
        public final Map<File, Long> O00000o0;
        private final long O00000oo;
        private final int O0000O0o;

        /* synthetic */ O000000o(dzi dzi, File file, long j, int i, byte b) {
            this(file, j, i);
        }

        private O000000o(File file, long j, int i) {
            this.O00000o0 = Collections.synchronizedMap(new HashMap());
            this.O00000o = file;
            this.O00000oo = j;
            this.O0000O0o = i;
            this.f15097O000000o = new AtomicLong();
            this.O00000Oo = new AtomicInteger();
            new Thread(new Runnable() {
                /* class _m_j.dzi.O000000o.AnonymousClass1 */

                public final void run() {
                    File[] listFiles = O000000o.this.O00000o.listFiles();
                    if (listFiles != null) {
                        int i = 0;
                        int i2 = 0;
                        for (File file : listFiles) {
                            i = (int) (((long) i) + file.length());
                            i2++;
                            O000000o.this.O00000o0.put(file, Long.valueOf(file.lastModified()));
                        }
                        O000000o.this.f15097O000000o.set((long) i);
                        O000000o.this.O00000Oo.set(i2);
                    }
                }
            }).start();
        }

        public final void O000000o(File file) {
            int i = this.O00000Oo.get();
            while (i + 1 > this.O0000O0o) {
                this.f15097O000000o.addAndGet(-O000000o());
                i = this.O00000Oo.addAndGet(-1);
            }
            this.O00000Oo.addAndGet(1);
            long length = file.length();
            long j = this.f15097O000000o.get();
            while (j + length > this.O00000oo) {
                j = this.f15097O000000o.addAndGet(-O000000o());
            }
            this.f15097O000000o.addAndGet(length);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.O00000o0.put(file, valueOf);
        }

        public final File O000000o(String str) {
            File O00000Oo2 = O00000Oo(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            O00000Oo2.setLastModified(valueOf.longValue());
            this.O00000o0.put(O00000Oo2, valueOf);
            return O00000Oo2;
        }

        public final File O00000Oo(String str) {
            File file = this.O00000o;
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            return new File(file, sb.toString());
        }

        private long O000000o() {
            File file;
            if (this.O00000o0.isEmpty()) {
                return 0;
            }
            Set<Map.Entry<File, Long>> entrySet = this.O00000o0.entrySet();
            synchronized (this.O00000o0) {
                file = null;
                Long l = null;
                for (Map.Entry next : entrySet) {
                    if (file == null) {
                        file = (File) next.getKey();
                        l = (Long) next.getValue();
                    } else {
                        Long l2 = (Long) next.getValue();
                        if (l2.longValue() < l.longValue()) {
                            file = (File) next.getKey();
                            l = l2;
                        }
                    }
                }
            }
            long length = file.length();
            if (file.delete()) {
                this.O00000o0.remove(file);
            }
            return length;
        }
    }

    static class O00000Oo {
        static boolean O00000Oo(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && O00000o0(bArr) > 14;
        }

        private static int O00000o0(byte[] bArr) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == 32) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] O000000o(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        public static boolean O000000o(byte[] bArr) {
            String[] strArr;
            if (O00000Oo(bArr)) {
                strArr = new String[]{new String(O000000o(bArr, 0, 13)), new String(O000000o(bArr, 14, O00000o0(bArr)))};
            } else {
                strArr = null;
            }
            if (strArr != null && strArr.length == 2) {
                String str = strArr[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(strArr[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static dzi O000000o(Context context) {
        File file = new File(context.getFilesDir(), "MiotMonitorXCache");
        Map<String, dzi> map = O00000o0;
        dzi dzi = map.get(file.getAbsoluteFile() + O000000o());
        if (dzi != null) {
            return dzi;
        }
        dzi dzi2 = new dzi(file, 50000000, Integer.MAX_VALUE);
        Map<String, dzi> map2 = O00000o0;
        map2.put(file.getAbsolutePath() + O000000o(), dzi2);
        return dzi2;
    }
}
