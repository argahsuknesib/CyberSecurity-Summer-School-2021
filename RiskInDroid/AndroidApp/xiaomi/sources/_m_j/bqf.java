package _m_j;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class bqf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ConcurrentHashMap<String, HashMap<String, bpy>> f13195O000000o = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, bqc> O00000Oo = new ConcurrentHashMap<>();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O000000o(Class<?> cls) {
        bpa bpa = (bpa) cls.getAnnotation(bpa.class);
        if (bpa == null || TextUtils.isEmpty(bpa.O000000o())) {
            return cls.getName().replace('.', '_');
        }
        return bpa.O000000o();
    }

    public static String O00000Oo(Class<?> cls) {
        bpa bpa = (bpa) cls.getAnnotation(bpa.class);
        if (bpa != null) {
            return bpa.O00000Oo();
        }
        return null;
    }

    static synchronized HashMap<String, bpy> O00000o0(Class<?> cls) {
        String str;
        synchronized (bqf.class) {
            if (f13195O000000o.containsKey(cls.getName())) {
                HashMap<String, bpy> hashMap = f13195O000000o.get(cls.getName());
                return hashMap;
            }
            HashMap<String, bpy> hashMap2 = new HashMap<>();
            bqc O00000o = O00000o(cls);
            if (O00000o == null) {
                str = null;
            } else {
                str = O00000o.O00000o0().getName();
            }
            O000000o(cls, str, hashMap2);
            f13195O000000o.put(cls.getName(), hashMap2);
            return hashMap2;
        }
    }

    private static void O000000o(Class<?> cls, String str, HashMap<String, bpy> hashMap) {
        if (!Object.class.equals(cls)) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (!bpz.O00000o(field) && !Modifier.isStatic(field.getModifiers())) {
                        if (bpi.O00000o0(field.getType())) {
                            if (!field.getName().equals(str)) {
                                bpy bpy = new bpy(cls, field);
                                if (!hashMap.containsKey(bpy.O000000o())) {
                                    hashMap.put(bpy.O000000o(), bpy);
                                }
                            }
                        } else if (bpz.O00000oO(field)) {
                            bqb bqb = new bqb(cls, field);
                            if (!hashMap.containsKey(bqb.O000000o())) {
                                hashMap.put(bqb.O000000o(), bqb);
                            }
                        } else if (bpz.O00000oo(field)) {
                            bqa bqa = new bqa(cls, field);
                            if (!hashMap.containsKey(bqa.O000000o())) {
                                hashMap.put(bqa.O000000o(), bqa);
                            }
                        }
                    }
                }
                if (!Object.class.equals(cls.getSuperclass())) {
                    O000000o(cls.getSuperclass(), str, hashMap);
                }
            } catch (Throwable th) {
                brm.O000000o(th.getMessage(), th);
            }
        }
    }

    static synchronized bqc O00000o(Class<?> cls) {
        Field field;
        synchronized (bqf.class) {
            if (Object.class.equals(cls)) {
                throw new RuntimeException("field 'id' not found");
            } else if (O00000Oo.containsKey(cls.getName())) {
                bqc bqc = O00000Oo.get(cls.getName());
                return bqc;
            } else {
                Field field2 = null;
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null) {
                    int length = declaredFields.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Field field3 = declaredFields[i2];
                        if (field3.getAnnotation(box.class) != null) {
                            field2 = field3;
                            break;
                        }
                        i2++;
                    }
                    if (field2 == null) {
                        int length2 = declaredFields.length;
                        while (true) {
                            if (i >= length2) {
                                break;
                            }
                            field = declaredFields[i];
                            if ("id".equals(field.getName())) {
                                break;
                            } else if ("_id".equals(field.getName())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        field2 = field;
                    }
                }
                if (field2 == null) {
                    bqc O00000o = O00000o(cls.getSuperclass());
                    return O00000o;
                }
                bqc bqc2 = new bqc(cls, field2);
                O00000Oo.put(cls.getName(), bqc2);
                return bqc2;
            }
        }
    }

    static bpy O000000o(Class<?> cls, String str) {
        String str2;
        bqc O00000o = O00000o(cls);
        if (O00000o == null) {
            str2 = null;
        } else {
            str2 = O00000o.O000000o();
        }
        if (str2.equals(str)) {
            return O00000o(cls);
        }
        return O00000o0(cls).get(str);
    }
}
