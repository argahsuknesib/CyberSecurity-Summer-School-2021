package com.mobikwik.sdk.ui.util;

import _m_j.ft;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import com.mobikwik.sdk.lib.utils.Utils;
import java.util.regex.Pattern;

public class c extends BroadcastReceiver {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        String str3 = "";
        try {
            SmsMessage createFromPdu = SmsMessage.createFromPdu((byte[]) ((Object[]) intent.getExtras().get("pdus"))[0]);
            str = createFromPdu.getMessageBody();
            try {
                str3 = createFromPdu.getOriginatingAddress();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                Utils.print("SMS SENDER > ".concat(String.valueOf(str3)));
                Utils.print("SMS BODY   > ".concat(String.valueOf(str)));
                if (!Utils.isNull(str3)) {
                }
                str2 = "Incomplete DATA !!!";
                Utils.print(str2);
            }
        } catch (Exception e2) {
            e = e2;
            str = str3;
            e.printStackTrace();
            Utils.print("SMS SENDER > ".concat(String.valueOf(str3)));
            Utils.print("SMS BODY   > ".concat(String.valueOf(str)));
            if (!Utils.isNull(str3)) {
            }
            str2 = "Incomplete DATA !!!";
            Utils.print(str2);
        }
        Utils.print("SMS SENDER > ".concat(String.valueOf(str3)));
        Utils.print("SMS BODY   > ".concat(String.valueOf(str)));
        if (!Utils.isNull(str3) || Utils.isNull(str)) {
            str2 = "Incomplete DATA !!!";
        } else if (!Pattern.compile("[a-zA-Z]{2,2}-MOBIKW").matcher(str3).matches()) {
            str2 = "SMS sender not matched ";
        } else if (str.contains("One Time Password (OTP) for your Mobikwik wallet is: ")) {
            int indexOf = str.indexOf("One Time Password (OTP) for your Mobikwik wallet is: ") + 53;
            String substring = str.substring(indexOf, str.indexOf(".", indexOf));
            Intent intent2 = new Intent("AUTO_OTP_FILTER");
            intent2.putExtra("otpValue", substring);
            ft.O000000o(context).O000000o(intent2);
            Utils.print("SMS OTP > ".concat(String.valueOf(substring)));
            return;
        } else {
            return;
        }
        Utils.print(str2);
    }
}
