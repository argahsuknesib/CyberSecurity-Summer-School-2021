package com.github.scribejava.core.model;

import java.util.Objects;

public class OAuth1AccessToken extends OAuth1Token {
    private static final long serialVersionUID = -103999293167210966L;

    public OAuth1AccessToken(String str, String str2, String str3) {
        super(str, str2, str3);
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
        OAuth1AccessToken oAuth1AccessToken = (OAuth1AccessToken) obj;
        if (!Objects.equals(super.O000000o(), super.O000000o())) {
            return false;
        }
        return Objects.equals(super.O00000Oo(), super.O00000Oo());
    }

    public String toString() {
        return "OAuth1AccessToken{oauth_token=" + super.O000000o() + ", oauth_token_secret=" + super.O00000Oo() + '}';
    }

    public int hashCode() {
        return ((Objects.hashCode(super.O000000o()) + 219) * 73) + Objects.hashCode(super.O00000Oo());
    }
}
