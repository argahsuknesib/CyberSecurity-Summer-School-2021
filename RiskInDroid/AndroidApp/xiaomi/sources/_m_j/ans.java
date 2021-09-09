package _m_j;

import _m_j.aki;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ans extends ajq {
    protected final akr<?> O00000Oo;
    protected final anj O00000o;
    protected final AnnotationIntrospector O00000o0;
    protected asp O00000oO;
    protected final List<anu> O00000oo;
    protected anz O0000O0o;
    protected ann O0000OOo;
    protected Set<String> O0000Oo;
    protected Map<Object, anm> O0000Oo0;
    protected ann O0000OoO;
    protected anm O0000Ooo;

    private ans(akr<?> akr, ajv ajv, anj anj, List<anu> list) {
        super(ajv);
        AnnotationIntrospector annotationIntrospector;
        this.O00000Oo = akr;
        if (akr == null) {
            annotationIntrospector = null;
        } else {
            annotationIntrospector = akr.O000000o();
        }
        this.O00000o0 = annotationIntrospector;
        this.O00000o = anj;
        this.O00000oo = list;
    }

    private ans(aoa aoa) {
        this(aoa.O000000o(), aoa.O00000Oo(), aoa.O00000o0(), aoa.O00000o());
        this.O0000O0o = aoa.O0000Oo();
    }

    public static ans O000000o(aoa aoa) {
        ans ans = new ans(aoa);
        ans.O0000OOo = aoa.O0000OOo();
        ans.O0000Oo = aoa.O0000Oo0();
        ans.O0000Oo0 = aoa.O00000oO();
        ans.O0000OoO = aoa.O00000oo();
        return ans;
    }

    public static ans O00000Oo(aoa aoa) {
        ans ans = new ans(aoa);
        ans.O0000OoO = aoa.O00000oo();
        ans.O0000Ooo = aoa.O0000O0o();
        return ans;
    }

    public static ans O000000o(akr<?> akr, ajv ajv, anj anj) {
        return new ans(akr, ajv, anj, Collections.emptyList());
    }

    public final anj O00000o0() {
        return this.O00000o;
    }

    public final anz O00000o() {
        return this.O0000O0o;
    }

    public final List<anu> O0000OOo() {
        return this.O00000oo;
    }

    public final ann O0000o0o() {
        return this.O0000OoO;
    }

    public final Set<String> O0000Oo() {
        Set<String> set = this.O0000Oo;
        return set == null ? Collections.emptySet() : set;
    }

    public final boolean O00000oO() {
        return this.O00000o.O0000OOo();
    }

    public final ast O0000O0o() {
        return this.O00000o.O0000O0o();
    }

    public final asp O00000oo() {
        if (this.O00000oO == null) {
            this.O00000oO = new asp(this.O00000Oo.O0000o0(), this.f12408O000000o);
        }
        return this.O00000oO;
    }

    public final ajv O000000o(Type type) {
        if (type == null) {
            return null;
        }
        return O00000oo().O000000o(type);
    }

    public final ank O0000o00() {
        return this.O00000o.O0000Oo0();
    }

    public final ann O0000o0O() throws IllegalArgumentException {
        Class<?> O0000o0;
        ann ann = this.O0000OOo;
        if (ann == null || (O0000o0 = ann.O0000o0()) == String.class || O0000o0 == Object.class) {
            return this.O0000OOo;
        }
        throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + this.O0000OOo.O00000Oo() + "(): first argument not of type String or Object, but " + O0000o0.getName());
    }

    public final Map<Object, anm> O0000o() {
        return this.O0000Oo0;
    }

    public final List<ank> O0000OoO() {
        return this.O00000o.O0000Oo();
    }

    public final Object O000000o(boolean z) {
        ank O0000Oo02 = this.O00000o.O0000Oo0();
        if (O0000Oo02 == null) {
            return null;
        }
        if (z) {
            asw.O000000o(O0000Oo02.O0000OoO());
        }
        try {
            return O0000Oo02.O00000oo().newInstance(new Object[0]);
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            } else if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else {
                throw new IllegalArgumentException("Failed to instantiate bean of type " + this.O00000o.O00000oo().getName() + ": (" + e.getClass().getName() + ") " + e.getMessage(), e);
            }
        }
    }

    public final ann O000000o(String str, Class<?>[] clsArr) {
        return this.O00000o.O000000o(str, clsArr);
    }

    public final List<ann> O0000Ooo() {
        List<ann> O0000OoO2 = this.O00000o.O0000OoO();
        if (O0000OoO2.isEmpty()) {
            return O0000OoO2;
        }
        ArrayList arrayList = new ArrayList();
        for (ann next : O0000OoO2) {
            if (O000000o(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final Constructor<?> O000000o(Class<?>... clsArr) {
        for (ank next : this.O00000o.O0000Oo()) {
            if (next.O0000O0o() == 1) {
                Class<?> O0000OOo2 = next.O0000OOo();
                for (int i = 0; i <= 0; i++) {
                    if (clsArr[0] == O0000OOo2) {
                        return next.O00000oo();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final Method O00000Oo(Class<?>... clsArr) {
        for (ann next : this.O00000o.O0000OoO()) {
            if (O000000o(next)) {
                Class<?> O0000o0 = next.O0000o0();
                for (int i = 0; i <= 0; i++) {
                    if (O0000o0.isAssignableFrom(clsArr[0])) {
                        return next.O00000oo();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private boolean O000000o(ann ann) {
        if (!O00000Oo().isAssignableFrom(ann.O0000o0O())) {
            return false;
        }
        if (!this.O00000o0.O0000oO0(ann) && !"valueOf".equals(ann.O00000Oo())) {
            return false;
        }
        return true;
    }

    public final JsonInclude.Include O000000o(JsonInclude.Include include) {
        AnnotationIntrospector annotationIntrospector = this.O00000o0;
        if (annotationIntrospector == null) {
            return include;
        }
        return annotationIntrospector.O000000o(this.O00000o, include);
    }

    public final anm O0000o0() throws IllegalArgumentException {
        anm anm = this.O0000Ooo;
        if (anm != null) {
            if (!Map.class.isAssignableFrom(anm.O00000o())) {
                throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + this.O0000Ooo.O00000Oo() + "(): return type is not instance of java.util.Map");
            }
        }
        return this.O0000Ooo;
    }

    public final Map<String, anm> O0000Oo0() {
        AnnotationIntrospector.ReferenceProperty O000000o2;
        HashMap hashMap = null;
        for (anu O0000Ooo2 : this.O00000oo) {
            anm O0000Ooo3 = O0000Ooo2.O0000Ooo();
            if (!(O0000Ooo3 == null || (O000000o2 = this.O00000o0.O000000o(O0000Ooo3)) == null || !O000000o2.O00000Oo())) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                String str = O000000o2.f3600O000000o;
                if (hashMap.put(str, O0000Ooo3) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + str + "'");
                }
            }
        }
        return hashMap;
    }

    public final Class<?> O0000oO0() {
        AnnotationIntrospector annotationIntrospector = this.O00000o0;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.O0000Oo0(this.O00000o);
    }

    public final aki.O000000o O0000oO() {
        AnnotationIntrospector annotationIntrospector = this.O00000o0;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.O0000Oo(this.O00000o);
    }
}
