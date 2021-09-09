package _m_j;

import java.io.IOException;
import java.io.OutputStream;

public final class avc {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12635O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final String O0000O0o;
    public auz O0000OOo;
    private final OutputStream O0000Oo;
    public auy O0000Oo0;

    public avc(String str, String str2, String str3, String str4, OutputStream outputStream, String str5, String str6, String str7, auz auz, auy auy) {
        this.f12635O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = str4;
        this.O0000Oo = outputStream;
        this.O00000oO = str5;
        this.O00000oo = str6;
        this.O0000O0o = str7;
        this.O0000OOo = auz;
        this.O0000Oo0 = auy;
    }

    public final void O000000o(String str) {
        if (this.O0000Oo != null) {
            try {
                this.O0000Oo.write((str + 10).getBytes("UTF8"));
            } catch (IOException | RuntimeException e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
