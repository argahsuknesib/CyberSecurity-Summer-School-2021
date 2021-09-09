package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ecc {
    private ecc() {
    }

    /* synthetic */ ecc(byte b) {
        this();
    }

    static void O000000o(byte[] bArr, int i) {
        bArr[0] = (byte) ((i >> 8) & 255);
        bArr[1] = (byte) (i & 255);
    }

    public static byte[] O000000o(byte[]... bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            try {
                byte[] bArr2 = bArr[i];
                if (bArr2 != null) {
                    byteArrayOutputStream.write(bArr2);
                }
                i++;
            } catch (IOException unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
