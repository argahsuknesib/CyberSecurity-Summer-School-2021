package _m_j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

final class jel implements Enumeration {

    /* renamed from: O000000o  reason: collision with root package name */
    private Enumeration f1792O000000o;

    public jel(Hashtable hashtable) {
        Enumeration keys = hashtable.keys();
        Vector vector = new Vector(hashtable.size());
        int i = 0;
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            int i2 = 0;
            while (i2 < i && str.compareTo((String) vector.get(i2)) > 0) {
                i2++;
            }
            vector.add(i2, str);
            i++;
        }
        this.f1792O000000o = vector.elements();
    }

    public final boolean hasMoreElements() {
        return this.f1792O000000o.hasMoreElements();
    }

    public final Object nextElement() {
        return this.f1792O000000o.nextElement();
    }
}
