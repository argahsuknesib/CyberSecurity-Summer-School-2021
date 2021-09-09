package _m_j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class jcz {

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f1770O000000o;
    private static final Object O00000Oo = new Object();
    private static final Method O00000o;
    private static String[] O00000o0 = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    private static final Method O00000oO;

    static {
        Method method;
        Class cls;
        Class cls2;
        Class cls3;
        Method method2 = null;
        try {
            if (f1770O000000o == null) {
                cls3 = O00000Oo("java.lang.Throwable");
                f1770O000000o = cls3;
            } else {
                cls3 = f1770O000000o;
            }
            method = cls3.getMethod("getCause", null);
        } catch (Exception unused) {
            method = null;
        }
        O00000o = method;
        try {
            if (f1770O000000o == null) {
                cls = O00000Oo("java.lang.Throwable");
                f1770O000000o = cls;
            } else {
                cls = f1770O000000o;
            }
            Class[] clsArr = new Class[1];
            if (f1770O000000o == null) {
                cls2 = O00000Oo("java.lang.Throwable");
                f1770O000000o = cls2;
            } else {
                cls2 = f1770O000000o;
            }
            clsArr[0] = cls2;
            method2 = cls.getMethod("initCause", clsArr);
        } catch (Exception unused2) {
        }
        O00000oO = method2;
    }

    private static Class O00000Oo(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Throwable O000000o(Throwable th) {
        Throwable O000000o2;
        synchronized (O00000Oo) {
            O000000o2 = O000000o(th, O00000o0);
        }
        return O000000o2;
    }

    private static Throwable O000000o(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null) {
            Class cls = f1770O000000o;
            if (cls == null) {
                cls = O00000Oo("java.lang.Throwable");
                f1770O000000o = cls;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, jcv.f1768O000000o);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                }
            }
        }
        return null;
    }

    private static Throwable O00000Oo(Throwable th, String str) {
        Field field;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException | SecurityException unused) {
            field = null;
        }
        if (field != null) {
            Class cls = f1770O000000o;
            if (cls == null) {
                cls = O00000Oo("java.lang.Throwable");
                f1770O000000o = cls;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException | IllegalArgumentException unused2) {
                }
            }
        }
        return null;
    }

    public static boolean O000000o() {
        return O00000o != null;
    }

    public static int O00000Oo(Throwable th) {
        return O00000o(th).size();
    }

    public static Throwable[] O00000o0(Throwable th) {
        List O00000o2 = O00000o(th);
        return (Throwable[]) O00000o2.toArray(new Throwable[O00000o2.size()]);
    }

    private static List O00000o(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = O000000o(th);
        }
        return arrayList;
    }

    public static void O000000o(List list, List list2) {
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (((String) list.get(size)).equals((String) list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }

    public static String[] O000000o(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, jcx.O000O0o0);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static Throwable O000000o(Throwable th, String[] strArr) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        if (th instanceof jda) {
            th2 = ((jda) th).getCause();
        } else if (th instanceof SQLException) {
            th2 = ((SQLException) th).getNextException();
        } else if (th instanceof InvocationTargetException) {
            th2 = ((InvocationTargetException) th).getTargetException();
        }
        if (th2 != null) {
            return th2;
        }
        if (strArr == null) {
            synchronized (O00000Oo) {
                strArr = O00000o0;
            }
        }
        int i = 0;
        while (i < strArr.length && ((r2 = strArr[i]) == null || (th2 = O000000o(th, r2)) == null)) {
            i++;
        }
        return th2 == null ? O00000Oo(th, "detail") : th2;
    }
}
