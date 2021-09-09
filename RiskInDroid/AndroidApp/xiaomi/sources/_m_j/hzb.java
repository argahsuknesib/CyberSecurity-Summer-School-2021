package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class hzb {
    @SuppressLint({"MissingPermission"})
    public static InetAddress O000000o(Context context) {
        DhcpInfo dhcpInfo;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = true;
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            z = false;
        }
        if (z && (dhcpInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo()) != null) {
            int i = (dhcpInfo.netmask ^ -1) | (dhcpInfo.ipAddress & dhcpInfo.netmask);
            byte[] bArr = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
