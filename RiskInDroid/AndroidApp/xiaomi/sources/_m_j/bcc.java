package _m_j;

import java.io.IOException;
import java.io.OutputStreamWriter;

final class bcc {

    /* renamed from: O000000o  reason: collision with root package name */
    final OutputStreamWriter f12850O000000o;

    public bcc(OutputStreamWriter outputStreamWriter) {
        this.f12850O000000o = outputStreamWriter;
    }

    private void O00000o0(String str) throws IOException {
        this.f12850O000000o.write(str);
    }

    public final void O000000o(String str) throws IOException {
        O00000o0(str + "\n");
    }

    public final void O00000Oo(String str) throws IOException {
        O000000o("#".concat(String.valueOf(str)));
    }

    public final void O000000o(String str, String str2) throws IOException {
        O000000o("#" + str + ":" + str2);
    }
}
