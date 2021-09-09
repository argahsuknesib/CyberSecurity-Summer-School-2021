package com.mibi.sdk.channel.wxpay;

import _m_j.cfi;
import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

public class WXRecharge implements Recharge {
    public boolean available(Context context) {
        return true;
    }

    public String getChannel() {
        return "WXPAY";
    }

    public RechargeMethodParser getParser() {
        return new cfi();
    }

    public Intent getEntryIntent(boolean z) {
        return new Intent("com.mibi.sdk.channel.wxpay");
    }
}
