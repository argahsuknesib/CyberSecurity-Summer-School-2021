package _m_j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class xu {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<xr> f2599O000000o = new ArrayList();

    public final <T extends xr> void O000000o(xr xrVar) {
        this.f2599O000000o.add(xrVar);
    }

    public final <T extends xr> T O000000o(Class cls) {
        Iterator<xr> it = this.f2599O000000o.iterator();
        while (it.hasNext()) {
            T t = (xr) it.next();
            if (cls.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public final String toString() {
        int size = this.f2599O000000o.size();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(size);
        objArr[1] = size == 1 ? "directory" : "directories";
        return String.format("Metadata (%d %s)", objArr);
    }
}
