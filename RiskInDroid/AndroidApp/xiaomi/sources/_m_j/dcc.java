package _m_j;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAuthListener;
import java.util.HashMap;
import java.util.Map;

public final class dcc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dcc f14465O000000o;
    private Map<String, WbAuthListener> O00000Oo = new HashMap();

    private dcc() {
    }

    public static synchronized dcc O000000o() {
        dcc dcc;
        synchronized (dcc.class) {
            if (f14465O000000o == null) {
                f14465O000000o = new dcc();
            }
            dcc = f14465O000000o;
        }
        return dcc;
    }

    public final synchronized WbAuthListener O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00000Oo.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    public final synchronized void O000000o(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str)) {
            if (wbAuthListener != null) {
                this.O00000Oo.put(str, wbAuthListener);
            }
        }
    }

    public final synchronized void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000Oo.remove(str);
        }
    }
}
