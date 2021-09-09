package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.Util;

public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (map != null) {
            this.scheme = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey() == null ? null : ((String) next.getKey()).toLowerCase(Locale.US), next.getValue());
            }
            this.authParams = Collections.unmodifiableMap(linkedHashMap);
        } else {
            throw new NullPointerException("authParams == null");
        }
    }

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 != null) {
            this.scheme = str;
            this.authParams = Collections.singletonMap("realm", str2);
        } else {
            throw new NullPointerException("realm == null");
        }
    }

    public final Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.authParams);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.scheme, linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public final String scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.ISO_8859_1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return challenge.scheme.equals(this.scheme) && challenge.authParams.equals(this.authParams);
    }

    public final int hashCode() {
        return ((this.scheme.hashCode() + 899) * 31) + this.authParams.hashCode();
    }

    public final String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
