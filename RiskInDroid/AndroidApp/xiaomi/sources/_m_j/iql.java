package _m_j;

import android.support.v4.app.NotificationCompat;
import gK.f;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class iql implements iqm, iqn, Cloneable {
    private static final byte[] O00000o0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: O000000o  reason: collision with root package name */
    iqw f1560O000000o;
    public long O00000Oo;

    private String O000000o(long j, Charset charset) throws EOFException {
        irb.O000000o(this.O00000Oo, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        } else if (j == 0) {
            return "";
        } else {
            iqw iqw = this.f1560O000000o;
            if (((long) iqw.O00000Oo) + j > ((long) iqw.O00000o0)) {
                return new String(O00000oO(j), charset);
            }
            String str = new String(iqw.f1572O000000o, iqw.O00000Oo, (int) j, charset);
            iqw.O00000Oo = (int) (((long) iqw.O00000Oo) + j);
            this.O00000Oo -= j;
            if (iqw.O00000Oo == iqw.O00000o0) {
                this.f1560O000000o = iqw.O000000o();
                iqx.O000000o(iqw);
            }
            return str;
        }
    }

    private String O0000OoO(long j) throws EOFException {
        return O000000o(j, irb.f1577O000000o);
    }

    /* access modifiers changed from: private */
    /* renamed from: O0000oO0 */
    public iql clone() {
        iql iql = new iql();
        if (this.O00000Oo == 0) {
            return iql;
        }
        iql.f1560O000000o = new iqw(this.f1560O000000o);
        iqw iqw = iql.f1560O000000o;
        iqw.O0000O0o = iqw;
        iqw.O00000oo = iqw;
        iqw iqw2 = this.f1560O000000o;
        while (true) {
            iqw2 = iqw2.O00000oo;
            if (iqw2 != this.f1560O000000o) {
                iql.f1560O000000o.O0000O0o.O000000o(new iqw(iqw2));
            } else {
                iql.O00000Oo = this.O00000Oo;
                return iql;
            }
        }
    }

    public final long O000000o(byte b) {
        return O000000o((byte) 0, 0);
    }

    public final long O000000o(byte b, long j) {
        if (j >= 0) {
            iqw iqw = this.f1560O000000o;
            if (iqw == null) {
                return -1;
            }
            long j2 = 0;
            do {
                long j3 = (long) (iqw.O00000o0 - iqw.O00000Oo);
                if (j >= j3) {
                    j -= j3;
                } else {
                    byte[] bArr = iqw.f1572O000000o;
                    int i = iqw.O00000o0;
                    for (int i2 = (int) (((long) iqw.O00000Oo) + j); i2 < i; i2++) {
                        if (bArr[i2] == b) {
                            return (j2 + ((long) i2)) - ((long) iqw.O00000Oo);
                        }
                    }
                    j = 0;
                }
                j2 += j3;
                iqw = iqw.O00000oo;
            } while (iqw != this.f1560O000000o);
            return -1;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public final long O000000o(iql iql, long j) {
        if (iql == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.O00000Oo;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            iql.a_(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
    }

    public final long O000000o(iqz iqz) throws IOException {
        if (iqz != null) {
            long j = 0;
            while (true) {
                long O000000o2 = iqz.O000000o(this, 8192);
                if (O000000o2 == -1) {
                    return j;
                }
                j += O000000o2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final iql O000000o(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                } else if (i <= 1114111) {
                    O0000OOo((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                O0000OOo(i2);
                i3 = ((i >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            O0000OOo(i3);
            i = (i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        O0000OOo(i);
        return this;
    }

    public final iql O000000o(iql iql, long j, long j2) {
        if (iql != null) {
            irb.O000000o(this.O00000Oo, j, j2);
            if (j2 == 0) {
                return this;
            }
            iql.O00000Oo += j2;
            iqw iqw = this.f1560O000000o;
            while (j >= ((long) (iqw.O00000o0 - iqw.O00000Oo))) {
                j -= (long) (iqw.O00000o0 - iqw.O00000Oo);
                iqw = iqw.O00000oo;
            }
            while (j2 > 0) {
                iqw iqw2 = new iqw(iqw);
                iqw2.O00000Oo = (int) (((long) iqw2.O00000Oo) + j);
                iqw2.O00000o0 = Math.min(iqw2.O00000Oo + ((int) j2), iqw2.O00000o0);
                iqw iqw3 = iql.f1560O000000o;
                if (iqw3 == null) {
                    iqw2.O0000O0o = iqw2;
                    iqw2.O00000oo = iqw2;
                    iql.f1560O000000o = iqw2;
                } else {
                    iqw3.O0000O0o.O000000o(iqw2);
                }
                j2 -= (long) (iqw2.O00000o0 - iqw2.O00000Oo);
                iqw = iqw.O00000oo;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: O000000o */
    public final iql O00000Oo(String str) {
        return O000000o(str, 0, str.length());
    }

    public final iql O000000o(String str, int i, int i2) {
        int i3;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    iqw O00000oO = O00000oO(1);
                    byte[] bArr = O00000oO.f1572O000000o;
                    int i4 = O00000oO.O00000o0 - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt2;
                    while (true) {
                        i = i5;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i6 = (i4 + i) - O00000oO.O00000o0;
                            O00000oO.O00000o0 += i6;
                            this.O00000Oo += (long) i6;
                        } else {
                            i5 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i) - O00000oO.O00000o0;
                    O00000oO.O00000o0 += i62;
                    this.O00000Oo += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >> 6) | 192;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        O0000OOo((charAt2 >> 12) | 224);
                        i3 = ((charAt2 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY;
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            O0000OOo(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 0;
                            O0000OOo((i8 >> 18) | 240);
                            O0000OOo(((i8 >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            O0000OOo(((i8 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            O0000OOo((i8 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            i += 2;
                        }
                    }
                    O0000OOo(i3);
                    O0000OOo((int) ((charAt2 & '?') | 128));
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    /* renamed from: O000000o */
    public final iql O00000Oo(byte[] bArr) {
        if (bArr != null) {
            return O00000Oo(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: O000000o */
    public final iql O00000Oo(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            irb.O000000o((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                iqw O00000oO = O00000oO(1);
                int min = Math.min(i3 - i, 8192 - O00000oO.O00000o0);
                System.arraycopy(bArr, i, O00000oO.f1572O000000o, O00000oO.O00000o0, min);
                i += min;
                O00000oO.O00000o0 += min;
            }
            this.O00000Oo += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final ira O000000o() {
        return ira.O00000Oo;
    }

    public final void O000000o(long j) throws EOFException {
        if (this.O00000Oo < j) {
            throw new EOFException();
        }
    }

    public final byte O00000Oo(long j) {
        irb.O000000o(this.O00000Oo, j, 1);
        iqw iqw = this.f1560O000000o;
        while (true) {
            long j2 = (long) (iqw.O00000o0 - iqw.O00000Oo);
            if (j < j2) {
                return iqw.f1572O000000o[iqw.O00000Oo + ((int) j)];
            }
            j -= j2;
            iqw = iqw.O00000oo;
        }
    }

    public final iql O00000Oo() {
        return this;
    }

    /* renamed from: O00000Oo */
    public final iql O0000OOo(int i) {
        iqw O00000oO = O00000oO(1);
        byte[] bArr = O00000oO.f1572O000000o;
        int i2 = O00000oO.O00000o0;
        O00000oO.O00000o0 = i2 + 1;
        bArr[i2] = (byte) i;
        this.O00000Oo++;
        return this;
    }

    /* renamed from: O00000o */
    public final iql O00000oo(int i) {
        iqw O00000oO = O00000oO(4);
        byte[] bArr = O00000oO.f1572O000000o;
        int i2 = O00000oO.O00000o0;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        O00000oO.O00000o0 = i5 + 1;
        this.O00000Oo += 4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final String O00000o(long j) throws EOFException {
        String O0000OoO;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (O00000Oo(j3) == 13) {
                O0000OoO = O0000OoO(j3);
                j2 = 2;
                O00000oo(j2);
                return O0000OoO;
            }
        }
        O0000OoO = O0000OoO(j);
        O00000oo(j2);
        return O0000OoO;
    }

    public final boolean O00000o() {
        return this.O00000Oo == 0;
    }

    /* renamed from: O00000o0 */
    public final iql O0000O0o(int i) {
        iqw O00000oO = O00000oO(2);
        byte[] bArr = O00000oO.f1572O000000o;
        int i2 = O00000oO.O00000o0;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        O00000oO.O00000o0 = i3 + 1;
        this.O00000Oo += 2;
        return this;
    }

    public final iqm O00000o0() {
        return this;
    }

    public final f O00000o0(long j) throws EOFException {
        return new f(O00000oO(j));
    }

    public final long O00000oO() {
        long j = this.O00000Oo;
        if (j == 0) {
            return 0;
        }
        iqw iqw = this.f1560O000000o.O0000O0o;
        return (iqw.O00000o0 >= 8192 || !iqw.O00000oO) ? j : j - ((long) (iqw.O00000o0 - iqw.O00000Oo));
    }

    /* access modifiers changed from: package-private */
    public final iqw O00000oO(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        iqw iqw = this.f1560O000000o;
        if (iqw == null) {
            this.f1560O000000o = iqx.O000000o();
            iqw iqw2 = this.f1560O000000o;
            iqw2.O0000O0o = iqw2;
            iqw2.O00000oo = iqw2;
            return iqw2;
        }
        iqw iqw3 = iqw.O0000O0o;
        return (iqw3.O00000o0 + i > 8192 || !iqw3.O00000oO) ? iqw3.O000000o(iqx.O000000o()) : iqw3;
    }

    public final byte[] O00000oO(long j) throws EOFException {
        irb.O000000o(this.O00000Oo, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            O00000o0(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final byte O00000oo() {
        if (this.O00000Oo != 0) {
            iqw iqw = this.f1560O000000o;
            int i = iqw.O00000Oo;
            int i2 = iqw.O00000o0;
            int i3 = i + 1;
            byte b = iqw.f1572O000000o[i];
            this.O00000Oo--;
            if (i3 == i2) {
                this.f1560O000000o = iqw.O000000o();
                iqx.O000000o(iqw);
            } else {
                iqw.O00000Oo = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public final void O00000oo(long j) throws EOFException {
        while (j > 0) {
            iqw iqw = this.f1560O000000o;
            if (iqw != null) {
                int min = (int) Math.min(j, (long) (iqw.O00000o0 - this.f1560O000000o.O00000Oo));
                long j2 = (long) min;
                this.O00000Oo -= j2;
                j -= j2;
                this.f1560O000000o.O00000Oo += min;
                if (this.f1560O000000o.O00000Oo == this.f1560O000000o.O00000o0) {
                    iqw iqw2 = this.f1560O000000o;
                    this.f1560O000000o = iqw2.O000000o();
                    iqx.O000000o(iqw2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: O0000O0o */
    public final iql O0000Oo(long j) {
        if (j == 0) {
            return O0000OOo(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return O00000Oo("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        iqw O00000oO = O00000oO(i);
        byte[] bArr = O00000oO.f1572O000000o;
        int i2 = O00000oO.O00000o0 + i;
        while (j != 0) {
            i2--;
            bArr[i2] = O00000o0[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        O00000oO.O00000o0 += i;
        this.O00000Oo += (long) i;
        return this;
    }

    public final short O0000O0o() {
        if (this.O00000Oo >= 2) {
            iqw iqw = this.f1560O000000o;
            int i = iqw.O00000Oo;
            int i2 = iqw.O00000o0;
            if (i2 - i < 2) {
                return (short) (((O00000oo() & 255) << 8) | (O00000oo() & 255));
            }
            byte[] bArr = iqw.f1572O000000o;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.O00000Oo -= 2;
            if (i4 == i2) {
                this.f1560O000000o = iqw.O000000o();
                iqx.O000000o(iqw);
            } else {
                iqw.O00000Oo = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.O00000Oo);
    }

    public final int O0000OOo() {
        if (this.O00000Oo >= 4) {
            iqw iqw = this.f1560O000000o;
            int i = iqw.O00000Oo;
            int i2 = iqw.O00000o0;
            if (i2 - i < 4) {
                return ((O00000oo() & 255) << 24) | ((O00000oo() & 255) << 16) | ((O00000oo() & 255) << 8) | (O00000oo() & 255);
            }
            byte[] bArr = iqw.f1572O000000o;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.O00000Oo -= 4;
            if (i6 == i2) {
                this.f1560O000000o = iqw.O000000o();
                iqx.O000000o(iqw);
            } else {
                iqw.O00000Oo = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.O00000Oo);
    }

    /* renamed from: O0000OOo */
    public final iql O0000Oo0(long j) {
        if (j == 0) {
            return O0000OOo(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        iqw O00000oO = O00000oO(numberOfTrailingZeros);
        byte[] bArr = O00000oO.f1572O000000o;
        int i = O00000oO.O00000o0;
        for (int i2 = (O00000oO.O00000o0 + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = O00000o0[(int) (15 & j)];
            j >>>= 4;
        }
        O00000oO.O00000o0 += numberOfTrailingZeros;
        this.O00000Oo += (long) numberOfTrailingZeros;
        return this;
    }

    public final int O0000Oo() {
        return irb.O000000o(O0000OOo());
    }

    public final short O0000Oo0() {
        return irb.O000000o(O0000O0o());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r8 != r9) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        r15.f1560O000000o = r6.O000000o();
        _m_j.iqx.O000000o(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r6.O00000Oo = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (r0 != false) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073 A[SYNTHETIC] */
    public final long O0000OoO() {
        int i;
        int i2;
        if (this.O00000Oo != 0) {
            boolean z = false;
            long j = 0;
            int i3 = 0;
            do {
                iqw iqw = this.f1560O000000o;
                byte[] bArr = iqw.f1572O000000o;
                int i4 = iqw.O00000Oo;
                int i5 = iqw.O00000o0;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    byte b = bArr[i4];
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i2 = b - 97;
                        } else if (b >= 65 && b <= 70) {
                            i2 = b - 65;
                        } else if (i3 == 0) {
                            z = true;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                        }
                        i = i2 + 10;
                    } else {
                        i = b - 48;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i4++;
                        i3++;
                    } else {
                        iql O00000Oo2 = new iql().O0000Oo0(j).O0000OOo((int) b);
                        throw new NumberFormatException("Number too large: " + O00000Oo2.O0000o00());
                    }
                }
                if (i3 == 0) {
                }
            } while (this.f1560O000000o != null);
            this.O00000Oo -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public final f O0000Ooo() {
        return new f(O0000o0O());
    }

    public final /* synthetic */ iqm O0000o() throws IOException {
        return this;
    }

    public final String O0000o00() {
        try {
            return O000000o(this.O00000Oo, irb.f1577O000000o);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] O0000o0O() {
        try {
            return O00000oO(this.O00000Oo);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void O0000o0o() {
        try {
            O00000oo(this.O00000Oo);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iql)) {
            return false;
        }
        iql iql = (iql) obj;
        long j = this.O00000Oo;
        if (j != iql.O00000Oo) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        iqw iqw = this.f1560O000000o;
        iqw iqw2 = iql.f1560O000000o;
        int i = iqw.O00000Oo;
        int i2 = iqw2.O00000Oo;
        while (j2 < this.O00000Oo) {
            long min = (long) Math.min(iqw.O00000o0 - i, iqw2.O00000o0 - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (iqw.f1572O000000o[i4] != iqw2.f1572O000000o[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == iqw.O00000o0) {
                iqw = iqw.O00000oo;
                i = iqw.O00000Oo;
            } else {
                i = i4;
            }
            if (i3 == iqw2.O00000o0) {
                iqw2 = iqw2.O00000oo;
                i2 = iqw2.O00000Oo;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public final void flush() {
    }

    public final int hashCode() {
        iqw iqw = this.f1560O000000o;
        if (iqw == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = iqw.O00000o0;
            for (int i3 = iqw.O00000Oo; i3 < i2; i3++) {
                i = (i * 31) + iqw.f1572O000000o[i3];
            }
            iqw = iqw.O00000oo;
        } while (iqw != this.f1560O000000o);
        return i;
    }

    public final String toString() {
        long j = this.O00000Oo;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.O00000Oo), clone().O0000Ooo().O00000Oo());
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.f1560O000000o.f1572O000000o, this.f1560O000000o.O00000Oo, this.f1560O000000o.O00000o0 - this.f1560O000000o.O00000Oo);
            iqw iqw = this.f1560O000000o;
            while (true) {
                iqw = iqw.O00000oo;
                if (iqw != this.f1560O000000o) {
                    instance.update(iqw.f1572O000000o, iqw.O00000Oo, iqw.O00000o0 - iqw.O00000Oo);
                } else {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.O00000Oo), f.O000000o(instance.digest()).O00000Oo());
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    public final String O0000o0() throws EOFException {
        long O000000o2 = O000000o((byte) 10, 0);
        if (O000000o2 != -1) {
            return O00000o(O000000o2);
        }
        iql iql = new iql();
        O000000o(iql, 0, Math.min(32L, this.O00000Oo));
        throw new EOFException("\\n not found: size=" + this.O00000Oo + " content=" + iql.O0000Ooo().O00000Oo() + "...");
    }

    private void O00000o0(byte[] bArr) throws EOFException {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            irb.O000000o((long) bArr.length, (long) i2, (long) length);
            iqw iqw = this.f1560O000000o;
            if (iqw == null) {
                i = -1;
            } else {
                i = Math.min(length, iqw.O00000o0 - iqw.O00000Oo);
                System.arraycopy(iqw.f1572O000000o, iqw.O00000Oo, bArr, i2, i);
                iqw.O00000Oo += i;
                this.O00000Oo -= (long) i;
                if (iqw.O00000Oo == iqw.O00000o0) {
                    this.f1560O000000o = iqw.O000000o();
                    iqx.O000000o(iqw);
                }
            }
            if (i != -1) {
                i2 += i;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: O000000o */
    public final iql O00000Oo(f fVar) {
        if (fVar != null) {
            O00000Oo(fVar.c, 0, fVar.c.length);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public final void a_(iql iql, long j) {
        if (iql == null) {
            throw new IllegalArgumentException("source == null");
        } else if (iql != this) {
            irb.O000000o(iql.O00000Oo, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (iql.f1560O000000o.O00000o0 - iql.f1560O000000o.O00000Oo))) {
                    iqw iqw = this.f1560O000000o;
                    iqw iqw2 = iqw != null ? iqw.O0000O0o : null;
                    if (iqw2 != null && iqw2.O00000oO) {
                        if ((((long) iqw2.O00000o0) + j) - ((long) (iqw2.O00000o ? 0 : iqw2.O00000Oo)) <= 8192) {
                            iql.f1560O000000o.O000000o(iqw2, (int) j);
                            iql.O00000Oo -= j;
                            this.O00000Oo += j;
                            return;
                        }
                    }
                    iqw iqw3 = iql.f1560O000000o;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > iqw3.O00000o0 - iqw3.O00000Oo) {
                        throw new IllegalArgumentException();
                    }
                    iqw iqw4 = new iqw(iqw3);
                    iqw4.O00000o0 = iqw4.O00000Oo + i2;
                    iqw3.O00000Oo += i2;
                    iqw3.O0000O0o.O000000o(iqw4);
                    iql.f1560O000000o = iqw4;
                }
                iqw iqw5 = iql.f1560O000000o;
                long j2 = (long) (iqw5.O00000o0 - iqw5.O00000Oo);
                iql.f1560O000000o = iqw5.O000000o();
                iqw iqw6 = this.f1560O000000o;
                if (iqw6 == null) {
                    this.f1560O000000o = iqw5;
                    iqw iqw7 = this.f1560O000000o;
                    iqw7.O0000O0o = iqw7;
                    iqw7.O00000oo = iqw7;
                } else {
                    iqw O000000o2 = iqw6.O0000O0o.O000000o(iqw5);
                    if (O000000o2.O0000O0o == O000000o2) {
                        throw new IllegalStateException();
                    } else if (O000000o2.O0000O0o.O00000oO) {
                        int i3 = O000000o2.O00000o0 - O000000o2.O00000Oo;
                        int i4 = 8192 - O000000o2.O0000O0o.O00000o0;
                        if (!O000000o2.O0000O0o.O00000o) {
                            i = O000000o2.O0000O0o.O00000Oo;
                        }
                        if (i3 <= i4 + i) {
                            O000000o2.O000000o(O000000o2.O0000O0o, i3);
                            O000000o2.O000000o();
                            iqx.O000000o(O000000o2);
                        }
                    }
                }
                iql.O00000Oo -= j2;
                this.O00000Oo += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
