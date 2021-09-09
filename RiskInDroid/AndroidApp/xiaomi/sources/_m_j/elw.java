package _m_j;

import android.content.Context;

final class elw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f15616O000000o = false;

    public static boolean O000000o(Context context) {
        try {
            Class<?> O000000o2 = esu.O000000o(context, "com.bun.miitmdid.core.JLibrary");
            if (O000000o2 != null) {
                if (!f15616O000000o) {
                    f15616O000000o = true;
                    O000000o2.getDeclaredMethod("InitEntry", Context.class).invoke(O000000o2, context);
                }
                return true;
            }
        } catch (Throwable th) {
            duv.O000000o("mdid:check error ".concat(String.valueOf(th)));
        }
        return false;
    }
}
