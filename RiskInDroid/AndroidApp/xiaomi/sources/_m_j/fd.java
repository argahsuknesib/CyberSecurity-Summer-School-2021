package _m_j;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class fd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<Class, Integer> f16095O000000o = new HashMap();
    private static Map<Class, List<Constructor<? extends ev>>> O00000Oo = new HashMap();

    static ey O000000o(Object obj) {
        boolean z = obj instanceof ey;
        boolean z2 = obj instanceof eu;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((eu) obj, (ey) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((eu) obj, null);
        }
        if (z) {
            return (ey) obj;
        }
        Class<?> cls = obj.getClass();
        if (O00000Oo(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = O00000Oo.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(O000000o((Constructor) list.get(0), obj));
        }
        ev[] evVarArr = new ev[list.size()];
        for (int i = 0; i < list.size(); i++) {
            evVarArr[i] = O000000o((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(evVarArr);
    }

    private static ev O000000o(Constructor<? extends ev> constructor, Object obj) {
        try {
            return (ev) constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends ev> O000000o(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str = canonicalName.replace(".", "_") + "_LifecycleAdapter";
            if (!name.isEmpty()) {
                str = name + "." + str;
            }
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static int O00000Oo(Class<?> cls) {
        Integer num = f16095O000000o.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int O00000o0 = O00000o0(cls);
        f16095O000000o.put(cls, Integer.valueOf(O00000o0));
        return O00000o0;
    }

    private static int O00000o0(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends ev> O000000o2 = O000000o(cls);
        if (O000000o2 != null) {
            O00000Oo.put(cls, Collections.singletonList(O000000o2));
            return 2;
        } else if (es.f15761O000000o.O000000o(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (O00000o(superclass)) {
                if (O00000Oo(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(O00000Oo.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (O00000o(cls2)) {
                    if (O00000Oo(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(O00000Oo.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            O00000Oo.put(cls, arrayList);
            return 2;
        }
    }

    private static boolean O00000o(Class<?> cls) {
        return cls != null && ez.class.isAssignableFrom(cls);
    }
}
