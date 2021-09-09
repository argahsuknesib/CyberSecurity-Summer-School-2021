package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.parser.Feature;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class bdy extends ben {
    private int O00000o;
    private final Type O00000o0;
    private bff O00000oO;

    public final int O000000o() {
        return 14;
    }

    public bdy(Class<?> cls, bid bid) {
        super(cls, bid);
        if (O00000oO() instanceof ParameterizedType) {
            this.O00000o0 = ((ParameterizedType) O00000oO()).getActualTypeArguments()[0];
        } else {
            this.O00000o0 = Object.class;
        }
    }

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
        if (bdo.O0000O0o().O00000o0() == 8) {
            O000000o(obj, (Object) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        bdt O00000o2 = bdo.O00000o();
        bdo.O000000o(O00000o2, obj, this.f12908O000000o.f12989O000000o);
        O000000o(bdo, type, arrayList);
        bdo.O000000o(O00000o2);
        if (obj == null) {
            map.put(this.f12908O000000o.f12989O000000o, arrayList);
        } else {
            O000000o(obj, arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    private void O000000o(bdo bdo, Type type, Collection collection) {
        int i;
        Type type2 = this.O00000o0;
        bff bff = this.O00000oO;
        int i2 = 0;
        if ((type2 instanceof TypeVariable) && (type instanceof ParameterizedType)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = null;
            if (parameterizedType.getRawType() instanceof Class) {
                cls = (Class) parameterizedType.getRawType();
            }
            if (cls != null) {
                int length = cls.getTypeParameters().length;
                i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (cls.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i];
                    if (!type2.equals(this.O00000o0)) {
                        bff = bdo.O00000o0().O000000o(type2);
                    }
                }
            }
            i = -1;
            if (i != -1) {
            }
        }
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() != 14) {
            String str = "exepct '[', but " + bdr.O000000o(O0000O0o.O00000o0());
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new JSONException(str);
        }
        if (bff == null) {
            bff = bdo.O00000o0().O000000o(type2);
            this.O00000oO = bff;
            this.O00000o = this.O00000oO.O000000o();
        }
        O0000O0o.O000000o(this.O00000o);
        while (true) {
            if (O0000O0o.O000000o(Feature.AllowArbitraryCommas)) {
                while (O0000O0o.O00000o0() == 16) {
                    O0000O0o.O000000o();
                }
            }
            if (O0000O0o.O00000o0() != 15) {
                collection.add(bff.O000000o(bdo, type2, Integer.valueOf(i2)));
                bdo.O000000o(collection);
                if (O0000O0o.O00000o0() == 16) {
                    O0000O0o.O000000o(this.O00000o);
                }
                i2++;
            } else {
                O0000O0o.O000000o(16);
                return;
            }
        }
    }
}
