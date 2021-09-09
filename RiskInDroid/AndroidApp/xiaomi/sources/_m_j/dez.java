package _m_j;

import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;

public final class dez extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14568O000000o;
    private final O000000o O00000Oo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected PointF f14569O000000o;
        protected PointF O00000Oo;
        protected PointF O00000o;
        protected PointF O00000o0;
        protected PointF O00000oO;

        private O000000o(PointF pointF, PointF pointF2) {
            this.O00000o0 = new PointF();
            this.O00000o = new PointF();
            this.O00000oO = new PointF();
            this.f14569O000000o = pointF;
            this.O00000Oo = pointF2;
        }

        public O000000o(float f, float f2, float f3, float f4) {
            this(new PointF(f, f2), new PointF(f3, f4));
        }

        public final float O000000o(float f) {
            float f2 = f;
            for (int i = 1; i < 14; i++) {
                this.O00000oO.x = this.f14569O000000o.x * 3.0f;
                this.O00000o.x = ((this.O00000Oo.x - this.f14569O000000o.x) * 3.0f) - this.O00000oO.x;
                this.O00000o0.x = (1.0f - this.O00000oO.x) - this.O00000o.x;
                float f3 = ((this.O00000oO.x + ((this.O00000o.x + (this.O00000o0.x * f2)) * f2)) * f2) - f;
                if (((double) Math.abs(f3)) < 0.001d) {
                    break;
                }
                f2 -= f3 / (this.O00000oO.x + (((this.O00000o.x * 2.0f) + ((this.O00000o0.x * 3.0f) * f2)) * f2));
            }
            this.O00000oO.y = this.f14569O000000o.y * 3.0f;
            this.O00000o.y = ((this.O00000Oo.y - this.f14569O000000o.y) * 3.0f) - this.O00000oO.y;
            this.O00000o0.y = (1.0f - this.O00000oO.y) - this.O00000o.y;
            return f2 * (this.O00000oO.y + ((this.O00000o.y + (this.O00000o0.y * f2)) * f2));
        }
    }

    public dez(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14568O000000o = readableMap.getInt("input");
        this.O00000Oo = new O000000o((float) readableMap.getDouble("mX1"), (float) readableMap.getDouble("mY1"), (float) readableMap.getDouble("mX2"), (float) readableMap.getDouble("mY2"));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object evaluate() {
        return Double.valueOf((double) this.O00000Oo.O000000o(((Double) this.mNodesManager.O000000o(this.f14568O000000o)).floatValue()));
    }
}
