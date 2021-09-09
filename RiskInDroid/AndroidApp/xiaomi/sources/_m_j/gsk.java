package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public final class gsk {

    /* renamed from: O000000o  reason: collision with root package name */
    String f18213O000000o;
    Map<String, String> O00000Oo;
    private String O00000o;
    List<gkw> O00000o0;

    public gsk(O000000o o000000o) {
        this.O00000o = o000000o.f18214O000000o;
        this.f18213O000000o = o000000o.O00000Oo;
        this.O00000Oo = o000000o.O00000o0;
        this.O00000o0 = o000000o.O00000o;
    }

    public final String O000000o() {
        if (!TextUtils.isEmpty(this.O00000o)) {
            return this.O00000o;
        }
        throw new IllegalArgumentException("method == null");
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18214O000000o;
        public String O00000Oo;
        public List<gkw> O00000o = new ArrayList(8);
        public Map<String, String> O00000o0 = new HashMap();

        public final O000000o O000000o(String str) {
            if (str != null) {
                this.f18214O000000o = str;
                return this;
            }
            throw new IllegalArgumentException("method == null");
        }

        public final O000000o O00000Oo(String str) {
            if (str != null) {
                this.O00000Oo = str;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public final O000000o O000000o(List<gkw> list) {
            if (list != null) {
                this.O00000o = list;
                return this;
            }
            throw new IllegalArgumentException("queries == null");
        }

        public final gsk O000000o() {
            return new gsk(this);
        }
    }
}
