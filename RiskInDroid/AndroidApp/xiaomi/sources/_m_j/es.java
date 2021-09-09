package _m_j;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class es {

    /* renamed from: O000000o  reason: collision with root package name */
    public static es f15761O000000o = new es();
    private final Map<Class, O000000o> O00000Oo = new HashMap();
    private final Map<Class, Boolean> O00000o0 = new HashMap();

    es() {
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Class cls) {
        Boolean bool = this.O00000o0.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] O00000o02 = O00000o0(cls);
        for (Method annotation : O00000o02) {
            if (((fi) annotation.getAnnotation(fi.class)) != null) {
                O000000o(cls, O00000o02);
                return true;
            }
        }
        this.O00000o0.put(cls, Boolean.FALSE);
        return false;
    }

    private static Method[] O00000o0(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public final O000000o O00000Oo(Class cls) {
        O000000o o000000o = this.O00000Oo.get(cls);
        if (o000000o != null) {
            return o000000o;
        }
        return O000000o(cls, null);
    }

    private static void O000000o(Map<O00000Oo, Lifecycle.Event> map, O00000Oo o00000Oo, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(o00000Oo);
        if (event2 != null && event != event2) {
            Method method = o00000Oo.O00000Oo;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(o00000Oo, event);
        }
    }

    private O000000o O000000o(Class cls, Method[] methodArr) {
        int i;
        O000000o O00000Oo2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (O00000Oo2 = O00000Oo(superclass)) == null)) {
            hashMap.putAll(O00000Oo2.O00000Oo);
        }
        for (Class<?> O00000Oo3 : cls.getInterfaces()) {
            for (Map.Entry next : O00000Oo(O00000Oo3).O00000Oo.entrySet()) {
                O000000o(hashMap, (O00000Oo) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = O00000o0(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            fi fiVar = (fi) method.getAnnotation(fi.class);
            if (fiVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(fa.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event O000000o2 = fiVar.O000000o();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (O000000o2 == Lifecycle.Event.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    O000000o(hashMap, new O00000Oo(i, method), O000000o2, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        O000000o o000000o = new O000000o(hashMap);
        this.O00000Oo.put(cls, o000000o);
        this.O00000o0.put(cls, Boolean.valueOf(z));
        return o000000o;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Map<Lifecycle.Event, List<O00000Oo>> f15762O000000o = new HashMap();
        final Map<O00000Oo, Lifecycle.Event> O00000Oo;

        O000000o(Map<O00000Oo, Lifecycle.Event> map) {
            this.O00000Oo = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                Object obj = this.f15762O000000o.get(event);
                if (obj == null) {
                    obj = new ArrayList();
                    this.f15762O000000o.put(event, obj);
                }
                obj.add(next.getKey());
            }
        }

        public static void O000000o(List<O00000Oo> list, fa faVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    O00000Oo o00000Oo = list.get(size);
                    try {
                        int i = o00000Oo.f15763O000000o;
                        if (i == 0) {
                            o00000Oo.O00000Oo.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            o00000Oo.O00000Oo.invoke(obj, faVar);
                        } else if (i == 2) {
                            o00000Oo.O00000Oo.invoke(obj, faVar, event);
                        }
                        size--;
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("Failed to call observer method", e.getCause());
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f15763O000000o;
        final Method O00000Oo;

        O00000Oo(int i, Method method) {
            this.f15763O000000o = i;
            this.O00000Oo = method;
            this.O00000Oo.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                O00000Oo o00000Oo = (O00000Oo) obj;
                return this.f15763O000000o == o00000Oo.f15763O000000o && this.O00000Oo.getName().equals(o00000Oo.O00000Oo.getName());
            }
        }

        public final int hashCode() {
            return (this.f15763O000000o * 31) + this.O00000Oo.getName().hashCode();
        }
    }
}
