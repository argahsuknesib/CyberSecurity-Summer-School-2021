package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class fim {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f16401O000000o = 4096;

    public static byte[] O000000o(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        O000000o(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static void O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[f16401O000000o];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
