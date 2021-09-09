package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dff extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14575O000000o;
    private final int O00000Oo;
    private final int O00000o0;

    public dff(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14575O000000o = readableMap.getInt("cond");
        int i2 = -1;
        this.O00000Oo = readableMap.hasKey("ifBlock") ? readableMap.getInt("ifBlock") : -1;
        this.O00000o0 = readableMap.hasKey("elseBlock") ? readableMap.getInt("elseBlock") : i2;
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        Object O000000o2 = this.mNodesManager.O000000o(this.f14575O000000o);
        return (!(O000000o2 instanceof Number) || ((Number) O000000o2).doubleValue() == 0.0d) ? this.O00000o0 != -1 ? this.mNodesManager.O000000o(this.O00000o0) : ZERO : this.O00000Oo != -1 ? this.mNodesManager.O000000o(this.O00000Oo) : ZERO;
    }
}
