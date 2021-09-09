package com.mi.global.shop.model;

import org.json.JSONObject;

public class PackageInfo {
    private String url;
    private long version;

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public static PackageInfo getPackageInfo(JSONObject jSONObject) {
        PackageInfo packageInfo = new PackageInfo();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("packageInfo");
            packageInfo.setVersion(optJSONObject.optLong("version"));
            packageInfo.setUrl(optJSONObject.optString("url"));
            return packageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
