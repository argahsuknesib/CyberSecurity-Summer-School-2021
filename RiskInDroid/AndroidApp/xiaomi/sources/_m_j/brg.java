package _m_j;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public final class brg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f13216O000000o = {'&'};
    private static final BitSet O00000Oo = new BitSet(256);
    private static final BitSet O00000o = new BitSet(256);
    private static final BitSet O00000o0 = new BitSet(256);
    private static final BitSet O00000oO = new BitSet(256);
    private static final BitSet O00000oo = new BitSet(256);
    private static final BitSet O0000O0o = new BitSet(256);
    private static final BitSet O0000OOo = new BitSet(256);

    static {
        for (int i = 97; i <= 122; i++) {
            O00000Oo.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            O00000Oo.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            O00000Oo.set(i3);
        }
        O00000Oo.set(95);
        O00000Oo.set(45);
        O00000Oo.set(46);
        O00000Oo.set(42);
        O0000OOo.or(O00000Oo);
        O00000Oo.set(33);
        O00000Oo.set(126);
        O00000Oo.set(39);
        O00000Oo.set(40);
        O00000Oo.set(41);
        O00000o0.set(44);
        O00000o0.set(59);
        O00000o0.set(58);
        O00000o0.set(36);
        O00000o0.set(38);
        O00000o0.set(43);
        O00000o0.set(61);
        O00000o.or(O00000Oo);
        O00000o.or(O00000o0);
        O00000oO.or(O00000Oo);
        O00000oO.set(47);
        O00000oO.set(59);
        O00000oO.set(58);
        O00000oO.set(64);
        O00000oO.set(38);
        O00000oO.set(61);
        O00000oO.set(43);
        O00000oO.set(36);
        O00000oO.set(44);
        O0000O0o.set(59);
        O0000O0o.set(47);
        O0000O0o.set(63);
        O0000O0o.set(58);
        O0000O0o.set(64);
        O0000O0o.set(38);
        O0000O0o.set(61);
        O0000O0o.set(43);
        O0000O0o.set(36);
        O0000O0o.set(44);
        O0000O0o.set(91);
        O0000O0o.set(93);
        O00000oo.or(O0000O0o);
        O00000oo.or(O00000Oo);
    }

    public static List<NameValuePair> O000000o(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.DEFAULT;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            NameValuePair parseNameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, f13216O000000o);
            if (parseNameValuePair.getName().length() > 0) {
                arrayList.add(new BasicNameValuePair(parseNameValuePair.getName(), parseNameValuePair.getValue()));
            }
        }
        return arrayList;
    }

    public static String O000000o(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : list) {
            String O000000o2 = O000000o(next.getName(), str);
            String O000000o3 = O000000o(next.getValue(), str);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(O000000o2);
            if (O000000o3 != null) {
                sb.append("=");
                sb.append(O000000o3);
            }
        }
        return sb.toString();
    }

    public static String O000000o(Iterable<? extends NameValuePair> iterable, Charset charset) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : iterable) {
            String O00000o2 = O00000o(next.getName(), charset);
            String O00000o3 = O00000o(next.getValue(), charset);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(O00000o2);
            if (O00000o3 != null) {
                sb.append("=");
                sb.append(O00000o3);
            }
        }
        return sb.toString();
    }

    private static String O000000o(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b = encode.get() & 255;
            if (bitSet.get(b)) {
                sb.append((char) b);
            } else if (!z || b != 32) {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((b >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & 15, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            } else {
                sb.append('+');
            }
        }
        return sb.toString();
    }

    private static String O000000o(String str, String str2) {
        Charset charset;
        if (str == null) {
            return null;
        }
        if (str2 != null) {
            charset = Charset.forName(str2);
        } else {
            charset = Charset.forName("UTF-8");
        }
        return O000000o(str, charset, O0000OOo, true);
    }

    private static String O00000o(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        return O000000o(str, charset, O0000OOo, true);
    }

    public static String O000000o(String str, Charset charset) {
        return O000000o(str, charset, O00000o, false);
    }

    public static String O00000Oo(String str, Charset charset) {
        return O000000o(str, charset, O00000oo, false);
    }

    public static String O00000o0(String str, Charset charset) {
        return O000000o(str, charset, O00000oO, false);
    }
}
