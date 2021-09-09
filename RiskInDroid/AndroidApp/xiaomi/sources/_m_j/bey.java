package _m_j;

import com.imi.fastjson.JSONArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public final class bey extends ben {
    private final List O00000o;
    private final int O00000o0;
    private final bdo O00000oO;

    public final void O000000o(bdo bdo, Object obj, Type type, Map<String, Object> map) {
    }

    public bey(bdo bdo, List list, int i) {
        super(null, null);
        this.O00000oO = bdo;
        this.O00000o0 = i;
        this.O00000o = list;
    }

    public final void O000000o(Object obj, Object obj2) {
        JSONArray jSONArray;
        Object O00000Oo;
        this.O00000o.set(this.O00000o0, obj2);
        List list = this.O00000o;
        if ((list instanceof JSONArray) && (O00000Oo = (jSONArray = (JSONArray) list).O00000Oo()) != null && Array.getLength(O00000Oo) > this.O00000o0) {
            if (jSONArray.O00000o0() != null) {
                obj2 = bih.O000000o(obj2, jSONArray.O00000o0(), this.O00000oO.O00000o0());
            }
            Array.set(O00000Oo, this.O00000o0, obj2);
        }
    }
}
