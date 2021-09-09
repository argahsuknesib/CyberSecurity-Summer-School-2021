package _m_j;

import bsh.Capabilities;

public abstract class lh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static lh f2165O000000o;

    public static lh O000000o() throws Capabilities.Unavailable {
        if (f2165O000000o == null) {
            try {
                f2165O000000o = (lh) Class.forName("bsh.reflect.ReflectManagerImpl").newInstance();
            } catch (Exception e) {
                throw new Capabilities.Unavailable("Reflect Manager unavailable: ".concat(String.valueOf(e)));
            }
        }
        return f2165O000000o;
    }
}
