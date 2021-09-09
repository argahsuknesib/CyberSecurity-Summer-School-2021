package com.amap.api.services.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class f {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3418a = (!f.class.desiredAssertionStatus());
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    /* access modifiers changed from: private */
    public static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return e;
        }
        if ((i & 32) == 32) {
            return g;
        }
        return c;
    }

    private f() {
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] b2 = b(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = b2[i7 >>> 18];
            bArr2[i3 + 1] = b2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = b2[i7 >>> 18];
            bArr2[i3 + 1] = b2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = b2[i7 >>> 18];
            bArr2[i3 + 1] = b2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = b2[i7 & 63];
            return bArr2;
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (f3418a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f3418a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] b2 = b(bArr, i, i2, i3);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:31|32|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x005f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        a aVar;
        ? r2;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        if (bArr2 == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i4 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: ".concat(String.valueOf(i)));
        } else if (i5 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i2)));
        } else if (i4 + i5 > bArr2.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr2.length)));
        } else if ((i3 & 2) != 0) {
            GZIPOutputStream gZIPOutputStream3 = null;
            try {
                ? byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    aVar = new a(byteArrayOutputStream, i3 | 1);
                } catch (IOException e2) {
                    e = e2;
                    aVar = null;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    aVar = null;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    aVar.close();
                    r2.close();
                    throw th;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(aVar);
                    try {
                        gZIPOutputStream.write(bArr2, i4, i5);
                        gZIPOutputStream.close();
                        gZIPOutputStream.close();
                        aVar.close();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e3) {
                        e = e3;
                        gZIPOutputStream3 = byteArrayOutputStream;
                        throw e;
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPOutputStream2 = byteArrayOutputStream;
                        gZIPOutputStream3 = gZIPOutputStream;
                        r2 = gZIPOutputStream2;
                        gZIPOutputStream3.close();
                        aVar.close();
                        r2.close();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    aVar.close();
                    r2.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                aVar = null;
                gZIPOutputStream = null;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                r2 = 0;
                aVar = null;
                gZIPOutputStream3.close();
                aVar.close();
                r2.close();
                throw th;
            }
        } else {
            boolean z = (i3 & 8) != 0;
            int i6 = ((i5 / 3) * 4) + (i5 % 3 > 0 ? 4 : 0);
            if (z) {
                i6 += i6 / 76;
            }
            byte[] bArr3 = new byte[i6];
            int i7 = i5 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                a(bArr, i8 + i4, 3, bArr3, i9, i3);
                int i11 = i10 + 4;
                if (!z || i11 < 76) {
                    i10 = i11;
                } else {
                    bArr3[i9 + 4] = 10;
                    i9++;
                    i10 = 0;
                }
                i8 += 3;
                i9 += 4;
            }
            if (i8 < i5) {
                a(bArr, i8 + i4, i5 - i8, bArr3, i9, i3);
                i9 += 4;
            }
            int i12 = i9;
            if (i12 > bArr3.length - 1) {
                return bArr3;
            }
            byte[] bArr4 = new byte[i12];
            System.arraycopy(bArr3, 0, bArr4, 0, i12);
            return bArr4;
        }
    }

    /* access modifiers changed from: private */
    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        } else if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        } else {
            byte[] c2 = c(i3);
            int i6 = i + 2;
            if (bArr[i6] == 61) {
                bArr2[i2] = (byte) ((((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i4] == 61) {
                int i7 = ((c2[bArr[i6]] & 255) << 6) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18);
                bArr2[i2] = (byte) (i7 >>> 16);
                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                return 2;
            } else {
                byte b2 = (c2[bArr[i4]] & 255) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i6]] & 255) << 6);
                bArr2[i2] = (byte) (b2 >> 16);
                bArr2[i2 + 1] = (byte) (b2 >> 8);
                bArr2[i5] = (byte) b2;
                return 3;
            }
        }
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 >= 4) {
                byte[] c2 = c(i3);
                byte[] bArr2 = new byte[((i2 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i5 = 0;
                int i6 = 0;
                while (i < i4) {
                    byte b2 = c2[bArr[i] & 255];
                    if (b2 >= -5) {
                        if (b2 >= -1) {
                            int i7 = i5 + 1;
                            bArr3[i5] = bArr[i];
                            if (i7 > 3) {
                                i6 += b(bArr3, 0, bArr2, i6, i3);
                                if (bArr[i] == 61) {
                                    break;
                                }
                                i5 = 0;
                            } else {
                                i5 = i7;
                            }
                        }
                        i++;
                    } else {
                        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                    }
                }
                byte[] bArr4 = new byte[i6];
                System.arraycopy(bArr2, 0, bArr4, 0, i6);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i2)));
        }
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:16|17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:67))|27|28|29)|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:52|53|54|55|56|57|58|59|60|61) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0085 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0088 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static byte[] a(String str, int i) throws IOException {
        byte[] bArr;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bArr = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bArr = str.getBytes();
            }
            byte[] c2 = c(bArr, 0, bArr.length, i);
            boolean z = (i & 4) != 0;
            if (c2 != null && c2.length >= 4 && !z && 35615 == ((c2[0] & 255) | ((c2[1] << 8) & 65280))) {
                byte[] bArr2 = new byte[2048];
                ? r0 = 0;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(c2);
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                        r0 = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            r0.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return c2;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = r0;
                            r0 = gZIPInputStream;
                            byteArrayOutputStream.close();
                            r0.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = null;
                        byteArrayOutputStream.close();
                        r0.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream.read(bArr2);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (IOException e3) {
                                e = e3;
                                r0 = byteArrayOutputStream;
                                e.printStackTrace();
                                r0.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                return c2;
                            } catch (Throwable th3) {
                                th = th3;
                                r0 = gZIPInputStream;
                                byteArrayOutputStream.close();
                                r0.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        }
                        c2 = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        gZIPInputStream = null;
                        r0 = byteArrayOutputStream;
                        e.printStackTrace();
                        r0.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return c2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream.close();
                        r0.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    e.printStackTrace();
                    r0.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return c2;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayOutputStream.close();
                    r0.close();
                    byteArrayInputStream.close();
                    throw th;
                }
                gZIPInputStream.close();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused2) {
                }
            }
            return c2;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static class a extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3419a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public a(OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f = (i2 & 8) != 0;
            this.f3419a = (i2 & 1) == 0 ? false : z;
            this.d = this.f3419a ? 3 : 4;
            this.c = new byte[this.d];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i2;
            this.j = f.c(i2);
        }

        public void write(int i2) throws IOException {
            if (this.h) {
                this.out.write(i2);
            } else if (this.f3419a) {
                byte[] bArr = this.c;
                int i3 = this.b;
                this.b = i3 + 1;
                bArr[i3] = (byte) i2;
                if (this.b >= this.d) {
                    this.out.write(f.b(this.g, this.c, this.d, this.i));
                    this.e += 4;
                    if (this.f && this.e >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte[] bArr2 = this.j;
                int i4 = i2 & 127;
                if (bArr2[i4] > -5) {
                    byte[] bArr3 = this.c;
                    int i5 = this.b;
                    this.b = i5 + 1;
                    bArr3[i5] = (byte) i2;
                    if (this.b >= this.d) {
                        this.out.write(this.g, 0, f.b(bArr3, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (bArr2[i4] != -5) {
                    throw new IOException("Invalid character in Base64Util data.");
                }
            }
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.h) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }

        public void a() throws IOException {
            if (this.b <= 0) {
                return;
            }
            if (this.f3419a) {
                this.out.write(f.b(this.g, this.c, this.b, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64Util input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }
    }
}
