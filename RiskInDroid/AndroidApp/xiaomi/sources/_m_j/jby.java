package _m_j;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public abstract class jby implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    final CRC32 f1753O000000o;
    long O00000Oo;
    private final Deflater O00000o;
    long O00000o0;
    private long O00000oO;
    private final byte[] O00000oo;
    private final byte[] O0000O0o;

    public final void O000000o(InputStream inputStream, int i) throws IOException {
        O000000o();
        while (true) {
            byte[] bArr = this.O0000O0o;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read < 0) {
                break;
            }
            O000000o(this.O0000O0o, read, i);
        }
        if (i == 8) {
            O00000Oo();
        }
    }

    private long O000000o(byte[] bArr, int i, int i2) throws IOException {
        long j = this.O00000Oo;
        this.f1753O000000o.update(bArr, 0, i);
        if (i2 == 8) {
            O00000Oo(bArr, 0, i);
        } else {
            O000000o(i);
        }
        this.O00000o0 += (long) i;
        return this.O00000Oo - j;
    }

    private void O000000o() {
        this.f1753O000000o.reset();
        this.O00000o.reset();
        this.O00000o0 = 0;
        this.O00000Oo = 0;
    }

    public void close() throws IOException {
        this.O00000o.end();
    }

    private void O00000Oo() throws IOException {
        this.O00000o.finish();
        while (!this.O00000o.finished()) {
            O00000o();
        }
    }

    private void O00000Oo(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0 && !this.O00000o.finished()) {
            if (i2 <= 8192) {
                this.O00000o.setInput(bArr, 0, i2);
                O00000o0();
                return;
            }
            int i3 = i2 / 8192;
            for (int i4 = 0; i4 < i3; i4++) {
                this.O00000o.setInput(bArr, (i4 * 8192) + 0, 8192);
                O00000o0();
            }
            int i5 = i3 * 8192;
            if (i5 < i2) {
                this.O00000o.setInput(bArr, i5 + 0, i2 - i5);
                O00000o0();
            }
        }
    }

    private void O00000o0() throws IOException {
        while (!this.O00000o.needsInput()) {
            O00000o();
        }
    }

    private void O00000o() throws IOException {
        Deflater deflater = this.O00000o;
        byte[] bArr = this.O00000oo;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            O000000o(deflate);
        }
    }

    private void O000000o(int i) throws IOException {
        long j = (long) i;
        this.O00000Oo += j;
        this.O00000oO += j;
    }
}
