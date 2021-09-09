package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class iib {

    /* renamed from: O000000o  reason: collision with root package name */
    private static iib f1309O000000o;
    private Context O00000Oo;
    private Map<String, ihy> O00000o0 = new HashMap();

    private iib(Context context) {
        this.O00000Oo = context;
    }

    public static synchronized iib O000000o(Context context) {
        iib iib;
        synchronized (iib.class) {
            if (f1309O000000o == null) {
                f1309O000000o = new iib(context);
            }
            iib = f1309O000000o;
        }
        return iib;
    }

    public final synchronized ihy O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00000o0.get(str);
    }

    public final synchronized void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.remove(str);
        }
    }
}
