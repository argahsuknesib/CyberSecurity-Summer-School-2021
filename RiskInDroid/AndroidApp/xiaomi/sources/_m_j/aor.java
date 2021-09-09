package _m_j;

import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;

public class aor extends aow {
    public aor(ajv ajv, asq asq) {
        super(ajv, asq);
    }

    public String O000000o(Object obj) {
        return O00000Oo(obj, obj.getClass());
    }

    public final String O000000o(Object obj, Class<?> cls) {
        return O00000Oo(obj, cls);
    }

    public ajv O000000o(String str) {
        if (str.indexOf(60) > 0) {
            return this.O00000o0.O000000o(str);
        }
        try {
            return this.O00000o0.O000000o(this.O00000o, asw.O000000o(str));
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): no such class found");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): " + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.asq.O000000o(java.lang.Class<? extends java.util.Collection>, java.lang.Class<?>):_m_j.asj
     arg types: [java.lang.Class, java.lang.Class<? extends java.lang.Enum<?>>]
     candidates:
      _m_j.asq.O000000o(java.lang.Class<?>, _m_j.ajv[]):_m_j.ajv
      _m_j.asq.O000000o(java.lang.reflect.GenericArrayType, _m_j.asp):_m_j.ajv
      _m_j.asq.O000000o(java.lang.reflect.ParameterizedType, _m_j.asp):_m_j.ajv
      _m_j.asq.O000000o(java.lang.reflect.TypeVariable<?>, _m_j.asp):_m_j.ajv
      _m_j.asq.O000000o(java.lang.reflect.WildcardType, _m_j.asp):_m_j.ajv
      _m_j.asq.O000000o(_m_j.ask, java.lang.Class<?>):_m_j.ask
      _m_j.asq.O000000o(java.lang.reflect.Type, java.lang.Class<?>):_m_j.ask
      _m_j.asq.O000000o(_m_j.ajv, java.lang.Class<?>):_m_j.ajv
      _m_j.asq.O000000o(java.lang.Class<?>, java.util.List<_m_j.ajv>):_m_j.ajv
      _m_j.asq.O000000o(java.lang.reflect.Type, _m_j.asp):_m_j.ajv
      _m_j.asq.O000000o(java.lang.Class<? extends java.util.Collection>, java.lang.Class<?>):_m_j.asj */
    private String O00000Oo(Object obj, Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (!name.startsWith("java.util")) {
            return (name.indexOf(36) < 0 || asw.O00000o0(cls) == null || asw.O00000o0(this.O00000o.O00000Oo()) != null) ? name : this.O00000o.O00000Oo().getName();
        }
        if (obj instanceof EnumSet) {
            return asq.O000000o().O000000o((Class<? extends Collection>) EnumSet.class, (Class<?>) asw.O000000o((EnumSet<?>) ((EnumSet) obj))).O000000o();
        } else if (obj instanceof EnumMap) {
            return asq.O000000o().O000000o(EnumMap.class, asw.O000000o((EnumMap<?, ?>) ((EnumMap) obj)), Object.class).O000000o();
        } else {
            String substring = name.substring(9);
            if ((substring.startsWith(".Arrays$") || substring.startsWith(".Collections$")) && name.indexOf("List") >= 0) {
                return "java.util.ArrayList";
            }
            return name;
        }
    }
}
