package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken {
    Bundle bundle;
    private String mAccessToken = "";
    private long mExpiresTime = 0;
    private String mPhoneNum = "";
    private String mRefreshToken = "";
    private String mUid = "";

    public Oauth2AccessToken() {
    }

    @Deprecated
    public Oauth2AccessToken(String str) {
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setUid(jSONObject.optString("uid"));
                setToken(jSONObject.optString("access_token"));
                setExpiresIn(jSONObject.optString("expires_in"));
                setRefreshToken(jSONObject.optString("refresh_token"));
                setPhoneNum(jSONObject.optString("phone_num"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mAccessToken = str;
        this.mExpiresTime = System.currentTimeMillis();
        if (str2 != null) {
            this.mExpiresTime += Long.parseLong(str2) * 1000;
        }
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("{") < 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString("uid"));
            oauth2AccessToken.setToken(jSONObject.optString("access_token"));
            oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
            oauth2AccessToken.setRefreshToken(jSONObject.optString("refresh_token"));
            oauth2AccessToken.setPhoneNum(jSONObject.optString("phone_num"));
            return oauth2AccessToken;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle2) {
        if (bundle2 == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        oauth2AccessToken.setUid(getString(bundle2, "uid", ""));
        oauth2AccessToken.setToken(getString(bundle2, "access_token", ""));
        oauth2AccessToken.setExpiresIn(getString(bundle2, "expires_in", ""));
        oauth2AccessToken.setRefreshToken(getString(bundle2, "refresh_token", ""));
        oauth2AccessToken.setPhoneNum(getString(bundle2, "phone_num", ""));
        oauth2AccessToken.setBundle(bundle2);
        return oauth2AccessToken;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public String toString() {
        return "uid: " + this.mUid + ", access_token: " + this.mAccessToken + ", refresh_token: " + this.mRefreshToken + ", phone_num: " + this.mPhoneNum + ", expires_in: " + Long.toString(this.mExpiresTime);
    }

    public String getUid() {
        return this.mUid;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setExpiresIn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    private static String getString(Bundle bundle2, String str, String str2) {
        String string;
        return (bundle2 == null || (string = bundle2.getString(str)) == null) ? str2 : string;
    }

    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    private void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }
}
