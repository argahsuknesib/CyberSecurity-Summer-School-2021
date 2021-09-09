package _m_j;

import org.apache.log4j.Level;

public class jef extends jdy {
    private static final String O0000Oo;
    static Class O0000Oo0;

    static {
        Class cls = O0000Oo0;
        if (cls == null) {
            cls = O000000o("_m_j.jef");
            O0000Oo0 = cls;
        }
        O0000Oo = cls.getName();
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected jef(String str) {
        super(str);
    }

    public boolean O0000OoO() {
        if (this.O00000oO.O000000o(5000)) {
            return false;
        }
        return Level.O0000O0o.O000000o(O00000o0());
    }
}
