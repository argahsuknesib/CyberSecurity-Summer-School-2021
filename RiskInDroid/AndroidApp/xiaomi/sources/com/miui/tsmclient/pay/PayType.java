package com.miui.tsmclient.pay;

import android.text.TextUtils;

public enum PayType {
    Mipay("MIPAY"),
    UCashier("UCASHIER"),
    EntryPay("ENTRYPAY"),
    UPInAppPay("UPINAPPPAY"),
    WxPay("WECHAT_PAY"),
    AliPay("ALIPAY");
    
    private String mPayType;

    private PayType(String str) {
        this.mPayType = str;
    }

    public final String toString() {
        return this.mPayType;
    }

    public static PayType getInstance(String str) {
        for (PayType payType : values()) {
            if (TextUtils.equals(payType.mPayType, str)) {
                return payType;
            }
        }
        return EntryPay;
    }
}
