package _m_j;

import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;

public final class gfo {
    public static void O000000o(File file) {
        if (file.isDirectory()) {
            for (File O000000o2 : file.listFiles()) {
                O000000o(O000000o2);
            }
        }
        O000000o("delete isSuccessDelete: " + file.delete() + " fileName: " + file);
    }

    public static void O000000o(String str) {
        gsy.O00000Oo(LogType.WEBVIEW, "Api64WebViewCompat", str);
    }
}
