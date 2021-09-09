package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dfi extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14577O000000o;

    public dfi(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14577O000000o = readableMap.getInt("what");
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        return this.mNodesManager.O000000o(this.f14577O000000o, dfk.class).value();
    }
}
