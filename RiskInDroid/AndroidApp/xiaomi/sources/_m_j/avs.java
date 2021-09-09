package _m_j;

import com.github.scribejava.core.exceptions.OAuthException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class avs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<String, String> f12647O000000o;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        f12647O000000o = Collections.unmodifiableMap(hashMap);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public static String O000000o(String str) {
        avt.O000000o((Object) str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            for (Map.Entry next : f12647O000000o.entrySet()) {
                encode = encode.replaceAll(Pattern.quote((String) next.getKey()), (String) next.getValue());
            }
            return encode;
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while encoding string: UTF-8", e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public static String O00000Oo(String str) {
        avt.O000000o((Object) str, "Cannot decode null object");
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Charset not found while decoding string: UTF-8", e);
        }
    }
}
