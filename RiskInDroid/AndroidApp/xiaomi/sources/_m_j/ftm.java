package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public final class ftm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17102O000000o = "";

    private static void O0000OOo(Context context) {
        if (context != null && TextUtils.isEmpty(f17102O000000o)) {
            String O000000o2 = O000000o(context, Process.myPid());
            f17102O000000o = O000000o2;
            if (O000000o2 == null) {
                f17102O000000o = "";
            }
            gsy.O000000o(4, "ProcessUtil", f17102O000000o);
        }
    }

    public static String O000000o(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        String O000000o2 = O000000o(i);
        gsy.O000000o(4, "ProcessUtil", "getProcessName /prop:".concat(String.valueOf(O000000o2)));
        if (TextUtils.isEmpty(O000000o2) && (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == i) {
                    O000000o2 = next.processName;
                    break;
                }
            }
        }
        gsy.O000000o(4, "ProcessUtil", "getProcessName getRunningAppProcesses:".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC, Splitter:B:24:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[SYNTHETIC, Splitter:B:29:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private static String O000000o(int i) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline"), StandardCharsets.ISO_8859_1));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return sb2;
            } catch (Exception e2) {
                e = e2;
                bufferedReader = bufferedReader2;
                try {
                    Log.e("ProcessUtil", "/prop", e);
                    if (bufferedReader != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            Log.e("ProcessUtil", "/prop", e);
            if (bufferedReader != null) {
                return "";
            }
            try {
                bufferedReader.close();
                return "";
            } catch (IOException e5) {
                e5.printStackTrace();
                return "";
            }
        }
    }

    public static boolean O000000o(Context context) {
        O0000OOo(context);
        return "com.xiaomi.smarthome".equals(f17102O000000o);
    }

    public static boolean O00000Oo(Context context) {
        O0000OOo(context);
        return f17102O000000o.startsWith("com.xiaomi.smarthome:plugin");
    }

    public static String O00000o0(Context context) {
        O0000OOo(context);
        return f17102O000000o;
    }

    public static boolean O00000o(Context context) {
        O0000OOo(context);
        return f17102O000000o.equalsIgnoreCase(context.getPackageName());
    }

    public static boolean O00000oO(Context context) {
        O0000OOo(context);
        return f17102O000000o.endsWith(":core");
    }

    public static boolean O00000oo(Context context) {
        O0000OOo(context);
        return f17102O000000o.endsWith(":plugin0") || f17102O000000o.endsWith(":plugin1") || f17102O000000o.endsWith(":plugin2") || f17102O000000o.endsWith(":plugin3") || f17102O000000o.endsWith(":camera");
    }

    public static boolean O0000O0o(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if ((next.processName.equals("com.xiaomi.smarthome") || next.processName.startsWith("com.xiaomi.smarthome:")) && (next.importance == 100 || next.importance == 200)) {
                return true;
            }
        }
        return false;
    }
}
