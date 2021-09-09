package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class ieb {

    /* renamed from: O000000o  reason: collision with root package name */
    public final idy f1226O000000o;
    private final List<idz> O00000Oo = new ArrayList();

    public ieb(idy idy) {
        this.f1226O000000o = idy;
        this.O00000Oo.add(new idz(idy, new int[]{1}));
    }

    public final idz O000000o(int i) {
        if (i >= this.O00000Oo.size()) {
            List<idz> list = this.O00000Oo;
            idz idz = list.get(list.size() - 1);
            for (int size = this.O00000Oo.size(); size <= i; size++) {
                idy idy = this.f1226O000000o;
                idz = idz.O00000Oo(new idz(idy, new int[]{1, idy.O0000Oo0[(size - 1) + idy.O0000o00]}));
                this.O00000Oo.add(idz);
            }
        }
        return this.O00000Oo.get(i);
    }
}
