package _m_j;

import android.content.Context;

public final class esm {
    public static boolean O000000o(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
