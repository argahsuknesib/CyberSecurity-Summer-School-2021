package _m_j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class xv {

    /* renamed from: O000000o  reason: collision with root package name */
    public final byte[] f2600O000000o;
    private final Charset O00000Oo;

    public xv(byte[] bArr, Charset charset) {
        this.f2600O000000o = bArr;
        this.O00000Oo = charset;
    }

    public final String toString() {
        return O000000o(this.O00000Oo);
    }

    private String O000000o(Charset charset) {
        if (charset != null) {
            try {
                return new String(this.f2600O000000o, charset.name());
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new String(this.f2600O000000o);
    }
}
