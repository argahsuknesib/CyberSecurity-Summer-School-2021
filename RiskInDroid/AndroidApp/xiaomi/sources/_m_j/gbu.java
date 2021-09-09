package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;

public final class gbu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f17505O000000o = false;
    private static String O00000Oo = "";

    public static void O000000o(boolean z) {
        f17505O000000o = z;
    }

    public static void O00000Oo(String str) {
        O000000o("miot-rn-plugin", str);
    }

    public static void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                str = "miot-rn-plugin";
            }
            if (O000000o()) {
                int length = str2.length() / 2000;
                int i = 0;
                while (i <= length) {
                    int i2 = i * 2000;
                    i++;
                    int i3 = i * 2000;
                    if (i3 > str2.length()) {
                        i3 = str2.length();
                    }
                    if (i2 >= i3) {
                        i2 = i3 - 1;
                    }
                    gsy.O000000o(6, str, str2.substring(i2, i3));
                }
            }
        }
    }

    public static void O00000o0(String str) {
        O00000Oo("miot-rn-plugin", str);
    }

    public static void O00000Oo(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                str = "miot-rn-plugin";
            }
            if (O000000o()) {
                int length = str2.length() / 2000;
                int i = 0;
                while (i <= length) {
                    int i2 = i * 2000;
                    i++;
                    int i3 = i * 2000;
                    if (i3 > str2.length()) {
                        i3 = str2.length();
                    }
                    if (i2 >= i3) {
                        i2 = i3 - 1;
                    }
                    gsy.O000000o(3, str, str2.substring(i2, i3));
                }
            }
        }
    }

    public static void O00000oO(String str) {
        O00000Oo = str;
    }

    public static void O000000o(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            gsy.O00000o0(LogType.PLUGIN, str2, str, "ProcessName:" + O00000Oo + ":  " + str3);
        }
    }

    public static void O000000o(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", i, str, "ProcessName:" + O00000Oo + ",ThreadId:" + Thread.currentThread().getId() + ",:  " + str2);
        }
    }

    private static boolean O000000o() {
        return f17505O000000o || gfr.O0000OOo || gfr.O0000o0o || gfr.O0000Oo;
    }

    public static void O0000O0o(String str) {
        if (O000000o()) {
            if (TextUtils.isEmpty(str) || CommonApplication.getApplication() == null) {
                gsy.O000000o(6, "miot-rn-plugin", "content is empty or logFilePath is empty");
            } else {
                gsy.O00000o0(LogType.PLUGIN, "RnPlugin", "RnPluginLog", str);
            }
        }
    }

    public static void O000000o(Context context) {
        if (O000000o()) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            StringBuilder sb = new StringBuilder();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    sb.append("  进程名： ");
                    sb.append(runningAppProcessInfo.processName);
                }
            }
            gsy.O00000o0(LogType.PLUGIN, "RnPlugin", "RnPluginLog", sb.toString());
        }
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean isEmpty = TextUtils.isEmpty("miot-rn-plugin");
            if (O000000o()) {
                int length = str.length() / 2000;
                int i = 0;
                while (i <= length) {
                    int i2 = i * 2000;
                    i++;
                    int i3 = i * 2000;
                    if (i3 > str.length()) {
                        i3 = str.length();
                    }
                    if (i2 >= i3) {
                        i2 = i3 - 1;
                    }
                    gsy.O000000o(4, "miot-rn-plugin", str.substring(i2, i3));
                }
            }
        }
    }

    public static void O00000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean isEmpty = TextUtils.isEmpty("miot-rn-plugin");
            if (O000000o()) {
                int length = str.length() / 2000;
                int i = 0;
                while (i <= length) {
                    int i2 = i * 2000;
                    i++;
                    int i3 = i * 2000;
                    if (i3 > str.length()) {
                        i3 = str.length();
                    }
                    if (i2 >= i3) {
                        i2 = i3 - 1;
                    }
                    gsy.O000000o(5, "miot-rn-plugin", str.substring(i2, i3));
                }
            }
        }
    }

    public static void O00000oo(String str) {
        O000000o("miot-rn-plugin", 3, str);
    }
}
