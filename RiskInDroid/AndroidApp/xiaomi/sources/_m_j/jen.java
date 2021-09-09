package _m_j;

import java.util.Enumeration;
import java.util.Vector;

public final class jen {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Vector f1794O000000o;

    public final void O000000o(jdx jdx) {
        if (jdx != null) {
            if (this.f1794O000000o == null) {
                this.f1794O000000o = new Vector(1);
            }
            if (!this.f1794O000000o.contains(jdx)) {
                this.f1794O000000o.addElement(jdx);
            }
        }
    }

    public final int O000000o() {
        Vector vector = this.f1794O000000o;
        if (vector == null) {
            return 0;
        }
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            this.f1794O000000o.elementAt(i);
        }
        return size;
    }

    public final Enumeration O00000Oo() {
        Vector vector = this.f1794O000000o;
        if (vector == null) {
            return null;
        }
        return vector.elements();
    }

    public final void O00000o0() {
        Vector vector = this.f1794O000000o;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                this.f1794O000000o.elementAt(i);
            }
            this.f1794O000000o.removeAllElements();
            this.f1794O000000o = null;
        }
    }
}
