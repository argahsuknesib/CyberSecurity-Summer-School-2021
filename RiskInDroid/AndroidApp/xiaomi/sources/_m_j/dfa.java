package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dfa extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f14570O000000o;

    public dfa(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14570O000000o = dex.O000000o(readableMap.getArray("block"));
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        Object obj = null;
        for (int O000000o2 : this.f14570O000000o) {
            obj = this.mNodesManager.O000000o(O000000o2, dfk.class).value();
        }
        return obj;
    }
}
