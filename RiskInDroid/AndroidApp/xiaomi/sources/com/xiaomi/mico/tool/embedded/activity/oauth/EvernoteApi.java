package com.xiaomi.mico.tool.embedded.activity.oauth;

import _m_j.aun;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.xiaomi.smarthome.R;

public class EvernoteApi extends aun implements MIBrainOauthApi {
    public String getAccessTokenEndpoint() {
        return "https://app.yinxiang.com/oauth";
    }

    public String getApiKey() {
        return "wlan139";
    }

    public String getApiSecret() {
        return "6bc0875e654180ce";
    }

    public int getBindHint() {
        return R.string.skill_auth_evernote_hint;
    }

    public String getCallback() {
        return "mico://oauth/oauth1";
    }

    public String getProviderId() {
        return "214810034687706112";
    }

    public String getRequestTokenEndpoint() {
        return "https://app.yinxiang.com/oauth";
    }

    static class InstanceHolder {
        public static final EvernoteApi INSTANCE = new EvernoteApi();

        private InstanceHolder() {
        }
    }

    public static EvernoteApi instance() {
        return InstanceHolder.INSTANCE;
    }

    public String getAuthorizationUrl(OAuth1RequestToken oAuth1RequestToken) {
        return String.format("https://app.yinxiang.com/OAuth.action?oauth_token=%s", oAuth1RequestToken.O000000o());
    }
}
