package _m_j;

import android.content.Context;
import java.util.zip.Adler32;

public final class bui {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f13286O000000o = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    static final Object O00000Oo = new Object();
    private static buh O00000o0;

    public static synchronized buh O000000o(Context context) {
        synchronized (bui.class) {
            if (O00000o0 != null) {
                buh buh = O00000o0;
                return buh;
            } else if (context == null) {
                return null;
            } else {
                buh O00000Oo2 = O00000Oo(context);
                O00000o0 = O00000Oo2;
                return O00000Oo2;
            }
        }
    }

    private static buh O00000Oo(Context context) {
        long j;
        if (context == null) {
            return null;
        }
        new buh();
        synchronized (O00000Oo) {
            String O000000o2 = buj.O000000o(context).O000000o();
            if (bvf.O000000o(O000000o2)) {
                return null;
            }
            if (O000000o2.endsWith("\n")) {
                O000000o2 = O000000o2.substring(0, O000000o2.length() - 1);
            }
            buh buh = new buh();
            long currentTimeMillis = System.currentTimeMillis();
            String O000000o3 = bve.O000000o(context);
            String O00000Oo2 = bve.O00000Oo(context);
            buh.O00000o0 = O000000o3;
            buh.f13285O000000o = O000000o3;
            buh.O00000oO = currentTimeMillis;
            buh.O00000Oo = O00000Oo2;
            buh.O00000o = O000000o2;
            String format = String.format("%s%s%s%s%s", buh.O00000o, buh.O00000o0, Long.valueOf(buh.O00000oO), buh.O00000Oo, buh.f13285O000000o);
            if (!bvf.O000000o(format)) {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(format.getBytes());
                j = adler32.getValue();
            } else {
                j = 0;
            }
            buh.O00000oo = j;
            return buh;
        }
    }
}
