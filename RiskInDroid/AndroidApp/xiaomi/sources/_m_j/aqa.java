package _m_j;

import _m_j.ajz;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

public abstract class aqa extends akf {
    protected IdentityHashMap<Object, aqx> O0000o0O;
    protected ArrayList<aig<?>> O0000o0o;

    public abstract aqa O000000o(ake ake, aqf aqf);

    protected aqa() {
    }

    protected aqa(akf akf, ake ake, aqf aqf) {
        super(akf, ake, aqf);
    }

    public final void O000000o(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException {
        ajz<Object> ajz;
        boolean z = false;
        if (obj == null) {
            ajz = O0000Oo0();
        } else {
            ajz = O00000Oo(obj.getClass(), (ajr) null);
            String O0000oO = this.O00000o.O0000oO();
            if (O0000oO == null) {
                z = this.O00000o.O000000o(SerializationFeature.WRAP_ROOT_VALUE);
                if (z) {
                    jsonGenerator.O00000o();
                    jsonGenerator.O000000o((ain) this.O0000OOo.O000000o(obj.getClass(), this.O00000o));
                }
            } else if (O0000oO.length() != 0) {
                z = true;
                jsonGenerator.O00000o();
                jsonGenerator.O000000o(O0000oO);
            }
        }
        try {
            ajz.O000000o(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.O00000oO();
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "[no message for " + e2.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, e2);
        }
    }

    public final aig<?> O000000o(anz anz) throws JsonMappingException {
        aig aig;
        Class<? extends aig<?>> O00000o0 = anz.O00000o0();
        if (this.O00000o.O0000Ooo() != null) {
            aig = null;
        } else {
            aig = (aig) asw.O000000o(O00000o0, this.O00000o.O0000OOo());
        }
        return aig.O000000o(anz.O00000Oo());
    }

    public final aqx O000000o(Object obj, aig<?> aig) {
        IdentityHashMap<Object, aqx> identityHashMap = this.O0000o0O;
        if (identityHashMap == null) {
            this.O0000o0O = new IdentityHashMap<>();
        } else {
            aqx aqx = identityHashMap.get(obj);
            if (aqx != null) {
                return aqx;
            }
        }
        aig<?> aig2 = null;
        ArrayList<aig<?>> arrayList = this.O0000o0o;
        if (arrayList != null) {
            int i = 0;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                aig<?> aig3 = this.O0000o0o.get(i);
                if (aig3.O000000o(aig)) {
                    aig2 = aig3;
                    break;
                }
                i++;
            }
        } else {
            this.O0000o0o = new ArrayList<>(8);
        }
        if (aig2 == null) {
            aig2 = aig.O00000Oo();
            this.O0000o0o.add(aig2);
        }
        aqx aqx2 = new aqx(aig2);
        this.O0000o0O.put(obj, aqx2);
        return aqx2;
    }

    public final ajz<Object> O000000o(Object obj) throws JsonMappingException {
        ajz<?> ajz;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ajz) {
            ajz = (ajz) obj;
        } else if (obj instanceof Class) {
            Class<akm> cls = (Class) obj;
            if (cls == ajz.O000000o.class || cls == akm.class) {
                return null;
            }
            if (ajz.class.isAssignableFrom(cls)) {
                akq O0000Ooo = this.O00000o.O0000Ooo();
                if (O0000Ooo != null) {
                    ajz = O0000Ooo.O00000o0();
                } else {
                    ajz = (ajz) asw.O000000o(cls, this.O00000o.O0000OOo());
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        if (ajz instanceof aqd) {
            ((aqd) ajz).O000000o(this);
        }
        return ajz;
    }

    public static final class O000000o extends aqa {
        public O000000o() {
        }

        private O000000o(akf akf, ake ake, aqf aqf) {
            super(akf, ake, aqf);
        }

        public final /* synthetic */ aqa O000000o(ake ake, aqf aqf) {
            return new O000000o(this, ake, aqf);
        }
    }
}
