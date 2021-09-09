package com.mibi.sdk.payment;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeManager;

class ChannelManager {
    private static final String[] ENTRYS = {"com.mibi.sdk.channel.mipay.MipayRecharge", "com.mibi.sdk.channel.alipay.AlipayRecharge", "com.mibi.sdk.channel.wxpay.WXRecharge", "com.mibi.sdk.channel.unionpay.UnionPayRecharge", "com.mibi.sdk.channel.unionpay.UnionMiPayRecharge"};

    ChannelManager() {
    }

    static void registerRechargeChannels(Context context) {
        for (String tryAddEntry : ENTRYS) {
            tryAddEntry(tryAddEntry);
        }
        tryInitUnionMiPay(context);
    }

    private static void tryInitUnionMiPay(Context context) {
        if (RechargeManager.get().getRecharge("UNIONMIPAY") != null) {
            try {
                Class.forName("com.mibi.sdk.channel.unionpay.UnionPayUtil").getMethod("init", Context.class).invoke(null, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void tryAddEntry(String str) {
        try {
            RechargeManager.get().registRecharge((Recharge) Class.forName(str).newInstance());
            Log.d("ChannelManager", str + " is added to rechage manager");
        } catch (ClassNotFoundException unused) {
            Log.e("ChannelManager", str + " is not found");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
}
