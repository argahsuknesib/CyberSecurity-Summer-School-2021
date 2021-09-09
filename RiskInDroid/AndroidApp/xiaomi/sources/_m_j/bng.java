package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class bng implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Charset f13132O000000o;
    private final InputStream O00000Oo;
    private int O00000o;
    private byte[] O00000o0;
    private int O00000oO;

    public bng(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private bng(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(bnh.f13134O000000o)) {
            this.O00000Oo = inputStream;
            this.f13132O000000o = charset;
            this.O00000o0 = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void close() throws IOException {
        synchronized (this.O00000Oo) {
            if (this.O00000o0 != null) {
                this.O00000o0 = null;
                this.O00000Oo.close();
            }
        }
    }

    public final String O000000o() throws IOException {
        int i;
        int i2;
        synchronized (this.O00000Oo) {
            if (this.O00000o0 != null) {
                if (this.O00000o >= this.O00000oO) {
                    O00000Oo();
                }
                for (int i3 = this.O00000o; i3 != this.O00000oO; i3++) {
                    if (this.O00000o0[i3] == 10) {
                        if (i3 != this.O00000o) {
                            i2 = i3 - 1;
                            if (this.O00000o0[i2] == 13) {
                                String str = new String(this.O00000o0, this.O00000o, i2 - this.O00000o, this.f13132O000000o.name());
                                this.O00000o = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.O00000o0, this.O00000o, i2 - this.O00000o, this.f13132O000000o.name());
                        this.O00000o = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.O00000oO - this.O00000o) + 80) {
                    /* class _m_j.bng.AnonymousClass1 */

                    public final String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, bng.this.f13132O000000o.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.O00000o0, this.O00000o, this.O00000oO - this.O00000o);
                    this.O00000oO = -1;
                    O00000Oo();
                    i = this.O00000o;
                    while (true) {
                        if (i != this.O00000oO) {
                            if (this.O00000o0[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.O00000o) {
                    r1.write(this.O00000o0, this.O00000o, i - this.O00000o);
                }
                this.O00000o = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    private void O00000Oo() throws IOException {
        InputStream inputStream = this.O00000Oo;
        byte[] bArr = this.O00000o0;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.O00000o = 0;
            this.O00000oO = read;
            return;
        }
        throw new EOFException();
    }
}
