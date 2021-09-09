package com.xiaomi.smarthome.uwb.lib.utils;

import _m_j.gpm;
import _m_j.gsy;
import _m_j.gtu;
import _m_j.gtv;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UwbLogUtil {
    public static gpm<String> sListCache;
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void d(String str, String str2) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3 && UwbSdk.getSdkConfig().getMode() != 2) {
            gsy.O000000o(3, str, str2);
        }
        writeLogOnGrey(str, str2);
    }

    public static void v(String str, String str2) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 2 && UwbSdk.getSdkConfig().getMode() != 2) {
            gsy.O000000o(2, str, str2);
        }
        writeLogOnGrey(str, str2);
    }

    public static void w(String str, String str2) {
        w(LogType.LOG_UWB, str, str2);
    }

    public static void w(LogType logType, String str, String str2) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 5 && UwbSdk.getSdkConfig().getMode() != 2) {
            gsy.O000000o(5, str, str2);
        }
        writeLogOnAll(logType, str, str2);
    }

    public static void e(String str, String str2) {
        e(LogType.LOG_UWB, str, str2);
    }

    public static void e(LogType logType, String str, String str2) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 6 && UwbSdk.getSdkConfig().getMode() != 2) {
            gsy.O000000o(6, str, str2);
        }
        writeLogOnAll(logType, str, str2);
    }

    private static void writeLogOnGrey(String str, String str2) {
        logUwbTest(str, str2);
        gtu O000000o2 = gtv.O000000o();
        if (O000000o2 != null) {
            O000000o2.writeLogOnGrey(LogType.LOG_UWB, str, str2);
        }
    }

    private static void writeLogOnAll(String str, String str2) {
        logUwbTest(str, str2);
        gtu O000000o2 = gtv.O000000o();
        if (O000000o2 != null) {
            O000000o2.writeLogOnAll(LogType.LOG_UWB, str, str2);
        }
    }

    public static void writeLogOnAll(LogType logType, String str, String str2) {
        logUwbTest(str, str2);
        gtu O000000o2 = gtv.O000000o();
        if (O000000o2 != null) {
            O000000o2.writeLogOnAll(logType, str, str2);
        }
    }

    private static void logUwbTest(String str, String str2) {
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            if (sListCache == null) {
                sListCache = new gpm<>(4096);
            }
            gpm<String> gpm = sListCache;
            gpm.O000000o(sdf.format(new Date()) + ":" + str + ":" + str2);
        }
    }

    public static String dumpCacheLog() {
        if (sListCache == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<String> O000000o2 = sListCache.O000000o();
        for (int size = O000000o2.size() - 1; size >= 0; size += -1) {
            stringBuffer.append(O000000o2.get(size) + "\n");
        }
        return stringBuffer.toString();
    }
}
