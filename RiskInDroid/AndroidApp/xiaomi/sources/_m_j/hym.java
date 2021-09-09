package _m_j;

import android.graphics.Color;
import com.xiaomi.smarthome.svg.SVG;

public final class hym extends hyn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o f991O000000o = new O000000o((byte) 0);

    public final boolean isStateful() {
        return true;
    }

    public hym(SVG svg) {
        super(svg);
        super.O000000o(this.f991O000000o);
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 16842919) {
                    this.f991O000000o.f992O000000o = 0.6f;
                    invalidateSelf();
                    return true;
                }
            }
        }
        this.f991O000000o.f992O000000o = 1.0f;
        invalidateSelf();
        return true;
    }

    public final hyn O000000o(hyj hyj) {
        this.f991O000000o.O0000OOo = hyj;
        return this;
    }

    static class O000000o extends hyj {

        /* renamed from: O000000o  reason: collision with root package name */
        float f992O000000o;
        public hyj O0000OOo;

        private O000000o() {
            this.f992O000000o = 1.0f;
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final int O000000o(int i) {
            hyj hyj = this.O0000OOo;
            if (hyj != null) {
                i = hyj.O000000o(i);
            }
            return this.f992O000000o != 1.0f ? Color.argb((int) (((float) Color.alpha(i)) * this.f992O000000o), Color.red(i), Color.green(i), Color.blue(i)) : i;
        }
    }
}
