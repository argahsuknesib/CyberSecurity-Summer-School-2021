package _m_j;

import org.mp4parser.aspectj.lang.NoAspectBoundException;

public final class jku {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jku f1912O000000o;
    private static Throwable O00000Oo;

    public static jku O000000o() {
        jku jku = f1912O000000o;
        if (jku != null) {
            return jku;
        }
        throw new NoAspectBoundException("org.mp4parser.support.RequiresParseDetailAspect", O00000Oo);
    }

    public static void O000000o(jhf jhf) {
        if (!(jhf.O000000o() instanceof jkn)) {
            throw new RuntimeException("Only methods in subclasses of " + jkn.class.getName() + " can  be annotated with ParseDetail");
        } else if (!((jkn) jhf.O000000o()).isParsed()) {
            ((jkn) jhf.O000000o()).parseDetails();
        }
    }

    static {
        try {
            f1912O000000o = new jku();
        } catch (Throwable th) {
            O00000Oo = th;
        }
    }
}
