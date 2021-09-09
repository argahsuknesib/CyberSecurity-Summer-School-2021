package _m_j;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

public final class csk {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Integer f14304O000000o;
    public final ReadableMap O00000Oo;
    public final Double O00000o;
    public final Double O00000o0;
    public final Double O00000oO;
    public final Integer O00000oo;
    public final List<csk> O0000O0o;
    public final List<csk> O0000OOo;

    private csk(Integer num, ReadableMap readableMap, Double d, Double d2, Double d3, Integer num2, List<csk> list, List<csk> list2) {
        this.f14304O000000o = num;
        this.O00000Oo = readableMap;
        this.O00000o0 = d;
        this.O00000o = d2;
        this.O00000oO = d3;
        this.O00000oo = num2;
        this.O0000O0o = list;
        this.O0000OOo = list2;
    }

    private static List<csk> O000000o(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(O000000o(readableArray.getMap(i)));
        }
        return arrayList;
    }

    public static csk O000000o(ReadableMap readableMap) {
        return new csk(Integer.valueOf(readableMap.getInt("shader")), readableMap.getMap("uniforms"), Double.valueOf(readableMap.getDouble("width")), Double.valueOf(readableMap.getDouble("height")), Double.valueOf(readableMap.getDouble("pixelRatio")), Integer.valueOf(readableMap.getInt("fboId")), O000000o(readableMap.getArray("contextChildren")), O000000o(readableMap.getArray("children")));
    }
}
