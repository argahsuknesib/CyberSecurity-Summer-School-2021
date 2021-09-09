package _m_j;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class cot {

    public interface O000000o {
        boolean O000000o(int i, int i2);
    }

    public static boolean O000000o(InputStream inputStream, OutputStream outputStream, O000000o o000000o, int i) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i];
        if (O000000o(o000000o, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!O000000o(o000000o, i2, available));
        return false;
    }

    private static boolean O000000o(O000000o o000000o, int i, int i2) {
        return o000000o != null && !o000000o.O000000o(i, i2) && (i * 100) / i2 < 75;
    }

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
