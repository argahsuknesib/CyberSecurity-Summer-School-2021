package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceStatus {
    public String extra;
    public String status;

    public static class ExtraData {
        public int progress;
        public String status;
        public String updateVerison;
    }

    public int getProgress() {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optInt("progress", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public String updateVersion() {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optString("update_version", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public boolean isUpgrading(String str) {
        if (!"download".equals(this.status) && !"verify".equals(this.status) && !"extract".equals(this.status) && !"burn".equals(this.status) && !"reboot".equals(this.status)) {
            return false;
        }
        String updateVersion = updateVersion();
        if (!TextUtils.isEmpty(updateVersion)) {
            return updateVersion.equals(str);
        }
        return true;
    }
}
