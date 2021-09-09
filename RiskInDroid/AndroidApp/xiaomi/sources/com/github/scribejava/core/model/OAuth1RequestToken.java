package com.github.scribejava.core.model;

import java.util.Objects;

public class OAuth1RequestToken extends OAuth1Token {
    private static final long serialVersionUID = 6185104114662587991L;
    private final boolean oauthCallbackConfirmed;

    public OAuth1RequestToken(String str, String str2, String str3) {
        this(str, str2, str3, (byte) 0);
    }

    private OAuth1RequestToken(String str, String str2, String str3, byte b) {
        super(str, str2, str3);
        this.oauthCallbackConfirmed = true;
    }

    public final String O000000o() {
        return super.O000000o();
    }

    public final String O00000Oo() {
        return super.O00000Oo();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth1RequestToken oAuth1RequestToken = (OAuth1RequestToken) obj;
        if (this.oauthCallbackConfirmed == oAuth1RequestToken.oauthCallbackConfirmed && Objects.equals(super.O000000o(), super.O000000o())) {
            return Objects.equals(super.O00000Oo(), super.O00000Oo());
        }
        return false;
    }

    public String toString() {
        return "OAuth1RequestToken{oauth_token=" + super.O000000o() + ", oauth_token_secret=" + super.O00000Oo() + ", oauth_callback_confirmed=" + this.oauthCallbackConfirmed + '}';
    }

    public int hashCode() {
        return ((((Objects.hashCode(super.O000000o()) + 581) * 83) + Objects.hashCode(super.O00000Oo())) * 83) + (this.oauthCallbackConfirmed ? 1 : 0);
    }
}
