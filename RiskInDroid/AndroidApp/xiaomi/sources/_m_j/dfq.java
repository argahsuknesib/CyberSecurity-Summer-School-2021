package _m_j;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import java.util.Map;

public final class dfq extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<String, Integer> f14584O000000o;

    public dfq(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14584O000000o = dex.O000000o(readableMap.getMap("style"));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object evaluate() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (Map.Entry next : this.f14584O000000o.entrySet()) {
            dfk O000000o2 = this.mNodesManager.O000000o(((Integer) next.getValue()).intValue(), dfk.class);
            if (O000000o2 instanceof dfr) {
                javaOnlyMap.putArray((String) next.getKey(), (WritableArray) O000000o2.value());
            } else {
                Object value = O000000o2.value();
                if (value instanceof Double) {
                    javaOnlyMap.putDouble((String) next.getKey(), ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    javaOnlyMap.putString((String) next.getKey(), (String) value);
                } else {
                    throw new IllegalStateException("Wrong style form");
                }
            }
        }
        return javaOnlyMap;
    }
}
