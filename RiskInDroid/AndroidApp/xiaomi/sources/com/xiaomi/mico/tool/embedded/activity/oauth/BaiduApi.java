package com.xiaomi.mico.tool.embedded.activity.oauth;

import _m_j.auo;
import com.xiaomi.smarthome.R;

public class BaiduApi extends auo implements MIBrainOauthApi {
    public String getAccessTokenEndpoint() {
        return "https://openapi.baidu.com/oauth/2.0/token";
    }

    public String getApiKey() {
        return "ZhgehjkYeHlObVMBQbAsacouiKsN9Gzd";
    }

    public String getApiSecret() {
        return "yoGbac0CaeW5lt7ydS5n3c2XlWH11t7b";
    }

    public String getAuthorizationBaseUrl() {
        return "http://openapi.baidu.com/oauth/2.0/authorize";
    }

    public int getBindHint() {
        return R.string.skill_auth_baidu_hint;
    }

    public String getCallback() {
        return "mico://oauth/oauth2/baiduapi";
    }

    public String getProviderId() {
        return "214810034687706112";
    }

    static class InstanceHolder {
        public static final BaiduApi INSTANCE = new BaiduApi();

        private InstanceHolder() {
        }
    }

    public static BaiduApi instance() {
        return InstanceHolder.INSTANCE;
    }
}
