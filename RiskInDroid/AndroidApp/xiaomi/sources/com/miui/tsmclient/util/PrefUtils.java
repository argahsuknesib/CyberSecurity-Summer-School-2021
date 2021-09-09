package com.miui.tsmclient.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardGroupType;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.RfCardCacheData;
import java.util.HashSet;
import java.util.Set;

public class PrefUtils {
    public static String PREF_KEY_AUTO_DISPLAY_QR_VIEW = "pref_key_auto_display_QR_view";
    public static String PREF_KEY_AUTO_RECHARGE_CARD_AID = "pref_key_auto_recharge_card_aid";
    public static String PREF_KEY_KEEP_ACTIVATED_STATUS_PREFIX = "pref_key_activated_status_";
    public static String PREF_KEY_LAST_RECHARGED_TRANSIT_CARD_AID = "pref_key_last_recharged_transit_card_aid";
    public static String PREF_KEY_LAST_USER_NAME = "pref_key_last_user_name";
    public static String PREF_KEY_SPI_PK_STATE = "key_spi_pk_state_new";
    private static Set<String> sInvalidSPIKeyDeviceSet = new HashSet();

    static {
        sInvalidSPIKeyDeviceSet.add("polaris");
        sInvalidSPIKeyDeviceSet.add("dipper");
        sInvalidSPIKeyDeviceSet.add("equuleus");
        sInvalidSPIKeyDeviceSet.add("ursa");
        sInvalidSPIKeyDeviceSet.add("sagit");
        sInvalidSPIKeyDeviceSet.add("jason");
        sInvalidSPIKeyDeviceSet.add("chiron");
        if (sInvalidSPIKeyDeviceSet.contains(Build.DEVICE)) {
        }
    }

    private PrefUtils() {
    }

    public static void putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_miui_tsmclient", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        putString(context, "pref_com_miui_tsmclient", str, str2);
    }

    public static void putString(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).getString(str, str2);
    }

    public static void putInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_miui_tsmclient", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).getInt(str, i);
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_com_miui_tsmclient", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).getLong(str, j);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).contains(str);
    }

    public static boolean remove(Context context, String str) {
        return context.getSharedPreferences("pref_com_miui_tsmclient", 0).edit().remove(str).commit();
    }

    public static void saveRfCard(Context context, CardInfo cardInfo, boolean z) {
        String buildCacheStr = new RfCardCacheData(cardInfo).buildCacheStr();
        LogUtils.d("save rf data: ".concat(String.valueOf(buildCacheStr)));
        putString(context, z ? "key_landscape_rf_default_card_info" : "key_rf_default_card_aid", buildCacheStr);
    }

    public static RfCardCacheData getRfCardCacheData(Context context, boolean z) {
        String str;
        if (z) {
            str = getString(context, "key_landscape_rf_default_card_info", "");
        } else {
            str = getString(context, "key_rf_default_card_aid", "");
        }
        StringBuilder sb = new StringBuilder("cached rf data: ");
        sb.append(str);
        sb.append(", ");
        sb.append(z ? "is" : "is not");
        sb.append("landscape data");
        LogUtils.d(sb.toString());
        return new RfCardCacheData(str);
    }

    public static void putSecureSettings(Context context, String str, int i) {
        putSecureSettings(context, str, i, true);
    }

    public static void putSecureSettings(Context context, String str, int i, boolean z) {
        LogUtils.d("save secure settings, key: " + str + ", value: " + i);
        if (z) {
            putInt(context, str, i);
        }
        SettingKeys.putSecureInt(context, str, i);
        if ("key_bank_card_in_ese".equals(str) || "key_trans_card_in_ese".equals(str)) {
            setDoubleHomeAvailability(context);
        }
    }

    public static int getSecureSettings(Context context, String str) {
        int i;
        try {
            i = SettingKeys.getSecureInt(context, str);
        } catch (Settings.SettingNotFoundException e) {
            LogUtils.e("failed to get secure value for key: ".concat(String.valueOf(str)), e);
            i = -1;
        }
        LogUtils.d("get secure value for key: " + str + ", value: " + i);
        return i;
    }

    public static void setDoubleHomeAvailability(Context context) {
        int secureSettings = getSecureSettings(context, "key_trans_card_in_ese");
        int secureSettings2 = getSecureSettings(context, "key_bank_card_in_ese");
        if ((secureSettings == 1 || secureSettings2 == 1) && getBoolean(context, "key_switch_double_click_home", false)) {
            putSecureSettings(context, "key_double_home_availability", 1);
        } else {
            putSecureSettings(context, "key_double_home_availability", 0);
        }
    }

    public static String getPreferTransitCardAid(Context context) {
        RfCardCacheData rfCardCacheData = getRfCardCacheData(context, false);
        CardGroupType cardGroupType = rfCardCacheData.getCardGroupType();
        if (cardGroupType == null || cardGroupType != CardGroupType.TRANSCARD) {
            return getString(context, PREF_KEY_LAST_RECHARGED_TRANSIT_CARD_AID, getString(context, "key_default_trans_card", ""));
        }
        return rfCardCacheData.getAid();
    }

    public static void clearMifareAndBankCardCacheStatus(Context context) {
        putBoolean(context, "key_mifare_cached", false);
        putBoolean(context, "key_bank_cached", false);
        putBoolean(context, "key_cards_cached", false);
    }

    public static void setTravelInfoTip(Context context, String str, String str2) {
        String str3;
        if (str2 != null) {
            str3 = str + "|" + str2;
        } else {
            str3 = null;
        }
        putString(context, "travel_info", str3);
    }

    public static String getTravelInfoTip(Context context, String str) {
        String string = getString(context, "travel_info", null);
        if (string == null) {
            return null;
        }
        String[] split = string.split("\\|");
        if (split.length < 2 || !TextUtils.equals(split[0], str)) {
            return null;
        }
        return split[1];
    }

    public static void clear(Context context) {
        context.getSharedPreferences("pref_com_miui_tsmclient", 0).edit().clear().apply();
    }
}
