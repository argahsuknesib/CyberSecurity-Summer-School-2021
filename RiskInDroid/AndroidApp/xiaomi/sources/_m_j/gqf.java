package _m_j;

import android.graphics.Paint;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public final class gqf {
    private static Field O00000Oo() {
        Field field = null;
        try {
            field = Class.forName("android.text.TextLine").getDeclaredField("sCached");
            field.setAccessible(true);
            return field;
        } catch (Exception e) {
            e.printStackTrace();
            return field;
        }
    }

    public static void O000000o() {
        Object obj;
        Field O00000Oo = O00000Oo();
        if (O00000Oo != null) {
            try {
                obj = O00000Oo.get(null);
            } catch (Exception unused) {
                obj = null;
            }
            if (obj != null) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Array.set(obj, i, null);
                }
            }
        }
    }

    public static int O000000o(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }
}
