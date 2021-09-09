package com.alipay.a.a;

import com.alipay.a.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static List<j> f3123a;

    static {
        ArrayList arrayList = new ArrayList();
        f3123a = arrayList;
        arrayList.add(new l());
        f3123a.add(new d());
        f3123a.add(new c());
        f3123a.add(new h());
        f3123a.add(new b());
        f3123a.add(new a());
        f3123a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (a.a(b.getClass())) {
            return b.c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.a((Collection) ((List) b)).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new b((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (j next : f3123a) {
            if (next.a(obj.getClass()) && (a2 = next.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
