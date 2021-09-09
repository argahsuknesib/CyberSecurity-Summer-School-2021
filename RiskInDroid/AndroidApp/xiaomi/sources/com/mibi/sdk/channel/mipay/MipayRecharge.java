package com.mibi.sdk.channel.mipay;

import _m_j.cff;
import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

public class MipayRecharge implements Recharge {
    public boolean available(Context context) {
        return true;
    }

    public String getChannel() {
        return "MIPAY";
    }

    public RechargeMethodParser getParser() {
        return new cff();
    }

    public Intent getEntryIntent(boolean z) {
        return new Intent("com.mibi.sdk.channel.mipay");
    }
}
