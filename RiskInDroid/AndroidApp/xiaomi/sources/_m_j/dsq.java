package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ResolveStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class dsq extends AbstractConfigValue implements dte, dtp {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<AbstractConfigValue> f14895O000000o;

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0015  */
    public dsq(dsi dsi, List<AbstractConfigValue> list) {
        super(dsi);
        this.f14895O000000o = list;
        if (!list.isEmpty()) {
            for (AbstractConfigValue next : list) {
                if ((next instanceof dsq) || (next instanceof dsr)) {
                    throw new ConfigException.BugOrBroken("placed nested DelayedMerge in a ConfigDelayedMerge, should have consolidated stack");
                }
                while (r2.hasNext()) {
                }
            }
            return;
        }
        throw new ConfigException.BugOrBroken("creating empty delayed merge value");
    }

    public final ConfigValueType O00000o0() {
        throw new ConfigException.NotResolved("called valueType() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    public final Object O00000o() {
        throw new ConfigException.NotResolved("called unwrapped() on value with unresolved substitutions, need to Config#resolve() first, see API docs");
    }

    public final AbstractConfigValue O00000Oo(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        return O000000o(this, this.f14895O000000o, dtf);
    }

    static AbstractConfigValue O000000o(dte dte, List<AbstractConfigValue> list, dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        boolean z;
        AbstractConfigValue abstractConfigValue = null;
        int i = 0;
        for (AbstractConfigValue next : list) {
            if (!(next instanceof dte)) {
                if (next instanceof dtp) {
                    dtf.f14918O000000o.O000000o((AbstractConfigValue) dte, dte.O000000o(i + 1));
                    z = true;
                } else {
                    z = false;
                }
                try {
                    AbstractConfigValue O000000o2 = dtf.O000000o(next);
                    if (z) {
                        dtf.f14918O000000o.O000000o((AbstractConfigValue) dte);
                    }
                    if (O000000o2 != null) {
                        if (abstractConfigValue == null) {
                            abstractConfigValue = O000000o2;
                        } else {
                            abstractConfigValue = abstractConfigValue.O00000o0(O000000o2);
                        }
                    }
                    i++;
                } catch (Throwable th) {
                    if (z) {
                        dtf.f14918O000000o.O000000o((AbstractConfigValue) dte);
                    }
                    throw th;
                }
            } else {
                throw new ConfigException.BugOrBroken("A delayed merge should not contain another one: ".concat(String.valueOf(dte)));
            }
        }
        return abstractConfigValue;
    }

    public final dth O000000o(final int i) {
        return new dth() {
            /* class _m_j.dsq.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final AbstractConfigValue O000000o(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
                return dsq.O000000o(dtf, dsq.this.f14895O000000o, i);
            }
        };
    }

    static AbstractConfigValue O000000o(dtf dtf, List<AbstractConfigValue> list, int i) throws AbstractConfigValue.NotPossibleToResolve {
        List<AbstractConfigValue> subList = list.subList(i, list.size());
        if (!subList.isEmpty()) {
            AbstractConfigValue abstractConfigValue = null;
            for (AbstractConfigValue next : subList) {
                if (abstractConfigValue == null) {
                    abstractConfigValue = next;
                } else {
                    abstractConfigValue = abstractConfigValue.O00000o0(next);
                }
            }
            return abstractConfigValue;
        }
        throw new AbstractConfigValue.NotPossibleToResolve(dtf);
    }

    public final ResolveStatus O0000O0o() {
        return ResolveStatus.UNRESOLVED;
    }

    static boolean O000000o(List<AbstractConfigValue> list) {
        return list.get(list.size() - 1).O0000OOo();
    }

    public final boolean O0000OOo() {
        return O000000o(this.f14895O000000o);
    }

    public final AbstractConfigValue O000000o(dsi dsi) {
        return new dsq(dsi, this.f14895O000000o);
    }

    public final Collection<AbstractConfigValue> h_() {
        return this.f14895O000000o;
    }

    public final boolean O00000Oo(Object obj) {
        return obj instanceof dsq;
    }

    public final boolean equals(Object obj) {
        boolean z = obj instanceof dsq;
        if (!z || !z || !this.f14895O000000o.equals(((dsq) obj).f14895O000000o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f14895O000000o.hashCode();
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, String str, dsl dsl) {
        O000000o(this.f14895O000000o, sb, i, z, str, dsl);
    }

    static void O000000o(List<AbstractConfigValue> list, StringBuilder sb, int i, boolean z, String str, dsl dsl) {
        boolean z2 = dsl.O00000Oo;
        if (z2) {
            sb.append("# unresolved merge of " + list.size() + " values follows (\n");
            if (str == null) {
                O000000o(sb, i, dsl);
                sb.append("# this unresolved merge will not be parseable because it's at the root of the object\n");
                O000000o(sb, i, dsl);
                sb.append("# the HOCON format has no way to list multiple root objects in a single file\n");
            }
        }
        ArrayList<AbstractConfigValue> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        Collections.reverse(arrayList);
        int i2 = 0;
        for (AbstractConfigValue abstractConfigValue : arrayList) {
            if (z2) {
                O000000o(sb, i, dsl);
                if (str != null) {
                    sb.append("#     unmerged value " + i2 + " for key " + dst.O000000o(str) + " from ");
                } else {
                    sb.append("#     unmerged value " + i2 + " from ");
                }
                i2++;
                sb.append(abstractConfigValue.origin.O000000o());
                sb.append("\n");
                for (String append : abstractConfigValue.origin.O00000o0()) {
                    O000000o(sb, i, dsl);
                    sb.append("# ");
                    sb.append(append);
                    sb.append("\n");
                }
            }
            O000000o(sb, i, dsl);
            if (str != null) {
                sb.append(dst.O000000o(str));
                if (dsl.O00000o0) {
                    sb.append(" : ");
                } else {
                    sb.append(":");
                }
            }
            abstractConfigValue.O000000o(sb, i, z, dsl);
            sb.append(",");
            if (dsl.O00000o0) {
                sb.append(10);
            }
        }
        sb.setLength(sb.length() - 1);
        if (dsl.O00000o0) {
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        if (z2) {
            O000000o(sb, i, dsl);
            sb.append("# ) end of unresolved merge\n");
        }
    }

    public final /* bridge */ /* synthetic */ AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) {
        return (dsq) O000000o(this.f14895O000000o, abstractConfigValue);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso):com.typesafe.config.impl.AbstractConfigValue
     arg types: [java.util.List<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso]
     candidates:
      com.typesafe.config.impl.AbstractConfigValue.O000000o(_m_j.dsi, java.util.List<com.typesafe.config.impl.AbstractConfigValue>):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dtp):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, com.typesafe.config.impl.AbstractConfigValue):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso):com.typesafe.config.impl.AbstractConfigValue */
    public final /* synthetic */ AbstractConfigValue O00000Oo(dso dso) {
        return (dsq) O000000o((Collection<AbstractConfigValue>) this.f14895O000000o, dso);
    }

    public final /* bridge */ /* synthetic */ AbstractConfigValue O000000o(dtp dtp) {
        return (dsq) O000000o(this.f14895O000000o, dtp);
    }

    public final /* synthetic */ AbstractConfigValue O00000Oo(dtb dtb) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue O00000Oo : this.f14895O000000o) {
            arrayList.add(O00000Oo.O00000Oo(dtb));
        }
        return new dsq(this.origin, arrayList);
    }
}
