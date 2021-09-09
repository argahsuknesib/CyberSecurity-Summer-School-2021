package com.xiaomi.mico.common.util;

import _m_j.ahh;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public class SystemUtil {
    private static Method GET_PROP_METHOD;
    private static OS ROM_OS = OS.OTHERS;

    public enum OS {
        XIAOMI_MIUI,
        HUAWEI_EMUI,
        MEIZU_FLYME,
        OPPO_OPPO,
        VIVO_VIVO,
        OTHERS
    }

    static {
        GET_PROP_METHOD = null;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            GET_PROP_METHOD = declaredMethod;
        } catch (Exception unused) {
        }
        loadSystemProps();
    }

    private static void loadSystemProps() {
        try {
            if (getProperty("ro.miui.ui.version.code", null) == null && getProperty("ro.miui.ui.version.name", null) == null) {
                if (getProperty("ro.miui.internal.storage", null) == null) {
                    if (getProperty("ro.build.hw_emui_api_level", null) == null && getProperty("ro.build.version.emui", null) == null) {
                        if (getProperty("ro.confg.hw_systemversion", null) == null) {
                            if (Build.DISPLAY.toUpperCase().contains("FLYME")) {
                                ROM_OS = OS.MEIZU_FLYME;
                                return;
                            } else if (getProperty("ro.build.version.opporom", null) != null) {
                                ROM_OS = OS.OPPO_OPPO;
                                return;
                            } else if (getProperty("ro.vivo.os.version", null) != null) {
                                ROM_OS = OS.VIVO_VIVO;
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    ROM_OS = OS.HUAWEI_EMUI;
                    return;
                }
            }
            ROM_OS = OS.XIAOMI_MIUI;
        } catch (Exception e) {
            ahh.O000000o(e);
        }
    }

    private static String getProperty(String str, String str2) {
        Method method = GET_PROP_METHOD;
        if (method == null) {
            return null;
        }
        try {
            String str3 = (String) method.invoke(null, str);
            if ("unknown".equals(str3)) {
                return null;
            }
            return str3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static OS getRomOs() {
        return ROM_OS;
    }

    public static boolean isMiui() {
        return getRomOs() == OS.XIAOMI_MIUI;
    }

    public static boolean isMeiZu() {
        return getRomOs() == OS.MEIZU_FLYME;
    }

    public static boolean isV6OrLater() {
        if (isMiui()) {
            try {
                if (Integer.parseInt(getProperty("ro.miui.ui.version.name", null).substring(1)) >= 6) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 16384);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstalled(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 16384) != null;
        } catch (PackageManager.NameNotFoundException e) {
            new Object[1][0] = "cannot find package".concat(String.valueOf(e));
        }
    }
}
