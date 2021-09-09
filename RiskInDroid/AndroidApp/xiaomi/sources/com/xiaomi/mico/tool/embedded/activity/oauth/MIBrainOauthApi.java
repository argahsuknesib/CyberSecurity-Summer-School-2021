package com.xiaomi.mico.tool.embedded.activity.oauth;

public interface MIBrainOauthApi {
    String getApiKey();

    String getApiSecret();

    int getBindHint();

    String getCallback();

    String getProviderId();
}
