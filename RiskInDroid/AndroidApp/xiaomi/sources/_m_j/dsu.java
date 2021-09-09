package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ResolveStatus;
import java.util.Collection;
import java.util.Collections;

final class dsu extends AbstractConfigValue implements dtp {

    /* renamed from: O000000o  reason: collision with root package name */
    private final dtm f14906O000000o;
    private final int O00000Oo;

    public final boolean O0000OOo() {
        return false;
    }

    dsu(dsi dsi, dtm dtm) {
        this(dsi, dtm, 0);
    }

    private dsu(dsi dsi, dtm dtm, int i) {
        super(dsi);
        this.f14906O000000o = dtm;
        this.O00000Oo = i;
    }

    private ConfigException.NotResolved O0000Ooo() {
        return new ConfigException.NotResolved("need to Config#resolve(), see the API docs for Config#resolve(); substitution not resolved: ".concat(String.valueOf(this)));
    }

    public final ConfigValueType O00000o0() {
        throw O0000Ooo();
    }

    public final Object O00000o() {
        throw O0000Ooo();
    }

    public final Collection<dsu> h_() {
        return Collections.singleton(this);
    }

    public final ResolveStatus O0000O0o() {
        return ResolveStatus.UNRESOLVED;
    }

    public final boolean O00000Oo(Object obj) {
        return obj instanceof dsu;
    }

    public final boolean equals(Object obj) {
        boolean z = obj instanceof dsu;
        if (!z || !z || !this.f14906O000000o.equals(((dsu) obj).f14906O000000o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f14906O000000o.hashCode();
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        sb.append(this.f14906O000000o.toString());
    }

    public final AbstractConfigValue O00000Oo(dtf dtf) {
        AbstractConfigValue abstractConfigValue;
        dtf.f14918O000000o.O000000o(this, dth.O00000o0);
        try {
            abstractConfigValue = dtf.f14918O000000o.O000000o(dtf, this.f14906O000000o, this.O00000Oo);
        } catch (AbstractConfigValue.NotPossibleToResolve e) {
            if (this.f14906O000000o.O00000Oo) {
                abstractConfigValue = null;
            } else {
                dtj dtj = this.origin;
                throw new ConfigException.UnresolvedSubstitution(dtj, this.f14906O000000o + " was part of a cycle of substitutions involving " + e.traceString, e);
            }
        } catch (Throwable th) {
            dtf.f14918O000000o.O000000o(this);
            throw th;
        }
        if (abstractConfigValue != null || this.f14906O000000o.O00000Oo) {
            dtf.f14918O000000o.O000000o(this);
            return abstractConfigValue;
        } else if (dtf.O00000Oo.O00000Oo) {
            dtf.f14918O000000o.O000000o(this);
            return this;
        } else {
            throw new ConfigException.UnresolvedSubstitution(this.origin, this.f14906O000000o.toString());
        }
    }

    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new dsu(dsi, this.f14906O000000o, this.O00000Oo);
    }

    public final /* synthetic */ AbstractConfigValue O00000Oo(dtb dtb) {
        dtm dtm = this.f14906O000000o;
        dtb dtb2 = dtm.f14928O000000o;
        dtc dtc = new dtc();
        dtc.O000000o(dtb);
        dtc.O000000o(dtb2);
        return new dsu(this.origin, dtm.O000000o(dtc.O000000o()), this.O00000Oo + dtb.O00000o0());
    }
}
