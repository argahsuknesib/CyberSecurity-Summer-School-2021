package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class ian implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Charset f1112O000000o;
    int O00000Oo;
    private byte[] O00000o;
    private final InputStream O00000o0;
    private int O00000oO;

    public ian(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private ian(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(iao.f1114O000000o)) {
            this.O00000o0 = inputStream;
            this.f1112O000000o = charset;
            this.O00000o = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void close() throws IOException {
        synchronized (this.O00000o0) {
            if (this.O00000o != null) {
                this.O00000o = null;
                this.O00000o0.close();
            }
        }
    }

    public final String O000000o() throws IOException {
        int i;
        int i2;
        synchronized (this.O00000o0) {
            if (this.O00000o != null) {
                if (this.O00000oO >= this.O00000Oo) {
                    O00000Oo();
                }
                for (int i3 = this.O00000oO; i3 != this.O00000Oo; i3++) {
                    if (this.O00000o[i3] == 10) {
                        if (i3 != this.O00000oO) {
                            i2 = i3 - 1;
                            if (this.O00000o[i2] == 13) {
                                String str = new String(this.O00000o, this.O00000oO, i2 - this.O00000oO, this.f1112O000000o.name());
                                this.O00000oO = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.O00000o, this.O00000oO, i2 - this.O00000oO, this.f1112O000000o.name());
                        this.O00000oO = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.O00000Oo - this.O00000oO) + 80) {
                    /* class _m_j.ian.AnonymousClass1 */

                    public final String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, ian.this.f1112O000000o.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.O00000o, this.O00000oO, this.O00000Oo - this.O00000oO);
                    this.O00000Oo = -1;
                    O00000Oo();
                    i = this.O00000oO;
                    while (true) {
                        if (i != this.O00000Oo) {
                            if (this.O00000o[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.O00000oO) {
                    r1.write(this.O00000o, this.O00000oO, i - this.O00000oO);
                }
                this.O00000oO = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    private void O00000Oo() throws IOException {
        InputStream inputStream = this.O00000o0;
        byte[] bArr = this.O00000o;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.O00000oO = 0;
            this.O00000Oo = read;
            return;
        }
        throw new EOFException();
    }
}
