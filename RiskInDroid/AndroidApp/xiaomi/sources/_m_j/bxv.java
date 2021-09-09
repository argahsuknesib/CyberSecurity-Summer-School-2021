package _m_j;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;

public class bxv implements bxx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Context f13393O000000o;
    private static bxv O00000Oo;

    public static String O0000O0o() {
        return "/blockcanary/";
    }

    public String O000000o() {
        return "unknown";
    }

    public final void O000000o(bye bye) {
    }

    public List<String> O00000Oo() {
        return null;
    }

    public boolean O00000o() {
        return false;
    }

    static void O000000o(Context context, bxv bxv) {
        f13393O000000o = context;
        O00000Oo = bxv;
    }

    public static bxv O00000oO() {
        bxv bxv = O00000Oo;
        if (bxv != null) {
            return bxv;
        }
        throw new RuntimeException("BlockCanaryContext null");
    }

    public static Context O00000oo() {
        return f13393O000000o;
    }

    public List<String> O00000o0() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("org.chromium");
        return linkedList;
    }
}
