package com.xiaomi.mico.tool.embedded.activity.oauth;

import _m_j.aul;
import _m_j.aum;
import _m_j.auo;
import _m_j.avj;
import com.github.scribejava.httpclient.okhttp.OkHttpHttpClient;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.smarthome.R;

public class DedaoApi extends auo implements MIBrainOauthApi {
    private avj mOAuthService;
    private MIBrainOauthApi mProvider;

    public String getAccessTokenEndpoint() {
        return "http://oauth.sim-c.luojilab.com/oauth2/access_token";
    }

    public String getApiKey() {
        return "ac81c7f7cdb71fbe";
    }

    public String getApiSecret() {
        return "f9bf825eaffe97e19c1b11c13933b352";
    }

    public String getAuthorizationBaseUrl() {
        return "http://oauth.sim-c.luojilab.com/oauth2/authorize";
    }

    public int getBindHint() {
        return R.string.skill_auth_dedao_hint;
    }

    public String getCallback() {
        return "mico://oauth/dedao";
    }

    public String getProviderId() {
        return "269135865337350144";
    }

    static class InstanceHolder {
        public static final DedaoApi INSTANCE = new DedaoApi();

        private InstanceHolder() {
        }
    }

    public static DedaoApi instance() {
        return InstanceHolder.INSTANCE;
    }

    public avj getOAuthService() {
        if (this.mOAuthService == null) {
            aul O000000o2 = new aul(getApiKey()).O00000Oo(getApiSecret()).O00000o0(String.valueOf(System.currentTimeMillis())).O000000o(getCallback());
            O000000o2.f12625O000000o = new OkHttpHttpClient(ApiManager.getThirdPartyInstance().getHttpClient());
            this.mOAuthService = O000000o2.O000000o((aum) this.mProvider);
        }
        return this.mOAuthService;
    }
}
