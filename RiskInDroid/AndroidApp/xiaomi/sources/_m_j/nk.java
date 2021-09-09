package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class nk {

    /* renamed from: O000000o  reason: collision with root package name */
    private List f2205O000000o = new ArrayList(5);

    public final int O000000o() {
        return this.f2205O000000o.size();
    }

    public final nm O000000o(int i) {
        return (nm) this.f2205O000000o.get(i);
    }

    public final void O000000o(nm nmVar) {
        this.f2205O000000o.add(nmVar);
    }

    public final String toString() {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 1; i2 < O000000o(); i2++) {
            stringBuffer.append(O000000o(i2));
            if (i2 < O000000o() - 1 && ((i = O000000o(i2 + 1).O00000Oo) == 1 || i == 2)) {
                stringBuffer.append('/');
            }
        }
        return stringBuffer.toString();
    }
}
