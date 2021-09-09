package _m_j;

public final class anh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final anh f12481O000000o = new anh();

    protected anh() {
    }

    public static Object O000000o(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    public final boolean O000000o(Class<?> cls, String str) {
        while (cls != null) {
            if (cls.getName().equals(str) || O00000o0(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean O00000o0(Class<?> cls, String str) {
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> name : interfaces) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        for (Class<?> O00000o0 : interfaces) {
            if (O00000o0(O00000o0, str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean O00000Oo(Class<?> cls, String str) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getName().startsWith(str)) {
                return true;
            }
        }
        while (cls != null) {
            if (O00000o(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean O00000o(Class<?> cls, String str) {
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> name : interfaces) {
            if (name.getName().startsWith(str)) {
                return true;
            }
        }
        for (Class<?> O00000o : interfaces) {
            if (O00000o(O00000o, str)) {
                return true;
            }
        }
        return false;
    }
}
