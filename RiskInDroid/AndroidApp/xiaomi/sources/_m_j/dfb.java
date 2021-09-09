package _m_j;

import com.facebook.react.bridge.ReadableMap;

public final class dfb extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14571O000000o;
    private final int O00000Oo;
    private final int[] O00000o;
    private final int[] O00000o0;

    public dfb(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.O00000Oo = readableMap.getInt("what");
        this.O00000o = dex.O000000o(readableMap.getArray("params"));
        this.O00000o0 = dex.O000000o(readableMap.getArray("args"));
    }

    private void O000000o() {
        int i = 0;
        while (true) {
            int[] iArr = this.O00000o;
            if (i < iArr.length) {
                ((dfn) this.mNodesManager.O000000o(iArr[i], dfn.class)).f14580O000000o.pop();
                i++;
            } else {
                this.mNodesManager.O0000o00.O00000Oo = this.f14571O000000o;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        this.f14571O000000o = this.mNodesManager.O0000o00.O00000Oo;
        dew dew = this.mNodesManager.O0000o00;
        dew.O00000Oo = this.mNodesManager.O0000o00.O00000Oo + '/' + String.valueOf(this.mNodeID);
        int i = 0;
        while (true) {
            int[] iArr = this.O00000o;
            if (i < iArr.length) {
                dfn dfn = (dfn) this.mNodesManager.O000000o(iArr[i], dfn.class);
                Integer valueOf = Integer.valueOf(this.O00000o0[i]);
                dfn.O00000Oo = this.f14571O000000o;
                dfn.f14580O000000o.push(valueOf);
                i++;
            } else {
                Object value = this.mNodesManager.O000000o(this.O00000Oo, dfk.class).value();
                O000000o();
                return value;
            }
        }
    }
}
