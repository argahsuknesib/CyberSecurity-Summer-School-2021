package _m_j;

import java.io.Closeable;
import java.io.IOException;

public final class gow {
    public static void O000000o(Closeable... closeableArr) {
        for (int i = 0; i < 2; i++) {
            Closeable closeable = closeableArr[i];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void O00000Oo(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}
