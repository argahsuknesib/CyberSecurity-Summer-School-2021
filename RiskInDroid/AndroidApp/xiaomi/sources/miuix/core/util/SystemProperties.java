package miuix.core.util;

import androidx.annotation.Keep;

@Deprecated
@Keep
public class SystemProperties {
    private static Class classSystemProperties = null;
    private static boolean isSupportGet = false;
    private static boolean isSupportGetBoolean = false;
    private static boolean isSupportGetInt = false;
    private static boolean isSupportGetLong = false;
    private static boolean isSupportSet = false;

    static {
        try {
            classSystemProperties = Class.forName("android.os.SystemProperties");
        } catch (Exception unused) {
            classSystemProperties = null;
        }
        Class cls = classSystemProperties;
        if (cls != null) {
            boolean z = true;
            try {
                isSupportGet = cls.getMethod("get", new Class[]{String.class, String.class}) != null;
            } catch (Exception unused2) {
                isSupportGet = false;
            }
            try {
                isSupportGetInt = classSystemProperties.getMethod("getInt", new Class[]{String.class, Integer.TYPE}) != null;
            } catch (Exception unused3) {
                isSupportGetInt = false;
            }
            try {
                isSupportGetLong = classSystemProperties.getMethod("getLong", new Class[]{String.class, Long.TYPE}) != null;
            } catch (Exception unused4) {
                isSupportGetLong = false;
            }
            try {
                isSupportGetBoolean = classSystemProperties.getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}) != null;
            } catch (Exception unused5) {
                isSupportGetBoolean = false;
            }
            try {
                if (classSystemProperties.getMethod("set", String.class, String.class) == null) {
                    z = false;
                }
                isSupportSet = z;
            } catch (Exception unused6) {
                isSupportSet = false;
            }
        }
    }

    public static String get(String str, String str2) {
        return isSupportGet ? android.os.SystemProperties.get(str, str2) : str2;
    }

    public static String get(String str) {
        return get(str, "");
    }

    public static int getInt(String str, int i) {
        return isSupportGetInt ? android.os.SystemProperties.getInt(str, i) : i;
    }

    public static long getLong(String str, long j) {
        return isSupportGetLong ? android.os.SystemProperties.getLong(str, j) : j;
    }

    public static boolean getBoolean(String str, boolean z) {
        return isSupportGetBoolean ? android.os.SystemProperties.getBoolean(str, z) : z;
    }

    public static void set(String str, String str2) {
        if (!isSupportSet) {
            return;
        }
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        } else if (str2 == null || str2.length() <= 91) {
            android.os.SystemProperties.set(str, str2);
        } else {
            throw new IllegalArgumentException("val.length > 91");
        }
    }

    public static void set(String str, int i) {
        set(str, Integer.toString(i));
    }

    public static void set(String str, long j) {
        set(str, Long.toString(j));
    }

    public static void set(String str, boolean z) {
        set(str, Boolean.toString(z));
    }
}
