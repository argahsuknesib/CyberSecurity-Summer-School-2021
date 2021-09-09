package _m_j;

import java.lang.reflect.Field;
import java.util.HashMap;

public class bmk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static bmk f13099O000000o;

    public static bmk O000000o() {
        if (f13099O000000o == null) {
            synchronized (bmk.class) {
                if (f13099O000000o == null) {
                    f13099O000000o = new bmk();
                }
            }
        }
        return f13099O000000o;
    }

    public static HashMap<String, String> O000000o(boolean z) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String O00000o0 = bnd.O00000o0("9e919b8d90969bd1908cd1bd8a96939b");
            Field[] declaredFields = Class.forName(O00000o0).getDeclaredFields();
            if (z) {
                try {
                    Object O000000o2 = bna.O000000o(O00000o0, bnd.O00000o0("989a8bac9a8d969e93"));
                    if (O000000o2 != null) {
                        hashMap.put(bnd.O00000o0("8c9a8d969e93a0af"), O000000o2.toString());
                    }
                } catch (Throwable unused) {
                }
                str = "9d909e8d9bd392909b9a93d38c9a8d969e93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
            } else {
                str = "9d909e8d9bd392909b9a93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
            }
            String O00000o02 = bnd.O00000o0(str);
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String lowerCase = field.getName().toLowerCase();
                if (O00000o02.contains(lowerCase)) {
                    hashMap.put(lowerCase, field.get(null).toString());
                }
            }
        } catch (Exception unused2) {
        }
        return hashMap;
    }
}
