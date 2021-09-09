package _m_j;

import _m_j.anv;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class anj extends ani {
    private static final anr[] O0000o00 = new anr[0];

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<?> f12482O000000o;
    protected final List<Class<?>> O00000Oo;
    protected final anv.O000000o O00000o;
    protected final AnnotationIntrospector O00000o0;
    protected final Class<?> O00000oO;
    protected anr O00000oo;
    protected boolean O0000O0o = false;
    protected ank O0000OOo;
    protected List<ann> O0000Oo;
    protected List<ank> O0000Oo0;
    protected ano O0000OoO;
    protected List<anl> O0000Ooo;

    private anj(Class<?> cls, List<Class<?>> list, AnnotationIntrospector annotationIntrospector, anv.O000000o o000000o) {
        this.f12482O000000o = cls;
        this.O00000Oo = list;
        this.O00000o0 = annotationIntrospector;
        this.O00000o = o000000o;
        anv.O000000o o000000o2 = this.O00000o;
        this.O00000oO = o000000o2 == null ? null : o000000o2.O00000oo(this.f12482O000000o);
        this.O00000oo = null;
    }

    public static anj O000000o(Class<?> cls, AnnotationIntrospector annotationIntrospector, anv.O000000o o000000o) {
        return new anj(cls, asw.O000000o(cls, (Class<?>) null), annotationIntrospector, o000000o);
    }

    public static anj O00000Oo(Class<?> cls, AnnotationIntrospector annotationIntrospector, anv.O000000o o000000o) {
        return new anj(cls, Collections.emptyList(), annotationIntrospector, o000000o);
    }

    public final Class<?> O00000oo() {
        return this.f12482O000000o;
    }

    public final String O00000Oo() {
        return this.f12482O000000o.getName();
    }

    public final <A extends Annotation> A O000000o(Class<A> cls) {
        if (this.O00000oo == null) {
            O0000o0();
        }
        return this.O00000oo.O000000o(cls);
    }

    public final Type O00000o0() {
        return this.f12482O000000o;
    }

    public final Class<?> O00000o() {
        return this.f12482O000000o;
    }

    /* access modifiers changed from: protected */
    public final anr O00000oO() {
        if (this.O00000oo == null) {
            O0000o0();
        }
        return this.O00000oo;
    }

    public final ast O0000O0o() {
        if (this.O00000oo == null) {
            O0000o0();
        }
        return this.O00000oo;
    }

    public final boolean O0000OOo() {
        if (this.O00000oo == null) {
            O0000o0();
        }
        return this.O00000oo.O000000o() > 0;
    }

    public final ank O0000Oo0() {
        if (!this.O0000O0o) {
            O0000o0O();
        }
        return this.O0000OOo;
    }

    public final List<ank> O0000Oo() {
        if (!this.O0000O0o) {
            O0000o0O();
        }
        return this.O0000Oo0;
    }

    public final List<ann> O0000OoO() {
        if (!this.O0000O0o) {
            O0000o0O();
        }
        return this.O0000Oo;
    }

    public final Iterable<ann> O0000Ooo() {
        if (this.O0000OoO == null) {
            O0000o0o();
        }
        return this.O0000OoO;
    }

    public final ann O000000o(String str, Class<?>[] clsArr) {
        if (this.O0000OoO == null) {
            O0000o0o();
        }
        return this.O0000OoO.O000000o(str, clsArr);
    }

    public final Iterable<anl> O0000o00() {
        if (this.O0000Ooo == null) {
            Map<String, anl> O000000o2 = O000000o(this.f12482O000000o, (Map<String, anl>) null);
            if (O000000o2 == null || O000000o2.size() == 0) {
                this.O0000Ooo = Collections.emptyList();
            } else {
                this.O0000Ooo = new ArrayList(O000000o2.size());
                this.O0000Ooo.addAll(O000000o2.values());
            }
        }
        return this.O0000Ooo;
    }

    private void O0000o0() {
        this.O00000oo = new anr();
        if (this.O00000o0 != null) {
            Class<?> cls = this.O00000oO;
            if (cls != null) {
                O000000o(this.O00000oo, this.f12482O000000o, cls);
            }
            O000000o(this.O00000oo, this.f12482O000000o.getDeclaredAnnotations());
            for (Class next : this.O00000Oo) {
                O000000o(this.O00000oo, next);
                O000000o(this.O00000oo, next.getDeclaredAnnotations());
            }
            O000000o(this.O00000oo, Object.class);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, boolean):_m_j.ank
     arg types: [java.lang.reflect.Constructor<?>, int]
     candidates:
      _m_j.anj.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, _m_j.anl>):java.util.Map<java.lang.String, _m_j.anl>
      _m_j.anj.O000000o(_m_j.anm, java.lang.annotation.Annotation[]):void
      _m_j.anj.O000000o(_m_j.anr, java.lang.Class<?>):void
      _m_j.anj.O000000o(_m_j.anr, java.lang.annotation.Annotation[]):void
      _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann):void
      _m_j.anj.O000000o(java.lang.String, java.lang.Class<?>[]):_m_j.ann
      _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, boolean):_m_j.ank */
    private void O0000o0O() {
        Constructor<?>[] declaredConstructors = this.f12482O000000o.getDeclaredConstructors();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (Constructor<?> constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == 0) {
                this.O0000OOo = O000000o(constructor, true);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(Math.max(10, declaredConstructors.length));
                }
                arrayList2.add(O000000o(constructor, false));
            }
        }
        if (arrayList2 == null) {
            this.O0000Oo0 = Collections.emptyList();
        } else {
            this.O0000Oo0 = arrayList2;
        }
        if (this.O00000oO != null && (this.O0000OOo != null || !this.O0000Oo0.isEmpty())) {
            O00000o0(this.O00000oO);
        }
        AnnotationIntrospector annotationIntrospector = this.O00000o0;
        if (annotationIntrospector != null) {
            ank ank = this.O0000OOo;
            if (ank != null && annotationIntrospector.O00000o0((anm) ank)) {
                this.O0000OOo = null;
            }
            List<ank> list = this.O0000Oo0;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else if (this.O00000o0.O00000o0((anm) this.O0000Oo0.get(size))) {
                        this.O0000Oo0.remove(size);
                    }
                }
            }
        }
        for (Method method : this.f12482O000000o.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length > 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList(8);
                }
                arrayList.add(O00000Oo(method));
            }
        }
        if (arrayList == null) {
            this.O0000Oo = Collections.emptyList();
        } else {
            this.O0000Oo = arrayList;
            Class<?> cls = this.O00000oO;
            if (cls != null) {
                O00000o(cls);
            }
            if (this.O00000o0 != null) {
                int size2 = this.O0000Oo.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else if (this.O00000o0.O00000o0((anm) this.O0000Oo.get(size2))) {
                        this.O0000Oo.remove(size2);
                    }
                }
            }
        }
        this.O0000O0o = true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void
     arg types: [java.lang.reflect.Method, _m_j.ann, int]
     candidates:
      _m_j.anj.O000000o(java.lang.Class<?>, com.fasterxml.jackson.databind.AnnotationIntrospector, _m_j.anv$O000000o):_m_j.anj
      _m_j.anj.O000000o(_m_j.anr, java.lang.Class<?>, java.lang.Class<?>):void
      _m_j.anj.O000000o(java.lang.Class<?>, java.lang.Class<?>, java.util.Map<java.lang.String, _m_j.anl>):void
      _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, _m_j.ank, boolean):void
      _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void */
    private void O0000o0o() {
        Class<?> O00000oo2;
        this.O0000OoO = new ano();
        ano ano = new ano();
        O000000o(this.f12482O000000o, this.O0000OoO, this.O00000oO, ano);
        for (Class next : this.O00000Oo) {
            anv.O000000o o000000o = this.O00000o;
            O000000o(next, this.O0000OoO, o000000o == null ? null : o000000o.O00000oo(next), ano);
        }
        anv.O000000o o000000o2 = this.O00000o;
        if (!(o000000o2 == null || (O00000oo2 = o000000o2.O00000oo(Object.class)) == null)) {
            O00000Oo(this.f12482O000000o, this.O0000OoO, O00000oo2, ano);
        }
        if (this.O00000o0 != null && !ano.O000000o()) {
            Iterator<ann> it = ano.iterator();
            while (it.hasNext()) {
                ann next2 = it.next();
                try {
                    Method declaredMethod = Object.class.getDeclaredMethod(next2.O00000Oo(), next2.O0000o00());
                    if (declaredMethod != null) {
                        ann O000000o2 = O000000o(declaredMethod);
                        O000000o(next2.O00000oo(), O000000o2, false);
                        this.O0000OoO.O000000o(O000000o2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void O000000o(anr anr, Class<?> cls) {
        anv.O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            O000000o(anr, cls, o000000o.O00000oo(cls));
        }
    }

    private void O000000o(anr anr, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            O000000o(anr, cls2.getDeclaredAnnotations());
            for (Class<?> declaredAnnotations : asw.O000000o(cls2, cls)) {
                O000000o(anr, declaredAnnotations.getDeclaredAnnotations());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, _m_j.ank, boolean):void
     arg types: [java.lang.reflect.Constructor<?>, _m_j.ank, int]
     candidates:
      _m_j.anj.O000000o(java.lang.Class<?>, com.fasterxml.jackson.databind.AnnotationIntrospector, _m_j.anv$O000000o):_m_j.anj
      _m_j.anj.O000000o(_m_j.anr, java.lang.Class<?>, java.lang.Class<?>):void
      _m_j.anj.O000000o(java.lang.Class<?>, java.lang.Class<?>, java.util.Map<java.lang.String, _m_j.anl>):void
      _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void
      _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, _m_j.ank, boolean):void */
    private void O00000o0(Class<?> cls) {
        List<ank> list = this.O0000Oo0;
        int size = list == null ? 0 : list.size();
        anx[] anxArr = null;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                ank ank = this.O0000OOo;
                if (ank != null) {
                    O000000o(constructor, ank, false);
                }
            } else {
                if (anxArr == null) {
                    anxArr = new anx[size];
                    for (int i = 0; i < size; i++) {
                        anxArr[i] = new anx(this.O0000Oo0.get(i).O00000oo());
                    }
                }
                anx anx = new anx(constructor);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (anx.equals(anxArr[i2])) {
                        O000000o(constructor, this.O0000Oo0.get(i2), true);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void
     arg types: [java.lang.reflect.Method, _m_j.ann, int]
     candidates:
      _m_j.anj.O000000o(java.lang.Class<?>, com.fasterxml.jackson.databind.AnnotationIntrospector, _m_j.anv$O000000o):_m_j.anj
      _m_j.anj.O000000o(_m_j.anr, java.lang.Class<?>, java.lang.Class<?>):void
      _m_j.anj.O000000o(java.lang.Class<?>, java.lang.Class<?>, java.util.Map<java.lang.String, _m_j.anl>):void
      _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, _m_j.ank, boolean):void
      _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void */
    private void O00000o(Class<?> cls) {
        int size = this.O0000Oo.size();
        anx[] anxArr = null;
        for (Method method : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length != 0) {
                if (anxArr == null) {
                    anxArr = new anx[size];
                    for (int i = 0; i < size; i++) {
                        anxArr[i] = new anx(this.O0000Oo.get(i).O00000oo());
                    }
                }
                anx anx = new anx(method);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (anx.equals(anxArr[i2])) {
                        O000000o(method, this.O0000Oo.get(i2), true);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void
     arg types: [java.lang.reflect.Method, _m_j.ann, int]
     candidates:
      _m_j.anj.O000000o(java.lang.Class<?>, com.fasterxml.jackson.databind.AnnotationIntrospector, _m_j.anv$O000000o):_m_j.anj
      _m_j.anj.O000000o(_m_j.anr, java.lang.Class<?>, java.lang.Class<?>):void
      _m_j.anj.O000000o(java.lang.Class<?>, java.lang.Class<?>, java.util.Map<java.lang.String, _m_j.anl>):void
      _m_j.anj.O000000o(java.lang.reflect.Constructor<?>, _m_j.ank, boolean):void
      _m_j.anj.O000000o(java.lang.reflect.Method, _m_j.ann, boolean):void */
    private void O000000o(Class<?> cls, ano ano, Class<?> cls2, ano ano2) {
        if (cls2 != null) {
            O00000Oo(cls, ano, cls2, ano2);
        }
        if (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (O00000o0(method)) {
                    ann O00000Oo2 = ano.O00000Oo(method);
                    if (O00000Oo2 == null) {
                        ann O000000o2 = O000000o(method);
                        ano.O000000o(O000000o2);
                        ann O000000o3 = ano2.O000000o(method);
                        if (O000000o3 != null) {
                            O000000o(O000000o3.O00000oo(), O000000o2, false);
                        }
                    } else {
                        O000000o(method, O00000Oo2);
                        if (O00000Oo2.O0000Oo().isInterface() && !method.getDeclaringClass().isInterface()) {
                            ano.O000000o(O00000Oo2.O000000o(method));
                        }
                    }
                }
            }
        }
    }

    private void O00000Oo(Class<?> cls, ano ano, Class<?> cls2, ano ano2) {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(cls2);
        asw.O000000o(cls2, cls, arrayList);
        for (Class declaredMethods : arrayList) {
            for (Method method : declaredMethods.getDeclaredMethods()) {
                if (O00000o0(method)) {
                    ann O00000Oo2 = ano.O00000Oo(method);
                    if (O00000Oo2 != null) {
                        O000000o(method, O00000Oo2);
                    } else {
                        ano2.O000000o(O000000o(method));
                    }
                }
            }
        }
    }

    private Map<String, anl> O000000o(Class<?> cls, Map<String, anl> map) {
        Class<?> O00000oo2;
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            map = O000000o(superclass, map);
            for (Field field : cls.getDeclaredFields()) {
                if (O00000Oo(field)) {
                    if (map == null) {
                        map = new LinkedHashMap<>();
                    }
                    map.put(field.getName(), O000000o(field));
                }
            }
            anv.O000000o o000000o = this.O00000o;
            if (!(o000000o == null || (O00000oo2 = o000000o.O00000oo(cls)) == null)) {
                O000000o(superclass, O00000oo2, map);
            }
        }
        return map;
    }

    private void O000000o(Class<?> cls, Class<?> cls2, Map<String, anl> map) {
        anl anl;
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(cls2);
        asw.O000000o(cls2, cls, arrayList);
        for (Class declaredFields : arrayList) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (O00000Oo(field) && (anl = map.get(field.getName())) != null) {
                    O00000Oo(anl, field.getDeclaredAnnotations());
                }
            }
        }
    }

    private ann O000000o(Method method) {
        if (this.O00000o0 == null) {
            return new ann(method, new anr(), null);
        }
        return new ann(method, O000000o(method.getDeclaredAnnotations()), null);
    }

    private ank O000000o(Constructor<?> constructor, boolean z) {
        anr[] anrArr;
        Annotation[][] annotationArr;
        if (this.O00000o0 == null) {
            return new ank(constructor, new anr(), O000000o(constructor.getParameterTypes().length));
        }
        if (z) {
            return new ank(constructor, O000000o(constructor.getDeclaredAnnotations()), null);
        }
        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
        int length = constructor.getParameterTypes().length;
        if (length != parameterAnnotations.length) {
            Class<?> declaringClass = constructor.getDeclaringClass();
            if (declaringClass.isEnum() && length == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[(parameterAnnotations.length + 2)][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                anrArr = O000000o(annotationArr);
            } else if (!declaringClass.isMemberClass() || length != parameterAnnotations.length + 1) {
                annotationArr = parameterAnnotations;
                anrArr = null;
            } else {
                annotationArr = new Annotation[(parameterAnnotations.length + 1)][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                anrArr = O000000o(annotationArr);
            }
            if (anrArr == null) {
                throw new IllegalStateException("Internal error: constructor for " + constructor.getDeclaringClass().getName() + " has mismatch: " + length + " parameters; " + annotationArr.length + " sets of annotations");
            }
        } else {
            anrArr = O000000o(parameterAnnotations);
        }
        return new ank(constructor, O000000o(constructor.getDeclaredAnnotations()), anrArr);
    }

    private ann O00000Oo(Method method) {
        if (this.O00000o0 == null) {
            return new ann(method, new anr(), O000000o(method.getParameterTypes().length));
        }
        return new ann(method, O000000o(method.getDeclaredAnnotations()), O000000o(method.getParameterAnnotations()));
    }

    private anl O000000o(Field field) {
        if (this.O00000o0 == null) {
            return new anl(field, new anr());
        }
        return new anl(field, O000000o(field.getDeclaredAnnotations()));
    }

    private static anr[] O000000o(int i) {
        if (i == 0) {
            return O0000o00;
        }
        anr[] anrArr = new anr[i];
        for (int i2 = 0; i2 < i; i2++) {
            anrArr[i2] = new anr();
        }
        return anrArr;
    }

    private static boolean O00000o0(Method method) {
        if (!Modifier.isStatic(method.getModifiers()) && !method.isSynthetic() && !method.isBridge() && method.getParameterTypes().length <= 2) {
            return true;
        }
        return false;
    }

    private static boolean O00000Oo(Field field) {
        if (field.isSynthetic()) {
            return false;
        }
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
            return false;
        }
        return true;
    }

    private anr[] O000000o(Annotation[][] annotationArr) {
        int length = annotationArr.length;
        anr[] anrArr = new anr[length];
        for (int i = 0; i < length; i++) {
            anrArr[i] = O000000o(annotationArr[i]);
        }
        return anrArr;
    }

    private anr O000000o(Annotation[] annotationArr) {
        anr anr = new anr();
        O000000o(anr, annotationArr);
        return anr;
    }

    private void O000000o(anr anr, Annotation[] annotationArr) {
        if (annotationArr != null) {
            LinkedList<Annotation[]> linkedList = null;
            for (Annotation annotation : annotationArr) {
                if (O000000o(annotation)) {
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    anr.O000000o(annotation);
                }
            }
            if (linkedList != null) {
                for (Annotation[] O000000o2 : linkedList) {
                    O000000o(anr, O000000o2);
                }
            }
        }
    }

    private void O000000o(anm anm, Annotation[] annotationArr) {
        if (annotationArr != null) {
            LinkedList<Annotation[]> linkedList = null;
            for (Annotation annotation : annotationArr) {
                if (O000000o(annotation)) {
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    anm.O00000Oo(annotation);
                }
            }
            if (linkedList != null) {
                for (Annotation[] O000000o2 : linkedList) {
                    O000000o(anm, O000000o2);
                }
            }
        }
    }

    private void O00000Oo(anm anm, Annotation[] annotationArr) {
        if (annotationArr != null) {
            LinkedList<Annotation[]> linkedList = null;
            for (Annotation annotation : annotationArr) {
                if (O000000o(annotation)) {
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    anm.O000000o(annotation);
                }
            }
            if (linkedList != null) {
                for (Annotation[] O00000Oo2 : linkedList) {
                    O00000Oo(anm, O00000Oo2);
                }
            }
        }
    }

    private void O000000o(Constructor<?> constructor, ank ank, boolean z) {
        O00000Oo(ank, constructor.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation O000000o2 : parameterAnnotations[i]) {
                    ank.O000000o(i, O000000o2);
                }
            }
        }
    }

    private void O000000o(Method method, ann ann, boolean z) {
        O00000Oo(ann, method.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation O000000o2 : parameterAnnotations[i]) {
                    ann.O000000o(i, O000000o2);
                }
            }
        }
    }

    private void O000000o(Method method, ann ann) {
        O000000o(ann, method.getDeclaredAnnotations());
    }

    private final boolean O000000o(Annotation annotation) {
        AnnotationIntrospector annotationIntrospector = this.O00000o0;
        return annotationIntrospector != null && annotationIntrospector.O000000o(annotation);
    }

    public final String toString() {
        return "[AnnotedClass " + this.f12482O000000o.getName() + "]";
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement O000000o() {
        return this.f12482O000000o;
    }
}
