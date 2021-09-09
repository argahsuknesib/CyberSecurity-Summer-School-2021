package com.alipay.sdk.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class b {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|(2:10|(1:12)(1:43))|13|14|15|16|17|(2:18|19)|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0045 A[SYNTHETIC, Splitter:B:31:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A[SYNTHETIC, Splitter:B:35:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0053 A[SYNTHETIC, Splitter:B:39:0x0053] */
    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream2;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    gZIPOutputStream = null;
                    th = th3;
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream2 = null;
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                gZIPOutputStream = byteArrayOutputStream2;
                if (byteArrayInputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream2.write(bArr2, 0, read);
                }
                gZIPOutputStream2.flush();
                gZIPOutputStream2.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream = gZIPOutputStream2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
            byteArrayOutputStream2 = null;
            th = th;
            byteArrayOutputStream = byteArrayOutputStream2;
            gZIPOutputStream = byteArrayOutputStream2;
            if (byteArrayInputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            if (gZIPOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(4:8|9|10|(1:12)(1:38))|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:22|23|30|31|32|33|34|35|37) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x004a */
    public static byte[] b(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream2);
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream2.read(bArr2, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (Throwable th) {
                            byteArrayInputStream = byteArrayInputStream2;
                            gZIPInputStream = gZIPInputStream2;
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayOutputStream.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                    gZIPInputStream2.close();
                    byteArrayInputStream2.close();
                    return byteArray;
                } catch (Throwable th2) {
                    ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream2;
                    gZIPInputStream = gZIPInputStream2;
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream3;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = byteArrayInputStream2;
                gZIPInputStream = null;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
            throw th;
        }
    }
}
