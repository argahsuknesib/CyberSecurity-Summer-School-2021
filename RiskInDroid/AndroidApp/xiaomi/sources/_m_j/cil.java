package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mmkv.MMKV;
import java.util.Map;

public class cil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13903O000000o = "cil";
    private static boolean O00000Oo = false;

    public static String O000000o(Context context, String str) {
        MMKV O000000o2 = MMKV.O000000o("smart.camera.cache");
        O000000o(context, O000000o2);
        return O000000o2.getString(str, null);
    }

    public static int O00000Oo(Context context, String str) {
        MMKV O000000o2 = MMKV.O000000o("smart.camera.cache");
        O000000o(context, O000000o2);
        return O000000o2.getInt(str, 1);
    }

    private static void O000000o(Context context, MMKV mmkv) {
        if (context != null && mmkv != null && !O00000Oo) {
            if (mmkv.getBoolean("is_old_data_transferred", false)) {
                O00000Oo = true;
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mijia.camera.global.sp", 0);
            gsy.O00000Oo("xm111", "begin to transfer data");
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null && all.size() > 0) {
                for (Map.Entry next : all.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (!(str == null || value == null)) {
                        if (value instanceof Boolean) {
                            mmkv.putBoolean(str, ((Boolean) value).booleanValue());
                        } else if (value instanceof Integer) {
                            mmkv.putInt(str, ((Integer) value).intValue());
                        } else if (value instanceof Long) {
                            mmkv.putLong(str, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            mmkv.putFloat(str, ((Float) value).floatValue());
                        } else if (value instanceof Double) {
                            mmkv.O000000o(str, ((Double) value).doubleValue());
                        } else if (value instanceof String) {
                            try {
                                mmkv.putInt(str, Integer.parseInt((String) value));
                            } catch (Exception unused) {
                                mmkv.putString(str, (String) value);
                            }
                        }
                    }
                }
            }
            sharedPreferences.edit().clear().apply();
            O00000Oo = true;
        }
    }

    public static void O000000o(String str, String str2) {
        MMKV.O000000o("smart.camera.cache").putString(str, str2);
    }

    public static void O000000o(String str, int i) {
        MMKV.O000000o("smart.camera.cache").putInt(str, i);
    }
}
