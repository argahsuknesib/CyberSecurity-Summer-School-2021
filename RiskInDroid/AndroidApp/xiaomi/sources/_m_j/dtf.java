package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ResolveStatus;
import java.util.ArrayList;
import java.util.List;

public final class dtf {

    /* renamed from: O000000o  reason: collision with root package name */
    final dti f14918O000000o;
    final dsm O00000Oo;
    private final dtg O00000o;
    public final dtb O00000o0;
    private final List<dtm> O00000oO;

    private dtf(dti dti, dtg dtg, dsm dsm, dtb dtb, List<dtm> list) {
        this.f14918O000000o = dti;
        this.O00000o = dtg;
        this.O00000Oo = dsm;
        this.O00000o0 = dtb;
        this.O00000oO = list;
    }

    private dtf(dso dso, dsm dsm) {
        this(new dti(dso), new dtg(), dsm, null, new ArrayList());
    }

    public final boolean O000000o() {
        return this.O00000o0 != null;
    }

    public final dtf O000000o(dtb dtb) {
        if (dtb == this.O00000o0) {
            return this;
        }
        return new dtf(this.f14918O000000o, this.O00000o, this.O00000Oo, dtb, this.O00000oO);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dtm dtm) {
        this.O00000oO.add(dtm);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        List<dtm> list = this.O00000oO;
        list.remove(list.size() - 1);
    }

    public final String O00000o0() {
        StringBuilder sb = new StringBuilder();
        for (dtm dtm : this.O00000oO) {
            sb.append(dtm.toString());
            sb.append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    public final AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
        dsx dsx = null;
        dsx dsx2 = new dsx(abstractConfigValue, null);
        AbstractConfigValue O000000o2 = this.O00000o.O000000o(dsx2);
        if (O000000o2 == null && O000000o()) {
            dsx = new dsx(abstractConfigValue, this.O00000o0);
            O000000o2 = this.O00000o.O000000o(dsx);
        }
        if (O000000o2 != null) {
            return O000000o2;
        }
        AbstractConfigValue O000000o3 = this.f14918O000000o.O000000o(this, abstractConfigValue);
        if (O000000o3 == null || O000000o3.O0000O0o() == ResolveStatus.RESOLVED) {
            this.O00000o.O000000o(dsx2, O000000o3);
        } else if (O000000o()) {
            if (dsx != null) {
                this.O00000o.O000000o(dsx, O000000o3);
            } else {
                throw new ConfigException.BugOrBroken("restrictedKey should not be null here");
            }
        } else if (this.O00000Oo.O00000Oo) {
            this.O00000o.O000000o(dsx2, O000000o3);
        } else {
            throw new ConfigException.BugOrBroken("resolveSubstitutions() did not give us a resolved object");
        }
        return O000000o3;
    }

    public static AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue, dso dso, dsm dsm) {
        try {
            return new dtf(dso, dsm).O000000o(abstractConfigValue);
        } catch (AbstractConfigValue.NotPossibleToResolve e) {
            throw new ConfigException.BugOrBroken("NotPossibleToResolve was thrown from an outermost resolve", e);
        }
    }
}
