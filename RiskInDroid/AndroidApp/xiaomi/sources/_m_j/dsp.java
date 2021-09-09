package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.SimpleConfigList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class dsp extends AbstractConfigValue implements dtp {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<AbstractConfigValue> f14894O000000o;

    public final boolean O0000OOo() {
        return false;
    }

    private dsp(dsi dsi, List<AbstractConfigValue> list) {
        super(dsi);
        this.f14894O000000o = list;
        if (list.size() >= 2) {
            boolean z = false;
            for (AbstractConfigValue next : list) {
                if (next instanceof dsp) {
                    throw new ConfigException.BugOrBroken("ConfigConcatenation should never be nested: ".concat(String.valueOf(this)));
                } else if (next instanceof dtp) {
                    z = true;
                }
            }
            if (!z) {
                throw new ConfigException.BugOrBroken("Created concatenation without an unmergeable in it: ".concat(String.valueOf(this)));
            }
            return;
        }
        throw new ConfigException.BugOrBroken("Created concatenation with less than 2 items: ".concat(String.valueOf(this)));
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

    public final Collection<dsp> h_() {
        return Collections.singleton(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dtj.O000000o(_m_j.dsi, _m_j.dsi):_m_j.dsi
     arg types: [_m_j.dtj, _m_j.dtj]
     candidates:
      _m_j.dtj.O000000o(_m_j.dtj, _m_j.dtj):_m_j.dtj
      _m_j.dtj.O000000o(java.util.Map<com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.Object>, java.util.Map<com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.Object>):java.util.Map<com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.Object>
      _m_j.dtj.O000000o(_m_j.dsi, _m_j.dsi):_m_j.dsi */
    private static List<AbstractConfigValue> O00000Oo(List<AbstractConfigValue> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList<AbstractConfigValue> arrayList = new ArrayList<>(list.size());
        for (AbstractConfigValue next : list) {
            if (next instanceof dsp) {
                arrayList.addAll(((dsp) next).f14894O000000o);
            } else {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (AbstractConfigValue abstractConfigValue : arrayList) {
            if (arrayList2.isEmpty()) {
                arrayList2.add(abstractConfigValue);
            } else {
                AbstractConfigValue abstractConfigValue2 = (AbstractConfigValue) arrayList2.get(arrayList2.size() - 1);
                if ((abstractConfigValue2 instanceof dsh) && (abstractConfigValue instanceof SimpleConfigList)) {
                    abstractConfigValue2 = dsv.O000000o(abstractConfigValue2, ConfigValueType.LIST);
                } else if ((abstractConfigValue2 instanceof SimpleConfigList) && (abstractConfigValue instanceof dsh)) {
                    abstractConfigValue = dsv.O000000o(abstractConfigValue, ConfigValueType.LIST);
                }
                Object obj = null;
                if ((abstractConfigValue2 instanceof dsh) && (abstractConfigValue instanceof dsh)) {
                    obj = abstractConfigValue.O00000o0(abstractConfigValue2);
                } else if ((abstractConfigValue2 instanceof SimpleConfigList) && (abstractConfigValue instanceof SimpleConfigList)) {
                    SimpleConfigList simpleConfigList = (SimpleConfigList) abstractConfigValue2;
                    SimpleConfigList simpleConfigList2 = (SimpleConfigList) abstractConfigValue;
                    dsi O000000o2 = dtj.O000000o((dsi) simpleConfigList.origin, (dsi) simpleConfigList2.origin);
                    ArrayList arrayList3 = new ArrayList(simpleConfigList.value.size() + simpleConfigList2.value.size());
                    arrayList3.addAll(simpleConfigList.value);
                    arrayList3.addAll(simpleConfigList2.value);
                    obj = new SimpleConfigList(O000000o2, arrayList3);
                } else if ((abstractConfigValue2 instanceof dsp) || (abstractConfigValue instanceof dsp)) {
                    throw new ConfigException.BugOrBroken("unflattened ConfigConcatenation");
                } else if (!(abstractConfigValue2 instanceof dtp) && !(abstractConfigValue instanceof dtp)) {
                    String O0000OoO = abstractConfigValue2.O0000OoO();
                    String O0000OoO2 = abstractConfigValue.O0000OoO();
                    if (O0000OoO == null || O0000OoO2 == null) {
                        dtj dtj = abstractConfigValue2.origin;
                        throw new ConfigException.WrongType(dtj, "Cannot concatenate object or list with a non-object-or-list, " + abstractConfigValue2 + " and " + abstractConfigValue + " are not compatible");
                    }
                    dsi O000000o3 = dtj.O000000o((dsi) abstractConfigValue2.origin, (dsi) abstractConfigValue.origin);
                    obj = new ConfigString(O000000o3, O0000OoO + O0000OoO2);
                }
                if (obj == null) {
                    arrayList2.add(abstractConfigValue);
                } else {
                    arrayList2.remove(arrayList2.size() - 1);
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    static AbstractConfigValue O000000o(List<AbstractConfigValue> list) {
        List<AbstractConfigValue> O00000Oo = O00000Oo(list);
        if (O00000Oo.isEmpty()) {
            return null;
        }
        if (O00000Oo.size() == 1) {
            return O00000Oo.get(0);
        }
        ArrayList arrayList = new ArrayList(O00000Oo.size());
        for (AbstractConfigValue abstractConfigValue : O00000Oo) {
            arrayList.add(abstractConfigValue.origin);
        }
        return new dsp(dtj.O000000o((Collection<? extends dsi>) arrayList), O00000Oo);
    }

    public final AbstractConfigValue O00000Oo(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        ArrayList arrayList = new ArrayList(this.f14894O000000o.size());
        for (AbstractConfigValue O000000o2 : this.f14894O000000o) {
            AbstractConfigValue O000000o3 = dtf.O000000o((dtb) null).O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        List<AbstractConfigValue> O00000Oo = O00000Oo((List<AbstractConfigValue>) arrayList);
        if (O00000Oo.size() > 1 && dtf.O00000Oo.O00000Oo) {
            return new dsp(this.origin, O00000Oo);
        }
        if (O00000Oo.size() == 1) {
            return O00000Oo.get(0);
        }
        throw new ConfigException.BugOrBroken("Resolved list should always join to exactly one value, not ".concat(String.valueOf(O00000Oo)));
    }

    public final ResolveStatus O0000O0o() {
        return ResolveStatus.UNRESOLVED;
    }

    public final boolean O00000Oo(Object obj) {
        return obj instanceof dsp;
    }

    public final boolean equals(Object obj) {
        boolean z = obj instanceof dsp;
        if (!z || !z || !this.f14894O000000o.equals(((dsp) obj).f14894O000000o)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f14894O000000o.hashCode();
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        for (AbstractConfigValue O000000o2 : this.f14894O000000o) {
            O000000o2.O000000o(sb, i, z, dsl);
        }
    }

    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new dsp(dsi, this.f14894O000000o);
    }

    public final /* synthetic */ AbstractConfigValue O00000Oo(dtb dtb) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue O00000Oo : this.f14894O000000o) {
            arrayList.add(O00000Oo.O00000Oo(dtb));
        }
        return new dsp(this.origin, arrayList);
    }
}
