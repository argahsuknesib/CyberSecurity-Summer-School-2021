package com.tiqiaa.icontrol.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class PhoneHelper {
    private static String IMEI;
    static ConnectivityManager connectivity;
    private static Vibrator vibrator;

    public static String getPhoneIMEI(Context context) {
        if (IMEI == null) {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            IMEI = deviceId;
            if (deviceId == null || IMEI.equals("") || isSpecialImei(IMEI)) {
                String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (macAddress == null || macAddress.equals("")) {
                    macAddress = "device_havnt_imei_or_mac_address";
                }
                IMEI = macAddress;
            }
        }
        return IMEI;
    }

    public static boolean isSpecialImei(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.equals("") || trim.length() < 2) {
            return true;
        }
        char[] charArray = trim.toCharArray();
        char c = charArray[0];
        for (char c2 : charArray) {
            if (c != c2) {
                return false;
            }
        }
        return true;
    }

    public static String getDevice() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    public static void vibrate(Context context) {
        vibrate(context, 50);
    }

    public static void vibrate(Context context, long j) {
        if (vibrator == null) {
            vibrator = (Vibrator) context.getSystemService("vibrator");
        }
        vibrator.vibrate(j);
    }

    public static int getSystemSDKVer() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean checkNet() {
        boolean z;
        NetworkInfo activeNetworkInfo;
        LogUtil.d("PhoneHelper", "checkNet.....检查网络连接......start");
        Date date = new Date();
        if (connectivity == null) {
            connectivity = (ConnectivityManager) TiqiaaService.getAppContext().getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = connectivity;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            z = false;
        } else {
            z = activeNetworkInfo.isAvailable();
        }
        LogUtil.w("PhoneHelper", "checkNet.....检查网络连接......end...netOk = " + z + " , usedTime = " + (new Date().getTime() - date.getTime()));
        return z;
    }

    public static void openWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
    }

    public static void closeWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }

    public static void sestMobileNetEnable(Context context, boolean z) {
        toggleMobileData(context, z);
    }

    static class GsmHelper {
        private Context context;

        public GsmHelper(Context context2) {
            this.context = context2;
        }

        public final boolean setMobileNetEnable(boolean z) {
            this.context.getSystemService("connectivity");
            try {
                boolean invokeMethod = invokeMethod("getMobileDataEnabled", null);
                LogUtil.w("GsmHelper", "setMobileNetEnable.......enable = " + z + ",isMobileDataEnable = " + invokeMethod);
                if (!invokeMethod || !(!z)) {
                    return true;
                }
                LogUtil.w("GsmHelper", "setMobileNetEnable....#######...尝试打开移动网络");
                Object invokeBooleanArgMethod = invokeBooleanArgMethod("setMobileDataEnabled", z);
                if (invokeBooleanArgMethod == null || !(invokeBooleanArgMethod instanceof Boolean)) {
                    return false;
                }
                return ((Boolean) invokeBooleanArgMethod).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean invokeMethod(String str, Object[] objArr) throws Exception {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            return ((Boolean) connectivityManager.getClass().getMethod(str, objArr != null ? new Class[]{objArr.getClass()} : null).invoke(connectivityManager, objArr)).booleanValue();
        }

        public Object invokeBooleanArgMethod(String str, boolean z) throws Exception {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            return connectivityManager.getClass().getMethod(str, Boolean.TYPE).invoke(connectivityManager, Boolean.valueOf(z));
        }
    }

    private static void toggleMobileData(Context context, boolean z) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Field declaredField = Class.forName(connectivityManager.getClass().getName()).getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(connectivityManager);
            Method declaredMethod = Class.forName(obj.getClass().getName()).getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, Boolean.valueOf(z));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
    }

    public static int getAppVersion(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(getPackageName(context), 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo.versionCode;
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }
}
