package com.typesafe.config.impl;

import _m_j.dsf;
import _m_j.dsi;
import _m_j.dsl;
import _m_j.dsn;
import _m_j.dtb;
import _m_j.dtf;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class SimpleConfigList extends AbstractConfigValue implements dsf, Serializable {
    private static final long serialVersionUID = 2;
    private final boolean resolved;
    public final List<AbstractConfigValue> value;

    public SimpleConfigList(dsi dsi, List<AbstractConfigValue> list) {
        this(dsi, list, ResolveStatus.fromValues(list));
    }

    private SimpleConfigList(dsi dsi, List<AbstractConfigValue> list, ResolveStatus resolveStatus) {
        super(dsi);
        this.value = list;
        this.resolved = resolveStatus == ResolveStatus.RESOLVED;
        if (resolveStatus != ResolveStatus.fromValues(list)) {
            throw new ConfigException.BugOrBroken("SimpleConfigList created with wrong resolve status: ".concat(String.valueOf(this)));
        }
    }

    public final ConfigValueType O00000o0() {
        return ConfigValueType.LIST;
    }

    /* access modifiers changed from: package-private */
    public final ResolveStatus O0000O0o() {
        return ResolveStatus.fromBoolean(this.resolved);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O000000o, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList
     arg types: [com.typesafe.config.impl.AbstractConfigValue$O00000Oo, com.typesafe.config.impl.ResolveStatus]
     candidates:
      com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O00000Oo, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList
      com.typesafe.config.impl.AbstractConfigValue.O000000o(_m_j.dsi, java.util.List<com.typesafe.config.impl.AbstractConfigValue>):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dtp):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, com.typesafe.config.impl.AbstractConfigValue):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O000000o, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList */
    private SimpleConfigList O000000o(AbstractConfigValue.O00000Oo o00000Oo, ResolveStatus resolveStatus) {
        try {
            return O000000o((AbstractConfigValue.O000000o) o00000Oo, resolveStatus);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e2);
        }
    }

    private SimpleConfigList O000000o(AbstractConfigValue.O000000o o000000o, ResolveStatus resolveStatus) throws Exception {
        ArrayList arrayList = null;
        int i = 0;
        for (AbstractConfigValue next : this.value) {
            AbstractConfigValue O000000o2 = o000000o.O000000o(null, next);
            if (arrayList == null && O000000o2 != next) {
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(this.value.get(i2));
                }
            }
            if (!(arrayList == null || O000000o2 == null)) {
                arrayList.add(O000000o2);
            }
            i++;
        }
        return arrayList != null ? new SimpleConfigList(this.origin, arrayList, resolveStatus) : this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public SimpleConfigList O00000Oo(final dtf dtf) throws AbstractConfigValue.NotPossibleToResolve {
        if (this.resolved || dtf.O000000o()) {
            return this;
        }
        try {
            return O000000o(new AbstractConfigValue.O000000o() {
                /* class com.typesafe.config.impl.SimpleConfigList.AnonymousClass1 */

                public final AbstractConfigValue O000000o(String str, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
                    return dtf.O000000o(abstractConfigValue);
                }
            }, ResolveStatus.RESOLVED);
        } catch (AbstractConfigValue.NotPossibleToResolve e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e3);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(Object obj) {
        return obj instanceof SimpleConfigList;
    }

    public final boolean equals(Object obj) {
        boolean z = obj instanceof SimpleConfigList;
        if (!z || !z || !this.value.equals(((SimpleConfigList) obj).value)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StringBuilder sb, int i, boolean z, dsl dsl) {
        if (this.value.isEmpty()) {
            sb.append("[]");
            return;
        }
        sb.append("[");
        if (dsl.O00000o0) {
            sb.append(10);
        }
        for (AbstractConfigValue next : this.value) {
            if (dsl.f14892O000000o) {
                O000000o(sb, i + 1, dsl);
                sb.append("# ");
                sb.append(next.origin.O000000o());
                sb.append("\n");
            }
            if (dsl.O00000Oo) {
                for (String append : next.origin.O00000o0()) {
                    O000000o(sb, i + 1, dsl);
                    sb.append("# ");
                    sb.append(append);
                    sb.append("\n");
                }
            }
            int i2 = i + 1;
            O000000o(sb, i2, dsl);
            next.O000000o(sb, i2, z, dsl);
            sb.append(",");
            if (dsl.O00000o0) {
                sb.append(10);
            }
        }
        sb.setLength(sb.length() - 1);
        if (dsl.O00000o0) {
            sb.setLength(sb.length() - 1);
            sb.append(10);
            O000000o(sb, i, dsl);
        }
        sb.append("]");
    }

    public final boolean contains(Object obj) {
        return this.value.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.value.containsAll(collection);
    }

    public final int indexOf(Object obj) {
        return this.value.indexOf(obj);
    }

    public final boolean isEmpty() {
        return this.value.isEmpty();
    }

    public final Iterator<dsn> iterator() {
        final Iterator<AbstractConfigValue> it = this.value.iterator();
        return new Iterator<dsn>() {
            /* class com.typesafe.config.impl.SimpleConfigList.AnonymousClass3 */

            public final boolean hasNext() {
                return it.hasNext();
            }

            public final void remove() {
                throw SimpleConfigList.O000000o("iterator().remove");
            }

            public final /* bridge */ /* synthetic */ Object next() {
                return (dsn) it.next();
            }
        };
    }

    public final int lastIndexOf(Object obj) {
        return this.value.lastIndexOf(obj);
    }

    private static ListIterator<dsn> O000000o(final ListIterator<AbstractConfigValue> listIterator) {
        return new ListIterator<dsn>() {
            /* class com.typesafe.config.impl.SimpleConfigList.AnonymousClass4 */

            public final boolean hasNext() {
                return listIterator.hasNext();
            }

            public final void remove() {
                throw SimpleConfigList.O000000o("listIterator().remove");
            }

            public final boolean hasPrevious() {
                return listIterator.hasPrevious();
            }

            public final int nextIndex() {
                return listIterator.nextIndex();
            }

            public final int previousIndex() {
                return listIterator.previousIndex();
            }

            public final /* synthetic */ void add(Object obj) {
                throw SimpleConfigList.O000000o("listIterator().add");
            }

            public final /* synthetic */ void set(Object obj) {
                throw SimpleConfigList.O000000o("listIterator().set");
            }

            public final /* bridge */ /* synthetic */ Object previous() {
                return (dsn) listIterator.previous();
            }

            public final /* bridge */ /* synthetic */ Object next() {
                return (dsn) listIterator.next();
            }
        };
    }

    public final ListIterator<dsn> listIterator() {
        return O000000o(this.value.listIterator());
    }

    public final ListIterator<dsn> listIterator(int i) {
        return O000000o(this.value.listIterator(i));
    }

    public final int size() {
        return this.value.size();
    }

    public final List<dsn> subList(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue add : this.value.subList(i, i2)) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final Object[] toArray() {
        return this.value.toArray();
    }

    public final <T> T[] toArray(T[] tArr) {
        return this.value.toArray(tArr);
    }

    public static UnsupportedOperationException O000000o(String str) {
        return new UnsupportedOperationException("ConfigList is immutable, you can't call List.'" + str + "'");
    }

    public final boolean addAll(Collection<? extends dsn> collection) {
        throw O000000o("addAll");
    }

    public final boolean addAll(int i, Collection<? extends dsn> collection) {
        throw O000000o("addAll");
    }

    public final void clear() {
        throw O000000o("clear");
    }

    public final boolean remove(Object obj) {
        throw O000000o("remove");
    }

    public final boolean removeAll(Collection<?> collection) {
        throw O000000o("removeAll");
    }

    public final boolean retainAll(Collection<?> collection) {
        throw O000000o("retainAll");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi) {
        return new SimpleConfigList(dsi, this.value);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O00000Oo, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList
     arg types: [com.typesafe.config.impl.SimpleConfigList$2, com.typesafe.config.impl.ResolveStatus]
     candidates:
      com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O000000o, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList
      com.typesafe.config.impl.AbstractConfigValue.O000000o(_m_j.dsi, java.util.List<com.typesafe.config.impl.AbstractConfigValue>):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dso):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, _m_j.dtp):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.AbstractConfigValue.O000000o(java.util.Collection<com.typesafe.config.impl.AbstractConfigValue>, com.typesafe.config.impl.AbstractConfigValue):com.typesafe.config.impl.AbstractConfigValue
      com.typesafe.config.impl.SimpleConfigList.O000000o(com.typesafe.config.impl.AbstractConfigValue$O00000Oo, com.typesafe.config.impl.ResolveStatus):com.typesafe.config.impl.SimpleConfigList */
    /* access modifiers changed from: package-private */
    public final /* synthetic */ AbstractConfigValue O00000Oo(final dtb dtb) {
        return O000000o((AbstractConfigValue.O00000Oo) new AbstractConfigValue.O00000Oo() {
            /* class com.typesafe.config.impl.SimpleConfigList.AnonymousClass2 */

            public final AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) {
                return abstractConfigValue.O00000Oo(dtb);
            }
        }, ResolveStatus.fromBoolean(this.resolved));
    }

    public final /* synthetic */ Object O00000o() {
        ArrayList arrayList = new ArrayList();
        for (AbstractConfigValue O00000o : this.value) {
            arrayList.add(O00000o.O00000o());
        }
        return arrayList;
    }

    public final /* synthetic */ Object remove(int i) {
        throw O000000o("remove");
    }

    public final /* synthetic */ void add(int i, Object obj) {
        throw O000000o("add");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        throw O000000o("set");
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.value.get(i);
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw O000000o("add");
    }
}
