package com.xiaomi.mi_connect_service.util;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

public class DeviceUtil {
    public static final int CURRENT_DEVICE_TYPE = getCurrentDeviceType();
    public static final boolean IS_INTERNATIONAL_PHONE = isInternationalMiPhone();
    public static final boolean IS_INTERNATIONAL_TV = isInternationalMiTV();
    public static final boolean IS_TV_GO_ALWAYS_ON = isSupportTVGo();
    private static BluetoothManager mBluetoothManager;
    private static Class<?> sMiuiSettingSystem;

    public static int getCurrentDeviceType() {
        if (isMiTv()) {
            return 2;
        }
        return isXiaoAiTongXue() ? 4 : 1;
    }

    public static boolean isMiTv() {
        String systemProperty = PropertyUtils.getSystemProperty("ro.build.characteristics");
        LogUtil.d("DeviceUtil", "platform type property: ".concat(String.valueOf(systemProperty)), new Object[0]);
        if (systemProperty == null || (!systemProperty.contains("tv") && !systemProperty.contains("mbx"))) {
            return false;
        }
        return true;
    }

    public static boolean isXiaoAiTongXue() {
        String systemProperty = PropertyUtils.getSystemProperty("ro.product.brand");
        if (systemProperty != null) {
            return systemProperty.contains("XiaoAiTongXue") || systemProperty.contains("XiaoMi");
        }
        return false;
    }

    private static synchronized boolean isInternationalMiTV() {
        boolean z;
        synchronized (DeviceUtil.class) {
            String systemProperty = PropertyUtils.getSystemProperty("ro.mitv.product.overseas");
            String systemProperty2 = PropertyUtils.getSystemProperty("ro.boot.region");
            LogUtil.d("DeviceUtil", "is oversea: ".concat(String.valueOf(systemProperty)), new Object[0]);
            LogUtil.d("DeviceUtil", "region: ".concat(String.valueOf(systemProperty2)), new Object[0]);
            z = true;
            if (!TextUtils.equals(systemProperty, "true")) {
                if (TextUtils.equals(systemProperty, "false") || TextUtils.equals("", systemProperty2) || TextUtils.equals("cn", systemProperty2)) {
                    z = false;
                }
            }
            LogUtil.e("DeviceUtil", "is international: ".concat(String.valueOf(z)), new Object[0]);
        }
        return z;
    }

    private static String getMiPhoneName(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (sMiuiSettingSystem == null) {
            sMiuiSettingSystem = Class.forName("android.provider.MiuiSettings$System");
        }
        String str = (String) sMiuiSettingSystem.getMethod("getDeviceName", Context.class).invoke(sMiuiSettingSystem, context);
        LogUtil.v("DeviceUtil", "Get Phone name ".concat(String.valueOf(str)), new Object[0]);
        return str;
    }

    private static String getMiTVName(Context context) {
        if (IS_INTERNATIONAL_TV) {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        }
        return Settings.System.getString(context.getContentResolver(), "dk_device_name");
    }

    private static String getBluetoothName(Context context) {
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        }
        BluetoothManager bluetoothManager = mBluetoothManager;
        if (bluetoothManager == null || bluetoothManager.getAdapter() == null) {
            LogUtil.e("DeviceUtil", "BT No Supported, use default name", new Object[0]);
            return null;
        }
        String name = mBluetoothManager.getAdapter().getName();
        LogUtil.v("DeviceUtil", "Get Bt name ".concat(String.valueOf(name)), new Object[0]);
        return name;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c A[RETURN] */
    public static String getName(Context context) {
        String str;
        int i = CURRENT_DEVICE_TYPE;
        if (i == 1) {
            try {
                str = getMiPhoneName(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (str != null) {
            }
        } else if (i == 2) {
            str = getMiTVName(context);
            return str != null ? str : "unknown";
        }
        str = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth") ? getBluetoothName(context) : null;
        if (str != null) {
        }
    }

    public static boolean isMiPhone() {
        return !TextUtils.isEmpty(PropertyUtils.getSystemProperty("ro.miui.ui.version.code"));
    }

    private static boolean isInternationalMiPhone() {
        String systemProperty = PropertyUtils.getSystemProperty("ro.product.mod_device");
        if (systemProperty != null) {
            return systemProperty.contains("_global");
        }
        return false;
    }

    public static boolean isSupportTVGo() {
        if (CURRENT_DEVICE_TYPE == 2) {
            String systemProperty = PropertyUtils.getSystemProperty("wlan.miplay.p2pgo");
            String systemProperty2 = PropertyUtils.getSystemProperty("wlan.miplay.p2pgo.alwayson");
            LogUtil.e("DeviceUtil", "isSupportTVGo: " + systemProperty + ", " + systemProperty2, new Object[0]);
            if (systemProperty == null || !systemProperty.equals("1") || systemProperty2 == null || !systemProperty2.equals("1")) {
                return false;
            }
            return true;
        }
        return false;
    }
}
