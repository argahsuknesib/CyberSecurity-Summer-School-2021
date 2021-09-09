package _m_j;

import android.text.TextUtils;
import com.xiaomi.mobilestats.controller.a;
import java.io.File;
import java.util.HashMap;

public final class ecj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ecj f15165O000000o;
    private static HashMap O00000Oo = new a();

    private ecj() {
    }

    public static ecj O000000o() {
        if (f15165O000000o == null) {
            f15165O000000o = new ecj();
        }
        return f15165O000000o;
    }

    public static void O000000o(String str) {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str) && (hashMap = O00000Oo) != null && hashMap.containsKey(str)) {
            O00000Oo.remove(str);
        }
    }

    public static void O000000o(String str, File file) {
        HashMap hashMap = O00000Oo;
        if (hashMap != null && !hashMap.containsKey(str)) {
            O00000Oo.put(str, file);
        }
    }
}
