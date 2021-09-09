package _m_j;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;

public final class gkl {
    public static String O000000o(Context context) {
        DhcpInfo dhcpInfo;
        if (context == null || (dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo()) == null) {
            return "";
        }
        return O000000o((long) dhcpInfo.gateway);
    }

    private static String O000000o(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }
}
