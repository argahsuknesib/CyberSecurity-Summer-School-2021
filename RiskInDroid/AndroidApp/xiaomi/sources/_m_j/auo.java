package _m_j;

import com.github.scribejava.core.builder.api.OAuth2SignatureType;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Verb;
import java.util.Map;

public abstract class auo implements aum<avi> {
    public abstract String getAccessTokenEndpoint();

    /* access modifiers changed from: protected */
    public abstract String getAuthorizationBaseUrl();

    public aux<OAuth2AccessToken> getAccessTokenExtractor() {
        return auw.O000000o();
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public String getRefreshTokenEndpoint() {
        return getAccessTokenEndpoint();
    }

    public String getAuthorizationUrl(avc avc, Map<String, String> map) {
        avf avf = new avf(map);
        avf.O000000o("response_type", avc.O00000oo);
        avf.O000000o("client_id", avc.f12635O000000o);
        String str = avc.O00000o0;
        if (str != null) {
            avf.O000000o("redirect_uri", str);
        }
        String str2 = avc.O00000o;
        if (str2 != null) {
            avf.O000000o("scope", str2);
        }
        String str3 = avc.O00000oO;
        if (str3 != null) {
            avf.O000000o("state", str3);
        }
        return avf.O000000o(getAuthorizationBaseUrl());
    }

    public avi createService(avc avc) {
        return new avi(this, avc);
    }

    public OAuth2SignatureType getSignatureType() {
        return OAuth2SignatureType.BEARER_AUTHORIZATION_REQUEST_HEADER_FIELD;
    }
}
