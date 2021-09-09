package _m_j;

import android.text.TextUtils;

public final class caf {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f13514O000000o;
    public final String O00000Oo;

    private caf(String str, String str2) {
        this.f13514O000000o = str;
        this.O00000Oo = str2;
    }

    public static caf O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return null;
        }
        return new caf(split[0], split[1]);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        caf caf = (caf) obj;
        String str = this.f13514O000000o;
        if (str == null ? caf.f13514O000000o != null : !str.equals(caf.f13514O000000o)) {
            return false;
        }
        String str2 = this.O00000Oo;
        return str2 == null ? caf.O00000Oo == null : str2.equals(caf.O00000Oo);
    }

    public final int hashCode() {
        String str = this.f13514O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
