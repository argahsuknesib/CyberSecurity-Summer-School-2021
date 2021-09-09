package _m_j;

import android.graphics.Bitmap;
import android.text.TextUtils;

public final class ckl {
    public static boolean O000000o(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap O000000o(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            cki.O00000o("AVToolUtils", "safeCreateBitmap() failed OOM: %s", e);
            return null;
        } catch (Exception e2) {
            cki.O00000o("AVToolUtils", "safeCreateBitmap() failed: %s", e2);
            return null;
        }
    }
}
