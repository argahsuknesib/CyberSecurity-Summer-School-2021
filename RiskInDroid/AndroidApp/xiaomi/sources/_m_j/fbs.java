package _m_j;

import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class fbs {
    public static void O000000o(fbt fbt) {
        if (fbt != null) {
            cub.O000000o(new cuh(fbt.f16049O000000o, fbt.O00000Oo.toString(), fbt.O00000o0));
        }
    }

    public static void O000000o(Fragment fragment, fbt fbt) {
        if (fragment != null) {
            cub.O000000o(new cui(fragment, fbt.O00000Oo.toString(), fbt.O00000o0));
        }
    }

    public static <I, T extends I> T O000000o(Class cls, String str) {
        Class<gze> cls2 = gze.class;
        T O000000o2 = gzg.O000000o().O000000o(str);
        if (O000000o2 != null) {
            return O000000o2;
        }
        return cub.O000000o(cls, str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class<I>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <I, T extends I> Class<T> O00000Oo(Class<I> r0, String str) {
        return cub.O00000Oo(r0, str);
    }

    public static List<String> O000000o() {
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = cza.class.getDeclaredField("O000000o");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(null);
            if (map != null && !map.isEmpty()) {
                for (cza cza : map.values()) {
                    try {
                        Field declaredField2 = cza.class.getDeclaredField("O00000Oo");
                        declaredField2.setAccessible(true);
                        HashMap hashMap = (HashMap) declaredField2.get(cza);
                        if (hashMap != null && hashMap.size() > 0) {
                            for (cyz cyz : hashMap.values()) {
                                arrayList.add(cyz.f14392O000000o + ": " + cyz.O00000Oo.getName());
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
