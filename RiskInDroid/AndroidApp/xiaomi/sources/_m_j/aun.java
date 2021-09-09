package _m_j;

import com.github.scribejava.core.builder.api.OAuth1SignatureType;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.Verb;

public abstract class aun implements aum<avh> {
    public abstract String getAccessTokenEndpoint();

    public abstract String getAuthorizationUrl(OAuth1RequestToken oAuth1RequestToken);

    public abstract String getRequestTokenEndpoint();

    public boolean isEmptyOAuthTokenParamIsRequired() {
        return false;
    }

    public aux<OAuth1AccessToken> getAccessTokenExtractor() {
        return auu.O000000o();
    }

    public auq getBaseStringExtractor() {
        return new aur();
    }

    public aus getHeaderExtractor() {
        return new aut();
    }

    public aux<OAuth1RequestToken> getRequestTokenExtractor() {
        return auv.O000000o();
    }

    public avo getSignatureService() {
        return new avn();
    }

    public OAuth1SignatureType getSignatureType() {
        return OAuth1SignatureType.Header;
    }

    public avp getTimestampService() {
        return new avq();
    }

    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    public Verb getRequestTokenVerb() {
        return Verb.POST;
    }

    public avh createService(avc avc) {
        return new avh(this, avc);
    }
}
