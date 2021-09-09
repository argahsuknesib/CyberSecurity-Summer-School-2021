package _m_j;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class alp implements Iterable<alm> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12434O000000o;
    private final O000000o[] O00000Oo;
    private final int O00000o0;

    private static final int O000000o(int i) {
        int i2 = 2;
        while (i2 < (i <= 32 ? i + i : i + (i >> 2))) {
            i2 += i2;
        }
        return i2;
    }

    public alp(Collection<alm> collection) {
        this.f12434O000000o = collection.size();
        int O000000o2 = O000000o(this.f12434O000000o);
        this.O00000o0 = O000000o2 - 1;
        O000000o[] o000000oArr = new O000000o[O000000o2];
        for (alm next : collection) {
            String O00000o = next.O00000o();
            int hashCode = O00000o.hashCode() & this.O00000o0;
            o000000oArr[hashCode] = new O000000o(o000000oArr[hashCode], O00000o, next);
        }
        this.O00000Oo = o000000oArr;
    }

    private alp(O000000o[] o000000oArr, int i) {
        this.O00000Oo = o000000oArr;
        this.f12434O000000o = i;
        this.O00000o0 = o000000oArr.length - 1;
    }

    public final alp O000000o(alm alm) {
        O000000o[] o000000oArr = this.O00000Oo;
        int length = o000000oArr.length;
        O000000o[] o000000oArr2 = new O000000o[length];
        System.arraycopy(o000000oArr, 0, o000000oArr2, 0, length);
        String O00000o = alm.O00000o();
        if (O000000o(alm.O00000o()) == null) {
            int hashCode = O00000o.hashCode() & this.O00000o0;
            o000000oArr2[hashCode] = new O000000o(o000000oArr2[hashCode], O00000o, alm);
            return new alp(o000000oArr2, this.f12434O000000o + 1);
        }
        alp alp = new alp(o000000oArr2, length);
        alp.O00000Oo(alm);
        return alp;
    }

    public final alp O000000o() {
        int i = 0;
        for (O000000o o000000o : this.O00000Oo) {
            while (o000000o != null) {
                o000000o.O00000o0.O000000o(i);
                o000000o = o000000o.f12435O000000o;
                i++;
            }
        }
        return this;
    }

    public final Iterator<alm> iterator() {
        return new O00000Oo(this.O00000Oo);
    }

    public final alm O000000o(String str) {
        int hashCode = str.hashCode() & this.O00000o0;
        O000000o o000000o = this.O00000Oo[hashCode];
        if (o000000o == null) {
            return null;
        }
        if (o000000o.O00000Oo == str) {
            return o000000o.O00000o0;
        }
        do {
            o000000o = o000000o.f12435O000000o;
            if (o000000o == null) {
                return O000000o(str, hashCode);
            }
        } while (o000000o.O00000Oo != str);
        return o000000o.O00000o0;
    }

    public final void O00000Oo(alm alm) {
        String O00000o = alm.O00000o();
        int hashCode = O00000o.hashCode();
        O000000o[] o000000oArr = this.O00000Oo;
        int length = hashCode & (o000000oArr.length - 1);
        O000000o o000000o = null;
        boolean z = false;
        for (O000000o o000000o2 = o000000oArr[length]; o000000o2 != null; o000000o2 = o000000o2.f12435O000000o) {
            if (z || !o000000o2.O00000Oo.equals(O00000o)) {
                o000000o = new O000000o(o000000o, o000000o2.O00000Oo, o000000o2.O00000o0);
            } else {
                z = true;
            }
        }
        if (z) {
            this.O00000Oo[length] = new O000000o(o000000o, O00000o, alm);
            return;
        }
        throw new NoSuchElementException("No entry '" + alm + "' found, can't replace");
    }

    public final void O00000o0(alm alm) {
        String O00000o = alm.O00000o();
        int hashCode = O00000o.hashCode();
        O000000o[] o000000oArr = this.O00000Oo;
        int length = hashCode & (o000000oArr.length - 1);
        O000000o o000000o = null;
        boolean z = false;
        for (O000000o o000000o2 = o000000oArr[length]; o000000o2 != null; o000000o2 = o000000o2.f12435O000000o) {
            if (z || !o000000o2.O00000Oo.equals(O00000o)) {
                o000000o = new O000000o(o000000o, o000000o2.O00000Oo, o000000o2.O00000o0);
            } else {
                z = true;
            }
        }
        if (z) {
            this.O00000Oo[length] = o000000o;
            return;
        }
        throw new NoSuchElementException("No entry '" + alm + "' found, can't remove");
    }

    private alm O000000o(String str, int i) {
        for (O000000o o000000o = this.O00000Oo[i]; o000000o != null; o000000o = o000000o.f12435O000000o) {
            if (str.equals(o000000o.O00000Oo)) {
                return o000000o.O00000o0;
            }
        }
        return null;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final O000000o f12435O000000o;
        public final String O00000Oo;
        public final alm O00000o0;

        public O000000o(O000000o o000000o, String str, alm alm) {
            this.f12435O000000o = o000000o;
            this.O00000Oo = str;
            this.O00000o0 = alm;
        }
    }

    static final class O00000Oo implements Iterator<alm> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O000000o[] f12436O000000o;
        private O000000o O00000Oo;
        private int O00000o0;

        public O00000Oo(O000000o[] o000000oArr) {
            this.f12436O000000o = o000000oArr;
            int length = this.f12436O000000o.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = i + 1;
                O000000o o000000o = this.f12436O000000o[i];
                if (o000000o != null) {
                    this.O00000Oo = o000000o;
                    i = i2;
                    break;
                }
                i = i2;
            }
            this.O00000o0 = i;
        }

        public final boolean hasNext() {
            return this.O00000Oo != null;
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final /* synthetic */ Object next() {
            O000000o o000000o = this.O00000Oo;
            if (o000000o != null) {
                O000000o o000000o2 = o000000o.f12435O000000o;
                while (o000000o2 == null) {
                    int i = this.O00000o0;
                    O000000o[] o000000oArr = this.f12436O000000o;
                    if (i >= o000000oArr.length) {
                        break;
                    }
                    this.O00000o0 = i + 1;
                    o000000o2 = o000000oArr[i];
                }
                this.O00000Oo = o000000o2;
                return o000000o.O00000o0;
            }
            throw new NoSuchElementException();
        }
    }
}
