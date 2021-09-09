package _m_j;

import com.xiaomi.push.jw;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class esh extends esk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected InputStream f15770O000000o = null;
    protected OutputStream O00000Oo = null;

    protected esh() {
    }

    public esh(OutputStream outputStream) {
        this.O00000Oo = outputStream;
    }

    public final int O000000o(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f15770O000000o;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new jw(4);
            } catch (IOException e) {
                throw new jw(0, e);
            }
        } else {
            throw new jw(1, "Cannot read from null inputStream");
        }
    }

    public final void O00000Oo(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.O00000Oo;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new jw(0, e);
            }
        } else {
            throw new jw(1, "Cannot write to null outputStream");
        }
    }
}
