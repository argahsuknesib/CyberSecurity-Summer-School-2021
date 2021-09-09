package _m_j;

import com.adobe.xmp.XMPException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class nf implements Comparable {
    static final /* synthetic */ boolean O0000OoO = (!nf.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    String f2198O000000o;
    String O00000Oo;
    List O00000o;
    nf O00000o0;
    List O00000oO;
    nr O00000oo;
    boolean O0000O0o;
    boolean O0000OOo;
    boolean O0000Oo;
    boolean O0000Oo0;

    public nf(String str, nr nrVar) {
        this(str, null, nrVar);
    }

    public nf(String str, String str2, nr nrVar) {
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.f2198O000000o = str;
        this.O00000Oo = str2;
        this.O00000oo = nrVar;
    }

    private void O00000o0(String str) throws XMPException {
        if (!"[]".equals(str) && O000000o(str) != null) {
            throw new XMPException("Duplicate property or field node '" + str + "'", 203);
        }
    }

    private boolean O0000Oo() {
        return "xml:lang".equals(this.f2198O000000o);
    }

    private boolean O0000OoO() {
        return "rdf:type".equals(this.f2198O000000o);
    }

    private List O0000Ooo() {
        if (this.O00000oO == null) {
            this.O00000oO = new ArrayList(0);
        }
        return this.O00000oO;
    }

    public final nf O000000o(int i) {
        return (nf) O0000Oo0().get(i - 1);
    }

    public final nf O000000o(String str) {
        return O000000o(O0000Oo0(), str);
    }

    /* access modifiers changed from: package-private */
    public void O000000o() {
        if (this.O00000o.isEmpty()) {
            this.O00000o = null;
        }
    }

    public final int O00000Oo() {
        List list = this.O00000o;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final nf O00000Oo(int i) {
        return (nf) O0000Ooo().get(i - 1);
    }

    public final nf O00000Oo(String str) {
        return O000000o(this.O00000oO, str);
    }

    public final boolean O00000o() {
        List list = this.O00000o;
        return list != null && list.size() > 0;
    }

    public final int O00000o0() {
        List list = this.O00000oO;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void O00000o0(nf nfVar) {
        O0000Oo0().remove(nfVar);
        O000000o();
    }

    public final Iterator O00000oO() {
        return this.O00000o != null ? O0000Oo0().iterator() : Collections.EMPTY_LIST.listIterator();
    }

    public final void O00000oO(nf nfVar) {
        nr O0000OOo2 = O0000OOo();
        if (nfVar.O0000Oo()) {
            O0000OOo2.O00000Oo(false);
        } else if (nfVar.O0000OoO()) {
            O0000OOo2.O00000o0(false);
        }
        O0000Ooo().remove(nfVar);
        if (this.O00000oO.isEmpty()) {
            O0000OOo2.O000000o(false);
            this.O00000oO = null;
        }
    }

    public final boolean O00000oo() {
        List list = this.O00000oO;
        return list != null && list.size() > 0;
    }

    public final Iterator O0000O0o() {
        if (this.O00000oO == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        final Iterator it = O0000Ooo().iterator();
        return new Iterator() {
            /* class _m_j.nf.AnonymousClass1 */

            public final boolean hasNext() {
                return it.hasNext();
            }

            public final Object next() {
                return it.next();
            }

            public final void remove() {
                throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
            }
        };
    }

    public final nr O0000OOo() {
        if (this.O00000oo == null) {
            this.O00000oo = new nr();
        }
        return this.O00000oo;
    }

    /* access modifiers changed from: package-private */
    public final List O0000Oo0() {
        if (this.O00000o == null) {
            this.O00000o = new ArrayList(0);
        }
        return this.O00000o;
    }

    public final void O000000o(nf nfVar) throws XMPException {
        O00000o0(nfVar.f2198O000000o);
        nfVar.O00000o0 = this;
        O0000Oo0().add(nfVar);
    }

    public final void O00000Oo(nf nfVar) throws XMPException {
        O00000o0(nfVar.f2198O000000o);
        nfVar.O00000o0 = this;
        O0000Oo0().add(0, nfVar);
    }

    public final void O00000o(nf nfVar) throws XMPException {
        String str = nfVar.f2198O000000o;
        if ("[]".equals(str) || O00000Oo(str) == null) {
            nfVar.O00000o0 = this;
            nfVar.O0000OOo().O000000o(32, true);
            O0000OOo().O000000o(true);
            if (nfVar.O0000Oo()) {
                this.O00000oo.O00000Oo(true);
                O0000Ooo().add(0, nfVar);
            } else if (nfVar.O0000OoO()) {
                this.O00000oo.O00000o0(true);
                O0000Ooo().add(this.O00000oo.O00000Oo(), nfVar);
            } else {
                O0000Ooo().add(nfVar);
            }
        } else {
            throw new XMPException("Duplicate '" + str + "' qualifier", 203);
        }
    }

    public Object clone() {
        nr nrVar;
        try {
            nrVar = new nr(O0000OOo().f2207O000000o);
        } catch (XMPException unused) {
            nrVar = new nr();
        }
        nf nfVar = new nf(this.f2198O000000o, this.O00000Oo, nrVar);
        try {
            Iterator O00000oO2 = O00000oO();
            while (O00000oO2.hasNext()) {
                nfVar.O000000o((nf) ((nf) O00000oO2.next()).clone());
            }
            Iterator O0000O0o2 = O0000O0o();
            while (O0000O0o2.hasNext()) {
                nfVar.O00000o((nf) ((nf) O0000O0o2.next()).clone());
            }
        } catch (XMPException unused2) {
            if (!O0000OoO) {
                throw new AssertionError();
            }
        }
        return nfVar;
    }

    public int compareTo(Object obj) {
        return O0000OOo().O0000o00() ? this.O00000Oo.compareTo(((nf) obj).O00000Oo) : this.f2198O000000o.compareTo(((nf) obj).f2198O000000o);
    }

    private static nf O000000o(List list, String str) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            nf nfVar = (nf) it.next();
            if (nfVar.f2198O000000o.equals(str)) {
                return nfVar;
            }
        }
        return null;
    }
}
