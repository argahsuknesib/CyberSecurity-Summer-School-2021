package com.miui.tsmclient.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.tsmclient.smartcard.Coder;
import java.util.List;
import java.util.Locale;

public class DeviceUtils {
    private static IDeviceInfo getPeripheralInfo(CardInfo cardInfo) {
        if (cardInfo == null) {
            cardInfo = CardInfoFactory.makeCardInfo("DUMMY", null);
        }
        return cardInfo.getDeviceInfo();
    }

    public static String getDeviceModel(CardInfo cardInfo) {
        return getPeripheralInfo(cardInfo).getDeviceModel();
    }

    public static String getMIUIRomType(CardInfo cardInfo) {
        return Versions.getRomType();
    }

    public static String getRomVersion() {
        return Versions.getRomVersion();
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceLanguage6393() {
        return Locale.getDefault().getISO3Language();
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int getAppVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        return getAppVersionName(context, context.getPackageName());
    }

    public static int getAppVersionCode(Context context) {
        return getAppVersionCode(context, context.getPackageName());
    }

    public static String getDeviceId(Context context, CardInfo cardInfo) {
        String deviceId = getPeripheralInfo(cardInfo).getDeviceId(context);
        if (!TextUtils.isEmpty(deviceId) && !deviceId.startsWith("vaid_")) {
            deviceId = Coder.hashDeviceInfo(deviceId);
        }
        return deviceId == null ? "" : deviceId;
    }

    public static List<String> getSIMNumber(CardInfo cardInfo) {
        return getPeripheralInfo(cardInfo).getSIMNumber();
    }
}
