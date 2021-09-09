package com.xiaomi.mico.common.application;

import android.text.TextUtils;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import org.json.JSONArray;
import org.json.JSONException;

public class UserPreference {
    public static boolean isExpiredAlarmRecall() {
        return System.currentTimeMillis() - PreferenceUtils.getSettingLong(CommonApplication.getAppContext(), "alarm_recall_".concat(String.valueOf(AccountProfile.current().getUserId())), 0) > 2592000000L;
    }

    public static void setAlarmRecallTimestamp() {
        PreferenceUtils.setSettingLong(CommonApplication.getAppContext(), "alarm_recall_".concat(String.valueOf(AccountProfile.current().getUserId())), System.currentTimeMillis());
    }

    public static boolean isInitRemindIgnored(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String settingString = PreferenceUtils.getSettingString(CommonApplication.getAppContext(), "blue_init_reminded_mac_".concat(String.valueOf(AccountProfile.current().getUserId())), null);
        if (settingString != null) {
            Object[] objArr = {"ignore macs=%s", settingString};
            try {
                JSONArray jSONArray = new JSONArray(settingString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str.equalsIgnoreCase(jSONArray.optString(i))) {
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void setInitRemindIgnore(String str) {
        if (!TextUtils.isEmpty(str)) {
            String userId = AccountProfile.current().getUserId();
            JSONArray jSONArray = null;
            String settingString = PreferenceUtils.getSettingString(CommonApplication.getAppContext(), "blue_init_reminded_mac_".concat(String.valueOf(userId)), null);
            if (settingString != null) {
                try {
                    jSONArray = new JSONArray(settingString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                jSONArray = new JSONArray();
            }
            jSONArray.put(str);
            if (jSONArray != null) {
                PreferenceUtils.setSettingString(CommonApplication.getAppContext(), "blue_init_reminded_mac_".concat(String.valueOf(userId)), jSONArray.toString());
            }
        }
    }

    public static long getUpgradeTime(String str) {
        return PreferenceUtils.getSettingLong(CommonApplication.getAppContext(), "upgrade_start_time".concat(String.valueOf(str)), 0);
    }

    public static void setUpgradeTime(String str) {
        PreferenceUtils.setSettingLong(CommonApplication.getAppContext(), "upgrade_start_time".concat(String.valueOf(str)), System.currentTimeMillis());
    }

    public static boolean getPrivacyAgreement() {
        return PreferenceUtils.getSettingBoolean(CommonApplication.getAppContext(), "privacy_agreement", false);
    }

    public static void setPrivacyAgreement(boolean z) {
        PreferenceUtils.setSettingBoolean(CommonApplication.getAppContext(), "privacy_agreement", z);
    }

    public static void setDedaoAuthClosed(boolean z) {
        PreferenceUtils.setSettingBoolean(CommonApplication.getAppContext(), "dedao_auth_view_state".concat(String.valueOf(LoginManager.getInstance().getPassportInfo().getUserId())), z);
    }

    public static boolean isDedaoAuthClosed() {
        return PreferenceUtils.getSettingBoolean(CommonApplication.getAppContext(), "dedao_auth_view_state".concat(String.valueOf(LoginManager.getInstance().getPassportInfo().getUserId())), false);
    }
}
