package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class bay {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f12758O000000o = {"irdnairdb", "irdna_sdk"};
    private static final String[] O00000Oo = {"arm64-v8a", "armeabi-v7a", "armeabi"};

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        java.lang.System.loadLibrary(r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004e */
    private static void O000000o(java.lang.String r9) {
        /*
            java.lang.String[] r0 = _m_j.bay.f12758O000000o
            int r0 = r0.length
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = "/"
            r1.append(r9)
            int r9 = r1.length()
            java.lang.String[] r2 = _m_j.bay.O00000Oo
            int r2 = r2.length
            r3 = 0
            r4 = 0
        L_0x0019:
            if (r4 < r2) goto L_0x001c
            return
        L_0x001c:
            r1.setLength(r9)
            java.lang.String[] r5 = _m_j.bay.O00000Oo
            r5 = r5[r4]
            r1.append(r5)
            java.lang.String r5 = "/lib"
            r1.append(r5)
            int r5 = r1.length()
            r6 = r4
            r4 = 0
        L_0x0031:
            if (r4 < r0) goto L_0x0036
            int r4 = r6 + 1
            goto L_0x0019
        L_0x0036:
            java.lang.String[] r7 = _m_j.bay.f12758O000000o
            r7 = r7[r4]
            r1.setLength(r5)
            r1.append(r7)
            java.lang.String r8 = ".so"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            java.lang.System.load(r8)     // Catch:{ Throwable -> 0x004e }
            r6 = r2
            goto L_0x0051
        L_0x004e:
            java.lang.System.loadLibrary(r7)     // Catch:{ Throwable -> 0x0051 }
        L_0x0051:
            int r4 = r4 + 1
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bay.O000000o(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[SYNTHETIC, Splitter:B:10:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    public static void O000000o(Context context) {
        boolean z;
        int i;
        File file;
        InputStream open;
        String packageName = context.getPackageName();
        String absolutePath = context.getFilesDir().getAbsolutePath();
        boolean z2 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(packageName, 0);
        int i2 = sharedPreferences.getInt("app.version", 0);
        boolean z3 = true;
        try {
            i = context.getPackageManager().getPackageInfo(packageName, 1).versionCode;
            if (i2 >= i) {
                z = false;
                file = new File(absolutePath);
                if (file.isDirectory()) {
                    try {
                        file.mkdirs();
                    } catch (Throwable unused) {
                    }
                } else {
                    String[] list = file.list();
                    if (list != null && list.length >= f12758O000000o.length) {
                        z3 = z;
                    }
                }
                if (z3) {
                    Throwable th = null;
                    try {
                        open = context.getAssets().open("libs.zip");
                        z2 = O000000o(open, absolutePath);
                        if (open != null) {
                            open.close();
                        }
                        if (z2) {
                            sharedPreferences.edit().putInt("app.version", i).commit();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (th != null) {
                            if (th != th) {
                                try {
                                    th.addSuppressed(th);
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            }
                            th = th;
                        }
                        throw th;
                    }
                }
                O000000o(absolutePath);
            }
        } catch (Throwable unused2) {
            i = 1;
        }
        z = true;
        file = new File(absolutePath);
        if (file.isDirectory()) {
        }
        if (z3) {
        }
        O000000o(absolutePath);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|(3:11|12|13)(4:14|15|(2:17|(3:19|20|62)(1:61))(7:21|22|(3:23|24|(1:64)(2:29|30))|26|27|28|63)|58)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018 A[LOOP:0: B:8:0x0018->B:58:0x0018, LOOP_START, SYNTHETIC, Splitter:B:8:0x0018] */
    private static boolean O000000o(InputStream inputStream, String str) {
        ZipInputStream zipInputStream;
        Throwable th;
        if (inputStream == null || str == null || str.length() == 0) {
            return false;
        }
        byte[] bArr = new byte[16384];
        Throwable th2 = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return true;
                }
                String str2 = String.valueOf(str) + '/' + nextEntry.getName();
                if (str2.endsWith("/")) {
                    File file = new File(str2);
                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }
                } else {
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2), 16384);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr, 0, 16384);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                th = th;
                                th = th4;
                                if (th == null) {
                                    break;
                                }
                                if (th == th) {
                                    break;
                                }
                                th.addSuppressed(th);
                                break;
                                th = th;
                                throw th;
                            }
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (Throwable th5) {
                        th = th5;
                        th = null;
                    }
                }
            }
            th = th;
            throw th;
        } catch (Throwable th6) {
            th = th6;
            if (th2 != null) {
                if (th2 != th) {
                    try {
                        th2.addSuppressed(th);
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                th = th2;
            }
            throw th;
        }
    }
}
