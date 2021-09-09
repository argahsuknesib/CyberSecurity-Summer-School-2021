package _m_j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class bre extends brb {
    private final byte[] O00000Oo;
    private final Charset O00000o0;

    public final String O00000o0() {
        return "8bit";
    }

    private bre(String str, String str2) throws UnsupportedEncodingException {
        super(str2);
        if (str != null) {
            Charset forName = Charset.forName("UTF-8");
            this.O00000Oo = str.getBytes(forName.name());
            this.O00000o0 = forName;
            return;
        }
        throw new IllegalArgumentException("Text may not be null");
    }

    public bre(String str) throws UnsupportedEncodingException {
        this(str, "text/plain");
    }

    public final void O000000o(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.O00000Oo);
            byte[] bArr = new byte[4096];
            do {
                int read = byteArrayInputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
                this.f13214O000000o.O00000o += (long) read;
            } while (this.f13214O000000o.O000000o(false));
            throw new InterruptedIOException("cancel");
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public final String O00000Oo() {
        return this.O00000o0.name();
    }

    public final long O00000o() {
        return (long) this.O00000Oo.length;
    }
}
