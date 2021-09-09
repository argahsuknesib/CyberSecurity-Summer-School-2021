package _m_j;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class bxk {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[SYNTHETIC, Splitter:B:25:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004e A[SYNTHETIC, Splitter:B:32:0x004e] */
    public static String O000000o(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!"2".equals(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str2.getBytes());
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e) {
                    e = e;
                }
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    return bxi.O000000o(byteArrayOutputStream.toByteArray());
                } catch (Throwable th) {
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException e5) {
                    e = e5;
                }
            }
            byteArrayOutputStream.close();
            return bxi.O000000o(byteArrayOutputStream.toByteArray());
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused2) {
        }
        return bxi.O000000o(byteArrayOutputStream.toByteArray());
        e.printStackTrace();
        byteArrayOutputStream.close();
        return bxi.O000000o(byteArrayOutputStream.toByteArray());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:41|(2:43|44)|(2:47|48)|49|50|51) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|18|19|20|21|38|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
        if (r1 == null) goto L_0x003b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0055 A[SYNTHETIC, Splitter:B:34:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0065 A[SYNTHETIC, Splitter:B:43:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006c A[SYNTHETIC, Splitter:B:47:0x006c] */
    public static String O00000Oo(String str, String str2) {
        ByteArrayInputStream byteArrayInputStream;
        if (!"2".equals(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bxi.O000000o(str2));
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            gZIPInputStream2.close();
                            byteArrayInputStream.close();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused) {
                            }
                            return byteArrayOutputStream.toString();
                        }
                    }
                } catch (IOException e) {
                    IOException iOException = e;
                    gZIPInputStream = gZIPInputStream2;
                    e = iOException;
                    try {
                        e.printStackTrace();
                        if (gZIPInputStream != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    gZIPInputStream = gZIPInputStream2;
                    th = th3;
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayInputStream = null;
            e.printStackTrace();
            if (gZIPInputStream != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
            if (gZIPInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
