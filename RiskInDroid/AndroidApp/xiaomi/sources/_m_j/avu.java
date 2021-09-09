package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class avu {
    public static String O000000o(InputStream inputStream) throws IOException {
        Throwable th;
        int read;
        avt.O000000o(inputStream, "Cannot get String from a null object");
        char[] cArr = new char[65536];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        do {
            try {
                read = inputStreamReader.read(cArr, 0, 65536);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                    continue;
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } while (read >= 0);
        inputStreamReader.close();
        return sb.toString();
        throw th;
    }
}
