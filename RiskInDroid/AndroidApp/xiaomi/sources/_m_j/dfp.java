package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dfp extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14583O000000o;
    private int O00000Oo;

    public dfp(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14583O000000o = readableMap.getInt("what");
        this.O00000Oo = readableMap.getInt("value");
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        Object O000000o2 = this.mNodesManager.O000000o(this.O00000Oo);
        ((dfs) this.mNodesManager.O000000o(this.f14583O000000o, dfs.class)).O000000o(O000000o2);
        return O000000o2;
    }
}
