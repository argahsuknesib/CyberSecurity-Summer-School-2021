package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import java.security.NoSuchAlgorithmException;

public final class hnb {
    public static String O000000o(Context context) {
        DhcpInfo dhcpInfo;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo()) == null) {
            return null;
        }
        return Formatter.formatIpAddress(dhcpInfo.gateway);
    }

    public static byte[] O000000o(String str, String str2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(str2.getBytes(), str.getBytes());
            return O000000o2.O000000o("router-auth".getBytes(), 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
