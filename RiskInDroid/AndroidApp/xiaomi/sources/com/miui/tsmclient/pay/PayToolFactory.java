package com.miui.tsmclient.pay;

import com.miui.tsmclient.util.ReflectUtil;

public class PayToolFactory {
    public static IPayTool getPayTool(String str) {
        return getPayTool(PayType.Mipay, str);
    }

    public static IPayTool getPayTool(PayType payType, String str) {
        switch (payType) {
            case Mipay:
            case UCashier:
                return (IPayTool) ReflectUtil.newInstance("com.miui.tsmclient.pay.MiPayTool", (Class<?>[]) null, new Object[0]);
            case EntryPay:
                return (IPayTool) ReflectUtil.newInstance("com.miui.tsmclient.pay.EntryPayTool", new Class[]{String.class}, str);
            case UPInAppPay:
                return (IPayTool) ReflectUtil.newInstance("com.miui.tsmclient.pay.UPInAppPayTool", (Class<?>[]) null, new Object[0]);
            case WxPay:
                return (IPayTool) ReflectUtil.newInstance("com.miui.tsmclient.pay.WxPayTool", (Class<?>[]) null, new Object[0]);
            case AliPay:
                return (IPayTool) ReflectUtil.newInstance("com.miui.tsmclient.pay.AliPayTool", (Class<?>[]) null, new Object[0]);
            default:
                return null;
        }
    }
}
