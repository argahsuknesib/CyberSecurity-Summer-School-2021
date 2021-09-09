package org.apache.commons.codec.binary;

import java.math.BigInteger;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Base64 implements BinaryDecoder, BinaryEncoder {
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private byte[] buffer;
    private int currentLinePos;
    private final int decodeSize;
    private final int encodeSize;
    private final byte[] encodeTable;
    private boolean eof;
    private final int lineLength;
    private final byte[] lineSeparator;
    private int modulus;
    private int pos;
    private int readPos;
    private int x;

    private static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    public Base64() {
        this(false);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            bArr = CHUNK_SEPARATOR;
            i = 0;
        }
        this.lineLength = i > 0 ? (i / 4) * 4 : 0;
        this.lineSeparator = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        if (i > 0) {
            this.encodeSize = bArr.length + 4;
        } else {
            this.encodeSize = 4;
        }
        this.decodeSize = this.encodeSize - 1;
        if (!containsBase64Byte(bArr)) {
            this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
            return;
        }
        String newStringUtf8 = StringUtils.newStringUtf8(bArr);
        StringBuffer stringBuffer = new StringBuffer("lineSeperator must not contain base64 characters: [");
        stringBuffer.append(newStringUtf8);
        stringBuffer.append("]");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* access modifiers changed from: package-private */
    public boolean hasData() {
        return this.buffer != null;
    }

    /* access modifiers changed from: package-private */
    public int avail() {
        if (this.buffer != null) {
            return this.pos - this.readPos;
        }
        return 0;
    }

    private void resizeBuffer() {
        byte[] bArr = this.buffer;
        if (bArr == null) {
            this.buffer = new byte[8192];
            this.pos = 0;
            this.readPos = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.buffer = bArr2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r2.readPos >= r2.pos) goto L_0x0020;
     */
    public int readResults(byte[] bArr, int i, int i2) {
        if (this.buffer == null) {
            return this.eof ? -1 : 0;
        }
        int min = Math.min(avail(), i2);
        byte[] bArr2 = this.buffer;
        if (bArr2 != bArr) {
            System.arraycopy(bArr2, this.readPos, bArr, i, min);
            this.readPos += min;
        }
        this.buffer = null;
        return min;
    }

    /* access modifiers changed from: package-private */
    public void setInitialBuffer(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length == i2) {
            this.buffer = bArr;
            this.pos = i;
            this.readPos = i;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public void encode(byte[] bArr, int i, int i2) {
        int i3;
        if (!this.eof) {
            if (i2 < 0) {
                this.eof = true;
                byte[] bArr2 = this.buffer;
                if (bArr2 == null || bArr2.length - this.pos < this.encodeSize) {
                    resizeBuffer();
                }
                int i4 = this.modulus;
                if (i4 == 1) {
                    byte[] bArr3 = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 + 1;
                    byte[] bArr4 = this.encodeTable;
                    int i6 = this.x;
                    bArr3[i5] = bArr4[(i6 >> 2) & 63];
                    int i7 = this.pos;
                    this.pos = i7 + 1;
                    bArr3[i7] = bArr4[(i6 << 4) & 63];
                    if (bArr4 == STANDARD_ENCODE_TABLE) {
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr3[i8] = 61;
                        int i9 = this.pos;
                        this.pos = i9 + 1;
                        bArr3[i9] = 61;
                    }
                } else if (i4 == 2) {
                    byte[] bArr5 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    byte[] bArr6 = this.encodeTable;
                    int i11 = this.x;
                    bArr5[i10] = bArr6[(i11 >> 10) & 63];
                    int i12 = this.pos;
                    this.pos = i12 + 1;
                    bArr5[i12] = bArr6[(i11 >> 4) & 63];
                    int i13 = this.pos;
                    this.pos = i13 + 1;
                    bArr5[i13] = bArr6[(i11 << 2) & 63];
                    if (bArr6 == STANDARD_ENCODE_TABLE) {
                        int i14 = this.pos;
                        this.pos = i14 + 1;
                        bArr5[i14] = 61;
                    }
                }
                if (this.lineLength > 0 && (i3 = this.pos) > 0) {
                    byte[] bArr7 = this.lineSeparator;
                    System.arraycopy(bArr7, 0, this.buffer, i3, bArr7.length);
                    this.pos += this.lineSeparator.length;
                    return;
                }
                return;
            }
            int i15 = i;
            int i16 = 0;
            while (i16 < i2) {
                byte[] bArr8 = this.buffer;
                if (bArr8 == null || bArr8.length - this.pos < this.encodeSize) {
                    resizeBuffer();
                }
                int i17 = this.modulus + 1;
                this.modulus = i17;
                this.modulus = i17 % 3;
                int i18 = i15 + 1;
                byte b = bArr[i15];
                int i19 = b;
                if (b < 0) {
                    i19 = b + 256;
                }
                this.x = (this.x << 8) + i19;
                if (this.modulus == 0) {
                    byte[] bArr9 = this.buffer;
                    int i20 = this.pos;
                    this.pos = i20 + 1;
                    byte[] bArr10 = this.encodeTable;
                    int i21 = this.x;
                    bArr9[i20] = bArr10[(i21 >> 18) & 63];
                    int i22 = this.pos;
                    this.pos = i22 + 1;
                    bArr9[i22] = bArr10[(i21 >> 12) & 63];
                    int i23 = this.pos;
                    this.pos = i23 + 1;
                    bArr9[i23] = bArr10[(i21 >> 6) & 63];
                    int i24 = this.pos;
                    this.pos = i24 + 1;
                    bArr9[i24] = bArr10[i21 & 63];
                    this.currentLinePos += 4;
                    int i25 = this.lineLength;
                    if (i25 > 0 && i25 <= this.currentLinePos) {
                        byte[] bArr11 = this.lineSeparator;
                        System.arraycopy(bArr11, 0, bArr9, this.pos, bArr11.length);
                        this.pos += this.lineSeparator.length;
                        this.currentLinePos = 0;
                    }
                }
                i16++;
                i15 = i18;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2) {
        int i3;
        byte b;
        if (!this.eof) {
            if (i2 < 0) {
                this.eof = true;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    break;
                }
                byte[] bArr2 = this.buffer;
                if (bArr2 == null || bArr2.length - this.pos < this.decodeSize) {
                    resizeBuffer();
                }
                int i5 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.eof = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr3 = DECODE_TABLE;
                    if (b2 < bArr3.length && (b = bArr3[b2]) >= 0) {
                        int i6 = this.modulus + 1;
                        this.modulus = i6;
                        this.modulus = i6 % 4;
                        this.x = (this.x << 6) + b;
                        if (this.modulus == 0) {
                            byte[] bArr4 = this.buffer;
                            int i7 = this.pos;
                            this.pos = i7 + 1;
                            int i8 = this.x;
                            bArr4[i7] = (byte) ((i8 >> 16) & 255);
                            int i9 = this.pos;
                            this.pos = i9 + 1;
                            bArr4[i9] = (byte) ((i8 >> 8) & 255);
                            int i10 = this.pos;
                            this.pos = i10 + 1;
                            bArr4[i10] = (byte) (i8 & 255);
                        }
                    }
                }
                i4++;
                i = i5;
            }
            if (this.eof && (i3 = this.modulus) != 0) {
                this.x <<= 6;
                if (i3 == 2) {
                    this.x <<= 6;
                    byte[] bArr5 = this.buffer;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    bArr5[i11] = (byte) ((this.x >> 16) & 255);
                } else if (i3 == 3) {
                    byte[] bArr6 = this.buffer;
                    int i12 = this.pos;
                    this.pos = i12 + 1;
                    int i13 = this.x;
                    bArr6[i12] = (byte) ((i13 >> 16) & 255);
                    int i14 = this.pos;
                    this.pos = i14 + 1;
                    bArr6[i14] = (byte) ((i13 >> 8) & 255);
                }
            }
        }
    }

    public static boolean isBase64(byte b) {
        if (b == 61) {
            return true;
        }
        if (b < 0) {
            return false;
        }
        byte[] bArr = DECODE_TABLE;
        return b < bArr.length && bArr[b] != -1;
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsBase64Byte(byte[] bArr) {
        for (byte isBase64 : bArr) {
            if (isBase64(isBase64)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, true));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base64 decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    public byte[] decode(byte[] bArr) {
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[((int) ((long) ((bArr.length * 3) / 4)))];
        setInitialBuffer(bArr2, 0, bArr2.length);
        decode(bArr, 0, bArr.length);
        decode(bArr, 0, -1);
        byte[] bArr3 = new byte[this.pos];
        readResults(bArr3, 0, bArr3.length);
        return bArr3;
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        long encodeLength = getEncodeLength(bArr, 76, CHUNK_SEPARATOR);
        if (encodeLength <= ((long) i)) {
            return (z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2)).encode(bArr);
        }
        StringBuffer stringBuffer = new StringBuffer("Input array too big, the output array would be bigger (");
        stringBuffer.append(encodeLength);
        stringBuffer.append(") than the specified maxium size of ");
        stringBuffer.append(i);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    static byte[] discardWhitespace(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            if (!(b == 9 || b == 10 || b == 13 || b == 32)) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] encode(byte[] bArr) {
        int i;
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[((int) getEncodeLength(bArr, this.lineLength, this.lineSeparator))];
        setInitialBuffer(bArr2, 0, bArr2.length);
        encode(bArr, 0, bArr.length);
        encode(bArr, 0, -1);
        if (this.buffer != bArr2) {
            readResults(bArr2, 0, bArr2.length);
        }
        if (!isUrlSafe() || (i = this.pos) >= bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    private static long getEncodeLength(byte[] bArr, int i, byte[] bArr2) {
        int i2 = (i / 4) * 4;
        long length = (long) ((bArr.length * 4) / 3);
        long j = length % 4;
        if (j != 0) {
            length += 4 - j;
        }
        if (i2 <= 0) {
            return length;
        }
        long j2 = (long) i2;
        boolean z = length % j2 == 0;
        long length2 = length + ((length / j2) * ((long) bArr2.length));
        return !z ? length2 + ((long) bArr2.length) : length2;
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int i = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i = 1;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    private void reset() {
        this.buffer = null;
        this.pos = 0;
        this.readPos = 0;
        this.currentLinePos = 0;
        this.modulus = 0;
        this.eof = false;
    }
}
