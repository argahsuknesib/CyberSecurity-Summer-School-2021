package _m_j;

import android.text.TextUtils;

public final class fwv {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f17334O000000o;
    private String O00000Oo;
    private Long O00000o0;

    public fwv(String str, String str2, Long l) {
        this.f17334O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = l;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(!(obj instanceof fwv) || this.O00000o0 == null || this.f17334O000000o == null || (str = this.O00000Oo) == null)) {
            fwv fwv = (fwv) obj;
            return TextUtils.equals(str, fwv.O00000Oo) && TextUtils.equals(this.f17334O000000o, fwv.f17334O000000o) && this.O00000o0.equals(fwv.O00000o0);
        }
    }

    public final int hashCode() {
        Long l = this.O00000o0;
        return (l == null || l == null || this.f17334O000000o == null) ? super.hashCode() : ((((this.O00000Oo.hashCode() + 527) * 31) + this.f17334O000000o.hashCode()) * 31) + this.O00000o0.hashCode();
    }

    public final String toString() {
        return "PluginBundleKey{model='" + this.f17334O000000o + '\'' + ", did='" + this.O00000Oo + '\'' + ", packageId=" + this.O00000o0 + '}';
    }
}
