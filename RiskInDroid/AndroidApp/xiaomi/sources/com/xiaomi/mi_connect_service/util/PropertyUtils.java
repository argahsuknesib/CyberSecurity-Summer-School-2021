package com.xiaomi.mi_connect_service.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyUtils {
    public static synchronized void setSystemProperty(String str, String str2) {
        synchronized (PropertyUtils.class) {
            if (str == null || str2 == null) {
                LogUtil.e("PropertyUtils", "setSystemProperty: parameter error!", new Object[0]);
                return;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName("android.os.SystemProperties");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (cls != null) {
                try {
                    ReflectUtil.callStaticObjectMethod(cls, "set", new Class[]{String.class, String.class}, str, str2);
                    return;
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                    return;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
        }
    }

    public static boolean hasProperty(String str) {
        return !TextUtils.isEmpty(getSystemProperty(str));
    }

    public static synchronized String getSystemProperty(String str) {
        String str2;
        Class<?> cls;
        synchronized (PropertyUtils.class) {
            str2 = null;
            if (str == null) {
                LogUtil.e("PropertyUtils", "getSystemProperty: parameter error!", new Object[0]);
                return null;
            }
            try {
                cls = Class.forName("android.os.SystemProperties");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                cls = null;
            }
            if (cls != null) {
                try {
                    str2 = ReflectUtil.callStaticObjectMethod(cls, "get", new Class[]{String.class}, str).toString();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return str2;
    }

    public static synchronized String getSystemProperty(String str, String str2) {
        synchronized (PropertyUtils.class) {
            String systemProperty = getSystemProperty(str);
            return TextUtils.isEmpty(systemProperty) ? str2 : systemProperty;
        }
    }

    public synchronized boolean SystemProperties_getBoolean(String str, boolean z) {
        Class<?> cls;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            LogUtil.e("PropertyUtils", "SystemProperties exception: ".concat(String.valueOf(e)), new Object[0]);
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            } catch (Exception e2) {
                LogUtil.e("PropertyUtils", "getMethod exception: ".concat(String.valueOf(e2)), new Object[0]);
            }
        }
        if (method != null) {
            try {
                return ((Boolean) method.invoke(this, str, Boolean.valueOf(z))).booleanValue();
            } catch (Exception e3) {
                LogUtil.e("PropertyUtils", "invoke exception: ".concat(String.valueOf(e3)), new Object[0]);
                return z;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC, Splitter:B:21:0x0044] */
    public synchronized String SystemProperties_get(String str) {
        Class<?> cls;
        Method method;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            LogUtil.e("PropertyUtils", "SystemProperties exception: ".concat(String.valueOf(e)), new Object[0]);
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("get", String.class);
            } catch (Exception e2) {
                LogUtil.e("PropertyUtils", "getMethod exception: ".concat(String.valueOf(e2)), new Object[0]);
            }
            if (method != null) {
                try {
                    return (String) method.invoke(this, str);
                } catch (Exception e3) {
                    LogUtil.e("PropertyUtils", "invoke exception: ".concat(String.valueOf(e3)), new Object[0]);
                    return null;
                }
            }
        }
        method = null;
        if (method != null) {
        }
    }

    public synchronized int SystemProperties_getInt(String str, int i) {
        Class<?> cls;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            LogUtil.e("PropertyUtils", "SystemProperties exception: ".concat(String.valueOf(e)), new Object[0]);
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getInt", String.class, Integer.TYPE);
            } catch (Exception e2) {
                LogUtil.e("PropertyUtils", "getMethod exception: ".concat(String.valueOf(e2)), new Object[0]);
            }
        }
        if (method != null) {
            try {
                return ((Integer) method.invoke(this, str, Integer.valueOf(i))).intValue();
            } catch (Exception e3) {
                LogUtil.e("PropertyUtils", "invoke exception: ".concat(String.valueOf(e3)), new Object[0]);
                return 0;
            }
        }
    }

    public static String toPrintString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Integer.toHexString(bArr[i] & 255));
            if (i < bArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static String getProductType() {
        return Build.PRODUCT;
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }

    public static String getMiuiRomVersion() {
        String systemProperty = getSystemProperty("ro.build.fingerprint");
        return systemProperty == null ? "" : systemProperty;
    }

    public static String getSdkVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getSdkAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isProvisioned(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("miconnect_config", 0);
        String str = "false";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("clause_agreed", str);
        }
        LogUtil.d("PropertyUtils", "is agreed: ".concat(String.valueOf(str)), new Object[0]);
        if (!TextUtils.equals(str, "true") && Settings.Secure.getInt(context.getContentResolver(), "device_provisioned", 0) == 0) {
            return false;
        }
        return true;
    }
}
