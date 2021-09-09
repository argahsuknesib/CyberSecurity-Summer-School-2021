package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class dpk {

    /* renamed from: O000000o  reason: collision with root package name */
    private Object[] f14839O000000o = new Object[6];

    public final void O000000o(dpl dpl) {
        List list = (List) this.f14839O000000o[0];
        if (list == null) {
            list = new ArrayList();
            this.f14839O000000o[0] = list;
        }
        list.add(dpl);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final boolean O000000o(int i, dpj dpj) {
        List list;
        boolean z = true;
        ? r1 = 0;
        boolean z2 = i >= 0;
        if (i >= 6) {
            z = false;
        }
        if ((z && z2) && (list = (List) this.f14839O000000o[i]) != null) {
            int size = list.size();
            boolean z3 = false;
            while (r1 < size) {
                z3 = ((dpl) list.get(r1)).O000000o(dpj);
                r1++;
            }
            r1 = z3;
        }
        if (dpj != null) {
            dpj.O000000o();
        }
        return r1;
    }
}
