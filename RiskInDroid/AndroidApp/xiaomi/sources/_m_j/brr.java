package _m_j;

import android.text.TextUtils;
import com.loc.t;
import java.util.HashMap;
import java.util.Map;

@bsl(O000000o = "a")
public class brr {
    @bsm(O000000o = "a6", O00000Oo = 2)

    /* renamed from: O000000o  reason: collision with root package name */
    int f13222O000000o;
    String O00000Oo;
    @bsm(O000000o = "a2", O00000Oo = 6)
    private String O00000o;
    @bsm(O000000o = "a1", O00000Oo = 6)
    private String O00000o0;
    @bsm(O000000o = "a3", O00000Oo = 6)
    private String O00000oO;
    @bsm(O000000o = "a4", O00000Oo = 6)
    private String O00000oo;
    @bsm(O000000o = "a5", O00000Oo = 6)
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private String[] O0000Ooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13223O000000o;
        public String O00000Oo;
        String O00000o;
        String O00000o0;
        boolean O00000oO = true;
        String O00000oo = "standard";
        String[] O0000O0o = null;

        public O000000o(String str, String str2, String str3) {
            this.f13223O000000o = str2;
            this.O00000Oo = str2;
            this.O00000o = str3;
            this.O00000o0 = str;
        }

        public final O000000o O000000o(String[] strArr) {
            if (strArr != null) {
                this.O0000O0o = (String[]) strArr.clone();
            }
            return this;
        }

        public final brr O000000o() throws t {
            if (this.O0000O0o != null) {
                return new brr(this, (byte) 0);
            }
            throw new t("sdk packages is null");
        }
    }

    private brr() {
        this.f13222O000000o = 1;
        this.O0000Ooo = null;
    }

    /* synthetic */ brr(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public static String O000000o(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", brs.O00000Oo(str));
        return bsk.O000000o((Map<String, String>) hashMap);
    }

    private static String O000000o(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String[] O00000Oo(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O00000oO() {
        return "a6=1";
    }

    public final String O000000o() {
        if (TextUtils.isEmpty(this.O0000Oo) && !TextUtils.isEmpty(this.O00000o0)) {
            this.O0000Oo = brs.O00000o0(this.O00000o0);
        }
        return this.O0000Oo;
    }

    public final void O000000o(boolean z) {
        this.f13222O000000o = z ? 1 : 0;
    }

    public final String O00000Oo() {
        if (TextUtils.isEmpty(this.O0000OOo) && !TextUtils.isEmpty(this.O00000o)) {
            this.O0000OOo = brs.O00000o0(this.O00000o);
        }
        return this.O0000OOo;
    }

    public final String[] O00000o() {
        String[] strArr = this.O0000Ooo;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.O00000oo)) {
            this.O0000Ooo = O00000Oo(brs.O00000o0(this.O00000oo));
        }
        return (String[]) this.O0000Ooo.clone();
    }

    public final String O00000o0() {
        if (TextUtils.isEmpty(this.O0000OoO) && !TextUtils.isEmpty(this.O0000O0o)) {
            this.O0000OoO = brs.O00000o0(this.O0000O0o);
        }
        if (TextUtils.isEmpty(this.O0000OoO)) {
            this.O0000OoO = "standard";
        }
        return this.O0000OoO;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getClass() == obj.getClass() && hashCode() == ((brr) obj).hashCode();
    }

    private brr(O000000o o000000o) {
        this.f13222O000000o = 1;
        this.O0000Ooo = null;
        this.O00000Oo = o000000o.f13223O000000o;
        this.O0000OOo = o000000o.O00000Oo;
        this.O0000Oo = o000000o.O00000o0;
        this.O0000Oo0 = o000000o.O00000o;
        this.f13222O000000o = o000000o.O00000oO ? 1 : 0;
        this.O0000OoO = o000000o.O00000oo;
        this.O0000Ooo = o000000o.O0000O0o;
        this.O00000o = brs.O00000Oo(this.O0000OOo);
        this.O00000o0 = brs.O00000Oo(this.O0000Oo);
        this.O00000oO = brs.O00000Oo(this.O0000Oo0);
        this.O00000oo = brs.O00000Oo(O000000o(this.O0000Ooo));
        this.O0000O0o = brs.O00000Oo(this.O0000OoO);
    }

    public int hashCode() {
        bsb bsb = new bsb();
        bsb.O000000o(this.O0000Oo).O000000o(this.O00000Oo).O000000o(this.O0000OOo).O000000o((Object[]) this.O0000Ooo);
        return bsb.f13228O000000o;
    }
}
