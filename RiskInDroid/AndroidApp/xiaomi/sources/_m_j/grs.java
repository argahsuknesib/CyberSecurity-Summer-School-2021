package _m_j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class grs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f18187O000000o = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] O00000Oo = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] O00000o = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] O00000o0 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] O00000oO = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] O00000oo = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9};

    public static byte[] O000000o(int i) {
        if ((i & 16) == 16) {
            return O00000o0;
        }
        if ((i & 32) == 32) {
            return O00000oO;
        }
        return f18187O000000o;
    }

    public static byte[] O00000Oo(int i) {
        if ((i & 16) == 16) {
            return O00000o;
        }
        if ((i & 32) == 32) {
            return O00000oo;
        }
        return O00000Oo;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, int i, int i2) {
        O000000o(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    private static byte[] O000000o(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] O000000o2 = O000000o(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = O000000o2[i7 >>> 18];
            bArr2[i3 + 1] = O000000o2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = O000000o2[i7 >>> 18];
            bArr2[i3 + 1] = O000000o2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = O000000o2[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = O000000o2[i7 >>> 18];
            bArr2[i3 + 1] = O000000o2[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = O000000o2[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = O000000o2[i7 & 63];
            return bArr2;
        }
    }

    public static String O00000Oo(byte[] bArr) {
        return O000000o(bArr, bArr.length, 24);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: _m_j.grs$O000000o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: _m_j.grs$O000000o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: _m_j.grs$O000000o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: _m_j.grs$O000000o} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:37|38|39|40|41|42|(2:43|44)|45) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:47|48|49|50|51|52|53|54|55) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x006e */
    /* JADX WARNING: Multi-variable type inference failed */
    private static String O000000o(byte[] bArr, int i, int i2) {
        int i3;
        O000000o o000000o;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        O000000o o000000o2;
        GZIPOutputStream gZIPOutputStream2;
        O000000o o000000o3;
        int i4 = i;
        int i5 = i2 & 8;
        if ((i2 & 2) == 2) {
            GZIPOutputStream gZIPOutputStream3 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    o000000o3 = new O000000o(byteArrayOutputStream, i2 | 1);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(o000000o3);
                    } catch (IOException e) {
                        e = e;
                        gZIPOutputStream = null;
                        o000000o2 = o000000o3;
                        try {
                            e.printStackTrace();
                            gZIPOutputStream.close();
                            o000000o2.close();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream3 = gZIPOutputStream;
                            o000000o = o000000o2;
                            gZIPOutputStream3.close();
                            o000000o.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        o000000o = o000000o3;
                        gZIPOutputStream3.close();
                        o000000o.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream2 = null;
                    gZIPOutputStream = gZIPOutputStream2;
                    o000000o2 = gZIPOutputStream2;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    o000000o2.close();
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    o000000o = null;
                    gZIPOutputStream3.close();
                    o000000o.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
                try {
                    gZIPOutputStream.write(bArr, 0, i4);
                    gZIPOutputStream.close();
                    gZIPOutputStream.close();
                    o000000o3.close();
                    byteArrayOutputStream.close();
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    o000000o2 = o000000o3;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    o000000o2.close();
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = null;
                gZIPOutputStream2 = null;
                gZIPOutputStream = gZIPOutputStream2;
                o000000o2 = gZIPOutputStream2;
                e.printStackTrace();
                gZIPOutputStream.close();
                o000000o2.close();
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                o000000o = null;
                gZIPOutputStream3.close();
                o000000o.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            boolean z = i5 == 0;
            int i6 = (i4 * 4) / 3;
            byte[] bArr2 = new byte[((i4 % 3 > 0 ? 4 : 0) + i6 + (z ? i6 / 76 : 0))];
            int i7 = i4 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                int i11 = i8;
                int i12 = i7;
                O000000o(bArr, i8 + 0, 3, bArr2, i9, i2);
                int i13 = i10 + 4;
                if (!z || i13 != 76) {
                    i10 = i13;
                } else {
                    bArr2[i9 + 4] = 10;
                    i9++;
                    i10 = 0;
                }
                i8 = i11 + 3;
                i9 += 4;
                i7 = i12;
            }
            int i14 = i8;
            if (i14 < i4) {
                int i15 = i4 - i14;
                O000000o(bArr, i14 + 0, i15, bArr2, i9, i2);
                if ((i2 & 16) != 16) {
                    i9 += 4;
                } else if (i15 == 0) {
                    i9++;
                } else if (i15 == 1) {
                    i9 += 2;
                } else if (i15 == 2) {
                    i9 += 3;
                }
            }
            int i16 = i9;
            try {
                i3 = 0;
                try {
                    return new String(bArr2, 0, i16, "UTF-8");
                } catch (UnsupportedEncodingException unused3) {
                    return new String(bArr2, i3, i16);
                }
            } catch (UnsupportedEncodingException unused4) {
                i3 = 0;
                return new String(bArr2, i3, i16);
            }
        }
    }

    public static int O00000Oo(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] O00000Oo2 = O00000Oo(i2);
        if (bArr[2] == 61) {
            bArr2[i] = (byte) ((((O00000Oo2[bArr[1]] & 255) << 12) | ((O00000Oo2[bArr[0]] & 255) << 18)) >>> 16);
            return 1;
        } else if (bArr[3] == 61) {
            int i3 = ((O00000Oo2[bArr[2]] & 255) << 6) | ((O00000Oo2[bArr[0]] & 255) << 18) | ((O00000Oo2[bArr[1]] & 255) << 12);
            bArr2[i] = (byte) (i3 >>> 16);
            bArr2[i + 1] = (byte) (i3 >>> 8);
            return 2;
        } else {
            try {
                byte b = ((O00000Oo2[bArr[0]] & 255) << 18) | ((O00000Oo2[bArr[1]] & 255) << 12) | ((O00000Oo2[bArr[2]] & 255) << 6) | (O00000Oo2[bArr[3]] & 255);
                bArr2[i] = (byte) (b >> 16);
                bArr2[i + 1] = (byte) (b >> 8);
                bArr2[i + 2] = (byte) b;
                return 3;
            } catch (Exception unused) {
                PrintStream printStream = System.out;
                printStream.println(((int) bArr[0]) + ": " + ((int) O00000Oo2[bArr[0]]));
                PrintStream printStream2 = System.out;
                printStream2.println(((int) bArr[1]) + ": " + ((int) O00000Oo2[bArr[1]]));
                PrintStream printStream3 = System.out;
                printStream3.println(((int) bArr[2]) + ": " + ((int) O00000Oo2[bArr[2]]));
                PrintStream printStream4 = System.out;
                printStream4.println(((int) bArr[3]) + ": " + ((int) O00000Oo2[bArr[3]]));
                return -1;
            }
        }
    }

    public static byte[] O000000o(String str) {
        return O000000o(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:31|32|(3:33|34|(1:36)(1:77))|37|38|39|40|41) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:47|46|65|66|67|68|42|43|69) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:49|50|55|56|57|58|59|60|61) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00ad */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00cc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00cf */
    public static byte[] O000000o(String str, int i) {
        byte[] bArr;
        GZIPInputStream gZIPInputStream;
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        int length = bArr.length;
        byte[] O00000Oo2 = O00000Oo(i);
        byte[] bArr3 = new byte[((length * 3) / 4)];
        byte[] bArr4 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            gZIPInputStream = null;
            if (i2 < length + 0) {
                byte b = (byte) (bArr[i2] & Byte.MAX_VALUE);
                byte b2 = O00000Oo2[b];
                if (b2 < -5) {
                    System.err.println("Bad Base64Coder input character at " + i2 + ": " + ((int) bArr[i2]) + "(decimal)");
                    bArr2 = null;
                    break;
                }
                if (b2 >= -1) {
                    int i5 = i3 + 1;
                    bArr4[i3] = b;
                    if (i5 > 3) {
                        i4 += O00000Oo(bArr4, bArr3, i4, i);
                        if (b == 61) {
                            break;
                        }
                        i3 = 0;
                    } else {
                        i3 = i5;
                    }
                }
                i2++;
            } else {
                break;
            }
        }
        bArr2 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr2, 0, i4);
        if (bArr2 != null && bArr2.length >= 4 && 35615 == ((bArr2[0] & 255) | ((bArr2[1] << 8) & 65280))) {
            byte[] bArr5 = new byte[2048];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr2);
                } catch (IOException unused2) {
                    byteArrayInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = null;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
                try {
                    GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                    while (true) {
                        try {
                            int read = gZIPInputStream2.read(bArr5);
                            if (read < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr5, 0, read);
                        } catch (IOException unused3) {
                            gZIPInputStream = gZIPInputStream2;
                            byteArrayOutputStream.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return bArr2;
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPInputStream = gZIPInputStream2;
                            byteArrayOutputStream.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    gZIPInputStream2.close();
                } catch (IOException ) {
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (IOException unused4) {
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused5) {
            }
        }
        return bArr2;
    }

    public static class O000000o extends FilterOutputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f18188O000000o;
        private int O00000Oo;
        private int O00000o;
        private byte[] O00000o0;
        private int O00000oO;
        private boolean O00000oo;
        private byte[] O0000O0o;
        private boolean O0000OOo;
        private byte[] O0000Oo;
        private int O0000Oo0;
        private byte[] O0000OoO;

        public O000000o(OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.O00000oo = (i & 8) != 8;
            this.f18188O000000o = (i & 1) != 1 ? false : z;
            this.O00000o = this.f18188O000000o ? 3 : 4;
            this.O00000o0 = new byte[this.O00000o];
            this.O00000Oo = 0;
            this.O00000oO = 0;
            this.O0000OOo = false;
            this.O0000O0o = new byte[4];
            this.O0000Oo0 = i;
            this.O0000Oo = grs.O000000o(i);
            this.O0000OoO = grs.O00000Oo(i);
        }

        public final void write(int i) throws IOException {
            if (this.O0000OOo) {
                this.out.write(i);
            } else if (this.f18188O000000o) {
                byte[] bArr = this.O00000o0;
                int i2 = this.O00000Oo;
                this.O00000Oo = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.O00000Oo >= this.O00000o) {
                    this.out.write(grs.O000000o(this.O0000O0o, this.O00000o0, this.O00000o, this.O0000Oo0));
                    this.O00000oO += 4;
                    if (this.O00000oo && this.O00000oO >= 76) {
                        this.out.write(10);
                        this.O00000oO = 0;
                    }
                    this.O00000Oo = 0;
                }
            } else {
                byte[] bArr2 = this.O0000OoO;
                int i3 = i & 127;
                if (bArr2[i3] > -5) {
                    byte[] bArr3 = this.O00000o0;
                    int i4 = this.O00000Oo;
                    this.O00000Oo = i4 + 1;
                    bArr3[i4] = (byte) i;
                    if (this.O00000Oo >= this.O00000o) {
                        this.out.write(this.O0000O0o, 0, grs.O00000Oo(bArr3, this.O0000O0o, 0, this.O0000Oo0));
                        this.O00000Oo = 0;
                    }
                } else if (bArr2[i3] != -5) {
                    throw new IOException("Invalid character in Base64Coder data.");
                }
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.O0000OOo) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public final void close() throws IOException {
            if (this.O00000Oo > 0) {
                if (this.f18188O000000o) {
                    this.out.write(grs.O000000o(this.O0000O0o, this.O00000o0, this.O00000Oo, this.O0000Oo0));
                    this.O00000Oo = 0;
                } else {
                    throw new IOException("Base64Coder input not properly padded.");
                }
            }
            super.close();
            this.O00000o0 = null;
            this.out = null;
        }
    }

    public static String O000000o(byte[] bArr) {
        return O000000o(bArr, bArr.length, 8);
    }
}
