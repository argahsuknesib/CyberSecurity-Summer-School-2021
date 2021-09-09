package _m_j;

import android.support.v4.app.NotificationCompat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;
import okio.SegmentedByteString;

public final class jax implements jay, jaz, Cloneable, ByteChannel {
    private static final byte[] O00000o0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: O000000o  reason: collision with root package name */
    public jbk f1718O000000o;
    public long O00000Oo;

    public final jax O000000o() {
        return this;
    }

    public final jay O00000o0() {
        return this;
    }

    public final /* bridge */ /* synthetic */ jay O0000ooo() throws IOException {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final boolean isOpen() {
        return true;
    }

    public final OutputStream O00000Oo() {
        return new OutputStream() {
            /* class _m_j.jax.AnonymousClass1 */

            public final void close() {
            }

            public final void flush() {
            }

            public final void write(int i) {
                jax.this.O0000Oo((int) ((byte) i));
            }

            public final void write(byte[] bArr, int i, int i2) {
                jax.this.O00000o0(bArr, i, i2);
            }

            public final String toString() {
                return jax.this + ".outputStream()";
            }
        };
    }

    public final boolean O00000o() {
        return this.O00000Oo == 0;
    }

    public final void O000000o(long j) throws EOFException {
        if (this.O00000Oo < j) {
            throw new EOFException();
        }
    }

    public final boolean O00000Oo(long j) {
        return this.O00000Oo >= j;
    }

    public final InputStream O00000oO() {
        return new InputStream() {
            /* class _m_j.jax.AnonymousClass2 */

            public final void close() {
            }

            public final int read() {
                if (jax.this.O00000Oo > 0) {
                    return jax.this.O0000O0o() & 255;
                }
                return -1;
            }

            public final int read(byte[] bArr, int i, int i2) {
                return jax.this.O000000o(bArr, i, i2);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(long, long):long}
             arg types: [long, int]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(float, float):float}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(long, long):long} */
            public final int available() {
                return (int) Math.min(jax.this.O00000Oo, 2147483647L);
            }

            public final String toString() {
                return jax.this + ".inputStream()";
            }
        };
    }

    public final jax O000000o(jax jax, long j, long j2) {
        if (jax != null) {
            jbp.O000000o(this.O00000Oo, j, j2);
            if (j2 == 0) {
                return this;
            }
            jax.O00000Oo += j2;
            jbk jbk = this.f1718O000000o;
            while (j >= ((long) (jbk.O00000o0 - jbk.O00000Oo))) {
                j -= (long) (jbk.O00000o0 - jbk.O00000Oo);
                jbk = jbk.O00000oo;
            }
            while (j2 > 0) {
                jbk O000000o2 = jbk.O000000o();
                O000000o2.O00000Oo = (int) (((long) O000000o2.O00000Oo) + j);
                O000000o2.O00000o0 = Math.min(O000000o2.O00000Oo + ((int) j2), O000000o2.O00000o0);
                jbk jbk2 = jax.f1718O000000o;
                if (jbk2 == null) {
                    O000000o2.O0000O0o = O000000o2;
                    O000000o2.O00000oo = O000000o2;
                    jax.f1718O000000o = O000000o2;
                } else {
                    jbk2.O0000O0o.O000000o(O000000o2);
                }
                j2 -= (long) (O000000o2.O00000o0 - O000000o2.O00000Oo);
                jbk = jbk.O00000oo;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long O00000oo() {
        long j = this.O00000Oo;
        if (j == 0) {
            return 0;
        }
        jbk jbk = this.f1718O000000o.O0000O0o;
        return (jbk.O00000o0 >= 8192 || !jbk.O00000oO) ? j : j - ((long) (jbk.O00000o0 - jbk.O00000Oo));
    }

    public final byte O0000O0o() {
        if (this.O00000Oo != 0) {
            jbk jbk = this.f1718O000000o;
            int i = jbk.O00000Oo;
            int i2 = jbk.O00000o0;
            int i3 = i + 1;
            byte b = jbk.f1738O000000o[i];
            this.O00000Oo--;
            if (i3 == i2) {
                this.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            } else {
                jbk.O00000Oo = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte O00000o0(long j) {
        jbp.O000000o(this.O00000Oo, j, 1);
        long j2 = this.O00000Oo;
        if (j2 - j > j) {
            jbk jbk = this.f1718O000000o;
            while (true) {
                long j3 = (long) (jbk.O00000o0 - jbk.O00000Oo);
                if (j < j3) {
                    return jbk.f1738O000000o[jbk.O00000Oo + ((int) j)];
                }
                j -= j3;
                jbk = jbk.O00000oo;
            }
        } else {
            long j4 = j - j2;
            jbk jbk2 = this.f1718O000000o;
            do {
                jbk2 = jbk2.O0000O0o;
                j4 += (long) (jbk2.O00000o0 - jbk2.O00000Oo);
            } while (j4 < 0);
            return jbk2.f1738O000000o[jbk2.O00000Oo + ((int) j4)];
        }
    }

    public final short O0000OOo() {
        if (this.O00000Oo >= 2) {
            jbk jbk = this.f1718O000000o;
            int i = jbk.O00000Oo;
            int i2 = jbk.O00000o0;
            if (i2 - i < 2) {
                return (short) (((O0000O0o() & 255) << 8) | (O0000O0o() & 255));
            }
            byte[] bArr = jbk.f1738O000000o;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.O00000Oo -= 2;
            if (i4 == i2) {
                this.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            } else {
                jbk.O00000Oo = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.O00000Oo);
    }

    public final int O0000Oo0() {
        if (this.O00000Oo >= 4) {
            jbk jbk = this.f1718O000000o;
            int i = jbk.O00000Oo;
            int i2 = jbk.O00000o0;
            if (i2 - i < 4) {
                return ((O0000O0o() & 255) << 24) | ((O0000O0o() & 255) << 16) | ((O0000O0o() & 255) << 8) | (O0000O0o() & 255);
            }
            byte[] bArr = jbk.f1738O000000o;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.O00000Oo -= 4;
            if (i6 == i2) {
                this.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            } else {
                jbk.O00000Oo = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.O00000Oo);
    }

    public final long O0000Oo() {
        if (this.O00000Oo >= 8) {
            jbk jbk = this.f1718O000000o;
            int i = jbk.O00000Oo;
            int i2 = jbk.O00000o0;
            if (i2 - i < 8) {
                return ((((long) O0000Oo0()) & 4294967295L) << 32) | (4294967295L & ((long) O0000Oo0()));
            }
            byte[] bArr = jbk.f1738O000000o;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j2 = (((long) bArr[i9]) & 255) | ((((long) bArr[i8]) & 255) << 8) | j;
            this.O00000Oo -= 8;
            if (i10 == i2) {
                this.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            } else {
                jbk.O00000Oo = i10;
            }
            return j2;
        }
        throw new IllegalStateException("size < 8: " + this.O00000Oo);
    }

    public final short O0000OoO() {
        return jbp.O000000o(O0000OOo());
    }

    public final int O0000Ooo() {
        return jbp.O000000o(O0000Oo0());
    }

    public final long O0000o00() {
        return jbp.O000000o(O0000Oo());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        if (r10 != r11) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a5, code lost:
        r0.f1718O000000o = r15.O00000o0();
        _m_j.jbl.O000000o(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r15.O00000Oo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if (r2 != false) goto L_0x00b8;
     */
    public final long O0000o0() {
        jbk jbk;
        byte b;
        byte[] bArr;
        if (this.O00000Oo != 0) {
            int i = 0;
            long j = 0;
            long j2 = -7;
            boolean z = false;
            boolean z2 = false;
            loop0:
            do {
                jbk jbk2 = this.f1718O000000o;
                byte[] bArr2 = jbk2.f1738O000000o;
                int i2 = jbk2.O00000Oo;
                int i3 = jbk2.O00000o0;
                while (true) {
                    if (i2 >= i3) {
                        jbk = jbk2;
                        break;
                    }
                    b = bArr2[i2];
                    if (b < 48 || b > 57) {
                        jbk = jbk2;
                        bArr = bArr2;
                        if (b == 45 && i == 0) {
                            j2--;
                            z = true;
                        } else if (i != 0) {
                            z2 = true;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                        }
                    } else {
                        int i4 = 48 - b;
                        if (j < -922337203685477580L) {
                            break loop0;
                        }
                        if (j == -922337203685477580L) {
                            jbk = jbk2;
                            bArr = bArr2;
                            if (((long) i4) < j2) {
                                break loop0;
                            }
                        } else {
                            jbk = jbk2;
                            bArr = bArr2;
                        }
                        j = (j * 10) + ((long) i4);
                    }
                    i2++;
                    i++;
                    jbk2 = jbk;
                    bArr2 = bArr;
                }
                jax O00000Oo2 = new jax().O0000o0O(j).O0000Oo((int) b);
                if (!z) {
                    O00000Oo2.O0000O0o();
                }
                throw new NumberFormatException("Number too large: " + O00000Oo2.O0000o());
            } while (this.f1718O000000o != null);
            this.O00000Oo -= (long) i;
            return z ? j : -j;
        }
        throw new IllegalStateException("size == 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r8 != r9) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        r15.f1718O000000o = r6.O00000o0();
        _m_j.jbl.O000000o(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r6.O00000Oo = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        if (r0 != false) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0073 A[SYNTHETIC] */
    public final long O0000o0O() {
        int i;
        int i2;
        if (this.O00000Oo != 0) {
            boolean z = false;
            long j = 0;
            int i3 = 0;
            do {
                jbk jbk = this.f1718O000000o;
                byte[] bArr = jbk.f1738O000000o;
                int i4 = jbk.O00000Oo;
                int i5 = jbk.O00000o0;
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
                        jax O00000Oo2 = new jax().O0000o0(j).O0000Oo((int) b);
                        throw new NumberFormatException("Number too large: " + O00000Oo2.O0000o());
                    }
                }
                if (i3 == 0) {
                }
            } while (this.f1718O000000o != null);
            this.O00000Oo -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public final ByteString O0000o0o() {
        return new ByteString(O0000oOO());
    }

    public final ByteString O00000o(long j) throws EOFException {
        return new ByteString(O0000OOo(j));
    }

    public final void O000000o(jax jax, long j) throws EOFException {
        long j2 = this.O00000Oo;
        if (j2 >= j) {
            jax.write(this, j);
        } else {
            jax.write(this, j2);
            throw new EOFException();
        }
    }

    public final long O000000o(jbm jbm) throws IOException {
        long j = this.O00000Oo;
        if (j > 0) {
            jbm.write(this, j);
        }
        return j;
    }

    public final String O0000o() {
        try {
            return O000000o(this.O00000Oo, jbp.f1740O000000o);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String O00000oO(long j) throws EOFException {
        return O000000o(j, jbp.f1740O000000o);
    }

    public final String O000000o(Charset charset) {
        try {
            return O000000o(this.O00000Oo, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private String O000000o(long j, Charset charset) throws EOFException {
        jbp.O000000o(this.O00000Oo, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        } else if (j == 0) {
            return "";
        } else {
            jbk jbk = this.f1718O000000o;
            if (((long) jbk.O00000Oo) + j > ((long) jbk.O00000o0)) {
                return new String(O0000OOo(j), charset);
            }
            String str = new String(jbk.f1738O000000o, jbk.O00000Oo, (int) j, charset);
            jbk.O00000Oo = (int) (((long) jbk.O00000Oo) + j);
            this.O00000Oo -= j;
            if (jbk.O00000Oo == jbk.O00000o0) {
                this.f1718O000000o = jbk.O00000o0();
                jbl.O000000o(jbk);
            }
            return str;
        }
    }

    public final String O0000oO0() throws EOFException {
        return O00000oo(Long.MAX_VALUE);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    public final String O00000oo(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long O000000o2 = O000000o((byte) 10, 0, j2);
            if (O000000o2 != -1) {
                return O0000O0o(O000000o2);
            }
            if (j2 < this.O00000Oo && O00000o0(j2 - 1) == 13 && O00000o0(j2) == 10) {
                return O0000O0o(j2);
            }
            jax jax = new jax();
            O000000o(jax, 0, Math.min(32L, this.O00000Oo));
            throw new EOFException("\\n not found: limit=" + Math.min(this.O00000Oo, j) + " content=" + jax.O0000o0o().O00000oo() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    /* access modifiers changed from: package-private */
    public final String O0000O0o(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (O00000o0(j2) == 13) {
                String O00000oO = O00000oO(j2);
                O0000Oo0(2L);
                return O00000oO;
            }
        }
        String O00000oO2 = O00000oO(j);
        O0000Oo0(1L);
        return O00000oO2;
    }

    public final int O0000oO() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (this.O00000Oo != 0) {
            byte O00000o02 = O00000o0(0L);
            int i2 = 1;
            if ((O00000o02 & 128) == 0) {
                b2 = O00000o02 & Byte.MAX_VALUE;
                i = 1;
                b = 0;
            } else if ((O00000o02 & 224) == 192) {
                b2 = O00000o02 & 31;
                i = 2;
                b = 128;
            } else if ((O00000o02 & 240) == 224) {
                b2 = O00000o02 & 15;
                i = 3;
                b = 2048;
            } else if ((O00000o02 & 248) == 240) {
                b2 = O00000o02 & 7;
                i = 4;
                b = 65536;
            } else {
                O0000Oo0(1L);
                return 65533;
            }
            long j = (long) i;
            if (this.O00000Oo >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte O00000o03 = O00000o0(j2);
                    if ((O00000o03 & 192) == 128) {
                        b2 = (b2 << 6) | (O00000o03 & 63);
                        i2++;
                    } else {
                        O0000Oo0(j2);
                        return 65533;
                    }
                }
                O0000Oo0(j);
                if (b2 > 1114111) {
                    return 65533;
                }
                if ((b2 < 55296 || b2 > 57343) && b2 >= b) {
                    return b2;
                }
                return 65533;
            }
            throw new EOFException("size < " + i + ": " + this.O00000Oo + " (to read code point prefixed 0x" + Integer.toHexString(O00000o02) + ")");
        }
        throw new EOFException();
    }

    public final byte[] O0000oOO() {
        try {
            return O0000OOo(this.O00000Oo);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] O0000OOo(long j) throws EOFException {
        jbp.O000000o(this.O00000Oo, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            O000000o(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final void O000000o(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int O000000o2 = O000000o(bArr, i, bArr.length - i);
            if (O000000o2 != -1) {
                i += O000000o2;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int O000000o(byte[] bArr, int i, int i2) {
        jbp.O000000o((long) bArr.length, (long) i, (long) i2);
        jbk jbk = this.f1718O000000o;
        if (jbk == null) {
            return -1;
        }
        int min = Math.min(i2, jbk.O00000o0 - jbk.O00000Oo);
        System.arraycopy(jbk.f1738O000000o, jbk.O00000Oo, bArr, i, min);
        jbk.O00000Oo += min;
        this.O00000Oo -= (long) min;
        if (jbk.O00000Oo == jbk.O00000o0) {
            this.f1718O000000o = jbk.O00000o0();
            jbl.O000000o(jbk);
        }
        return min;
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        jbk jbk = this.f1718O000000o;
        if (jbk == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), jbk.O00000o0 - jbk.O00000Oo);
        byteBuffer.put(jbk.f1738O000000o, jbk.O00000Oo, min);
        jbk.O00000Oo += min;
        this.O00000Oo -= (long) min;
        if (jbk.O00000Oo == jbk.O00000o0) {
            this.f1718O000000o = jbk.O00000o0();
            jbl.O000000o(jbk);
        }
        return min;
    }

    public final void O0000oOo() {
        try {
            O0000Oo0(this.O00000Oo);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void O0000Oo0(long j) throws EOFException {
        while (j > 0) {
            jbk jbk = this.f1718O000000o;
            if (jbk != null) {
                int min = (int) Math.min(j, (long) (jbk.O00000o0 - this.f1718O000000o.O00000Oo));
                long j2 = (long) min;
                this.O00000Oo -= j2;
                j -= j2;
                this.f1718O000000o.O00000Oo += min;
                if (this.f1718O000000o.O00000Oo == this.f1718O000000o.O00000o0) {
                    jbk jbk2 = this.f1718O000000o;
                    this.f1718O000000o = jbk2.O00000o0();
                    jbl.O000000o(jbk2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: O000000o */
    public final jax O00000o0(ByteString byteString) {
        if (byteString != null) {
            byteString.O000000o(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: O000000o */
    public final jax O00000Oo(String str) {
        return O000000o(str, 0, str.length());
    }

    public final jax O000000o(String str, int i, int i2) {
        char c;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    jbk O00000oo = O00000oo(1);
                    byte[] bArr = O00000oo.f1738O000000o;
                    int i3 = O00000oo.O00000o0 - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = (i3 + i) - O00000oo.O00000o0;
                            O00000oo.O00000o0 += i5;
                            this.O00000Oo += (long) i5;
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = (i3 + i) - O00000oo.O00000o0;
                    O00000oo.O00000o0 += i52;
                    this.O00000Oo += (long) i52;
                } else {
                    if (charAt2 < 2048) {
                        O0000Oo((charAt2 >> 6) | 192);
                        O0000Oo((int) ((charAt2 & '?') | 128));
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        O0000Oo((charAt2 >> 12) | 224);
                        O0000Oo(((charAt2 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                        O0000Oo((int) ((charAt2 & '?') | 128));
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c = str.charAt(i6);
                        } else {
                            c = 0;
                        }
                        if (charAt2 > 56319 || c < 56320 || c > 57343) {
                            O0000Oo(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt2 & 10239) << 10) | (9215 & c)) + 0;
                            O0000Oo((i7 >> 18) | 240);
                            O0000Oo(((i7 >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            O0000Oo(((i7 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            O0000Oo((i7 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public final jax O000000o(int i) {
        if (i < 128) {
            O0000Oo(i);
        } else if (i < 2048) {
            O0000Oo((i >> 6) | 192);
            O0000Oo((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                O0000Oo((i >> 12) | 224);
                O0000Oo(((i >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                O0000Oo((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else {
                O0000Oo(63);
            }
        } else if (i <= 1114111) {
            O0000Oo((i >> 18) | 240);
            O0000Oo(((i >> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            O0000Oo(((i >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            O0000Oo((i & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: O000000o */
    public final jax O00000Oo(String str, Charset charset) {
        return O000000o(str, 0, str.length(), charset);
    }

    public final jax O000000o(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(jbp.f1740O000000o)) {
            return O000000o(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return O00000o0(bytes, 0, bytes.length);
        }
    }

    /* renamed from: O00000Oo */
    public final jax O00000o0(byte[] bArr) {
        if (bArr != null) {
            return O00000o0(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: O00000Oo */
    public final jax O00000o0(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            jbp.O000000o((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                jbk O00000oo = O00000oo(1);
                int min = Math.min(i3 - i, 8192 - O00000oo.O00000o0);
                System.arraycopy(bArr, i, O00000oo.f1738O000000o, O00000oo.O00000o0, min);
                i += min;
                O00000oo.O00000o0 += min;
            }
            this.O00000Oo += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                jbk O00000oo = O00000oo(1);
                int min = Math.min(i, 8192 - O00000oo.O00000o0);
                byteBuffer.get(O00000oo.f1738O000000o, O00000oo.O00000o0, min);
                i -= min;
                O00000oo.O00000o0 += min;
            }
            this.O00000Oo += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long O000000o(jbn jbn) throws IOException {
        if (jbn != null) {
            long j = 0;
            while (true) {
                long read = jbn.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: O00000Oo */
    public final jax O0000Oo(int i) {
        jbk O00000oo = O00000oo(1);
        byte[] bArr = O00000oo.f1738O000000o;
        int i2 = O00000oo.O00000o0;
        O00000oo.O00000o0 = i2 + 1;
        bArr[i2] = (byte) i;
        this.O00000Oo++;
        return this;
    }

    /* renamed from: O00000o0 */
    public final jax O0000Oo0(int i) {
        jbk O00000oo = O00000oo(2);
        byte[] bArr = O00000oo.f1738O000000o;
        int i2 = O00000oo.O00000o0;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        O00000oo.O00000o0 = i3 + 1;
        this.O00000Oo += 2;
        return this;
    }

    /* renamed from: O00000o */
    public final jax O0000OOo(int i) {
        jbk O00000oo = O00000oo(4);
        byte[] bArr = O00000oo.f1738O000000o;
        int i2 = O00000oo.O00000o0;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        O00000oo.O00000o0 = i5 + 1;
        this.O00000Oo += 4;
        return this;
    }

    /* renamed from: O00000oO */
    public final jax O0000O0o(int i) {
        return O0000OOo(jbp.O000000o(i));
    }

    public final jax O0000Oo(long j) {
        jbk O00000oo = O00000oo(8);
        byte[] bArr = O00000oo.f1738O000000o;
        int i = O00000oo.O00000o0;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        O00000oo.O00000o0 = i8 + 1;
        this.O00000Oo += 8;
        return this;
    }

    /* renamed from: O0000OoO */
    public final jax O0000o0o(long j) {
        return O0000Oo(jbp.O000000o(j));
    }

    /* renamed from: O0000Ooo */
    public final jax O0000o0O(long j) {
        if (j == 0) {
            return O0000Oo(48);
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
        jbk O00000oo = O00000oo(i);
        byte[] bArr = O00000oo.f1738O000000o;
        int i2 = O00000oo.O00000o0 + i;
        while (j != 0) {
            i2--;
            bArr[i2] = O00000o0[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        O00000oo.O00000o0 += i;
        this.O00000Oo += (long) i;
        return this;
    }

    /* renamed from: O0000o00 */
    public final jax O0000o0(long j) {
        if (j == 0) {
            return O0000Oo(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        jbk O00000oo = O00000oo(numberOfTrailingZeros);
        byte[] bArr = O00000oo.f1738O000000o;
        int i = O00000oo.O00000o0;
        for (int i2 = (O00000oo.O00000o0 + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = O00000o0[(int) (15 & j)];
            j >>>= 4;
        }
        O00000oo.O00000o0 += numberOfTrailingZeros;
        this.O00000Oo += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final jbk O00000oo(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        jbk jbk = this.f1718O000000o;
        if (jbk == null) {
            this.f1718O000000o = jbl.O000000o();
            jbk jbk2 = this.f1718O000000o;
            jbk2.O0000O0o = jbk2;
            jbk2.O00000oo = jbk2;
            return jbk2;
        }
        jbk jbk3 = jbk.O0000O0o;
        return (jbk3.O00000o0 + i > 8192 || !jbk3.O00000oO) ? jbk3.O000000o(jbl.O000000o()) : jbk3;
    }

    public final void write(jax jax, long j) {
        jbk jbk;
        int i;
        if (jax == null) {
            throw new IllegalArgumentException("source == null");
        } else if (jax != this) {
            jbp.O000000o(jax.O00000Oo, 0, j);
            while (j > 0) {
                int i2 = 0;
                if (j < ((long) (jax.f1718O000000o.O00000o0 - jax.f1718O000000o.O00000Oo))) {
                    jbk jbk2 = this.f1718O000000o;
                    jbk jbk3 = jbk2 != null ? jbk2.O0000O0o : null;
                    if (jbk3 != null && jbk3.O00000oO) {
                        long j2 = ((long) jbk3.O00000o0) + j;
                        if (jbk3.O00000o) {
                            i = 0;
                        } else {
                            i = jbk3.O00000Oo;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            jax.f1718O000000o.O000000o(jbk3, (int) j);
                            jax.O00000Oo -= j;
                            this.O00000Oo += j;
                            return;
                        }
                    }
                    jbk jbk4 = jax.f1718O000000o;
                    int i3 = (int) j;
                    if (i3 <= 0 || i3 > jbk4.O00000o0 - jbk4.O00000Oo) {
                        throw new IllegalArgumentException();
                    }
                    if (i3 >= 1024) {
                        jbk = jbk4.O000000o();
                    } else {
                        jbk = jbl.O000000o();
                        System.arraycopy(jbk4.f1738O000000o, jbk4.O00000Oo, jbk.f1738O000000o, 0, i3);
                    }
                    jbk.O00000o0 = jbk.O00000Oo + i3;
                    jbk4.O00000Oo += i3;
                    jbk4.O0000O0o.O000000o(jbk);
                    jax.f1718O000000o = jbk;
                }
                jbk jbk5 = jax.f1718O000000o;
                long j3 = (long) (jbk5.O00000o0 - jbk5.O00000Oo);
                jax.f1718O000000o = jbk5.O00000o0();
                jbk jbk6 = this.f1718O000000o;
                if (jbk6 == null) {
                    this.f1718O000000o = jbk5;
                    jbk jbk7 = this.f1718O000000o;
                    jbk7.O0000O0o = jbk7;
                    jbk7.O00000oo = jbk7;
                } else {
                    jbk O000000o2 = jbk6.O0000O0o.O000000o(jbk5);
                    if (O000000o2.O0000O0o == O000000o2) {
                        throw new IllegalStateException();
                    } else if (O000000o2.O0000O0o.O00000oO) {
                        int i4 = O000000o2.O00000o0 - O000000o2.O00000Oo;
                        int i5 = 8192 - O000000o2.O0000O0o.O00000o0;
                        if (!O000000o2.O0000O0o.O00000o) {
                            i2 = O000000o2.O0000O0o.O00000Oo;
                        }
                        if (i4 <= i5 + i2) {
                            O000000o2.O000000o(O000000o2.O0000O0o, i4);
                            O000000o2.O00000o0();
                            jbl.O000000o(O000000o2);
                        }
                    }
                }
                jax.O00000Oo -= j3;
                this.O00000Oo += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public final long read(jax jax, long j) {
        if (jax == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.O00000Oo;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            jax.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
    }

    public final long O0000oo0() {
        return O000000o((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long O000000o(byte b, long j, long j2) {
        jbk jbk;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.O00000Oo), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.O00000Oo;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (jbk = this.f1718O000000o) == null) {
            return -1;
        }
        long j5 = this.O00000Oo;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j5;
                if (j3 >= j) {
                    break;
                }
                jbk = jbk.O00000oo;
            }
        } else {
            while (j5 > j) {
                jbk = jbk.O0000O0o;
                j5 -= (long) (jbk.O00000o0 - jbk.O00000Oo);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = jbk.f1738O000000o;
            int min = (int) Math.min((long) jbk.O00000o0, (((long) jbk.O00000Oo) + j4) - j5);
            for (int i = (int) ((((long) jbk.O00000Oo) + j6) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - jbk.O00000Oo)) + j5;
                }
            }
            j6 = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j5;
            jbk = jbk.O00000oo;
            j5 = j6;
        }
        return -1;
    }

    public final long O000000o(ByteString byteString, long j) throws IOException {
        ByteString byteString2 = byteString;
        if (byteString.O0000OOo() != 0) {
            long j2 = 0;
            if (j >= 0) {
                jbk jbk = this.f1718O000000o;
                long j3 = -1;
                if (jbk == null) {
                    return -1;
                }
                long j4 = this.O00000Oo;
                if (j4 - j >= j) {
                    while (true) {
                        j4 = j2;
                        j2 = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j4;
                        if (j2 >= j) {
                            break;
                        }
                        jbk = jbk.O00000oo;
                    }
                } else {
                    while (j4 > j) {
                        jbk = jbk.O0000O0o;
                        j4 -= (long) (jbk.O00000o0 - jbk.O00000Oo);
                    }
                }
                byte O000000o2 = byteString2.O000000o(0);
                int O0000OOo = byteString.O0000OOo();
                long j5 = (this.O00000Oo - ((long) O0000OOo)) + 1;
                long j6 = j;
                while (j4 < j5) {
                    byte[] bArr = jbk.f1738O000000o;
                    int min = (int) Math.min((long) jbk.O00000o0, (((long) jbk.O00000Oo) + j5) - j4);
                    for (int i = (int) ((((long) jbk.O00000Oo) + j6) - j4); i < min; i++) {
                        if (bArr[i] == O000000o2 && O000000o(jbk, i + 1, byteString2, O0000OOo)) {
                            return ((long) (i - jbk.O00000Oo)) + j4;
                        }
                    }
                    j6 = j4 + ((long) (jbk.O00000o0 - jbk.O00000Oo));
                    jbk = jbk.O00000oo;
                    j4 = j6;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public final long O00000Oo(ByteString byteString, long j) {
        long j2;
        int i;
        int i2;
        jbk jbk = this.f1718O000000o;
        if (jbk == null) {
            return -1;
        }
        long j3 = this.O00000Oo;
        if (j3 - 0 >= 0) {
            j2 = 0;
            while (true) {
                long j4 = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j2;
                if (j4 >= 0) {
                    break;
                }
                jbk = jbk.O00000oo;
                j2 = j4;
            }
        } else {
            while (j2 > 0) {
                jbk = jbk.O0000O0o;
                j3 = j2 - ((long) (jbk.O00000o0 - jbk.O00000Oo));
            }
        }
        if (byteString.O0000OOo() == 2) {
            byte O000000o2 = byteString.O000000o(0);
            byte O000000o3 = byteString.O000000o(1);
            while (j2 < this.O00000Oo) {
                byte[] bArr = jbk.f1738O000000o;
                i = (int) ((((long) jbk.O00000Oo) + j) - j2);
                int i3 = jbk.O00000o0;
                while (i < i3) {
                    byte b = bArr[i];
                    if (b == O000000o2 || b == O000000o3) {
                        i2 = jbk.O00000Oo;
                    } else {
                        i++;
                    }
                }
                j = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j2;
                jbk = jbk.O00000oo;
                j2 = j;
            }
            return -1;
        }
        byte[] O0000Oo = byteString.O0000Oo();
        while (j2 < this.O00000Oo) {
            byte[] bArr2 = jbk.f1738O000000o;
            int i4 = (int) ((((long) jbk.O00000Oo) + j) - j2);
            int i5 = jbk.O00000o0;
            while (i < i5) {
                byte b2 = bArr2[i];
                int length = O0000Oo.length;
                int i6 = 0;
                while (i6 < length) {
                    if (b2 == O0000Oo[i6]) {
                        i2 = jbk.O00000Oo;
                    } else {
                        i6++;
                    }
                }
                i4 = i + 1;
            }
            j = ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j2;
            jbk = jbk.O00000oo;
            j2 = j;
        }
        return -1;
        return ((long) (i - i2)) + j2;
    }

    public final boolean O00000Oo(ByteString byteString) {
        int O0000OOo = byteString.O0000OOo();
        if (O0000OOo < 0 || this.O00000Oo - 0 < ((long) O0000OOo) || byteString.O0000OOo() - 0 < O0000OOo) {
            return false;
        }
        for (int i = 0; i < O0000OOo; i++) {
            if (O00000o0(((long) i) + 0) != byteString.O000000o(i + 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean O000000o(jbk jbk, int i, ByteString byteString, int i2) {
        int i3 = jbk.O00000o0;
        byte[] bArr = jbk.f1738O000000o;
        jbk jbk2 = jbk;
        for (int i4 = 1; i4 < i2; i4++) {
            if (i == i3) {
                jbk jbk3 = jbk2.O00000oo;
                byte[] bArr2 = jbk3.f1738O000000o;
                int i5 = jbk3.O00000Oo;
                int i6 = jbk3.O00000o0;
                int i7 = i5;
                jbk2 = jbk3;
                i = i7;
                int i8 = i6;
                bArr = bArr2;
                i3 = i8;
            }
            if (bArr[i] != byteString.O000000o(i4)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final jbo timeout() {
        return jbo.NONE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jax)) {
            return false;
        }
        jax jax = (jax) obj;
        long j = this.O00000Oo;
        if (j != jax.O00000Oo) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        jbk jbk = this.f1718O000000o;
        jbk jbk2 = jax.f1718O000000o;
        int i = jbk.O00000Oo;
        int i2 = jbk2.O00000Oo;
        while (j2 < this.O00000Oo) {
            long min = (long) Math.min(jbk.O00000o0 - i, jbk2.O00000o0 - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (jbk.f1738O000000o[i4] != jbk2.f1738O000000o[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == jbk.O00000o0) {
                jbk = jbk.O00000oo;
                i = jbk.O00000Oo;
            } else {
                i = i4;
            }
            if (i3 == jbk2.O00000o0) {
                jbk2 = jbk2.O00000oo;
                i2 = jbk2.O00000Oo;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public final int hashCode() {
        jbk jbk = this.f1718O000000o;
        if (jbk == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jbk.O00000o0;
            for (int i3 = jbk.O00000Oo; i3 < i2; i3++) {
                i = (i * 31) + jbk.f1738O000000o[i3];
            }
            jbk = jbk.O00000oo;
        } while (jbk != this.f1718O000000o);
        return i;
    }

    public final String toString() {
        return O0000ooO().toString();
    }

    /* renamed from: O0000oo */
    public final jax clone() {
        jax jax = new jax();
        if (this.O00000Oo == 0) {
            return jax;
        }
        jax.f1718O000000o = this.f1718O000000o.O000000o();
        jbk jbk = jax.f1718O000000o;
        jbk.O0000O0o = jbk;
        jbk.O00000oo = jbk;
        jbk jbk2 = this.f1718O000000o;
        while (true) {
            jbk2 = jbk2.O00000oo;
            if (jbk2 != this.f1718O000000o) {
                jax.f1718O000000o.O0000O0o.O000000o(jbk2.O000000o());
            } else {
                jax.O00000Oo = this.O00000Oo;
                return jax;
            }
        }
    }

    public final ByteString O0000ooO() {
        long j = this.O00000Oo;
        if (j <= 2147483647L) {
            return O0000OoO((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.O00000Oo);
    }

    private ByteString O0000OoO(int i) {
        if (i == 0) {
            return ByteString.O00000Oo;
        }
        return new SegmentedByteString(this, i);
    }

    public final O000000o O000000o(O000000o o000000o) {
        if (o000000o.f1721O000000o == null) {
            o000000o.f1721O000000o = this;
            o000000o.O00000Oo = true;
            return o000000o;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class O000000o implements Closeable {

        /* renamed from: O000000o  reason: collision with root package name */
        public jax f1721O000000o;
        public boolean O00000Oo;
        public byte[] O00000o;
        public long O00000o0 = -1;
        public int O00000oO = -1;
        public int O00000oo = -1;
        private jbk O0000O0o;

        public final int O000000o(long j) {
            jbk jbk;
            long j2;
            if (j < -1 || j > this.f1721O000000o.O00000Oo) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.f1721O000000o.O00000Oo)));
            } else if (j == -1 || j == this.f1721O000000o.O00000Oo) {
                this.O0000O0o = null;
                this.O00000o0 = j;
                this.O00000o = null;
                this.O00000oO = -1;
                this.O00000oo = -1;
                return -1;
            } else {
                long j3 = 0;
                long j4 = this.f1721O000000o.O00000Oo;
                jbk jbk2 = this.f1721O000000o.f1718O000000o;
                jbk jbk3 = this.f1721O000000o.f1718O000000o;
                jbk jbk4 = this.O0000O0o;
                if (jbk4 != null) {
                    long j5 = this.O00000o0 - ((long) (this.O00000oO - jbk4.O00000Oo));
                    if (j5 > j) {
                        jbk3 = this.O0000O0o;
                        j4 = j5;
                    } else {
                        jbk2 = this.O0000O0o;
                        j3 = j5;
                    }
                }
                if (j4 - j > j - j3) {
                    while (j >= ((long) (jbk.O00000o0 - jbk.O00000Oo)) + j2) {
                        j3 = j2 + ((long) (jbk.O00000o0 - jbk.O00000Oo));
                        jbk2 = jbk.O00000oo;
                    }
                } else {
                    j2 = j4;
                    jbk = jbk3;
                    while (j2 > j) {
                        jbk = jbk.O0000O0o;
                        j2 -= (long) (jbk.O00000o0 - jbk.O00000Oo);
                    }
                }
                if (this.O00000Oo && jbk.O00000o) {
                    jbk O00000Oo2 = jbk.O00000Oo();
                    if (this.f1721O000000o.f1718O000000o == jbk) {
                        this.f1721O000000o.f1718O000000o = O00000Oo2;
                    }
                    jbk = jbk.O000000o(O00000Oo2);
                    jbk.O0000O0o.O00000o0();
                }
                this.O0000O0o = jbk;
                this.O00000o0 = j;
                this.O00000o = jbk.f1738O000000o;
                this.O00000oO = jbk.O00000Oo + ((int) (j - j2));
                this.O00000oo = jbk.O00000o0;
                return this.O00000oo - this.O00000oO;
            }
        }

        public final void close() {
            if (this.f1721O000000o != null) {
                this.f1721O000000o = null;
                this.O0000O0o = null;
                this.O00000o0 = -1;
                this.O00000o = null;
                this.O00000oO = -1;
                this.O00000oo = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}
