package _m_j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

public class bwh {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f13334O000000o = (!bwh.class.desiredAssertionStatus());
    private static final byte[] O00000Oo = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] O00000o = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] O00000o0 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] O00000oO = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] O00000oo = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] O0000O0o = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private bwh() {
    }

    public static String O000000o(byte[] bArr) {
        String str;
        try {
            str = O000000o(bArr, bArr.length);
        } catch (IOException e) {
            if (f13334O000000o) {
                str = null;
            } else {
                throw new AssertionError(e.getMessage());
            }
        }
        if (f13334O000000o || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static String O000000o(byte[] bArr, int i) throws IOException {
        byte[] bArr2;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
        } else if (i + 0 <= bArr.length) {
            int i2 = 4;
            int i3 = (i / 3) * 4;
            if (i % 3 <= 0) {
                i2 = 0;
            }
            byte[] bArr3 = new byte[(i3 + i2)];
            int i4 = i - 2;
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                O000000o(bArr, i5 + 0, 3, bArr3, i6);
                i5 += 3;
                i6 += 4;
            }
            if (i5 < i) {
                O000000o(bArr, i5 + 0, i - i5, bArr3, i6);
                i6 += 4;
            }
            if (i6 <= bArr3.length - 1) {
                bArr2 = new byte[i6];
                System.arraycopy(bArr3, 0, bArr2, 0, i6);
            } else {
                bArr2 = bArr3;
            }
            try {
                return new String(bArr2, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr2);
            }
        } else {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
        }
    }

    public static byte[] O000000o(String str) throws IOException {
        return O00000Oo(str);
    }

    private static byte[] O000000o(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = O00000Oo;
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i6 & 63];
            return bArr2;
        }
    }

    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:46|47|48|49|50|51|52|53|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|(8:13|14|15|16|(3:17|18|(1:20)(1:61))|21|22|23)|24|25|(2:26|27)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x007b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x007e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static byte[] O00000Oo(String str) throws IOException {
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
            byte[] O00000Oo2 = O00000Oo(bArr, bArr.length);
            if (O00000Oo2.length >= 4 && 35615 == ((O00000Oo2[0] & 255) | ((O00000Oo2[1] << 8) & 65280))) {
                byte[] bArr2 = new byte[2048];
                ? r2 = 0;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(O00000Oo2);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr2);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                } catch (IOException e) {
                                    e = e;
                                    r2 = byteArrayOutputStream;
                                    try {
                                        e.printStackTrace();
                                        r2.close();
                                        gZIPInputStream.close();
                                        byteArrayInputStream.close();
                                        return O00000Oo2;
                                    } catch (Throwable th) {
                                        th = th;
                                        byteArrayOutputStream = r2;
                                        r2 = gZIPInputStream;
                                        byteArrayOutputStream.close();
                                        r2.close();
                                        byteArrayInputStream.close();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r2 = gZIPInputStream;
                                    byteArrayOutputStream.close();
                                    r2.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            O00000Oo2 = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPInputStream = null;
                            r2 = byteArrayOutputStream;
                            e.printStackTrace();
                            r2.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return O00000Oo2;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream.close();
                            r2.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                        r2 = byteArrayOutputStream;
                        e.printStackTrace();
                        r2.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return O00000Oo2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        byteArrayOutputStream.close();
                        r2.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    e.printStackTrace();
                    r2.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return O00000Oo2;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayOutputStream.close();
                    r2.close();
                    byteArrayInputStream.close();
                    throw th;
                }
                gZIPInputStream.close();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused2) {
                }
            }
            return O00000Oo2;
        }
        throw new NullPointerException("Input string was null.");
    }

    private static byte[] O00000Oo(byte[] bArr, int i) throws IOException {
        int i2;
        int i3;
        if (bArr != null) {
            int i4 = i + 0;
            if (i4 > bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
            } else if (i == 0) {
                return new byte[0];
            } else {
                if (i >= 4) {
                    byte[] bArr2 = O00000o0;
                    byte[] bArr3 = new byte[((i * 3) / 4)];
                    byte[] bArr4 = new byte[4];
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i4) {
                        byte b = bArr2[bArr[i5] & 255];
                        if (b >= -5) {
                            if (b >= -1) {
                                int i8 = i6 + 1;
                                bArr4[i6] = bArr[i5];
                                if (i8 <= 3) {
                                    i6 = i8;
                                } else if (i7 < 0 || (i2 = i7 + 2) >= bArr3.length) {
                                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr3.length), Integer.valueOf(i7)));
                                } else {
                                    byte[] bArr5 = O00000o0;
                                    if (bArr4[2] == 61) {
                                        bArr3[i7] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[1]] & 255) << 12)) >>> 16);
                                        i3 = 1;
                                    } else if (bArr4[3] == 61) {
                                        int i9 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[1]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                        bArr3[i7] = (byte) (i9 >>> 16);
                                        bArr3[i7 + 1] = (byte) (i9 >>> 8);
                                        i3 = 2;
                                    } else {
                                        byte b2 = (bArr5[bArr4[3]] & 255) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[1]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                        bArr3[i7] = (byte) (b2 >> 16);
                                        bArr3[i7 + 1] = (byte) (b2 >> 8);
                                        bArr3[i2] = (byte) b2;
                                        i3 = 3;
                                    }
                                    i7 += i3;
                                    if (bArr[i5] == 61) {
                                        break;
                                    }
                                    i6 = 0;
                                }
                            }
                            i5++;
                        } else {
                            throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i5] & 255), Integer.valueOf(i5)));
                        }
                    }
                    byte[] bArr6 = new byte[i7];
                    System.arraycopy(bArr3, 0, bArr6, 0, i7);
                    return bArr6;
                }
                throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i)));
            }
        } else {
            throw new NullPointerException("Cannot decode null source array.");
        }
    }
}
