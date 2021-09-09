package com.typesafe.config.impl;

import _m_j.dsh;
import _m_j.dsi;
import _m_j.dsl;
import _m_j.dsn;
import _m_j.dso;
import _m_j.dtb;
import _m_j.dtf;
import _m_j.dtj;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class SimpleConfigObject extends dso implements Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final SimpleConfigObject f5927O000000o = O00000o0(dtj.O000000o("empty config"));
    private static final long serialVersionUID = 2;
    private final boolean ignoresFallbacks;
    private final boolean resolved;
    private final Map<String, AbstractConfigValue> value;

    public SimpleConfigObject(dsi dsi, Map<String, AbstractConfigValue> map, ResolveStatus resolveStatus, boolean z) {
        super(dsi);
        if (map != null) {
            this.value = map;
            this.resolved = resolveStatus == ResolveStatus.RESOLVED;
            this.ignoresFallbacks = z;
            if (resolveStatus != ResolveStatus.fromValues(map.values())) {
                throw new ConfigException.BugOrBroken("Wrong resolved status on ".concat(String.valueOf(this)));
            }
            return;
        }
        throw new ConfigException.BugOrBroken("creating config object with null map");
    }

    public SimpleConfigObject(dsi dsi, Map<String, AbstractConfigValue> map) {
        this(dsi, map, ResolveStatus.fromValues(map.values()), false);
    }

    public final AbstractConfigValue O000000o(String str) {
        return this.value.get(str);
    }

    private SimpleConfigObject O000000o(ResolveStatus resolveStatus, dsi dsi, boolean z) {
        return new SimpleConfigObject(dsi, this.value, resolveStatus, z);
    }

    /* access modifiers changed from: package-private */
    public final ResolveStatus O0000O0o() {
        return ResolveStatus.fromBoolean(this.resolved);
    }

    /* access modifiers changed from: protected */
    public final boolean O0000OOo() {
        return this.ignoresFallbacks;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public SimpleConfigObject O00000Oo(dso dso) {
        O0000Oo();
        if (dso instanceof SimpleConfigObject) {
            SimpleConfigObject simpleConfigObject = (SimpleConfigObject) dso;
            HashMap hashMap = new HashMap();
            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(keySet());
            hashSet.addAll(simpleConfigObject.keySet());
            boolean z = true;
            boolean z2 = false;
            for (String str : hashSet) {
                AbstractConfigValue abstractConfigValue = this.value.get(str);
                AbstractConfigValue abstractConfigValue2 = simpleConfigObject.value.get(str);
                if (abstractConfigValue != null) {
                    abstractConfigValue2 = abstractConfigValue2 == null ? abstractConfigValue : abstractConfigValue.O00000o0(abstractConfigValue2);
                }
                hashMap.put(str, abstractConfigValue2);
                if (abstractConfigValue != abstractConfigValue2) {
                    z2 = true;
                }
                if (abstractConfigValue2.O0000O0o() == ResolveStatus.UNRESOLVED) {
                    z = false;
                }
            }
            ResolveStatus fromBoolean = ResolveStatus.fromBoolean(z);
            boolean z3 = simpleConfigObject.ignoresFallbacks;
            if (z2) {
                return new SimpleConfigObject(O000000o(this, simpleConfigObject), hashMap, fromBoolean, z3);
            } else if (fromBoolean == ResolveStatus.fromBoolean(this.resolved) && z3 == this.ignoresFallbacks) {
                return this;
            } else {
                return O000000o(fromBoolean, this.origin, z3);
            }
        } else {
            throw new ConfigException.BugOrBroken("should not be reached (merging non-SimpleConfigObject)");
        }
    }

    private SimpleConfigObject O000000o(AbstractConfigValue.O00000Oo o00000Oo) {
        try {
            return O000000o((AbstractConfigValue.O000000o) o00000Oo);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e2);
        }
    }

    private SimpleConfigObject O000000o(AbstractConfigValue.O000000o o000000o) throws Exception {
        ResolveStatus resolveStatus;
        HashMap hashMap = null;
        for (String next : keySet()) {
            AbstractConfigValue abstractConfigValue = this.value.get(next);
            AbstractConfigValue O000000o2 = o000000o.O000000o(next, abstractConfigValue);
            if (O000000o2 != abstractConfigValue) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(next, O000000o2);
            }
        }
        if (hashMap == null) {
            return this;
        }
        HashMap hashMap2 = new HashMap();
        boolean z = false;
        for (String next2 : keySet()) {
            if (hashMap.containsKey(next2)) {
                AbstractConfigValue abstractConfigValue2 = (AbstractConfigValue) hashMap.get(next2);
                if (abstractConfigValue2 != null) {
                    hashMap2.put(next2, abstractConfigValue2);
                    if (abstractConfigValue2.O0000O0o() != ResolveStatus.UNRESOLVED) {
                    }
                }
            } else {
                AbstractConfigValue abstractConfigValue3 = this.value.get(next2);
                hashMap2.put(next2, abstractConfigValue3);
                if (abstractConfigValue3.O0000O0o() != ResolveStatus.UNRESOLVED) {
                }
            }
            z = true;
        }
        dtj dtj = this.origin;
        if (z) {
            resolveStatus = ResolveStatus.UNRESOLVED;
        } else {
            resolveStatus = ResolveStatus.RESOLVED;
        }
        return new SimpleConfigObject(dtj, hashMap2, resolveStatus, this.ignoresFallbacks);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public SimpleConfigObject O00000Oo(final dtb dtb) {
        return O000000o((AbstractConfigValue.O00000Oo) new AbstractConfigValue.O00000Oo() {
            /* class com.typesafe.config.impl.SimpleConfigObject.AnonymousClass2 */

            public final AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) {
                return abstractConfigValue.O00000Oo(dtb);
            }
        });
    }

    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        int i2;
        int i3;
        StringBuilder sb2 = sb;
        int i4 = i;
        dsl dsl2 = dsl;
        if (isEmpty()) {
            sb2.append("{}");
        } else {
            int i5 = 0;
            boolean z2 = dsl2.O00000o || !z;
            if (z2) {
                int i6 = i4 + 1;
                sb2.append("{");
                if (dsl2.O00000o0) {
                    sb2.append(10);
                }
                i2 = i6;
            } else {
                i2 = i4;
            }
            String[] strArr = (String[]) keySet().toArray(new String[size()]);
            Arrays.sort(strArr);
            for (String str : strArr) {
                AbstractConfigValue abstractConfigValue = this.value.get(str);
                if (dsl2.f14892O000000o) {
                    O000000o(sb2, i2, dsl2);
                    sb2.append("# ");
                    sb2.append(abstractConfigValue.origin.O000000o());
                    sb2.append("\n");
                }
                if (dsl2.O00000Oo) {
                    for (String next : abstractConfigValue.origin.O00000o0()) {
                        O000000o(sb2, i2, dsl2);
                        sb2.append("#");
                        if (!next.startsWith(" ")) {
                            sb2.append(' ');
                        }
                        sb2.append(next);
                        sb2.append("\n");
                    }
                }
                O000000o(sb2, i2, dsl2);
                abstractConfigValue.O000000o(sb, i2, false, str, dsl);
                if (dsl2.O00000o0) {
                    if (dsl2.O00000o) {
                        sb2.append(",");
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    sb2.append(10);
                    i5 = i3;
                } else {
                    sb2.append(",");
                    i5 = 1;
                }
            }
            sb2.setLength(sb.length() - i5);
            if (z2) {
                if (dsl2.O00000o0) {
                    sb2.append(10);
                    if (z2) {
                        O000000o(sb2, i4, dsl2);
                    }
                }
                sb2.append("}");
            }
        }
        if (z && dsl2.O00000o0) {
            sb2.append(10);
        }
    }

    /* renamed from: O000000o */
    public final AbstractConfigValue get(Object obj) {
        return this.value.get(obj);
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(Object obj) {
        return obj instanceof dsh;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2 = obj instanceof dsh;
        if (z2 && z2) {
            dsh dsh = (dsh) obj;
            Set keySet = keySet();
            if (!keySet.equals(dsh.keySet())) {
                z = false;
            } else {
                Iterator it = keySet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String str = (String) it.next();
                    if (!((dsn) get(str)).equals(dsh.get(str))) {
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsKey(Object obj) {
        return this.value.containsKey(obj);
    }

    public final Set<String> keySet() {
        return this.value.keySet();
    }

    public final boolean containsValue(Object obj) {
        return this.value.containsValue(obj);
    }

    public final Set<Map.Entry<String, dsn>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : this.value.entrySet()) {
            hashSet.add(new AbstractMap.SimpleImmutableEntry(next.getKey(), next.getValue()));
        }
        return hashSet;
    }

    public final boolean isEmpty() {
        return this.value.isEmpty();
    }

    public final int size() {
        return this.value.size();
    }

    public final Collection<dsn> values() {
        return new HashSet(this.value.values());
    }

    public static final SimpleConfigObject O00000o(dsi dsi) {
        return new SimpleConfigObject(dtj.O000000o(dsi.O000000o() + " (not found)"), Collections.emptyMap());
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    /* renamed from: O000000o */
    public final dso O00000Oo(final dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        if (ResolveStatus.fromBoolean(this.resolved) == ResolveStatus.RESOLVED) {
            return this;
        }
        try {
            return O000000o((AbstractConfigValue.O000000o) new AbstractConfigValue.O000000o() {
                /* class com.typesafe.config.impl.SimpleConfigObject.AnonymousClass1 */

                public final AbstractConfigValue O000000o(String str, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
                    dtb dtb;
                    if (dtf.O000000o()) {
                        return (!str.equals(dtf.O00000o0.f14916O000000o) || (dtb = dtf.O00000o0.O00000Oo) == null) ? abstractConfigValue : dtf.O000000o(dtb).O000000o(abstractConfigValue);
                    }
                    return dtf.O000000o((dtb) null).O000000o(abstractConfigValue);
                }
            });
        } catch (AbstractConfigValue.NotPossibleToResolve e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e3);
        }
    }

    public final int hashCode() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(keySet());
        Collections.sort(arrayList);
        int i = 0;
        for (String str : arrayList) {
            i += ((dsn) get(str)).hashCode();
        }
        return ((arrayList.hashCode() + 41) * 41) + i;
    }

    public static final SimpleConfigObject O00000o0(dsi dsi) {
        if (dsi == null) {
            return f5927O000000o;
        }
        return new SimpleConfigObject(dsi, Collections.emptyMap());
    }

    public final /* bridge */ /* synthetic */ dso O000000o(ResolveStatus resolveStatus, dsi dsi) {
        return O000000o(resolveStatus, dsi, this.ignoresFallbacks);
    }

    public final /* synthetic */ Object O00000o() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.value.entrySet()) {
            hashMap.put(next.getKey(), ((AbstractConfigValue) next.getValue()).O00000o());
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.typesafe.config.impl.SimpleConfigObject.O000000o(com.typesafe.config.impl.ResolveStatus, _m_j.dsi, boolean):com.typesafe.config.impl.SimpleConfigObject
     arg types: [com.typesafe.config.impl.ResolveStatus, _m_j.dtj, int]
     candidates:
      _m_j.dso.O000000o(_m_j.dso, _m_j.dtb, _m_j.dtf):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.lang.StringBuilder, int, _m_j.dsl):void
      com.typesafe.config.impl.SimpleConfigObject.O000000o(com.typesafe.config.impl.ResolveStatus, _m_j.dsi, boolean):com.typesafe.config.impl.SimpleConfigObject */
    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O0000Oo0() {
        if (this.ignoresFallbacks) {
            return this;
        }
        return O000000o(ResolveStatus.fromBoolean(this.resolved), (dsi) this.origin, true);
    }
}
