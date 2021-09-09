package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class goo {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static Map<String, String> f18094O000000o = new ConcurrentHashMap();
    private static List<String> O00000Oo = new ArrayList();
    private static String O00000o0 = null;

    public static void O000000o(String str, int i) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(O00000o0)) {
                O00000o0 = str;
                if (!O00000Oo.contains(str)) {
                    if (O00000Oo.size() > 2) {
                        f18094O000000o.remove(O00000Oo.remove(0));
                    }
                    O00000Oo.add(str);
                }
            }
            String str3 = f18094O000000o.get(str);
            if (TextUtils.isEmpty(str3)) {
                str2 = "#".concat(String.valueOf(i));
            } else {
                str2 = str3 + "#" + i;
            }
            f18094O000000o.put(str, str2);
        }
    }

    public static String O000000o(long j) {
        return O000000o(String.valueOf(j));
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String remove = f18094O000000o.remove(str);
        if (str.equals(O00000o0)) {
            O00000o0 = null;
        }
        O00000Oo.remove(str);
        if (TextUtils.isEmpty(remove)) {
            return null;
        }
        return remove;
    }
}
