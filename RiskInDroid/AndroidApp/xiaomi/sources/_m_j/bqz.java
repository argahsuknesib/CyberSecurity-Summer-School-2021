package _m_j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class bqz implements Iterable<bqy> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<bqy> f13210O000000o = new LinkedList();
    private final Map<String, List<bqy>> O00000Oo = new HashMap();

    public final bqy O000000o(String str) {
        List list = this.O00000Oo.get(str.toLowerCase(Locale.US));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bqy) list.get(0);
    }

    public final Iterator<bqy> iterator() {
        return Collections.unmodifiableList(this.f13210O000000o).iterator();
    }

    public final String toString() {
        return this.f13210O000000o.toString();
    }

    public final void O000000o(bqy bqy) {
        String lowerCase = bqy.f13209O000000o.toLowerCase(Locale.US);
        List list = this.O00000Oo.get(lowerCase);
        if (list == null) {
            list = new LinkedList();
            this.O00000Oo.put(lowerCase, list);
        }
        list.add(bqy);
        this.f13210O000000o.add(bqy);
    }
}
