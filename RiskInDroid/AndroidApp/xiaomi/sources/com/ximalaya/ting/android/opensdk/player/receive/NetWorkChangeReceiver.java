package com.ximalaya.ting.android.opensdk.player.receive;

import _m_j.ilk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Parcelable;
import com.ximalaya.ting.android.opensdk.util.NetworkType;

public class NetWorkChangeReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f12186O000000o = false;

    public void onReceive(Context context, Intent intent) {
        Parcelable parcelableExtra;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (NetworkType.O00000Oo(context)) {
                if (!f12186O000000o) {
                    ilk.O00000Oo("SNetWorkChangeReceiver", "startTrafficStatistic");
                }
                ilk.O00000o0("SNetWorkChangeReceiver", "connect to mobile");
                f12186O000000o = true;
            } else {
                if (NetworkType.O000000o(context) == NetworkType.NetWorkType.NETWORKTYPE_WIFI) {
                    if (f12186O000000o) {
                        ilk.O00000Oo("SNetWorkChangeReceiver", "endTrafficStatistic");
                    }
                    ilk.O00000o0("SNetWorkChangeReceiver", "connect to wifi");
                    f12186O000000o = false;
                }
            }
        }
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
            NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
            if ((networkInfo.getState() == NetworkInfo.State.CONNECTED) && networkInfo.getType() == 1) {
                if (f12186O000000o) {
                    ilk.O00000Oo("SNetWorkChangeReceiver", "endTrafficStatistic");
                }
                ilk.O00000o0("SNetWorkChangeReceiver", "connect to wifi");
                f12186O000000o = false;
            }
        }
    }
}
