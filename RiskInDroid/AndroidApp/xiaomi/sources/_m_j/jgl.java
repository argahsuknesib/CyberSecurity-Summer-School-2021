package _m_j;

import android.support.v4.app.NotificationCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

final class jgl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<Class<?>, List<jgk>> f1824O000000o = new ConcurrentHashMap();
    private static final O000000o[] O00000oO = new O000000o[4];
    private List<jgq> O00000Oo;
    private final boolean O00000o;
    private final boolean O00000o0;

    jgl(List<jgq> list, boolean z, boolean z2) {
        this.O00000Oo = list;
        this.O00000o0 = z;
        this.O00000o = z2;
    }

    /* access modifiers changed from: package-private */
    public final List<jgk> O000000o(Class<?> cls) {
        List<jgk> list;
        List<jgk> list2 = f1824O000000o.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.O00000o) {
            list = O00000o0(cls);
        } else {
            list = O00000Oo(cls);
        }
        if (!list.isEmpty()) {
            f1824O000000o.put(cls, list);
            return list;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    private List<jgk> O00000Oo(Class<?> cls) {
        O000000o O000000o2 = O000000o();
        O000000o2.O000000o(cls);
        while (O000000o2.O00000oo != null) {
            O000000o2.O0000OOo = O00000Oo(O000000o2);
            if (O000000o2.O0000OOo != null) {
                for (jgk jgk : O000000o2.O0000OOo.O00000o0()) {
                    if (O000000o2.O000000o(jgk.f1823O000000o, jgk.O00000o0)) {
                        O000000o2.f1825O000000o.add(jgk);
                    }
                }
            } else {
                O00000o0(O000000o2);
            }
            O000000o2.O000000o();
        }
        return O000000o(O000000o2);
    }

    private static List<jgk> O000000o(O000000o o000000o) {
        ArrayList arrayList = new ArrayList(o000000o.f1825O000000o);
        o000000o.f1825O000000o.clear();
        o000000o.O00000Oo.clear();
        o000000o.O00000o0.clear();
        int i = 0;
        o000000o.O00000o.setLength(0);
        o000000o.O00000oO = null;
        o000000o.O00000oo = null;
        o000000o.O0000O0o = false;
        o000000o.O0000OOo = null;
        synchronized (O00000oO) {
            while (true) {
                if (i >= 4) {
                    break;
                } else if (O00000oO[i] == null) {
                    O00000oO[i] = o000000o;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private static O000000o O000000o() {
        synchronized (O00000oO) {
            for (int i = 0; i < 4; i++) {
                O000000o o000000o = O00000oO[i];
                if (o000000o != null) {
                    O00000oO[i] = null;
                    return o000000o;
                }
            }
            return new O000000o();
        }
    }

    private jgp O00000Oo(O000000o o000000o) {
        if (!(o000000o.O0000OOo == null || o000000o.O0000OOo.O00000Oo() == null)) {
            jgp O00000Oo2 = o000000o.O0000OOo.O00000Oo();
            if (o000000o.O00000oo == O00000Oo2.O000000o()) {
                return O00000Oo2;
            }
        }
        List<jgq> list = this.O00000Oo;
        if (list == null) {
            return null;
        }
        for (jgq subscriberInfo : list) {
            jgp subscriberInfo2 = subscriberInfo.getSubscriberInfo(o000000o.O00000oo);
            if (subscriberInfo2 != null) {
                return subscriberInfo2;
            }
        }
        return null;
    }

    private List<jgk> O00000o0(Class<?> cls) {
        O000000o O000000o2 = O000000o();
        O000000o2.O000000o(cls);
        while (O000000o2.O00000oo != null) {
            O00000o0(O000000o2);
            O000000o2.O000000o();
        }
        return O000000o(O000000o2);
    }

    private void O00000o0(O000000o o000000o) {
        Method[] methodArr;
        try {
            methodArr = o000000o.O00000oo.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = o000000o.O00000oo.getMethods();
            o000000o.O0000O0o = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    jgi jgi = (jgi) method.getAnnotation(jgi.class);
                    if (jgi != null) {
                        Class<?> cls = parameterTypes[0];
                        if (o000000o.O000000o(method, cls)) {
                            o000000o.f1825O000000o.add(new jgk(method, cls, jgi.O000000o(), jgi.O00000o0(), jgi.O00000Oo()));
                        }
                    }
                } else if (this.O00000o0 && method.isAnnotationPresent(jgi.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.O00000o0 && method.isAnnotationPresent(jgi.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<jgk> f1825O000000o = new ArrayList();
        final Map<Class, Object> O00000Oo = new HashMap();
        final StringBuilder O00000o = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        final Map<String, Class> O00000o0 = new HashMap();
        Class<?> O00000oO;
        Class<?> O00000oo;
        boolean O0000O0o;
        jgp O0000OOo;

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Class<?> cls) {
            this.O00000oo = cls;
            this.O00000oO = cls;
            this.O0000O0o = false;
            this.O0000OOo = null;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(Method method, Class<?> cls) {
            Object put = this.O00000Oo.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (O00000Oo((Method) put, cls)) {
                    this.O00000Oo.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return O00000Oo(method, cls);
        }

        private boolean O00000Oo(Method method, Class<?> cls) {
            this.O00000o.setLength(0);
            this.O00000o.append(method.getName());
            StringBuilder sb = this.O00000o;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.O00000o.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.O00000o0.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.O00000o0.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (!this.O0000O0o) {
                this.O00000oo = this.O00000oo.getSuperclass();
                String name = this.O00000oo.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.")) {
                    return;
                }
            }
            this.O00000oo = null;
        }
    }
}
