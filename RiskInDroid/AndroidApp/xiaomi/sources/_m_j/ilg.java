package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class ilg {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Object[] f1437O000000o = new Object[0];
    static final Class<?>[] O00000Oo = new Class[0];
    private static char O00000o = 0;
    public static String O00000o0;

    public static int O000000o(String str) throws IllegalArgumentException {
        String str2 = str;
        if (!TextUtils.isEmpty(str) && str2.contains("-") && str2.contains(":")) {
            String[] split = str2.split("-");
            boolean z = split[0].split(":").length == 2;
            boolean z2 = split[0].split(":").length == 3;
            boolean z3 = split[0].split(":").length == 5;
            SimpleDateFormat simpleDateFormat = null;
            if (z2) {
                simpleDateFormat = new SimpleDateFormat("dd:HH:mm", Locale.getDefault());
            } else if (z3) {
                simpleDateFormat = new SimpleDateFormat("yy:MM:dd:HH:mm", Locale.getDefault());
            } else if (z) {
                simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            }
            if (simpleDateFormat == null) {
                return -2;
            }
            try {
                long time = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime();
                long time2 = simpleDateFormat.parse(split[0]).getTime();
                if (split[1].contains("00:00") && z2) {
                    split[1] = split[1].split(":")[0] + ":23:59";
                } else if (split[1].contains("00:00") && z3) {
                    split[1] = split[1].split(":")[0] + ":" + split[1].split(":")[1] + ":" + split[1].split(":")[2] + ":23:59";
                } else if (split[1].contains("00:00") && z) {
                    split[1] = "23:59";
                }
                long time3 = simpleDateFormat.parse(split[1]).getTime();
                if (time >= time3) {
                    return -1;
                }
                if (time < time2 || time >= time3) {
                    return 1;
                }
                return 0;
            } catch (ParseException e) {
                e.printStackTrace();
                if (!iio.f1319O000000o) {
                    return -2;
                }
                throw new IllegalArgumentException("Illegal Argument arg:".concat(String.valueOf(str)));
            }
        } else if (!iio.f1319O000000o) {
            return -2;
        } else {
            throw new IllegalArgumentException("Illegal Argument arg:".concat(String.valueOf(str)));
        }
    }

    private static String O00000Oo(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(O00000o0)) {
            return O00000o0;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    O00000o0 = next.processName;
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(O00000o0)) {
            O00000o0 = O00000Oo();
        }
        if (TextUtils.isEmpty(O00000o0)) {
            O00000o0 = context.getPackageName();
        }
        return O00000o0;
    }

    private static String O00000Oo() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Class<?>[] O000000o(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return O00000Oo;
        }
        return clsArr;
    }

    public static Object[] O000000o(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return f1437O000000o;
        }
        return objArr;
    }

    public static boolean O000000o(Context context) {
        if (O000000o()) {
            String O00000Oo2 = O00000Oo(context);
            return !TextUtils.isEmpty(O00000Oo2) && O00000Oo2.equals("com.ximalaya.ting.android");
        }
        String O00000Oo3 = O00000Oo(context);
        return !TextUtils.isEmpty(O00000Oo3) && O00000Oo3.equals(context.getPackageName());
    }

    public static boolean O000000o(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o() {
        if (O00000o == 0) {
            try {
                Class.forName("com.ximalaya.ting.android.host.manager.request.CommonRequestM");
                O00000o = 1;
            } catch (ClassNotFoundException unused) {
                O00000o = 2;
            } catch (Exception unused2) {
                O00000o = 2;
            }
        }
        char c = O00000o;
        if (c != 1 && c == 2) {
            return false;
        }
        return true;
    }
}
