package _m_j;

import com.adobe.xmp.XMPException;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class nc implements mn {

    /* renamed from: O000000o  reason: collision with root package name */
    no f2193O000000o = new no();
    String O00000Oo = null;
    protected boolean O00000o = false;
    protected boolean O00000o0 = false;
    private Iterator O00000oO = null;

    public final boolean hasNext() {
        return this.O00000oO.hasNext();
    }

    public final Object next() {
        return this.O00000oO.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("The XMPIterator does not support remove().");
    }

    class O000000o implements Iterator {

        /* renamed from: O000000o  reason: collision with root package name */
        nt f2194O000000o = null;
        private nf O00000o;
        private int O00000o0 = 0;
        private String O00000oO;
        private Iterator O00000oo = null;
        private int O0000O0o = 0;
        private Iterator O0000OOo = Collections.EMPTY_LIST.iterator();

        public O000000o() {
        }

        private boolean O000000o(Iterator it) {
            if (nc.this.O00000o0) {
                nc.this.O00000o0 = false;
                this.O0000OOo = Collections.EMPTY_LIST.iterator();
            }
            if (!this.O0000OOo.hasNext() && it.hasNext()) {
                this.O0000O0o++;
                this.O0000OOo = new O000000o((nf) it.next(), this.O00000oO, this.O0000O0o);
            }
            if (!this.O0000OOo.hasNext()) {
                return false;
            }
            this.f2194O000000o = (nt) this.O0000OOo.next();
            return true;
        }

        public Object next() {
            if (hasNext()) {
                nt ntVar = this.f2194O000000o;
                this.f2194O000000o = null;
                return ntVar;
            }
            throw new NoSuchElementException("There are no more nodes to return");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public O000000o(nf nfVar, String str, int i) {
            this.O00000o = nfVar;
            this.O00000o0 = 0;
            if (nfVar.O0000OOo().O0000o00()) {
                nc.this.O00000Oo = nfVar.f2198O000000o;
            }
            this.O00000oO = O000000o(nfVar, str, i);
        }

        public boolean hasNext() {
            if (this.f2194O000000o != null) {
                return true;
            }
            int i = this.O00000o0;
            if (i == 0) {
                this.O00000o0 = 1;
                if (this.O00000o.O00000o0 == null || (nc.this.f2193O000000o.O00000o0() && this.O00000o.O00000o())) {
                    return hasNext();
                }
                this.f2194O000000o = O000000o(this.O00000o, nc.this.O00000Oo, this.O00000oO);
                return true;
            } else if (i == 1) {
                if (this.O00000oo == null) {
                    this.O00000oo = this.O00000o.O00000oO();
                }
                boolean O000000o2 = O000000o(this.O00000oo);
                if (O000000o2 || !this.O00000o.O00000oo() || nc.this.f2193O000000o.O00000o()) {
                    return O000000o2;
                }
                this.O00000o0 = 2;
                this.O00000oo = null;
                return hasNext();
            } else {
                if (this.O00000oo == null) {
                    this.O00000oo = this.O00000o.O0000O0o();
                }
                return O000000o(this.O00000oo);
            }
        }

        /* access modifiers changed from: protected */
        public final String O000000o(nf nfVar, String str, int i) {
            String str2;
            String str3;
            if (nfVar.O00000o0 == null || nfVar.O0000OOo().O0000o00()) {
                return null;
            }
            if (nfVar.O00000o0.O0000OOo().O00000o()) {
                str3 = "[" + String.valueOf(i) + "]";
                str2 = "";
            } else {
                str3 = nfVar.f2198O000000o;
                str2 = "/";
            }
            if (str == null || str.length() == 0) {
                return str3;
            }
            if (nc.this.f2193O000000o.O00000Oo()) {
                return !str3.startsWith("?") ? str3 : str3.substring(1);
            }
            return str + str2 + str3;
        }

        /* access modifiers changed from: protected */
        public final nt O000000o(nf nfVar, String str, String str2) {
            final String str3 = nfVar.O0000OOo().O0000o00() ? null : nfVar.O00000Oo;
            final nf nfVar2 = nfVar;
            final String str4 = str;
            final String str5 = str2;
            return new nt() {
                /* class _m_j.nc.O000000o.AnonymousClass1 */

                public final String O000000o() {
                    return str5;
                }

                public final String O00000Oo() {
                    return str3;
                }
            };
        }
    }

    class O00000Oo extends O000000o {
        private String O00000o;
        private Iterator O00000oO;
        private int O00000oo = 0;

        public O00000Oo(nf nfVar, String str) {
            super();
            if (nfVar.O0000OOo().O0000o00()) {
                nc.this.O00000Oo = nfVar.f2198O000000o;
            }
            this.O00000o = O000000o(nfVar, str, 1);
            this.O00000oO = nfVar.O00000oO();
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x0006  */
        public final boolean hasNext() {
            while (this.f2194O000000o == null) {
                if (nc.this.O00000o0 || !this.O00000oO.hasNext()) {
                    return false;
                }
                nf nfVar = (nf) this.O00000oO.next();
                this.O00000oo++;
                String str = null;
                if (nfVar.O0000OOo().O0000o00()) {
                    nc.this.O00000Oo = nfVar.f2198O000000o;
                } else if (nfVar.O00000o0 != null) {
                    str = O000000o(nfVar, this.O00000o, this.O00000oo);
                }
                if (!nc.this.f2193O000000o.O00000o0() || !nfVar.O00000o()) {
                    this.f2194O000000o = O000000o(nfVar, nc.this.O00000Oo, str);
                    return true;
                }
                while (this.f2194O000000o == null) {
                }
            }
            return true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O000000o(_m_j.nf, java.lang.String, boolean):_m_j.nf
     arg types: [_m_j.nf, java.lang.String, int]
     candidates:
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String):void
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, boolean):_m_j.nf */
    public nc(nd ndVar, String str, String str2, no noVar) throws XMPException {
        nf nfVar;
        if (!(str != null && str.length() > 0)) {
            nfVar = ndVar.f2196O000000o;
        } else {
            nfVar = ng.O000000o(ndVar.f2196O000000o, str, false);
        }
        if (nfVar == null) {
            this.O00000oO = Collections.EMPTY_LIST.iterator();
        } else if (!this.f2193O000000o.O000000o()) {
            this.O00000oO = new O000000o(nfVar, null, 1);
        } else {
            this.O00000oO = new O00000Oo(nfVar, null);
        }
    }
}
