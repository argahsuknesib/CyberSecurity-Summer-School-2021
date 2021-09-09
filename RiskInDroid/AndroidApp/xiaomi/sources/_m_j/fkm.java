package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class fkm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Map<String, String[]> f16538O000000o = new HashMap();
    private static final Object O00000Oo = new Object();
    private static String O00000o = O00000Oo();
    private static volatile fkm O00000o0;

    static {
        f16538O000000o.put("arm", new String[]{"armeabi", "armeabi-v7a"});
        f16538O000000o.put("mips", new String[]{"mips"});
        f16538O000000o.put("mips64", new String[]{"mips64"});
        f16538O000000o.put("x86", new String[]{"x86"});
        f16538O000000o.put("x86_64", new String[]{"x86_64"});
        f16538O000000o.put("arm64", new String[]{"arm64-v8a"});
    }

    private fkm() {
    }

    public static fkm O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000Oo) {
                if (O00000o0 == null) {
                    O00000o0 = new fkm();
                }
            }
        }
        return O00000o0;
    }

    public static void O000000o(Context context, long j, long j2, String str) {
        System.currentTimeMillis();
        O00000Oo();
        new exs(str, hsi.O000000o(context, j, j2)).run();
        System.currentTimeMillis();
    }

    private static String O00000Oo() {
        try {
            String str = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
            if (gfr.O0000Ooo) {
                gsy.O00000Oo(LogType.PLUGIN, "PluginSoManager", "getCurrentInstructionSet:".concat(String.valueOf(str)));
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            LogType logType = LogType.PLUGIN;
            gsy.O00000Oo(logType, "PluginSoManager", "getCurrentInstructionSet exception " + e.getMessage());
            return "";
        }
    }

    public static String O000000o(Context context, long j, long j2) {
        String[] strArr = f16538O000000o.get(O00000o);
        if (strArr == null) {
            return null;
        }
        for (String O000000o2 : strArr) {
            String O000000o3 = hsi.O000000o(context, j, j2, O000000o2);
            if (new File(O000000o3).exists()) {
                return O000000o3;
            }
        }
        return null;
    }
}
