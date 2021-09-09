package _m_j;

import java.io.Closeable;
import java.io.IOException;

public abstract class jrl implements Closeable {
    public abstract jpk O000000o();

    public abstract long O00000Oo();

    /* JADX INFO: finally extract failed */
    public final byte[] O00000o() throws IOException {
        long O00000Oo = O00000Oo();
        if (O00000Oo <= 2147483647L) {
            iqn O00000o0 = O00000o0();
            try {
                byte[] O0000o0O = O00000o0.O0000o0O();
                jqp.O000000o(O00000o0);
                if (O00000Oo == -1 || O00000Oo == ((long) O0000o0O.length)) {
                    return O0000o0O;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                jqp.O000000o(O00000o0);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(O00000Oo)));
        }
    }

    public abstract iqn O00000o0();

    public void close() {
        jqp.O000000o(O00000o0());
    }
}
