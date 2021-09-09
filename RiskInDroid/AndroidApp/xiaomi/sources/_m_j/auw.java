package _m_j;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuth2AccessTokenErrorResponse;
import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class auw implements aux<OAuth2AccessToken> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pattern f12629O000000o = Pattern.compile("\"access_token\"\\s*:\\s*\"(\\S*?)\"");
    private static final Pattern O00000Oo = Pattern.compile("\"token_type\"\\s*:\\s*\"(\\S*?)\"");
    private static final Pattern O00000o = Pattern.compile("\"refresh_token\"\\s*:\\s*\"(\\S*?)\"");
    private static final Pattern O00000o0 = Pattern.compile("\"expires_in\"\\s*:\\s*\"?(\\d*?)\"?\\D");
    private static final Pattern O00000oO = Pattern.compile("\"scope\"\\s*:\\s*\"(\\S*?)\"");
    private static final Pattern O00000oo = Pattern.compile("\"error\"\\s*:\\s*\"(\\S*?)\"");
    private static final Pattern O0000O0o = Pattern.compile("\"error_description\"\\s*:\\s*\"([^\"]*?)\"");
    private static final Pattern O0000OOo = Pattern.compile("\"error_uri\"\\s*:\\s*\"(\\S*?)\"");

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final auw f12630O000000o = new auw();
    }

    protected auw() {
    }

    public static auw O000000o() {
        return O000000o.f12630O000000o;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public OAuth2AccessToken O000000o(avg avg) throws IOException {
        String O000000o2 = avg.O000000o();
        avt.O000000o(O000000o2, "Response body is incorrect. Can't extract a token from an empty string");
        if (avg.f12639O000000o == 200) {
            return O000000o(O000000o2);
        }
        String O000000o3 = avg.O000000o();
        String O000000o4 = O000000o(O000000o3, O00000oo, true);
        String O000000o5 = O000000o(O000000o3, O0000O0o, false);
        String O000000o6 = O000000o(O000000o3, O0000OOo, false);
        URI uri = null;
        if (O000000o6 != null) {
            try {
                uri = URI.create(O000000o6);
            } catch (IllegalArgumentException unused) {
            }
        }
        throw new OAuth2AccessTokenErrorResponse(OAuth2AccessTokenErrorResponse.ErrorCode.valueOf(O000000o4), O000000o5, uri, O000000o3);
    }

    private static OAuth2AccessToken O000000o(String str) {
        String O000000o2 = O000000o(str, f12629O000000o, true);
        String O000000o3 = O000000o(str, O00000Oo, false);
        String O000000o4 = O000000o(str, O00000o0, false);
        Integer num = null;
        if (O000000o4 != null) {
            try {
                num = Integer.valueOf(O000000o4);
            } catch (NumberFormatException unused) {
            }
        }
        return new OAuth2AccessToken(O000000o2, O000000o3, num, O000000o(str, O00000o, false), O000000o(str, O00000oO, false), str);
    }

    private static String O000000o(String str, Pattern pattern, boolean z) throws OAuthException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (!z) {
            return null;
        }
        throw new OAuthException("Response body is incorrect. Can't extract a '" + pattern.pattern() + "' from this: '" + str + "'", null);
    }
}
