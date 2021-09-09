package _m_j;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class cpo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14212O000000o = null;
    static String O00000Oo = null;
    private static List<O000000o> O00000o = null;
    private static int O00000o0 = 3;
    private String O00000oO;

    public interface O000000o {
        void O000000o(int i, String str, String str2, Throwable th);
    }

    static {
        ArrayList arrayList = new ArrayList();
        O00000o = arrayList;
        arrayList.add(new O000000o() {
            /* class _m_j.cpo.AnonymousClass1 */

            public final void O000000o(int i, String str, String str2, Throwable th) {
                if (i == 0) {
                    Log.v(str, str2, th);
                } else if (i == 1) {
                    Log.i(str, str2, th);
                } else if (i == 2) {
                    Log.w(str, str2, th);
                } else if (i == 3) {
                    Log.e(str, str2, th);
                }
            }
        });
    }

    public static cpo O000000o(String str) {
        return new cpo(str);
    }

    private cpo(String str) {
        this.O00000oO = str;
    }

    private static boolean O000000o(int i) {
        return O00000o0 <= i && O00000o.size() > 0;
    }

    public final void O000000o(Object... objArr) {
        O000000o(1, objArr);
    }

    public final void O00000Oo(Object... objArr) {
        O000000o(2, objArr);
    }

    public final void O000000o(int i, Object... objArr) {
        if (O000000o(i)) {
            Throwable th = null;
            String str = "";
            for (Object obj : objArr) {
                if (obj instanceof Throwable) {
                    th = (Throwable) obj;
                }
                str = (str + String.valueOf(obj)) + " ";
            }
            String trim = str.trim();
            for (O000000o O000000o2 : O00000o) {
                O000000o2.O000000o(i, this.O00000oO, trim, th);
            }
            f14212O000000o = trim;
            O00000Oo = this.O00000oO;
        }
    }
}
