package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class bic {

    /* renamed from: O000000o  reason: collision with root package name */
    public Constructor<?> f12988O000000o;
    public Constructor<?> O00000Oo;
    public final List<bid> O00000o = new ArrayList();
    public Method O00000o0;
    private final Class<?> O00000oO;

    private bic(Class<?> cls) {
        this.O00000oO = cls;
    }

    private bid O000000o(String str) {
        for (bid next : this.O00000o) {
            if (next.f12989O000000o.equals(str)) {
                return next;
            }
        }
        return null;
    }

    private boolean O000000o(bid bid) {
        for (bid bid2 : this.O00000o) {
            if (bid2.f12989O000000o.equals(bid.f12989O000000o)) {
                return false;
            }
        }
        this.O00000o.add(bid);
        return true;
    }

    public static bic O000000o(Class<?> cls, Type type) {
        Constructor<?> constructor;
        String substring;
        bdk bdk;
        Constructor<?> constructor2;
        Method method;
        bdk bdk2;
        bdk bdk3;
        Class<?> cls2 = cls;
        bic bic = new bic(cls2);
        if (Modifier.isAbstract(cls.getModifiers())) {
            constructor = null;
        } else {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                constructor = declaredConstructors[i];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                }
                i++;
            }
            if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                Constructor<?>[] declaredConstructors2 = cls.getDeclaredConstructors();
                int length2 = declaredConstructors2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    }
                    Constructor<?> constructor3 = declaredConstructors2[i2];
                    if (constructor3.getParameterTypes().length == 1 && constructor3.getParameterTypes()[0].equals(cls.getDeclaringClass())) {
                        constructor = constructor3;
                        break;
                    }
                    i2++;
                }
            }
        }
        if (constructor != null) {
            constructor.setAccessible(true);
            bic.f12988O000000o = constructor;
        } else if (constructor == null && !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
            Constructor<?>[] declaredConstructors3 = cls.getDeclaredConstructors();
            int length3 = declaredConstructors3.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    constructor2 = null;
                    break;
                }
                Constructor<?> constructor4 = declaredConstructors3[i3];
                if (((bdj) constructor4.getAnnotation(bdj.class)) != null) {
                    constructor2 = constructor4;
                    break;
                }
                i3++;
            }
            if (constructor2 != null) {
                constructor2.setAccessible(true);
                bic.O00000Oo = constructor2;
                int i4 = 0;
                while (i4 < constructor2.getParameterTypes().length) {
                    Annotation[] annotationArr = constructor2.getParameterAnnotations()[i4];
                    int length4 = annotationArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length4) {
                            bdk3 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i5];
                        if (annotation instanceof bdk) {
                            bdk3 = (bdk) annotation;
                            break;
                        }
                        i5++;
                    }
                    if (bdk3 != null) {
                        bic.O000000o(new bid(bdk3.O000000o(), cls, constructor2.getParameterTypes()[i4], constructor2.getGenericParameterTypes()[i4], O000000o(cls2, bdk3.O000000o())));
                        i4++;
                    } else {
                        throw new JSONException("illegal json creator");
                    }
                }
                return bic;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length5 = declaredMethods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length5) {
                    method = null;
                    break;
                }
                Method method2 = declaredMethods[i6];
                if (Modifier.isStatic(method2.getModifiers()) && cls2.isAssignableFrom(method2.getReturnType()) && ((bdj) method2.getAnnotation(bdj.class)) != null) {
                    method = method2;
                    break;
                }
                i6++;
            }
            if (method != null) {
                method.setAccessible(true);
                bic.O00000o0 = method;
                int i7 = 0;
                while (i7 < method.getParameterTypes().length) {
                    Annotation[] annotationArr2 = method.getParameterAnnotations()[i7];
                    int length6 = annotationArr2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length6) {
                            bdk2 = null;
                            break;
                        }
                        Annotation annotation2 = annotationArr2[i8];
                        if (annotation2 instanceof bdk) {
                            bdk2 = (bdk) annotation2;
                            break;
                        }
                        i8++;
                    }
                    if (bdk2 != null) {
                        bic.O000000o(new bid(bdk2.O000000o(), cls, method.getParameterTypes()[i7], method.getGenericParameterTypes()[i7], O000000o(cls2, bdk2.O000000o())));
                        i7++;
                    } else {
                        throw new JSONException("illegal json creator");
                    }
                }
                return bic;
            }
            throw new JSONException("default constructor not found. ".concat(String.valueOf(cls)));
        }
        for (Method method3 : cls.getMethods()) {
            String name = method3.getName();
            if (name.length() >= 4 && !Modifier.isStatic(method3.getModifiers()) && ((method3.getReturnType().equals(Void.TYPE) || method3.getReturnType().equals(cls2)) && method3.getParameterTypes().length == 1)) {
                bdk bdk4 = (bdk) method3.getAnnotation(bdk.class);
                if (bdk4 == null) {
                    bdk4 = bih.O000000o(cls2, method3);
                }
                if (bdk4 != null) {
                    if (bdk4.O00000o()) {
                        if (bdk4.O000000o().length() != 0) {
                            bic.O000000o(new bid(bdk4.O000000o(), method3, (Field) null, cls, type));
                            method3.setAccessible(true);
                        }
                    }
                }
                if (name.startsWith("set")) {
                    char charAt = name.charAt(3);
                    if (Character.isUpperCase(charAt)) {
                        substring = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                    } else if (charAt == '_') {
                        substring = name.substring(4);
                    } else if (charAt == 'f') {
                        substring = name.substring(3);
                    }
                    String str = substring;
                    Field O000000o2 = O000000o(cls2, str);
                    if (O000000o2 == null || (bdk = (bdk) O000000o2.getAnnotation(bdk.class)) == null || bdk.O000000o().length() == 0) {
                        bic.O000000o(new bid(str, method3, (Field) null, cls, type));
                        method3.setAccessible(true);
                    } else {
                        bic.O000000o(new bid(bdk.O000000o(), method3, O000000o2, cls, type));
                    }
                }
            }
        }
        for (Field field : cls.getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                boolean z = false;
                for (bid bid : bic.O00000o) {
                    if (bid.f12989O000000o.equals(field.getName())) {
                        z = true;
                    }
                }
                if (!z) {
                    String name2 = field.getName();
                    bdk bdk5 = (bdk) field.getAnnotation(bdk.class);
                    if (!(bdk5 == null || bdk5.O000000o().length() == 0)) {
                        name2 = bdk5.O000000o();
                    }
                    bic.O000000o(new bid(name2, (Method) null, field, cls, type));
                }
            }
        }
        for (Method method4 : cls.getMethods()) {
            String name3 = method4.getName();
            if (name3.length() >= 4 && !Modifier.isStatic(method4.getModifiers()) && name3.startsWith("get") && Character.isUpperCase(name3.charAt(3)) && method4.getParameterTypes().length == 0 && (Collection.class.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType()) || AtomicBoolean.class == method4.getReturnType() || AtomicInteger.class == method4.getReturnType() || AtomicLong.class == method4.getReturnType())) {
                String str2 = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                if (bic.O000000o(str2) == null) {
                    bic.O000000o(new bid(str2, method4, (Field) null, cls, type));
                    method4.setAccessible(true);
                }
            }
        }
        return bic;
    }

    private static Field O000000o(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
