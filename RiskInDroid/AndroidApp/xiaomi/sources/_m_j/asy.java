package _m_j;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.lang.Enum;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class asy<T extends Enum<T>> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<T> f12579O000000o;
    protected final T[] O00000Oo;
    protected final HashMap<String, T> O00000o0;

    private asy(Class<T> cls, T[] tArr, HashMap<String, T> hashMap) {
        this.f12579O000000o = cls;
        this.O00000Oo = tArr;
        this.O00000o0 = hashMap;
    }

    public static <ET extends Enum<ET>> asy<ET> O000000o(Class cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(annotationIntrospector.O000000o(enumR), enumR);
            }
            return new asy<>(cls, enumArr, hashMap);
        }
        throw new IllegalArgumentException("No enum constants for class " + cls.getName());
    }

    public static <ET extends Enum<ET>> asy<ET> O000000o(Class cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return new asy<>(cls, enumArr, hashMap);
            }
            Enum enumR = enumArr[length];
            hashMap.put(enumR.toString(), enumR);
        }
    }

    public static <ET extends Enum<ET>> asy<ET> O000000o(Class cls, Method method) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return new asy<>(cls, enumArr, hashMap);
            }
            Enum enumR = enumArr[length];
            try {
                Object invoke = method.invoke(enumR, new Object[0]);
                if (invoke != null) {
                    hashMap.put(invoke.toString(), enumR);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + enumR + ": " + e.getMessage());
            }
        }
    }

    public final T O000000o(String str) {
        return (Enum) this.O00000o0.get(str);
    }

    public final T O000000o(int i) {
        if (i < 0) {
            return null;
        }
        T[] tArr = this.O00000Oo;
        if (i >= tArr.length) {
            return null;
        }
        return tArr[i];
    }

    public final Class<T> O000000o() {
        return this.f12579O000000o;
    }

    public final int O00000Oo() {
        return this.O00000Oo.length - 1;
    }
}
