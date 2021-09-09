package _m_j;

import java.util.Collection;

public class ixi {
    private static <T extends Throwable> T O000000o(Throwable th) {
        return ixe.O000000o(th, ixi.class.getName());
    }

    private static void O000000o(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        throw ((ClassCastException) O000000o((Throwable) new ClassCastException(name + " cannot be cast to " + str)));
    }

    public static Iterable O000000o(Object obj) {
        if ((obj instanceof ixj) && !(obj instanceof ixl)) {
            O000000o(obj, "kotlin.collections.MutableIterable");
        }
        return O00000o(obj);
    }

    private static Iterable O00000o(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw ((ClassCastException) O000000o((Throwable) e));
        }
    }

    public static Collection O00000Oo(Object obj) {
        if ((obj instanceof ixj) && !(obj instanceof ixk)) {
            O000000o(obj, "kotlin.collections.MutableCollection");
        }
        return O00000oO(obj);
    }

    private static Collection O00000oO(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw ((ClassCastException) O000000o((Throwable) e));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ba, code lost:
        if (r0 == 2) goto L_0x00be;
     */
    public static Object O00000o0(Object obj) {
        int i;
        if (obj != null) {
            boolean z = true;
            if (obj instanceof ity) {
                if (obj instanceof ixd) {
                    i = ((ixd) obj).getArity();
                } else if (obj instanceof iwb) {
                    i = 0;
                } else if (obj instanceof iwc) {
                    i = 1;
                } else if (obj instanceof iwn) {
                    i = 2;
                } else if (obj instanceof iwr) {
                    i = 3;
                } else if (obj instanceof iws) {
                    i = 4;
                } else if (obj instanceof iwt) {
                    i = 5;
                } else if (obj instanceof iwu) {
                    i = 6;
                } else if (obj instanceof iwv) {
                    i = 7;
                } else if (obj instanceof iww) {
                    i = 8;
                } else if (obj instanceof iwx) {
                    i = 9;
                } else if (obj instanceof iwd) {
                    i = 10;
                } else if (obj instanceof iwe) {
                    i = 11;
                } else if (obj instanceof iwf) {
                    i = 12;
                } else if (obj instanceof iwg) {
                    i = 13;
                } else if (obj instanceof iwh) {
                    i = 14;
                } else if (obj instanceof iwi) {
                    i = 15;
                } else if (obj instanceof iwj) {
                    i = 16;
                } else if (obj instanceof iwk) {
                    i = 17;
                } else if (obj instanceof iwl) {
                    i = 18;
                } else if (obj instanceof iwm) {
                    i = 19;
                } else if (obj instanceof iwo) {
                    i = 20;
                } else if (obj instanceof iwp) {
                    i = 21;
                } else {
                    i = obj instanceof iwq ? 22 : -1;
                }
            }
            z = false;
            if (!z) {
                O000000o(obj, new StringBuilder("kotlin.jvm.functions.Function2").toString());
            }
        }
        return obj;
    }
}
