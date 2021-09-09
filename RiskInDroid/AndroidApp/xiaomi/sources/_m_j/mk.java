package _m_j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

public final class mk {
    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080 A[RETURN] */
    public static boolean O000000o(Context context) {
        Method method;
        int i;
        if (Build.MANUFACTURER.toLowerCase().contains("vivo")) {
            if (context != null) {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (query != null) {
                    query.getColumnNames();
                    if (query.moveToFirst()) {
                        i = query.getInt(query.getColumnIndex("currentlmode"));
                        query.close();
                        return i == 0;
                    }
                    query.close();
                }
                Cursor query2 = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        int i2 = query2.getInt(query2.getColumnIndex("currentmode"));
                        query2.close();
                        i = i2;
                        if (i == 0) {
                        }
                    } else {
                        query2.close();
                    }
                }
                i = 1;
                if (i == 0) {
                }
            } else {
                throw new IllegalArgumentException("context is null");
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        } else {
            try {
                Object systemService = context.getApplicationContext().getSystemService("appops");
                if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                    return false;
                }
                return ((Integer) method.invoke(systemService, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0160, code lost:
        r5 = r6;
        r17 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0165, code lost:
        r5 = r6;
        r16 = r8;
        r17 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0193 A[Catch:{ OutOfMemoryError -> 0x01cb, Exception -> 0x01c8, all -> 0x01c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b2 A[Catch:{ OutOfMemoryError -> 0x01cb, Exception -> 0x01c8, all -> 0x01c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c5 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0052] */
    public static boolean O000000o(String str, File file, File file2, int i, int i2, int i3) {
        jig jig;
        jig jig2;
        jia jia;
        boolean z;
        jig jig3;
        jia jia2;
        jia jia3;
        FileOutputStream fileOutputStream;
        jip jip;
        File file3;
        jip jip2;
        FileOutputStream fileOutputStream2;
        File file4;
        File file5 = file;
        if (!file.exists() || file.length() <= 100) {
            return false;
        }
        try {
            civ.O00000o("g711", "start build ".concat(String.valueOf(str)));
            FileInputStream fileInputStream = new FileInputStream(file5);
            jia = new jia(new RandomAccessFile(file5, "r"));
            try {
                jib O000000o2 = jil.O000000o(fileInputStream.getChannel(), jia, file.getName());
                fileInputStream.close();
                List<jig> list = O000000o2.O00000Oo;
                civ.O00000o("g711", "start check ");
                boolean z2 = false;
                jig2 = null;
                jig = null;
                for (jig next : list) {
                    try {
                        if (next.O0000o00().equals("soun")) {
                            if (next.O0000OoO().getBoxes().get(0).getType().equals("alaw")) {
                                z2 = true;
                            }
                            jig = next;
                        } else {
                            jig2 = next;
                        }
                    } catch (OutOfMemoryError unused) {
                        jia2 = jia;
                        jig3 = jig2;
                        boolean z3 = false;
                        try {
                            civ.O00000o("g711", "Error OOM " + file.length());
                            O000000o(jia2);
                            O000000o(jig3);
                            O000000o(jig);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            jia = jia2;
                            jig2 = jig3;
                            O000000o(jia);
                            O000000o(jig2);
                            O000000o(jig);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        jia3 = jia;
                        boolean z4 = false;
                        try {
                            civ.O00000o("g711", "Error Exception " + e.toString());
                            O000000o(jia3);
                            O000000o(jig2);
                            O000000o(jig);
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            jia = jia3;
                            O000000o(jia);
                            O000000o(jig2);
                            O000000o(jig);
                            throw th;
                        }
                    } catch (Throwable th3) {
                    }
                }
                if (z2 && jig2 != null) {
                    civ.O00000o("g711", "start change ");
                    String str2 = str + ".aac";
                    byte[] bArr = new byte[10240];
                    AACEncodeEx aACEncodeEx = new AACEncodeEx();
                    aACEncodeEx.initial(i, i2, i3);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                    List<jie> O0000Oo0 = jig.O0000Oo0();
                    byte[] bArr2 = new byte[2048];
                    faf faf = new faf();
                    for (jie O00000Oo : O0000Oo0) {
                        ByteBuffer O00000Oo2 = O00000Oo.O00000Oo();
                        byte[] bArr3 = new byte[O00000Oo2.remaining()];
                        O00000Oo2.get(bArr3, 0, bArr3.length);
                        int decode = G711.decode(bArr3, 0, bArr3.length, bArr);
                        byte[] bArr4 = new byte[decode];
                        System.arraycopy(bArr, 0, bArr4, 0, decode);
                        faf.O00000Oo(bArr4);
                        while (faf.O000000o(bArr2)) {
                            byte[] encode = aACEncodeEx.encode(bArr2, 0, 2048);
                            bufferedOutputStream.write(encode, 0, encode.length);
                        }
                    }
                    try {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        jip = new jip(new jhz(str2));
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream2 = null;
                        jip2 = null;
                        try {
                            e.printStackTrace();
                            file4 = new File(str2);
                            if (file4.exists()) {
                                file4.delete();
                            }
                            aACEncodeEx.release();
                            O000000o(fileOutputStream2);
                            O000000o(jip2);
                            z = false;
                            O000000o(jia);
                            O000000o(jig2);
                            O000000o(jig);
                            return z;
                        } catch (Throwable th4) {
                            th = th4;
                            jip jip3 = jip2;
                            fileOutputStream = fileOutputStream2;
                            jip = jip3;
                            file3 = new File(str2);
                            if (file3.exists()) {
                                file3.delete();
                            }
                            aACEncodeEx.release();
                            O000000o(fileOutputStream);
                            O000000o(jip);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        jip = null;
                        fileOutputStream = null;
                        file3 = new File(str2);
                        if (file3.exists()) {
                        }
                        aACEncodeEx.release();
                        O000000o(fileOutputStream);
                        O000000o(jip);
                        throw th;
                    }
                    try {
                        jib jib = new jib();
                        jib.O000000o(jig2);
                        jib.O000000o(jip);
                        jha O000000o3 = new jii().O000000o(jib);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                        try {
                            O000000o3.writeContainer(fileOutputStream3.getChannel());
                            File file6 = new File(str2);
                            if (file6.exists()) {
                                file6.delete();
                            }
                            aACEncodeEx.release();
                            O000000o(fileOutputStream3);
                            O000000o(jip);
                            z = true;
                        } catch (Exception e4) {
                            e = e4;
                            jip2 = jip;
                            fileOutputStream2 = fileOutputStream3;
                            e.printStackTrace();
                            file4 = new File(str2);
                            if (file4.exists()) {
                            }
                            aACEncodeEx.release();
                            O000000o(fileOutputStream2);
                            O000000o(jip2);
                            z = false;
                            O000000o(jia);
                            O000000o(jig2);
                            O000000o(jig);
                            return z;
                        } catch (Throwable th6) {
                            th = th6;
                            fileOutputStream = fileOutputStream3;
                            file3 = new File(str2);
                            if (file3.exists()) {
                            }
                            aACEncodeEx.release();
                            O000000o(fileOutputStream);
                            O000000o(jip);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        jip2 = jip;
                        fileOutputStream2 = null;
                        e.printStackTrace();
                        file4 = new File(str2);
                        if (file4.exists()) {
                        }
                        aACEncodeEx.release();
                        O000000o(fileOutputStream2);
                        O000000o(jip2);
                        z = false;
                        O000000o(jia);
                        O000000o(jig2);
                        O000000o(jig);
                        return z;
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream = null;
                        file3 = new File(str2);
                        if (file3.exists()) {
                        }
                        aACEncodeEx.release();
                        O000000o(fileOutputStream);
                        O000000o(jip);
                        throw th;
                    }
                    O000000o(jia);
                    O000000o(jig2);
                    O000000o(jig);
                    return z;
                }
                z = false;
                O000000o(jia);
            } catch (OutOfMemoryError unused2) {
                jia2 = jia;
                jig = null;
                jig3 = null;
                boolean z32 = false;
                civ.O00000o("g711", "Error OOM " + file.length());
                O000000o(jia2);
                O000000o(jig3);
                O000000o(jig);
                return z;
            } catch (Exception e6) {
                e = e6;
                jia3 = jia;
                jig2 = null;
                jig = null;
                boolean z42 = false;
                civ.O00000o("g711", "Error Exception " + e.toString());
                O000000o(jia3);
                O000000o(jig2);
                O000000o(jig);
                return z;
            } catch (Throwable th8) {
                th = th8;
                jig2 = null;
                jig = null;
                O000000o(jia);
                O000000o(jig2);
                O000000o(jig);
                throw th;
            }
        } catch (OutOfMemoryError unused3) {
            jia2 = null;
            jig = null;
            jig3 = null;
            boolean z322 = false;
            civ.O00000o("g711", "Error OOM " + file.length());
            O000000o(jia2);
            O000000o(jig3);
            O000000o(jig);
            return z;
        } catch (Exception e7) {
            e = e7;
            jia3 = null;
            jig2 = null;
            jig = null;
            boolean z422 = false;
            civ.O00000o("g711", "Error Exception " + e.toString());
            O000000o(jia3);
            O000000o(jig2);
            O000000o(jig);
            return z;
        } catch (Throwable th9) {
            th = th9;
            jia = null;
            jig2 = null;
            jig = null;
            O000000o(jia);
            O000000o(jig2);
            O000000o(jig);
            throw th;
        }
        O000000o(jig2);
        O000000o(jig);
        return z;
    }

    public static boolean O000000o(String str, File file, File file2) {
        return O000000o(str, file, file2, 8000, 1, 16000);
    }

    public static boolean O000000o(Context context, String str) {
        return g.O000000o(context, str) == 0;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
