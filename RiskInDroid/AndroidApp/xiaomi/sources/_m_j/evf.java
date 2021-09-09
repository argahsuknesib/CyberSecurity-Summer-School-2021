package _m_j;

import android.content.Context;

final class evf {
    public static int O000000o(Context context, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float O00000Oo(Context context, float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return f * context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static String O000000o(int i) {
        return i < 10 ? "0".concat(String.valueOf(i)) : String.valueOf(i);
    }

    public static String O00000Oo(int i) {
        if (i > 99) {
            return String.valueOf(i / 10);
        }
        if (i <= 9) {
            return "0".concat(String.valueOf(i));
        }
        return String.valueOf(i);
    }
}
