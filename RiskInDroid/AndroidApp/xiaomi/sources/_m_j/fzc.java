package _m_j;

import android.content.Context;

final class fzc {
    static int O000000o(Context context, String str) {
        String replace = str.toLowerCase().replace("-", "_");
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            return context.getResources().getIdentifier(replace, "raw", context.getPackageName());
        }
    }
}
