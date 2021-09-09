package com.mi.mistatistic.sdk.receiver;

import _m_j.ccv;
import _m_j.ccx;
import _m_j.cde;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MiReferrerTrackingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) && stringExtra != null) {
            ccv.O000000o("referrer", stringExtra, null, null);
            cde.O00000Oo(ccx.O000000o(), "installFrom", stringExtra);
        }
    }
}
