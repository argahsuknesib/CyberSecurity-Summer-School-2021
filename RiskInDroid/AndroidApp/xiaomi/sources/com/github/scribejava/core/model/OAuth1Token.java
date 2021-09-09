package com.github.scribejava.core.model;

import _m_j.avt;

public abstract class OAuth1Token extends Token {
    private static final long serialVersionUID = 6285873427974823019L;
    private final String token;
    private final String tokenSecret;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public OAuth1Token(String str, String str2, String str3) {
        super(str3);
        avt.O000000o((Object) str, "oauth_token can't be null");
        avt.O000000o((Object) str2, "oauth_token_secret can't be null");
        this.token = str;
        this.tokenSecret = str2;
    }

    public String O000000o() {
        return this.token;
    }

    public String O00000Oo() {
        return this.tokenSecret;
    }
}
