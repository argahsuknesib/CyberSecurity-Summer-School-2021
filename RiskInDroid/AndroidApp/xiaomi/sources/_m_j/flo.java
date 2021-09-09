package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;

public final class flo {
    private static int O00000o0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (i < min) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt != parseInt2) {
                    return parseInt - parseInt2;
                }
                i++;
            } catch (Exception unused) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean O000000o(int i, String str) {
        return i != 1 ? i != 4 ? i == 5 && O00000o0(str, "1.4.0") >= 0 : O00000o0(str, "1.1.0") >= 0 : O00000o0(str, "2.3.0") >= 0;
    }

    public static int O000000o(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        try {
            return Integer.parseInt(str) - Integer.parseInt(str2);
        } catch (Exception unused) {
            LogType logType = LogType.BLUETOOTH;
            gsy.O00000o0(logType, "VersionUtils", "compareMcuVersion fail, newVersion=" + str + ",oldVersion=" + str2);
            return 0;
        }
    }

    public static int O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (i < min) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt != parseInt2) {
                    return parseInt - parseInt2;
                }
                i++;
            } catch (Exception e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
                return 0;
            }
        }
        return split.length - split2.length;
    }
}
