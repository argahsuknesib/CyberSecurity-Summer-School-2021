package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;
import java.util.TimeZone;
import org.json.JSONObject;

public final class grr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f18186O000000o;
    private static String O00000Oo;
    private static Object O00000o = new Object();
    private static volatile grr O00000o0;
    private static Boolean O00000oO = null;
    private static String O00000oo = null;

    public static String O0000O0o() {
        return "Android";
    }

    public static String O0000o0() {
        return "com.xiaomi.mihome";
    }

    public static String O0000o0O() {
        return "phone";
    }

    private grr() {
    }

    public static grr O000000o() {
        if (O00000o0 == null) {
            synchronized (O00000o) {
                if (O00000o0 == null) {
                    O00000o0 = new grr();
                }
            }
        }
        return O00000o0;
    }

    private static Class<?> O000000o(String str) throws ClassNotFoundException {
        Stack stack = new Stack();
        Class<?> cls = null;
        while (true) {
            if (str == null) {
                break;
            }
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException unused) {
            }
            if (cls != null) {
                while (!stack.isEmpty() && cls != null) {
                    Class<?>[] classes = cls.getClasses();
                    String str2 = (String) stack.pop();
                    Class<?> cls2 = null;
                    for (Class<?> cls3 : classes) {
                        if (cls3.getSimpleName().equals(str2)) {
                            cls2 = cls3;
                        }
                    }
                    cls = cls2;
                }
            } else {
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
                    str = null;
                } else {
                    stack.add(str.substring(lastIndexOf + 1));
                    str = str.substring(0, lastIndexOf);
                }
            }
        }
        if (cls != null) {
            return cls;
        }
        throw new ClassNotFoundException("failed to guess class: ".concat(String.valueOf(str)));
    }

    public static String O00000Oo() {
        return O00000Oo("ro.miui.ui.version.name");
    }

    public static String O00000o0() {
        return O00000Oo("ro.miui.ui.version.code");
    }

    private static String O00000Oo(String str) {
        Class<?> cls;
        try {
            cls = O000000o("android.os.SystemProperties");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return "";
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("get", String.class, String.class);
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(null, str, "");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return "";
    }

    public static boolean O00000o() {
        Method declaredMethod;
        try {
            Class<?> O000000o2 = O000000o("android.os.SystemProperties");
            if (!(O000000o2 == null || (declaredMethod = O000000o2.getDeclaredMethod("get", String.class, String.class)) == null)) {
                String str = (String) declaredMethod.invoke(null, "ro.miui.ui.version.name", "");
                if (TextUtils.isEmpty(str) || str.length() < 2 || Integer.valueOf(str.substring(1)).intValue() < 12) {
                    return false;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean O00000oO() {
        if (O00000oO == null) {
            Class<?> cls = null;
            try {
                cls = O000000o("miui.os.Build");
            } catch (ClassNotFoundException unused) {
            }
            if (cls != null) {
                O00000oO = Boolean.TRUE;
            } else {
                O00000oO = Boolean.FALSE;
            }
        }
        return O00000oO.booleanValue();
    }

    public static boolean O00000oo() {
        try {
            return O000000o("miui.os.Build").getDeclaredField("IS_TABLET").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String O000000o(Context context, boolean z) {
        return z ? grw.O00000Oo(gsa.O000000o(context)) : grw.O000000o(gsa.O000000o(context));
    }

    public static String O000000o(Context context) {
        return gsa.O000000o(context);
    }

    public static String O0000OOo() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String O0000Oo0() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "unknown";
    }

    public static String O0000Oo() {
        try {
            gss.O000000o(Build.MODEL);
            return Build.MODEL;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static String O0000OoO() {
        try {
            gss.O000000o(Build.BRAND);
            return Build.BRAND;
        } catch (Exception unused) {
            return "UnknownBrand";
        }
    }

    public static String O0000Ooo() {
        if (O00000oo == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("manu", Build.MANUFACTURER);
                jSONObject.put("hard", Build.HARDWARE);
            } catch (Exception unused) {
            }
            O00000oo = O0000Oo() + "|" + jSONObject.toString();
        }
        return O00000oo;
    }

    public static String O0000o00() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String O00000Oo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    public static int O00000o0(Context context) {
        if (f18186O000000o <= 0) {
            try {
                f18186O000000o = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                f18186O000000o = 0;
            }
        }
        return f18186O000000o;
    }

    public static String O00000o(Context context) {
        if (TextUtils.isEmpty(O00000Oo)) {
            try {
                O00000Oo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                O00000Oo = "";
            }
        }
        return O00000Oo;
    }

    public static String O00000oO(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (Exception unused) {
            return null;
        }
    }

    public static int O00000oo(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 8) {
                if (subtype != 12) {
                    if (subtype != 15) {
                        switch (subtype) {
                            case 1:
                            case 2:
                                return 12;
                            case 4:
                                return 11;
                        }
                    }
                }
                return 21;
            }
            return 23;
        }
        return 0;
    }

    public static String O0000o0o() {
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            char c = '+';
            if (rawOffset < 0) {
                c = '-';
                rawOffset = -rawOffset;
            }
            StringBuilder sb = new StringBuilder(9);
            sb.append("GMT");
            sb.append(c);
            O000000o(sb, rawOffset / 60);
            sb.append(':');
            O000000o(sb, rawOffset % 60);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String O0000o() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception unused) {
            return "";
        }
    }

    private static void O000000o(StringBuilder sb, int i) {
        String num = Integer.toString(i);
        for (int i2 = 0; i2 < 2 - num.length(); i2++) {
            sb.append('0');
        }
        sb.append(num);
    }
}
