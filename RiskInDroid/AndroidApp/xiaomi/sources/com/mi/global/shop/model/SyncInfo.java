package com.mi.global.shop.model;

import _m_j.cba;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public class SyncInfo {

    public static class ApkInfo {
        public boolean forceUpdate;
        public String notes;
        public String url;
        public String version;

        public static ApkInfo parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ApkInfo apkInfo = new ApkInfo();
            apkInfo.version = jSONObject.optString("version");
            apkInfo.notes = jSONObject.optString("notes");
            apkInfo.url = jSONObject.optString("url");
            apkInfo.forceUpdate = jSONObject.optBoolean("forceUpdate");
            return apkInfo;
        }
    }

    public static class LaunchInfo {
        public int duration;
        public long endTime;
        public String img;
        public String openType;
        public long startTime;
        public String url;

        public static LaunchInfo parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            LaunchInfo launchInfo = new LaunchInfo();
            launchInfo.startTime = jSONObject.optLong("startTime");
            launchInfo.endTime = jSONObject.optLong("endTime");
            launchInfo.url = jSONObject.optString("url");
            launchInfo.duration = jSONObject.optInt("duration");
            launchInfo.img = jSONObject.optString("img");
            launchInfo.openType = jSONObject.optString("openType");
            if (TextUtils.isEmpty(launchInfo.img)) {
                return null;
            }
            return launchInfo;
        }

        public void handleClick(Context context) {
            HomeThemeItem homeThemeItem = new HomeThemeItem();
            homeThemeItem.mLinkUrl = this.url;
            homeThemeItem.mOpenType = this.openType;
            cba.O000000o(context, homeThemeItem);
        }

        public String toString() {
            return "LaunchInfo:{startTime:" + this.startTime + ",endTime:" + this.endTime + ",url:" + this.url + ",img:" + this.img + ",duration:" + this.duration + "}";
        }
    }
}
