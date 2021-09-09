package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ResolveStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class dsr extends dso implements dte, dtp {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<AbstractConfigValue> f14897O000000o;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001e  */
    dsr(dsi dsi, List<AbstractConfigValue> list) {
        super(dsi);
        this.f14897O000000o = list;
        if (list.isEmpty()) {
            throw new ConfigException.BugOrBroken("creating empty delayed merge object");
        } else if (list.get(0) instanceof dso) {
            for (AbstractConfigValue next : list) {
                if ((next instanceof dsq) || (next instanceof dsr)) {
                    throw new ConfigException.BugOrBroken("placed nested DelayedMerge in a ConfigDelayedMergeObject, should have consolidated stack");
                }
                while (r2.hasNext()) {
                }
            }
        } else {
            throw new ConfigException.BugOrBroken("created a delayed merge object not guaranteed to be an object");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O000000o */
    public final dso O00000Oo(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        AbstractConfigValue O000000o2 = dsq.O000000o(this, this.f14897O000000o, dtf);
        if (O000000o2 instanceof dso) {
            return (dso) O000000o2;
        }
        throw new ConfigException.BugOrBroken("somehow brokenly merged an object and didn't get an object, got ".concat(String.valueOf(O000000o2)));
    }

    public final dth O000000o(final int i) {
        return new dth() {
            /* class _m_j.dsr.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final AbstractConfigValue O000000o(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
                return dsq.O000000o(dtf, dsr.this.f14897O000000o, i);
            }
        };
    }

    public final ResolveStatus O0000O0o() {
        return ResolveStatus.UNRESOLVED;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public dsr O00000Oo(dtb dtb) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue O00000Oo : this.f14897O000000o) {
            arrayList.add(O00000Oo.O00000Oo(dtb));
        }
        return new dsr(this.origin, arrayList);
    }

    public final boolean O0000OOo() {
        return dsq.O000000o(this.f14897O000000o);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public dsr O000000o(AbstractConfigValue abstractConfigValue) {
        O0000Oo();
        return (dsr) O000000o(this.f14897O000000o, abstractConfigValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public dsr O00000o0(dsg dsg) {
        return (dsr) super.O00000o0(dsg);
    }

    public final Collection<AbstractConfigValue> h_() {
        return this.f14897O000000o;
    }

    public final boolean O00000Oo(Object obj) {
        return obj instanceof dsr;
    }

    public final boolean equals(Object obj) {
        boolean z = obj instanceof dsr;
        if (!z || !z || !this.f14897O000000o.equals(((dsr) obj).f14897O000000o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f14897O000000o.hashCode();
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, String str, dsl dsl) {
        dsq.O000000o(this.f14897O000000o, sb, i, z, str, dsl);
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        O000000o(sb, i, z, null, dsl);
    }

    private static ConfigException O0000Ooo() {
        return new ConfigException.NotResolved("need to Config#resolve() before using this object, see the API docs for Config#resolve()");
    }

    public final AbstractConfigValue O000000o(Object obj) {
        throw O0000Ooo();
    }

    public final boolean containsKey(Object obj) {
        throw O0000Ooo();
    }

    public final boolean containsValue(Object obj) {
        throw O0000Ooo();
    }

    public final Set<Map.Entry<String, dsn>> entrySet() {
        throw O0000Ooo();
    }

    public final boolean isEmpty() {
        throw O0000Ooo();
    }

    public final Set<String> keySet() {
        throw O0000Ooo();
    }

    public final int size() {
        throw O0000Ooo();
    }

    public final Collection<dsn> values() {
        throw O0000Ooo();
    }

    /* access modifiers changed from: protected */
    public final AbstractConfigValue O000000o(String str) {
        for (AbstractConfigValue next : this.f14897O000000o) {
            if (next instanceof dso) {
                AbstractConfigValue O000000o2 = ((dso) next).O000000o(str);
                if (O000000o2 != null) {
                    if (O000000o2.O0000OOo()) {
                        return O000000o2;
                    }
                } else if (next instanceof dtp) {
                    throw new ConfigException.BugOrBroken("should not be reached: unmergeable object returned null value");
                }
            } else if (next instanceof dtp) {
                throw new ConfigException.NotResolved("Key '" + str + "' is not available at '" + this.origin.O000000o() + "' because value at '" + next.origin.O000000o() + "' has not been resolved and may turn out to contain or hide '" + str + "'. Be sure to Config#resolve() before using a config object.");
            } else if (next.O0000O0o() == ResolveStatus.UNRESOLVED) {
                if (next instanceof dsf) {
                    return null;
                }
                throw new ConfigException.BugOrBroken("Expecting a list here, not ".concat(String.valueOf(next)));
            } else if (next.O0000OOo()) {
                return null;
            } else {
                throw new ConfigException.BugOrBroken("resolved non-object should ignore fallbacks");
            }
        }
        throw new ConfigException.BugOrBroken("Delayed merge stack does not contain any unmergeable values");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ dso O000000o(dso dso) {
        return O000000o((AbstractConfigValue) dso);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ dso O000000o(ResolveStatus resolveStatus, dsi dsi) {
        if (resolveStatus == ResolveStatus.UNRESOLVED) {
            return new dsr(dsi, this.f14897O000000o);
        }
        throw new ConfigException.BugOrBroken("attempt to create resolved ConfigDelayedMergeObject");
    }

    public final /* synthetic */ Object O00000o() {
        throw O0000Ooo();
    }

    public final /* synthetic */ Object get(Object obj) {
        throw O0000Ooo();
    }

    public final /* bridge */ /* synthetic */ AbstractConfigValue O00000Oo(dso dso) {
        return O000000o((AbstractConfigValue) dso);
    }

    public final /* synthetic */ AbstractConfigValue O000000o(dtp dtp) {
        O0000Oo();
        return (dsr) O000000o(this.f14897O000000o, dtp);
    }
}
