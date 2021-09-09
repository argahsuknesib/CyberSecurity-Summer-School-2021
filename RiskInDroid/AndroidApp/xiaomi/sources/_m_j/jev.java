package _m_j;

import java.util.Hashtable;

public final class jev {
    public static jeu O00000Oo = new jet();
    static Class O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Hashtable f1799O000000o = new Hashtable();

    public static void O000000o(jff jff, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer("Rendering class: [");
        stringBuffer.append(str2);
        stringBuffer.append("], Rendered class: [");
        stringBuffer.append(str);
        stringBuffer.append("].");
        jep.O000000o(stringBuffer.toString());
        Class cls = O00000o0;
        if (cls == null) {
            cls = O000000o("_m_j.jeu");
            O00000o0 = cls;
        }
        jeu jeu = (jeu) jer.O000000o(str2, cls, (Object) null);
        if (jeu == null) {
            StringBuffer stringBuffer2 = new StringBuffer("Could not instantiate renderer [");
            stringBuffer2.append(str2);
            stringBuffer2.append("].");
            jep.O00000Oo(stringBuffer2.toString());
            return;
        }
        try {
            jff.O000000o(jeo.O00000Oo(str), jeu);
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer3 = new StringBuffer("Could not find class [");
            stringBuffer3.append(str);
            stringBuffer3.append("].");
            jep.O00000Oo(stringBuffer3.toString(), e);
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final jeu O000000o(Class cls) {
        jeu jeu = (jeu) this.f1799O000000o.get(cls);
        if (jeu != null) {
            return jeu;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> O000000o2 : interfaces) {
            jeu O000000o3 = O000000o(O000000o2);
            if (O000000o3 != null) {
                return O000000o3;
            }
        }
        return null;
    }
}
