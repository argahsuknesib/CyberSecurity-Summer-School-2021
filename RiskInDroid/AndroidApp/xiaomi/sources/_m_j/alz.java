package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class alz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final aln f12448O000000o;
    protected final HashMap<String, alm> O00000Oo = new HashMap<>();
    protected final Object[] O00000o;
    protected final int O00000o0;
    protected final alm[] O00000oO;

    private alz(aln aln, alm[] almArr, Object[] objArr) {
        this.f12448O000000o = aln;
        int length = almArr.length;
        this.O00000o0 = length;
        alm[] almArr2 = null;
        for (int i = 0; i < length; i++) {
            alm alm = almArr[i];
            this.O00000Oo.put(alm.O00000o(), alm);
            if (alm.O00000o0() != null) {
                almArr2 = almArr2 == null ? new alm[length] : almArr2;
                almArr2[i] = alm;
            }
        }
        this.O00000o = objArr;
        this.O00000oO = almArr2;
    }

    public static alz O000000o(ajt ajt, aln aln, alm[] almArr) throws JsonMappingException {
        Object obj;
        char c;
        int length = almArr.length;
        alm[] almArr2 = new alm[length];
        Object[] objArr = null;
        for (int i = 0; i < length; i++) {
            alm alm = almArr[i];
            if (!alm.O00000oo()) {
                alm = alm.O00000Oo(ajt.O000000o(alm.O000000o(), alm));
            }
            almArr2[i] = alm;
            ajw<Object> O0000OOo = alm.O0000OOo();
            if (O0000OOo == null) {
                obj = null;
            } else {
                obj = O0000OOo.O000000o();
            }
            if (obj == null && alm.O000000o().O0000Oo0()) {
                Class<?> O00000Oo2 = alm.O000000o().O00000Oo();
                if (O00000Oo2 == Integer.TYPE) {
                    c = 0;
                } else if (O00000Oo2 == Long.TYPE) {
                    c = 0L;
                } else if (O00000Oo2 == Boolean.TYPE) {
                    c = Boolean.FALSE;
                } else if (O00000Oo2 == Double.TYPE) {
                    c = Double.valueOf(0.0d);
                } else if (O00000Oo2 == Float.TYPE) {
                    c = Float.valueOf(0.0f);
                } else if (O00000Oo2 == Byte.TYPE) {
                    c = (byte) 0;
                } else if (O00000Oo2 == Short.TYPE) {
                    c = (short) 0;
                } else if (O00000Oo2 == Character.TYPE) {
                    c = 0;
                } else {
                    throw new IllegalArgumentException("Class " + O00000Oo2.getName() + " is not a primitive type");
                }
                obj = c;
            }
            if (obj != null) {
                if (objArr == null) {
                    objArr = new Object[length];
                }
                objArr[i] = obj;
            }
        }
        return new alz(aln, almArr2, objArr);
    }

    public final Collection<alm> O000000o() {
        return this.O00000Oo.values();
    }

    public final alm O000000o(String str) {
        return this.O00000Oo.get(str);
    }

    public final amc O000000o(JsonParser jsonParser, ajt ajt) {
        amc amc = new amc(jsonParser, ajt, this.O00000o0);
        alm[] almArr = this.O00000oO;
        if (almArr != null) {
            amc.O000000o(almArr);
        }
        return amc;
    }

    public final Object O000000o(amc amc) throws IOException {
        Object O000000o2 = this.f12448O000000o.O000000o(amc.O000000o(this.O00000o));
        for (amb amb = amc.O00000o; amb != null; amb = amb.f12450O000000o) {
            amb.O000000o(O000000o2);
        }
        return O000000o2;
    }
}
