package _m_j;

import _m_j.aqp;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

public class apt implements ajr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f12516O000000o = new Object();
    protected final anm O00000Oo;
    protected final ajv O00000o;
    protected final ast O00000o0;
    protected final Method O00000oO;
    protected final Field O00000oo;
    protected HashMap<Object, Object> O0000O0o;
    protected final aja O0000OOo;
    protected ajz<Object> O0000Oo;
    protected final ajv O0000Oo0;
    protected ajz<Object> O0000OoO;
    protected aqp O0000Ooo;
    protected ajv O0000o;
    protected final Object O0000o0;
    protected final boolean O0000o00;
    protected final Class<?>[] O0000o0O;
    protected aoi O0000o0o;

    public apt(anu anu, anm anm, ast ast, ajv ajv, ajz<?> ajz, aoi aoi, ajv ajv2, boolean z, Object obj) {
        this.O00000Oo = anm;
        this.O00000o0 = ast;
        this.O0000OOo = new aja(anu.O000000o());
        this.O00000o = ajv;
        this.O0000Oo = ajz;
        this.O0000Ooo = ajz == null ? aqp.O000000o() : null;
        this.O0000o0o = aoi;
        this.O0000Oo0 = ajv2;
        if (anm instanceof anl) {
            this.O00000oO = null;
            this.O00000oo = (Field) anm.O0000OoO();
        } else if (anm instanceof ann) {
            this.O00000oO = (Method) anm.O0000OoO();
            this.O00000oo = null;
        } else {
            throw new IllegalArgumentException("Can not pass member of type " + anm.getClass().getName());
        }
        this.O0000o00 = z;
        this.O0000o0 = obj;
        this.O0000o0O = anu.O0000o00();
        this.O0000OoO = null;
    }

    protected apt(apt apt) {
        this(apt, apt.O0000OOo);
    }

    protected apt(apt apt, aja aja) {
        this.O0000OOo = aja;
        this.O00000Oo = apt.O00000Oo;
        this.O00000o0 = apt.O00000o0;
        this.O00000o = apt.O00000o;
        this.O00000oO = apt.O00000oO;
        this.O00000oo = apt.O00000oo;
        this.O0000Oo = apt.O0000Oo;
        this.O0000OoO = apt.O0000OoO;
        HashMap<Object, Object> hashMap = apt.O0000O0o;
        if (hashMap != null) {
            this.O0000O0o = new HashMap<>(hashMap);
        }
        this.O0000Oo0 = apt.O0000Oo0;
        this.O0000Ooo = apt.O0000Ooo;
        this.O0000o00 = apt.O0000o00;
        this.O0000o0 = apt.O0000o0;
        this.O0000o0O = apt.O0000o0O;
        this.O0000o0o = apt.O0000o0o;
        this.O0000o = apt.O0000o;
    }

    public apt O000000o(atb atb) {
        String O000000o2 = atb.O000000o(this.O0000OOo.O000000o());
        if (O000000o2.equals(this.O0000OOo.toString())) {
            return this;
        }
        return new apt(this, new aja(O000000o2));
    }

    public void O000000o(ajz<Object> ajz) {
        ajz<Object> ajz2 = this.O0000Oo;
        if (ajz2 == null || ajz2 == ajz) {
            this.O0000Oo = ajz;
            return;
        }
        throw new IllegalStateException("Can not override serializer");
    }

    public void O00000Oo(ajz<Object> ajz) {
        ajz<Object> ajz2 = this.O0000OoO;
        if (ajz2 == null || ajz2 == ajz) {
            this.O0000OoO = ajz;
            return;
        }
        throw new IllegalStateException("Can not override null serializer");
    }

    public final void O000000o(ajv ajv) {
        this.O0000o = ajv;
    }

    public final String O00000o0() {
        return this.O0000OOo.O000000o();
    }

    public final ajv O000000o() {
        return this.O00000o;
    }

    public final anm O00000Oo() {
        return this.O00000Oo;
    }

    public final boolean O00000o() {
        return this.O0000Oo != null;
    }

    public final boolean O00000oO() {
        return this.O0000OoO != null;
    }

    public final boolean O00000oo() {
        return this.O0000o00;
    }

    public final ajv O0000O0o() {
        return this.O0000Oo0;
    }

    public final Type O0000OOo() {
        Method method = this.O00000oO;
        if (method != null) {
            return method.getGenericReturnType();
        }
        return this.O00000oo.getGenericType();
    }

    public final Class<?>[] O0000Oo0() {
        return this.O0000o0O;
    }

    public void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws Exception {
        Object O000000o2 = O000000o(obj);
        if (O000000o2 != null) {
            ajz<Object> ajz = this.O0000Oo;
            if (ajz == null) {
                Class<?> cls = O000000o2.getClass();
                aqp aqp = this.O0000Ooo;
                ajz<Object> O000000o3 = aqp.O000000o(cls);
                ajz = O000000o3 == null ? O000000o(aqp, cls, akf) : O000000o3;
            }
            Object obj2 = this.O0000o0;
            if (obj2 != null) {
                if (f12516O000000o == obj2) {
                    if (ajz.O000000o(O000000o2)) {
                        return;
                    }
                } else if (obj2.equals(O000000o2)) {
                    return;
                }
            }
            if (O000000o2 == obj) {
                O00000o0(ajz);
            }
            jsonGenerator.O000000o((ain) this.O0000OOo);
            aoi aoi = this.O0000o0o;
            if (aoi == null) {
                ajz.O000000o(O000000o2, jsonGenerator, akf);
            } else {
                ajz.O000000o(O000000o2, jsonGenerator, akf, aoi);
            }
        } else if (this.O0000OoO != null) {
            jsonGenerator.O000000o((ain) this.O0000OOo);
            this.O0000OoO.O000000o(null, jsonGenerator, akf);
        }
    }

    /* access modifiers changed from: protected */
    public ajz<Object> O000000o(aqp aqp, Class<?> cls, akf akf) throws JsonMappingException {
        aqp.O00000o o00000o;
        ajv ajv = this.O0000o;
        if (ajv != null) {
            o00000o = aqp.O000000o(akf.O000000o(ajv, cls), akf, this);
        } else {
            o00000o = aqp.O000000o(cls, akf, this);
        }
        if (aqp != o00000o.O00000Oo) {
            this.O0000Ooo = o00000o.O00000Oo;
        }
        return o00000o.f12530O000000o;
    }

    public final Object O000000o(Object obj) throws Exception {
        Method method = this.O00000oO;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.O00000oo.get(obj);
    }

    protected static void O00000o0(ajz<?> ajz) throws JsonMappingException {
        if (!ajz.O00000o0()) {
            throw new JsonMappingException("Direct self-reference leading to cycle");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this.O0000OOo.O000000o());
        sb.append("' (");
        if (this.O00000oO != null) {
            sb.append("via method ");
            sb.append(this.O00000oO.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.O00000oO.getName());
        } else {
            sb.append("field \"");
            sb.append(this.O00000oo.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.O00000oo.getName());
        }
        if (this.O0000Oo == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type " + this.O0000Oo.getClass().getName());
        }
        sb.append(')');
        return sb.toString();
    }
}
