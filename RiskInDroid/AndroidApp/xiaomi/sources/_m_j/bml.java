package _m_j;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class bml {
    private static bml O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13100O000000o = "";
    public String O00000Oo = "";
    private Context O00000o0 = null;
    private final FileFilter O00000oO = new FileFilter() {
        /* class _m_j.bml.AnonymousClass1 */

        public final boolean accept(File file) {
            String name = file.getName();
            try {
                if (name.startsWith(bnd.O00000o0("9c8f8a"))) {
                    for (int i = 3; i < name.length(); i++) {
                        if (!Character.isDigit(name.charAt(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
    };

    private bml() {
        try {
            this.O00000o0 = blw.f13081O000000o;
            O00000oO();
        } catch (Exception unused) {
        }
    }

    public static bml O000000o() {
        if (O00000o == null) {
            synchronized (bml.class) {
                if (O00000o == null) {
                    O00000o = new bml();
                }
            }
        }
        return O00000o;
    }

    private void O00000oO() {
        try {
            for (String split : bne.O00000o0(bnd.O00000o0("d08f8d909cd09c8f8a96919990"))) {
                String[] split2 = split.split(":");
                if (2 == split2.length) {
                    String trim = split2[0].trim();
                    String trim2 = split2[1].trim();
                    if (!TextUtils.equals(bnd.O00000o0("979e8d9b889e8d9a"), trim)) {
                        if (!TextUtils.equals(bnd.O00000o0("899a919b908da0969b"), trim)) {
                            if (TextUtils.equals(bnd.O00000o0("af8d909c9a8c8c908d"), trim) || TextUtils.equals(bnd.O00000o0("92909b9a93df919e929a"), trim)) {
                                this.f13100O000000o = trim2;
                            }
                        }
                    }
                    this.O00000Oo = trim2;
                }
            }
        } catch (Exception unused) {
        }
    }

    private int O00000oo() {
        try {
            return new File(bnd.O00000o0("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a")).listFiles(this.O00000oO).length;
        } catch (Exception e) {
            bmz.O000000o(e);
            return 0;
        }
    }

    public final int O00000Oo() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int O000000o2 = O000000o(bnd.O00000o0("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a"));
            if (O000000o2 == -1) {
                O000000o2 = O000000o(bnd.O00000o0("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f8d9a8c9a918b"));
            }
            return O000000o2 == -1 ? O00000oo() : O000000o2;
        } catch (Exception | SecurityException unused) {
            return -1;
        }
    }

    @TargetApi(16)
    public final long O00000o() {
        if (this.O00000o0 == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) this.O00000o0.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem;
            } catch (Exception unused) {
                return 0;
            }
        } else {
            long j = -1;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(bnd.O00000o0("d08f8d909cd0929a9296919990"));
                try {
                    j = ((long) O000000o(bnd.O00000o0("b29a92ab908b9e93"), fileInputStream2)) * 1024;
                    return j;
                } catch (Throwable th) {
                    FileInputStream fileInputStream3 = fileInputStream2;
                    th = th;
                    fileInputStream = fileInputStream3;
                    bne.O000000o((Closeable) fileInputStream);
                    throw th;
                }
                try {
                    bne.O000000o((Closeable) fileInputStream2);
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                bne.O000000o((Closeable) fileInputStream);
                throw th;
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0064 */
    public final int O00000o0() {
        FileInputStream fileInputStream;
        int i = -1;
        for (int i2 = 0; i2 < O00000Oo(); i2++) {
            try {
                File file = new File(bnd.O00000o0("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad09c8f8a") + i2 + bnd.O00000o0("d09c8f8a998d9a8ed09c8f8a96919990a0929e87a0998d9a8e"));
                if (file.exists()) {
                    byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
                    fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    int i3 = 0;
                    while (Character.isDigit(bArr[i3]) && i3 < 128) {
                        i3++;
                    }
                    Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                    if (valueOf.intValue() > i) {
                        i = valueOf.intValue();
                    }
                    bne.O000000o((Closeable) fileInputStream);
                }
            } catch (NumberFormatException ) {
                bne.O000000o((Closeable) fileInputStream);
            } catch (Exception unused) {
                return -1;
            } catch (Throwable th) {
                bne.O000000o((Closeable) fileInputStream);
                throw th;
            }
        }
        if (i != -1) {
            return i;
        }
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream fileInputStream3 = new FileInputStream(bnd.O00000o0("d08f8d909cd09c8f8a96919990"));
            try {
                int O000000o2 = O000000o(bnd.O00000o0("9c8f8adfb2b785"), fileInputStream3) * 1000;
                if (O000000o2 <= i) {
                    O000000o2 = i;
                }
                bne.O000000o((Closeable) fileInputStream3);
                return O000000o2;
            } catch (Throwable th2) {
                FileInputStream fileInputStream4 = fileInputStream3;
                th = th2;
                fileInputStream2 = fileInputStream4;
                bne.O000000o((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bne.O000000o((Closeable) fileInputStream2);
            throw th;
        }
    }

    private static int O000000o(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        int i = -1;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (IOException unused) {
                bne.O000000o((Closeable) bufferedReader2);
                bne.O000000o((Closeable) fileInputStream);
                return i;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                bne.O000000o((Closeable) bufferedReader);
                bne.O000000o((Closeable) fileInputStream);
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.matches("0-[\\d]+$")) {
                        i = Integer.valueOf(readLine.substring(2)).intValue() + 1;
                    }
                }
                bne.O000000o((Closeable) bufferedReader);
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                bne.O000000o((Closeable) bufferedReader2);
                bne.O000000o((Closeable) fileInputStream);
                return i;
            } catch (Throwable th2) {
                th = th2;
                bne.O000000o((Closeable) bufferedReader);
                bne.O000000o((Closeable) fileInputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileInputStream = null;
            bne.O000000o((Closeable) bufferedReader2);
            bne.O000000o((Closeable) fileInputStream);
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileInputStream = null;
            bne.O000000o((Closeable) bufferedReader);
            bne.O000000o((Closeable) fileInputStream);
            throw th;
        }
        bne.O000000o((Closeable) fileInputStream);
        return i;
    }

    private static int O000000o(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < 1024 && bArr[i2] != 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    int i4 = i2 + 1;
                                    while (i4 < 1024 && Character.isDigit(bArr[i4])) {
                                        i4++;
                                    }
                                    return Integer.parseInt(new String(bArr, 0, i2, i4 - i2));
                                }
                                i2++;
                            }
                            return -1;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException | NumberFormatException unused) {
        }
        return -1;
    }
}
