package _m_j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class igi {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<Integer, Integer> f1271O000000o = new HashMap();

    igi() {
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        Integer num = this.f1271O000000o.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f1271O000000o.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    public final int[] O000000o() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry next : this.f1271O000000o.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i) {
                i = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i) {
                arrayList.add(next.getKey());
            }
        }
        return ige.O000000o(arrayList);
    }
}
