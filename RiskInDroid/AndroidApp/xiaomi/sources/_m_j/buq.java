package _m_j;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

public final class buq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static buq f13295O000000o = new buq();
    private static ConcurrentMap O00000Oo;
    private static ConcurrentSkipListSet O00000o0;

    private buq() {
        O00000Oo = new ConcurrentHashMap();
        O00000o0 = new ConcurrentSkipListSet();
    }

    public static buq O000000o() {
        return f13295O000000o;
    }

    public static void O000000o(String str, bur bur) {
        O00000Oo.put(str, bur);
    }

    static boolean O000000o(String str) {
        return O00000o0.contains(str);
    }

    public static int O00000Oo() {
        return O00000Oo.size();
    }

    public static void O00000Oo(String str) {
        O00000o0.add(str);
    }

    static ArrayList O00000o() {
        return new ArrayList(O00000Oo.keySet());
    }

    static void O00000o0() {
        O00000Oo.clear();
        O00000o0.clear();
    }

    public static void O00000o0(String str) {
        O00000o0.remove(str);
    }
}
