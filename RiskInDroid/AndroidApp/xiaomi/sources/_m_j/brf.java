package _m_j;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.NameValuePair;

public final class brf {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13215O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public List<NameValuePair> O0000OoO;
    public String O0000Ooo;
    public String O0000o00;

    public brf() {
        this.O0000O0o = -1;
    }

    public brf(String str) {
        try {
            O000000o(new URI(str));
        } catch (URISyntaxException e) {
            brm.O000000o(e.getMessage(), e);
        }
    }

    public brf(URI uri) {
        O000000o(uri);
    }

    private void O000000o(URI uri) {
        this.f13215O000000o = uri.getScheme();
        this.O00000Oo = uri.getRawSchemeSpecificPart();
        this.O00000o0 = uri.getRawAuthority();
        this.O00000oo = uri.getHost();
        this.O0000O0o = uri.getPort();
        this.O00000oO = uri.getRawUserInfo();
        this.O00000o = uri.getUserInfo();
        this.O0000Oo0 = uri.getRawPath();
        this.O0000OOo = uri.getPath();
        this.O0000Oo = uri.getRawQuery();
        this.O0000OoO = O00000Oo(uri.getRawQuery());
        this.O0000o00 = uri.getRawFragment();
        this.O0000Ooo = uri.getFragment();
    }

    private static List<NameValuePair> O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            return brg.O000000o(str);
        }
        return null;
    }

    public static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }
}
