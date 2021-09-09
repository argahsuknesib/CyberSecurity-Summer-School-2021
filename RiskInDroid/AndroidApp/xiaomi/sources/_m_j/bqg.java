package _m_j;

import android.text.TextUtils;
import com.lidroid.xutils.http.client.HttpRequest;
import java.util.concurrent.ConcurrentHashMap;

public final class bqg {
    private static final ConcurrentHashMap<String, Boolean> O00000o;
    private static long O00000o0 = 60000;

    /* renamed from: O000000o  reason: collision with root package name */
    public final bor<String, String> f13196O000000o;
    private int O00000Oo;

    public bqg() {
        this((byte) 0);
    }

    private bqg(byte b) {
        this.O00000Oo = 102400;
        this.O00000Oo = 102400;
        O00000o0 = 60000;
        this.f13196O000000o = new bor<String, String>(this.O00000Oo) {
            /* class _m_j.bqg.AnonymousClass1 */

            public final /* synthetic */ int O000000o(Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return 0;
                }
                return str.length();
            }
        };
    }

    public static long O000000o() {
        return O00000o0;
    }

    public static boolean O000000o(String str) {
        Boolean bool;
        if (!TextUtils.isEmpty(str) && (bool = O00000o.get(str.toUpperCase())) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        O00000o = concurrentHashMap;
        concurrentHashMap.put(HttpRequest.HttpMethod.GET.toString(), Boolean.TRUE);
    }
}
