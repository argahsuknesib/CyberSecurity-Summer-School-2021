package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

public final class gsj {

    /* renamed from: O000000o  reason: collision with root package name */
    String f18211O000000o;
    Map<String, String> O00000Oo;
    public RequestBody O00000o;
    public List<gsi> O00000o0;
    private String O00000oO;

    public gsj(O000000o o000000o) {
        this.O00000oO = o000000o.f18212O000000o;
        this.f18211O000000o = o000000o.O00000Oo;
        this.O00000Oo = o000000o.O00000o;
        this.O00000o0 = o000000o.O00000oO;
        this.O00000o = o000000o.O00000o0;
    }

    public final String O000000o() {
        if (!TextUtils.isEmpty(this.O00000oO)) {
            return this.O00000oO;
        }
        throw new IllegalArgumentException("method == null");
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18212O000000o;
        public String O00000Oo;
        public Map<String, String> O00000o = new HashMap();
        public RequestBody O00000o0;
        public List<gsi> O00000oO = new ArrayList(8);

        public final O000000o O000000o(String str) {
            this.f18212O000000o = str;
            return this;
        }

        public final O000000o O00000Oo(String str) {
            if (str != null) {
                this.O00000Oo = str;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public final O000000o O000000o(RequestBody requestBody) {
            if (requestBody != null) {
                this.O00000o0 = requestBody;
                return this;
            }
            throw new IllegalArgumentException("body == null");
        }

        public final O000000o O000000o(Map<String, String> map) {
            if (map != null) {
                this.O00000o = map;
                return this;
            }
            throw new IllegalArgumentException("headers == null");
        }

        public final O000000o O000000o(List<gsi> list) {
            this.O00000oO = list;
            return this;
        }

        public final gsj O000000o() {
            return new gsj(this);
        }
    }
}
