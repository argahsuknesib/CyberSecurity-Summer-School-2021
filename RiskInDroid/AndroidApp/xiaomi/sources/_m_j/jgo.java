package _m_j;

public final class jgo extends jgn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jgr[] f1828O000000o;

    public jgo(Class cls, jgr[] jgrArr) {
        super(cls, true);
        this.f1828O000000o = jgrArr;
    }

    public final synchronized jgk[] O00000o0() {
        jgk[] jgkArr;
        int length = this.f1828O000000o.length;
        jgkArr = new jgk[length];
        for (int i = 0; i < length; i++) {
            jgr jgr = this.f1828O000000o[i];
            jgkArr[i] = O000000o(jgr.f1829O000000o, jgr.O00000o0, jgr.O00000Oo, jgr.O00000o, jgr.O00000oO);
        }
        return jgkArr;
    }
}
