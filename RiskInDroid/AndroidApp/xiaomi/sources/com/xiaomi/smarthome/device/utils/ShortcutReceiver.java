package com.xiaomi.smarthome.device.utils;

import _m_j.gsy;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public class ShortcutReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        gsy.O000000o(4, "ShortcutReceiver", "action:" + action + intent.getExtras());
        izb.O000000o(CommonApplication.getAppContext(), (int) R.string.smarthome_add_short_cut_success, 0).show();
    }
}
