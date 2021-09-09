package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import java.util.IdentityHashMap;
import java.util.Map;

final class dti {

    /* renamed from: O000000o  reason: collision with root package name */
    private final dso f14921O000000o;
    private final Map<AbstractConfigValue, dth> O00000Oo = new IdentityHashMap();

    dti(dso dso) {
        this.f14921O000000o = dso;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final AbstractConfigValue O000000o(dtf dtf, dtm dtm, int i) throws AbstractConfigValue.NotPossibleToResolve {
        dtf.O000000o(dtm);
        try {
            AbstractConfigValue O000000o2 = O000000o(this.f14921O000000o, dtf, dtm);
            if (O000000o2 == null) {
                dtb dtb = dtm.f14928O000000o;
                int i2 = i;
                while (dtb != null && i2 > 0) {
                    i2--;
                    dtb = dtb.O00000Oo;
                }
                dtm O000000o3 = dtm.O000000o(dtb);
                dtf.O00000Oo();
                dtf.O000000o(O000000o3);
                if (i > 0) {
                    O000000o2 = O000000o(this.f14921O000000o, dtf, O000000o3);
                }
                if (O000000o2 == null && dtf.O00000Oo.f14893O000000o) {
                    O000000o2 = O000000o(dss.O00000oO(), dtf, O000000o3);
                }
            }
            if (O000000o2 != null) {
                O000000o2 = dtf.O000000o(O000000o2);
            }
            dtf.O00000Oo();
            return O000000o2;
        } catch (Throwable th) {
            dtf.O00000Oo();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(AbstractConfigValue abstractConfigValue, dth dth) {
        if (this.O00000Oo.put(abstractConfigValue, dth) != null) {
            throw new ConfigException.BugOrBroken("should not have replaced the same value twice: ".concat(String.valueOf(abstractConfigValue)));
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(AbstractConfigValue abstractConfigValue) {
        if (this.O00000Oo.remove(abstractConfigValue) == null) {
            throw new ConfigException.BugOrBroken("unreplace() without replace(): ".concat(String.valueOf(abstractConfigValue)));
        }
    }

    private AbstractConfigValue O00000Oo(dtf dtf, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
        dth dth = this.O00000Oo.get(abstractConfigValue);
        if (dth == null) {
            return abstractConfigValue;
        }
        return dth.O00000Oo(dtf);
    }

    /* access modifiers changed from: package-private */
    public final AbstractConfigValue O000000o(dtf dtf, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
        AbstractConfigValue O00000Oo2 = O00000Oo(dtf, abstractConfigValue);
        if (O00000Oo2 != abstractConfigValue) {
            return dtf.O000000o(O00000Oo2);
        }
        return abstractConfigValue.O00000Oo(dtf);
    }

    private static AbstractConfigValue O000000o(dso dso, dtf dtf, dtm dtm) throws AbstractConfigValue.NotPossibleToResolve {
        return dso.O000000o(dso, dtm.f14928O000000o, dtf);
    }
}
