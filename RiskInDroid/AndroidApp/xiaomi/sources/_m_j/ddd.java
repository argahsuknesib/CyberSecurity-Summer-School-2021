package _m_j;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.Iterator;

public final class ddd {
    public static String O000000o(Context context) {
        String ssid = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
        return ssid.substring(1, ssid.length() - 1);
    }

    public static boolean O00000Oo(Context context) {
        int i;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        String ssid = wifiManager.getConnectionInfo().getSSID();
        String substring = ssid.substring(1, ssid.length() - 1);
        Iterator<ScanResult> it = wifiManager.getScanResults().iterator();
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            }
            ScanResult next = it.next();
            if (next.SSID.equals(substring)) {
                i = next.frequency;
                break;
            }
        }
        if (i > 4900) {
            return true;
        }
        return false;
    }
}
