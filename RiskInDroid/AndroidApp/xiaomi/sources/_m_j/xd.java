package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class xd<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O000000o<T> f2588O000000o = new O000000o<>();
    public int O00000Oo;

    public static class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Map<Byte, O000000o<T>> f2589O000000o = new HashMap();
        public T O00000Oo = null;

        O000000o() {
        }

        public final void O000000o(T t) {
            if (this.O00000Oo == null) {
                this.O00000Oo = t;
                return;
            }
            throw new RuntimeException("Value already set for this trie node");
        }
    }

    public final T O000000o(byte[] bArr) {
        O000000o<T> o000000o = this.f2588O000000o;
        T t = o000000o.O00000Oo;
        for (byte valueOf : bArr) {
            o000000o = o000000o.f2589O000000o.get(Byte.valueOf(valueOf));
            if (o000000o == null) {
                break;
            }
            if (o000000o.O00000Oo != null) {
                t = o000000o.O00000Oo;
            }
        }
        return t;
    }

    public final void O000000o(T t, byte[]... bArr) {
        O000000o<T> o000000o = this.f2588O000000o;
        int length = bArr.length;
        O000000o<T> o000000o2 = o000000o;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            O000000o<T> o000000o3 = o000000o2;
            int i3 = i2;
            for (byte b : bArr[i]) {
                O000000o<T> o000000o4 = o000000o3.f2589O000000o.get(Byte.valueOf(b));
                if (o000000o4 == null) {
                    o000000o4 = new O000000o<>();
                    o000000o3.f2589O000000o.put(Byte.valueOf(b), o000000o4);
                }
                o000000o3 = o000000o4;
                i3++;
            }
            i++;
            i2 = i3;
            o000000o2 = o000000o3;
        }
        if (i2 != 0) {
            o000000o2.O000000o(t);
            this.O00000Oo = Math.max(this.O00000Oo, i2);
            return;
        }
        throw new IllegalArgumentException("Parts must contain at least one byte.");
    }
}
