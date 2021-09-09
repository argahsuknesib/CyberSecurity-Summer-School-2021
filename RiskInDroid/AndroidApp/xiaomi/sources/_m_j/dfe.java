package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dfe extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f14574O000000o;

    public dfe(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14574O000000o = dex.O000000o(readableMap.getArray("input"));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object evaluate() {
        StringBuilder sb = new StringBuilder();
        for (int O000000o2 : this.f14574O000000o) {
            sb.append(this.mNodesManager.O000000o(O000000o2, dfk.class).value());
        }
        return sb.toString();
    }
}
