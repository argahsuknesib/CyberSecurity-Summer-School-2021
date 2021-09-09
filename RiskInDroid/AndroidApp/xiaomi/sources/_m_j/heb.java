package _m_j;

import java.util.List;

public final class heb extends hcc<hed, String> {
    public final boolean O00000o;
    public final String O00000o0;
    public final boolean O00000oO;
    private final List<hed> O00000oo;

    public heb(int i, boolean z, String str, boolean z2, List<hed> list, List<hed> list2) {
        this.O00000Oo = i;
        this.O00000oO = z;
        this.O00000o0 = str;
        this.O00000o = z2;
        this.f18768O000000o = list;
        this.O00000oo = list2;
    }

    public final List<hed> O000000o() {
        return this.O00000oo;
    }

    public final boolean O00000o0() {
        return this.O00000oO;
    }

    public final String[][] O00000o() {
        List O00000Oo = O00000Oo();
        String[][] strArr = new String[O00000Oo.size()][];
        for (int i = 0; i < O00000Oo.size(); i++) {
            strArr[i] = new String[]{((hed) O00000Oo.get(i)).O00000o0};
        }
        return strArr;
    }
}
