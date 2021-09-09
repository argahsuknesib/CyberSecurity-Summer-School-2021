package _m_j;

import com.typesafe.config.impl.AbstractConfigValue;

final class dsx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final AbstractConfigValue f14908O000000o;
    private final dtb O00000Oo;

    dsx(AbstractConfigValue abstractConfigValue, dtb dtb) {
        this.f14908O000000o = abstractConfigValue;
        this.O00000Oo = dtb;
    }

    public final int hashCode() {
        int identityHashCode = System.identityHashCode(this.f14908O000000o);
        dtb dtb = this.O00000Oo;
        return dtb != null ? identityHashCode + ((dtb.hashCode() + 41) * 41) : identityHashCode;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dsx) {
            dsx dsx = (dsx) obj;
            if (dsx.f14908O000000o != this.f14908O000000o) {
                return false;
            }
            dtb dtb = dsx.O00000Oo;
            dtb dtb2 = this.O00000Oo;
            if (dtb == dtb2) {
                return true;
            }
            if (!(dtb == null || dtb2 == null)) {
                return dtb.equals(dtb2);
            }
        }
        return false;
    }
}
