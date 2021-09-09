package _m_j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.Level;
import org.apache.log4j.ProvisionNode;

public final class jec implements jfb, jff, jfj {

    /* renamed from: O000000o  reason: collision with root package name */
    Vector f1784O000000o = new Vector(1);
    Hashtable O00000Oo = new Hashtable();
    jev O00000o;
    jef O00000o0;
    int O00000oO;
    Level O00000oo;
    boolean O0000O0o = false;
    boolean O0000OOo = false;
    private jfi O0000Oo = null;
    private jfa O0000Oo0;

    public jec(jef jef) {
        this.O00000o0 = jef;
        O000000o(Level.O0000OOo);
        this.O00000o0.O000000o(this);
        this.O00000o = new jev();
        this.O0000Oo0 = new jea();
    }

    public final void O000000o(jdy jdy) {
        if (!this.O0000O0o) {
            StringBuffer stringBuffer = new StringBuffer("No appenders could be found for logger (");
            stringBuffer.append(jdy.O00000oO());
            stringBuffer.append(").");
            jep.O00000o0(stringBuffer.toString());
            jep.O00000o0("Please initialize the log4j system properly.");
            jep.O00000o0("See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.");
            this.O0000O0o = true;
        }
    }

    public final void O000000o(Level level) {
        if (level != null) {
            this.O00000oO = level.O0000Oo;
            this.O00000oo = level;
        }
    }

    public final void O000000o() {
        Vector vector = this.f1784O000000o;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                this.f1784O000000o.elementAt(i);
            }
        }
    }

    public final Level O00000Oo() {
        return this.O00000oo;
    }

    public final jef O000000o(String str) {
        return O000000o(str, this.O0000Oo0);
    }

    public final jef O000000o(String str, jfa jfa) {
        jdz jdz = new jdz(str);
        synchronized (this.O00000Oo) {
            Object obj = this.O00000Oo.get(jdz);
            if (obj == null) {
                jef O000000o2 = jfa.O000000o(str);
                O000000o2.O000000o(this);
                this.O00000Oo.put(jdz, O000000o2);
                O000000o(O000000o2);
                return O000000o2;
            } else if (obj instanceof jef) {
                jef jef = (jef) obj;
                return jef;
            } else if (!(obj instanceof ProvisionNode)) {
                return null;
            } else {
                jef O000000o3 = jfa.O000000o(str);
                O000000o3.O000000o(this);
                this.O00000Oo.put(jdz, O000000o3);
                ProvisionNode provisionNode = (ProvisionNode) obj;
                int size = provisionNode.size();
                for (int i = 0; i < size; i++) {
                    jef jef2 = (jef) provisionNode.elementAt(i);
                    if (!jef2.O00000o0.f1781O000000o.startsWith(O000000o3.f1781O000000o)) {
                        O000000o3.O00000o0 = jef2.O00000o0;
                        jef2.O00000o0 = O000000o3;
                    }
                }
                O000000o(O000000o3);
                return O000000o3;
            }
        }
    }

    private Enumeration O0000O0o() {
        Vector vector = new Vector(this.O00000Oo.size());
        Enumeration elements = this.O00000Oo.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof jef) {
                vector.addElement(nextElement);
            }
        }
        return vector.elements();
    }

    public final jev O00000o0() {
        return this.O00000o;
    }

    public final jef O00000o() {
        return this.O00000o0;
    }

    public final boolean O000000o(int i) {
        return this.O00000oO > i;
    }

    public final void O000000o(Class cls, jeu jeu) {
        this.O00000o.f1799O000000o.put(cls, jeu);
    }

    public final void O000000o(jfi jfi) {
        this.O0000Oo = jfi;
    }

    public final jfi O00000oo() {
        return this.O0000Oo;
    }

    private final void O000000o(jef jef) {
        String str = jef.f1781O000000o;
        boolean z = true;
        int lastIndexOf = str.lastIndexOf(46, str.length() - 1);
        while (true) {
            if (lastIndexOf < 0) {
                z = false;
                break;
            }
            jdz jdz = new jdz(str.substring(0, lastIndexOf));
            Object obj = this.O00000Oo.get(jdz);
            if (obj == null) {
                this.O00000Oo.put(jdz, new ProvisionNode(jef));
            } else if (obj instanceof jdy) {
                jef.O00000o0 = (jdy) obj;
                break;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(jef);
            } else {
                StringBuffer stringBuffer = new StringBuffer("unexpected object type ");
                stringBuffer.append(obj.getClass());
                stringBuffer.append(" in ht.");
                new IllegalStateException(stringBuffer.toString()).printStackTrace();
            }
            lastIndexOf = str.lastIndexOf(46, lastIndexOf - 1);
        }
        if (!z) {
            jef.O00000o0 = this.O00000o0;
        }
    }

    public final void O00000oO() {
        this.O00000o0.O000000o(Level.O00000oo);
        this.O00000o0.O0000Oo();
        O000000o(Level.O0000OOo);
        synchronized (this.O00000Oo) {
            jef jef = this.O00000o0;
            jef.O000000o();
            synchronized (this.O00000Oo) {
                Enumeration O0000O0o2 = O0000O0o();
                while (O0000O0o2.hasMoreElements()) {
                    ((jef) O0000O0o2.nextElement()).O000000o();
                }
                jef.O0000Oo0();
                Enumeration O0000O0o3 = O0000O0o();
                while (O0000O0o3.hasMoreElements()) {
                    ((jef) O0000O0o3.nextElement()).O0000Oo0();
                }
            }
            Enumeration O0000O0o4 = O0000O0o();
            while (O0000O0o4.hasMoreElements()) {
                jef jef2 = (jef) O0000O0o4.nextElement();
                jef2.O000000o((Level) null);
                jef2.O000000o(true);
                jef2.O0000Oo();
            }
        }
        this.O00000o.f1799O000000o.clear();
        this.O0000Oo = null;
    }
}
