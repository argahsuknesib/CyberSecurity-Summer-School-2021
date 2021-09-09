package _m_j;

import _m_j.ajw;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class alg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ConcurrentHashMap<ajv, ajw<Object>> f12432O000000o = new ConcurrentHashMap<>(64, 0.75f, 2);
    protected final HashMap<ajv, ajw<Object>> O00000Oo = new HashMap<>(8);

    public final ajw<Object> O000000o(ajt ajt, alh alh, ajv ajv) throws JsonMappingException {
        ajw<Object> O000000o2 = O000000o(ajv);
        if (O000000o2 != null) {
            return O000000o2;
        }
        ajw<Object> O00000Oo2 = O00000Oo(ajt, alh, ajv);
        if (O00000Oo2 != null) {
            return O00000Oo2;
        }
        if (!((ajv.O00000Oo().getModifiers() & 1536) == 0)) {
            throw new JsonMappingException("Can not find a Value deserializer for abstract type ".concat(String.valueOf(ajv)));
        }
        throw new JsonMappingException("Can not find a Value deserializer for type ".concat(String.valueOf(ajv)));
    }

    private ajw<Object> O000000o(ajv ajv) {
        if (ajv != null) {
            return this.f12432O000000o.get(ajv);
        }
        throw new IllegalArgumentException("Null JavaType passed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return r4;
     */
    private ajw<Object> O00000Oo(ajt ajt, alh alh, ajv ajv) throws JsonMappingException {
        ajw<Object> ajw;
        synchronized (this.O00000Oo) {
            ajw<Object> O000000o2 = O000000o(ajv);
            if (O000000o2 != null) {
                return O000000o2;
            }
            int size = this.O00000Oo.size();
            if (size > 0 && (ajw = this.O00000Oo.get(ajv)) != null) {
                return ajw;
            }
            try {
                ajw<Object> O00000o0 = O00000o0(ajt, alh, ajv);
                if (size == 0) {
                    if (this.O00000Oo.size() > 0) {
                        this.O00000Oo.clear();
                    }
                }
            } catch (Throwable th) {
                if (size == 0 && this.O00000Oo.size() > 0) {
                    this.O00000Oo.clear();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011b, code lost:
        if (r6 != _m_j.akm.class) goto L_0x011e;
     */
    private static ajv O000000o(ajt ajt, ani ani, ajv ajv) throws JsonMappingException {
        Object O0000o0;
        Class<akm> cls;
        Object O0000o00;
        aka O00000o0;
        AnnotationIntrospector O00000Oo2 = ajt.O00000Oo();
        Class<?> O0000o0O = O00000Oo2.O0000o0O(ani);
        ajw<Object> ajw = null;
        if (O0000o0O != null) {
            try {
                ajv = ajv.O000000o(O0000o0O);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException("Failed to narrow type " + ajv + " with concrete-type annotation (value " + O0000o0O.getName() + "), method '" + ani.O00000Oo() + "': " + e.getMessage(), null, e);
            }
        }
        if (!ajv.O0000OoO()) {
            return ajv;
        }
        Class<?> O0000o0o = O00000Oo2.O0000o0o(ani);
        if (O0000o0o != null) {
            if (ajv instanceof asl) {
                try {
                    ajv = ((asl) ajv).O0000O0o(O0000o0o);
                } catch (IllegalArgumentException e2) {
                    throw new JsonMappingException("Failed to narrow key type " + ajv + " with key-type annotation (" + O0000o0o.getName() + "): " + e2.getMessage(), null, e2);
                }
            } else {
                throw new JsonMappingException("Illegal key-type annotation: type " + ajv + " is not a Map(-like) type");
            }
        }
        ajv O0000o0O2 = ajv.O0000o0O();
        if (!(O0000o0O2 == null || O0000o0O2.O0000oO0() != null || (O0000o00 = O00000Oo2.O0000o00(ani)) == null || (O00000o0 = ajt.O00000o0(O0000o00)) == null)) {
            ajv = ((asl) ajv).O0000Oo0(O00000o0);
        }
        Class<?> O0000o = O00000Oo2.O0000o(ani);
        if (O0000o != null) {
            try {
                ajv = ajv.O00000oO(O0000o);
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException("Failed to narrow content type " + ajv + " with content-type annotation (" + O0000o.getName() + "): " + e3.getMessage(), null, e3);
            }
        }
        if (ajv.O0000o0o().O0000oO0() != null || (O0000o0 = O00000Oo2.O0000o0(ani)) == null) {
            return ajv;
        }
        Class<ajw.O000000o> cls2 = ajw.O000000o.class;
        if (O0000o0 != null) {
            if (O0000o0 instanceof Class) {
                cls = (Class) O0000o0;
                if (cls != cls2) {
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector." + "findContentDeserializer" + "() returned value of type " + O0000o0.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
            }
        }
        cls = null;
        if (cls != null) {
            ajw = ajt.O00000Oo((Object) cls);
        }
        if (ajw != null) {
            return ajv.O00000o(ajw);
        }
        return ajv;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[Catch:{ IllegalArgumentException -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ IllegalArgumentException -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A[Catch:{ IllegalArgumentException -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ IllegalArgumentException -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bf  */
    private ajw<Object> O00000o0(ajt ajt, alh alh, ajv ajv) throws JsonMappingException {
        ajv ajv2;
        Object O0000Ooo;
        ajw<?> ajw;
        try {
            ajs O000000o2 = ajt.O000000o();
            if (!ajv.O00000o0() && !ajv.O0000o00()) {
                if (!ajv.O0000Ooo()) {
                    ajv2 = ajv;
                    ajq O00000Oo2 = O000000o2.O00000Oo(ajv2);
                    O0000Ooo = ajt.O00000Oo().O0000Ooo(O00000Oo2.O00000o0());
                    if (O0000Ooo != null) {
                        ajw = null;
                    } else {
                        ajw = ajt.O00000Oo(O0000Ooo);
                    }
                    if (ajw != null) {
                        ajv O000000o3 = O000000o(ajt, O00000Oo2.O00000o0(), ajv2);
                        if (O000000o3 != ajv2) {
                            O00000Oo2 = O000000o2.O00000Oo(O000000o3);
                            ajv2 = O000000o3;
                        }
                        Class<?> O0000oO0 = O00000Oo2.O0000oO0();
                        if (O0000oO0 != null) {
                            ajw = alh.O000000o(ajt, ajv2, O0000oO0);
                        } else if (ajv2.O0000O0o()) {
                            ajw = alh.O000000o(ajt, ajv2, O00000Oo2);
                        } else {
                            if (ajv2.O0000OoO()) {
                                if (ajv2.O00000oo()) {
                                    ajw = alh.O000000o(ajt, (asg) ajv2, O00000Oo2);
                                } else if (ajv2.O0000o00()) {
                                    asl asl = (asl) ajv2;
                                    if (asl.O0000oOo()) {
                                        ajw = alh.O000000o(ajt, (asm) asl, O00000Oo2);
                                    } else {
                                        ajw = alh.O000000o(ajt, asl, O00000Oo2);
                                    }
                                } else if (ajv2.O0000Ooo()) {
                                    asi asi = (asi) ajv2;
                                    if (asi.O0000oOo()) {
                                        ajw = alh.O000000o(ajt, (asj) asi, O00000Oo2);
                                    } else {
                                        ajw = alh.O000000o(ajt, asi, O00000Oo2);
                                    }
                                }
                            }
                            if (ajx.class.isAssignableFrom(ajv2.O00000Oo())) {
                                ajw = alh.O000000o(O000000o2, ajv2, O00000Oo2);
                            } else {
                                ajw = alh.O00000Oo(ajt, ajv2, O00000Oo2);
                            }
                        }
                    }
                    if (ajw != null) {
                        return null;
                    }
                    boolean z = ajw instanceof alk;
                    boolean O00000o0 = ajw.O00000o0();
                    if (z) {
                        this.O00000Oo.put(ajv, ajw);
                        ((alk) ajw).O000000o(ajt);
                        this.O00000Oo.remove(ajv);
                    }
                    if (O00000o0) {
                        this.f12432O000000o.put(ajv, ajw);
                    }
                    return ajw;
                }
            }
            ajv2 = alh.O000000o(O000000o2, ajv);
            ajq O00000Oo22 = O000000o2.O00000Oo(ajv2);
            O0000Ooo = ajt.O00000Oo().O0000Ooo(O00000Oo22.O00000o0());
            if (O0000Ooo != null) {
            }
            if (ajw != null) {
            }
            if (ajw != null) {
            }
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }
}
