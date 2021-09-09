package _m_j;

import _m_j.bra;

public abstract class brb implements brc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected bra.O000000o f13214O000000o = bra.O000000o.f13213O000000o;
    private final String O00000Oo;
    private final String O00000o;
    private final String O00000o0;

    public brb(String str) {
        if (str != null) {
            this.O00000Oo = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                this.O00000o0 = str.substring(0, indexOf);
                this.O00000o = str.substring(indexOf + 1);
                return;
            }
            this.O00000o0 = str;
            this.O00000o = null;
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    public final void O000000o(bra.O000000o o000000o) {
        this.f13214O000000o = o000000o;
    }
}
