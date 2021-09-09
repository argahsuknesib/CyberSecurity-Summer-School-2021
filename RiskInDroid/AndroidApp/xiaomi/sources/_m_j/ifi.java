package _m_j;

import java.util.List;

final class ifi {
    static idl O000000o(List<ifj> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).O00000Oo == null) {
            size--;
        }
        idl idl = new idl(size * 12);
        int i = list.get(0).O00000Oo.f1256O000000o;
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & i) != 0) {
                idl.O00000Oo(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            ifj ifj = list.get(i4);
            int i5 = ifj.f1258O000000o.f1256O000000o;
            int i6 = i2;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i5) != 0) {
                    idl.O00000Oo(i6);
                }
                i6++;
            }
            if (ifj.O00000Oo != null) {
                int i8 = ifj.O00000Oo.f1256O000000o;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        idl.O00000Oo(i6);
                    }
                    i6++;
                }
            }
            i2 = i6;
        }
        return idl;
    }
}
