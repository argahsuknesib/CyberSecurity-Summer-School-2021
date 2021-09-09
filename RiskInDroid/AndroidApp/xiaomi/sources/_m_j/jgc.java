package _m_j;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

public class jgc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1813O000000o = "EventBus";
    static volatile jgc O00000Oo;
    private static final jgd O00000o = new jgd();
    private static final Map<Class<?>, List<Class<?>>> O00000oO = new HashMap();
    final ExecutorService O00000o0;
    private final Map<Class<?>, CopyOnWriteArrayList<jgm>> O00000oo;
    private final Map<Object, List<Class<?>>> O0000O0o;
    private final Map<Class<?>, Object> O0000OOo;
    private final jge O0000Oo;
    private final ThreadLocal<O000000o> O0000Oo0;
    private final jgb O0000OoO;
    private final jga O0000Ooo;
    private final boolean O0000o;
    private final boolean O0000o0;
    private final jgl O0000o00;
    private final boolean O0000o0O;
    private final boolean O0000o0o;
    private final boolean O0000oO;
    private final boolean O0000oO0;
    private final int O0000oOO;

    public static jgc O000000o() {
        if (O00000Oo == null) {
            synchronized (jgc.class) {
                if (O00000Oo == null) {
                    O00000Oo = new jgc();
                }
            }
        }
        return O00000Oo;
    }

    public jgc() {
        this(O00000o);
    }

    private jgc(jgd jgd) {
        this.O0000Oo0 = new ThreadLocal<O000000o>() {
            /* class _m_j.jgc.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object initialValue() {
                return new O000000o();
            }
        };
        this.O00000oo = new HashMap();
        this.O0000O0o = new HashMap();
        this.O0000OOo = new ConcurrentHashMap();
        this.O0000Oo = new jge(this, Looper.getMainLooper());
        this.O0000OoO = new jgb(this);
        this.O0000Ooo = new jga(this);
        this.O0000oOO = jgd.O0000Oo != null ? jgd.O0000Oo.size() : 0;
        this.O0000o00 = new jgl(jgd.O0000Oo, jgd.O0000OOo, jgd.O0000O0o);
        this.O0000o0O = jgd.f1817O000000o;
        this.O0000o0o = jgd.O00000Oo;
        this.O0000o = jgd.O00000o0;
        this.O0000oO0 = jgd.O00000o;
        this.O0000o0 = jgd.O00000oO;
        this.O0000oO = jgd.O00000oo;
        this.O00000o0 = jgd.O0000Oo0;
    }

    public final void O000000o(Object obj) {
        List<jgk> O000000o2 = this.O0000o00.O000000o(obj.getClass());
        synchronized (this) {
            for (jgk O000000o3 : O000000o2) {
                O000000o(obj, O000000o3);
            }
        }
    }

    private void O000000o(Object obj, jgk jgk) {
        Class<?> cls = jgk.O00000o0;
        jgm jgm = new jgm(obj, jgk);
        CopyOnWriteArrayList copyOnWriteArrayList = this.O00000oo.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.O00000oo.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(jgm)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            } else if (i == size || jgk.O00000o > ((jgm) copyOnWriteArrayList.get(i)).O00000Oo.O00000o) {
                copyOnWriteArrayList.add(i, jgm);
            } else {
                i++;
            }
        }
        copyOnWriteArrayList.add(i, jgm);
        Object obj2 = this.O0000O0o.get(obj);
        if (obj2 == null) {
            obj2 = new ArrayList();
            this.O0000O0o.put(obj, obj2);
        }
        obj2.add(cls);
        if (!jgk.O00000oO) {
            return;
        }
        if (this.O0000oO) {
            for (Map.Entry next : this.O0000OOo.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    O000000o(jgm, next.getValue());
                }
            }
            return;
        }
        O000000o(jgm, this.O0000OOo.get(cls));
    }

    private void O000000o(jgm jgm, Object obj) {
        if (obj != null) {
            O000000o(jgm, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public final synchronized boolean O00000Oo(Object obj) {
        return this.O0000O0o.containsKey(obj);
    }

    public final synchronized void O00000o0(Object obj) {
        List<Class> list = this.O0000O0o.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.O00000oo.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i = 0;
                    while (i < size) {
                        jgm jgm = (jgm) list2.get(i);
                        if (jgm.f1826O000000o == obj) {
                            jgm.O00000o0 = false;
                            list2.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.O0000O0o.remove(obj);
            return;
        }
        Log.w(f1813O000000o, "Subscriber to unregister was not registered before: " + obj.getClass());
    }

    public final void O00000o(Object obj) {
        O000000o o000000o = this.O0000Oo0.get();
        List<Object> list = o000000o.f1816O000000o;
        list.add(obj);
        if (!o000000o.O00000Oo) {
            o000000o.O00000o0 = Looper.getMainLooper() == Looper.myLooper();
            o000000o.O00000Oo = true;
            if (!o000000o.O00000oo) {
                while (!list.isEmpty()) {
                    try {
                        O000000o(list.remove(0), o000000o);
                    } finally {
                        o000000o.O00000Oo = false;
                        o000000o.O00000o0 = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public final void O00000oO(Object obj) {
        synchronized (this.O0000OOo) {
            this.O0000OOo.put(obj.getClass(), obj);
        }
        O00000o(obj);
    }

    public final <T> T O000000o(Class cls) {
        T cast;
        synchronized (this.O0000OOo) {
            cast = cls.cast(this.O0000OOo.get(cls));
        }
        return cast;
    }

    public final <T> T O00000Oo(Class<T> cls) {
        T cast;
        synchronized (this.O0000OOo) {
            cast = cls.cast(this.O0000OOo.remove(cls));
        }
        return cast;
    }

    public final boolean O00000oo(Object obj) {
        synchronized (this.O0000OOo) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.O0000OOo.get(cls))) {
                return false;
            }
            this.O0000OOo.remove(cls);
            return true;
        }
    }

    private void O000000o(Object obj, O000000o o000000o) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.O0000oO) {
            List<Class<?>> O00000o02 = O00000o0(cls);
            int size = O00000o02.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= O000000o(obj, o000000o, O00000o02.get(i));
            }
        } else {
            z = O000000o(obj, o000000o, cls);
        }
        if (!z) {
            if (this.O0000o0o) {
                Log.d(f1813O000000o, "No subscribers registered for event ".concat(String.valueOf(cls)));
            }
            if (this.O0000oO0 && cls != jgf.class && cls != jgj.class) {
                O00000o(new jgf(this, obj));
            }
        }
    }

    private boolean O000000o(Object obj, O000000o o000000o, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.O00000oo.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            jgm jgm = (jgm) it.next();
            o000000o.O00000oO = obj;
            o000000o.O00000o = jgm;
            try {
                O000000o(jgm, obj, o000000o.O00000o0);
                if (o000000o.O00000oo) {
                    return true;
                }
            } finally {
                o000000o.O00000oO = null;
                o000000o.O00000o = null;
                o000000o.O00000oo = false;
            }
        }
        return true;
    }

    /* renamed from: _m_j.jgc$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1815O000000o = new int[ThreadMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f1815O000000o[ThreadMode.POSTING.ordinal()] = 1;
            f1815O000000o[ThreadMode.MAIN.ordinal()] = 2;
            f1815O000000o[ThreadMode.BACKGROUND.ordinal()] = 3;
            try {
                f1815O000000o[ThreadMode.ASYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void O000000o(jgm jgm, Object obj, boolean z) {
        int i = AnonymousClass2.f1815O000000o[jgm.O00000Oo.O00000Oo.ordinal()];
        if (i == 1) {
            O00000Oo(jgm, obj);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    this.O0000Ooo.O000000o(jgm, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + jgm.O00000Oo.O00000Oo);
            } else if (z) {
                this.O0000OoO.O000000o(jgm, obj);
            } else {
                O00000Oo(jgm, obj);
            }
        } else if (z) {
            O00000Oo(jgm, obj);
        } else {
            this.O0000Oo.O000000o(jgm, obj);
        }
    }

    private static List<Class<?>> O00000o0(Class<?> cls) {
        List<Class<?>> list;
        synchronized (O00000oO) {
            list = O00000oO.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    O000000o(list, cls2.getInterfaces());
                }
                O00000oO.put(cls, list);
            }
        }
        return list;
    }

    private static void O000000o(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                O000000o(list, cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jgg jgg) {
        Object obj = jgg.f1820O000000o;
        jgm jgm = jgg.O00000Oo;
        jgg.O000000o(jgg);
        if (jgm.O00000o0) {
            O00000Oo(jgm, obj);
        }
    }

    private void O00000Oo(jgm jgm, Object obj) {
        try {
            jgm.O00000Oo.f1823O000000o.invoke(jgm.f1826O000000o, obj);
        } catch (InvocationTargetException e) {
            O000000o(jgm, obj, e.getCause());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    private void O000000o(jgm jgm, Object obj, Throwable th) {
        if (obj instanceof jgj) {
            if (this.O0000o0O) {
                String str = f1813O000000o;
                Log.e(str, "SubscriberExceptionEvent subscriber " + jgm.f1826O000000o.getClass() + " threw an exception", th);
                jgj jgj = (jgj) obj;
                String str2 = f1813O000000o;
                Log.e(str2, "Initial event " + jgj.O00000o0 + " caused exception in " + jgj.O00000o, jgj.O00000Oo);
            }
        } else if (!this.O0000o0) {
            if (this.O0000o0O) {
                String str3 = f1813O000000o;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + jgm.f1826O000000o.getClass(), th);
            }
            if (this.O0000o) {
                O00000o(new jgj(this, th, obj, jgm.f1826O000000o));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<Object> f1816O000000o = new ArrayList();
        boolean O00000Oo;
        jgm O00000o;
        boolean O00000o0;
        Object O00000oO;
        boolean O00000oo;

        O000000o() {
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.O0000oOO + ", eventInheritance=" + this.O0000oO + "]";
    }
}
