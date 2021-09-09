package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class aca {
    public static byte[] O000000o(xm xmVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[257];
        while (true) {
            byte O00000Oo = xmVar.O00000Oo();
            if (O00000Oo == 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byte b = O00000Oo & 255;
            bArr[0] = O00000Oo;
            xmVar.O000000o(bArr, 1, b);
            byteArrayOutputStream.write(bArr, 0, b + 1);
        }
    }

    public static byte[] O000000o(xm xmVar, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i > 0) {
            byteArrayOutputStream.write(xmVar.O000000o(i), 0, i);
            i = xmVar.O00000Oo() & 255;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void O00000Oo(xm xmVar) throws IOException {
        while (true) {
            short O00000o = xmVar.O00000o();
            if (O00000o != 0) {
                xmVar.O000000o((long) O00000o);
            } else {
                return;
            }
        }
    }
}
