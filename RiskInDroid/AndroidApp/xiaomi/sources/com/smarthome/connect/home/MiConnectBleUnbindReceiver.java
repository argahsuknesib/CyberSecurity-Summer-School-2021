package com.smarthome.connect.home;

import _m_j.dcp;
import _m_j.dct;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class MiConnectBleUnbindReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("mac");
        String stringExtra2 = intent.getStringExtra("combo_key");
        if (TextUtils.isEmpty(stringExtra2)) {
            dcp O000000o2 = dcp.O000000o();
            if (O000000o2.O00000oO != null) {
                O000000o2.O00000oO.O00000Oo(stringExtra);
                return;
            }
            dct.O00000oO("onDeleteDevice null");
            if (context != null && !TextUtils.isEmpty(stringExtra)) {
                O000000o2.O0000O0o.offer(stringExtra);
                O000000o2.O00000o();
                return;
            }
            return;
        }
        dcp O000000o3 = dcp.O000000o();
        dct.O00000oO("onDeleteDevice(context, mac, comboKey)");
        if (O000000o3.O00000oO != null) {
            O000000o3.O00000oO.O000000o(stringExtra, stringExtra2);
            return;
        }
        dct.O00000oO("onDeleteDevice null");
        if (context != null && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            O000000o3.O0000OOo.put(stringExtra, stringExtra2);
            O000000o3.O00000o();
        }
    }
}
