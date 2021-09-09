package com.miui.tsmclient.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.miui.tsmclient.common.net.host.AssetsHost;
import com.miui.tsmclient.net.AuthRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public final class NetworkUtil {
    public static String getHtml(String str) {
        if (AuthRequest.STAGING) {
            return "http://staging.sf.pay.xiaomi.com/".concat(String.valueOf(str));
        }
        return "https://sf.pay.xiaomi.com/".concat(String.valueOf(str));
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (Build.VERSION.SDK_INT < 16) {
            if (!z || activeNetworkInfo.getType() != 1) {
                return false;
            }
        } else if (!z || connectivityManager.isActiveNetworkMetered()) {
            return false;
        }
        return true;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    public static boolean isNetworkMetered(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.isActiveNetworkMetered();
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            LogUtils.e("WifiPreference IpAddress", e);
            return null;
        }
    }

    public static String getTransCardHelpUrl(String str) {
        return AuthRequest.AuthRequestBuilder.newBuilder(null, new AssetsHost(), String.format("views/commonQuestion/help_%1$s/", str.toLowerCase()), null).create().getRequestFullUrl();
    }

    public static String getTransferProtocolUrl(String str) {
        return AuthRequest.AuthRequestBuilder.newBuilder(null, new AssetsHost(), String.format("views/transferCardProtocol/%1$s.html", str.toLowerCase()), null).create().getRequestFullUrl();
    }

    public static String getCommonHelpUrl() {
        return AuthRequest.AuthRequestBuilder.newBuilder(null, new AssetsHost(), "views/commonQuestion/common_help/index.html", null).create().getRequestFullUrl();
    }
}
