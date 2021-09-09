package _m_j;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth1Token;
import com.github.scribejava.core.model.Token;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class aup<T extends OAuth1Token> implements aux<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pattern f12626O000000o = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern O00000Oo = Pattern.compile("oauth_token_secret=([^&]*)");

    /* access modifiers changed from: protected */
    public abstract T O000000o(String str, String str2, String str3);

    private static String O000000o(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() > 0) {
            return avs.O00000Oo(matcher.group(1));
        }
        throw new OAuthException("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
    }

    public final /* bridge */ /* synthetic */ Token O000000o(avg avg) throws IOException, OAuthException {
        String O000000o2 = avg.O000000o();
        avt.O000000o(O000000o2, "Response body is incorrect. Can't extract a token from an empty string");
        return O000000o(O000000o(O000000o2, f12626O000000o), O000000o(O000000o2, O00000Oo), O000000o2);
    }
}
