package com.miui.tsmclient.util;

import android.content.Context;
import android.text.TextUtils;
import com.miui.tsmclient.analytics.AnalyticManager;
import com.miui.tsmclient.analytics.TSMDataStatInterface;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoManager;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.terminal.APDUConstants;
import java.util.ArrayList;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f5263a;
    private static String b;

    public static int a(Context context) {
        return DeviceUtils.getAppVersionCode(context);
    }

    public static String a() {
        return DeviceUtils.getRomVersion();
    }

    public static String a(CardInfo cardInfo) {
        return DeviceUtils.getMIUIRomType(cardInfo);
    }

    public static void a(Context context, CardInfo cardInfo) {
        CardInfoManager.getInstance(context).remove(cardInfo);
        PrefUtils.remove(context, String.format("key_card_extra_%1$s", cardInfo.mCardType));
    }

    private static void a(Context context, CardInfo cardInfo, boolean z) {
        if (cardInfo.isTransCard() && z) {
            PrefUtils.putSecureSettings(context, "key_trans_card_in_ese", 1);
        }
    }

    public static final boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(Coder.bytesToHexString(APDUConstants.PBOC_CARD_AID_PREFFIX));
    }

    public static String b(CardInfo cardInfo) {
        return DeviceUtils.getDeviceModel(cardInfo);
    }

    public static String b(String str) {
        return (str == null || str.length() < 3 || !a(str)) ? str : str.substring(0, str.length() - 3);
    }

    public static boolean b(Context context, CardInfo cardInfo) {
        if (cardInfo == null || TextUtils.isEmpty(cardInfo.mAid)) {
            LogUtils.w("Aid of activated card must not be empty");
            return false;
        }
        String mapAid = cardInfo.mapAid();
        LogUtils.d("activateCard appAid:".concat(String.valueOf(mapAid)));
        HashMap hashMap = new HashMap();
        hashMap.put("aid", b(cardInfo.mAid));
        AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_launch", "activateCard"), hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add(cardInfo.mAid);
        TSMDataStatInterface.getInstance().recordListEvent(3, arrayList);
        if (cardInfo.getTerminal().activateCard(mapAid)) {
            a(context, cardInfo, false);
            LogUtils.d("activateCard appAid:" + mapAid + " success");
            AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_success", "activateCard"), hashMap);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("1");
            arrayList2.add(cardInfo.mAid);
            TSMDataStatInterface.getInstance().recordListEvent(3, arrayList2);
            return true;
        }
        AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_failed", "activateCard"), hashMap);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("-1");
        arrayList3.add(cardInfo.mAid);
        TSMDataStatInterface.getInstance().recordListEvent(3, arrayList3);
        return false;
    }

    public static boolean c(Context context, CardInfo cardInfo) {
        if (cardInfo == null || TextUtils.isEmpty(cardInfo.mAid)) {
            LogUtils.w("Aid of deactivated card must not be empty");
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aid", b(cardInfo.mAid));
        AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_launch", "deactivateCard"), hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add(cardInfo.mAid);
        TSMDataStatInterface.getInstance().recordListEvent(4, arrayList);
        if (cardInfo.getTerminal().deactivateCard(cardInfo.mapAid())) {
            LogUtils.d("deactivateCard appAid:" + cardInfo.mapAid() + " success");
            AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_success", "deactivateCard"), hashMap);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("1");
            arrayList2.add(cardInfo.mAid);
            TSMDataStatInterface.getInstance().recordListEvent(4, arrayList2);
            return true;
        }
        AnalyticManager.getInstance().recordEvent("nfc", String.format("operation_%s_failed", "deactivateCard"), hashMap);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("-1");
        arrayList3.add(cardInfo.mAid);
        TSMDataStatInterface.getInstance().recordListEvent(4, arrayList3);
        return false;
    }
}
