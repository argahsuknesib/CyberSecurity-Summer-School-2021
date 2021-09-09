package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a implements i, j {
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (Object[]) obj) {
            arrayList.add(f.b(b));
        }
        return arrayList;
    }

    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        if (!(type instanceof GenericArrayType)) {
            Class<?> componentType = ((Class) type).getComponentType();
            int a2 = aVar.a();
            Object newInstance = Array.newInstance(componentType, a2);
            for (int i = 0; i < a2; i++) {
                Array.set(newInstance, i, e.a(aVar.a(i), componentType));
            }
            return newInstance;
        }
        throw new IllegalArgumentException("Does not support generic array!");
    }

    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
