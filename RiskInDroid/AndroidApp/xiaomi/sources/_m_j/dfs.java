package _m_j;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public class dfs extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private Object f14588O000000o;

    public dfs(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        if (readableMap == null || !readableMap.hasKey("value")) {
            this.f14588O000000o = null;
            return;
        }
        ReadableType type = readableMap.getType("value");
        if (type == ReadableType.String) {
            this.f14588O000000o = readableMap.getString("value");
        } else if (type == ReadableType.Number) {
            this.f14588O000000o = Double.valueOf(readableMap.getDouble("value"));
        } else if (type == ReadableType.Null) {
            this.f14588O000000o = null;
        } else {
            throw new IllegalStateException("Not supported value type. Must be boolean, number or string");
        }
    }

    public void O000000o(Object obj) {
        this.f14588O000000o = obj;
        forceUpdateMemoizedValue(this.f14588O000000o);
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        return this.f14588O000000o;
    }
}
