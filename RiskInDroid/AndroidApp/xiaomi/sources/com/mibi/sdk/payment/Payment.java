package com.mibi.sdk.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.OrderBean;
import java.security.InvalidParameterException;

public final class Payment {
    private static final String MIBI_ENVIRONMENT;

    private Payment() {
    }

    static {
        StringBuilder sb = new StringBuilder(" ; mibiEnv : ");
        String str = "sta";
        sb.append(CommonConstants.STAGING ? str : "pro");
        sb.append(" ; accEnv : ");
        if (!CommonConstants.ACCOUNT_PREVIEW) {
            str = "pro";
        }
        sb.append(str);
        MIBI_ENVIRONMENT = sb.toString();
    }

    @Deprecated
    public static boolean payChannel(Activity activity, int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return payChannel(activity, i, str, str2, z, z2, z3, z4, "");
    }

    @Deprecated
    public static boolean payChannel(Activity activity, int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        return pay(activity, i, new OrderBean.OrderBeanBuilder().setOrder(str).setChannel(str2).useBalance(z).useGiftcard(z2).usePartnerGiftcard(z3).setNoAccount(z4).setQueryIntervalConfig(str3).build());
    }

    public static boolean pay(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "pay versionCode : 38" + " ;use no account : " + orderBean.mIsNoAccount + MIBI_ENVIRONMENT);
        Client.init(activity);
        ChannelManager.registerRechargeChannels(activity);
        if (orderBean.mIsNoAccount) {
            AccountManager.tryClearAccount();
        } else if (AccountManager.isLogined(activity)) {
            AccountManager.initAccount(activity);
        } else {
            MibiLog.e("Payment", "should login first");
            return false;
        }
        orderBean.mOrderType = 1;
        Intent intent = new Intent("com.mibi.sdk.pay.CHANNEL");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
        return true;
    }

    public static boolean qrPay(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "qrPay versionCode : 38" + " ;use no account : " + orderBean.mIsNoAccount + MIBI_ENVIRONMENT);
        if (!isQrPayChannelValid(orderBean.mChannel)) {
            MibiLog.d("Payment", "qr pay not support for channel : " + orderBean.mChannel);
            return false;
        }
        Client.init(activity);
        if (orderBean.mIsNoAccount) {
            AccountManager.tryClearAccount();
        } else if (AccountManager.isLogined(activity)) {
            AccountManager.initAccount(activity);
        } else {
            MibiLog.e("Payment", "should login first");
            return false;
        }
        orderBean.mOrderType = 1;
        Intent intent = new Intent("com.mibi.sdk.action.QR_CODE");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
        return true;
    }

    public static boolean qrDeduct(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "qrDeduct versionCode : 38" + " ; qrDeduct" + MIBI_ENVIRONMENT);
        if (!isQrDeductChannelValid(orderBean.mChannel)) {
            MibiLog.d("Payment", "qr deduct not support for channel : " + orderBean.mChannel);
            return false;
        }
        Client.init(activity);
        if (orderBean.mIsNoAccount) {
            AccountManager.tryClearAccount();
        } else if (AccountManager.isLogined(activity)) {
            AccountManager.initAccount(activity);
        } else {
            MibiLog.e("Payment", "should login first");
            return false;
        }
        orderBean.mOrderType = 2;
        Intent intent = new Intent("com.mibi.sdk.action.QR_CODE");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
        return true;
    }

    public static boolean qrSignDeduct(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "qrSignDeduct versionCode : 38" + " ; qrSignDeduct" + MIBI_ENVIRONMENT);
        if (!isQrSignDeductChannelValid(orderBean.mChannel)) {
            MibiLog.d("Payment", "qr sign deduct not support for channel : " + orderBean.mChannel);
            return false;
        }
        Client.init(activity);
        if (orderBean.mIsNoAccount) {
            AccountManager.tryClearAccount();
        } else if (AccountManager.isLogined(activity)) {
            AccountManager.initAccount(activity);
        } else {
            MibiLog.e("Payment", "should login first");
            return false;
        }
        orderBean.mOrderType = 3;
        Intent intent = new Intent("com.mibi.sdk.action.QR_CODE");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
        return true;
    }

    private static boolean isQrSignDeductChannelValid(String str) {
        return "UNITED_QR".equals(str);
    }

    private static boolean isQrDeductChannelValid(String str) {
        return "UNITED_QR".equals(str);
    }

    private static boolean isQrPayChannelValid(String str) {
        return "UNITED_QR".equals(str) || "MI_QR".equals(str) || "ALI_QR".equals(str) || "WX_QR".equals(str);
    }

    @Deprecated
    public static void deduct(Activity activity, String str, String str2, int i) {
        deduct(activity, str, str2, i, "");
    }

    @Deprecated
    public static void deduct(Activity activity, String str, String str2, int i, String str3) {
        deduct(activity, i, new OrderBean.OrderBeanBuilder().setOrder(str).setChannel(str2).setQueryIntervalConfig(str3).build());
    }

    public static void deduct(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "deduct versionCode : 38" + " ; deduct" + MIBI_ENVIRONMENT);
        if (activity != null) {
            checkOrder(orderBean);
            if (TextUtils.isEmpty(orderBean.mChannel)) {
                throw new InvalidParameterException("the value of channel can not be empty!");
            } else if (!"MIPAYDEDUCT".equals(orderBean.mChannel) && !"WXPAYDEDUCT".equals(orderBean.mChannel) && !"ALIPAYDEDUCT".equals(orderBean.mChannel)) {
                throw new IllegalArgumentException(orderBean.mChannel + " not supported(only sign)");
            } else if (AccountManager.isLogined(activity)) {
                AccountManager.initAccount(activity);
                Client.init(activity);
                orderBean.mOrderType = 2;
                Intent intent = new Intent("com.mibi.sdk.action.DEDUCT");
                intent.putExtra("orderBean", orderBean);
                intent.setPackage(Client.getAppInfo().getPackage());
                activity.startActivityForResult(intent, i);
            } else {
                throw new IllegalStateException("should login first");
            }
        } else {
            throw new InvalidParameterException("activity cannot be null");
        }
    }

    private static void checkOrder(OrderBean orderBean) {
        if (TextUtils.isEmpty(orderBean.mOrder)) {
            throw new InvalidParameterException("the value of order can not be empty!");
        }
    }

    @Deprecated
    public static void signDeduct(Activity activity, String str, String str2, int i) {
        signDeduct(activity, str, str2, i, "");
    }

    @Deprecated
    public static void signDeduct(Activity activity, String str, String str2, int i, String str3) {
        signDeduct(activity, i, new OrderBean.OrderBeanBuilder().setOrder(str).setChannel(str2).setQueryIntervalConfig(str3).build());
    }

    public static void signDeduct(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "signDeduct versionCode : 38" + " ; signDeduct" + MIBI_ENVIRONMENT);
        checkActivity(activity);
        checkOrder(orderBean);
        if (TextUtils.isEmpty(orderBean.mChannel)) {
            throw new InvalidParameterException("the value of channel can not be empty!");
        } else if (!"WXPAYDEDUCT".equals(orderBean.mChannel) && !"ALIPAYDEDUCT".equals(orderBean.mChannel)) {
            throw new IllegalArgumentException(orderBean.mChannel + " not supported(only sign)");
        } else if (AccountManager.isLogined(activity)) {
            AccountManager.initAccount(activity);
            Client.init(activity);
            orderBean.mOrderType = 3;
            Intent intent = new Intent("com.mibi.sdk.action.SIGN_DEDUCT");
            intent.putExtra("orderBean", orderBean);
            intent.setPackage(Client.getAppInfo().getPackage());
            activity.startActivityForResult(intent, i);
        } else {
            throw new IllegalStateException("should login first");
        }
    }

    private static void checkActivity(Activity activity) {
        if (activity == null) {
            throw new InvalidParameterException("activity cannot be null");
        }
    }

    public static void partnerRecharge(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "partnerRecharge versionCode : 38" + " ; useUi : " + orderBean.mUseUi + MIBI_ENVIRONMENT);
        checkActivity(activity);
        checkPartnerInfo(orderBean);
        if (!orderBean.mUseUi) {
            checkChannel(orderBean);
        }
        orderBean.mIsNoAccount = true;
        Client.init(activity);
        ChannelManager.registerRechargeChannels(activity);
        AccountManager.tryClearAccount();
        Intent intent = new Intent("com.mibi.sdk.action.PARTNER_RECHARGE");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
    }

    public static void partnerPay(Activity activity, int i, OrderBean orderBean) {
        MibiLog.d("Payment", "partnerPay versionCode : 38" + " ; useUi : " + orderBean.mUseUi + MIBI_ENVIRONMENT);
        checkActivity(activity);
        checkPartnerInfo(orderBean);
        if (!orderBean.mUseUi) {
            checkChannel(orderBean);
        }
        checkOrder(orderBean);
        orderBean.mIsNoAccount = true;
        orderBean.mDiscountGiftCardId = -1;
        Client.init(activity);
        ChannelManager.registerRechargeChannels(activity);
        AccountManager.tryClearAccount();
        Intent intent = new Intent("com.mibi.sdk.action.PARTNER_PAY");
        intent.putExtra("orderBean", orderBean);
        intent.setPackage(Client.getAppInfo().getPackage());
        activity.startActivityForResult(intent, i);
    }

    private static void checkPartnerInfo(OrderBean orderBean) {
        if (!(orderBean != null && !TextUtils.isEmpty(orderBean.mPartnerUserId) && !TextUtils.isEmpty(orderBean.mPartnerAccountType) && orderBean.mPartnerMarketType > 0)) {
            MibiLog.e("Payment", "partner info invalid, please check your param");
            throw new IllegalArgumentException("partner info invalid, please check your param");
        }
    }

    private static void checkChannel(OrderBean orderBean) {
        if (TextUtils.isEmpty(orderBean.mChannel)) {
            MibiLog.d("Payment", "channel can't be null");
            throw new IllegalArgumentException("channel can't be null");
        }
    }

    public static void setTokenType(Context context, String str) {
        if (TextUtils.isEmpty(str) || (!"AUTH_TOKEN".equals(str) && !"SERVICE_TOKEN".equals(str))) {
            String str2 = str + " not supported, only support CommonConstants.TOKEN_TYPE_AUTH_TOKEN and CommonConstants.TOKEN_TYPE_SERVICE_TOKEN";
            MibiLog.d("Payment", str2);
            throw new IllegalArgumentException(str2);
        }
        CommonConstants.TOKEN_TYPE = str;
        Utils.setStringPref(context, "tokenType", str);
    }
}
