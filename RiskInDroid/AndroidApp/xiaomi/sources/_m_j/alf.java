package _m_j;

import _m_j.aig;
import _m_j.ajw;
import _m_j.aka;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.LinkedHashMap;

public abstract class alf extends ajt {
    protected LinkedHashMap<aig.O000000o, amd> O0000OoO;

    public abstract alf O000000o(ajs ajs, JsonParser jsonParser, aju aju);

    protected alf(alh alh) {
        super(alh, null);
    }

    protected alf(alf alf, ajs ajs, JsonParser jsonParser, aju aju) {
        super(alf, ajs, jsonParser, aju);
    }

    public final amd O000000o(Object obj, aig<?> aig) {
        aig.O000000o O000000o2 = aig.O000000o(obj);
        LinkedHashMap<aig.O000000o, amd> linkedHashMap = this.O0000OoO;
        if (linkedHashMap == null) {
            this.O0000OoO = new LinkedHashMap<>();
        } else {
            amd amd = linkedHashMap.get(O000000o2);
            if (amd != null) {
                return amd;
            }
        }
        amd amd2 = new amd(obj);
        this.O0000OoO.put(O000000o2, amd2);
        return amd2;
    }

    public final aig<?> O000000o(anz anz) throws JsonMappingException {
        aig aig;
        Class<? extends aig<?>> O00000o0 = anz.O00000o0();
        if (this.O00000o0.O0000Ooo() != null) {
            aig = null;
        } else {
            aig = (aig) asw.O000000o(O00000o0, this.O00000o0.O0000OOo());
        }
        return aig.O000000o(anz.O00000Oo());
    }

    public final ajw<Object> O00000Oo(Object obj) throws JsonMappingException {
        ajw<?> ajw;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ajw) {
            ajw = (ajw) obj;
        } else if (obj instanceof Class) {
            Class<akm> cls = (Class) obj;
            if (cls == ajw.O000000o.class || cls == akm.class) {
                return null;
            }
            if (ajw.class.isAssignableFrom(cls)) {
                akq O0000Ooo = this.O00000o0.O0000Ooo();
                if (O0000Ooo != null) {
                    ajw = O0000Ooo.O000000o();
                } else {
                    ajw = (ajw) asw.O000000o(cls, this.O00000o0.O0000OOo());
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
        }
        if (ajw instanceof alk) {
            ((alk) ajw).O000000o(this);
        }
        return ajw;
    }

    public final aka O00000o0(Object obj) throws JsonMappingException {
        aka aka;
        if (obj == null) {
            return null;
        }
        if (obj instanceof aka) {
            aka = (aka) obj;
        } else if (obj instanceof Class) {
            Class<akm> cls = (Class) obj;
            if (cls == aka.O000000o.class || cls == akm.class) {
                return null;
            }
            if (aka.class.isAssignableFrom(cls)) {
                akq O0000Ooo = this.O00000o0.O0000Ooo();
                if (O0000Ooo != null) {
                    aka = O0000Ooo.O00000Oo();
                } else {
                    aka = (aka) asw.O000000o(cls, this.O00000o0.O0000OOo());
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        if (aka instanceof alk) {
            ((alk) aka).O000000o(this);
        }
        return aka;
    }

    public static final class O000000o extends alf {
        public O000000o(alh alh) {
            super(alh);
        }

        private O000000o(O000000o o000000o, ajs ajs, JsonParser jsonParser, aju aju) {
            super(o000000o, ajs, jsonParser, aju);
        }

        public final alf O000000o(ajs ajs, JsonParser jsonParser, aju aju) {
            return new O000000o(this, ajs, jsonParser, aju);
        }
    }
}
