package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static List<i> f3122a;

    static {
        ArrayList arrayList = new ArrayList();
        f3122a = arrayList;
        arrayList.add(new l());
        f3122a.add(new d());
        f3122a.add(new c());
        f3122a.add(new h());
        f3122a.add(new k());
        f3122a.add(new b());
        f3122a.add(new a());
        f3122a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T a2;
        for (i next : f3122a) {
            if (next.a(a.a(type)) && (a2 = next.a(obj, type)) != null) {
                return a2;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.a.a.e.a(java.lang.Object, java.lang.reflect.Type):T
     arg types: [java.lang.String, java.lang.reflect.Type]
     candidates:
      com.alipay.a.a.e.a(java.lang.String, java.lang.reflect.Type):java.lang.Object
      com.alipay.a.a.e.a(java.lang.Object, java.lang.reflect.Type):T */
    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith("{") || !trim.endsWith("}")) {
            return a((Object) trim, type);
        } else {
            bVar = new b(trim);
        }
        return a(bVar, type);
    }
}
