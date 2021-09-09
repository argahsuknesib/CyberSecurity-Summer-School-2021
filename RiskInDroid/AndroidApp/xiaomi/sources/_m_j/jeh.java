package _m_j;

import java.util.Hashtable;
import java.util.Stack;

public final class jeh {

    /* renamed from: O000000o  reason: collision with root package name */
    static Hashtable f1788O000000o = new Hashtable();
    static int O00000Oo = 0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f1789O000000o;
    }

    public static String O000000o() {
        Hashtable hashtable = f1788O000000o;
        Stack stack = hashtable != null ? (Stack) hashtable.get(Thread.currentThread()) : null;
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return ((O000000o) stack.peek()).f1789O000000o;
    }
}
