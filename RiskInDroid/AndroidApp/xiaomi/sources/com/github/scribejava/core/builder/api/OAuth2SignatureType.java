package com.github.scribejava.core.builder.api;

import _m_j.avd;
import com.github.scribejava.core.model.OAuth2AccessToken;

public enum OAuth2SignatureType {
    BEARER_AUTHORIZATION_REQUEST_HEADER_FIELD {
        public final void signRequest(OAuth2AccessToken oAuth2AccessToken, avd avd) {
            avd.O00000Oo("Authorization", "Bearer " + oAuth2AccessToken.accessToken);
        }
    },
    BEARER_URI_QUERY_PARAMETER {
        public final void signRequest(OAuth2AccessToken oAuth2AccessToken, avd avd) {
            avd.O00000o0("access_token", oAuth2AccessToken.accessToken);
        }
    };

    public abstract void signRequest(OAuth2AccessToken oAuth2AccessToken, avd avd);
}
