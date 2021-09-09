package _m_j;

import android.database.Cursor;
import java.io.Closeable;

public final class brl {
    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void O000000o(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }
}
