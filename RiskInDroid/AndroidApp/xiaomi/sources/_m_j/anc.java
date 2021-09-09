package _m_j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public final class anc extends aln {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12477O000000o;
    protected final boolean O00000Oo;
    protected anq O00000o;
    protected anq O00000o0;
    protected ale[] O00000oO;
    protected ajv O00000oo;
    protected anq O0000O0o;
    protected ale[] O0000OOo;
    protected anq O0000Oo;
    protected anq O0000Oo0;
    protected anq O0000OoO;
    protected anq O0000Ooo;
    protected anq O0000o00;

    public anc(ajs ajs, ajv ajv) {
        boolean z;
        String str;
        if (ajs == null) {
            z = false;
        } else {
            z = ajs.O00000o0(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        }
        this.O00000Oo = z;
        if (ajv == null) {
            str = "UNKNOWN TYPE";
        } else {
            str = ajv.toString();
        }
        this.f12477O000000o = str;
    }

    public final void O000000o(anq anq, anq anq2, ajv ajv, ale[] aleArr, anq anq3, ale[] aleArr2) {
        this.O00000o0 = anq;
        this.O0000O0o = anq2;
        this.O00000oo = ajv;
        this.O0000OOo = aleArr;
        this.O00000o = anq3;
        this.O00000oO = aleArr2;
    }

    public final void O000000o(anq anq) {
        this.O0000Oo0 = anq;
    }

    public final void O00000Oo(anq anq) {
        this.O0000Oo = anq;
    }

    public final void O00000o0(anq anq) {
        this.O0000OoO = anq;
    }

    public final void O00000o(anq anq) {
        this.O0000Ooo = anq;
    }

    public final void O00000oO(anq anq) {
        this.O0000o00 = anq;
    }

    public final String O000000o() {
        return this.f12477O000000o;
    }

    public final boolean O00000Oo() {
        return this.O0000Oo0 != null;
    }

    public final boolean O00000o0() {
        return this.O0000Oo != null;
    }

    public final boolean O00000o() {
        return this.O0000OoO != null;
    }

    public final boolean O00000oO() {
        return this.O0000Ooo != null;
    }

    public final boolean O00000oo() {
        return this.O0000o00 != null;
    }

    public final boolean O0000O0o() {
        return this.O00000o0 != null;
    }

    public final boolean O0000OOo() {
        return this.O00000oo != null;
    }

    public final boolean O0000Oo0() {
        return this.O00000o != null;
    }

    public final ajv O0000Oo() {
        return this.O00000oo;
    }

    public final alm[] O000000o(ajs ajs) {
        return this.O00000oO;
    }

    public final Object O0000OoO() throws IOException, JsonProcessingException {
        anq anq = this.O00000o0;
        if (anq != null) {
            try {
                return anq.O0000Oo0();
            } catch (ExceptionInInitializerError e) {
                throw O000000o(e);
            } catch (Exception e2) {
                throw O000000o(e2);
            }
        } else {
            throw new IllegalStateException("No default constructor for " + this.f12477O000000o);
        }
    }

    public final Object O000000o(Object[] objArr) throws IOException, JsonProcessingException {
        anq anq = this.O00000o;
        if (anq != null) {
            try {
                return anq.O000000o(objArr);
            } catch (ExceptionInInitializerError e) {
                throw O000000o(e);
            } catch (Exception e2) {
                throw O000000o(e2);
            }
        } else {
            throw new IllegalStateException("No with-args constructor for " + this.f12477O000000o);
        }
    }

    public final Object O000000o(ajt ajt, Object obj) throws IOException, JsonProcessingException {
        anq anq = this.O0000O0o;
        if (anq != null) {
            try {
                if (this.O0000OOo == null) {
                    return anq.O000000o(obj);
                }
                int length = this.O0000OOo.length;
                Object[] objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    ale ale = this.O0000OOo[i];
                    if (ale == null) {
                        objArr[i] = obj;
                    } else {
                        objArr[i] = ajt.O000000o(ale.O00000o0());
                    }
                }
                return this.O0000O0o.O000000o(objArr);
            } catch (ExceptionInInitializerError e) {
                throw O000000o(e);
            } catch (Exception e2) {
                throw O000000o(e2);
            }
        } else {
            throw new IllegalStateException("No delegate constructor for " + this.f12477O000000o);
        }
    }

    public final Object O000000o(ajt ajt, String str) throws IOException, JsonProcessingException {
        anq anq = this.O0000Oo0;
        if (anq != null) {
            try {
                return anq.O000000o(str);
            } catch (Exception e) {
                throw O000000o(e);
            } catch (ExceptionInInitializerError e2) {
                throw O000000o(e2);
            }
        } else {
            if (this.O0000o00 != null) {
                String trim = str.trim();
                if ("true".equals(trim)) {
                    return O000000o(true);
                }
                if ("false".equals(trim)) {
                    return O000000o(false);
                }
            }
            if (this.O00000Oo && str.length() == 0) {
                return null;
            }
            throw new JsonMappingException("Can not instantiate value of type " + this.f12477O000000o + " from JSON String; no single-String constructor/factory method");
        }
    }

    public final Object O000000o(int i) throws IOException, JsonProcessingException {
        try {
            if (this.O0000Oo != null) {
                return this.O0000Oo.O000000o(Integer.valueOf(i));
            }
            if (this.O0000OoO != null) {
                return this.O0000OoO.O000000o(Long.valueOf((long) i));
            }
            throw new JsonMappingException("Can not instantiate value of type " + this.f12477O000000o + " from JSON integral number; no single-int-arg constructor/factory method");
        } catch (Exception e) {
            throw O000000o(e);
        } catch (ExceptionInInitializerError e2) {
            throw O000000o(e2);
        }
    }

    public final Object O000000o(long j) throws IOException, JsonProcessingException {
        try {
            if (this.O0000OoO != null) {
                return this.O0000OoO.O000000o(Long.valueOf(j));
            }
            throw new JsonMappingException("Can not instantiate value of type " + this.f12477O000000o + " from JSON long integral number; no single-long-arg constructor/factory method");
        } catch (Exception e) {
            throw O000000o(e);
        } catch (ExceptionInInitializerError e2) {
            throw O000000o(e2);
        }
    }

    public final Object O000000o(double d) throws IOException, JsonProcessingException {
        try {
            if (this.O0000Ooo != null) {
                return this.O0000Ooo.O000000o(Double.valueOf(d));
            }
            throw new JsonMappingException("Can not instantiate value of type " + this.f12477O000000o + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
        } catch (Exception e) {
            throw O000000o(e);
        } catch (ExceptionInInitializerError e2) {
            throw O000000o(e2);
        }
    }

    public final Object O000000o(boolean z) throws IOException, JsonProcessingException {
        try {
            if (this.O0000o00 != null) {
                return this.O0000o00.O000000o(Boolean.valueOf(z));
            }
            throw new JsonMappingException("Can not instantiate value of type " + this.f12477O000000o + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
        } catch (Exception e) {
            throw O000000o(e);
        } catch (ExceptionInInitializerError e2) {
            throw O000000o(e2);
        }
    }

    public final anq O0000o00() {
        return this.O0000O0o;
    }

    public final anq O0000Ooo() {
        return this.O00000o0;
    }

    private JsonMappingException O000000o(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof JsonMappingException) {
            return (JsonMappingException) th;
        }
        return new JsonMappingException("Instantiation of " + this.f12477O000000o + " value failed: " + th.getMessage(), th);
    }
}
