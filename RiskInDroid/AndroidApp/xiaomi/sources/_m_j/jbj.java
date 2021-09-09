package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

final class jbj implements jaz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jax f1736O000000o = new jax();
    public final jbn O00000Oo;
    boolean O00000o0;

    jbj(jbn jbn) {
        if (jbn != null) {
            this.O00000Oo = jbn;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final jax O000000o() {
        return this.f1736O000000o;
    }

    public final long read(jax jax, long j) throws IOException {
        if (jax == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.O00000o0) {
            throw new IllegalStateException("closed");
        } else if (this.f1736O000000o.O00000Oo == 0 && this.O00000Oo.read(this.f1736O000000o, 8192) == -1) {
            return -1;
        } else {
            return this.f1736O000000o.read(jax, Math.min(j, this.f1736O000000o.O00000Oo));
        }
    }

    public final boolean O00000o() throws IOException {
        if (!this.O00000o0) {
            return this.f1736O000000o.O00000o() && this.O00000Oo.read(this.f1736O000000o, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final void O000000o(long j) throws IOException {
        if (!O00000Oo(j)) {
            throw new EOFException();
        }
    }

    public final boolean O00000Oo(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (!this.O00000o0) {
            while (this.f1736O000000o.O00000Oo < j) {
                if (this.O00000Oo.read(this.f1736O000000o, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final byte O0000O0o() throws IOException {
        O000000o(1);
        return this.f1736O000000o.O0000O0o();
    }

    public final ByteString O00000o(long j) throws IOException {
        O000000o(j);
        return this.f1736O000000o.O00000o(j);
    }

    public final byte[] O0000oOO() throws IOException {
        this.f1736O000000o.O000000o(this.O00000Oo);
        return this.f1736O000000o.O0000oOO();
    }

    public final byte[] O0000OOo(long j) throws IOException {
        O000000o(j);
        return this.f1736O000000o.O0000OOo(j);
    }

    public final void O000000o(byte[] bArr) throws IOException {
        try {
            O000000o((long) bArr.length);
            this.f1736O000000o.O000000o(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f1736O000000o.O00000Oo > 0) {
                jax jax = this.f1736O000000o;
                int O000000o2 = jax.O000000o(bArr, i, (int) jax.O00000Oo);
                if (O000000o2 != -1) {
                    i += O000000o2;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f1736O000000o.O00000Oo == 0 && this.O00000Oo.read(this.f1736O000000o, 8192) == -1) {
            return -1;
        }
        return this.f1736O000000o.read(byteBuffer);
    }

    public final void O000000o(jax jax, long j) throws IOException {
        try {
            O000000o(j);
            this.f1736O000000o.O000000o(jax, j);
        } catch (EOFException e) {
            jax.O000000o((jbn) this.f1736O000000o);
            throw e;
        }
    }

    public final long O000000o(jbm jbm) throws IOException {
        if (jbm != null) {
            long j = 0;
            while (this.O00000Oo.read(this.f1736O000000o, 8192) != -1) {
                long O00000oo = this.f1736O000000o.O00000oo();
                if (O00000oo > 0) {
                    j += O00000oo;
                    jbm.write(this.f1736O000000o, O00000oo);
                }
            }
            if (this.f1736O000000o.O00000Oo <= 0) {
                return j;
            }
            long j2 = j + this.f1736O000000o.O00000Oo;
            jax jax = this.f1736O000000o;
            jbm.write(jax, jax.O00000Oo);
            return j2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final String O0000o() throws IOException {
        this.f1736O000000o.O000000o(this.O00000Oo);
        return this.f1736O000000o.O0000o();
    }

    public final String O00000oO(long j) throws IOException {
        O000000o(j);
        return this.f1736O000000o.O00000oO(j);
    }

    public final String O000000o(Charset charset) throws IOException {
        if (charset != null) {
            this.f1736O000000o.O000000o(this.O00000Oo);
            return this.f1736O000000o.O000000o(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String O0000oO0() throws IOException {
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
    public final String O00000oo(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long O000000o2 = O000000o((byte) 10, 0, j2);
            if (O000000o2 != -1) {
                return this.f1736O000000o.O0000O0o(O000000o2);
            }
            if (j2 < Long.MAX_VALUE && O00000Oo(j2) && this.f1736O000000o.O00000o0(j2 - 1) == 13 && O00000Oo(1 + j2) && this.f1736O000000o.O00000o0(j2) == 10) {
                return this.f1736O000000o.O0000O0o(j2);
            }
            jax jax = new jax();
            jax jax2 = this.f1736O000000o;
            jax2.O000000o(jax, 0, Math.min(32L, jax2.O00000Oo));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f1736O000000o.O00000Oo, j) + " content=" + jax.O0000o0o().O00000oo() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    public final short O0000OOo() throws IOException {
        O000000o(2);
        return this.f1736O000000o.O0000OOo();
    }

    public final short O0000OoO() throws IOException {
        O000000o(2);
        return jbp.O000000o(this.f1736O000000o.O0000OOo());
    }

    public final int O0000Oo0() throws IOException {
        O000000o(4);
        return this.f1736O000000o.O0000Oo0();
    }

    public final int O0000Ooo() throws IOException {
        O000000o(4);
        return jbp.O000000o(this.f1736O000000o.O0000Oo0());
    }

    public final long O0000Oo() throws IOException {
        O000000o(8);
        return this.f1736O000000o.O0000Oo();
    }

    public final long O0000o00() throws IOException {
        O000000o(8);
        return jbp.O000000o(this.f1736O000000o.O0000Oo());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    public final long O0000o0() throws IOException {
        O000000o(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!O00000Oo((long) i2)) {
                break;
            }
            byte O00000o02 = this.f1736O000000o.O00000o0((long) i);
            if ((O00000o02 >= 48 && O00000o02 <= 57) || (i == 0 && O00000o02 == 45)) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(O00000o02)));
            }
        }
        if (i == 0) {
        }
        return this.f1736O000000o.O0000o0();
    }

    public final long O0000o0O() throws IOException {
        O000000o(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!O00000Oo((long) i2)) {
                break;
            }
            byte O00000o02 = this.f1736O000000o.O00000o0((long) i);
            if ((O00000o02 >= 48 && O00000o02 <= 57) || ((O00000o02 >= 97 && O00000o02 <= 102) || (O00000o02 >= 65 && O00000o02 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(O00000o02)));
            }
        }
        return this.f1736O000000o.O0000o0O();
    }

    public final void O0000Oo0(long j) throws IOException {
        if (!this.O00000o0) {
            while (j > 0) {
                if (this.f1736O000000o.O00000Oo == 0 && this.O00000Oo.read(this.f1736O000000o, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f1736O000000o.O00000Oo);
                this.f1736O000000o.O0000Oo0(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final long O0000oo0() throws IOException {
        return O000000o((byte) 0, 0, Long.MAX_VALUE);
    }

    private long O000000o(byte b, long j, long j2) throws IOException {
        if (this.O00000o0) {
            throw new IllegalStateException("closed");
        } else if (j2 >= 0) {
            while (j < j2) {
                long O000000o2 = this.f1736O000000o.O000000o(b, j, j2);
                if (O000000o2 == -1) {
                    long j3 = this.f1736O000000o.O00000Oo;
                    if (j3 >= j2 || this.O00000Oo.read(this.f1736O000000o, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return O000000o2;
                }
            }
            return -1;
        } else {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", 0L, Long.valueOf(j2)));
        }
    }

    public final boolean O00000Oo(ByteString byteString) throws IOException {
        int O0000OOo = byteString.O0000OOo();
        if (this.O00000o0) {
            throw new IllegalStateException("closed");
        } else if (O0000OOo < 0 || byteString.O0000OOo() - 0 < O0000OOo) {
            return false;
        } else {
            for (int i = 0; i < O0000OOo; i++) {
                long j = ((long) i) + 0;
                if (!O00000Oo(1 + j) || this.f1736O000000o.O00000o0(j) != byteString.O000000o(i + 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final InputStream O00000oO() {
        return new InputStream() {
            /* class _m_j.jbj.AnonymousClass1 */

            public final int read() throws IOException {
                if (jbj.this.O00000o0) {
                    throw new IOException("closed");
                } else if (jbj.this.f1736O000000o.O00000Oo == 0 && jbj.this.O00000Oo.read(jbj.this.f1736O000000o, 8192) == -1) {
                    return -1;
                } else {
                    return jbj.this.f1736O000000o.O0000O0o() & 255;
                }
            }

            public final int read(byte[] bArr, int i, int i2) throws IOException {
                if (!jbj.this.O00000o0) {
                    jbp.O000000o((long) bArr.length, (long) i, (long) i2);
                    if (jbj.this.f1736O000000o.O00000Oo == 0 && jbj.this.O00000Oo.read(jbj.this.f1736O000000o, 8192) == -1) {
                        return -1;
                    }
                    return jbj.this.f1736O000000o.O000000o(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(long, long):long}
             arg types: [long, int]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(float, float):float}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(long, long):long} */
            public final int available() throws IOException {
                if (!jbj.this.O00000o0) {
                    return (int) Math.min(jbj.this.f1736O000000o.O00000Oo, 2147483647L);
                }
                throw new IOException("closed");
            }

            public final void close() throws IOException {
                jbj.this.close();
            }

            public final String toString() {
                return jbj.this + ".inputStream()";
            }
        };
    }

    public final boolean isOpen() {
        return !this.O00000o0;
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            this.O00000Oo.close();
            this.f1736O000000o.O0000oOo();
        }
    }

    public final jbo timeout() {
        return this.O00000Oo.timeout();
    }

    public final String toString() {
        return "buffer(" + this.O00000Oo + ")";
    }
}
