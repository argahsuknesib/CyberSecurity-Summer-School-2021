package _m_j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public class isu extends AbstractMap<String, List<? extends isv>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final isu f1608O000000o = new O00000Oo();
    private transient Set<Map.Entry<String, List<? extends isv>>> O00000Oo;

    static final class O00000Oo extends isu {
        /* renamed from: O000000o */
        public final List<? extends isv> put(String str, List<? extends isv> list) {
            return null;
        }

        public final boolean containsKey(Object obj) {
            return false;
        }

        public final boolean containsValue(Object obj) {
            return false;
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final int hashCode() {
            return 0;
        }

        public final boolean isEmpty() {
            return true;
        }

        public final int size() {
            return 0;
        }

        O00000Oo() {
        }

        public final Set<String> keySet() {
            return Collections.emptySet();
        }

        public final Collection<List<? extends isv>> values() {
            return Collections.emptySet();
        }

        public final Set<Map.Entry<String, List<? extends isv>>> entrySet() {
            return Collections.emptySet();
        }

        public final boolean equals(Object obj) {
            return (obj instanceof Map) && ((Map) obj).size() == 0;
        }
    }

    public static class O000000o implements Map.Entry<String, List<? extends isv>> {

        /* renamed from: O000000o  reason: collision with root package name */
        private List<? extends isv> f1609O000000o;
        private String O00000Oo;

        public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
            List<? extends isv> list = this.f1609O000000o;
            this.f1609O000000o = (List) obj;
            return list;
        }

        protected O000000o(String str, List<? extends isv> list) {
            this.O00000Oo = str != null ? str.trim().toLowerCase() : null;
            this.f1609O000000o = list;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public String getKey() {
            String str = this.O00000Oo;
            return str != null ? str : "";
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!getKey().equals(entry.getKey()) || !this.f1609O000000o.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.O00000Oo;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final synchronized String toString() {
            StringBuilder sb;
            sb = new StringBuilder(200);
            sb.append("\n\t\tname '");
            sb.append(this.O00000Oo);
            sb.append("' ");
            if (this.f1609O000000o == null || this.f1609O000000o.isEmpty()) {
                sb.append(" no entries");
            } else {
                for (isv isv : this.f1609O000000o) {
                    sb.append("\n\t\t\t");
                    sb.append(isv.toString());
                }
            }
            return sb.toString();
        }

        public final /* bridge */ /* synthetic */ Object getValue() {
            return this.f1609O000000o;
        }
    }

    public isu() {
        this(1024);
    }

    private isu(isu isu) {
        this(isu.size());
        putAll(isu);
    }

    public isu(int i) {
        this.O00000Oo = null;
        this.O00000Oo = new HashSet(i);
    }

    public Set<Map.Entry<String, List<? extends isv>>> entrySet() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new HashSet();
        }
        return this.O00000Oo;
    }

    private Map.Entry<String, List<? extends isv>> O00000Oo(String str) {
        String lowerCase = str != null ? str.trim().toLowerCase() : null;
        for (Map.Entry<String, List<? extends isv>> next : entrySet()) {
            if (lowerCase != null) {
                if (lowerCase.equals(next.getKey())) {
                    return next;
                }
            } else if (next.getKey() == null) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: O000000o */
    public List<? extends isv> put(String str, List<? extends isv> list) {
        List<? extends isv> list2;
        synchronized (this) {
            list2 = null;
            Map.Entry<String, List<? extends isv>> O00000Oo2 = O00000Oo(str);
            if (O00000Oo2 != null) {
                list2 = O00000Oo2.setValue(list);
            } else {
                entrySet().add(new O000000o(str, list));
            }
        }
        return list2;
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return new isu(this);
    }

    public final synchronized Collection<isv> O000000o() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (List list : values()) {
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public final synchronized Collection<? extends isv> O000000o(String str) {
        Collection<? extends isv> collection;
        Collection<? extends isv> O00000o0 = O00000o0(str);
        if (O00000o0 != null) {
            collection = new ArrayList<>(O00000o0);
        } else {
            collection = Collections.emptyList();
        }
        return collection;
    }

    private Collection<? extends isv> O00000o0(String str) {
        return (Collection) get(str != null ? str.toLowerCase() : null);
    }

    public final synchronized isv O000000o(isv isv) {
        isv isv2;
        isv2 = null;
        if (isv != null) {
            Collection<? extends isv> O00000o0 = O00000o0(isv.O00000o());
            if (O00000o0 != null) {
                Iterator<? extends isv> it = O00000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    isv isv3 = (isv) it.next();
                    if (isv3.O000000o(isv)) {
                        isv2 = isv3;
                        break;
                    }
                }
            }
        }
        return isv2;
    }

    public final synchronized isv O000000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass) {
        isv isv;
        isv isv2;
        isv = null;
        Collection<? extends isv> O00000o0 = O00000o0(str);
        if (O00000o0 != null) {
            Iterator<? extends isv> it = O00000o0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                isv2 = (isv) it.next();
                if (!isv2.O00000oO().equals(dNSRecordType) || (DNSRecordClass.CLASS_ANY != dNSRecordClass && !isv2.O00000oo().equals(dNSRecordClass))) {
                }
            }
            isv = isv2;
        }
        return isv;
    }

    public final synchronized Collection<? extends isv> O00000Oo(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass) {
        Collection<? extends isv> collection;
        Collection<? extends isv> O00000o0 = O00000o0(str);
        if (O00000o0 != null) {
            collection = new ArrayList<>(O00000o0);
            Iterator<? extends isv> it = collection.iterator();
            while (it.hasNext()) {
                isv isv = (isv) it.next();
                if (!isv.O00000oO().equals(dNSRecordType) || (DNSRecordClass.CLASS_ANY != dNSRecordClass && !isv.O00000oo().equals(dNSRecordClass))) {
                    it.remove();
                }
            }
        } else {
            collection = Collections.emptyList();
        }
        return collection;
    }

    public final synchronized boolean O00000Oo(isv isv) {
        boolean z;
        ArrayList arrayList;
        z = false;
        if (isv != null) {
            Map.Entry<String, List<? extends isv>> O00000Oo2 = O00000Oo(isv.O00000o());
            if (O00000Oo2 != null) {
                arrayList = new ArrayList(O00000Oo2.getValue());
            } else {
                arrayList = new ArrayList();
            }
            arrayList.add(isv);
            if (O00000Oo2 != null) {
                O00000Oo2.setValue(arrayList);
            } else {
                entrySet().add(new O000000o(isv.O00000o(), arrayList));
            }
            z = true;
        }
        return z;
    }

    public final synchronized boolean O00000o0(isv isv) {
        boolean z;
        z = false;
        if (isv != null) {
            Map.Entry<String, List<? extends isv>> O00000Oo2 = O00000Oo(isv.O00000o());
            if (O00000Oo2 != null) {
                z = O00000Oo2.getValue().remove(isv);
                if (O00000Oo2.getValue().isEmpty()) {
                    entrySet().remove(O00000Oo2);
                }
            }
        }
        return z;
    }

    public final synchronized boolean O000000o(isv isv, isv isv2) {
        boolean z;
        ArrayList arrayList;
        z = false;
        if (!(isv == null || isv2 == null)) {
            if (isv.O00000o().equals(isv2.O00000o())) {
                Map.Entry<String, List<? extends isv>> O00000Oo2 = O00000Oo(isv.O00000o());
                if (O00000Oo2 != null) {
                    arrayList = new ArrayList(O00000Oo2.getValue());
                } else {
                    arrayList = new ArrayList();
                }
                arrayList.remove(isv2);
                arrayList.add(isv);
                if (O00000Oo2 != null) {
                    O00000Oo2.setValue(arrayList);
                } else {
                    entrySet().add(new O000000o(isv.O00000o(), arrayList));
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder(2000);
        sb.append("\t---- cache ----");
        for (Map.Entry<String, List<? extends isv>> obj : entrySet()) {
            sb.append("\n\t\t");
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
