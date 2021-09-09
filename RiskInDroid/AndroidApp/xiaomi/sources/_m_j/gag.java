package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

public final class gag {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
     arg types: [com.facebook.react.bridge.ReadableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double */
    public static List<md> O000000o(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            arrayList.add(new md((float) fyf.O000000o(map, "x", 0.0d), (float) fyf.O000000o(map, "y", 0.0d), (float) fyf.O000000o(map, "pressure", 0.0d), fyf.O000000o(map, "state", 0)));
        }
        return arrayList;
    }
}
