package _m_j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class dwl extends FilterInputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    private final dwe f15001O000000o;
    private final dwd O00000Oo;
    private long O00000o;
    private long O00000o0;

    public dwl(InputStream inputStream, dwd dwd, dwe dwe) {
        super(inputStream);
        this.O00000Oo = dwd;
        this.f15001O000000o = dwe;
    }

    private void O000000o(boolean z) {
        if (this.f15001O000000o != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!z || currentTimeMillis - this.O00000o0 >= 500) {
                this.O00000o0 = currentTimeMillis;
                this.O00000Oo.O000000o();
            }
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.O00000o += (long) read;
            O000000o(true);
        }
        return read;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.O00000o++;
            O000000o(true);
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        super.reset();
        this.O00000o = 0;
        O000000o(true);
    }

    public final void close() throws IOException {
        super.close();
        O000000o(false);
    }
}
