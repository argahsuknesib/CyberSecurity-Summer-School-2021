package com.github.scribejava.core.model;

import _m_j.avt;
import java.util.Objects;

public class OAuth2AccessToken extends Token {
    private static final long serialVersionUID = 8901381135476613449L;
    public String accessToken;
    public Integer expiresIn;
    private String refreshToken;
    private String scope;
    private String tokenType;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public OAuth2AccessToken(String str, String str2, Integer num, String str3, String str4, String str5) {
        super(str5);
        avt.O000000o((Object) str, "access_token can't be null");
        this.accessToken = str;
        this.tokenType = str2;
        this.expiresIn = num;
        this.refreshToken = str3;
        this.scope = str4;
    }

    public int hashCode() {
        return ((((((((Objects.hashCode(this.accessToken) + 287) * 41) + Objects.hashCode(this.tokenType)) * 41) + Objects.hashCode(this.expiresIn)) * 41) + Objects.hashCode(this.refreshToken)) * 41) + Objects.hashCode(this.scope);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) obj;
        if (Objects.equals(this.accessToken, oAuth2AccessToken.accessToken) && Objects.equals(this.tokenType, oAuth2AccessToken.tokenType) && Objects.equals(this.refreshToken, oAuth2AccessToken.refreshToken) && Objects.equals(this.scope, oAuth2AccessToken.scope)) {
            return Objects.equals(this.expiresIn, oAuth2AccessToken.expiresIn);
        }
        return false;
    }

    public String toString() {
        return "OAuth2AccessToken{access_token=" + this.accessToken + ", token_type=" + this.tokenType + ", expires_in=" + this.expiresIn + ", refresh_token=" + this.refreshToken + ", scope=" + this.scope + '}';
    }
}
