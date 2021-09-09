package _m_j;

import _m_j.dev;
import com.facebook.react.bridge.ReadableMap;

public class dfc extends dfk implements dev.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f14572O000000o;

    public dfc(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
    }

    public final void O00000Oo() {
        if (!this.f14572O000000o) {
            this.f14572O000000o = true;
            this.mNodesManager.O000000o(this);
        }
    }

    public final void O000000o() {
        if (this.f14572O000000o) {
            markUpdated();
            this.mNodesManager.O000000o(this);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object evaluate() {
        return Double.valueOf(this.mNodesManager.O0000Ooo);
    }
}
