package com.xiaomi.passport;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.accountsdk.request.IPUtilExternal;
import java.util.Arrays;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class IPUtilExternalImpl implements IPUtilExternal {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f6182O000000o;

    public IPUtilExternalImpl(Context context) {
        if (context != null) {
            this.f6182O000000o = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public String getNetworkName() {
        String str;
        Context context = this.f6182O000000o;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        String str2 = null;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.getConnectionInfo() != null) {
                    str2 = wifiManager.getConnectionInfo().getSSID();
                }
                if (str2 != null && str2.matches("\".*\"")) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                return "W_".concat(String.valueOf(str2));
            } else if (type == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "CDMA_EVDO_0";
                        break;
                    case 6:
                        str = "CDMA_EVDO_A";
                        break;
                    case 7:
                        str = "CDMA_1xRTT";
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "iDEN";
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        str = "CDMA_EVDO_B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "CDMA_eHRPD";
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        str = "HSPAP";
                        break;
                    default:
                        str = "";
                        break;
                }
                return String.format("M_%s_%s", networkOperator, str);
            }
        }
        return null;
    }

    public boolean isWifi() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f6182O000000o.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public void saveCachedIp(String str, String str2, String str3) {
        O000000o().edit().putString(O000000o("cached_ip", str, str2), str3).commit();
    }

    public String loadCachedIp(String str, String str2, String str3) {
        return O000000o().getString(O000000o("cached_ip", str, str2), str3);
    }

    public void saveBackupIpList(String str, String str2, List<String> list) {
        String str3;
        SharedPreferences.Editor edit = O000000o().edit();
        String O000000o2 = O000000o("backup_ip_list", str, str2);
        if (list == null || list.isEmpty()) {
            str3 = null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String next : list) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(next);
            }
            str3 = sb.toString();
        }
        edit.putString(O000000o2, str3).commit();
    }

    public List<String> loadBackupIpList(String str, String str2, List<String> list) {
        SharedPreferences O000000o2 = O000000o();
        String O000000o3 = O000000o("backup_ip_list", str, str2);
        List<String> list2 = null;
        String string = O000000o2.getString(O000000o3, null);
        if (string != null) {
            list2 = Arrays.asList(string.split(","));
        }
        return list2 != null ? list2 : list;
    }

    public void saveCachedTimeStamp(String str, String str2, long j) {
        O000000o(O000000o("cached_ip_timestamp", str, str2), j);
    }

    public long loadCachedTimeStamp(String str, String str2, long j) {
        return O00000Oo(O000000o("cached_ip_timestamp", str, str2), j);
    }

    public void saveBackupTimeStamp(String str, String str2, long j) {
        O000000o(O000000o("backup_ip_list_timestamp", str, str2), j);
    }

    public long loadBackupTimeStamp(String str, String str2, long j) {
        return O00000Oo(O000000o("backup_ip_list_timestamp", str, str2), j);
    }

    public void saveCachedIpExpireDuration(long j) {
        O000000o("cached_ip_expire", j);
    }

    public long loadCachedIpExpireDuration(long j) {
        return O00000Oo("cached_ip_expire", j);
    }

    public void saveBackupIpListExpireDuration(long j) {
        O000000o("backup_ip_list_expire", j);
    }

    public long loadBackupIpListExpireDuration(long j) {
        return O00000Oo("backup_ip_list_expire", j);
    }

    public void savePingThreshold(long j) {
        O000000o("ping_threshold", j);
    }

    public long loadPingThreshold(long j) {
        return O00000Oo("ping_threshold", j);
    }

    public void savePingTimeCoefficient(long j) {
        O000000o("ping_time_coefficient", j);
    }

    public long loadPingTimeCoefficient(long j) {
        return O00000Oo("ping_time_coefficient", j);
    }

    private void O000000o(String str, long j) {
        O000000o().edit().putLong(str, j).commit();
    }

    private long O00000Oo(String str, long j) {
        return O000000o().getLong(str, j);
    }

    private SharedPreferences O000000o() {
        return this.f6182O000000o.getSharedPreferences("ip", 0);
    }

    private static String O000000o(String str, String str2, String str3) {
        return String.format("%s#%s#%s", str, str2, str3);
    }
}
