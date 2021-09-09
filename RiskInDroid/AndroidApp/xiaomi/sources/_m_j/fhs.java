package _m_j;

import _m_j.fij;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public abstract class fhs extends fhr implements fik<fhm> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Vector f16388O000000o = new Vector();

    /* access modifiers changed from: package-private */
    public abstract void O000000o(fhq fhq) throws IOException;

    protected fhs() {
    }

    protected fhs(fhn fhn) {
        for (int i = 0; i != fhn.f16385O000000o.size(); i++) {
            this.f16388O000000o.addElement((fhm) fhn.f16385O000000o.elementAt(i));
        }
    }

    public final Enumeration O00000o() {
        return this.f16388O000000o.elements();
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(fhr fhr) {
        if (!(fhr instanceof fhs)) {
            return false;
        }
        fhs fhs = (fhs) fhr;
        if (this.f16388O000000o.size() != fhs.f16388O000000o.size()) {
            return false;
        }
        Enumeration elements = this.f16388O000000o.elements();
        Enumeration elements2 = fhs.f16388O000000o.elements();
        while (elements.hasMoreElements()) {
            fhm O000000o2 = O000000o(elements);
            fhm O000000o3 = O000000o(elements2);
            fhr O000000o4 = O000000o2.O000000o();
            fhr O000000o5 = O000000o3.O000000o();
            if (O000000o4 != O000000o5 && !O000000o4.equals(O000000o5)) {
                return false;
            }
        }
        return true;
    }

    private static fhm O000000o(Enumeration enumeration) {
        return (fhm) enumeration.nextElement();
    }

    /* access modifiers changed from: package-private */
    public final fhr O00000o0() {
        fhu fhu = new fhu();
        fhu.f16388O000000o = this.f16388O000000o;
        return fhu;
    }

    public String toString() {
        return this.f16388O000000o.toString();
    }

    public Iterator<fhm> iterator() {
        return new fij.O000000o(O00000oO());
    }

    private fhm[] O00000oO() {
        fhm[] fhmArr = new fhm[this.f16388O000000o.size()];
        for (int i = 0; i != this.f16388O000000o.size(); i++) {
            fhmArr[i] = (fhm) this.f16388O000000o.elementAt(i);
        }
        return fhmArr;
    }

    public int hashCode() {
        Enumeration elements = this.f16388O000000o.elements();
        int size = this.f16388O000000o.size();
        while (elements.hasMoreElements()) {
            size = (size * 17) ^ O000000o(elements).hashCode();
        }
        return size;
    }
}
