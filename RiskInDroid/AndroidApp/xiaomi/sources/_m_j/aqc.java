package _m_j;

import _m_j.asx;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.reflect.Array;

public final class aqc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ake f12519O000000o;
    protected final ajq O00000Oo;
    protected final AnnotationIntrospector O00000o = this.f12519O000000o.O000000o();
    protected final JsonInclude.Include O00000o0;
    protected Object O00000oO;

    public aqc(ake ake, ajq ajq) {
        this.f12519O000000o = ake;
        this.O00000Oo = ajq;
        this.O00000o0 = ajq.O000000o(ake.O00000Oo());
    }

    public final ast O000000o() {
        return this.O00000Oo.O0000O0o();
    }

    /* renamed from: _m_j.aqc$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12520O000000o = new int[JsonInclude.Include.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f12520O000000o[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;
            f12520O000000o[JsonInclude.Include.NON_EMPTY.ordinal()] = 2;
            f12520O000000o[JsonInclude.Include.NON_NULL.ordinal()] = 3;
            try {
                f12520O000000o[JsonInclude.Include.ALWAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    private static Object O000000o(Exception exc, String str, Object obj) {
        Throwable th;
        while (true) {
            Throwable cause = th.getCause();
            th = exc;
            if (cause == null) {
                break;
            }
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    public final apt O000000o(anu anu, ajv ajv, ajz<?> ajz, aoi aoi, aoi aoi2, anm anm, boolean z) {
        boolean z2;
        ajv ajv2;
        ajv ajv3;
        asx.AnonymousClass1 r10;
        boolean z3;
        Object O000000o2;
        JsonSerialize.Typing O0000OoO;
        ajv ajv4 = ajv;
        aoi aoi3 = aoi2;
        anm anm2 = anm;
        Class<?> O0000OOo = this.O00000o.O0000OOo(anm2);
        boolean z4 = true;
        if (O0000OOo != null) {
            Class<?> O00000Oo2 = ajv.O00000Oo();
            if (O0000OOo.isAssignableFrom(O00000Oo2)) {
                ajv2 = ajv.O00000o0(O0000OOo);
            } else if (O00000Oo2.isAssignableFrom(O0000OOo)) {
                ajv2 = this.f12519O000000o.O000000o(ajv, O0000OOo);
            } else {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + anm.O00000Oo() + "': class " + O0000OOo.getName() + " not a super-type of (declared) class " + O00000Oo2.getName());
            }
            z2 = true;
        } else {
            z2 = z;
            ajv2 = ajv4;
        }
        ajv O00000Oo3 = apw.O00000Oo(this.f12519O000000o, anm2, ajv2);
        if (O00000Oo3 != ajv2) {
            ajv2 = O00000Oo3;
            z2 = true;
        }
        if (!z2 && (O0000OoO = this.O00000o.O0000OoO(anm2)) != null) {
            z2 = O0000OoO == JsonSerialize.Typing.STATIC;
        }
        if (!z2) {
            ajv2 = null;
        }
        if (aoi3 != null) {
            if (ajv2 == null) {
                ajv2 = ajv4;
            }
            if (ajv2.O0000o0o() != null) {
                ajv3 = ajv2.O00000Oo(aoi3);
            } else {
                throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + anu.O000000o() + "' (of type " + this.O00000Oo.O000000o() + "); serialization type " + ajv2 + " has no content");
            }
        } else {
            ajv3 = ajv2;
        }
        JsonInclude.Include O000000o3 = this.O00000o.O000000o(anm2, this.O00000o0);
        if (O000000o3 != null) {
            int i = AnonymousClass1.f12520O000000o[O000000o3.ordinal()];
            if (i == 1) {
                O000000o2 = O000000o(anu.O000000o(), anm2);
                if (O000000o2 != null) {
                    r10 = O000000o2.getClass().isArray() ? new Object(O000000o2, Array.getLength(O000000o2)) {
                        /* class _m_j.asx.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Object f12578O000000o;
                        final /* synthetic */ int O00000Oo;

                        {
                            this.f12578O000000o = r1;
                            this.O00000Oo = r2;
                        }

                        public final boolean equals(Object obj) {
                            if (obj == this) {
                                return true;
                            }
                            if (obj == null || obj.getClass() != this.f12578O000000o.getClass() || Array.getLength(obj) != this.O00000Oo) {
                                return false;
                            }
                            for (int i = 0; i < this.O00000Oo; i++) {
                                Object obj2 = Array.get(this.f12578O000000o, i);
                                Object obj3 = Array.get(obj, i);
                                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    } : O000000o2;
                    z3 = false;
                    apt apt = new apt(anu, anm, this.O00000Oo.O0000O0o(), ajv, ajz, aoi, ajv3, z3, r10);
                    atb O00000Oo4 = this.O00000o.O00000Oo(anm2);
                    if (O00000Oo4 == null) {
                    }
                }
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        z4 = false;
                    }
                }
                if (!ajv.O0000OoO() || this.f12519O000000o.O000000o(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS)) {
                    z3 = z4;
                    r10 = null;
                } else {
                    r10 = apt.f12516O000000o;
                    z3 = z4;
                }
                apt apt2 = new apt(anu, anm, this.O00000Oo.O0000O0o(), ajv, ajz, aoi, ajv3, z3, r10);
                atb O00000Oo42 = this.O00000o.O00000Oo(anm2);
                return O00000Oo42 == null ? new aqv(apt2, O00000Oo42) : apt2;
            } else {
                O000000o2 = apt.f12516O000000o;
            }
            r10 = O000000o2;
            z3 = true;
            apt apt22 = new apt(anu, anm, this.O00000Oo.O0000O0o(), ajv, ajz, aoi, ajv3, z3, r10);
            atb O00000Oo422 = this.O00000o.O00000Oo(anm2);
            if (O00000Oo422 == null) {
            }
        }
        r10 = null;
        z3 = false;
        apt apt222 = new apt(anu, anm, this.O00000Oo.O0000O0o(), ajv, ajz, aoi, ajv3, z3, r10);
        atb O00000Oo4222 = this.O00000o.O00000Oo(anm2);
        if (O00000Oo4222 == null) {
        }
    }

    private Object O000000o(String str, anm anm) {
        if (this.O00000oO == null) {
            this.O00000oO = this.O00000Oo.O000000o(this.f12519O000000o.O0000OOo());
            if (this.O00000oO == null) {
                Class<?> O00000oo = this.O00000Oo.O00000o0().O00000oo();
                throw new IllegalArgumentException("Class " + O00000oo.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        Object obj = this.O00000oO;
        try {
            return anm.O00000Oo(obj);
        } catch (Exception e) {
            return O000000o(e, str, obj);
        }
    }
}
