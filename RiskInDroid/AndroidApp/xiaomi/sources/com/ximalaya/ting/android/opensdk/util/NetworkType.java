package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class NetworkType {
    private static boolean O00000o(Context context) {
        int i;
        try {
            i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception unused) {
            i = 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
            case 6:
                return true;
            case 7:
                return false;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
                return true;
            case 11:
                return false;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return true;
            default:
                return false;
        }
    }

    public static NetWorkType O000000o(Context context) {
        NetWorkType netWorkType;
        if (context == null) {
            return NetWorkType.NETWORKTYPE_INVALID;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        NetWorkType netWorkType2 = NetWorkType.NETWORKTYPE_INVALID;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return NetWorkType.NETWORKTYPE_INVALID;
        }
        String typeName = networkInfo.getTypeName();
        if (typeName.equalsIgnoreCase("WIFI")) {
            netWorkType = NetWorkType.NETWORKTYPE_WIFI;
        } else if (!typeName.equalsIgnoreCase("MOBILE")) {
            return netWorkType2;
        } else {
            netWorkType = TextUtils.isEmpty(Proxy.getDefaultHost()) ? O00000o(context) ? NetWorkType.NETWORKTYPE_3G : NetWorkType.NETWORKTYPE_2G : NetWorkType.NETWORKTYPE_WAP;
        }
        return netWorkType;
    }

    public enum NetWorkType {
        NETWORKTYPE_INVALID("no_network", 1),
        NETWORKTYPE_WAP("wap", 2),
        NETWORKTYPE_2G("2g", 3),
        NETWORKTYPE_3G("3g", 4),
        NETWORKTYPE_WIFI("wifi", 5);
        
        private int index;
        private String name;

        private NetWorkType(String str, int i) {
            this.name = str;
            this.index = i;
        }

        public static String getName(int i) {
            for (NetWorkType netWorkType : values()) {
                if (netWorkType.getIndex() == i) {
                    return netWorkType.name;
                }
            }
            return null;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static boolean O00000Oo(Context context) {
        NetWorkType O000000o2 = O000000o(context);
        return O000000o2 == NetWorkType.NETWORKTYPE_WAP || O000000o2 == NetWorkType.NETWORKTYPE_2G || O000000o2 == NetWorkType.NETWORKTYPE_3G;
    }

    public static int O00000o0(Context context) {
        if (context == null) {
            return 3;
        }
        String str = null;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception unused) {
        }
        if (str == null) {
            return 3;
        }
        if (str.equals("46000") || str.equals("46002") || str.equals("46007") || str.equals("46020")) {
            return 0;
        }
        if (str.equals("46001") || str.equals("46006") || str.equals("46009")) {
            return 1;
        }
        if (str.equals("46003") || str.equals("46005") || str.equals("46011")) {
            return 2;
        }
        return 3;
    }
}
