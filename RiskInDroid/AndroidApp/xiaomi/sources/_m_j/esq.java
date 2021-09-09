package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class esq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile esq f15776O000000o;
    /* access modifiers changed from: private */
    public Context O00000Oo;
    private Map<String, Map<String, String>> O00000o = new HashMap();
    private Handler O00000o0 = new Handler(Looper.getMainLooper());

    private esq(Context context) {
        this.O00000Oo = context;
    }

    public static esq O000000o(Context context) {
        if (f15776O000000o == null) {
            synchronized (esq.class) {
                if (f15776O000000o == null) {
                    f15776O000000o = new esq(context);
                }
            }
        }
        return f15776O000000o;
    }

    private synchronized String O000000o(String str, String str2) {
        if (this.O00000o == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Map map = this.O00000o.get(str);
            if (map == null) {
                return "";
            }
            return (String) map.get(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private synchronized void O00000o0(String str, String str2, String str3) {
        if (this.O00000o == null) {
            this.O00000o = new HashMap();
        }
        Map map = this.O00000o.get(str);
        if (map == null) {
            map = new HashMap();
        }
        map.put(str2, str3);
        this.O00000o.put(str, map);
    }

    public final synchronized void O000000o(String str, String str2, String str3) {
        O00000o0(str, str2, str3);
        this.O00000o0.post(new esr(this, str, str2, str3));
    }

    public final synchronized String O00000Oo(String str, String str2, String str3) {
        String O000000o2 = O000000o(str, str2);
        if (!TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        return this.O00000Oo.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
