package com.xiaomi.passport.ui.settings.utils;

import _m_j.oOOO00o0;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.device.api.Permission;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountSmsVerifyCodeReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f6321O000000o;

    public interface O000000o {
        void O000000o(String str);
    }

    public AccountSmsVerifyCodeReceiver(O000000o o000000o) {
        this.f6321O000000o = o000000o;
    }

    private static boolean O000000o(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (Permission.RECEIVE_SMS.equals(equals)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean O000000o(Activity activity) {
        if (!O000000o((Context) activity)) {
            AccountLog.d("SmsVerifyCodeReceiver", "no android.permission.RECEIVE_SMS permission in AndroidManifest.xml, ignore");
            return false;
        } else if (ContextCompat.O000000o(activity, Permission.RECEIVE_SMS) == 0) {
            return false;
        } else {
            if (oOOO00o0.O000000o(activity, Permission.RECEIVE_SMS)) {
                AccountLog.d("SmsVerifyCodeReceiver", "ignore showing prompt when sms permission already denied");
                return false;
            }
            oOOO00o0.O000000o(activity, new String[]{Permission.RECEIVE_SMS}, 51);
            return true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        ArrayList<String> arrayList;
        if (intent == null || intent.getExtras() == null) {
            AccountLog.i("SmsVerifyCodeReceiver", "bundle is null");
            arrayList = null;
        } else {
            Object[] objArr = (Object[]) intent.getExtras().get("pdus");
            arrayList = new ArrayList<>();
            if (objArr != null) {
                for (Object obj : objArr) {
                    String messageBody = SmsMessage.createFromPdu((byte[]) obj).getMessageBody();
                    if (!TextUtils.isEmpty(messageBody)) {
                        arrayList.add(messageBody);
                    }
                }
            } else {
                AccountLog.w("SmsVerifyCodeReceiver", "no pdus in bundle data");
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            AccountLog.i("SmsVerifyCodeReceiver", "null message");
            return;
        }
        Pattern compile = Pattern.compile("^([\\D]*|.*[\\D])(\\d{4}|\\d{6}|\\d{8})([\\D].*|[\\D]*)$");
        for (String matcher : arrayList) {
            Matcher matcher2 = compile.matcher(matcher);
            if (matcher2.matches()) {
                this.f6321O000000o.O000000o(matcher2.group(2));
            }
        }
    }
}
