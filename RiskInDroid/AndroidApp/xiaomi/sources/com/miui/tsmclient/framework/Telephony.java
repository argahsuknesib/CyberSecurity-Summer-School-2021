package com.miui.tsmclient.framework;

import android.telephony.SmsMessage;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import miui.telephony.SubscriptionInfo;
import miui.telephony.SubscriptionManager;
import miui.telephony.TelephonyManager;

public class Telephony {
    public static List<String> getSIMNumber() {
        LinkedList linkedList = new LinkedList();
        TelephonyManager telephonyManager = TelephonyManager.getDefault();
        for (int i = 0; i < telephonyManager.getPhoneCount(); i++) {
            if (telephonyManager.hasIccCard(i)) {
                SubscriptionInfo subscriptionInfoForSlot = SubscriptionManager.getDefault().getSubscriptionInfoForSlot(i);
                if (subscriptionInfoForSlot == null || TextUtils.isEmpty(subscriptionInfoForSlot.getDisplayNumber())) {
                    linkedList.add("13100000000");
                } else {
                    linkedList.add("1310000" + tail(subscriptionInfoForSlot.getDisplayNumber(), 4));
                }
            }
        }
        return linkedList;
    }

    private static String tail(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(str.length() - i);
    }

    public static String createSmsFromPdu(byte[] bArr) {
        return SmsMessage.createFromPdu(bArr).getMessageBody();
    }
}
