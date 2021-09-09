package _m_j;

import com.github.scribejava.core.builder.api.OAuth1SignatureType;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class avh extends avj<OAuth1AccessToken> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final aun f12640O000000o;

    public avh(aun aun, avc avc) {
        super(avc);
        this.f12640O000000o = aun;
    }

    /* renamed from: _m_j.avh$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12641O000000o = new int[OAuth1SignatureType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f12641O000000o[OAuth1SignatureType.Header.ordinal()] = 1;
            f12641O000000o[OAuth1SignatureType.QueryString.ordinal()] = 2;
        }
    }

    public final OAuth1RequestToken O000000o() throws IOException, InterruptedException, ExecutionException {
        avc avc = this.O00000Oo;
        avc.O000000o("obtaining request token from " + this.f12640O000000o.getRequestTokenEndpoint());
        avd avd = new avd(this.f12640O000000o.getRequestTokenVerb(), this.f12640O000000o.getRequestTokenEndpoint());
        avc avc2 = this.O00000Oo;
        avc2.O000000o("setting oauth_callback to " + avc2.O00000o0);
        avd.O000000o("oauth_callback", avc2.O00000o0);
        O000000o(avd, "");
        O00000Oo(avd);
        avc.O000000o("sending request...");
        avg O000000o2 = O000000o(avd);
        String O000000o3 = O000000o2.O000000o();
        avc.O000000o("response status code: " + O000000o2.f12639O000000o);
        avc.O000000o("response body: ".concat(String.valueOf(O000000o3)));
        return this.f12640O000000o.getRequestTokenExtractor().O000000o(O000000o2);
    }

    private void O000000o(avd avd, String str) {
        avc avc = this.O00000Oo;
        avd.O000000o("oauth_timestamp", this.f12640O000000o.getTimestampService().O000000o());
        avd.O000000o("oauth_nonce", this.f12640O000000o.getTimestampService().O00000Oo());
        avd.O000000o("oauth_consumer_key", avc.f12635O000000o);
        avd.O000000o("oauth_signature_method", this.f12640O000000o.getSignatureService().O000000o());
        avd.O000000o("oauth_version", "1.0");
        String str2 = avc.O00000o;
        if (str2 != null) {
            avd.O000000o("scope", str2);
        }
        avd.O000000o("oauth_signature", O00000Oo(avd, str));
        avc.O000000o("appended additional OAuth parameters: " + avr.O000000o(avd.O0000O0o));
    }

    public final OAuth1AccessToken O000000o(OAuth1RequestToken oAuth1RequestToken, String str) throws IOException, InterruptedException, ExecutionException {
        avc avc = this.O00000Oo;
        avc.O000000o("obtaining access token from " + this.f12640O000000o.getAccessTokenEndpoint());
        avd avd = new avd(this.f12640O000000o.getAccessTokenVerb(), this.f12640O000000o.getAccessTokenEndpoint());
        avc avc2 = this.O00000Oo;
        avd.O000000o("oauth_token", oAuth1RequestToken.O000000o());
        avd.O000000o("oauth_verifier", str);
        avc2.O000000o("setting token to: " + oAuth1RequestToken + " and verifier to: " + str);
        O000000o(avd, oAuth1RequestToken.O00000Oo());
        O00000Oo(avd);
        return this.f12640O000000o.getAccessTokenExtractor().O000000o(O000000o(avd));
    }

    private String O00000Oo(avd avd, String str) {
        avc avc = this.O00000Oo;
        avc.O000000o("generating signature...");
        avc.O000000o("using base64 encoder: " + avk.O00000Oo());
        String O000000o2 = this.f12640O000000o.getBaseStringExtractor().O000000o(avd);
        String O000000o3 = this.f12640O000000o.getSignatureService().O000000o(O000000o2, avc.O00000Oo, str);
        avc.O000000o("base string is: ".concat(String.valueOf(O000000o2)));
        avc.O000000o("signature is: ".concat(String.valueOf(O000000o3)));
        return O000000o3;
    }

    private void O00000Oo(avd avd) {
        avc avc = this.O00000Oo;
        OAuth1SignatureType signatureType = this.f12640O000000o.getSignatureType();
        int i = AnonymousClass1.f12641O000000o[signatureType.ordinal()];
        if (i == 1) {
            avc.O000000o("using Http Header signature");
            avd.O00000Oo("Authorization", this.f12640O000000o.getHeaderExtractor().O000000o(avd));
        } else if (i == 2) {
            avc.O000000o("using Querystring signature");
            for (Map.Entry next : avd.O0000O0o.entrySet()) {
                avd.O00000o0((String) next.getKey(), (String) next.getValue());
            }
        } else {
            throw new IllegalStateException("Unknown new Signature Type '" + signatureType + "'.");
        }
    }
}
