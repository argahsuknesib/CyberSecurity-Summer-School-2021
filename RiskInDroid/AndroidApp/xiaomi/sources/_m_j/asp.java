package _m_j;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public final class asp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ajv f12571O000000o = new asn(Object.class);
    private static final ajv[] O0000O0o = new ajv[0];
    protected final asq O00000Oo;
    protected final Class<?> O00000o;
    protected final ajv O00000o0;
    protected Map<String, ajv> O00000oO;
    protected HashSet<String> O00000oo;
    private final asp O0000OOo;

    public asp(asq asq, Class<?> cls) {
        this(asq, null, cls, null);
    }

    public asp(asq asq, ajv ajv) {
        this(asq, null, ajv.O00000Oo(), ajv);
    }

    public final asp O000000o() {
        return new asp(this.O00000Oo, this, this.O00000o, this.O00000o0);
    }

    private asp(asq asq, asp asp, Class<?> cls, ajv ajv) {
        this.O00000Oo = asq;
        this.O0000OOo = asp;
        this.O00000o = cls;
        this.O00000o0 = ajv;
    }

    public final ajv O000000o(Type type) {
        return this.O00000Oo.O00000Oo(type, this);
    }

    public final ajv O000000o(String str) {
        String str2;
        asp asp = this;
        while (true) {
            if (asp.O00000oO == null) {
                asp.O00000o0();
            }
            ajv ajv = asp.O00000oO.get(str);
            if (ajv != null) {
                return ajv;
            }
            HashSet<String> hashSet = asp.O00000oo;
            if (hashSet != null && hashSet.contains(str)) {
                return f12571O000000o;
            }
            asp asp2 = asp.O0000OOo;
            if (asp2 != null) {
                asp = asp2;
            } else {
                Class<?> cls = asp.O00000o;
                if (cls != null && cls.getEnclosingClass() != null && !Modifier.isStatic(asp.O00000o.getModifiers())) {
                    return f12571O000000o;
                }
                Class<?> cls2 = asp.O00000o;
                if (cls2 == null) {
                    ajv ajv2 = asp.O00000o0;
                    str2 = ajv2 != null ? ajv2.toString() : "UNKNOWN";
                } else {
                    str2 = cls2.getName();
                }
                throw new IllegalArgumentException("Type variable '" + str + "' can not be resolved (with context of class " + str2 + ")");
            }
        }
    }

    public final void O000000o(String str, ajv ajv) {
        Map<String, ajv> map = this.O00000oO;
        if (map == null || map.size() == 0) {
            this.O00000oO = new LinkedHashMap();
        }
        this.O00000oO.put(str, ajv);
    }

    public final ajv[] O00000Oo() {
        if (this.O00000oO == null) {
            O00000o0();
        }
        if (this.O00000oO.size() == 0) {
            return O0000O0o;
        }
        return (ajv[]) this.O00000oO.values().toArray(new ajv[this.O00000oO.size()]);
    }

    private void O00000o0() {
        int O0000o;
        O00000Oo(this.O00000o);
        ajv ajv = this.O00000o0;
        if (ajv != null && (O0000o = ajv.O0000o()) > 0) {
            for (int i = 0; i < O0000o; i++) {
                O000000o(this.O00000o0.O00000Oo(i), this.O00000o0.O000000o(i));
            }
        }
        if (this.O00000oO == null) {
            this.O00000oO = Collections.emptyMap();
        }
    }

    public final void O00000Oo(String str) {
        if (this.O00000oo == null) {
            this.O00000oo = new HashSet<>();
        }
        this.O00000oo.add(str);
    }

    private void O00000Oo(Type type) {
        Class cls;
        if (type != null) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                    Class cls2 = (Class) parameterizedType.getRawType();
                    TypeVariable[] typeParameters = cls2.getTypeParameters();
                    if (typeParameters.length == actualTypeArguments.length) {
                        int length = actualTypeArguments.length;
                        for (int i = 0; i < length; i++) {
                            String name = typeParameters[i].getName();
                            Map<String, ajv> map = this.O00000oO;
                            if (map == null) {
                                this.O00000oO = new LinkedHashMap();
                            } else if (map.containsKey(name)) {
                            }
                            O00000Oo(name);
                            this.O00000oO.put(name, this.O00000Oo.O00000Oo(actualTypeArguments[i], this));
                        }
                    } else {
                        throw new IllegalArgumentException("Strange parametrized type (in class " + cls2.getName() + "): number of type arguments != number of type parameters (" + actualTypeArguments.length + " vs " + typeParameters.length + ")");
                    }
                }
                cls = (Class) parameterizedType.getRawType();
            } else if (type instanceof Class) {
                cls = (Class) type;
                O00000Oo(cls.getDeclaringClass());
                TypeVariable[] typeParameters2 = cls.getTypeParameters();
                if (typeParameters2 != null && typeParameters2.length > 0) {
                    ajv[] ajvArr = null;
                    ajv ajv = this.O00000o0;
                    if (ajv != null && cls.isAssignableFrom(ajv.O00000Oo())) {
                        ajvArr = this.O00000Oo.O00000Oo(this.O00000o0, cls);
                    }
                    for (int i2 = 0; i2 < typeParameters2.length; i2++) {
                        TypeVariable typeVariable = typeParameters2[i2];
                        String name2 = typeVariable.getName();
                        Type type2 = typeVariable.getBounds()[0];
                        if (type2 != null) {
                            Map<String, ajv> map2 = this.O00000oO;
                            if (map2 == null) {
                                this.O00000oO = new LinkedHashMap();
                            } else if (map2.containsKey(name2)) {
                            }
                            O00000Oo(name2);
                            if (ajvArr != null) {
                                this.O00000oO.put(name2, ajvArr[i2]);
                            } else {
                                this.O00000oO.put(name2, this.O00000Oo.O00000Oo(type2, this));
                            }
                        }
                    }
                }
            } else {
                return;
            }
            O00000Oo(cls.getGenericSuperclass());
            for (Type O00000Oo2 : cls.getGenericInterfaces()) {
                O00000Oo(O00000Oo2);
            }
        }
    }

    public final String toString() {
        if (this.O00000oO == null) {
            O00000o0();
        }
        StringBuilder sb = new StringBuilder("[TypeBindings for ");
        ajv ajv = this.O00000o0;
        if (ajv != null) {
            sb.append(ajv.toString());
        } else {
            sb.append(this.O00000o.getName());
        }
        sb.append(": ");
        sb.append(this.O00000oO);
        sb.append("]");
        return sb.toString();
    }
}
