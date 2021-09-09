package _m_j;

import java.io.IOException;
import java.io.OutputStream;

public final class dyn extends OutputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    dyj f15073O000000o = null;
    private final String O00000Oo = "AopOutputStream";
    private long O00000o = 0;
    private final OutputStream O00000o0;

    public dyn(OutputStream outputStream) {
        this.O00000o0 = outputStream;
    }

    public final void write(int i) throws IOException {
        try {
            this.O00000o0.write(i);
            this.O00000o++;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.O00000o0.write(bArr);
            this.O00000o += (long) bArr.length;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.O00000o0.write(bArr, i, i2);
            this.O00000o += (long) i2;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void flush() throws IOException {
        try {
            this.O00000o0.flush();
        } catch (IOException e) {
            throw e;
        }
    }

    public final void close() throws IOException {
        try {
            this.O00000o0.close();
            if (this.f15073O000000o != null) {
                this.f15073O000000o.O00000Oo(this.O00000o);
            }
        } catch (IOException e) {
            dyj dyj = this.f15073O000000o;
            if (dyj != null) {
                dyj.O00000o(this.O00000o);
            }
            throw e;
        }
    }
}
