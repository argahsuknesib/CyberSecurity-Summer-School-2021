package _m_j;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

public class ec {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final o0OO00OO<String, Class<?>> f15158O000000o = new o0OO00OO<>();

    private static Class<?> O00000o(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = f15158O000000o.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f15158O000000o.put(str, cls2);
        return cls2;
    }

    static boolean O000000o(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(O00000o(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends Fragment> O00000Oo(ClassLoader classLoader, String str) {
        try {
            return O00000o(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    public Fragment O00000o0(ClassLoader classLoader, String str) {
        try {
            return (Fragment) O00000Oo(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
