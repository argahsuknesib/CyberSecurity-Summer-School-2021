package com.smarthome.connect.home;

import _m_j.dcp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MiConnectPopReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("miui.intent.action.NEARBY_MIHOME_APPEAR".equals(action)) {
            dcp.O000000o().O00000o0(true);
        } else if ("miui.intent.action.NEARBY_MIHOME_DISAPPEAR".equals(action)) {
            dcp.O000000o().O00000o0(false);
        }
    }
}
