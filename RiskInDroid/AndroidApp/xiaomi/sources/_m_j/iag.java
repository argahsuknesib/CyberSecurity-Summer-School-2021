package _m_j;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class iag extends BaseWifiSettingUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1088O000000o = false;
    private static boolean O00000Oo = false;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ScanResult f1089O000000o;
        public boolean O00000Oo;
        public String O00000o;
        public boolean O00000o0;
        public String O00000oO;
    }

    public static int O000000o(int i) {
        return i > 80 ? R.drawable.wifi_strength_4 : i > 60 ? R.drawable.wifi_strength_3 : i > 40 ? R.drawable.wifi_strength_2 : i > 20 ? R.drawable.wifi_strength_1 : R.drawable.wifi_strength_0;
    }

    public static int O00000Oo(int i) {
        if (i <= -100) {
            return 0;
        }
        if (i >= -55) {
            return 100;
        }
        return (int) ((((float) (i - -100)) * 100.0f) / 45.0f);
    }

    public static boolean O000000o() {
        if (Build.VERSION.SDK_INT >= 21) {
            for (String equals : Build.SUPPORTED_ABIS) {
                if (equals.equals("x86_64")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String O000000o(Context context, O000000o o000000o) {
        BaseWifiSettingUtils.PskType pskType;
        int O00000Oo2 = O00000Oo(o000000o.f1089O000000o);
        String str = "";
        if (o000000o.O00000Oo && O00000Oo2 != 0) {
            str = str + context.getString(R.string.kuailian_save_passwd) + "，";
        }
        if (O00000Oo2 == 0) {
            return str + context.getString(R.string.kuailian_no_passwd);
        } else if (O00000Oo2 == 2) {
            ScanResult scanResult = o000000o.f1089O000000o;
            boolean contains = scanResult.capabilities.contains("WPA-PSK");
            boolean contains2 = scanResult.capabilities.contains("WPA2-PSK");
            if (contains2 && contains) {
                pskType = BaseWifiSettingUtils.PskType.WPA_WPA2;
            } else if (contains2) {
                pskType = BaseWifiSettingUtils.PskType.WPA2;
            } else if (contains) {
                pskType = BaseWifiSettingUtils.PskType.WPA;
            } else {
                pskType = BaseWifiSettingUtils.PskType.UNKNOWN;
            }
            if (pskType == BaseWifiSettingUtils.PskType.WPA) {
                return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "WPA");
            } else if (pskType == BaseWifiSettingUtils.PskType.WPA2) {
                return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "WPA2");
            } else if (pskType != BaseWifiSettingUtils.PskType.WPA_WPA2) {
                return str;
            } else {
                return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "WPA_WPA2");
            }
        } else if (O00000Oo2 == 1) {
            return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "WEP");
        } else if (O00000Oo2 == 3) {
            return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "802.1X");
        } else if (O00000Oo2 != 4) {
            return str;
        } else {
            return str + String.format(context.getString(R.string.kuailian_wifi_security_type), "WAPI");
        }
    }

    public static boolean O00000o0(ScanResult scanResult) {
        try {
            Field declaredField = Class.forName(ScanResult.class.getName()).getDeclaredField("isXiaomiRouter");
            if (declaredField != null) {
                return declaredField.getBoolean(scanResult);
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return false;
        }
    }

    public static boolean O00000o0(String str) {
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            if ((b & 128) != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(WifiManager wifiManager, String str) {
        WifiConfiguration wifiConfiguration;
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return false;
        }
        Iterator<WifiConfiguration> it = configuredNetworks.iterator();
        while (true) {
            if (!it.hasNext()) {
                wifiConfiguration = null;
                break;
            }
            wifiConfiguration = it.next();
            if (O000000o(wifiConfiguration.SSID, str)) {
                break;
            }
        }
        if (wifiConfiguration != null) {
            return true;
        }
        return false;
    }
}
