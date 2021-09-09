package _m_j;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.Verb;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class avd {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12636O000000o;
    public final Verb O00000Oo;
    public final Map<String, String> O00000o = new HashMap();
    public final avf O00000o0 = new avf();
    public String O00000oO;
    public File O00000oo;
    public final Map<String, String> O0000O0o = new HashMap();
    public String O0000OOo;
    private String O0000Oo;
    private final avf O0000Oo0 = new avf();
    private byte[] O0000OoO;

    public avd(Verb verb, String str) {
        this.O00000Oo = verb;
        this.f12636O000000o = str;
    }

    public final void O000000o(String str, String str2) {
        Map<String, String> map = this.O0000O0o;
        if (str.startsWith("oauth_") || str.equals("scope") || str.equals("realm")) {
            map.put(str, str2);
        } else {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s', '%s' or start with '%s'", "scope", "realm", "oauth_"));
        }
    }

    public final String O000000o() {
        return this.O0000Oo0.O000000o(this.f12636O000000o);
    }

    public final void O00000Oo(String str, String str2) {
        this.O00000o.put(str, str2);
    }

    public final void O00000o0(String str, String str2) {
        this.O0000Oo0.O000000o(str, str2);
    }

    public final void O00000o(String str, String str2) {
        if (this.O00000Oo.isPermitBody()) {
            this.O00000o0.O000000o(str, str2);
        } else {
            this.O0000Oo0.O000000o(str, str2);
        }
    }

    public final avf O00000Oo() {
        try {
            avf avf = new avf();
            avf.O00000Oo(new URL(this.f12636O000000o).getQuery());
            avf.O000000o(this.O0000Oo0);
            return avf;
        } catch (MalformedURLException e) {
            throw new OAuthException("Malformed URL", e);
        }
    }

    public final byte[] O00000o0() {
        byte[] bArr = this.O0000OoO;
        if (bArr != null) {
            return bArr;
        }
        try {
            return this.O00000o0.O000000o().getBytes(O00000o());
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Unsupported Charset: " + O00000o(), e);
        }
    }

    public final String toString() {
        return String.format("@Request(%s %s)", this.O00000Oo, this.f12636O000000o);
    }

    private String O00000o() {
        String str = this.O0000Oo;
        return str == null ? Charset.defaultCharset().name() : str;
    }
}
