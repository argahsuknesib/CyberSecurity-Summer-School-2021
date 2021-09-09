package _m_j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class mt {

    /* renamed from: O000000o  reason: collision with root package name */
    byte[] f2187O000000o;
    int O00000Oo;
    private String O00000o0;

    public mt(int i) {
        this.O00000o0 = null;
        this.f2187O000000o = new byte[i];
        this.O00000Oo = 0;
    }

    public mt(InputStream inputStream) throws IOException {
        this.O00000o0 = null;
        this.O00000Oo = 0;
        this.f2187O000000o = new byte[16384];
        while (true) {
            int read = inputStream.read(this.f2187O000000o, this.O00000Oo, 16384);
            if (read > 0) {
                this.O00000Oo += read;
                if (read == 16384) {
                    O000000o(this.O00000Oo + 16384);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public mt(byte[] bArr) {
        this.O00000o0 = null;
        this.f2187O000000o = bArr;
        this.O00000Oo = bArr.length;
    }

    public mt(byte[] bArr, int i, int i2) {
        this.O00000o0 = null;
        if (i2 <= bArr.length - 0) {
            this.f2187O000000o = new byte[i2];
            System.arraycopy(bArr, 0, this.f2187O000000o, 0, i2);
            this.O00000Oo = i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Valid length exceeds the buffer length.");
    }

    public final InputStream O000000o() {
        return new ByteArrayInputStream(this.f2187O000000o, 0, this.O00000Oo);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        byte[] bArr = this.f2187O000000o;
        if (i > bArr.length) {
            this.f2187O000000o = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, this.f2187O000000o, 0, bArr.length);
        }
    }

    public final void O000000o(byte[] bArr, int i) {
        O000000o(this.O00000Oo + i);
        System.arraycopy(bArr, 0, this.f2187O000000o, this.O00000Oo, i);
        this.O00000Oo += i;
    }

    public final String O00000Oo() {
        String str;
        if (this.O00000o0 == null) {
            int i = this.O00000Oo;
            if (i >= 2) {
                byte[] bArr = this.f2187O000000o;
                if (bArr[0] == 0) {
                    if (i < 4 || bArr[1] != 0) {
                        str = "UTF-16BE";
                        this.O00000o0 = str;
                    } else if ((bArr[2] & 255) == 254 && (bArr[3] & 255) == 255) {
                        str = "UTF-32BE";
                        this.O00000o0 = str;
                    }
                } else if ((bArr[0] & 255) < 128) {
                    if (bArr[1] == 0) {
                        str = (i < 4 || bArr[2] != 0) ? "UTF-16LE" : "UTF-32LE";
                        this.O00000o0 = str;
                    }
                } else if ((bArr[0] & 255) != 239) {
                    if ((bArr[0] & 255) == 254 || i < 4 || bArr[2] != 0) {
                        this.O00000o0 = "UTF-16";
                    }
                }
                this.O00000o0 = "UTF-32";
            }
            this.O00000o0 = "UTF-8";
        }
        return this.O00000o0;
    }
}
