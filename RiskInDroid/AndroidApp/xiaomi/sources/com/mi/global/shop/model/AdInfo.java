package com.mi.global.shop.model;

import _m_j.cba;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public class AdInfo {
    public int duration;
    private String mIsNeedLogin;
    private String mKeyword;
    public String mLinkUrl;
    public String mOpenType;
    public String mProductId;
    public String picUrl;
    public String text;

    public static AdInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdInfo adInfo = new AdInfo();
        adInfo.text = jSONObject.optString("text");
        adInfo.mOpenType = jSONObject.optString("open_type");
        adInfo.mLinkUrl = jSONObject.optString("link_url");
        adInfo.mProductId = jSONObject.optString("product_id");
        adInfo.mKeyword = jSONObject.optString("keyword");
        adInfo.mIsNeedLogin = jSONObject.optString("is_login");
        adInfo.duration = jSONObject.optInt("duration", 3);
        if (!TextUtils.isEmpty(adInfo.mLinkUrl) || !TextUtils.isEmpty(adInfo.mProductId) || !TextUtils.isEmpty(adInfo.mKeyword)) {
            return adInfo;
        }
        return null;
    }

    public void handleClick(Context context) {
        HomeThemeItem homeThemeItem = new HomeThemeItem();
        homeThemeItem.mOpenType = this.mOpenType;
        homeThemeItem.mLinkUrl = this.mLinkUrl;
        homeThemeItem.mProductId = this.mProductId;
        homeThemeItem.mKeyword = this.mKeyword;
        homeThemeItem.mIsNeedLogin = this.mIsNeedLogin;
        cba.O000000o(context, homeThemeItem);
    }
}
