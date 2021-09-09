package _m_j;

import java.io.IOException;
import java.io.InputStream;

public final class jjh extends jjg {
    public jjh(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public final long O000000o(int i, String str) throws IOException {
        long O000000o2 = O000000o(i);
        O000000o(str, String.valueOf(O000000o2));
        return O000000o2;
    }

    private int O00000oO() throws IOException {
        int i = 0;
        while (O000000o() == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + O000000o(i));
    }

    public final int O000000o(String str) throws IOException {
        int O00000oO = O00000oO();
        O000000o(str, String.valueOf(O00000oO));
        return O00000oO;
    }

    public final int O00000Oo(String str) throws IOException {
        int O00000oO = O00000oO();
        int i = O00000oO & 1;
        int i2 = ((O00000oO >> 1) + i) * ((i << 1) - 1);
        O000000o(str, String.valueOf(i2));
        return i2;
    }

    public final boolean O00000o0(String str) throws IOException {
        boolean z = O000000o() != 0;
        O000000o(str, z ? "1" : "0");
        return z;
    }

    public final int O00000Oo(int i, String str) throws IOException {
        return (int) O000000o(i, str);
    }

    public final void O00000o() throws IOException {
        O000000o();
        O00000o0();
    }

    private void O000000o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(f1881O000000o - this.O00000Oo.O00000Oo);
        int length = 8 - valueOf.length();
        sb.append("@".concat(String.valueOf(valueOf)));
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }
        sb.append(str);
        int length2 = (100 - sb.length()) - this.O00000Oo.O00000Oo;
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(' ');
        }
        sb.append(this.O00000Oo);
        sb.append(" (" + str2 + ")");
        this.O00000Oo.O00000Oo = 0;
    }
}
