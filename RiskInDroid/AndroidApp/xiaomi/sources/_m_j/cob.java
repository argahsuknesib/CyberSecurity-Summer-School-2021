package _m_j;

import java.io.IOException;
import java.io.InputStream;

public final class cob extends InputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    private final InputStream f14164O000000o;
    private final int O00000Oo;

    public cob(InputStream inputStream, int i) {
        this.f14164O000000o = inputStream;
        this.O00000Oo = i;
    }

    public final int available() {
        return this.O00000Oo;
    }

    public final void close() throws IOException {
        this.f14164O000000o.close();
    }

    public final void mark(int i) {
        this.f14164O000000o.mark(i);
    }

    public final int read() throws IOException {
        return this.f14164O000000o.read();
    }

    public final int read(byte[] bArr) throws IOException {
        return this.f14164O000000o.read(bArr);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f14164O000000o.read(bArr, i, i2);
    }

    public final void reset() throws IOException {
        this.f14164O000000o.reset();
    }

    public final long skip(long j) throws IOException {
        return this.f14164O000000o.skip(j);
    }

    public final boolean markSupported() {
        return this.f14164O000000o.markSupported();
    }
}
