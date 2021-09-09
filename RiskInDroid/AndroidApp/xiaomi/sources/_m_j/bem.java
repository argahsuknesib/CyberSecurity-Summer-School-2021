package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class bem implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Class<?> f12907O000000o;
    private final Map<Integer, Enum> O00000Oo = new HashMap();
    private final Map<String, Enum> O00000o0 = new HashMap();

    public final int O000000o() {
        return 2;
    }

    public bem(Class<?> cls) {
        this.f12907O000000o = cls;
        try {
            for (Object obj : (Object[]) cls.getMethod("values", new Class[0]).invoke(null, new Object[0])) {
                Enum enumR = (Enum) obj;
                this.O00000Oo.put(Integer.valueOf(enumR.ordinal()), enumR);
                this.O00000o0.put(enumR.name(), enumR);
            }
        } catch (Exception unused) {
            throw new JSONException("init enum values error, " + cls.getName());
        }
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        try {
            bdp O0000O0o = bdo.O0000O0o();
            if (O0000O0o.O00000o0() == 2) {
                Integer valueOf = Integer.valueOf(O0000O0o.O0000o0O());
                O0000O0o.O000000o(16);
                T t = this.O00000Oo.get(valueOf);
                if (t != null) {
                    return t;
                }
                throw new JSONException("parse enum " + this.f12907O000000o.getName() + " error, value : " + valueOf);
            } else if (O0000O0o.O00000o0() == 4) {
                String O0000oO0 = O0000O0o.O0000oO0();
                O0000O0o.O000000o(16);
                if (O0000oO0.length() == 0) {
                    return null;
                }
                this.O00000o0.get(O0000oO0);
                return Enum.valueOf(this.f12907O000000o, O0000oO0);
            } else if (O0000O0o.O00000o0() == 8) {
                O0000O0o.O000000o(16);
                return null;
            } else {
                Object O000000o2 = bdo.O000000o((Object) null);
                throw new JSONException("parse enum " + this.f12907O000000o.getName() + " error, value : " + O000000o2);
            }
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }
}
