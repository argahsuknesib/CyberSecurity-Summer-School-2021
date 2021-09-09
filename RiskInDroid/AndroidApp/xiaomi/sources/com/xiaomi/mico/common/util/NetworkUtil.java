package com.xiaomi.mico.common.util;

import _m_j.jdn;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtil {
    private static int getTelephonyNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return 3;
            case 13:
                return 4;
            default:
                return 1;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static void gotoNetworkSetting(Context context) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void gotoWifiSetting(Context context) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static boolean downloadFile(String str, File file) {
        Response response;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            response = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            try {
                bufferedInputStream = new BufferedInputStream(response.body().byteStream());
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
                try {
                    e.printStackTrace();
                    IOUtils.closeQuietly(bufferedInputStream2);
                    IOUtils.closeQuietly(fileOutputStream);
                    if (response == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(bufferedInputStream2);
                    IOUtils.closeQuietly(fileOutputStream);
                    if (!(response == null || response.body() == null)) {
                        response.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                IOUtils.closeQuietly(bufferedInputStream2);
                IOUtils.closeQuietly(fileOutputStream);
                response.close();
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    IOUtils.copy(bufferedInputStream, fileOutputStream);
                    IOUtils.closeQuietly(bufferedInputStream);
                    IOUtils.closeQuietly(fileOutputStream);
                    if (response == null || response.body() == null) {
                        return true;
                    }
                    response.close();
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    IOUtils.closeQuietly(bufferedInputStream2);
                    IOUtils.closeQuietly(fileOutputStream);
                    if (response == null && response.body() != null) {
                        response.close();
                        return false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    IOUtils.closeQuietly(bufferedInputStream2);
                    IOUtils.closeQuietly(fileOutputStream);
                    response.close();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                e.printStackTrace();
                IOUtils.closeQuietly(bufferedInputStream2);
                IOUtils.closeQuietly(fileOutputStream);
                if (response == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                IOUtils.closeQuietly(bufferedInputStream2);
                IOUtils.closeQuietly(fileOutputStream);
                response.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            response = null;
            fileOutputStream = null;
            e.printStackTrace();
            IOUtils.closeQuietly(bufferedInputStream2);
            IOUtils.closeQuietly(fileOutputStream);
            return response == null ? false : false;
        } catch (Throwable th5) {
            th = th5;
            response = null;
            fileOutputStream = null;
            IOUtils.closeQuietly(bufferedInputStream2);
            IOUtils.closeQuietly(fileOutputStream);
            response.close();
            throw th;
        }
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return -1;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            return type != 1 ? 5 : 0;
        }
        return getTelephonyNetworkClass(networkInfo.getSubtype());
    }

    public static int getActiveNetworkType(Context context) {
        return getNetworkType(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
    }

    public static int getTelephonyNetworkClass(Context context) {
        return getTelephonyNetworkClass(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
    }

    public static String getBSSID(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo != null) {
            return wifiInfo.getBSSID();
        }
        return null;
    }

    public static String getSSID(Context context) {
        WifiInfo wifiInfo;
        String ssid;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null || (ssid = wifiInfo.getSSID()) == null) {
            return null;
        }
        return (ssid.length() < 3 || !ssid.startsWith(jdn.f1779O000000o) || !ssid.endsWith(jdn.f1779O000000o)) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public static String getIpAddr(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo.isConnected()) {
            return getLocalIpAddress();
        }
        if (networkInfo2.isConnected()) {
            return intToIp(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        }
        return null;
    }

    public static String getLocalIpAddress() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (isIPv4Address(hostAddress)) {
                                return hostAddress;
                            }
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isIPv4Address(String str) {
        if (str.contains(":") || !str.contains(".") || str.split("\\.").length != 4) {
            return false;
        }
        return true;
    }

    public static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }
}
