package _m_j;

import com.imi.fastjson.JSONObject;
import java.lang.reflect.Type;
import java.util.Map;

public final class bev implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bev f12915O000000o = new bev();

    public final int O000000o() {
        return 12;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
     arg types: [T, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object */
    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T jSONObject = new JSONObject();
        bdo.O000000o((Map) jSONObject, (Object) null);
        return jSONObject;
    }
}
