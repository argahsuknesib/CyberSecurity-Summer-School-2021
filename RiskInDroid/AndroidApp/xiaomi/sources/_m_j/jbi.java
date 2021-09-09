package _m_j;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

final class jbi implements jay {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jax f1734O000000o = new jax();
    public final jbm O00000Oo;
    boolean O00000o0;

    jbi(jbm jbm) {
        if (jbm != null) {
            this.O00000Oo = jbm;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public final jax O000000o() {
        return this.f1734O000000o;
    }

    public final void write(jax jax, long j) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.write(jax, j);
            O0000ooo();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000o0(ByteString byteString) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O00000o0(byteString);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000Oo(String str) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O00000Oo(str);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000Oo(String str, Charset charset) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O00000Oo(str, charset);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000o0(byte[] bArr) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O00000o0(bArr);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000o0(byte[] bArr, int i, int i2) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O00000o0(bArr, i, i2);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.O00000o0) {
            int write = this.f1734O000000o.write(byteBuffer);
            O0000ooo();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public final long O000000o(jbn jbn) throws IOException {
        if (jbn != null) {
            long j = 0;
            while (true) {
                long read = jbn.read(this.f1734O000000o, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                O0000ooo();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final jay O0000Oo(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000Oo(i);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000Oo0(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000Oo0(i);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000OOo(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000OOo(i);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000O0o(int i) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000O0o(i);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000o0o(long j) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000o0o(j);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000o0O(long j) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000o0O(j);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000o0(long j) throws IOException {
        if (!this.O00000o0) {
            this.f1734O000000o.O0000o0(j);
            return O0000ooo();
        }
        throw new IllegalStateException("closed");
    }

    public final jay O0000ooo() throws IOException {
        if (!this.O00000o0) {
            long O00000oo = this.f1734O000000o.O00000oo();
            if (O00000oo > 0) {
                this.O00000Oo.write(this.f1734O000000o, O00000oo);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final jay O00000o0() throws IOException {
        if (!this.O00000o0) {
            long j = this.f1734O000000o.O00000Oo;
            if (j > 0) {
                this.O00000Oo.write(this.f1734O000000o, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final OutputStream O00000Oo() {
        return new OutputStream() {
            /* class _m_j.jbi.AnonymousClass1 */

            public final void write(int i) throws IOException {
                if (!jbi.this.O00000o0) {
                    jbi.this.f1734O000000o.O0000Oo((int) ((byte) i));
                    jbi.this.O0000ooo();
                    return;
                }
                throw new IOException("closed");
            }

            public final void write(byte[] bArr, int i, int i2) throws IOException {
                if (!jbi.this.O00000o0) {
                    jbi.this.f1734O000000o.O00000o0(bArr, i, i2);
                    jbi.this.O0000ooo();
                    return;
                }
                throw new IOException("closed");
            }

            public final void flush() throws IOException {
                if (!jbi.this.O00000o0) {
                    jbi.this.flush();
                }
            }

            public final void close() throws IOException {
                jbi.this.close();
            }

            public final String toString() {
                return jbi.this + ".outputStream()";
            }
        };
    }

    public final void flush() throws IOException {
        if (!this.O00000o0) {
            if (this.f1734O000000o.O00000Oo > 0) {
                jbm jbm = this.O00000Oo;
                jax jax = this.f1734O000000o;
                jbm.write(jax, jax.O00000Oo);
            }
            this.O00000Oo.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean isOpen() {
        return !this.O00000o0;
    }

    public final void close() throws IOException {
        if (!this.O00000o0) {
            Throwable th = null;
            try {
                if (this.f1734O000000o.O00000Oo > 0) {
                    this.O00000Oo.write(this.f1734O000000o, this.f1734O000000o.O00000Oo);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.O00000Oo.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.O00000o0 = true;
            if (th != null) {
                jbp.O000000o(th);
            }
        }
    }

    public final jbo timeout() {
        return this.O00000Oo.timeout();
    }

    public final String toString() {
        return "buffer(" + this.O00000Oo + ")";
    }
}
