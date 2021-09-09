package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@akg
public final class arl extends asb<Object> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Method f12547O000000o;
    protected final ajz<Object> O00000Oo;
    protected final boolean O00000o;
    protected final ajr O00000o0;

    public arl(Method method, ajz<Object> ajz) {
        super(Object.class);
        this.f12547O000000o = method;
        this.O00000Oo = ajz;
        this.O00000o0 = null;
        this.O00000o = true;
    }

    private arl(arl arl, ajr ajr, ajz<?> ajz, boolean z) {
        super(Object.class);
        this.f12547O000000o = arl.f12547O000000o;
        this.O00000Oo = ajz;
        this.O00000o0 = ajr;
        this.O00000o = z;
    }

    private arl O000000o(ajr ajr, ajz<?> ajz, boolean z) {
        if (this.O00000o0 == ajr && this.O00000Oo == ajz && z == this.O00000o) {
            return this;
        }
        return new arl(this, ajr, ajz, z);
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        ajz<Object> ajz = this.O00000Oo;
        if (ajz == null) {
            if (akf.O000000o(MapperFeature.USE_STATIC_TYPING) || Modifier.isFinal(this.f12547O000000o.getReturnType().getModifiers())) {
                ajv O000000o2 = akf.O000000o(this.f12547O000000o.getGenericReturnType());
                ajz<Object> O00000Oo2 = akf.O00000Oo(O000000o2, this.O00000o0);
                Class<?> O00000Oo3 = O000000o2.O00000Oo();
                boolean z = false;
                if (!O00000Oo3.isPrimitive() ? O00000Oo3 == String.class || O00000Oo3 == Integer.class || O00000Oo3 == Boolean.class || O00000Oo3 == Double.class : O00000Oo3 == Integer.TYPE || O00000Oo3 == Boolean.TYPE || O00000Oo3 == Double.TYPE) {
                    z = O000000o((ajz<?>) O00000Oo2);
                }
                return O000000o(ajr, O00000Oo2, z);
            }
        } else if (ajz instanceof apz) {
            return O000000o(ajr, ((apz) ajz).O000000o(akf, ajr), this.O00000o);
        }
        return this;
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        try {
            Object invoke = this.f12547O000000o.invoke(obj, new Object[0]);
            if (invoke == null) {
                akf.O000000o(jsonGenerator);
                return;
            }
            ajz<Object> ajz = this.O00000Oo;
            if (ajz == null) {
                ajz = akf.O00000Oo(invoke.getClass(), this.O00000o0);
            }
            ajz.O000000o(invoke, jsonGenerator, akf);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            while ((e instanceof InvocationTargetException) && e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            }
            throw JsonMappingException.wrapWithPath(e, obj, this.f12547O000000o.getName() + "()");
        }
    }

    public final void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        try {
            Object invoke = this.f12547O000000o.invoke(obj, new Object[0]);
            if (invoke == null) {
                akf.O000000o(jsonGenerator);
                return;
            }
            ajz<Object> ajz = this.O00000Oo;
            if (ajz != null) {
                if (this.O00000o) {
                    aoi.O000000o(obj, jsonGenerator);
                }
                ajz.O000000o(invoke, jsonGenerator, akf, aoi);
                if (this.O00000o) {
                    aoi.O00000o(obj, jsonGenerator);
                    return;
                }
                return;
            }
            akf.O00000Oo(invoke.getClass(), this.O00000o0).O000000o(invoke, jsonGenerator, akf);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            while ((e instanceof InvocationTargetException) && e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            }
            throw JsonMappingException.wrapWithPath(e, obj, this.f12547O000000o.getName() + "()");
        }
    }

    public final String toString() {
        return "(@JsonValue serializer for method " + this.f12547O000000o.getDeclaringClass() + "#" + this.f12547O000000o.getName() + ")";
    }
}
