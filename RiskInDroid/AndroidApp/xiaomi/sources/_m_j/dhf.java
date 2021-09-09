package _m_j;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class dhf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14638O000000o;

    private static Map<String, Integer> O00000o0(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    did.O00000oO("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e) {
            did.O00000oO("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    private static String O00000o(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012c A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014c A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0157 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0177 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0178 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0183 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a3 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d2 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0216 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022c A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0238 A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024e A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x026a A[Catch:{ NumberFormatException -> 0x027b, Throwable -> 0x028c }] */
    private static CrashDetailBean O000000o(Context context, Map<String, String> map, dhd dhd) {
        String str;
        String str2;
        String str3;
        Integer num;
        String str4;
        Integer num2;
        String str5;
        Integer num3;
        String str6;
        HashMap hashMap;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Map<String, String> map2 = map;
        if (dgs.O000000o(context) == null) {
            did.O00000oO("abnormal com info not created", new Object[0]);
            return null;
        }
        String str12 = map2.get("intStateStr");
        if (str12 == null || str12.trim().length() <= 0) {
            did.O00000oO("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> O00000o0 = O00000o0(str12);
        if (O00000o0 == null) {
            did.O00000oO("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            O00000o0.get("sino").intValue();
            O00000o0.get("sud").intValue();
            String str13 = map2.get("soVersion");
            if (str13 == null) {
                did.O00000oO("error format at version", new Object[0]);
                return null;
            }
            String str14 = map2.get("errorAddr");
            String str15 = "unknown";
            String str16 = str14 == null ? str15 : str14;
            String str17 = map2.get("codeMsg");
            if (str17 == null) {
                str17 = str15;
            }
            String str18 = map2.get("tombPath");
            String str19 = str18 == null ? str15 : str18;
            String str20 = map2.get("signalName");
            if (str20 == null) {
                str20 = str15;
            }
            map2.get("errnoMsg");
            String str21 = map2.get("stack");
            if (str21 == null) {
                str21 = str15;
            }
            String str22 = map2.get("jstack");
            if (str22 != null) {
                str21 = str21 + "java:\n" + str22;
            }
            Integer num4 = O00000o0.get("sico");
            if (num4 != null) {
                if (num4.intValue() > 0) {
                    str2 = str20 + "(" + str17 + ")";
                    str = "KERNEL";
                    String str23 = map2.get("nativeLog");
                    byte[] O000000o2 = (str23 != null || str23.isEmpty()) ? null : dif.O000000o((File) null, str23, "BuglyNativeLog.txt");
                    str3 = map2.get("sendingProcess");
                    if (str3 == null) {
                        str3 = str15;
                    }
                    num = O00000o0.get("spd");
                    if (num != null) {
                        str3 = str3 + "(" + num + ")";
                    }
                    String str24 = str3;
                    str4 = map2.get("threadName");
                    if (str4 == null) {
                        str4 = str15;
                    }
                    num2 = O00000o0.get("et");
                    if (num2 != null) {
                        str4 = str4 + "(" + num2 + ")";
                    }
                    String str25 = str4;
                    str5 = map2.get("processName");
                    if (str5 == null) {
                        str15 = str5;
                    }
                    num3 = O00000o0.get("ep");
                    if (num3 != null) {
                        str15 = str15 + "(" + num3 + ")";
                    }
                    String str26 = str15;
                    str6 = map2.get("key-value");
                    if (str6 == null) {
                        HashMap hashMap2 = new HashMap();
                        String[] split = str6.split("\n");
                        int length = split.length;
                        int i = 0;
                        while (i < length) {
                            String[] split2 = split[i].split("=");
                            String[] strArr = split;
                            if (split2.length == 2) {
                                hashMap2.put(split2[0], split2[1]);
                            }
                            i++;
                            split = strArr;
                        }
                        hashMap = hashMap2;
                    } else {
                        hashMap = null;
                    }
                    CrashDetailBean O000000o3 = dhd.O000000o(str26, str25, (((long) O00000o0.get("etms").intValue()) / 1000) + (((long) O00000o0.get("ets").intValue()) * 1000), str2, str16, O00000o(str21), str, str24, str19, map2.get("sysLogPath"), str13, O000000o2, hashMap);
                    str7 = map2.get("userId");
                    if (str7 != null) {
                        did.O00000o0("[Native record info] userId: %s", str7);
                        O000000o3.O0000o00 = str7;
                    }
                    str8 = map2.get("sysLog");
                    if (str8 != null) {
                        O000000o3.O0000oo = str8;
                    }
                    str9 = map2.get("appVersion");
                    if (str9 != null) {
                        did.O00000o0("[Native record info] appVersion: %s", str9);
                        O000000o3.O00000oo = str9;
                    }
                    str10 = map2.get("isAppForeground");
                    if (str10 != null) {
                        did.O00000o0("[Native record info] isAppForeground: %s", str10);
                        O000000o3.O000OOOo = str10.equalsIgnoreCase("true");
                    }
                    str11 = map2.get("launchTime");
                    if (str11 != null) {
                        did.O00000o0("[Native record info] launchTime: %s", str11);
                        O000000o3.O000OO = Long.parseLong(str11);
                    }
                    O000000o3.O0000ooo = null;
                    O000000o3.O0000OoO = true;
                    return O000000o3;
                }
            }
            str = str17;
            str2 = str20;
            String str232 = map2.get("nativeLog");
            if (str232 != null) {
            }
            str3 = map2.get("sendingProcess");
            if (str3 == null) {
            }
            num = O00000o0.get("spd");
            if (num != null) {
            }
            String str242 = str3;
            str4 = map2.get("threadName");
            if (str4 == null) {
            }
            num2 = O00000o0.get("et");
            if (num2 != null) {
            }
            String str252 = str4;
            str5 = map2.get("processName");
            if (str5 == null) {
            }
            num3 = O00000o0.get("ep");
            if (num3 != null) {
            }
            String str262 = str15;
            str6 = map2.get("key-value");
            if (str6 == null) {
            }
            CrashDetailBean O000000o32 = dhd.O000000o(str262, str252, (((long) O00000o0.get("etms").intValue()) / 1000) + (((long) O00000o0.get("ets").intValue()) * 1000), str2, str16, O00000o(str21), str, str242, str19, map2.get("sysLogPath"), str13, O000000o2, hashMap);
            str7 = map2.get("userId");
            if (str7 != null) {
            }
            str8 = map2.get("sysLog");
            if (str8 != null) {
            }
            str9 = map2.get("appVersion");
            if (str9 != null) {
            }
            str10 = map2.get("isAppForeground");
            if (str10 != null) {
            }
            str11 = map2.get("launchTime");
            if (str11 != null) {
            }
            O000000o32.O0000ooo = null;
            O000000o32.O0000OoO = true;
            return O000000o32;
        } catch (NumberFormatException e) {
            if (!did.O000000o(e)) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            did.O00000oO("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    private static String O000000o(BufferedInputStream bufferedInputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                return null;
            }
            if (read == 0) {
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x008c A[SYNTHETIC, Splitter:B:53:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0098 A[SYNTHETIC, Splitter:B:60:0x0098] */
    public static CrashDetailBean O000000o(Context context, String str, dhd dhd) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String O000000o2;
        if (context == null || str == null || dhd == null) {
            did.O00000oO("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                String O000000o3 = O000000o(bufferedInputStream);
                if (O000000o3 != null) {
                    if (O000000o3.equals("NATIVE_RQD_REPORT")) {
                        HashMap hashMap = new HashMap();
                        loop0:
                        while (true) {
                            str2 = null;
                            while (true) {
                                O000000o2 = O000000o(bufferedInputStream);
                                if (O000000o2 != null) {
                                    if (str2 != null) {
                                        break;
                                    }
                                    str2 = O000000o2;
                                } else {
                                    break loop0;
                                }
                            }
                            hashMap.put(str2, O000000o2);
                        }
                        if (str2 != null) {
                            did.O00000oO("record not pair! drop! %s", str2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        CrashDetailBean O000000o4 = O000000o(context, hashMap, dhd);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return O000000o4;
                    }
                }
                did.O00000oO("record read fail! %s", O000000o3);
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            bufferedInputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    private static String O00000Oo(String str, String str2) {
        BufferedReader O000000o2 = dif.O000000o(str, "reg_record.txt");
        if (O000000o2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = O000000o2.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    int i = 0;
                    int i2 = 18;
                    int i3 = 0;
                    while (true) {
                        String readLine2 = O000000o2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (i % 4 == 0) {
                            if (i > 0) {
                                sb.append("\n");
                            }
                            sb.append("  ");
                        } else {
                            if (readLine2.length() > 16) {
                                i2 = 28;
                            }
                            sb.append("                ".substring(0, i2 - i3));
                        }
                        i3 = readLine2.length();
                        sb.append(readLine2);
                        i++;
                    }
                    sb.append("\n");
                    String sb2 = sb.toString();
                    if (O000000o2 != null) {
                        try {
                            O000000o2.close();
                        } catch (Exception e) {
                            did.O000000o(e);
                        }
                    }
                    return sb2;
                }
            }
            if (O000000o2 != null) {
                try {
                    O000000o2.close();
                } catch (Exception e2) {
                    did.O000000o(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (O000000o2 != null) {
                try {
                    O000000o2.close();
                } catch (Exception e3) {
                    did.O000000o(e3);
                }
            }
            throw th;
        }
    }

    private static String O00000o0(String str, String str2) {
        BufferedReader O000000o2 = dif.O000000o(str, "map_record.txt");
        if (O000000o2 == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = O000000o2.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    while (true) {
                        String readLine2 = O000000o2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb.append("  ");
                        sb.append(readLine2);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    if (O000000o2 != null) {
                        try {
                            O000000o2.close();
                        } catch (Exception e) {
                            did.O000000o(e);
                        }
                    }
                    return sb2;
                }
            }
            if (O000000o2 != null) {
                try {
                    O000000o2.close();
                } catch (Exception e2) {
                    did.O000000o(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (O000000o2 != null) {
                try {
                    O000000o2.close();
                } catch (Exception e3) {
                    did.O000000o(e3);
                }
            }
            throw th;
        }
    }

    public static String O000000o(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String O00000Oo = O00000Oo(str, str2);
        if (O00000Oo != null && !O00000Oo.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(O00000Oo);
        }
        String O00000o0 = O00000o0(str, str2);
        if (O00000o0 != null && !O00000o0.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(O00000o0);
        }
        return sb.toString();
    }

    public static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void O00000Oo(String str) {
        if (str != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists() && file.canWrite()) {
                file.delete();
                did.O00000o0("delete record file %s", file.getAbsoluteFile());
            }
            File file2 = new File(str, "reg_record.txt");
            if (file2.exists() && file2.canWrite()) {
                file2.delete();
                did.O00000o0("delete record file %s", file2.getAbsoluteFile());
            }
            File file3 = new File(str, "map_record.txt");
            if (file3.exists() && file3.canWrite()) {
                file3.delete();
                did.O00000o0("delete record file %s", file3.getAbsoluteFile());
            }
            File file4 = new File(str, "backup_record.txt");
            if (file4.exists() && file4.canWrite()) {
                file4.delete();
                did.O00000o0("delete record file %s", file4.getAbsoluteFile());
            }
            String str2 = f14638O000000o;
            if (str2 != null) {
                File file5 = new File(str2);
                if (file5.exists() && file5.canWrite()) {
                    file5.delete();
                    did.O00000o0("delete record file %s", file5.getAbsoluteFile());
                }
            }
        }
    }

    public static String O000000o(String str, int i) {
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                f14638O000000o = str;
                did.O000000o("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                String O000000o2 = dif.O000000o(new File(str));
                return (O000000o2 == null || O000000o2.length() <= i) ? O000000o2 : O000000o2.substring(O000000o2.length() - i);
            }
        }
        return null;
    }
}
