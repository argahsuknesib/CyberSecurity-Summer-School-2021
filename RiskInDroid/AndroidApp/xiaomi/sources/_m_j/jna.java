package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.NOPLogger;

public final class jna implements jmw {

    /* renamed from: O000000o  reason: collision with root package name */
    final List f1967O000000o = new ArrayList();

    public final jmx O000000o(String str) {
        synchronized (this.f1967O000000o) {
            this.f1967O000000o.add(str);
        }
        return NOPLogger.f15480O000000o;
    }

    public final List O000000o() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1967O000000o) {
            arrayList.addAll(this.f1967O000000o);
        }
        return arrayList;
    }
}
