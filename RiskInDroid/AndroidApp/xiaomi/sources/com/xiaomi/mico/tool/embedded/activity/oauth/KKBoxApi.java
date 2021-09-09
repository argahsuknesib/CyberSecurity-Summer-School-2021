package com.xiaomi.mico.tool.embedded.activity.oauth;

import _m_j.auo;
import com.xiaomi.smarthome.R;

public class KKBoxApi extends auo implements MIBrainOauthApi {
    public String getAccessTokenEndpoint() {
        return "https://i-preview.ai.mi.com/skills/account_link";
    }

    public String getApiKey() {
        return "ac81c7f7cdb71fbe";
    }

    public String getApiSecret() {
        return "f9bf825eaffe97e19c1b11c13933b352";
    }

    public String getAuthorizationBaseUrl() {
        return " https://i-preview.ai.mi.com/skills/account_link";
    }

    public int getBindHint() {
        return R.string.skill_auth_dedao_hint;
    }

    public String getCallback() {
        return "mico://oauth/oauth2/common";
    }

    public String getProviderId() {
        return "347442676548767744";
    }

    static class InstanceHolder {
        public static final KKBoxApi INSTANCE = new KKBoxApi();

        private InstanceHolder() {
        }
    }

    public static KKBoxApi instance() {
        return InstanceHolder.INSTANCE;
    }
}
