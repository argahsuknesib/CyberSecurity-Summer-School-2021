package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.SimpleConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class dso extends AbstractConfigValue implements dsh {
    public final SimpleConfig config = new SimpleConfig(this);

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public abstract dso O00000Oo(dso dso);

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public abstract dso O00000Oo(dtb dtb);

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public abstract dso O00000Oo(dtf dtf) throws AbstractConfigValue.NotPossibleToResolve;

    /* access modifiers changed from: protected */
    public abstract dso O000000o(ResolveStatus resolveStatus, dsi dsi);

    /* renamed from: O000000o */
    public abstract AbstractConfigValue get(Object obj);

    /* access modifiers changed from: protected */
    public abstract AbstractConfigValue O000000o(String str);

    public abstract void O000000o(StringBuilder sb, int i, boolean z, dsl dsl);

    public final /* bridge */ /* synthetic */ AbstractConfigValue O00000oO() {
        return this;
    }

    public final /* bridge */ /* synthetic */ dsn O00000oo() {
        return this;
    }

    protected dso(dsi dsi) {
        super(dsi);
    }

    static AbstractConfigValue O000000o(dso dso, dtb dtb, dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        if (dtf != null) {
            try {
                AbstractConfigValue O000000o2 = dtf.O000000o(dtb).O000000o(dso);
                if (O000000o2 instanceof dso) {
                    return O000000o((dso) O000000o2, dtb, (dtf) null);
                }
                throw new ConfigException.BugOrBroken("resolved object to non-object " + dso + " to " + O000000o2);
            } catch (ConfigException.NotResolved e) {
                throw dss.O000000o(dtb, e);
            }
        } else {
            dtb dtb2 = dtb.O00000Oo;
            AbstractConfigValue O000000o3 = dso.O000000o(dtb.f14916O000000o);
            if (dtb2 == null) {
                return O000000o3;
            }
            if (O000000o3 instanceof dso) {
                return O000000o((dso) O000000o3, dtb2, (dtf) null);
            }
            return null;
        }
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.OBJECT;
    }

    /* renamed from: O00000Oo */
    public dso O00000o0(dsg dsg) {
        return (dso) super.O00000o0(dsg);
    }

    public static dsi O000000o(Collection<? extends AbstractConfigValue> collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            dtj dtj = null;
            int i = 0;
            for (AbstractConfigValue abstractConfigValue : collection) {
                if (dtj == null) {
                    dtj = abstractConfigValue.origin;
                }
                if (!(abstractConfigValue instanceof dso) || ((dso) abstractConfigValue).O0000O0o() != ResolveStatus.RESOLVED || !((dsh) abstractConfigValue).isEmpty()) {
                    arrayList.add(abstractConfigValue.origin);
                    i++;
                }
            }
            if (i == 0) {
                arrayList.add(dtj);
            }
            return dtj.O000000o((Collection<? extends dsi>) arrayList);
        }
        throw new ConfigException.BugOrBroken("can't merge origins on empty list");
    }

    protected static dsi O000000o(dso... dsoArr) {
        return O000000o((Collection<? extends AbstractConfigValue>) Arrays.asList(dsoArr));
    }

    private static UnsupportedOperationException O00000Oo(String str) {
        return new UnsupportedOperationException("ConfigObject is immutable, you can't call Map.".concat(String.valueOf(str)));
    }

    public void clear() {
        throw O00000Oo("clear");
    }

    public void putAll(Map<? extends String, ? extends dsn> map) {
        throw O00000Oo("putAll");
    }

    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi, List list) {
        return new dsr(dsi, list);
    }

    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return O000000o(O0000O0o(), dsi);
    }

    public final /* bridge */ /* synthetic */ dry O000000o() {
        return this.config;
    }

    public /* synthetic */ Object remove(Object obj) {
        throw O00000Oo("remove");
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw O00000Oo("put");
    }
}
