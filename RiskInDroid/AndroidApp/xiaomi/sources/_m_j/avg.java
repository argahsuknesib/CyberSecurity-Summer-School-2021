package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class avg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12639O000000o;
    private final String O00000Oo;
    private String O00000o;
    private final Map<String, String> O00000o0;
    private InputStream O00000oO;

    private avg(int i, String str, Map<String, String> map) {
        this.f12639O000000o = i;
        this.O00000Oo = str;
        this.O00000o0 = map;
    }

    public avg(int i, String str, Map<String, String> map, InputStream inputStream) {
        this(i, str, map);
        this.O00000oO = inputStream;
    }

    private String O00000Oo() throws IOException {
        if (this.O00000oO == null) {
            return null;
        }
        if ("gzip".equals(this.O00000o0.get("Content-Encoding"))) {
            InputStream inputStream = this.O00000oO;
            avt.O000000o(inputStream, "Cannot get String from a null object");
            this.O00000o = avu.O000000o(new GZIPInputStream(inputStream));
        } else {
            this.O00000o = avu.O000000o(this.O00000oO);
        }
        return this.O00000o;
    }

    public final String O000000o() throws IOException {
        String str = this.O00000o;
        return str == null ? O00000Oo() : str;
    }

    public final String toString() {
        return "Response{code=" + this.f12639O000000o + ", message='" + this.O00000Oo + '\'' + ", body='" + this.O00000o + '\'' + ", headers=" + this.O00000o0 + '}';
    }
}
