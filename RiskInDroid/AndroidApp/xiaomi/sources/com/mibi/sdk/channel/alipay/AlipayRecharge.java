package com.mibi.sdk.channel.alipay;

import _m_j.cez;
import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

public class AlipayRecharge implements Recharge {
    public boolean available(Context context) {
        return true;
    }

    public String getChannel() {
        return "ALIPAY";
    }

    public RechargeMethodParser getParser() {
        return new cez();
    }

    public Intent getEntryIntent(boolean z) {
        return new Intent("com.mibi.sdk.channel.alipay");
    }
}
