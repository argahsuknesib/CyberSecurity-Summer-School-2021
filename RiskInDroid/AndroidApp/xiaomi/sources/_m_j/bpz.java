package _m_j;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;

public final class bpz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HashSet<String> f13192O000000o;

    static {
        HashSet<String> hashSet = new HashSet<>(14);
        f13192O000000o = hashSet;
        hashSet.add(Integer.TYPE.getName());
        f13192O000000o.add(Long.TYPE.getName());
        f13192O000000o.add(Short.TYPE.getName());
        f13192O000000o.add(Byte.TYPE.getName());
        f13192O000000o.add(Float.TYPE.getName());
        f13192O000000o.add(Double.TYPE.getName());
        f13192O000000o.add(Integer.class.getName());
        f13192O000000o.add(Long.class.getName());
        f13192O000000o.add(Short.class.getName());
        f13192O000000o.add(Byte.class.getName());
        f13192O000000o.add(Float.class.getName());
        f13192O000000o.add(Double.class.getName());
        f13192O000000o.add(String.class.getName());
        f13192O000000o.add(byte[].class.getName());
    }

    public static Method O000000o(Class<?> cls, Field field) {
        Method method;
        while (true) {
            String name = field.getName();
            method = null;
            if (field.getType() == Boolean.TYPE) {
                method = O000000o(cls, name);
            }
            if (method == null) {
                String str = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    method = cls.getDeclaredMethod(str, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    brm.O000000o(String.valueOf(str) + " not exist");
                }
            }
            if (method != null || Object.class.equals(cls.getSuperclass())) {
                return method;
            }
            cls = cls.getSuperclass();
        }
        return method;
    }

    public static Method O00000Oo(Class<?> cls, Field field) {
        Method method;
        while (true) {
            String name = field.getName();
            method = null;
            if (field.getType() == Boolean.TYPE) {
                method = O00000o0(cls, field);
            }
            if (method == null) {
                String str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    method = cls.getDeclaredMethod(str, field.getType());
                } catch (NoSuchMethodException unused) {
                    brm.O000000o(String.valueOf(str) + " not exist");
                }
            }
            if (method != null || Object.class.equals(cls.getSuperclass())) {
                return method;
            }
            cls = cls.getSuperclass();
        }
        return method;
    }

    public static String O000000o(Field field) {
        bou bou = (bou) field.getAnnotation(bou.class);
        if (bou != null && !TextUtils.isEmpty(bou.O000000o())) {
            return bou.O000000o();
        }
        box box = (box) field.getAnnotation(box.class);
        if (box != null && !TextUtils.isEmpty(box.O000000o())) {
            return box.O000000o();
        }
        bow bow = (bow) field.getAnnotation(bow.class);
        if (bow != null && !TextUtils.isEmpty(bow.O000000o())) {
            return bow.O000000o();
        }
        if (((bov) field.getAnnotation(bov.class)) != null) {
            return field.getName();
        }
        return field.getName();
    }

    public static String O00000Oo(Field field) {
        bow bow = (bow) field.getAnnotation(bow.class);
        if (bow != null) {
            return bow.O00000Oo();
        }
        return field.getName();
    }

    public static String O00000o0(Field field) {
        bou bou = (bou) field.getAnnotation(bou.class);
        if (bou == null || TextUtils.isEmpty(bou.O00000Oo())) {
            return null;
        }
        return bou.O00000Oo();
    }

    public static boolean O00000o(Field field) {
        return field.getAnnotation(bpb.class) != null;
    }

    public static boolean O00000oO(Field field) {
        return field.getAnnotation(bow.class) != null;
    }

    public static boolean O00000oo(Field field) {
        return field.getAnnotation(bov.class) != null;
    }

    public static boolean O0000O0o(Field field) {
        return field.getAnnotation(bpc.class) != null;
    }

    public static boolean O0000OOo(Field field) {
        return field.getAnnotation(boz.class) != null;
    }

    public static String O0000Oo0(Field field) {
        bot bot = (bot) field.getAnnotation(bot.class);
        if (bot != null) {
            return bot.O000000o();
        }
        return null;
    }

    public static Class<?> O000000o(bqb bqb) {
        Class<?> type = bqb.O00000o0().getType();
        return (type.equals(bpt.class) || type.equals(List.class)) ? (Class) ((ParameterizedType) bqb.O00000o0().getGenericType()).getActualTypeArguments()[0] : type;
    }

    public static Class<?> O000000o(bqa bqa) {
        Class<?> type = bqa.O00000o0().getType();
        return (type.equals(bps.class) || type.equals(List.class)) ? (Class) ((ParameterizedType) bqa.O00000o0().getGenericType()).getActualTypeArguments()[0] : type;
    }

    public static Object O000000o(Object obj) {
        bph O000000o2;
        if (obj == null) {
            return obj;
        }
        Class<?> cls = obj.getClass();
        return (f13192O000000o.contains(cls.getName()) || (O000000o2 = bpi.O000000o(cls)) == null) ? obj : O000000o2.O000000o(obj);
    }

    private static boolean O000000o(String str) {
        return str != null && str.startsWith("is");
    }

    private static Method O000000o(Class<?> cls, String str) {
        String str2 = "is" + str.substring(0, 1).toUpperCase() + str.substring(1);
        if (!O000000o(str)) {
            str = str2;
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            brm.O000000o(String.valueOf(str) + " not exist");
            return null;
        }
    }

    private static Method O00000o0(Class<?> cls, Field field) {
        String str;
        String name = field.getName();
        if (O000000o(field.getName())) {
            str = "set" + name.substring(2, 3).toUpperCase() + name.substring(3);
        } else {
            str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        try {
            return cls.getDeclaredMethod(str, field.getType());
        } catch (NoSuchMethodException unused) {
            brm.O000000o(String.valueOf(str) + " not exist");
            return null;
        }
    }
}
