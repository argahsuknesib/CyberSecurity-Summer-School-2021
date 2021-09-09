package _m_j;

import java.io.IOException;
import java.net.ProtocolException;
import ss.u;

public final class jqg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final u f2054O000000o;
    public final int O00000Oo;
    public final String O00000o0;

    private jqg(u uVar, int i, String str) {
        this.f2054O000000o = uVar;
        this.O00000Oo = i;
        this.O00000o0 = str;
    }

    public static jqg O000000o(String str) throws IOException {
        u uVar;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                uVar = u.HTTP_1_0;
            } else if (charAt == 1) {
                uVar = u.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
        } else if (str.startsWith("ICY ")) {
            uVar = u.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
                }
                return new jqg(uVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2054O000000o == u.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.O00000Oo);
        if (this.O00000o0 != null) {
            sb.append(' ');
            sb.append(this.O00000o0);
        }
        return sb.toString();
    }
}
