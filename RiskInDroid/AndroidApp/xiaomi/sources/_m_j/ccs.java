package _m_j;

import android.content.Context;

public final class ccs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13638O000000o = false;
    private static boolean O00000Oo = false;
    private static boolean O00000o = false;
    private static boolean O00000o0 = false;

    public static void O000000o(boolean z) {
        f13638O000000o = z;
    }

    public static boolean O000000o() {
        return f13638O000000o;
    }

    public static boolean O00000Oo() {
        return O00000Oo;
    }

    public static boolean O00000o0() {
        return O00000o0;
    }

    public static void O00000Oo(boolean z) {
        O00000Oo = z;
    }

    public static void O00000o0(boolean z) {
        O00000o0 = z;
    }

    public static boolean O00000o() {
        return O00000o;
    }

    public static void O00000o(boolean z) {
        O00000o = z;
    }

    private static boolean O000000o(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0);
            return true;
        } catch (Exception e) {
            cdc.O00000Oo("BS", "cannot get pkginfo com.xiaomi.xmsf, not miui.", e);
            return false;
        }
    }

    private static boolean O00000oo() {
        try {
            if (!O000000o(ccx.O000000o())) {
                return false;
            }
            Object obj = Class.forName("miui.os.Build").getField("IS_ALPHA_BUILD").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O0000O0o() {
        try {
            if (!O000000o(ccx.O000000o())) {
                return false;
            }
            Object obj = Class.forName("miui.os.Build").getField("IS_DEVELOPMENT_VERSION").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O0000OOo() {
        try {
            if (!O000000o(ccx.O000000o())) {
                return false;
            }
            Object obj = Class.forName("miui.os.Build").getField("IS_STABLE_VERSION").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String O00000oO() {
        if (O0000OOo()) {
            return "S";
        }
        if (O0000O0o()) {
            return "D";
        }
        return O00000oo() ? "A" : "";
    }
}
