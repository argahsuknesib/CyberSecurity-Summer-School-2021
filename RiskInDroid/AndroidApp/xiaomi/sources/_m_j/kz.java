package _m_j;

import _m_j.ky;
import java.lang.reflect.Array;
import java.util.Enumeration;

final class kz implements Enumeration {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2161O000000o = 0;
    int O00000Oo = Array.getLength(this.O00000o0);
    private final ky.O000000o O00000o;
    private final Object O00000o0;

    kz(ky.O000000o o000000o, Object obj) {
        this.O00000o = o000000o;
        this.O00000o0 = obj;
    }

    public final boolean hasMoreElements() {
        return this.f2161O000000o < this.O00000Oo;
    }

    public final Object nextElement() {
        Object obj = this.O00000o0;
        int i = this.f2161O000000o;
        this.f2161O000000o = i + 1;
        return Array.get(obj, i);
    }
}
