package _m_j;

import com.facebook.react.bridge.ReadableMap;

public abstract class dfd extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14573O000000o;

    /* access modifiers changed from: protected */
    public abstract Double O000000o(dfc dfc);

    public static class O000000o extends dfd {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object evaluate() {
            return dfd.super.evaluate();
        }

        public O000000o(int i, ReadableMap readableMap, dev dev) {
            super(i, readableMap, dev);
        }

        /* access modifiers changed from: protected */
        public final Double O000000o(dfc dfc) {
            dfc.O00000Oo();
            return ZERO;
        }
    }

    public static class O00000Oo extends dfd {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object evaluate() {
            return dfd.super.evaluate();
        }

        public O00000Oo(int i, ReadableMap readableMap, dev dev) {
            super(i, readableMap, dev);
        }

        /* access modifiers changed from: protected */
        public final Double O000000o(dfc dfc) {
            dfc.f14572O000000o = false;
            return ZERO;
        }
    }

    public static class O00000o0 extends dfd {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object evaluate() {
            return dfd.super.evaluate();
        }

        public O00000o0(int i, ReadableMap readableMap, dev dev) {
            super(i, readableMap, dev);
        }

        /* access modifiers changed from: protected */
        public final Double O000000o(dfc dfc) {
            return Double.valueOf(dfc.f14572O000000o ? 1.0d : 0.0d);
        }
    }

    public dfd(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14573O000000o = readableMap.getInt("clock");
    }

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public final Double evaluate() {
        return O000000o((dfc) this.mNodesManager.O000000o(this.f14573O000000o, dfc.class));
    }
}
