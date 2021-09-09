package com.xiaomi.smarthome.newui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConnectionObserver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f10115O000000o;

    public interface O000000o {
        void O00000Oo();
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f10115O000000o != null) {
            try {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                        this.f10115O000000o.O00000Oo();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
