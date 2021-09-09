package com.xiaomi.smarthome.operation.js_sdk.network;

import _m_j.fjz;
import _m_j.hlg;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.application.CommonApplication;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class NetWorkObserver {
    @SuppressLint({"CheckResult"})

    /* renamed from: O000000o  reason: collision with root package name */
    public fjz.O00000Oo f10521O000000o = new fjz.O00000Oo() {
        /* class com.xiaomi.smarthome.operation.js_sdk.network.NetWorkObserver.AnonymousClass1 */

        public final void O00000oO() {
            if (NetWorkObserver.this.O00000Oo != null) {
                NetWorkObserver.this.O00000Oo.onNetChanged(NetWorkObserver.O000000o());
            }
        }
    };
    public O000000o O00000Oo;

    public interface O000000o {
        void onNetChanged(hlg hlg);
    }

    enum NetworkType {
        NETWORK_WIFI("WiFi"),
        NETWORK_4G("4G"),
        NETWORK_2G("2G"),
        NETWORK_3G("3G"),
        NETWORK_UNKNOWN("UNKNOWN"),
        NETWORK_NO("NOTREACHABLE");
        
        public String desc;

        private NetworkType(String str) {
            this.desc = str;
        }
    }

    private static NetworkInfo O000000o(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static hlg O000000o() {
        NetworkType O00000Oo2 = O00000Oo(CommonApplication.getAppContext());
        NetworkInfo O000000o2 = O000000o(CommonApplication.getAppContext());
        boolean z = false;
        if (O00000Oo2 == NetworkType.NETWORK_NO) {
            return new hlg(false, O00000Oo2.desc);
        }
        if (O000000o2 != null && O000000o2.isConnected()) {
            z = true;
        }
        return new hlg(z, O00000Oo2.desc);
    }

    private static NetworkType O00000Oo(Context context) {
        NetworkType networkType = NetworkType.NETWORK_NO;
        NetworkInfo O000000o2 = O000000o(context);
        if (O000000o2 == null || !O000000o2.isAvailable()) {
            return networkType;
        }
        if (O000000o2.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (O000000o2.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (O000000o2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            default:
                String subtypeName = O000000o2.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return NetworkType.NETWORK_3G;
                }
                return NetworkType.NETWORK_UNKNOWN;
        }
    }

    public final void O000000o(O000000o o000000o) {
        this.O00000Oo = o000000o;
        if (this.O00000Oo != null) {
            fjz.O000000o().O000000o(this.f10521O000000o);
        }
    }
}
