package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

public final class dih {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Class<?> f14665O000000o = null;
    private static Class<?> O00000Oo = null;
    private static Method O00000o = null;
    private static Method O00000o0 = null;
    private static Method O00000oO = null;
    private static Method O00000oo = null;
    private static boolean O0000O0o = false;

    public static void O000000o(Context context, dij dij, String str, String... strArr) {
        if (O0000O0o) {
            O00000o0(context, dij);
            try {
                O00000o.invoke(O00000Oo, context, str, strArr);
            } catch (Exception e) {
                diz.O00000oO("OpenConfig", "trackCustomEvent exception: " + e.toString());
            }
        }
    }

    private static void O00000o0(Context context, dij dij) {
        try {
            if (djl.O000000o(context, dij.f14674O000000o).O00000Oo("Common_ta_enable")) {
                O00000oo.invoke(f14665O000000o, Boolean.TRUE);
                return;
            }
            O00000oo.invoke(f14665O000000o, Boolean.FALSE);
        } catch (Exception e) {
            diz.O00000oO("OpenConfig", "checkStatStatus exception: " + e.toString());
        }
    }

    public static void O000000o(Context context, dij dij) {
        String concat = "Aqc".concat(String.valueOf(dij.f14674O000000o));
        try {
            f14665O000000o = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            O00000Oo = cls;
            O00000o0 = cls.getMethod("reportQQ", Context.class, String.class);
            O00000o = O00000Oo.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            O00000oO = O00000Oo.getMethod("commitEvents", Context.class, Integer.TYPE);
            O00000oo = f14665O000000o.getMethod("setEnableStatService", Boolean.TYPE);
            O00000o0(context, dij);
            f14665O000000o.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f14665O000000o, Boolean.FALSE);
            f14665O000000o.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f14665O000000o, Boolean.TRUE);
            f14665O000000o.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f14665O000000o, 1440);
            Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
            f14665O000000o.getMethod("setStatSendStrategy", cls2).invoke(f14665O000000o, cls2.getField("PERIOD").get(null));
            O00000Oo.getMethod("startStatService", Context.class, String.class, String.class).invoke(O00000Oo, context, concat, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            O0000O0o = true;
        } catch (Exception e) {
            diz.O00000oO("OpenConfig", "start4QQConnect exception: " + e.toString());
        }
    }

    public static void O00000Oo(Context context, dij dij) {
        if (!TextUtils.isEmpty(dij.O00000o0)) {
            diw.O000000o();
            diw.O000000o(dij.O00000o0, dij.f14674O000000o, "2", "1", "11", "0", "0", "0");
        }
        if (O0000O0o) {
            O00000o0(context, dij);
            if (dij.O00000o0 != null) {
                try {
                    O00000o0.invoke(O00000Oo, context, dij.O00000o0);
                } catch (Exception e) {
                    diz.O00000oO("OpenConfig", "reportQQ exception: " + e.toString());
                }
            }
        }
    }
}
