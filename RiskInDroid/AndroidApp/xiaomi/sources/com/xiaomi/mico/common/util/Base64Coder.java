package com.xiaomi.mico.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Base64Coder {
    private static final byte[] _ORDERED_ALPHABET = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9};
    private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    public static final byte[] getAlphabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    public static final byte[] getDecodabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    private Base64Coder() {
    }

    public static final void main(String[] strArr) {
        if (strArr.length < 3) {
            usage("Not enough arguments.");
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        if (str.equals("-e")) {
            encodeFileToFile(str2, str3);
        } else if (str.equals("-d")) {
            decodeFileToFile(str2, str3);
        } else {
            usage("Unknown flag: ".concat(String.valueOf(str)));
        }
    }

    private static final void usage(String str) {
        System.err.println(str);
        System.err.println("Usage: java Base64Coder -e|-d inputfile outputfile");
    }

    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = alphabet[i7 & 63];
            return bArr2;
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:47|48|49|50|51|52|53|54|55|56|57) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:59|60|61|62|63|64|65|66|67|68|69) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:18|19|20|21|22|23|24|25|26|27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        return new java.lang.String(r2.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0036 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0087 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x008a */
    public static String encodeObject(Serializable serializable, int i) {
        GZIPOutputStream gZIPOutputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        int i2 = i & 2;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i | 1);
                if (i2 == 2) {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            gZIPOutputStream2 = gZIPOutputStream;
                            objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                        } catch (IOException e) {
                            e = e;
                            gZIPOutputStream2 = gZIPOutputStream;
                            objectOutputStream = null;
                            try {
                                e.printStackTrace();
                                objectOutputStream.close();
                                gZIPOutputStream2.close();
                                outputStream.close();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused) {
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                gZIPOutputStream = gZIPOutputStream2;
                                objectOutputStream2.close();
                                gZIPOutputStream.close();
                                outputStream.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream2.close();
                            gZIPOutputStream.close();
                            outputStream.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = null;
                        gZIPOutputStream2 = null;
                        e.printStackTrace();
                        objectOutputStream.close();
                        gZIPOutputStream2.close();
                        outputStream.close();
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPOutputStream = null;
                        objectOutputStream2.close();
                        gZIPOutputStream.close();
                        outputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } else {
                    objectOutputStream = new ObjectOutputStream(outputStream);
                    gZIPOutputStream2 = null;
                }
                try {
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.close();
                    gZIPOutputStream2.close();
                    outputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    objectOutputStream.close();
                    gZIPOutputStream2.close();
                    outputStream.close();
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = null;
                gZIPOutputStream2 = null;
                outputStream = null;
                e.printStackTrace();
                objectOutputStream.close();
                gZIPOutputStream2.close();
                outputStream.close();
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                outputStream = null;
                objectOutputStream2.close();
                gZIPOutputStream.close();
                outputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            objectOutputStream = null;
            gZIPOutputStream2 = null;
            byteArrayOutputStream = null;
            outputStream = null;
            e.printStackTrace();
            objectOutputStream.close();
            gZIPOutputStream2.close();
            outputStream.close();
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
            objectOutputStream2.close();
            gZIPOutputStream.close();
            outputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public static String encode(byte[] bArr) {
        return encodeBytes(bArr);
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, 0, bArr.length, 8);
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        return encodeBytes(bArr, i, i2, 8);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.xiaomi.mico.common.util.Base64Coder$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.xiaomi.mico.common.util.Base64Coder$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: com.xiaomi.mico.common.util.Base64Coder$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: com.xiaomi.mico.common.util.Base64Coder$OutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:26|27|37|38|39|40|41|42|43|44|45) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:47|48|49|50|51|52|53|54|55) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x006f */
    /* JADX WARNING: Multi-variable type inference failed */
    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) {
        int i4;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        OutputStream outputStream2;
        GZIPOutputStream gZIPOutputStream2;
        OutputStream outputStream3;
        int i5 = i;
        int i6 = i2;
        int i7 = i3 & 8;
        if ((i3 & 2) == 2) {
            GZIPOutputStream gZIPOutputStream3 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    outputStream3 = new OutputStream(byteArrayOutputStream, i3 | 1);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(outputStream3);
                    } catch (IOException e) {
                        e = e;
                        gZIPOutputStream = null;
                        outputStream2 = outputStream3;
                        try {
                            e.printStackTrace();
                            gZIPOutputStream.close();
                            outputStream2.close();
                            byteArrayOutputStream.close();
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream3 = gZIPOutputStream;
                            outputStream = outputStream2;
                            gZIPOutputStream3.close();
                            outputStream.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream3;
                        gZIPOutputStream3.close();
                        outputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream2 = null;
                    gZIPOutputStream = gZIPOutputStream2;
                    outputStream2 = gZIPOutputStream2;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    outputStream2.close();
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    gZIPOutputStream3.close();
                    outputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
                try {
                    gZIPOutputStream.write(bArr, i5, i6);
                    gZIPOutputStream.close();
                    gZIPOutputStream.close();
                    outputStream3.close();
                    byteArrayOutputStream.close();
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    outputStream2 = outputStream3;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    outputStream2.close();
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = null;
                gZIPOutputStream2 = null;
                gZIPOutputStream = gZIPOutputStream2;
                outputStream2 = gZIPOutputStream2;
                e.printStackTrace();
                gZIPOutputStream.close();
                outputStream2.close();
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                outputStream = null;
                gZIPOutputStream3.close();
                outputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            boolean z = i7 == 0;
            int i8 = (i6 * 4) / 3;
            byte[] bArr2 = new byte[((i6 % 3 > 0 ? 4 : 0) + i8 + (z ? i8 / 76 : 0))];
            int i9 = i6 - 2;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < i9) {
                int i13 = i10;
                int i14 = i9;
                byte[] bArr3 = bArr2;
                encode3to4(bArr, i10 + i5, 3, bArr2, i11, i3);
                int i15 = i12 + 4;
                if (!z || i15 != 76) {
                    i12 = i15;
                } else {
                    bArr3[i11 + 4] = 10;
                    i11++;
                    i12 = 0;
                }
                i10 = i13 + 3;
                i11 += 4;
                bArr2 = bArr3;
                i9 = i14;
            }
            int i16 = i10;
            byte[] bArr4 = bArr2;
            if (i16 < i6) {
                int i17 = i6 - i16;
                encode3to4(bArr, i16 + i5, i17, bArr4, i11, i3);
                if ((i3 & 16) != 16) {
                    i11 += 4;
                } else if (i17 == 0) {
                    i11++;
                } else if (i17 == 1) {
                    i11 += 2;
                } else if (i17 == 2) {
                    i11 += 3;
                }
            }
            int i18 = i11;
            try {
                i4 = 0;
                try {
                    return new String(bArr4, 0, i18, "UTF-8");
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr4, i4, i18);
                }
            } catch (UnsupportedEncodingException unused3) {
                i4 = 0;
                return new String(bArr4, i4, i18);
            }
        }
    }

    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] decodabet = getDecodabet(i3);
        int i4 = i + 2;
        if (bArr[i4] == 61) {
            bArr2[i2] = (byte) ((((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i5 = i + 3;
        if (bArr[i5] == 61) {
            int i6 = (decodabet[bArr[i + 1]] & 255) << 12;
            int i7 = ((decodabet[bArr[i4]] & 255) << 6) | i6 | ((decodabet[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i7 >>> 16);
            bArr2[i2 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        try {
            byte b = ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i4]] & 255) << 6) | (decodabet[bArr[i5]] & 255);
            bArr2[i2] = (byte) (b >> 16);
            bArr2[i2 + 1] = (byte) (b >> 8);
            bArr2[i2 + 2] = (byte) b;
            return 3;
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println(((int) bArr[i]) + ": " + ((int) decodabet[bArr[i]]));
            PrintStream printStream2 = System.out;
            StringBuilder sb = new StringBuilder();
            int i8 = i + 1;
            sb.append((int) bArr[i8]);
            sb.append(": ");
            sb.append((int) decodabet[bArr[i8]]);
            printStream2.println(sb.toString());
            PrintStream printStream3 = System.out;
            printStream3.println(((int) bArr[i4]) + ": " + ((int) decodabet[bArr[i4]]));
            PrintStream printStream4 = System.out;
            printStream4.println(((int) bArr[i5]) + ": " + ((int) decodabet[bArr[i5]]));
            return -1;
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        byte[] decodabet = getDecodabet(i3);
        byte[] bArr2 = new byte[((i2 * 3) / 4)];
        byte[] bArr3 = new byte[4];
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i + i2) {
            byte b = (byte) (bArr[i4] & Byte.MAX_VALUE);
            byte b2 = decodabet[b];
            if (b2 >= -5) {
                if (b2 >= -1) {
                    int i7 = i5 + 1;
                    bArr3[i5] = b;
                    if (i7 > 3) {
                        i6 += decode4to3(bArr3, 0, bArr2, i6, i3);
                        if (b == 61) {
                            break;
                        }
                        i5 = 0;
                    } else {
                        i5 = i7;
                    }
                }
                i4++;
            } else {
                PrintStream printStream = System.err;
                printStream.println("Bad Base64Coder input character at " + i4 + ": " + ((int) bArr[i4]) + "(decimal)");
                return null;
            }
        }
        byte[] bArr4 = new byte[i6];
        System.arraycopy(bArr2, 0, bArr4, 0, i6);
        return bArr4;
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|(3:18|19|(1:21)(1:56))|22|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:29|30|40|41|42|43|44|45|46) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:32|31|50|51|52|53|27|28|54) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0071 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0074 */
    public static byte[] decode(String str, int i) {
        byte[] bArr;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        byte[] decode = decode(bArr, 0, bArr.length, i);
        if (decode != null && decode.length >= 4 && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
            byte[] bArr2 = new byte[2048];
            gZIPInputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(decode);
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream2.read(bArr2);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (IOException unused2) {
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                return decode;
                            } catch (Throwable th) {
                                th = th;
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        }
                        decode = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        gZIPInputStream2.close();
                    } catch (IOException ) {
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException unused3) {
                    byteArrayInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream = null;
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
        return decode;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:1:0x0005 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:22:0x002c */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|31|32|33|34|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(3:1|2|(4:3|4|5|6))|7|8|9|10|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static Object decodeToObject(String str) {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        ? decode = decode(str);
        ObjectInputStream objectInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(decode);
            try {
                ObjectInputStream objectInputStream3 = new ObjectInputStream(byteArrayInputStream);
                try {
                    ? readObject = objectInputStream3.readObject();
                    decode = objectInputStream3;
                    objectInputStream2 = readObject;
                } catch (IOException e) {
                    e = e;
                    objectInputStream = objectInputStream3;
                    e.printStackTrace();
                    decode = objectInputStream;
                    byteArrayInputStream.close();
                    decode.close();
                    return objectInputStream2;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    decode = objectInputStream3;
                    e.printStackTrace();
                    byteArrayInputStream.close();
                    decode.close();
                    return objectInputStream2;
                }
            } catch (IOException e3) {
                e = e3;
                objectInputStream = null;
                e.printStackTrace();
                decode = objectInputStream;
                byteArrayInputStream.close();
                decode.close();
                return objectInputStream2;
            } catch (ClassNotFoundException e4) {
                e = e4;
                decode = 0;
                e.printStackTrace();
                byteArrayInputStream.close();
                decode.close();
                return objectInputStream2;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream.close();
                objectInputStream2.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            objectInputStream = null;
            byteArrayInputStream = null;
            e.printStackTrace();
            decode = objectInputStream;
            byteArrayInputStream.close();
            decode.close();
            return objectInputStream2;
        } catch (ClassNotFoundException e6) {
            e = e6;
            decode = 0;
            byteArrayInputStream = null;
            e.printStackTrace();
            byteArrayInputStream.close();
            decode.close();
            return objectInputStream2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream2 = decode;
            th = th4;
            byteArrayInputStream.close();
            objectInputStream2.close();
            throw th;
        }
        byteArrayInputStream.close();
        decode.close();
        return objectInputStream2;
    }

    public static boolean encodeToFile(byte[] bArr, String str) {
        boolean z = true;
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
            try {
                outputStream2.write(bArr);
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException unused2) {
                outputStream = outputStream2;
                z = false;
                outputStream.close();
                return z;
            } catch (Throwable th) {
                th = th;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            z = false;
            outputStream.close();
            return z;
        } catch (Throwable th2) {
            th = th2;
            outputStream.close();
            throw th;
        }
        return z;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0024 */
    public static boolean decodeToFile(String str, String str2) {
        OutputStream outputStream;
        boolean z = false;
        outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("UTF-8"));
                z = true;
            } catch (IOException unused) {
                outputStream = outputStream2;
                outputStream.close();
                return z;
            } catch (Throwable th) {
                th = th;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                outputStream2.close();
            } catch (Exception unused3) {
            }
        } catch (IOException ) {
            outputStream.close();
        } catch (Throwable th2) {
            th = th2;
            outputStream.close();
            throw th;
        }
        return z;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.xiaomi.mico.common.util.Base64Coder$InputStream} */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[], com.xiaomi.mico.common.util.Base64Coder$InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    public static byte[] decodeFromFile(String str) {
        InputStream inputStream;
        byte[] bArr;
        ? r0 = 0;
        try {
            File file = new File(str);
            if (file.length() > 2147483647L) {
                PrintStream printStream = System.err;
                printStream.println("File is too big for this convenience method (" + file.length() + " bytes).");
                try {
                    r0.close();
                } catch (Exception unused) {
                }
                return r0;
            }
            byte[] bArr2 = new byte[((int) file.length())];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
            int i = 0;
            while (true) {
                try {
                    int read = inputStream2.read(bArr2, i, 4096);
                    if (read >= 0) {
                        i += read;
                    } else {
                        byte[] bArr3 = new byte[i];
                        System.arraycopy(bArr2, 0, bArr3, 0, i);
                        try {
                            inputStream2.close();
                            return bArr3;
                        } catch (Exception unused2) {
                            return bArr3;
                        }
                    }
                } catch (IOException unused3) {
                    bArr = r0;
                    r0 = inputStream2;
                    try {
                        System.err.println("Error decoding from file ".concat(String.valueOf(str)));
                        try {
                            r0.close();
                        } catch (Exception unused4) {
                        }
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = r0;
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    inputStream.close();
                    throw th;
                }
            }
        } catch (IOException unused6) {
            bArr = r0;
            System.err.println("Error decoding from file ".concat(String.valueOf(str)));
            r0.close();
            return bArr;
        }
    }

    public static String encodeFromFile(String str) {
        return encodeFromFile(str, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        java.lang.System.err.println("Error encoding from file ".concat(java.lang.String.valueOf(r6)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0048 */
    public static String encodeFromFile(String str, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            File file = new File(str);
            double length = (double) file.length();
            Double.isNaN(length);
            byte[] bArr = new byte[Math.max((int) (length * 1.4d), 40)];
            inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), i);
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr, i2, 4096);
                if (read >= 0) {
                    i2 += read;
                } else {
                    String str2 = new String(bArr, 0, i2, "UTF-8");
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return str2;
                }
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                inputStream2.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public static void encodeFileToFile(String str, String str2) {
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    public static void decodeFileToFile(String str, String str2) {
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(decodeFromFile);
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    public static class InputStream extends FilterInputStream {
        private byte[] alphabet;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int numSigBytes;
        private int options;
        private int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            boolean z = true;
            this.breakLines = (i & 8) != 8;
            this.encode = (i & 1) != 1 ? false : z;
            this.bufferLength = this.encode ? 4 : 3;
            this.buffer = new byte[this.bufferLength];
            this.position = -1;
            this.lineLength = 0;
            this.options = i;
            this.alphabet = Base64Coder.getAlphabet(i);
            this.decodabet = Base64Coder.getDecodabet(i);
        }

        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        try {
                            int read2 = this.in.read();
                            if (read2 >= 0) {
                                bArr[i2] = (byte) read2;
                                i++;
                            }
                        } catch (IOException e) {
                            if (i2 == 0) {
                                throw e;
                            }
                        }
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64Coder.encode3to4(bArr, 0, i, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 == 4) {
                        this.numSigBytes = Base64Coder.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                        this.position = 0;
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64Coder input.");
                    }
                }
            }
            int i4 = this.position;
            if (i4 < 0) {
                throw new IOException("Error in Base64Coder code reading stream.");
            } else if (i4 >= this.numSigBytes) {
                return -1;
            } else {
                if (!this.encode || !this.breakLines || this.lineLength < 76) {
                    this.lineLength++;
                    byte[] bArr3 = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    byte b = bArr3[i5];
                    if (this.position >= this.bufferLength) {
                        this.position = -1;
                    }
                    return b & 255;
                }
                this.lineLength = 0;
                return 10;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class OutputStream extends FilterOutputStream {
        private byte[] alphabet;
        private byte[] b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.breakLines = (i & 8) != 8;
            this.encode = (i & 1) != 1 ? false : z;
            this.bufferLength = this.encode ? 3 : 4;
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = i;
            this.alphabet = Base64Coder.getAlphabet(i);
            this.decodabet = Base64Coder.getDecodabet(i);
        }

        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(i);
            } else if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.position >= this.bufferLength) {
                    this.out.write(Base64Coder.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else {
                byte[] bArr2 = this.decodabet;
                int i3 = i & 127;
                if (bArr2[i3] > -5) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) i;
                    if (this.position >= this.bufferLength) {
                        this.out.write(this.b4, 0, Base64Coder.decode4to3(bArr3, 0, this.b4, 0, this.options));
                        this.position = 0;
                    }
                } else if (bArr2[i3] != -5) {
                    throw new IOException("Invalid character in Base64Coder data.");
                }
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.position <= 0) {
                return;
            }
            if (this.encode) {
                this.out.write(Base64Coder.encode3to4(this.b4, this.buffer, this.position, this.options));
                this.position = 0;
                return;
            }
            throw new IOException("Base64Coder input not properly padded.");
        }

        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }
    }
}
