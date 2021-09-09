package _m_j;

import java.io.IOException;
import java.io.InputStream;

public final class dym extends InputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    dyj f15072O000000o = null;
    private final String O00000Oo = "AopInputStream";
    private long O00000o = 0;
    private final InputStream O00000o0;

    public dym(InputStream inputStream) {
        this.O00000o0 = inputStream;
    }

    private void O000000o() {
        dyj dyj = this.f15072O000000o;
        if (dyj != null) {
            dyj.O000000o(this.O00000o);
        }
    }

    private void O00000Oo() {
        dyj dyj = this.f15072O000000o;
        if (dyj != null) {
            dyj.O00000o0(this.O00000o);
        }
    }

    public final int read() throws IOException {
        try {
            int read = this.O00000o0.read();
            if (read >= 0) {
                this.O00000o += (long) read;
            } else {
                O000000o();
            }
            return read;
        } catch (IOException e) {
            O00000Oo();
            throw e;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.O00000o0.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.O00000o += (long) read;
            } else {
                O000000o();
            }
            return read;
        } catch (IOException e) {
            O00000Oo();
            throw e;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.O00000o0.read(bArr, i, i2);
            if (read >= 0) {
                this.O00000o += (long) read;
            } else {
                O000000o();
            }
            return read;
        } catch (IOException e) {
            O00000Oo();
            throw e;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.O00000o0.skip(j);
            this.O00000o += skip;
            return skip;
        } catch (IOException e) {
            O00000Oo();
            throw e;
        }
    }

    public final int available() throws IOException {
        try {
            return this.O00000o0.available();
        } catch (IOException e) {
            throw e;
        }
    }

    public final void close() throws IOException {
        try {
            this.O00000o0.close();
            O000000o();
        } catch (IOException e) {
            O00000Oo();
            throw e;
        }
    }

    public final void mark(int i) {
        if (markSupported()) {
            this.O00000o0.mark(i);
        }
    }

    public final boolean markSupported() {
        return this.O00000o0.markSupported();
    }

    public final void reset() throws IOException {
        if (markSupported()) {
            try {
                this.O00000o0.reset();
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
